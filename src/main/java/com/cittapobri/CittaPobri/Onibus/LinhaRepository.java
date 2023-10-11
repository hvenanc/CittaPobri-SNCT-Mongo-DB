package com.cittapobri.CittaPobri.Onibus;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface LinhaRepository extends MongoRepository<LinhaModel, String> {

    LinhaModel findAllByCodigo(String codigo);
}
