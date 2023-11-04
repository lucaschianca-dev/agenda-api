package com.cadastro.apicadastro.dtos;

import com.cadastro.apicadastro.entities.Pessoa;
import com.cadastro.apicadastro.enums.TipoContato;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContatoDTO {

    private Long id;

    private String nome;

    private TipoContato tipoContato;

    private String contato;

    private Pessoa pessoa;
}
