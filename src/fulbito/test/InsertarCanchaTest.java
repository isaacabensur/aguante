package fulbito.test;

import junit.framework.Assert;
import org.junit.Test;

import fulbito.business.InsertarCancha;
import fulbito.exception.DAOExcepcion;

public class InsertarCanchaTest {
	
	
	
	@Test
	public void insertarCanchaTest(){
		
		InsertarCancha neg = new InsertarCancha();
		try {
		
			neg.insertarCancha("Cancha Carlos", "Natural, sin iluminacion", "L-S", "09:00-17:00", 50.50, 60.60, "Sin oferta", "/images/canchamessi.jpg", 1);
		} catch (DAOExcepcion e) {
			Assert.fail("Falló: " + e.getMessage());
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}
	
	@Test
public void insertarMensajeErrorTest(){
		
		InsertarCancha neg = new InsertarCancha();
		try {
		
			neg.insertarCancha("", "", "", "", 0.0 , 0.0 , "", "", 0);
		} catch (DAOExcepcion e) {
			System.out.print(e.getMessage());
			Assert.fail("Falló: " + e.getMessage());
			
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

@Test

public void MensajeErrorNombreDuplicadoTest(){
	
	InsertarCancha neg = new InsertarCancha();
	try {
         	
		
		neg.insertarCancha("Cancha Carlos", "Natural, sin iluminacion", "L-S", "09:00-17:00", 50.50, 60.60, "Sin oferta", "/images/canchamessi.jpg", 1);
		
		
	} catch (DAOExcepcion e) {
		Assert.fail("Falló: " + e.getMessage());
	} catch (Exception ex) {
		System.out.println(ex);
	}
}


}
