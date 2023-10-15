package com.cittapobri.CittaPobri.Empresas;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmpresaRepository extends MongoRepository<EmpresaModel, String>{

    EmpresaModel findEmpresaModelById(String id);
    
}
