package com.cadastro.apicadastro.services;

import com.cadastro.apicadastro.dtos.PessoaDTO;
import com.cadastro.apicadastro.entities.Pessoa;
import com.cadastro.apicadastro.mapper.PessoaMapper;
import com.cadastro.apicadastro.repositories.PessoaRepository;
import com.cadastro.apicadastro.requests.PessoaRegistroRequest;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PessoaService {

    private PessoaRepository pessoaRepository;

    public PessoaService(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    @Transactional
    public PessoaDTO registraPessoa(@Valid PessoaRegistroRequest request) {
        Pessoa pessoa = pessoaRepository.save(PessoaMapper.INSTANCE.toPessoa(request));

        return PessoaMapper.INSTANCE.toPessoaDTO(pessoa);
    }
}
