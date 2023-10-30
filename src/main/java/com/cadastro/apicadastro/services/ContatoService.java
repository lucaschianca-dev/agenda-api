package com.cadastro.apicadastro.services;

import com.cadastro.apicadastro.dtos.ContatoDTO;
import com.cadastro.apicadastro.entities.Contato;
import com.cadastro.apicadastro.mapper.ContatoMapper;
import com.cadastro.apicadastro.repositories.ContatoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class ContatoService {

    private ContatoRepository contatoRepository;

    @Transactional
    public ContatoDTO registraContato(Contato contato) {
        Contato novoContato = contatoRepository.save(contato);
        return ContatoMapper.INSTANCE.toContatoDTO(novoContato);
    }
}
