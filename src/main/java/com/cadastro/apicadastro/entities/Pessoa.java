package com.cadastro.apicadastro.entities;

import com.cadastro.apicadastro.dtos.AtualizaPessoaDTO;
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

    private boolean ativo = true;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;

    @OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL)
    private List<Contato> contatos;

    public void atualizaPessoa(AtualizaPessoaDTO atualiza) {
        if (atualiza.nome() != null)
            this.nome = atualiza.nome();
        if (atualiza.genero() != null)
            this.genero = atualiza.genero();
        if (atualiza.estadoCivil() != null)
            this.estadoCivil = atualiza.estadoCivil();
        if (atualiza.endereco() != null)
            this.endereco = atualiza.endereco();
    }

    public void ativaPessoa() {
        this.ativo = true;
    }

    public void inativaPessoa() {
        this.ativo = false;
    }
}
