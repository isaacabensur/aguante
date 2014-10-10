package fulbito.business;

import java.util.Collection;

import fulbito.dao.EventoDAO;
import fulbito.exception.DAOExcepcion;
import fulbito.model.Evento;
import fulbito.model.Local;


public class InsertarEvento {

	public String insertarEvento( String nombre,String premio,Integer limiteCantidad, String plazoInscripcion,int Local_codLoc) throws DAOExcepcion {
		boolean flag = true;
		String status = "";
		String answer = "";
		Evento model = new Evento();
		Local oLocal=new Local();
		//if(!nombre.equals("")  ){
		model.setNombre(nombre);
		model.setPremio(premio);
		model.setLimiteCantidad(limiteCantidad);
		model.setPlazoInscripcion(plazoInscripcion);
		oLocal.setCodLoc(Local_codLoc);
		model.setoLocal(oLocal);
		
		if(nombre == null || nombre.equals("")) {
			flag = false;
			status = "Ingrese el nombre del evento.";
			answer += status+"\\n";
			System.out.println(status);
			throw new DAOExcepcion(status);
		}
		if(premio == null || premio.equals("")) {
			flag = false;
			status = "Ingrese el premio del evento.";
			answer += status+"\\n";
			System.out.println(status);
			throw new DAOExcepcion(status);
		}
		if(limiteCantidad == null || limiteCantidad==0) {
			flag = false;
			status = "Ingrese el límite de cantidad de equipos.";
			answer += status+"\\n";
			System.out.println(status);
			throw new DAOExcepcion(status);
		}
		if(plazoInscripcion == null || plazoInscripcion.equals("")) {
			flag = false;
			status = "Ingrese el plazo para la inscripción.";
			answer += status+"\\n";
			System.out.println(status);
			throw new DAOExcepcion(status);
		}
		EventoDAO dao = new EventoDAO();
		Collection<Evento> Eventos = dao.buscarPorNombre(nombre);
		if (Eventos.size()>0) {
			flag = false;
			status = "El evento "+nombre+" ya se encuentra registrado.";
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
				answer = "El evento "+nombre+" se ha registrado con éxito.";
				System.out.println(answer);
			}
		}
		return answer;
	}

}
