package fulbito.test;

import junit.framework.Assert;
import org.junit.Test;

import fulbito.business.InsertarServAdicional;
import fulbito.exception.DAOExcepcion;

public class InsertarServAdicionalTest {
	
	
	
	
	public void insertarServAdicionalTest(){
		
		InsertarServAdicional neg = new InsertarServAdicional();
		try {
		
			neg.insertarServAdicional("Camisetas", "Indumentaria del grupo en la cancha", 20.00,02);
		} catch (DAOExcepcion e) {
			Assert.fail("Falló: " + e.getMessage());
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}
	
	
	@Test
	public void insertarMensajeErrorTest(){
		
		InsertarServAdicional neg = new InsertarServAdicional();
		try {
		
			neg.insertarServAdicional("", "", 0.0 , 0);
		} catch (DAOExcepcion e) {
			System.out.print(e.getMessage());
			Assert.fail("Falló: " + e.getMessage());
			
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}
	
}
