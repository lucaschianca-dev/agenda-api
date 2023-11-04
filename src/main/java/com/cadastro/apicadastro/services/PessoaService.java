package com.cadastro.apicadastro.services;

import com.cadastro.apicadastro.dtos.AtualizaPessoaDTO;
import com.cadastro.apicadastro.dtos.MalaDiretaDTO;
import com.cadastro.apicadastro.dtos.PessoaDTO;
import com.cadastro.apicadastro.entities.Pessoa;
import com.cadastro.apicadastro.erros.excecoesTratadas.NotFoundException;
import com.cadastro.apicadastro.mapper.ContatoMapper;
import com.cadastro.apicadastro.mapper.PessoaMapper;
import com.cadastro.apicadastro.repositories.PessoaRepository;
import com.cadastro.apicadastro.requests.ContatoRegistroRequest;
import com.cadastro.apicadastro.requests.PessoaRegistroRequest;
import com.cadastro.apicadastro.util.extensions.EnderecoExtensions;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@AllArgsConstructor
public class PessoaService {

    private final PessoaRepository pessoaRepository;

    private final ContatoService contatoService;

    @Transactional
    public PessoaDTO registraPessoa(PessoaRegistroRequest request) {
        Pessoa pessoa = PessoaMapper.INSTANCE.toPessoa(request);

        pessoaRepository.save(pessoa);

        return PessoaMapper.INSTANCE.toPessoaDTO(pessoa);
    }

    public Page<PessoaDTO> listaPessoas(Pageable pageable) {
        Page<PessoaDTO> pessoasAtivas = pessoaRepository
                .findAllByAtivoTrue(pageable)
                .map(PessoaMapper.INSTANCE::toPessoaDTO);

        return pessoasAtivas;
    }

    public PessoaDTO buscaPessoaPorId(Long id) {
        Pessoa pessoa = pessoaRepository.findById(id).orElse(null);
        if (pessoa != null) {
            return PessoaMapper.INSTANCE.toPessoaDTO(pessoa);
        } else {
            throw new NotFoundException("Pessoa não encontrada");
        }
    }

    @Transactional
    public PessoaDTO atualizaPessoa(Long id, AtualizaPessoaDTO atualiza) {
        Pessoa pessoa = pessoaRepository.findById(id).orElseThrow(() -> new NotFoundException("Pessoa não encontrada"));
        pessoa.atualizaPessoa(atualiza);

        return PessoaMapper.INSTANCE.toPessoaDTO(pessoa);
    }

    @Transactional
    public PessoaDTO adicionaContato(Long pessoaId, ContatoRegistroRequest request) {
        Pessoa pessoa = pessoaRepository.findById(pessoaId).orElseThrow(() -> new NotFoundException("Pessoa não encontrada"));

        var contato = ContatoMapper.INSTANCE.toContato(request);

        contato.setPessoa(pessoa);
        contatoService.registraContato(contato);
        pessoa.getContatos().add(contato);
        pessoaRepository.save(pessoa);

        return new PessoaDTO(pessoa);
    }

    @Transactional
    public PessoaDTO ativaPessoa(Long id) {
        Pessoa pessoa = pessoaRepository.findById(id).orElseThrow(() -> new NotFoundException("Pessoa não encontrada"));

        pessoa.ativaPessoa();

        return PessoaMapper.INSTANCE.toPessoaDTO(pessoa);

    }

    @Transactional
    public PessoaDTO inativaPessoa(Long id) {
        Pessoa pessoa = pessoaRepository.findById(id).orElseThrow(() -> new NotFoundException("Pessoa não encontrada"));

        pessoa.inativaPessoa();

        return PessoaMapper.INSTANCE.toPessoaDTO(pessoa);
    }

    @Transactional
    public void excluiPessoa(Long id) {
        if (!pessoaRepository.existsById(id)) {
            throw new NotFoundException("Pessoa não encontrada");
        }
        pessoaRepository.deleteById(id);
    }

    public MalaDiretaDTO listaPessoaMalaDireta(Long id) {
        Optional<Pessoa> pessoaOptional = pessoaRepository.findById(id);
        if (pessoaOptional.isEmpty()) {
            throw new NotFoundException("Pessoa não encontrada");
        }

        Pessoa pessoa = pessoaOptional.get();

        String malaDireta = EnderecoExtensions.buildMalaDireta(
                pessoa.getEndereco().getRua(),
                pessoa.getEndereco().getNumero(),
                pessoa.getEndereco().getBairro(),
                pessoa.getEndereco().getCep(),
                pessoa.getEndereco().getCidade(),
                pessoa.getEndereco().getUf()
        );

        return new MalaDiretaDTO(pessoa.getId(), pessoa.getNome(), malaDireta);
    }
}