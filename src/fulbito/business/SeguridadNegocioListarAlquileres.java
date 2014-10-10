package fulbito.business;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import fulbito.dao.AlquilerDAO;
import fulbito.exception.DAOExcepcion;
import fulbito.model.Alquiler;


public class SeguridadNegocioListarAlquileres {
	
	public void listarAlquilerFulbito(int codlocal, String horainicio, String horasfin) throws DAOExcepcion {
		
						
		Collection<Alquiler> lista = new ArrayList<Alquiler>();
		AlquilerDAO dao = new AlquilerDAO();
		lista = dao.listarAlquileres(codlocal, horainicio, horasfin);
			
		//for(int i=0; i<lista.size(); i++) {
		for(Iterator<Alquiler> i = lista.iterator(); i.hasNext();) {
			Alquiler vo = (Alquiler)i.next();
			System.out.println("codAlquiler="+vo.getCodAlquiler()+" fecAlquiler="+vo.getFecAlquiler()+" codPer="+vo.getoCliente().getCodPer());
			throw new DAOExcepcion("codAlquiler="+vo.getCodAlquiler()+" fecAlquiler="+vo.getFecAlquiler()+" codPer="+vo.getoCliente().getCodPer());
		}
		
	}
	
}
