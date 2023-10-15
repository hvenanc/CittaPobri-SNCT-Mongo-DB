package com.cittapobri.CittaPobri.Onibus;

import com.cittapobri.CittaPobri.Empresas.Empresas;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "linhas")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LinhaModel {

    @Id
    private String id;
    private String codigo;
    private String nome;
    private double tarifa;
    private String empresa_id;
    private boolean ativo = true;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCriacao = new Date();
}
