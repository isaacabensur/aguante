package fulbito.model;

import java.util.Collection;

public class Alquiler {
	
	private int codAlquiler;
	private String fecAlquiler;
	private Collection<Horario> horarios;
	private Cliente oCliente;
	
	public Alquiler() {
		
	}
	
	public Alquiler(int codAlquiler, String fecAlquiler,
			Collection<Horario> horarios, Cliente oCliente) {
		super();
		this.codAlquiler = codAlquiler;
		this.fecAlquiler = fecAlquiler;
		this.horarios = horarios;
		this.oCliente = oCliente;
	}
	
	public int getCodAlquiler() {
		return codAlquiler;
	}

	public void setCodAlquiler(int codAlquiler) {
		this.codAlquiler = codAlquiler;
	}

	public String getFecAlquiler() {
		return fecAlquiler;
	}

	public void setFecAlquiler(String fecAlquiler) {
		this.fecAlquiler = fecAlquiler;
	}

	public Collection<Horario> getHorarios() {
		return horarios;
	}

	public void setHorarios(Collection<Horario> horarios) {
		this.horarios = horarios;
	}

	public Cliente getoCliente() {
		return oCliente;
	}

	public void setoCliente(Cliente oCliente) {
		this.oCliente = oCliente;
	}
	
}
