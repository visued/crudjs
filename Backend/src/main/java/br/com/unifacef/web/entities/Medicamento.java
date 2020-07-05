package br.com.unifacef.web.entities;
import javax.validation	.constraints.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

// a classe é um documento do MongoDB
@Document(collection="medicamento")
public class Medicamento {
	@Id
	private String id;
	private String nome;
	private String principio_ativo;
	private Integer concentracao;
	private Float valor;
	
	public Medicamento() {
		
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
	@NotNull(message="Principio ativo não pode ser nulo")
	public String getPrincipio_ativo() {
		return principio_ativo;
	}

	public void setPrincipio_ativo(String principio_ativo) {
		this.principio_ativo = principio_ativo;
	}
	
	@NotNull(message="Concentracao não pode ser nulo")
	public Integer getConcentracao() {
		return concentracao;
	}

	public void setConcentracao(Integer concentracao) {
		this.concentracao = concentracao;
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
		return "Medicamento [id=" + id + ", nome=" + nome + ", principio_ativo=" + principio_ativo + ", concentracao="
				+ concentracao + ", valor=" + valor + "]";
	}
	
	

}
