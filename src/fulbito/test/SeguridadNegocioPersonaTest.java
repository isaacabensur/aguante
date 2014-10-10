package fulbito.test;

import junit.framework.Assert;
import org.junit.Test;

import fulbito.business.SeguridadNegocioPersona;
import fulbito.exception.DAOExcepcion;

public class SeguridadNegocioPersonaTest {
	
	@Test
	public void insertarPersonaTest() {
		
		SeguridadNegocioPersona neg = new SeguridadNegocioPersona();
		try {
			neg.insertarPersona("NAT", "user9", "Dante", "Fernandez","M","DNI","186374545","user921@asd.com","576678","21/05/1995",45);
		} catch (DAOExcepcion e) {
			Assert.fail("Falló: " + e.getMessage());
		} catch (Exception ex) {
			System.out.println(ex);
		}
		
	}
	
	//@Test
	public void insertarErrorPersonaTest() {
		
		SeguridadNegocioPersona neg = new SeguridadNegocioPersona();
		try {
			neg.insertarPersona("", "dd", "wq", "eqw","M","DNI","18637455","user9@asd.com","576678","21/05/1995",45);
		} catch (DAOExcepcion e) {
			Assert.fail("Falló: " + e.getMessage());
		} catch (Exception ex) {
			System.out.println(ex);
		}
		
	}
	
	//@Test
	public void insertarErrorDuplicadoPersonaTest() {
		
		SeguridadNegocioPersona neg = new SeguridadNegocioPersona();
		try {
			neg.insertarPersona("NAT", "user9", "Dante", "Fernandez","M","DNI","186374545","user91@asd.com","576678","21/05/1995",45);
		} catch (DAOExcepcion e) {
			Assert.fail("Falló: " + e.getMessage());
		} catch (Exception ex) {
			System.out.println(ex);
		}
		
	}
}
