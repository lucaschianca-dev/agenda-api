package com.cadastro.apicadastro.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

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
    @JoinColumn(name = "endereco")
    private Endereco endereco;
}
