package com.cadastro.apicadastro.dtos;

import com.cadastro.apicadastro.entities.Contato;
import com.cadastro.apicadastro.entities.Endereco;

import java.util.List;

public record AtualizaPessoaDTO(
        Long id,

        String nome,

        String genero,

        String estadoCivil,

        Endereco endereco,

        List<Contato> contatos
) {
}
