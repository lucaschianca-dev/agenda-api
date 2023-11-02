package com.cadastro.apicadastro.controllers;

import com.cadastro.apicadastro.dtos.AtualizaContatoDTO;
import com.cadastro.apicadastro.dtos.AtualizaPessoaDTO;
import com.cadastro.apicadastro.dtos.ListarContatoPorPessoaDTO;
import com.cadastro.apicadastro.dtos.PessoaDTO;
import com.cadastro.apicadastro.services.ContatoService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/contatos")
@AllArgsConstructor
public class ContatoController {

    private ContatoService contatoService;

    @GetMapping("/{id}")
    public ResponseEntity buscaContatoPorId(@PathVariable Long id) {
        var contato = contatoService.buscaContatoPorId(id);
        return ResponseEntity.ok(contato);
    }

    @PutMapping("/{id}")
    public ResponseEntity atualizaContato(@PathVariable Long id, @RequestBody @Valid AtualizaContatoDTO atualiza) {
        AtualizaContatoDTO contatoDto = contatoService.atualizaContato(id, atualiza);
        if (contatoDto != null) {
            return ResponseEntity.ok(contatoDto);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
}
