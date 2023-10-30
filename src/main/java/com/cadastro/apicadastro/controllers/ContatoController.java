package com.cadastro.apicadastro.controllers;

import com.cadastro.apicadastro.dtos.PessoaDTO;
import com.cadastro.apicadastro.entities.Contato;
import com.cadastro.apicadastro.services.PessoaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pessoas")
public class ContatoController {

    private PessoaService pessoaService;

    public ContatoController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @PostMapping("/{pessoaId}/contatos")
    public ResponseEntity adicionaContato(@PathVariable Long pessoaId, @RequestBody Contato contato) {
        PessoaDTO pessoaDTO = pessoaService.adicionaContato(pessoaId, contato);

        if (pessoaDTO != null) {
            return ResponseEntity.ok(pessoaDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
