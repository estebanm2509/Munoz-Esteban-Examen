package ec.edu.ups.modelos;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TarjetaCredito implements Serializable {

	@Id
	private String numeroTarjeta;
	private String nombreTitular;
	private LocalDate fechaCaducidad;
	private int cvv;
	
	public TarjetaCredito() {
	}

	public String getNumeroTarjeta() {
		return numeroTarjeta;
	}

	public void setNumeroTarjeta(String numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
	}

	public String getNombreTitular() {
		return nombreTitular;
	}

	public void setNombreTitular(String nombreTitular) {
		this.nombreTitular = nombreTitular;
	}

	public LocalDate getFechaCaducidad() {
		return fechaCaducidad;
	}

	public void setFechaCaducidad(LocalDate fechaCaducidad) {
		this.fechaCaducidad = fechaCaducidad;
	}

	public int getCvv() {
		return cvv;
	}

	public void setCvv(int cvv) {
		this.cvv = cvv;
	}
}
