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

import br.com.unifacef.web.entities.Spaceship;
import br.com.unifacef.web.repository.SpaceshipRepositorio;
import br.com.unifacef.web.response.Response;
@CrossOrigin(origins = "*")
//Classe que controla solicitação de API em REST
@RestController
//Mapeamento das solicitações para esta classe
@RequestMapping("/spaceship")

public class SpaceshipAPI {
	//injeção de dependência
	//usar um obj de uma interface sem ter que instanciá-lo
	@Autowired
	private SpaceshipRepositorio injecao;
	// consulta e retorna uma lista de produtos do banco
	@GetMapping
	public List<Spaceship> consulta(){
			return injecao.findAll();
	}
	// insere um medicamento no banco
	@PostMapping
	public ResponseEntity<Response<Spaceship>> cadastra(@Valid @RequestBody Spaceship spaceship,
			BindingResult result) {
			
		Response<Spaceship> response = new Response<Spaceship>();
			
		if (result.hasErrors()) {
			result.getAllErrors().forEach(
					error -> response.getErrors().add(error.getDefaultMessage())
			);
				
			// retorna os erros encontrados
			return ResponseEntity.badRequest().body(response);
		}
			
		// não teve erro
		Spaceship novo = injecao.save(spaceship);
		response.setData(novo);
		return ResponseEntity.ok(response);
	}
	@DeleteMapping("/{id}")
	public Spaceship remove(@PathVariable String id) {
		injecao.deleteById(id);
		return null;
	}

	@PutMapping
	public Spaceship atualiza(@RequestBody Spaceship spaceship) {
		return injecao.save(spaceship); // atualiza
	}

}
