package com.cadastro.apicadastro.requests;

import com.cadastro.apicadastro.dtos.DataEndereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PessoaRegistroRequest {

    @NotBlank(message = "Nome é obrigatório")
    @Pattern(regexp = ".{2,50}", message = "O nome precisa ter entre 2 e 50 caracteres")
    private String nome;

    @NotNull(message = "Data de nascimento é obrigatório")
    private LocalDate dataNascimento;

    @NotBlank(message = "CPF é obrigatório")
    @Pattern(regexp = "\\d{11}", message = "CPF deve ter 11 dígitos")
    private String cpf;

    @NotBlank(message = "Gênero é obrigatório")
    @Pattern(regexp = "^([M]{1}|[F]{1})$", message = "Gênero deve ser 'M' ou 'F'")
    private String genero;

    @NotBlank(message = "Estado Civil é obrigatório")
    @Pattern(regexp = ".{1,30}", message = "Máximo de caracteres é 30")
    private String estadoCivil;

    @NotBlank(message = "Nacionalidade é obrigatório")
    @Pattern(regexp = ".{1,30}", message = "Máximo de caracteres é 30")
    private String nacionalidade;

    @NotNull(message = "Dados do endereço são obrigatórios")
    @Valid
    private DataEndereco endereco;
}
