package fulbito.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import fulbito.exception.DAOExcepcion;
import fulbito.model.Cancha;
import fulbito.util.ConexionBD;



public class ListarAlquilerDAO extends BaseDAO {


	
/*public void insertar(Cancha vo) throws DAOExcepcion {
		System.out.println("CanchaDAO: insertar(Cancha vo)");
		String query = "INSERT INTO cancha(nombre,caracteristicas,diasAtencion,horasAtencion,tarifa,promo,foto,Local_codLoc) VALUES (?,?,?,?,?,?,?,?)";
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			
			stmt.setString(1, vo.getNombre());
			stmt.setString(2, vo.getCaracteristicas());
			stmt.setString(3, vo.getDiasAtencion());
			stmt.setString(4, vo.getHorasAtencion());
			stmt.setLong(5, (long) vo.getTarifa());
			stmt.setString(6, vo.getPromo());
			stmt.setString(7, vo.getFoto());
			//stmt.setString(8, vo.getDisponible());
			stmt.setInt(9, vo.getoLocal().getCodLoc());
			
			int i = stmt.executeUpdate();
			if (i != 1) {
				throw new SQLException("No se pudo insertar");
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
	}*/


public Collection<Cancha> buscarPorNombre(String nombre,int codlocal) throws DAOExcepcion {
	System.out.println("CanchaDAO: buscarPorNombre(String nombre)");
	String query = "SELECT nombre FROM cancha WHERE nombre like ? and Local_codLoc = ? ";
	Collection<Cancha> lista = new ArrayList<Cancha>();
	Connection con = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;
	try {
		con = ConexionBD.obtenerConexion();
		stmt = con.prepareStatement(query);
		stmt.setString(1, "%" + nombre + "%");
		stmt.setInt(2, codlocal);
		rs = stmt.executeQuery();
		while (rs.next()) {
			Cancha vo = new Cancha();
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

