package fulbito.test;

import junit.framework.Assert;
import org.junit.Test;

import fulbito.business.SeguridadNegocioPublicidad;
import fulbito.exception.DAOExcepcion;

public class SeguridadNegocioPublicidadTest {
	
	@Test
	public void insertarPublicidadTest() {
		
		SeguridadNegocioPublicidad neg = new SeguridadNegocioPublicidad();
		try {
			neg.isertarPublicidad("Bienvenida", "Se da una grata bienvenida a los inscritos", "15/03/2012", "18/03/2012", 1000.0, 0, "P1", 1);
		} catch (DAOExcepcion e) {
			Assert.fail("Falló: " + e.getMessage());
		} catch (Exception ex) {
			System.out.println(ex);
		}
		
	}
	
	
}
