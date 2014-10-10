package fulbito.test;

import junit.framework.Assert;
import org.junit.Test;

import fulbito.business.SeguridadNegocioAlquiler;
import fulbito.business.SeguridadNegocioHorario;
import fulbito.exception.DAOExcepcion;

public class SeguridadNegocioAlquilerTest {
	
	@Test
	public void insertarAlquilerTest() {
		SeguridadNegocioHorario negh = new SeguridadNegocioHorario();
		SeguridadNegocioAlquiler neg = new SeguridadNegocioAlquiler();
		String fecha = "";
		boolean flag = false;
		
		
		try {
			fecha = "17/03/2012";
			flag = negh.buscarPorFecha(fecha);
			if(!flag) neg.isertarAlquiler(fecha, 1);
			else{
				System.out.println("La cancha ya esta alquilada");
				throw new DAOExcepcion("La cancha ya esta alquilada");
			
			}
		} catch (DAOExcepcion e) {
			Assert.fail("Falló: " + e.getMessage());
		} catch (Exception ex) {
			System.out.println(ex);
		}
		
	}
	
	
}
