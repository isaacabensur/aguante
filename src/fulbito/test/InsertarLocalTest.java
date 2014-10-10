package fulbito.test;

import junit.framework.Assert;
import org.junit.Test;

import fulbito.business.InsertarLocal;
import fulbito.exception.DAOExcepcion;

public class InsertarLocalTest {
	
	@Test
	public void insertarLocalTest() {
		
		InsertarLocal neg = new InsertarLocal();
		try {
			neg.insertarLocal("Leyendas peruanas", "Av. San Luis 397", "San Borja", "123456",3489632,1 );
		} catch (DAOExcepcion e) {
			Assert.fail("Falló: " + e.getMessage());
		} catch (Exception ex) {
			System.out.println(ex);
		}
		
	}
		
	@Test
	public void insertarErrorLocalTest() {
		
		InsertarLocal neg = new InsertarLocal();
		try {
			neg.insertarLocal("Leyendas peruanas", "Av. San Luis 397", "San Borja", "123456",3489632,1 );
		} catch (DAOExcepcion e) {
			Assert.fail("Falló: " + e.getMessage());
		} catch (Exception ex) {
			System.out.println(ex);
		}
		
	}
	
	@Test
	public void insertarErrorDuplicadoLocalTest() {
		
		InsertarLocal neg = new InsertarLocal();
		try {
			neg.insertarLocal("Leyendas peruanas", "Av. San Luis 397", "San Borja", "123456",3489632,1 );
		} catch (DAOExcepcion e) {
			Assert.fail("Falló: " + e.getMessage());
		} catch (Exception ex) {
			System.out.println(ex);
		}
		
	}
	
	
}
