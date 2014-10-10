package fulbito.business;

import fulbito.dao.PersonaDAO;
import fulbito.exception.DAOExcepcion;
import fulbito.model.Persona;

public class SeguridadNegocioPersona {
	
	public String insertarPersona(String tipoPer, String nombres, String paterno, String materno, String sexo, String tipoDoc, String numDoc, String correo, String password, String fecNac, Integer celular) throws DAOExcepcion {
		
		boolean flag = true;
		String status = "";
		String answer = "";
		Persona model = new Persona();
		model.setTipoPer(tipoPer);
		model.setNombres(nombres);
		model.setPaterno(paterno);
		model.setMaterno(materno);
		model.setSexo(sexo);
		model.setTipoDoc(tipoDoc);
		model.setNumDoc(numDoc);
		model.setCorreo(correo);
		model.setPassword(password);
		model.setFecNac(fecNac);
		model.setCelular(celular);
		
		if(tipoPer == null || tipoPer.equals("")) {
			flag = false;
			status = "Ingrese el tipo de persona.";
			answer += status+"\\n";
			System.out.println(status);
			throw new DAOExcepcion(status);
		}
		if(nombres == null || nombres.equals("")) {
			flag = false;
			status = "Ingrese los nombres.";
			answer += status+"\\n";
			System.out.println(status);
			throw new DAOExcepcion(status);
		}
		if(paterno == null || paterno.equals("")) {
			flag = false;
			status = "Ingrese el apellido paterno.";
			answer += status+"\\n";
			System.out.println(status);
			throw new DAOExcepcion(status);
		}
		if(materno == null || materno.equals("")) {
			flag = false;
			status = "Ingrese el apellido materno.";
			answer += status+"\\n";
			System.out.println(status);
			throw new DAOExcepcion(status);
		}
		if(sexo == null || sexo.equals("")) {
			flag = false;
			status = "Ingrese el sexo.";
			answer += status+"\\n";
			System.out.println(status);
			throw new DAOExcepcion(status);
		}
		if(tipoDoc == null || tipoDoc.equals("")) {
			flag = false;
			status = "Ingrese el tipo de documento.";
			answer += status+"\\n";
			System.out.println(status);
			throw new DAOExcepcion(status);
		}
		if(numDoc == null || numDoc.equals("")) {
			flag = false;
			status = "Ingrese el número de documento.";
			answer += status+"\\n";
			System.out.println(status);
			throw new DAOExcepcion(status);
		}
		if(correo == null || correo.equals("")) {
			flag = false;
			status = "Ingrese el correo.";
			answer += status+"\\n";
			System.out.println(status);
			throw new DAOExcepcion(status);
		}
		if(password == null || password.equals("")) {
			flag = false;
			status = "Ingrese la contraseña.";
			answer += status+"\\n";
			System.out.println(status);
			throw new DAOExcepcion(status);
		}
		if(fecNac == null || fecNac.equals("")) {
			flag = false;
			status = "Ingrese la fecha de nacimiento.";
			answer += status+"\\n";
			System.out.println(status);
			throw new DAOExcepcion(status);
		}
		if(celular == null || celular.equals("")) {
			flag = false;
			status = "Ingrese el celular.";
			answer += status+"\\n";
			System.out.println(status);
			throw new DAOExcepcion(status);
		}
		PersonaDAO dao = new PersonaDAO();
		Persona personaBusca = dao.buscarCorreo(correo);
		if (personaBusca!=null) {
			flag = false;
			status = "El correo "+correo+" ya se encuentra registrado.";
			answer += status+"\\n";
			System.out.println(status);
			//throw new DAOExcepcion(status);
		}
		
		personaBusca = dao.buscarNumDoc(numDoc);
		if (personaBusca!=null) {
			flag = false;
			status = "El DNI "+numDoc+" ya se encuentra registrado.";
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
				answer = "El usuario "+nombres+" "+paterno+" "+materno+" se ha registrado con éxito. Ingrese al sistema con el correo y contraseña registrados.";
				System.out.println(answer);
			}
		}
		return answer;
	}
	
	public Persona validarPersona(String correo, String password) throws DAOExcepcion {
		Persona persona = new Persona();
		PersonaDAO dao = new PersonaDAO();
		persona = dao.buscarCorreoPassword(correo, password);
		return persona;
	}
	
}
