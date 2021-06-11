package ec.edu.ups.jpa;

import java.util.List;

import ec.edu.ups.modelos.Pedido;

public interface PedidoDAO {

	public List<Pedido>buscarPorComida(String nombre);
	
	public List<Pedido>buscarPorTarjeta(String numeroTarjeta);
}
