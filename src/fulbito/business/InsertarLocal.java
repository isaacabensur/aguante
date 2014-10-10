package fulbito.business;

import java.util.Collection;

import fulbito.dao.LocalDAO;
import fulbito.exception.DAOExcepcion;
import fulbito.model.Local;
import fulbito.model.Duenio;

public class InsertarLocal {

	public String insertarLocal(String desLoc, String direccion, String distrito, String dicGoogle, Integer telefonoFijo, Integer codPer ) throws DAOExcepcion {
		
		Duenio oDuenio = new Duenio();
		boolean flag = true; 
		String status = "";
		String answer = "";
		Local model = new Local();
		model.setDesLoc(desLoc);
		model.setDireccion(direccion);
		model.setDistrito(distrito);
		model.setDicGoogle(dicGoogle);
		model.setTelefonoFijo(telefonoFijo);
		oDuenio.setCodPer(codPer);
		model.setoDuenio(oDuenio);		
				
		if(desLoc == null || desLoc.equals("")) {
			flag = false;
			status = "Ingrese la descripción del local.";
			answer += status+"\\n";
			System.out.println(status);
			throw new DAOExcepcion(status);
		}
		if(direccion == null || direccion.equals("")) {
			flag = false;
			status = "Ingrese la direción.";
			answer += status+"\\n";
			System.out.println(status);
			throw new DAOExcepcion(status);
		}
		if(distrito == null || distrito.equals("")) {
			flag = false;
			status = "Ingrese el distrito.";
			answer += status+"\\n";
			System.out.println(status);
			throw new DAOExcepcion(status);
		}
		if(dicGoogle == null || dicGoogle.equals("")) {
			flag = false;
			status = "Ingrese la dirección en Google.";
			answer += status+"\\n";
			System.out.println(status);
			throw new DAOExcepcion(status);
		}
		if(telefonoFijo == null || telefonoFijo.equals("")) {
			flag = false;
			status = "Ingrese el teléfono fijo";
			answer += status+"\\n";
			System.out.println(status);
			throw new DAOExcepcion(status);
		}
				
		LocalDAO dao = new LocalDAO();
		Local localBusca = null;
		localBusca=dao.buscarDescripcion(desLoc);
		if (localBusca!=null) {
			flag = false;
			status = "El local "+desLoc+" ya se encuentra registrado.";
			answer += status+"\\n";
			System.out.println(status);
			//throw new DAOExcepcion(status);
		}
		if(flag) {
			int state = dao.insertar(model);
			if (state != 1) {
				answer = "No se logró insertar. Intentelo nuevamente.";
				System.out.println(answer);
				//throw new DAOExcepcion(answer);
			} else {
				answer = "El local "+desLoc+" se ha registrado con éxito. Puede registrar canchas para este local.";
				System.out.println(answer);
			}
		}
		return answer;
	}
		
	public Collection<Local> buscarPorPersona(int codPersona) throws DAOExcepcion {
		
		boolean flag = true; 
		LocalDAO dao = new LocalDAO();
		Collection<Local> lista = dao.buscarPorPersona(codPersona);
		return lista;
	}
}
