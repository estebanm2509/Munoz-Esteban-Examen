package ec.edu.ups.jpa;

import java.util.List;

public interface GenericDAO<T, ID> {

	public void crear(T entidad);
	
	public void modificar(T entidad);
	
	public void eliminar(ID id);
	
	public T buscar(ID id);
	
	public List<T> listar();
}
