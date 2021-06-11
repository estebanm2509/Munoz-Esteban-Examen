package ec.edu.ups.beans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ec.edu.ups.jpa.JPAPedidoDAO;
import ec.edu.ups.modelos.Comida;
import ec.edu.ups.modelos.Pedido;

@Named
@RequestScoped
public class VistaPedidos {

	@Inject
	private JPAPedidoDAO dao;
	
	private Pedido pedido;
	private List<Comida> comidas;
	private String comida;
	
	public VistaPedidos() {
	}
	
	@PostConstruct
	public void init() {
		comida = "";
		pedido = new Pedido();
		comidas = new ArrayList<Comida>();
	}
	
	public Pedido getPedido() {
		return pedido;
	}
	
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	
	public List<Comida> getComidas() {
		return comidas;
	}
	
	public void setComidas(List<Comida> comidas) {
		this.comidas = comidas;
	}
	
	public void guardar() {
		dao.crear(pedido);
		comida = "";
	}
	
}
