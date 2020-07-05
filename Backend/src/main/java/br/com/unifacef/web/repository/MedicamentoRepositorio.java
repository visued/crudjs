package br.com.unifacef.web.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.unifacef.web.entities.Medicamento;

public interface MedicamentoRepositorio  extends MongoRepository<Medicamento, String>{

}
