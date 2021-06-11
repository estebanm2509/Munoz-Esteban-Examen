package ec.edu.ups.jpa;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class JPAGenericDAO<T, ID> implements GenericDAO<T, ID>, Serializable {

	private Class<T> clase;
	protected EntityManager gestor;
	
	public JPAGenericDAO(Class<T> clase) {
		this.clase = clase;
		this.gestor = Persistence.createEntityManagerFactory("jpa").createEntityManager();
	}

	@Override
	public void crear(T entidad) {
		gestor.getTransaction().begin();
		try {
			gestor.persist(entidad);
			gestor.getTransaction().commit();
		} catch (Exception e) {
			if (gestor.getTransaction().isActive()) {
				gestor.getTransaction().rollback();
			}
		}
	}

	@Override
	public void modificar(T entidad) {
		gestor.getTransaction().begin();
		try {
			gestor.merge(entidad);
			gestor.getTransaction().commit();
		} catch (Exception e) {
			if (gestor.getTransaction().isActive()) {
				gestor.getTransaction().rollback();
			}
		}
	}

	@Override
	public void eliminar(ID id) {
		gestor.getTransaction().begin();
		try {
			gestor.remove(buscar(id));
			gestor.getTransaction().commit();
		} catch (Exception e) {
			if (gestor.getTransaction().isActive()) {
				gestor.getTransaction().rollback();
			}
		}
	}

	@Override
	public T buscar(ID id) {
		return gestor.find(clase, id);
	}

	@Override
	public List<T> listar() {
		String jpql = "SELECT o from " + clase.toString() + " o";
		Query consulta = gestor.createQuery(jpql, clase);
		return consulta.getResultList();
	}
	
	
}
