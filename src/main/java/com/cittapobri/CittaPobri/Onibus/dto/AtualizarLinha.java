package com.cittapobri.CittaPobri.Onibus.dto;

import com.cittapobri.CittaPobri.Empresas.Empresas;

public record AtualizarLinha(String codigo, String nome, double tarifa, Empresas empresa) {
}
