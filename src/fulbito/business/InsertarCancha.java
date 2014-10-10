package fulbito.business;

import java.sql.SQLException;
import java.util.Collection;

import fulbito.dao.CanchaDAO;
import fulbito.exception.DAOExcepcion;
import fulbito.model.Cancha;
import fulbito.model.Local;

public class InsertarCancha {

	public String insertarCancha(String nombre, String caracteristicas, String diasAtencion, String horasAtencion, Double tarifaDiurna, Double tarifaNocturna, String promo, String foto, int local) throws DAOExcepcion {

		Cancha model = new Cancha();
		Local oLocal = new Local();
		boolean flag = true; 
		String status = "";
		String answer = "";
		//if(!nombre.equals("") && !caracteristicas.equals("") && !diasAtencion.equals("") && !horasAtencion.equals("") && tarifaDiurna >0 && tarifaNocturna >0 && !promo.equals("") && !foto.equals("") && local > 0 ){
		model.setNombre(nombre);
		model.setCaracteristicas(caracteristicas);
		model.setDiasAtencion(diasAtencion);
		model.setHorasAtencion(horasAtencion);
		model.setTarifaDiurna(tarifaDiurna);
		model.setTarifaNocturna(tarifaNocturna);
		model.setPromo(promo);
		model.setFoto(foto);
		//model.setDisponible(disponible);
		oLocal.setCodLoc(local);
		model.setoLocal(oLocal);
		
		if(nombre == null || nombre.equals("")) {
			flag = false;
			status = "Ingrese el nombre de la cancha.";
			answer += status+"\\n";
			System.out.println(status);
			throw new DAOExcepcion(status);
		}
		if(caracteristicas == null || caracteristicas.equals("")) {
			flag = false;
			status = "Ingrese las caracterísitcas de la cancha.";
			answer += status+"\\n";
			System.out.println(status);
			throw new DAOExcepcion(status);
		}
		if(diasAtencion == null || diasAtencion.equals("")) {
			flag = false;
			status = "Ingrese los días de antención de la cancha.";
			answer += status+"\\n";
			System.out.println(status);
			throw new DAOExcepcion(status);
		}
		if(horasAtencion == null || horasAtencion.equals("")) {
			flag = false;
			status = "Ingrese las horas de antención de la cancha.";
			answer += status+"\\n";
			System.out.println(status);
			throw new DAOExcepcion(status);
		}
		if(tarifaDiurna == null || tarifaDiurna == 0.0) {
			flag = false;
			status = "Ingrese la tarifa diurna.";
			answer += status+"\\n";
			System.out.println(status);
			throw new DAOExcepcion(status);
		}
		if(tarifaNocturna == null || tarifaNocturna == 0.0) {
			flag = false;
			status = "Ingrese la tarifa nocturna.";
			answer += status+"\\n";
			System.out.println(status);
			throw new DAOExcepcion(status);
		}
		CanchaDAO dao = new CanchaDAO();
		Collection<Cancha> Canchas = dao.buscarPorNombre(nombre, local);
		if (Canchas.size()>0) {
			flag = false;
			status = "La cancha "+nombre+" ya se encuentra registrado.";
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
				answer = "La cancha "+nombre+" se ha registrado con éxito.";
				System.out.println(answer);
			}
		}
		return answer;
	}

	
	
}
