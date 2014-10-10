package fulbito.test;

import junit.framework.Assert;
import org.junit.Test;

import fulbito.business.SeguridadNegocioHorario;
import fulbito.exception.DAOExcepcion;

public class SeguridadNegocioHorarioTest {
	
	@Test
	public void insertarHorarioTest() {
		
		SeguridadNegocioHorario neg = new SeguridadNegocioHorario();
		try {
			neg.isertarHorario("17/03/2012", "12:00", "14:00", "D", 3, 1);
		} catch (DAOExcepcion e) {
			Assert.fail("Falló: " + e.getMessage());
		} catch (Exception ex) {
			System.out.println(ex);
		}
		
	}
	
	
}
