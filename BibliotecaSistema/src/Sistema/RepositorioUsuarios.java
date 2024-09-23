package Sistema;

import java.util.List;
import java.util.ArrayList;

public class RepositorioUsuarios {
	
	private List<Usuario> usuarios;
	
	public RepositorioUsuarios() {
		this.usuarios = new ArrayList<>();
	}
	
	public void adicionarUsuario(Usuario usuario) {
		this.usuarios.add(usuario);
	}
	
	public List<Usuario>getUsuarios(){
		return new ArrayList<>(usuarios);
	}
	
	public Usuario buscarUsuarioPorId(String id) {
		 for (Usuario usuario : usuarios) {
		        if (usuario.getId().equals(id)) {
		            return usuario;
		        }
		    }
		    return null; 
    }	

}
