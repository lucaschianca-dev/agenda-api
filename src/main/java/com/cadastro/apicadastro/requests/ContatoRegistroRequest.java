package com.cadastro.apicadastro.requests;

import com.cadastro.apicadastro.entities.Pessoa;
import com.cadastro.apicadastro.enums.TipoContato;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContatoRegistroRequest {

    private String nome;

    private TipoContato tipoContato;

    private String contato;

    private Pessoa pessoa;
}
