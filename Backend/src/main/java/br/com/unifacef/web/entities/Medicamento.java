package br.com.unifacef.web.entities;
import javax.validation	.constraints.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

// a classe é um documento do MongoDB
@Document(collection="medicamento")
public class Medicamento {
	@Id
	private String id;
	private String attr1;
	private Integer attr2;
	private String attr3;
	
	public Medicamento() {
		
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
	@NotNull(message="Concentração não pode ser nulo")
	public Integer getAttr2() {
		return attr2;
	}

	public void setAttr2(Integer attr2) {
		this.attr2 = attr2;
	}
	@NotNull(message="Valor não pode ser nulo")
	public String getAttr3() {
		return attr3;
	}

	public void setAttr3(String attr3) {
		this.attr3 = attr3;
	}

	@Override
	public String toString() {
		return "Medicamento [id=" + id + ", attr1=" + attr1 + ", attr2=" + attr2 + ", attr3=" + attr3 + "]";
	}

	
	
	

}
