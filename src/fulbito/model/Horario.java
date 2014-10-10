package fulbito.model;

public class Horario {

	private int codHorario;
	private String fecha;
	private String horaInicio;
	private String horaFin;
	private String estado;
	private Alquiler oAlquiler;
	private Cancha oCancha;
	
	public Horario() {
		
	}
	
	public Horario(int codHorario, String fecha, String horaInicio,
			String horaFin, String estado, Alquiler oAlquiler, Cancha oCancha) {
		super();
		this.codHorario = codHorario;
		this.fecha = fecha;
		this.horaInicio = horaInicio;
		this.horaFin = horaFin;
		this.estado = estado;
		this.oAlquiler = oAlquiler;
		this.oCancha = oCancha;
	}

	public int getCodHorario() {
		return codHorario;
	}

	public void setCodHorario(int codHorario) {
		this.codHorario = codHorario;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(String horaInicio) {
		this.horaInicio = horaInicio;
	}

	public String getHoraFin() {
		return horaFin;
	}

	public void setHoraFin(String horaFin) {
		this.horaFin = horaFin;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Alquiler getoAlquiler() {
		return oAlquiler;
	}

	public void setoAlquiler(Alquiler oAlquiler) {
		this.oAlquiler = oAlquiler;
	}

	public Cancha getoCancha() {
		return oCancha;
	}

	public void setoCancha(Cancha oCancha) {
		this.oCancha = oCancha;
	}
	
}
