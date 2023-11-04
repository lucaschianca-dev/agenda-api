package com.cadastro.apicadastro.services;

import com.cadastro.apicadastro.dtos.AtualizaContatoDTO;
import com.cadastro.apicadastro.dtos.ContatoDTO;
import com.cadastro.apicadastro.dtos.ListarContatoPorPessoaDTO;
import com.cadastro.apicadastro.entities.Contato;
import com.cadastro.apicadastro.erros.excecoesTratadas.NotFoundException;
import com.cadastro.apicadastro.mapper.ContatoMapper;
import com.cadastro.apicadastro.mapper.PessoaMapper;
import com.cadastro.apicadastro.repositories.ContatoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class ContatoService {

    private final ContatoRepository contatoRepository;

    @Transactional
    public ContatoDTO registraContato(Contato contato) {
        Contato novoContato = contatoRepository.save(contato);
        return ContatoMapper.INSTANCE.toContatoDTO(novoContato);
    }

    public List<ListarContatoPorPessoaDTO> buscaContatosPorPessoa(Long id) {
        List<ListarContatoPorPessoaDTO> contatos = contatoRepository.buscarContatosPorId(id).get();

        if (contatos == null || contatos.isEmpty()) {

            throw new NotFoundException("Pessoa não encontrada ou não contém nenhum contato!");
        }

        return contatos;
    }

    public ListarContatoPorPessoaDTO buscaContatoPorId(Long id) {
        Contato contato = contatoRepository
                .findById(id).orElseThrow(() -> new NotFoundException("Contato não encontrado!"));

        return PessoaMapper.INSTANCE.toPessoaDTO(contato);
    }

    @Transactional
    public AtualizaContatoDTO atualizaContato(Long id, AtualizaContatoDTO atualiza) {
        Contato contato = contatoRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Contato não encontrado!"));

        contato.atualizaContato(atualiza);

        return ContatoMapper.INSTANCE.toAtualizaContatoDTO(contato);
    }

    @Transactional
    public void excluiContato(Long id) {
        if (!contatoRepository.existsById(id)) {
            throw new NotFoundException("Contato não encontrado!");
        }
        contatoRepository.deleteById(id);
    }
}
