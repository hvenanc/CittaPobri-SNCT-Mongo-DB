package com.cittapobri.CittaPobri.Onibus.dto;

import com.cittapobri.CittaPobri.Empresas.EmpresaModel;
import com.cittapobri.CittaPobri.Onibus.LinhaModel;

public record ExibirLinha(String codigo, String nome, double tarifa, String empresa) {

    public ExibirLinha(LinhaModel linhaModel) {
        this(linhaModel.getCodigo(), linhaModel.getNome(), linhaModel.getTarifa(), linhaModel.getEmpresa_id());
    }

}
