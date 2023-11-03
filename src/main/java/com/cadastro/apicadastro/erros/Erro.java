package com.cadastro.apicadastro.erros;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Erro {

    private Long timestamp;

    private Integer status;

    private String error;

    private String mensage;

    private String path;
}