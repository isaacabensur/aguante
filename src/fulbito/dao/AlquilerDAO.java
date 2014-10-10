package fulbito.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import fulbito.exception.DAOExcepcion;
import fulbito.model.Alquiler;
import fulbito.model.Cancha;
import fulbito.model.Cliente;
import fulbito.model.Local;
import fulbito.model.Persona;
import fulbito.util.ConexionBD;



public class AlquilerDAO extends BaseDAO {

	public Collection<Alquiler> buscarPorFecha(String fecha) throws DAOExcepcion {
		System.out.println("AlquilerDAO: buscarPorFecha(String fecha)");
		String query = "SELECT codAlquiler FROM alquiler WHERE fecAlquiler = STR_TO_DATE(?,'%d/%m/%Y')";
		Collection<Alquiler> lista = new ArrayList<Alquiler>();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, fecha);
			rs = stmt.executeQuery();
			while (rs.next()) {
				Alquiler vo = new Alquiler();
				vo.setCodAlquiler(rs.getInt("codAlquiler"));
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

	
public void insertar(Alquiler vo) throws DAOExcepcion {
		System.out.println("AlquilerDAO: insertar(Alquiler vo)");
		String query = "INSERT INTO alquiler(fecAlquiler,Persona_codPer) VALUES (STR_TO_DATE(?,'%d/%m/%Y'),?)";
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, vo.getFecAlquiler());
			stmt.setInt(2, vo.getoCliente().getCodPer());
			
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
	}

	public Alquiler obtener(String codigoAlquiler) throws DAOExcepcion {
		System.out.println("AlquilerDAO: obtener(String codigoAlquiler)");
		Alquiler vo = new Alquiler();
		Cliente cl = new Cliente();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			String query = "select fecAlquiler, Persona_codPer from alquiler where codAlquiler=?";
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, codigoAlquiler);
			rs = stmt.executeQuery();
			if (rs.next()) {
				vo.setFecAlquiler(rs.getString(1));
				cl.setCodPer(rs.getInt(2));
				vo.setoCliente(cl);
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarResultSet(rs);
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		return vo;
	}

	public void eliminar(String codigoAlquiler) throws DAOExcepcion {
		System.out.println("AlquilerDAO: eliminar(String codigoAlquiler)");
		String query = "DELETE FROM alquiler WHERE codAlquiler=?";
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, codigoAlquiler);
			int i = stmt.executeUpdate();
			if (i != 1) {
				throw new SQLException("No se pudo eliminar");
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
	}

	public void actualizar(Alquiler vo) throws DAOExcepcion {
		System.out.println("AlquilerDAO: actualizar(Alquiler vo)");
		String query = "update alquiler set fecAlquiler=? where codAlquiler=?";
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, vo.getFecAlquiler());
			stmt.setInt(2, vo.getCodAlquiler());
			int i = stmt.executeUpdate();
			if (i != 1) {
				throw new SQLException("No se pudo actualizar");
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
	}

	
	public Collection<Alquiler> listar() throws DAOExcepcion {
		System.out.println("AlquilerDAO: listar()");
		Collection<Alquiler> c = new ArrayList<Alquiler>();
		Cliente cl = new Cliente();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			String query = "SELECT codAlquiler, fecAlquiler, Persona_codPer from alquiler";
			stmt = con.prepareStatement(query);
			rs = stmt.executeQuery();
			while (rs.next()) {
				Alquiler vo = new Alquiler();
				vo.setCodAlquiler(rs.getInt("codAlquiler"));
				vo.setFecAlquiler(rs.getString("fecAlquiler"));
				cl.setCodPer(rs.getInt("Persona_codPer"));
				vo.setoCliente(cl);
				c.add(vo);
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		return c;
	}
	
	public Collection<Alquiler> listarAlquileres(int codlocal, String horainicio, String horasfin) throws DAOExcepcion {
		System.out.println("CanchaDAO: buscarAlquileres(int codlocal, String horainicio, String horasfin)");
		String query = "select a.codAlquiler, a.fecAlquiler, a.Persona_codPer from alquiler a, horario b, cancha c where a.codAlquiler = b.Alquiler_codAlquiler and c.numCancha = b.Cancha_numCancha and c.Local_codLoc = ? and b.horaInicio = ? and b.horaFin = ? ";
		Collection<Alquiler> lista = new ArrayList<Alquiler>();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setInt(1, codlocal);
			stmt.setString(2, horainicio);
			stmt.setString(3, horasfin);
			rs = stmt.executeQuery();
			while (rs.next()) {
				Alquiler vo = new Alquiler();
				Cliente _vo = new Cliente();
				vo.setCodAlquiler(rs.getInt("codAlquiler"));
				vo.setFecAlquiler(rs.getString("fecAlquiler"));
				_vo.setCodPer(rs.getInt("Persona_codPer"));
				vo.setoCliente(_vo);
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