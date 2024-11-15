package negocio;

public abstract class Usuario {
	
	private String id;
	private String nome;
	private String senha;
	
	public Usuario(String id, String nome, String senha) {
		this.id = id;
		this.nome = nome;
		this.senha = senha;
	}
	
	public String getId() {
		return id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public boolean verificarSenha(String senha) {
        return this.senha.equals(senha);
	}
	
	public String toString() {
        return nome + " (ID: " + id + ")";
    }


}