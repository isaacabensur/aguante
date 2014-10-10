package fulbito.model;

import java.util.Collection;


public class Cliente extends Persona {
	
	private Collection<Alquiler> alquileres;
	private Collection<Comentario> comentarios;
	
	public Cliente() {
		
	}

	public Cliente(Collection<Alquiler> alquileres,
			Collection<Comentario> comentarios) {
		super();
		this.alquileres = alquileres;
		this.comentarios = comentarios;
	}

	public Collection<Alquiler> getAlquileres() {
		return alquileres;
	}

	public void setAlquileres(Collection<Alquiler> alquileres) {
		this.alquileres = alquileres;
	}

	public Collection<Comentario> getComentarios() {
		return comentarios;
	}

	public void setComentarios(Collection<Comentario> comentarios) {
		this.comentarios = comentarios;
	}
	
}
