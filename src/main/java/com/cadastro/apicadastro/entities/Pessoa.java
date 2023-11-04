package com.cadastro.apicadastro.entities;

import com.cadastro.apicadastro.dtos.AtualizaPessoaDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

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

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private LocalDate dataNascimento;

    @Column(nullable = false, length = 11)
    private String cpf;

    @Column(columnDefinition = "CHAR(1) NOT NULL CHECK (genero IN ('M', 'F'))")
    private String genero;

    @Column(nullable = false)
    @Length(max = 30)
    private String estadoCivil;

    @Column(nullable = false)
    @Length(max = 30)
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
            this.endereco.atualizaEndereco(atualiza.endereco());
    }

    public void ativaPessoa() {
        this.ativo = true;
    }

    public void inativaPessoa() {
        this.ativo = false;
    }
}
