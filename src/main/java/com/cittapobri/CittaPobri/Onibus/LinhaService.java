package com.cittapobri.CittaPobri.Onibus;

import com.cittapobri.CittaPobri.Onibus.dto.AtualizarLinha;
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

    public ResponseEntity<AtualizarLinha> editarLinha(AtualizarLinha linha) {
        LinhaModel linhaModel = repository.findAllByCodigo(linha.codigo());
        if(linha.nome() != null && !linha.nome().equals("")) {
            linhaModel.setNome(linha.nome());
        }
        if(linha.tarifa() > 0) {
            linhaModel.setTarifa(linha.tarifa());
        }
        if(linha.empresa() != null) {
            linhaModel.setEmpresa(linha.empresa());
        }
        repository.save(linhaModel);
        return ResponseEntity.noContent().build();
    }
}
