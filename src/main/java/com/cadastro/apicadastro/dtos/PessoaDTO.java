package com.cadastro.apicadastro.dtos;

import com.cadastro.apicadastro.entities.Contato;
import com.cadastro.apicadastro.entities.Endereco;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PessoaDTO {

    private Long id;

    private String nome;

    private LocalDate idade;

    private String cpf;

    private String genero;

    private String estadoCivil;

    private String nacionalidade;

    private Endereco endereco;

    private List<Contato> contatos;
}
