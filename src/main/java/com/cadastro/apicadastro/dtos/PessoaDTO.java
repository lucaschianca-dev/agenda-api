package com.cadastro.apicadastro.dtos;

import com.cadastro.apicadastro.entities.Contato;
import com.cadastro.apicadastro.entities.Endereco;
import com.cadastro.apicadastro.entities.Pessoa;
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

    private boolean ativo;

    public PessoaDTO(Pessoa pessoa) {
        this.id = pessoa.getId();
        this.nome = pessoa.getNome();
        this.idade = pessoa.getIdade();
        this.cpf = pessoa.getCpf();
        this.genero = pessoa.getGenero();
        this.estadoCivil = pessoa.getEstadoCivil();
        this.nacionalidade = pessoa.getNacionalidade();
        this.endereco = pessoa.getEndereco();
        this.contatos = pessoa.getContatos();
        this.ativo = pessoa.isAtivo();

    }
}
