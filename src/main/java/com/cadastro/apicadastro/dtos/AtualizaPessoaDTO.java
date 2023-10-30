package com.cadastro.apicadastro.dtos;

import com.cadastro.apicadastro.entities.Endereco;

public record AtualizaPessoaDTO(
        Long id,

        String nome,

        String genero,

        String estadoCivil,

        Endereco endereco

) {
}
