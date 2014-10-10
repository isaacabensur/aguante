package fulbito.model;

import java.util.Collection;

public class Local {
	
	private int codLoc;
	private String desLoc;
	private String direccion;
	private String distrito;
	private String dicGoogle;
	private int telefonoFijo;
	private Collection<Evento> eventos;
	private Collection<ServAdicional> servAdicionales;
	private Collection<Cancha> canchas;
	private Duenio oDuenio;
	
	public Local() {
		
	}

	public Local(int codLoc, String desLoc, String direccion, String distrito,
			String dicGoogle, int telefonoFijo, Collection<Evento> eventos,
			Collection<ServAdicional> servAdicionales,
			Collection<Cancha> canchas, Duenio oDuenio) {
		super();
		this.codLoc = codLoc;
		this.desLoc = desLoc;
		this.direccion = direccion;
		this.distrito = distrito;
		this.dicGoogle = dicGoogle;
		this.telefonoFijo = telefonoFijo;
		this.eventos = eventos;
		this.servAdicionales = servAdicionales;
		this.canchas = canchas;
		this.oDuenio = oDuenio;
	}

	public int getCodLoc() {
		return codLoc;
	}

	public void setCodLoc(int codLoc) {
		this.codLoc = codLoc;
	}

	public String getDesLoc() {
		return desLoc;
	}

	public void setDesLoc(String descLoc) {
		this.desLoc = descLoc;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getDistrito() {
		return distrito;
	}

	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}

	public String getDicGoogle() {
		return dicGoogle;
	}

	public void setDicGoogle(String dicGoogle) {
		this.dicGoogle = dicGoogle;
	}

	public int getTelefonoFijo() {
		return telefonoFijo;
	}

	public void setTelefonoFijo(int telefonoFijo) {
		this.telefonoFijo = telefonoFijo;
	}

	public Collection<Evento> getEventos() {
		return eventos;
	}

	public void setEventos(Collection<Evento> eventos) {
		this.eventos = eventos;
	}

	public Collection<ServAdicional> getServAdicionales() {
		return servAdicionales;
	}

	public void setServAdicionales(Collection<ServAdicional> servAdicionales) {
		this.servAdicionales = servAdicionales;
	}

	public Collection<Cancha> getCanchas() {
		return canchas;
	}

	public void setCanchas(Collection<Cancha> canchas) {
		this.canchas = canchas;
	}

	public Duenio getoDuenio() {
		return oDuenio;
	}

	public void setoDuenio(Duenio oDuenio) {
		this.oDuenio = oDuenio;
	}
	
}
