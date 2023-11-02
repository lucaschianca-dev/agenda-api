package com.cadastro.apicadastro.controllers;

import com.cadastro.apicadastro.services.ContatoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
