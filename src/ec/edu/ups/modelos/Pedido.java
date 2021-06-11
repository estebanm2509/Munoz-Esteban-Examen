package ec.edu.ups.modelos;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
public class Pedido implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int numero;
	
	private LocalDate fecha;
	private String nombreCliente;
	private double subtotal;
	private double total;
	private String observaciones;
	
	@JoinColumn(name= "numeroTarjeta",referencedColumnName = "numeroTarjeta")
	@OneToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	private TarjetaCredito tarjetaCredito;
	
	@JoinTable(
		name = "pedidos_detalle",
		joinColumns = @JoinColumn(name = "pedido_numero"),
		inverseJoinColumns = @JoinColumn(name = "comida_codigo")
	)
	@ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	List<Comida> listaComidas;
	
	private static final double IVA = 0.12;

	public Pedido() {
		fecha = LocalDate.now();
	}
	
	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	
	public TarjetaCredito getTarjetaCredito() {
		return tarjetaCredito;
	}
	
	public void setTarjetaCredito(TarjetaCredito tarjetaCredito) {
		this.tarjetaCredito = tarjetaCredito;
	}
	
	public List<Comida> getListaComidas() {
		return listaComidas;
	}
	
	public void setListaComidas(List<Comida> listaComidas) {
		this.listaComidas = listaComidas;
	}
	
	public double calcularSubtotal(){
		double subtotal = 0;
		for (Comida c : listaComidas) {
			subtotal += c.getPrecioUnitario();
		}
		return subtotal;
	}
	
	public double calcularTotal(){
		return subtotal * IVA;
	}
}