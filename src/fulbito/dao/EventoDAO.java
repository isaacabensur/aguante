package fulbito.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
//import java.util.ArrayList;
//import java.util.Collection;

import fulbito.exception.DAOExcepcion;
import fulbito.model.Evento;
import fulbito.util.ConexionBD;



public class EventoDAO extends BaseDAO {

	
	
public int insertar(Evento vo) throws DAOExcepcion {
		System.out.println("EventoDAO: insertar(Evento vo)");
		String query = "INSERT INTO Evento(codEvento,nombre,premio,limiteCantidad,plazoInscripcion,Local_codLoc) VALUES (?,?,?,?,STR_TO_DATE(?,'%d/%m/%Y'),?)";
		Connection con = null;
		PreparedStatement stmt = null;
		int state = 0;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setInt(1, vo.getCodEvento());
			stmt.setString(2, vo.getNombre());
			stmt.setString(3, vo.getPremio());
			stmt.setLong(4, vo.getLimiteCantidad());
			stmt.setString(5, vo.getPlazoInscripcion());
			stmt.setInt(6, vo.getoLocal().getCodLoc());
			state = stmt.executeUpdate();
			return state;
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
	}

	
public Collection<Evento> buscarPorNombre(String nombre) throws DAOExcepcion {
	System.out.println("EventoDAO: buscarPorNombre(String nombre)");
	String query = "SELECT nombre FROM evento WHERE nombre like ?  ";
	Collection<Evento> lista = new ArrayList<Evento>();
	Connection con = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;
	try {
		con = ConexionBD.obtenerConexion();
		stmt = con.prepareStatement(query);
		stmt.setString(1, "%" + nombre + "%");
		
		rs = stmt.executeQuery();
		while (rs.next()) {
			Evento vo = new Evento();
			vo.setNombre(rs.getString("nombre"));
			lista.add(vo);
		}
	} catch (SQLException e) {
		System.err.println(e.getMessage());
		throw new DAOExcepcion(e.getMessage());
	} finally {
		this.cerrarResultSet(rs);
		this.cerrarStatement(stmt);
		this.cerrarConexion(con);
	}
	return lista;
}

	
	

}

