package com.cadastro.apicadastro.entities;

import com.cadastro.apicadastro.requests.PessoaRegistroRequest;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "pessoas")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private LocalDate idade;

    private String cpf;

    private String genero;

    private String estadoCivil;

    private String nacionalidade;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id")
    @JsonIgnore
    private Endereco endereco;

    @OneToMany(mappedBy = "pessoa")
    @JsonIgnore
    private List<Contato> contatos;
}
