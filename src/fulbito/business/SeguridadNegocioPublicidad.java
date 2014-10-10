package fulbito.business;

import fulbito.dao.PublicidadDAO;
import fulbito.exception.DAOExcepcion;
import fulbito.model.Administrador;
import fulbito.model.Publicidad;

public class SeguridadNegocioPublicidad {
	
	public String isertarPublicidad(String titulo, String contenido, String fecInicio, String fecFin, Double tarifa, Integer clicks, String seccion, Integer codPersona) throws DAOExcepcion {
		
		boolean flag = true;
		String status = "";
		String answer = "";
		Publicidad model = new Publicidad();
		Administrador admin = new Administrador();
		model.setTitulo(titulo);
		model.setContenido(contenido);
		model.setFechaInicio(fecInicio);
		model.setFechaFin(fecFin);
		model.setTarifa(tarifa);
		model.setClicks(clicks);
		model.setSeccion(seccion);
		admin.setCodPer(codPersona);
		model.setoAdministrador(admin);
		
		if(titulo == null || titulo.equals("")) {
			flag = false;
			status = "Ingrese el título.";
			answer += status+"\\n";
			System.out.println(status);
			throw new DAOExcepcion(status);
		}
		if(contenido == null || contenido.equals("")) {
			flag = false;
			status = "Ingrese el contenido.";
			answer += status+"\\n";
			System.out.println(status);
			throw new DAOExcepcion(status);
		}
		if(fecInicio == null || fecInicio.equals("")) {
			flag = false;
			status = "Ingrese la fecha de inicio.";
			answer += status+"\\n";
			System.out.println(status);
			throw new DAOExcepcion(status);
		}
		if(fecFin == null || fecFin.equals("")) {
			flag = false;
			status = "Ingrese la fecha de fin.";
			answer += status+"\\n";
			System.out.println(status);
			throw new DAOExcepcion(status);
		}
		if(tarifa == null || tarifa.equals("")) {
			flag = false;
			status = "Ingrese la tarifa.";
			answer += status+"\\n";
			System.out.println(status);
			throw new DAOExcepcion(status);
		}
		if(clicks == null || clicks.equals("")) {
			flag = false;
			status = "Ingrese un número de clics.";
			answer += status+"\\n";
			System.out.println(status);
			throw new DAOExcepcion(status);
		}
		if(seccion == null || seccion.equals("")) {
			flag = false;
			status = "Ingrese la seccion.";
			answer += status+"\\n";
			System.out.println(status);
			throw new DAOExcepcion(status);
		}
		if(codPersona == null || codPersona.equals("")) {
			flag = false;
			status = "Ingrese la el código del Administrador";
			answer += status+"\\n";
			System.out.println(status);
			throw new DAOExcepcion(status);
		}
		PublicidadDAO dao = new PublicidadDAO();
		if(flag) {
			int state = dao.insertar(model);
			if (state != 1) {
				answer = "No se logró insertar. Intentelo nuevamente.";
				System.out.println(answer);
				//throw new DAOExcepcion(answer);
			} else {
				answer = "El publicidad "+titulo+" se ha registrado con éxito.";
				System.out.println(answer);
			}
		}
		return answer;
	}
	
}
