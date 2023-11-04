package com.cadastro.apicadastro.dtos;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record AtualizaPessoaDTO(

        @NotBlank(message = "Nome é obrigatório")
        @Pattern(regexp = ".{2,50}", message = "O nome precisa ter entre 2 e 50 caracteres")
        String nome,

        @NotBlank(message = "Gênero é obrigatório")
        @Pattern(regexp = "^([M]{1}|[F]{1})$", message = "Gênero deve ser 'M' ou 'F'" )
        String genero,

        @NotBlank(message = "Estado Civil é obrigatório")
        @Pattern(regexp = ".{1,30}", message = "Máximo de caracteres é 30")
        String estadoCivil,

        @NotNull(message = "Dados do endereço são obrigatórios")
        @Valid
        DataEndereco endereco

) {
}
