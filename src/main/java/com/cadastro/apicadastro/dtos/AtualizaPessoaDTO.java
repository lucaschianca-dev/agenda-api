package com.cadastro.apicadastro.dtos;

import com.cadastro.apicadastro.entities.Endereco;

public record AtualizaPessoaDTO(

        String nome,

        String genero,

        String estadoCivil,

        DataEndereco endereco

) {
}
