package br.com.unifacef.web.api;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.unifacef.web.entities.Produto;
import br.com.unifacef.web.repository.ProdutoRepositorio;
import br.com.unifacef.web.response.Response;

//Classe que controla solicitação de API em REST
@RestController
//Mapeamento das solicitações para esta classe
@RequestMapping("/produto")
public class ProdutoAPI {
	//injeção de dependência
	//usar um obj de uma interface sem ter que instanciá-lo
	@Autowired
	private ProdutoRepositorio injecao;
	
	// consulta e retorna uma lista de produtos do banco
	@GetMapping
	public List<Produto> consulta(){
		return injecao.findAll();
	}
	// insere um produto no banco
	@PostMapping
	public ResponseEntity<Response<Produto>> cadastra(@Valid @RequestBody Produto produto,
			BindingResult result) {
			
		Response<Produto> response = new Response<Produto>();
			
		if (result.hasErrors()) {
			result.getAllErrors().forEach(
					error -> response.getErrors().add(error.getDefaultMessage())
			);
				
			// retorna os erros encontrados
			return ResponseEntity.badRequest().body(response);
		}
			
		// não teve erro
		Produto novo = injecao.save(produto);
		response.setData(novo);
		return ResponseEntity.ok(response);
	}
	@DeleteMapping("/{id}")
	public Produto remove(@PathVariable String id) {
		injecao.deleteById(id);
		return null;
	}

	@PutMapping
	public Produto atualiza(@RequestBody Produto produto) {
		return injecao.save(produto); // atualiza
	}

}
