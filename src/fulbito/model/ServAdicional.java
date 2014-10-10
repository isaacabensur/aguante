package fulbito.model;

public class ServAdicional {
	
	private int codServ;
	private String tipo;
	private String descripcion;
	private double tarifa;
	private Local oLocal;
	
	public ServAdicional() {
		
	}
	
	public ServAdicional(int codServ, String tipo, String descripcion,
			double tarifa, Local oLocal) {
		super();
		this.codServ = codServ;
		this.tipo = tipo;
		this.descripcion = descripcion;
		this.tarifa = tarifa;
		this.oLocal = oLocal;
	}

	public int getCodServ() {
		return codServ;
	}

	public void setCodServ(int codServ) {
		this.codServ = codServ;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getTarifa() {
		return tarifa;
	}

	public void setTarifa(double tarifa) {
		this.tarifa = tarifa;
	}

	public Local getoLocal() {
		return oLocal;
	}

	public void setoLocal(Local oLocal) {
		this.oLocal = oLocal;
	}
	
}
