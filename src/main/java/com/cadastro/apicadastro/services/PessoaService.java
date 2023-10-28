package com.cadastro.apicadastro.services;

import com.cadastro.apicadastro.dtos.PessoaDTO;
import com.cadastro.apicadastro.entities.Contato;
import com.cadastro.apicadastro.entities.Pessoa;
import com.cadastro.apicadastro.mapper.PessoaMapper;
import com.cadastro.apicadastro.repositories.PessoaRepository;
import com.cadastro.apicadastro.requests.PessoaRegistroRequest;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class PessoaService {

    private PessoaRepository pessoaRepository;

    private static List<Contato> contatos = new ArrayList<>();

    @Transactional
    public PessoaDTO registraPessoa(@Valid PessoaRegistroRequest request) {
        Pessoa pessoa = PessoaMapper.INSTANCE.toPessoa(request);

        for(Contato contato: request.getContatos()){
            contato.setPessoa(pessoa);
            contatos.add(contato);
        }
        pessoa.setContatos(contatos);

        Pessoa pessoaSalva = pessoaRepository.save(pessoa);

        return PessoaMapper.INSTANCE.toPessoaDTO(pessoaSalva);
    }
}