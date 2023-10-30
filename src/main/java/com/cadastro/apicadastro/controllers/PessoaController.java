package com.cadastro.apicadastro.controllers;

import com.cadastro.apicadastro.dtos.AtualizaPessoaDTO;
import com.cadastro.apicadastro.dtos.PessoaDTO;
import com.cadastro.apicadastro.requests.PessoaRegistroRequest;
import com.cadastro.apicadastro.services.PessoaService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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
    public ResponseEntity listaPessoas(@PageableDefault(size = 5, page = 0, sort = "nome") Pageable pageable) {
        Page<PessoaDTO> pessoasAtivas = pessoaService.listaPessoas(pageable);
        return ResponseEntity.ok(pessoasAtivas);
    }

    @GetMapping("{id}")
    public ResponseEntity buscaPessoaPorId(@PathVariable Long id) {
        var pessoa = pessoaService.buscaPessoaPorId(id);
        return ResponseEntity.ok(pessoa);
    }

    @PutMapping("{id}")
    public ResponseEntity atualizaPessoa(@RequestBody @Valid AtualizaPessoaDTO atualiza) {
        PessoaDTO pessoa = pessoaService.atualizaPessoa(atualiza);
        if (pessoa != null) {
            return ResponseEntity.ok(pessoa);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
}
