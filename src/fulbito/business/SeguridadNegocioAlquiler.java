package fulbito.business;

import fulbito.dao.AlquilerDAO;
import fulbito.exception.DAOExcepcion;
import fulbito.model.Alquiler;
import fulbito.model.Cliente;

public class SeguridadNegocioAlquiler {
	
	public void isertarAlquiler(String fecAlquiler, Integer codPer) throws DAOExcepcion {
		
		boolean flag = true; 
		Alquiler model = new Alquiler();
		Cliente cliente = new Cliente();
		model.setFecAlquiler(fecAlquiler);
		cliente.setCodPer(codPer);
		model.setoCliente(cliente);
		
		if(fecAlquiler == null || fecAlquiler.equals("")) {
			flag = false;
			System.out.println("Ingrese la fecha del alquiler");
			throw new DAOExcepcion("Ingrese la fecha del alquiler");
		}
		if(codPer == null || codPer.equals("")) {
			flag = false;
			System.out.println("Ingrese el código del cliente");
			throw new DAOExcepcion("Ingrese el código del cliente");
		}
		AlquilerDAO dao = new AlquilerDAO();
		if(flag) {
			dao.insertar(model);
			System.out.println("El alquiler para la fecha "+fecAlquiler+" se ha insertado correctamente.");
			//throw new DAOExcepcion("El alquiler para la fecha "+fecAlquiler+" se ha insertado correctamente.");
		}
		
	}
	
}
