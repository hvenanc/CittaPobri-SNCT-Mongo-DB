package com.cittapobri.CittaPobri.Onibus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document()
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
}
