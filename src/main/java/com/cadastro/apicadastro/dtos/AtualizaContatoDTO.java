package com.cadastro.apicadastro.dtos;

import com.cadastro.apicadastro.enums.TipoContato;

public record AtualizaContatoDTO(
        String nome,

        TipoContato tipoContato,

        String contato
) {
}
