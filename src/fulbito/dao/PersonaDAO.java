package fulbito.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import fulbito.exception.DAOExcepcion;
import fulbito.model.Persona;
//import fulbito.model.ServAdicional;
import fulbito.util.ConexionBD;



public class PersonaDAO extends BaseDAO {

	public Collection<Persona> buscarPorNombre(String nombre) throws DAOExcepcion {
		System.out.println("PersonaDAO: buscarPorNombre(String nombre)");
		String query = "SELECT Persona_nombre, descripcion FROM Persona WHERE Persona_nombre like ?";
		Collection<Persona> lista = new ArrayList<Persona>();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, "%" + nombre + "%");
			rs = stmt.executeQuery();
			while (rs.next()) {
				Persona vo = new Persona();
				vo.setNombres(rs.getString("Persona_nombre"));
				vo.setPaterno(rs.getString("descripcion"));
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
	
	public int insertar(Persona vo) throws DAOExcepcion {
		System.out.println("PersonaDAO: insertar(Persona vo)");
		String query = "INSERT INTO Persona(tipoPer,nombres,paterno,materno,sexo,tipoDoc,numDoc,correo,password,fecNac,celular) VALUES (?,?,?,?,?,?,?,?,?,STR_TO_DATE(?,'%d/%m/%Y'),?)";
		Connection con = null;
		PreparedStatement stmt = null;
		int state = 0;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setInt(1, vo.getCodPer());
			stmt.setString(1, vo.getTipoPer());
			stmt.setString(2, vo.getNombres());
			stmt.setString(3, vo.getPaterno());
			stmt.setString(4, vo.getMaterno());
			stmt.setString(5, vo.getSexo());
			stmt.setString(6, vo.getTipoDoc());
			stmt.setString(7, vo.getNumDoc());
			stmt.setString(8, vo.getCorreo());
			stmt.setString(9, vo.getPassword());
			stmt.setString(10, vo.getFecNac());
			stmt.setInt(11, vo.getCelular());
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

	public Persona buscarCorreo(String correo) throws DAOExcepcion {
		System.out.println("PersonaDAO: buscarCorreo(String correo)");
		Persona vo = null;
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			String query = "select nombres, paterno from Persona where correo=?";
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, correo);
			rs = stmt.executeQuery();
			if (rs.next()) {
				vo = new Persona();
				vo.setNombres(rs.getString(1));
				vo.setPaterno(rs.getString(2));
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
	
	public Persona buscarCorreoPassword(String correo, String password) throws DAOExcepcion {
		System.out.println("PersonaDAO: buscarCorreoPassword(String correo, String password)");
		Persona vo = null;
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			String query = "select codPer, tipoPer, nombres, paterno, materno, sexo, tipoDoc, numDoc, correo, fecNac, celular from Persona where correo=? and password=?";
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, correo);
			stmt.setString(2, password);
			rs = stmt.executeQuery();
			if (rs.next()) {
				vo = new Persona();
				vo.setCodPer(rs.getInt(1));
				vo.setTipoPer(rs.getString(2));
				vo.setNombres(rs.getString(3));
				vo.setPaterno(rs.getString(4));
				vo.setMaterno(rs.getString(5));
				vo.setSexo(rs.getString(6));
				vo.setTipoDoc(rs.getString(7));
				vo.setNumDoc(rs.getString(8));
				vo.setCorreo(rs.getString(9));
				vo.setFecNac(rs.getString(10));
				vo.setCelular(rs.getInt(11));
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
	
	public Persona buscarNumDoc(String numDoc) throws DAOExcepcion {
		System.out.println("PersonaDAO: buscarNumDoc(String numDoc)");
		Persona vo = null;
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			String query = "select nombres, paterno from Persona where numDoc=?";
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, numDoc);
			rs = stmt.executeQuery();
			if (rs.next()) {
				vo = new Persona();
				vo.setNombres(rs.getString(1));
				vo.setPaterno(rs.getString(2));
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
	
	
	
	public Persona obtener(String PersonaNombre) throws DAOExcepcion {
		System.out.println("PersonaDAO: obtener(String PersonaNombre)");
		Persona vo = new Persona();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			String query = "select Persona_nombre, descripcion from Persona where Persona_nombre=?";
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, PersonaNombre);
			rs = stmt.executeQuery();
			if (rs.next()) {
				vo.setNombres(rs.getString(1));
				vo.setPaterno(rs.getString(2));
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

	
	
	
	public void eliminar(String PersonaNombre) throws DAOExcepcion {
		System.out.println("PersonaDAO: eliminar(String PersonaNombre)");
		String query = "DELETE FROM Persona WHERE Persona_nombre=?";
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, PersonaNombre);
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

	public void actualizar(Persona vo) throws DAOExcepcion {
		System.out.println("PersonaDAO: actualizar(Persona vo)");
		String query = "update Persona set descripcion=? where Persona_nombre=?";
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, vo.getNombres());
			stmt.setString(2, vo.getPaterno());
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

	
	public Collection<Persona> listar() throws DAOExcepcion {
		System.out.println("PersonaDAO: listar()");
		Collection<Persona> c = new ArrayList<Persona>();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
		con = ConexionBD.obtenerConexion();
		String query = "SELECT Persona_nombre,descripcion from Persona";
		stmt = con.prepareStatement(query);
		rs = stmt.executeQuery();
		while (rs.next()) {
		Persona vo = new Persona();
		vo.setNombres(rs.getString("Persona_nombre"));
		vo.setPaterno(rs.getString("descripcion"));
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