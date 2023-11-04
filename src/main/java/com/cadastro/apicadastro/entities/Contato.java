package com.cadastro.apicadastro.entities;

import com.cadastro.apicadastro.dtos.AtualizaContatoDTO;
import com.cadastro.apicadastro.enums.TipoContato;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "contatos")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Contato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Length(max = 30)
    private String nome;

    @Column(nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private TipoContato tipoContato;

    @Column(nullable = false)
    @Length(max = 50)
    private String contato;

    @ManyToOne()
    @JsonIgnore
    @JoinColumn(name = "pessoa_id")
    @JsonManagedReference
    private Pessoa pessoa;

    public void atualizaContato(AtualizaContatoDTO atualiza) {
        if (atualiza.nome() != null) this.nome = atualiza.nome();
        if (atualiza.tipoContato() != null) this.tipoContato = atualiza.tipoContato();
        if (atualiza.contato() != null) this.contato = atualiza.contato();
    }
}
