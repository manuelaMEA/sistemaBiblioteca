package Sistema;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Emprestimo {
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private String idLivro;
	private String idUsuario;
	private Livro livro;
	private Usuario usuario;
    private String devolucaoString;
    private String emprestimoString;
	
	public Emprestimo(String idUsuario, String idLivro, Calendar dataEmprestimo, Calendar dataDevolucao, RepositorioLivros repositorioLivros, RepositorioUsuarios repositorioUsuarios) {
		this.idUsuario = idUsuario;
		this.idLivro = idLivro;
		this.usuario = repositorioUsuarios.buscarUsuarioPorId(idUsuario);
		this.livro = repositorioLivros.buscarLivroPorId(idLivro);
        this.devolucaoString = sdf.format(dataDevolucao.getTime());
        this.emprestimoString = sdf.format(dataEmprestimo.getTime());
	}
	
	public String getIdUsuario() {
		return idUsuario;
	}
	
	public String getIdLivro() {
		return idLivro;
	}
	
	public String getDataDevolucao() {
		return devolucaoString;
	}

	public String getDataEmprestimo() {
		return emprestimoString;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	public Livro getLivro() {
		return livro;
	}
	
}
