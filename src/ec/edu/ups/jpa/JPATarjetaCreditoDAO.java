package ec.edu.ups.jpa;

import ec.edu.ups.modelos.TarjetaCredito;

public class JPATarjetaCreditoDAO extends JPAGenericDAO<TarjetaCredito, String> {

	public JPATarjetaCreditoDAO() {
		super(TarjetaCredito.class);
	}
	
}
