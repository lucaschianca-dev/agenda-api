package com.cadastro.apicadastro.dtos;

public record DataEndereco(
        String uf,

        String cep,

        String cidade,

        String bairro,

        String rua,

        String numero
) {
}
