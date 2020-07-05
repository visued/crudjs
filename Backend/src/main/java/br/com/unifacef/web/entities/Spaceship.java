package br.com.unifacef.web.entities;
import javax.validation	.constraints.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

// a classe é um documento do MongoDB
@Document(collection="spaceship")
public class Spaceship {
	@Id
	private String id;
	private String attr1;
	private String attr2;
	private Integer attr3;
	
	public Spaceship() {
		
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
	
	@NotNull(message="Missao não pode ser nulo")
	public String getAttr2() {
		return attr2;
	}

	public void setAttr2(String attr2) {
		this.attr2 = attr2;
	}
	
	@NotNull(message="Ano não pode ser nulo")
	public Integer getAttr3() {
		return attr3;
	}

	public void setAttr3(Integer attr3) {
		this.attr3 = attr3;
	}

	@Override
	public String toString() {
		return "Medicamento [id=" + id + ", Nome=" + attr1 + ", Missao="
				+ attr2 + ", Ano=" + attr3 + "]";
	}
	
	

}
