package com.cadastro.apicadastro.controllers;

import com.cadastro.apicadastro.dtos.PessoaDTO;
import com.cadastro.apicadastro.requests.PessoaRegistroRequest;
import com.cadastro.apicadastro.services.PessoaService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pessoas")
public class PessoaController {

    private PessoaService pessoaService;

    public PessoaController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @PostMapping
    public ResponseEntity registraPessoa(@RequestBody PessoaRegistroRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(pessoaService.registraPessoa(request));
    }

    @GetMapping
    public ResponseEntity listaPessoas(Pageable pageable) {
        Page<PessoaDTO> pessoasAtivas = pessoaService.listaPessoas(pageable);
        return ResponseEntity.ok(pessoasAtivas);
    }

    @GetMapping("{id}")
    public ResponseEntity buscaPessoaPorId(@PathVariable Long id) {
        var pessoa = pessoaService.buscaPessoaPorId(id);
        return ResponseEntity.ok(pessoa);
    }
}
