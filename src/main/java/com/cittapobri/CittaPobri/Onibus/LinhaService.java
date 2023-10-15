package com.cittapobri.CittaPobri.Onibus;

import com.cittapobri.CittaPobri.Empresas.EmpresaRepository;
import com.cittapobri.CittaPobri.Empresas.EmpresaService;
import com.cittapobri.CittaPobri.Onibus.dto.AtualizarLinha;
import com.cittapobri.CittaPobri.Onibus.dto.ExibirLinha;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LinhaService {

    private final LinhaRepository repository;
    private final EmpresaRepository empresaRepository;
    private final EmpresaService empresaService;

    public LinhaService(LinhaRepository repository, EmpresaRepository empresaRepository, EmpresaService empresaService) {
        this.repository = repository;
        this.empresaRepository = empresaRepository;
        this.empresaService = empresaService;
    }

    public ResponseEntity<LinhaModel> deletar(String codigo) {
        var linha = repository.findAllByCodigo(codigo);
        if(linha != null) {
            repository.delete(linha);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    public ExibirLinha buscarLinhaPorCodigo(String codigo) {
        var linha = repository.findAllByCodigo(codigo);
        var empresa = empresaRepository.findEmpresaModelById(linha.getEmpresa_id());
        return new ExibirLinha(linha.getCodigo(), linha.getNome(), linha.getTarifa(), empresa.getNome());
    }

    public ResponseEntity<AtualizarLinha> editarLinha(AtualizarLinha linha) {
        LinhaModel linhaModel = repository.findAllByCodigo(linha.codigo());
        if(linha.nome() != null && !linha.nome().equals("")) {
            linhaModel.setNome(linha.nome());
        }
        if(linha.tarifa() > 0) {
            linhaModel.setTarifa(linha.tarifa());
        }
        repository.save(linhaModel);
        return ResponseEntity.noContent().build();
    }

    public List<ExibirLinha> buscarTodasAsLinhas(Pageable pageable) {
        var linhas = repository.findAllByAtivoTrue(pageable);
        List<ExibirLinha> detalhes = new ArrayList<>();
        for(LinhaModel linhaModel: linhas) {
            detalhes.add(new ExibirLinha(linhaModel.getCodigo(), linhaModel.getNome(),
                    linhaModel.getTarifa(), empresaService.nomeEmpresa(linhaModel.getEmpresa_id())));
        }
        return detalhes;
    }

}
