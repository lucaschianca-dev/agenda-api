package com.cadastro.apicadastro.dtos;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;

public record AtualizaPessoaDTO(

        @Pattern(regexp = ".{2,50}", message = "O nome precisa ter entre 2 e 50 caracteres")
        String nome,

        @Pattern(regexp = "^([M]{1}|[F]{1})$", message = "Gênero deve ser 'M' ou 'F'")
        String genero,

        @Pattern(regexp = ".{1,30}", message = "Estado civil deve ter no máximo 30 caracteres")
        String estadoCivil,

        @Valid
        DataEndereco endereco

) {
}
