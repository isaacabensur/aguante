package fulbito.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import fulbito.exception.DAOExcepcion;
import fulbito.model.ServAdicional;
import fulbito.util.ConexionBD;



public class ServAdicionalDAO extends BaseDAO {


	
	public int insertar(ServAdicional vo) throws DAOExcepcion {
		System.out.println("ServAdicionalDAO: insertar(ServAdicional vo)");
		String query = "INSERT INTO servadicional(tipo,descripcion,tarifa,Local_codLoc) VALUES (?,?,?,?)";
		Connection con = null;
		PreparedStatement stmt = null;
		int state = 0;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			
			stmt.setString(1, vo.getTipo());
			stmt.setString(2, vo.getDescripcion());
			stmt.setLong(3, (long) vo.getTarifa());
			stmt.setInt(4, vo.getoLocal().getCodLoc());
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



}

