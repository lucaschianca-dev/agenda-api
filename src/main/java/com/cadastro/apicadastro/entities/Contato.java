package com.cadastro.apicadastro.entities;

import com.cadastro.apicadastro.enums.TipoContato;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "contatos")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Contato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Enumerated(EnumType.ORDINAL)
    private TipoContato tipoContato;

    private String contato;

    @ManyToOne()
    private Pessoa pessoa;
}
