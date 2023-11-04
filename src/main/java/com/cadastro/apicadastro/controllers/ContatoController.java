package com.cadastro.apicadastro.controllers;

import com.cadastro.apicadastro.dtos.AtualizaContatoDTO;
import com.cadastro.apicadastro.dtos.ListarContatoPorPessoaDTO;
import com.cadastro.apicadastro.services.ContatoService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/contatos")
@AllArgsConstructor
public class ContatoController {

    private final ContatoService contatoService;

    @Operation(summary = "Carregar dados de um contato pelo ID")
    @GetMapping("/{id}")
    public ResponseEntity<ListarContatoPorPessoaDTO> buscaContatoPorId(@PathVariable Long id) {
        var contato = contatoService.buscaContatoPorId(id);
        return ResponseEntity.ok(contato);
    }

    @Operation(summary = "Atualizar dados de um contato por ID")
    @PutMapping("/{id}")
    public ResponseEntity<AtualizaContatoDTO> atualizaContato(@PathVariable Long id, @RequestBody @Valid AtualizaContatoDTO atualiza) {
        AtualizaContatoDTO contatoDto = contatoService.atualizaContato(id, atualiza);
        if (contatoDto != null) {
            return ResponseEntity.ok(contatoDto);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @Operation(summary = "Excluir um contato do banco de dados por ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluiContato(@PathVariable Long id) {
        contatoService.excluiContato(id);

        return ResponseEntity.noContent().build();
    }
}
