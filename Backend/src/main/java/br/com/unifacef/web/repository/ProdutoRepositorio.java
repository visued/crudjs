package br.com.unifacef.web.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.unifacef.web.entities.Produto;

//interface para acesso aos métodos de CRUD do MongoDB
public interface ProdutoRepositorio extends MongoRepository<Produto, String>{
	

}
