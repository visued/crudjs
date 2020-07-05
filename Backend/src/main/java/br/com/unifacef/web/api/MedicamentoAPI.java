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

import br.com.unifacef.web.entities.Medicamento;
import br.com.unifacef.web.repository.MedicamentoRepositorio;
import br.com.unifacef.web.response.Response;
@CrossOrigin(origins = "*")
//Classe que controla solicitação de API em REST
@RestController
//Mapeamento das solicitações para esta classe
@RequestMapping("/medicamento")

public class MedicamentoAPI {
	//injeção de dependência
	//usar um obj de uma interface sem ter que instanciá-lo
	@Autowired
	private MedicamentoRepositorio injecao;
	// consulta e retorna uma lista de produtos do banco
	@GetMapping
	public List<Medicamento> consulta(){
			return injecao.findAll();
	}
	// insere um medicamento no banco
	@PostMapping
	public ResponseEntity<Response<Medicamento>> cadastra(@Valid @RequestBody Medicamento medicamento,
			BindingResult result) {
			
		Response<Medicamento> response = new Response<Medicamento>();
			
		if (result.hasErrors()) {
			result.getAllErrors().forEach(
					error -> response.getErrors().add(error.getDefaultMessage())
			);
				
			// retorna os erros encontrados
			return ResponseEntity.badRequest().body(response);
		}
			
		// não teve erro
		Medicamento novo = injecao.save(medicamento);
		response.setData(novo);
		return ResponseEntity.ok(response);
	}
	@DeleteMapping("/{id}")
	public Medicamento remove(@PathVariable String id) {
		injecao.deleteById(id);
		return null;
	}

	@PutMapping
	public Medicamento atualiza(@RequestBody Medicamento medicamento) {
		return injecao.save(medicamento); // atualiza
	}

}
