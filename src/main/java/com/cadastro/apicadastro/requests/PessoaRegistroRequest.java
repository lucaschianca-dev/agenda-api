package com.cadastro.apicadastro.requests;

import com.cadastro.apicadastro.entities.Contato;
import com.cadastro.apicadastro.entities.Endereco;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PessoaRegistroRequest {

    private String nome;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate idade;

    private String cpf;

    private String genero;

    private String estadoCivil;

    private String nacionalidade;

    private Endereco endereco;

    private List<Contato> contatos;
}
