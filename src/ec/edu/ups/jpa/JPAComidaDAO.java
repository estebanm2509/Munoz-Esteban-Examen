package ec.edu.ups.jpa;

import ec.edu.ups.modelos.Comida;

public class JPAComidaDAO extends JPAGenericDAO<Comida, Integer> {

	public JPAComidaDAO() {
		super(Comida.class);
	}
	
}
