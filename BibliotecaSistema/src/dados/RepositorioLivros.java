package dados;

import java.util.List;
import java.util.ArrayList;
import negocio.Livro;

public class RepositorioLivros implements Repositorio<Livro> {
	
	private List<Livro> livros;
	
	public RepositorioLivros() {
		this.livros = new ArrayList<>();
	}
	
	@Override
	public void adicionar(Livro livro) {
		livros.add(livro);
	}
	
	@Override
	public List<Livro> listarTodos(){
		return livros;
	}
	
	@Override
	public Livro buscar(String id) {
		return livros.stream()
                .filter(u -> u.getId().equals(id))
                .findFirst()
                .orElse(null);
	}
	
	@Override
	public void remover(Livro livro) {
		livros.remove(livro);
	}


}
