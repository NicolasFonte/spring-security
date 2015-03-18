package modelo;


import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

import dao.DAO;
import modelo.Autor;
import modelo.Livro;

@ManagedBean
@ViewScoped
public class LivroBean implements Serializable {

	private static final long serialVersionUID = 1932792412326305073L;

	public LivroBean() {
	}
	
	private Livro livro = new Livro();

	private Integer autorId;
	
	private List<Livro> livros;
	
	public Livro getLivro() {
		return livro;
	}

	public void comecaComDigitoUm(FacesContext fc, UIComponent component, Object object) {
		String isbn = object.toString();
		if (!isbn.startsWith("1")) {
			throw new ValidatorException(new FacesMessage(" ISBN Deveria começar com 1"));
		}
	}
	
	public List<Autor> getAutores() {
		return new DAO<Autor>(Autor.class).listaTodos();
	}
	
	public List<Autor> getAutoresDoLivro(){
		return this.livro.getAutores();
	}
	
	public void associarAutor() {
		Autor autor = new DAO<Autor>(Autor.class).buscaPorId(autorId);
		System.out.println("Autor Id: " + autorId );
		this.livro.adicionaAutor(autor);
	}
	
	public void gravar() {

		if (livro.getAutores().isEmpty()) {
			FacesContext.getCurrentInstance().addMessage("autor", new FacesMessage("O autor é obrigatório"));
			return;
		}

		new DAO<Livro>(Livro.class).adiciona(this.livro);
		this.livro = new Livro();
		this.livros = null;
	}

	public Integer getAutorId() {
		return autorId;
	}

	public void setAutorId(Integer autorId) {
		this.autorId = autorId;
	}

	public List<Livro> getLivros() {
		if (livros == null) {
			livros = new DAO<Livro>(Livro.class).listaTodos();
		}
		return livros;
	}

	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}

	
	public String formAutor() {
		return "autor?faces-redirect=true";
	}
	
}

