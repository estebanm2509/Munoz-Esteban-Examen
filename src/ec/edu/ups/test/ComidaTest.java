package ec.edu.ups.test;

import ec.edu.ups.jpa.FabricaDAO;
import ec.edu.ups.jpa.JPAComidaDAO;
import ec.edu.ups.modelos.Comida;

public class ComidaTest {

	public static void main(String[] args) {
		JPAComidaDAO dao = FabricaDAO.getComidaDAO();
		Comida c1 = new Comida();
		c1.setNombre("Arroz figuetti");
		c1.setPrecioUnitario(2.50);
		
		Comida c2 = new Comida();
		c2.setNombre("Seco de pollo");
		c2.setPrecioUnitario(1.50);
		
		Comida c3 = new Comida();
		c3.setNombre("Seco de res");
		c3.setPrecioUnitario(2.0);
		
		Comida c4 = new Comida();
		c4.setNombre("Fritada");
		c4.setPrecioUnitario(3.0);
		
		dao.crear(c1);
		dao.crear(c2);
		dao.crear(c3);
		dao.crear(c4);
	}

}
