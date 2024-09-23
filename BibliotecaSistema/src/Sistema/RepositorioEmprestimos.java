package Sistema;

import java.util.List;
import java.util.ArrayList;

public class RepositorioEmprestimos {
	
	private List<Emprestimo> emprestimos;
	
	public RepositorioEmprestimos() {
		this.emprestimos = new ArrayList<>();
	}
	
	public void adicionarEmprestimos(Emprestimo emprestimo) {
		emprestimos.add(emprestimo);
	}
	
	public List<Emprestimo>getEmprestimos(){
		return new ArrayList<>(emprestimos);
	}
	
	public Emprestimo buscarEmprestimo(String idLivro) {
	    for (Emprestimo emprestimo : emprestimos) {
	        if (emprestimo.getIdLivro().equals(idLivro)) {
	            return emprestimo;
	        }
	    }
	    return null;
	}
	
	public void removerEmprestimo(Emprestimo emprestimo) {
		emprestimos.remove(emprestimo);
	}
	

}
