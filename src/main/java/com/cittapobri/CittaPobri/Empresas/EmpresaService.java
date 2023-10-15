package com.cittapobri.CittaPobri.Empresas;

import org.springframework.stereotype.Service;

@Service
public class EmpresaService {

    private final EmpresaRepository empresaRepository;

    public EmpresaService(EmpresaRepository empresaRepository) {
        this.empresaRepository = empresaRepository;
    }

    public void cadastrarEmpresa(EmpresaModel empresa) {
        empresa.setAtivo(true);
        empresaRepository.save(empresa);
    }

    public String nomeEmpresa(String id) {
        var empresa = empresaRepository.findEmpresaModelById(id);
        return empresa.getNome();
    }
    
}
