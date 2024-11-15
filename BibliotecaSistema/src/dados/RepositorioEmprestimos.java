package dados;

import java.util.List;
import java.util.ArrayList;
import negocio.Emprestimo;

public class RepositorioEmprestimos implements Repositorio<Emprestimo>{
	
	private List<Emprestimo> emprestimos;
	
	public RepositorioEmprestimos() {
		this.emprestimos = new ArrayList<>();
	}
	
	@Override
	public void adicionar(Emprestimo emprestimo) {
		emprestimos.add(emprestimo);
	}
	
	@Override
	public List<Emprestimo> listarTodos(){
		return emprestimos;
	}
	
	@Override
	public void remover(Emprestimo emprestimo) {
		emprestimos.remove(emprestimo);
	}
	
	@Override
	public Emprestimo buscar(String idLivro) {
	    for (Emprestimo emprestimo : emprestimos) {
	        if (emprestimo.getIdLivro().equals(idLivro)) {
	            return emprestimo;
	        }
	    }
	    return null;
	}
	
	
}