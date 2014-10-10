package fulbito.business;

import fulbito.dao.ServAdicionalDAO;
import fulbito.exception.DAOExcepcion;
import fulbito.model.ServAdicional;
import fulbito.model.Local;

public class InsertarServAdicional {

	public String insertarServAdicional(String tipo, String descripcion, Double tarifa, int local) throws DAOExcepcion {

		boolean flag = true;
		String status = "";
		String answer = "";
		ServAdicional model = new ServAdicional();
		Local oLocal = new Local();
		//if(!tipo.equals("") && !descripcion.equals("") && tarifa>0 && local>0  ){
		model.setTipo(tipo);
		model.setDescripcion(descripcion);
		model.setTarifa(tarifa);
		oLocal.setCodLoc(local);
		model.setoLocal(oLocal);
		
		if(tipo == null || tipo.equals("")) {
			flag = false;
			status = "Ingrese el tipo del servicio adicional.";
			answer += status+"\\n";
			System.out.println(status);
			throw new DAOExcepcion(status);
		}
		if(descripcion == null || descripcion.equals("")) {
			flag = false;
			status = "Ingrese la descripcion del servicio adicional.";
			answer += status+"\\n";
			System.out.println(status);
			throw new DAOExcepcion(status);
		}
		if(tarifa == null || tarifa==0) {
			flag = false;
			status = "Ingrese la tarifa del servicio adicional.";
			answer += status+"\\n";
			System.out.println(status);
			throw new DAOExcepcion(status);
		}
		ServAdicionalDAO dao = new ServAdicionalDAO();
		if(flag) {
			int state = dao.insertar(model);
			if (state != 1) {
				answer = "No se logró insertar. Intentelo nuevamente.";
				System.out.println(answer);
				//throw new DAOExcepcion(answer);
			} else {
				answer = "El servicio adicional "+descripcion+" se ha registrado con éxito.";
				System.out.println(answer);
			}
		}
		return answer;
	}

}
