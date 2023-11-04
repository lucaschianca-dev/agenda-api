package com.cadastro.apicadastro.controllers;

import com.cadastro.apicadastro.dtos.AtualizaPessoaDTO;
import com.cadastro.apicadastro.dtos.ListarContatoPorPessoaDTO;
import com.cadastro.apicadastro.dtos.MalaDiretaDTO;
import com.cadastro.apicadastro.dtos.PessoaDTO;
import com.cadastro.apicadastro.entities.Contato;
import com.cadastro.apicadastro.requests.PessoaRegistroRequest;
import com.cadastro.apicadastro.services.ContatoService;
import com.cadastro.apicadastro.services.PessoaService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pessoas")
@AllArgsConstructor
public class PessoaController {

    private final PessoaService pessoaService;

    private final ContatoService contatoService;

    @Operation(summary = "Registrar uma pessoa")
    @PostMapping
    public ResponseEntity<PessoaDTO> registraPessoa(@RequestBody @Valid PessoaRegistroRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(pessoaService.registraPessoa(request));
    }

    @Operation(summary = "Listar todas as pessoas com registro ativo")
    @GetMapping
    public ResponseEntity<Page<PessoaDTO>> listaPessoas(
            @PageableDefault(size = 5, page = 0, sort = "nome")
            @RequestParam(required = false) Pageable pageable
    ) {
        return ResponseEntity.ok(pessoaService.listaPessoas(pageable));
    }

    @Operation(summary = "Carregar dados de uma pessoa por ID")
    @GetMapping("/{id}")
    public ResponseEntity<PessoaDTO> buscaPessoaPorId(@PathVariable Long id) {
        return ResponseEntity.ok(pessoaService.buscaPessoaPorId(id));
    }

    @Operation(summary = "Listar todos os contatos de uma pessoa(ID)")
    @GetMapping("/{id}/contatos")
    public ResponseEntity<List<ListarContatoPorPessoaDTO>> buscaContatosPorPessoa(@PathVariable Long id) {
        return ResponseEntity.ok(contatoService.buscaContatosPorPessoa(id));
    }

    @Operation(summary = "Atualizar dados de uma pessoa por ID")
    @PutMapping("/{id}")
    public ResponseEntity<PessoaDTO> atualizaPessoa(@PathVariable Long id, @RequestBody @Valid AtualizaPessoaDTO atualiza) {
        PessoaDTO pessoa = pessoaService.atualizaPessoa(id, atualiza);
        if (pessoa != null) {
            return ResponseEntity.ok(pessoa);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @Operation(summary = "Adicionar um contato à uma pessoa(ID)")
    @PostMapping("/{pessoaId}/contatos")
    public ResponseEntity<PessoaDTO> adicionaContato(@PathVariable Long pessoaId, @RequestBody Contato contato) {
        return ResponseEntity.ok(pessoaService.adicionaContato(pessoaId, contato));
    }

    @Operation(summary = "Ativar o registro de uma pessoa inativa por ID")
    @PutMapping("/ativa/{id}")
    public ResponseEntity<PessoaDTO> ativaPessoa(@PathVariable Long id) {
        return ResponseEntity.ok(pessoaService.ativaPessoa(id));
    }

    @Operation(summary = "Inativar o registro de uma pessoa por ID")
    @DeleteMapping("/inativa/{id}")
    public ResponseEntity<Void> inativaPessoa(@PathVariable Long id) {
        pessoaService.inativaPessoa(id);

        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Excluir uma pessoa do banco de dados por ID")
    @DeleteMapping("{id}")
    public ResponseEntity<Void> excluiPessoa(@PathVariable Long id) {
        pessoaService.excluiPessoa(id);

        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Listar pessoa em mala direta por ID")
    @GetMapping("/maladireta/{id}")
    public ResponseEntity<MalaDiretaDTO> listaPessoaMalaDireta(@PathVariable Long id) {
        return ResponseEntity.ok(pessoaService.listaPessoaMalaDireta(id));
    }
}
