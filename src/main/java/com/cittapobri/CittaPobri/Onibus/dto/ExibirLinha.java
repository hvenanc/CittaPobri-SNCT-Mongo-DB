package com.cittapobri.CittaPobri.Onibus.dto;

import com.cittapobri.CittaPobri.Onibus.LinhaModel;

public record ExibirLinha(String codigo, String nome, double tarifa) {

    public ExibirLinha(LinhaModel linhaModel) {
        this(linhaModel.getCodigo(), linhaModel.getNome(), linhaModel.getTarifa());
    }
}
