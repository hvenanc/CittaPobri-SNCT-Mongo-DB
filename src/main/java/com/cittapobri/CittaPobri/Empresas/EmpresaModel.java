package com.cittapobri.CittaPobri.Empresas;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "empresas")
public class EmpresaModel {

    private String id;
    private String cnpj;
    private String nome;
    private String sac;
    private boolean ativo;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCriacao = new Date();
    
}
