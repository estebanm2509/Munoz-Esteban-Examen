package ec.edu.ups.test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import ec.edu.ups.jpa.FabricaDAO;
import ec.edu.ups.jpa.JPAComidaDAO;
import ec.edu.ups.jpa.JPAPedidoDAO;
import ec.edu.ups.jpa.JPATarjetaCreditoDAO;
import ec.edu.ups.modelos.Comida;
import ec.edu.ups.modelos.Pedido;

public class PedidoTest {

	public static void main(String[] args) {
		JPAComidaDAO daoComida = FabricaDAO.getComidaDAO();
		JPATarjetaCreditoDAO daoTarjeta = FabricaDAO.getTarjetaCreditoDAO();
		JPAPedidoDAO daoPedido = FabricaDAO.getPedidoDAO();
		List<Comida> listaComidas = new ArrayList<Comida>();
		listaComidas.add(daoComida.buscar(1));
		listaComidas.add(daoComida.buscar(2));
		
		Pedido p1 = new Pedido();
		p1.setTarjetaCredito(daoTarjeta.buscar("1536-4562-7471-8787"));
		p1.setListaComidas(listaComidas);
		p1.setNombreCliente("Lala Paluza");
		p1.setObservaciones("Sin aji, me da ansiedad");
		p1.setSubtotal(p1.calcularSubtotal());
		p1.setTotal(p1.calcularTotal());
		
		daoPedido.crear(p1);
	}

}
