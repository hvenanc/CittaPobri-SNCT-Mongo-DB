package com.cittapobri.CittaPobri.Empresas;

import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/empresa")
public class EmpresaController {

    private final EmpresaService empresaService;

    public EmpresaController(EmpresaService empresaService) {
        this.empresaService = empresaService;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<EmpresaModel> cadastrarEmpresa(@RequestBody EmpresaModel empresaModel, UriComponentsBuilder uriBuilder) {
        empresaService.cadastrarEmpresa(empresaModel);
        var uri = uriBuilder.path("/empresa/{id}").buildAndExpand(empresaModel.getId()).toUri();
        return ResponseEntity.created(uri).body(empresaModel);
    }
    
}
