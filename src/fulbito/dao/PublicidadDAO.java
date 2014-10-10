package fulbito.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import fulbito.exception.DAOExcepcion;
import fulbito.model.Publicidad;
import fulbito.util.ConexionBD;



public class PublicidadDAO extends BaseDAO {

	public Collection<Publicidad> buscarPorTitulo(String titulo) throws DAOExcepcion {
		System.out.println("PublicidadDAO: buscarPorTitulo(String titulo)");
		String query = "SELECT titulo, contenido FROM publicidad WHERE titulo like ?";
		Collection<Publicidad> lista = new ArrayList<Publicidad>();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, "%" + titulo + "%");
			rs = stmt.executeQuery();
			while (rs.next()) {
				Publicidad vo = new Publicidad();
				vo.setTitulo(rs.getString("titulo"));
				vo.setContenido(rs.getString("contenido"));
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

	
public int insertar(Publicidad vo) throws DAOExcepcion {
		System.out.println("PublicidadDAO: insertar(Publicidad vo)");
		String query = "INSERT INTO publicidad(titulo,contenido,fechaInicio,fechaFin,tarifa,clicks,seccion,Persona_codPer) VALUES (?,?,STR_TO_DATE(?,'%d/%m/%Y'),STR_TO_DATE(?,'%d/%m/%Y'),?,?,?,?)";
		Connection con = null;
		PreparedStatement stmt = null;
		int state = 0;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, vo.getTitulo());
			stmt.setString(2, vo.getContenido());
			stmt.setString(3, vo.getFechaInicio());
			stmt.setString(4, vo.getFechaFin());
			stmt.setDouble(5, vo.getTarifa());
			stmt.setInt(6, vo.getClicks());
			stmt.setString(7, vo.getSeccion());
			stmt.setInt(8, vo.getoAdministrador().getCodPer());
			
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

	public Publicidad obtener(String codigoPublicidad) throws DAOExcepcion {
		System.out.println("PublicidadDAO: obtener(String codigoPublicidad)");
		Publicidad vo = new Publicidad();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			String query = "select titulo, contenido from publicidad where codPublicidad=?";
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, codigoPublicidad);
			rs = stmt.executeQuery();
			if (rs.next()) {
				vo.setTitulo(rs.getString(1));
				vo.setContenido(rs.getString(2));
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

	public void eliminar(String codigoPublicidad) throws DAOExcepcion {
		System.out.println("PublicidadDAO: eliminar(String codigoPublicidad)");
		String query = "DELETE FROM publicidad WHERE codPublicidad=?";
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, codigoPublicidad);
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

	public void actualizar(Publicidad vo) throws DAOExcepcion {
		System.out.println("PublicidadDAO: actualizar(Publicidad vo)");
		String query = "update publicidad set contenido=? where codPublicidad=?";
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, vo.getContenido());
			stmt.setInt(2, vo.getCodPublicidad());
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

	
public Collection<Publicidad> listar() throws DAOExcepcion {
		System.out.println("PublicidadDAO: listar()");
		Collection<Publicidad> c = new ArrayList<Publicidad>();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			String query = "SELECT codPublicidad, titulo, contenido, fechaInicio, fechaFin, tarifa from publicidad";
			stmt = con.prepareStatement(query);
			rs = stmt.executeQuery();
			while (rs.next()) {
				Publicidad vo = new Publicidad();
				vo.setCodPublicidad(rs.getInt("codPublicidad"));
				vo.setTitulo(rs.getString("titulo"));
				vo.setContenido(rs.getString("contenido"));
				vo.setFechaInicio(rs.getString("fechaInicio"));
				vo.setFechaFin(rs.getString("fechaFin"));
				vo.setTarifa(rs.getDouble("tarifa"));
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

}

