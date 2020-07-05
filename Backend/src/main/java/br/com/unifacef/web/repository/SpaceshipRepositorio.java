package br.com.unifacef.web.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.unifacef.web.entities.Spaceship;

public interface SpaceshipRepositorio  extends MongoRepository<Spaceship, String>{

}
