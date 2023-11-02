package com.cadastro.apicadastro.services;

import com.cadastro.apicadastro.dtos.*;
import com.cadastro.apicadastro.entities.Contato;
import com.cadastro.apicadastro.entities.Pessoa;
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

    private ContatoRepository contatoRepository;

    @Transactional
    public ContatoDTO registraContato(Contato contato) {
        Contato novoContato = contatoRepository.save(contato);
        return ContatoMapper.INSTANCE.toContatoDTO(novoContato);
    }

    public List<ListarContatoPorPessoaDTO> buscaContatosPorPessoa(Long id) {
        List<ListarContatoPorPessoaDTO> contatos = contatoRepository.buscarContatosPorId(id).orElse(null);
        if (contatos != null) {
            return contatos;
        } else {
            return null; // LEMBRAR DE LANÇAR EXCEÇÃO
        }
    }

    public ListarContatoPorPessoaDTO buscaContatoPorId(Long id) {
        Contato contato = contatoRepository.findById(id).orElse(null);
        if (contato != null) {
            return PessoaMapper.INSTANCE.toPessoaDTO(contato);
        } else {
            return null; // LEMBRAR DE LANÇAR EXCEÇÃO
        }
    }

    @Transactional
    public AtualizaContatoDTO atualizaContato(Long id, AtualizaContatoDTO atualiza) {
        Contato contato = contatoRepository.findById(id).orElseThrow();
        contato.atualizaContato(atualiza);

        return ContatoMapper.INSTANCE.toAtualizaContatoDTO(contato);
    }
}
