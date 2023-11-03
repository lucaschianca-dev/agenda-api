package com.cadastro.apicadastro.util.extensions;

public class EnderecoExtensions {
    public static String buildMalaDireta(String rua, String numero, String bairro, String cep, String cidade, String uf) {
        return String.format("%s - %s - %s - CEP: %s - %s/%s", rua, numero, bairro, cep, cidade, uf);
    }
}
