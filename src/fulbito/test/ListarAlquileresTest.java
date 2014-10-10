package fulbito.test;

import junit.framework.Assert;
import org.junit.Test;

import fulbito.business.SeguridadNegocioListarAlquileres;

import fulbito.exception.DAOExcepcion;

public class ListarAlquileresTest {
	
	
	
	@Test
	public void buscarcanchafulbito(){
		
		SeguridadNegocioListarAlquileres neg = new SeguridadNegocioListarAlquileres();
		
		try {
		
			neg.listarAlquilerFulbito(1, "12:00", "14:00");
		} catch (DAOExcepcion e) {
			Assert.fail("Falló: " + e.getMessage());
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}
	
}
