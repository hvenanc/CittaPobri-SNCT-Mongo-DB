package com.cittapobri.CittaPobri.Onibus;

import com.cittapobri.CittaPobri.Onibus.dto.ExibirLinha;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class LinhaService {

    private final LinhaRepository repository;


    public LinhaService(LinhaRepository repository) {
        this.repository = repository;
    }

    public ResponseEntity<LinhaModel> deletar(String codigo) {
        var linha = repository.findAllByCodigo(codigo);
        if(linha != null) {
            repository.delete(linha);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<ExibirLinha> buscarLinhaPorCodigo(String codigo) {
        var linha = repository.findAllByCodigo(codigo);
        if(linha != null) {
            return ResponseEntity.ok(new ExibirLinha(linha));
        }
        return ResponseEntity.notFound().build();
    }
}
