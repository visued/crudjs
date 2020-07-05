package br.com.unifacef.web.entities;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

// a classe é um documento do MongoDB
@Document(collection="produto")
public class Produto {
	
	@Id
	private String id;
	private String nome;
	private Integer qtde;
	private Float valor;
	
	public Produto() {
		
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@NotNull(message="Nome não pode ser nulo")
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	@NotNull(message="Qtde não pode ser nula")
	public Integer getQtde() {
		return qtde;
	}
	public void setQtde(Integer qtde) {
		this.qtde = qtde;
	}
	@NotNull(message="Valor não pode ser nulo")
	public Float getValor() {
		return valor;
	}
	public void setValor(Float valor) {
		this.valor = valor;
	}
	@Override
	public String toString() {
		return "Produto [id=" + id + ", nome=" + nome + ", qtde=" + qtde + ", valor=" + valor + "]";
	}
	
	

}
