package fulbito.business;
import java.util.Collection;
import fulbito.dao.LocalDAO;
import fulbito.exception.DAOExcepcion;
import fulbito.model.Local;

public class SeguridadLocal {

		
	public Collection<Local> ListarLocal() throws DAOExcepcion {
		LocalDAO dao = new LocalDAO();
		return dao.ListarLocales();
	}
	
	
}