package Sistema;

import java.util.Calendar;
import java.util.List;

public class Biblioteca {
	
	private RepositorioLivros repositorioLivros;
	private RepositorioUsuarios repositorioUsuarios;
	private RepositorioEmprestimos repositorioEmprestimos;
	
	public Biblioteca() {	
		repositorioLivros = new RepositorioLivros();
		repositorioUsuarios = new RepositorioUsuarios();
		repositorioEmprestimos = new RepositorioEmprestimos();	
	}
	
	public void adicionarLivros(Livro livro) {
		repositorioLivros.adicionarLivro(livro);
	}
	
	public void adicionarUsuarios(Usuario usuario) {
		repositorioUsuarios.adicionarUsuario(usuario);
	}
	
	public Usuario fazerLogin(String idUsuario, String senha) {
		Usuario usuario = repositorioUsuarios.buscarUsuarioPorId(idUsuario);    
        if (usuario == null) {
            System.out.println("Usuário não encontrado.");
            return null;
        }
        if (!usuario.verificarSenha(senha)) {
            System.out.println("Senha incorreta.");
            return null;
        }		
        return usuario;
	}
	
	public void emprestarLivro(String idLivro, String idUsuario) {
		Livro livro = repositorioLivros.buscarLivroPorId(idLivro);
		
	        if (livro == null) {
	            System.out.println("Livro não encontrado.");
	            return;
	        }
	        
	        if (!livro.isDisponivel()) {
	            System.out.println("Livro indisponível.");
	            return;
	        }
	        
	        livro.setDisponivel(false);
	        Calendar dataEmprestimo = Calendar.getInstance();
	        Calendar dataDevolucao = Calendar.getInstance();
	        dataDevolucao.add(Calendar.DAY_OF_MONTH, 14);
	        Emprestimo emprestimo = new Emprestimo(idUsuario, idLivro, dataEmprestimo, dataDevolucao, repositorioLivros, repositorioUsuarios);
	        repositorioEmprestimos.adicionarEmprestimos(emprestimo);
	        System.out.println("Empréstimo realizado com sucesso!");
	}
	
	public void devolverLivro(String idLivro) {
		Emprestimo emprestimo = repositorioEmprestimos.buscarEmprestimo(idLivro);
		Livro livro = repositorioLivros.buscarLivroPorId(idLivro);
	
	        if (emprestimo == null) {
	            System.out.println("Empréstimo não encontrado.");
	            return;
	        }
	        livro.setDisponivel(true);
	        repositorioEmprestimos.removerEmprestimo(emprestimo);
	        System.out.println("Devolução realizada com sucesso!");
	}
	
	public void listarLivros() {
        System.out.println("Livros cadastrados:");
        for (Livro livro : repositorioLivros.getLivros()) {
            System.out.println("- " + livro.getTitulo() + " por " + livro.getAutor() + " (ISBN: " + livro.getId() + ")");
        }
    }
	
	public void listarUsuarios() {
        System.out.println("Usuários cadastrados:");
        for (Usuario usuario : repositorioUsuarios.getUsuarios()) {
        	System.out.println("- " + usuario.getNome() + " (ID: " + usuario.getId() + ")");
        }
    }
	
	public void listarEmprestimos() {
	        System.out.println("\nLivros emprestados:");
	        for (Emprestimo emprestimo : repositorioEmprestimos.getEmprestimos()) {
	            System.out.println("- Livro Emprestado: " + emprestimo.getLivro() + "\n- Usuário: " + emprestimo.getUsuario() + "\n" + "- Data Empréstimo: " + emprestimo.getDataEmprestimo() + "\n- Data Devolução: " + emprestimo.getDataDevolucao() + "\n");
	        }
	    }
	
	public void listarEmprestimosPorUsuario(String idUsuario) {
	    List<Emprestimo> emprestimos = repositorioEmprestimos.getEmprestimos();
	    boolean encontrou = false;	    
	    System.out.println("Empréstimos do usuário " + idUsuario + ":");
	    for (Emprestimo emprestimo : emprestimos) {
	        if (emprestimo.getIdUsuario().equals(idUsuario)) {
	        	System.out.println("- Livro Emprestado: " + emprestimo.getLivro() + "\n- Usuário: " + emprestimo.getUsuario() + "\n" + "- Data Empréstimo: " + emprestimo.getDataEmprestimo() + "\n- Data Devolução: " + emprestimo.getDataDevolucao() + "\n");
	            encontrou = true;
	        }
	    }
	    if (!encontrou) {
	        System.out.println("Nenhum empréstimo encontrado para o usuário " + idUsuario + ".");
	    }
	}
        
}
