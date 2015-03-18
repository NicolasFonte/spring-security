package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Usuario implements Serializable {

	private static final long serialVersionUID = 7903815551528467928L;

	@Id
	@GeneratedValue
	private int id;
	
	private String username;
	private String password;
	@Column(name = "enable", columnDefinition = "BOOLEAN")
	private boolean enable;
	@OneToMany
	private List<Autorizacao> autorizacoes;

	public Usuario() {
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Autorizacao> getAutorizacoes() {
		if (autorizacoes == null) {
			autorizacoes = new ArrayList<Autorizacao>();
		}
		return autorizacoes;
	}

	public void setAutorizacoes(List<Autorizacao> autorizacoes) {
		this.autorizacoes = autorizacoes;
	}

	public boolean isEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}

}
