package com.cittapobri.CittaPobri.Onibus;

import com.cittapobri.CittaPobri.Onibus.dto.ExibirLinha;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/linha")
public class LinhaController {

    private final LinhaService service;
    private final LinhaRepository repository;

    public LinhaController(LinhaService service, LinhaRepository repository) {
        this.service = service;
        this.repository = repository;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<?> cadastrarLinha(@RequestBody LinhaModel linhaModel, UriComponentsBuilder uriBuilder) {
        var codigoLinha = linhaModel.getCodigo();
        if(repository.findAllByCodigo(codigoLinha) == null) {
            repository.save(linhaModel);
            var uri = uriBuilder.path("/linha/{codigo}").buildAndExpand(linhaModel.getCodigo()).toUri();
            return ResponseEntity.created(uri).body(linhaModel);
        }
        return ResponseEntity.badRequest().body("Linha Já Cadastrada");
    }

    @DeleteMapping("/{codigo}")
    @Transactional
    public ResponseEntity<LinhaModel> deletarLinha(@PathVariable String codigo) {
        return service.deletar(codigo);
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<ExibirLinha> buscarLinha(@PathVariable String codigo) {
        return service.buscarLinhaPorCodigo(codigo);
    }

    @GetMapping
    public ResponseEntity<Page<ExibirLinha>> buscarTodasAsLinhasAtivas(@PageableDefault(sort = "codigo") Pageable page) {
        var linhas = repository.findAll(page).map(ExibirLinha::new);
        return ResponseEntity.ok(linhas);
    }

}
