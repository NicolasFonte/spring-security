package modelo;

import javax.faces.bean.ManagedBean;
import dao.DAO;
import modelo.Autor;

@ManagedBean
public class AutorBean {

	private Autor autor = new Autor();

	public Autor getAutor() {
		return autor;
	}

	public String gravar() {
		System.out.println("Gravando autor " + this.autor.getNome());

		new DAO<Autor>(Autor.class).adiciona(this.autor);
		return "livro?faces-redirect=true";
	}
}
