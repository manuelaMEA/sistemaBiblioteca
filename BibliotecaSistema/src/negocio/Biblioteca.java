package negocio;

import dados.RepositorioEmprestimos;
import dados.RepositorioLivros;
import dados.RepositorioUsuarios;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import dados.Repositorio;

public class Biblioteca {
	
	private Repositorio<Livro> repositorioLivros;
	private Repositorio<Usuario> repositorioUsuarios;
	private Repositorio<Emprestimo> repositorioEmprestimos;
	
	public Biblioteca() {	
		repositorioLivros = new RepositorioLivros();
		repositorioUsuarios = new RepositorioUsuarios();
		repositorioEmprestimos = new RepositorioEmprestimos();	
	}
	
	public void inicializar() {
        Livro livro0 = new Livro("978-6-3258-9681-8", "Amanhecer", "Stefani Neves");
        repositorioLivros.adicionar(livro0);
        Livro livro1 = new Livro("978-7-3291-1555-4", "Entardecer", "Stefani Neves");
        repositorioLivros.adicionar(livro1);
        Livro livro2 = new Livro("978-4-3193-7896-8", "Anoitecer", "Stefani Neves");
        repositorioLivros.adicionar(livro2);
        Livro livro3 = new Livro("978-8-0902-9295-6", "96 Tons de Carmin", "M.C. Benevides");
        repositorioLivros.adicionar(livro3);
        Livro livro4 = new Livro("978-6-6204-4114-0", "É Assim que Continua", "M.C. Benevides");
        repositorioLivros.adicionar(livro4);
        Livro livro5 = new Livro("978-9-3952-3913-4", "Anna Bella", "Lucas S. Alves");
        repositorioLivros.adicionar(livro5);
        Livro livro6 = new Livro("978-0-9189-7738-0", "Bozo, o Palhazo Assassino", "Lucas S. Alves");
        repositorioLivros.adicionar(livro6);
        Livro livro7 = new Livro("978-2-9883-4867-1", "Adotada", "Lucas S. Alves");
        repositorioLivros.adicionar(livro7);
        Livro livro8 = new Livro("978-2-7045-1758-9", "O Depois", "Mary Lane");
        repositorioLivros.adicionar(livro8);
        Livro livro9 = new Livro("978-6-2279-9756-9", "A resposta", "Emanuel J. Douglas");
        repositorioLivros.adicionar(livro9);        
        UsuarioCliente usuario0 = new UsuarioCliente("2024005676", "Manuela Menezes Alves", "abc123");
        repositorioUsuarios.adicionar(usuario0);
        UsuarioCliente usuario1 = new UsuarioCliente("2024002114", "Helio Rodrigues Carvalho", "helio123");
        repositorioUsuarios.adicionar(usuario1);
        UsuarioAdmin userAdmin = new UsuarioAdmin("1", "Raissa", "raissa123");
        repositorioUsuarios.adicionar(userAdmin);
    }
	
	public void adicionarLivros(Livro livro) {
		repositorioLivros.adicionar(livro);
	}
	
	public void adicionarUsuarios(Usuario usuario) {
		repositorioUsuarios.adicionar(usuario);
	}
	
	public Usuario fazerLogin(String idUsuario, String senha) {
		Usuario usuario = repositorioUsuarios.buscar(idUsuario);    
        if (usuario == null) {
            throw new RuntimeException("Usuário não encontrado.");
        }
        if (!usuario.verificarSenha(senha)) {
            throw new RuntimeException("Senha Incorreta.");
        }	  
        return usuario;
	}
	
	public void emprestarLivro(String idLivro, String idUsuario) {
		Livro livro = repositorioLivros.buscar(idLivro);
	        if (livro == null) {
	        	throw new RuntimeException("Livro não encontrado.");
	        }
	        if (!(livro.isDisponivel())) {
	        	throw new RuntimeException("Livro Indisponível.");
	        }
	        livro.setDisponivel(false);
	        Calendar dataEmprestimo = Calendar.getInstance();
	        Calendar dataDevolucao = Calendar.getInstance();
	        dataDevolucao.add(Calendar.DAY_OF_MONTH, 14);
	        Emprestimo emprestimo = new Emprestimo(idUsuario, idLivro, dataEmprestimo, dataDevolucao, repositorioLivros, repositorioUsuarios);
	        repositorioEmprestimos.adicionar(emprestimo);        	
		  }	        
	
	public void devolverLivro(String idLivro) {
		Emprestimo emprestimo = repositorioEmprestimos.buscar(idLivro);
		Livro livro = repositorioLivros.buscar(idLivro);	
	        if (emprestimo != null) {
	        	livro.setDisponivel(true);
		        repositorioEmprestimos.remover(emprestimo);
	        }        
	        else
	        	throw new RuntimeException("Empréstimo não encontrado.");
	}
	
	public List<Livro> listarLivros() {
        return repositorioLivros.listarTodos();
    }
	
	public List<Usuario> listarUsuarios() {
        return repositorioUsuarios.listarTodos();
    }
	
	public List<Emprestimo> listarEmprestimos() {
	        return repositorioEmprestimos.listarTodos();
	    }
	
	public List<Emprestimo> listarEmprestimosPorUsuario(String idUsuario) {
		List<Emprestimo> emprestimoUsuario = new ArrayList<>();
		List<Emprestimo> todosEmprestimos = repositorioEmprestimos.listarTodos();
	    for (Emprestimo emprestimo : todosEmprestimos) {
	        if (emprestimo.getIdUsuario().equals(idUsuario)) {
	        	emprestimoUsuario.add(emprestimo);
	        }
	    }
	    return emprestimoUsuario;
	}	
}
