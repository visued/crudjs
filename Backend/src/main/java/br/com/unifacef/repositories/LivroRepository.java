package br.com.unifacef.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.unifacef.entities.Livro;

// classe interface que herda de MongoRepository
// Livro é a classe que será persistida e String é o tipo do id da classe

public interface LivroRepository extends MongoRepository <Livro, String>{

	
}
