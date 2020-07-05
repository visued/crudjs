package br.com.unifacef.web.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.unifacef.web.entities.Pokemon;

public interface PokemonRepositorio  extends MongoRepository<Pokemon, String>{

}
