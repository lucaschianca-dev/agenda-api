package com.cadastro.apicadastro.dtos;

import com.cadastro.apicadastro.entities.Contato;
import com.cadastro.apicadastro.enums.TipoContato;

import java.util.List;

public record ListarContatoPorPessoaDTO(
        Long id,

        String nome,

        TipoContato tipoContato,

        String contato
) {
    public ListarContatoPorPessoaDTO(Contato contato) {
        this(
                contato.getId(),
                contato.getNome(),
                contato.getTipoContato(),
                contato.getContato()
        );
    }
}
