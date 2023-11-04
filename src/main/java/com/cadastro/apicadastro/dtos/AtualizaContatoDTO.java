package com.cadastro.apicadastro.dtos;

import com.cadastro.apicadastro.enums.TipoContato;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record AtualizaContatoDTO(

        @NotBlank(message = "Nome é obrigatório")
        @Pattern(regexp = ".{2,50}", message = "O nome precisa ter entre 2 e 50 caracteres")
        String nome,

        TipoContato tipoContato,

        String contato
) {
}
