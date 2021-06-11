package ec.edu.ups.jpa;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.Query;

import ec.edu.ups.modelos.Pedido;

@Stateless
@Local
public class JPAPedidoDAO extends JPAGenericDAO<Pedido, Integer> implements PedidoDAO, Serializable {

	public JPAPedidoDAO() {
		super(Pedido.class);
	}

	@Override
	public List<Pedido> buscarPorComida(String nombre) {
		String jpql = "SELECT p from Pedido p LEFT JOIN p.listaComidas lc " +
					  "WHERE lc.nombre LIKE '" + nombre + "'";
		Query consulta = gestor.createQuery(jpql, Pedido.class);
		return consulta.getResultList();
	}

	@Override
	public List<Pedido> buscarPorTarjeta(String numeroTarjeta) {
		String jpql = "SELECT p from Pedido p LEFT JOIN p.tarjetaCredito t " +
				  "WHERE t LIKE '" + numeroTarjeta + "'";
		Query consulta = gestor.createQuery(jpql, Pedido.class);
		return consulta.getResultList();
	}
	
	
}
