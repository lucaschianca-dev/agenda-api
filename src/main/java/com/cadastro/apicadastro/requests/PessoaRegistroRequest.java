package com.cadastro.apicadastro.requests;

import com.cadastro.apicadastro.entities.Contato;
import com.cadastro.apicadastro.entities.Endereco;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PessoaRegistroRequest {

    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate idade;

    @NotBlank(message = "CPF é obrigatório")
    private String cpf;

    @NotBlank(message = "Gênero é obrigatório")
    private String genero;

    @NotBlank(message = "Estado Civil é obrigatório")
    private String estadoCivil;

    @NotBlank(message = "Nacionalidade é obrigatório")
    private String nacionalidade;

    @NotNull(message = "Dados do endereço são obrigatórios")
    private Endereco endereco;

    private List<Contato> contatos;
}
