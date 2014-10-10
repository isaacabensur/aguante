package fulbito.business;

import fulbito.dao.ComentarioDAO;
import fulbito.exception.DAOExcepcion;
import fulbito.model.Comentario;
import fulbito.model.Cliente;
import fulbito.model.Cancha;

public class InsertarComentario {

	public void insertarComentario(String texto, int calificacion, int nivel, int comentario, int cliente, int cancha) throws DAOExcepcion {

		Comentario model = new Comentario();
		Cancha oCancha = new Cancha();
		Cliente oCliente= new Cliente();
		
		if(!texto.equals("")){
		
		model.setTexto(texto);
		model.setCalificacion(calificacion);
		model.setNivel(nivel);
		
		model.setCodComent(comentario);
		
		oCliente.setCodPer(cliente);
		model.setoCliente(oCliente);
		
		oCancha.setNumCan(cancha);
		model.setoCancha(oCancha);
		
		
		ComentarioDAO dao = new ComentarioDAO();
		dao.insertar(model);
		
		
		}
		
		else {
			
			throw new DAOExcepcion("Ingrese datos");
		}
		
	}

	
	
}
