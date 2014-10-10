package fulbito.model;

public class Publicidad {
	
	private int codPublicidad;
	private String titulo;
	private String contenido;
	private String fechaInicio;
	private String fechaFin;
	private double tarifa;
	private int clicks;
	private String seccion;
	private Administrador oAdministrador;
	
	public Publicidad() {
		
	}
	
	public Publicidad(int codPublicidad, String titulo, String contenido,
			String fechaInicio, String fechaFin, double tarifa, int clicks,
			String seccion, Administrador oAdministrador) {
		super();
		this.codPublicidad = codPublicidad;
		this.titulo = titulo;
		this.contenido = contenido;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.tarifa = tarifa;
		this.clicks = clicks;
		this.seccion = seccion;
		this.oAdministrador = oAdministrador;
	}

	public int getCodPublicidad() {
		return codPublicidad;
	}

	public void setCodPublicidad(int codPublicidad) {
		this.codPublicidad = codPublicidad;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	public String getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public String getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}

	public double getTarifa() {
		return tarifa;
	}

	public void setTarifa(double tarifa) {
		this.tarifa = tarifa;
	}

	public int getClicks() {
		return clicks;
	}

	public void setClicks(int clicks) {
		this.clicks = clicks;
	}

	public String getSeccion() {
		return seccion;
	}

	public void setSeccion(String seccion) {
		this.seccion = seccion;
	}

	public Administrador getoAdministrador() {
		return oAdministrador;
	}

	public void setoAdministrador(Administrador oAdministrador) {
		this.oAdministrador = oAdministrador;
	}
	
}
