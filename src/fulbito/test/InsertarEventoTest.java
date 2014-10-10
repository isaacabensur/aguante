package fulbito.test;

import junit.framework.Assert;
import org.junit.Test;

import fulbito.business.InsertarEvento;
import fulbito.exception.DAOExcepcion;

public class InsertarEventoTest {
	
	
		
	
	public void insertarEventoTest(){
		
		InsertarEvento neg = new InsertarEvento();
		try {
		
			neg.insertarEvento("COPA DEL REY", "COPA", 20, "23/03/2012", 1);
		} catch (DAOExcepcion e) {
			Assert.fail("Falló: " + e.getMessage());
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}
	
	
		
public void insertarMensajeErrorTest(){
		
		InsertarEvento  neg = new InsertarEvento();
		try {
		
			neg.insertarEvento("", "", 0 , "", 0);
		} catch (DAOExcepcion e) {
			System.out.print(e.getMessage());
			Assert.fail("Falló: " + e.getMessage());
			
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

@Test
public void MensajeErrorNombreDuplicadoTest(){
	
	InsertarEvento neg = new InsertarEvento();
	try {
	
		neg.insertarEvento("CHAMPIONS LEAGUE", "COPA", 20, "17/03/2012", 1);
	} catch (DAOExcepcion e) {
		Assert.fail("Falló: " + e.getMessage());
	} catch (Exception ex) {
		System.out.println(ex);
	}
}


}
