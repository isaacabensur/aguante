package fulbito.model;

import java.util.Collection;

public class Duenio extends Persona {
	
	private Collection<Local> locales;
	
	public Duenio() {
		
	}
	
	public Duenio(Collection<Local> locales) {
		super();
		this.locales = locales;
	}


	public Collection<Local> getLocales() {
		return locales;
	}

	public void setLocales(Collection<Local> locales) {
		this.locales = locales;
	}
	
	
}

