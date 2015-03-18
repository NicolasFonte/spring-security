package modelo;
 
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
 
@Entity
public class Autorizacao implements Serializable {
 
	private static final long serialVersionUID = 2057548940795673131L;

	@Id
	@GeneratedValue
	private int id;
	
    private String nome;
 
    public Autorizacao() {
    }

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
 
    
 
}
