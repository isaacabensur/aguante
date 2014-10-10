package fulbito.model;

public class Persona {
	
	private int codPer;
	private String tipoPer;
	private String nombres;
	private String paterno;
	private String materno;
	private String sexo;
	private String tipoDoc;
	private String numDoc;
	private String correo;
	private String password;
	private String fecNac;
	private Integer celular;
	
	public Persona() {
		
	}
	
	public Persona(int codPer, String tipoPer, String nombres, String paterno,
			String materno, String sexo, String tipoDoc, String numDoc,
			String correo, String password, String fecNac, Integer celular) {
		super();
		this.codPer = codPer;
		this.tipoPer = tipoPer;
		this.nombres = nombres;
		this.paterno = paterno;
		this.materno = materno;
		this.sexo = sexo;
		this.tipoDoc = tipoDoc;
		this.numDoc = numDoc;
		this.correo = correo;
		this.password = password;
		this.fecNac = fecNac;
		this.celular = celular;
	}

	public int getCodPer() {
		return codPer;
	}

	public void setCodPer(int codPer) {
		this.codPer = codPer;
	}

	public String getTipoPer() {
		return tipoPer;
	}

	public void setTipoPer(String tipoPer) {
		this.tipoPer = tipoPer;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getPaterno() {
		return paterno;
	}

	public void setPaterno(String paterno) {
		this.paterno = paterno;
	}

	public String getMaterno() {
		return materno;
	}

	public void setMaterno(String materno) {
		this.materno = materno;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getTipoDoc() {
		return tipoDoc;
	}

	public void setTipoDoc(String tipoDoc) {
		this.tipoDoc = tipoDoc;
	}

	public String getNumDoc() {
		return numDoc;
	}

	public void setNumDoc(String numDoc) {
		this.numDoc = numDoc;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFecNac() {
		return fecNac;
	}

	public void setFecNac(String fecNac) {
		this.fecNac = fecNac;
	}

	public Integer getCelular() {
		return celular;
	}

	public void setCelular(int celular) {
		this.celular = celular;
	}
	
}
