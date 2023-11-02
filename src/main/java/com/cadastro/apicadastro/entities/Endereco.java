package com.cadastro.apicadastro.entities;

import com.cadastro.apicadastro.dtos.DataEndereco;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

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

    public void atualizaEndereco(DataEndereco atualiza) {
        if (atualiza.uf() != null) this.uf = atualiza.uf();
        if (atualiza.cep() != null) this.cep = atualiza.cep();
        if (atualiza.cidade() != null) this.cidade = atualiza.cidade();
        if (atualiza.bairro() != null) this.bairro = atualiza.bairro();
        if (atualiza.rua() != null) this.rua = atualiza.rua();
        if (atualiza.numero() != null) this.numero = atualiza.numero();
    }
}
