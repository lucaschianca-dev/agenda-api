package com.cadastro.apicadastro.dtos;

import com.cadastro.apicadastro.enums.TipoContato;
import jakarta.validation.constraints.Pattern;

public record AtualizaContatoDTO(

        @Pattern(regexp = ".{2,30}", message = "O nome precisa ter entre 2 e 30 caracteres")
        String nome,

        TipoContato tipoContato,

        @Pattern(regexp = ".{2,50}", message = "O contato precisa ter entre 2 e 50 caracteres")
        String contato
) {
}
