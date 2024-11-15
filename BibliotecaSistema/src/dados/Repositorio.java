package dados;
import java.util.List;

public interface Repositorio<T> {
	void adicionar(T item);
	void remover(T item);
	List<T> listarTodos();
	T buscar(String id);
}
