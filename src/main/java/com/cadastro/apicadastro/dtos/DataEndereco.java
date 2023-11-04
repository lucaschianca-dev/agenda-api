package com.cadastro.apicadastro.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DataEndereco(

        @NotBlank(message = "UF é obrigatório")
        @Pattern(regexp = ".{2}")
        String uf,

        @NotBlank(message = "CEP é obrigatório")
        @Pattern(regexp = "\\d{8}", message = "CEP deve ter 8 dígitos")
        String cep,

        @NotBlank(message = "Cidade é obrigatório")
        @Pattern(regexp = ".{1,80}", message = "Máximo de caracteres é 80")
        String cidade,

        @NotBlank(message = "Bairro é obrigatório")
        @Pattern(regexp = ".{1,80}", message = "Máximo de caracteres é 80")
        String bairro,

        @NotBlank(message = "Rua é obrigatório")
        @Pattern(regexp = ".{1,100}", message = "Máximo de caracteres é 100")
        String rua,

        @NotBlank(message = "Número é obrigatório")
        @Pattern(regexp = "\\d{1,5}", message = "Número deve conter de 1 a 5 dígitos")
        String numero
) {
}
