package ec.edu.ups.beans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ec.edu.ups.jpa.JPAPedidoDAO;
import ec.edu.ups.modelos.Pedido;

@Named
@RequestScoped
public class VistaInicial {

	@Inject
	private JPAPedidoDAO dao;
	
	private List<Pedido> pedidos;
	
	public VistaInicial() {
	}
	
	@PostConstruct
	public void init() {
		pedidos = dao.listar();
	}
	
	public List<Pedido> getPedidos() {
		return pedidos;
	}
	
	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}
}
