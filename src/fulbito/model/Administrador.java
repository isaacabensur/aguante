package fulbito.model;

import java.util.Collection;


public class Administrador extends Persona {
	
	private Collection<Publicidad> publicidades;
	
	public Administrador() {
			
	}

	public Administrador(Collection<Publicidad> publicidades) {
		super();
		this.publicidades = publicidades;
	}

	public Collection<Publicidad> getPublicidades() {
		return publicidades;
	}

	public void setPublicidades(Collection<Publicidad> publicidades) {
		this.publicidades = publicidades;
	}
	
}
