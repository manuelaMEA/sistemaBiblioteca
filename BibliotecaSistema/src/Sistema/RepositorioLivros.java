package Sistema;

import java.util.List;
import java.util.ArrayList;

public class RepositorioLivros {
	
	private List<Livro> livros;
	
	public RepositorioLivros() {
		this.livros = new ArrayList<>();
	}
	
	public void adicionarLivro(Livro livro) {
		livros.add(livro);
	}
	
	public List<Livro>getLivros(){
		return new ArrayList<>(livros);
	}
	
	public Livro buscarLivroPorId(String id) {
		return livros.stream()
                .filter(u -> u.getId().equals(id))
                .findFirst()
                .orElse(null);
	}


}
