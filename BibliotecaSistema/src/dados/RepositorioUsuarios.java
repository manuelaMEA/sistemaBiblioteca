package dados;

import java.util.List;
import java.util.ArrayList;
import negocio.Usuario;

public class RepositorioUsuarios implements Repositorio<Usuario> {
	
	private List<Usuario> usuarios;
	
	public RepositorioUsuarios() {
		this.usuarios = new ArrayList<>();
	}
	
	@Override
	public void adicionar(Usuario usuario) {
		usuarios.add(usuario);
	}
	
	@Override
	public List<Usuario> listarTodos(){
		return usuarios;
	}
	
	@Override
	public Usuario buscar(String id) {
		 for (Usuario usuario : usuarios) {
		        if (usuario.getId().equals(id)) {
		            return usuario;
		        }
		    }
		    return null; 
    }	
	
	@Override
	public void remover(Usuario usuario) {
		usuarios.remove(usuario);
	}

}
