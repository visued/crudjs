package br.com.unifacef.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.unifacef.entities.Livro;
import br.com.unifacef.repositories.LivroRepository;

@RestController
@RequestMapping("/api/livro")
public class LivroController {

	// injeção de dependência
	LivroRepository objeto;
	
	
	// insere um livro no banco de dados
	@PostMapping
	public Livro addLivro(Livro livro) {
		return objeto.save(livro);
	}
	
	
	@GetMapping
	public List<Livro> getLivros(){
		return objeto.findAll();
	}
	
}
