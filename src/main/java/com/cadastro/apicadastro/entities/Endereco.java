package com.cadastro.apicadastro.entities;

import com.cadastro.apicadastro.requests.PessoaRegistroRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "enderecos")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String uf;

    private String cep;

    private String cidade;

    private String bairro;

    private String rua;

    private String numero;

    @OneToMany(mappedBy = "endereco")
    private List<Pessoa> pessoa;
}
