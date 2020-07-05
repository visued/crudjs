package br.com.unifacef.web.entities;
import javax.validation	.constraints.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

// a classe é um documento do MongoDB
@Document(collection="pokemon")
public class Pokemon {
	@Id
	private String id;
	private String attr1;
	private String attr2;
	private String attr3;
	
	public Pokemon() {
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	@NotNull(message="Nome não pode ser nulo")
	public String getAttr1() {
		return attr1;
	}

	public void setAttr1(String attr1) {
		this.attr1 = attr1;
	}
	
	@NotNull(message="Especie não pode ser nulo")
	public String getAttr2() {
		return attr2;
	}

	public void setAttr2(String attr2) {
		this.attr2 = attr2;
	}
	
	@NotNull(message="Habilidade não pode ser nulo")
	public String getAttr3() {
		return attr3;
	}

	public void setAttr3(String attr3) {
		this.attr3 = attr3;
	}

	@Override
	public String toString() {
		return "Pokemon [id=" + id + ", nome=" + attr1 + ", especie="
				+ attr2 + ", habilidade=" + attr3 + "]";
	}
}
