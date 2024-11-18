package negocio;

public class Livro {
	
	private String id;
	private String titulo;
	private String autor;
	private boolean disponivel;
	
	public Livro(String id, String titulo, String autor) {
		this.id = id;
		this.autor =  autor;
		this.titulo = titulo;
		this.disponivel = true;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public String getAutor() {
		return autor;
	}
	
	public String getId() {
		return id;
	}
	
	public boolean isDisponivel() {
		return disponivel;
	}
	
	public void setDisponivel(boolean disponivel) {
		this.disponivel = disponivel;
	}
	@Override
	public String toString() {
        return titulo + " por " + autor + " (ISBN: " + id + ")\n";
    }

}
