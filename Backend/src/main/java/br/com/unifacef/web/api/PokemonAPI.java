package br.com.unifacef.web.api;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.unifacef.web.entities.Pokemon;
import br.com.unifacef.web.repository.PokemonRepositorio;
import br.com.unifacef.web.response.Response;
@CrossOrigin(origins = "*")
//Classe que controla solicitação de API em REST
@RestController
//Mapeamento das solicitações para esta classe
@RequestMapping("/pokemon")

public class PokemonAPI {
	//injeção de dependência
	//usar um obj de uma interface sem ter que instanciá-lo
	@Autowired
	private PokemonRepositorio injecao;
	// consulta e retorna uma lista de produtos do banco
	@GetMapping
	public List<Pokemon> consulta(){
			return injecao.findAll();
	}
	// insere um medicamento no banco
	@PostMapping
	public ResponseEntity<Response<Pokemon>> cadastra(@Valid @RequestBody Pokemon pokemon,
			BindingResult result) {
			
		Response<Pokemon> response = new Response<Pokemon>();
			
		if (result.hasErrors()) {
			result.getAllErrors().forEach(
					error -> response.getErrors().add(error.getDefaultMessage())
			);
				
			// retorna os erros encontrados
			return ResponseEntity.badRequest().body(response);
		}
			
		// não teve erro
		Pokemon novo = injecao.save(pokemon);
		response.setData(novo);
		return ResponseEntity.ok(response);
	}
	@DeleteMapping("/{id}")
	public Pokemon remove(@PathVariable String id) {
		injecao.deleteById(id);
		return null;
	}

	@PutMapping
	public Pokemon atualiza(@RequestBody Pokemon pokemon) {
		return injecao.save(pokemon); // atualiza
	}

}
