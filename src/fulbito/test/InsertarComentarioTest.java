package fulbito.test;

import junit.framework.Assert;
import org.junit.Test;
import fulbito.business.InsertarComentario;
import fulbito.exception.DAOExcepcion;

public class InsertarComentarioTest {
	
	
	
	@Test
	public void insertarComentarioTest(){
		
		InsertarComentario neg = new InsertarComentario();
		try {
		
			neg.insertarComentario("Esta cancha es genial", 5,0, 0, 1,2);
			
		} catch (DAOExcepcion e) {
			Assert.fail("Falló: " + e.getMessage());
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}
	
	
	
	public void insertarMensajeErrorTest(){
		
		InsertarComentario neg = new InsertarComentario();
		try {
		
			neg.insertarComentario("", 0, 0 , 0,0, 0);
		} catch (DAOExcepcion e) {
			System.out.print(e.getMessage());
			Assert.fail("Falló: " + e.getMessage());
			
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}
	
}
