package com.cadastro.apicadastro.requests;

import com.cadastro.apicadastro.enums.TipoContato;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContatoRegistroRequest {

    @NotBlank(message = "Nome é obrigatório")
    @Pattern(regexp = ".{2,30}", message = "O nome precisa ter entre 2 e 30 caracteres")
    private String nome;

    @NotNull(message = "Tipo de contato é obrigatório")
    private TipoContato tipoContato;

    @NotBlank(message = "Contato é obrigatório")
    @Pattern(regexp = ".{2,50}", message = "O nome precisa ter entre 2 e 50 caracteres")
    private String contato;
}
