package com.cadastro.apicadastro.entities;

import com.cadastro.apicadastro.dtos.AtualizaPessoaDTO;
import com.cadastro.apicadastro.requests.PessoaRegistroRequest;
import com.fasterxml.jackson.annotation.JsonIgnore;
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

    public void atualizaEndereco(AtualizaPessoaDTO atualiza) {
        if (atualiza.endereco().uf != null)
            this.uf = atualiza.endereco().uf;
        if (atualiza.endereco().cep != null)
            this.cep = atualiza.endereco().cep;
        if (atualiza.endereco().cidade != null)
            this.cidade = atualiza.endereco().cidade;
        if (atualiza.endereco().bairro != null)
            this.bairro = atualiza.endereco().bairro;
        if (atualiza.endereco().rua != null)
            this.rua = atualiza.endereco().rua;
        if (atualiza.endereco().numero != null)
            this.numero = atualiza.endereco().numero;
    }
}
