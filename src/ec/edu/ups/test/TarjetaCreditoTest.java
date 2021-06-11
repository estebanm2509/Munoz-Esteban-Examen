package ec.edu.ups.test;

import java.time.LocalDate;

import ec.edu.ups.jpa.FabricaDAO;
import ec.edu.ups.jpa.JPATarjetaCreditoDAO;
import ec.edu.ups.modelos.TarjetaCredito;

public class TarjetaCreditoTest {

	public static void main(String[] args) {
		JPATarjetaCreditoDAO dao = FabricaDAO.getTarjetaCreditoDAO();
		TarjetaCredito t1 = new TarjetaCredito();
		t1.setNumeroTarjeta("1231-4234-1312-5342");
		t1.setNombreTitular("Elvis Cocho");
		t1.setFechaCaducidad(LocalDate.of(2021, 5, 15));
		t1.setCvv(112);
		
		TarjetaCredito t2 = new TarjetaCredito();
		t2.setNumeroTarjeta("1536-4562-7471-8787");
		t2.setNombreTitular("Alan Brito Delgado");
		t2.setFechaCaducidad(LocalDate.of(2026, 1, 7));
		t2.setCvv(223);
		
		TarjetaCredito t3 = new TarjetaCredito();
		t3.setNumeroTarjeta("1111-2222-3333-4444");
		t3.setNombreTitular("Esteban Quito");
		t3.setFechaCaducidad(LocalDate.of(2021, 5, 15));
		t3.setCvv(853);
		
		dao.crear(t1);
		dao.crear(t2);
		dao.crear(t3);
	}

}
