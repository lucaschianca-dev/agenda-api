package com.cadastro.apicadastro.dtos;

public record AtualizaPessoaDTO(

        String nome,

        String genero,

        String estadoCivil,

        DataEndereco endereco

) {
}
