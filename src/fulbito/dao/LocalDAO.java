package fulbito.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import fulbito.exception.DAOExcepcion;
import fulbito.model.Local;
import fulbito.util.ConexionBD;


public class LocalDAO extends BaseDAO {

	public Collection<Local> buscarPorNombre(String desLoc) throws DAOExcepcion {
		System.out.println("LocalDAO: buscarPorNombre(String desLoc)");
		String query = "SELECT desLoc, direccion FROM Local WHERE desLoc like ?";
		Collection<Local> lista = new ArrayList<Local>();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, "%" + desLoc + "%");
			rs = stmt.executeQuery();
			while (rs.next()) {
				Local vo = new Local();
				vo.setDesLoc(rs.getString("desLoc"));
				vo.setDireccion(rs.getString("direccion"));
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
	
	public int insertar(Local vo) throws DAOExcepcion {
		System.out.println("LocalDAO: insertar(Local vo)");
		String query = "INSERT INTO Local(desLoc,direccion,distrito,dicGoogle,telefonoFijo,Persona_codPer ) VALUES (?,?,?,?,?,?)";
		Connection con = null;
		PreparedStatement stmt = null;
		int state = 0;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setInt(1, vo.getCodLoc());
			stmt.setString(1, vo.getDesLoc());
			stmt.setString(2, vo.getDireccion());
			stmt.setString(3, vo.getDistrito());
			stmt.setString(4, vo.getDicGoogle());
			stmt.setInt(5, vo.getTelefonoFijo());
			stmt.setInt(6, vo.getoDuenio().getCodPer());
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

	public Local buscarDescripcion(String desLoc) throws DAOExcepcion {
		System.out.println("LocalDAO: buscarDesLoc(String desLoc)");
		Local vo = null;
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			String query = "select desLoc, direccion from Local where desLoc=?";
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, desLoc);
			rs = stmt.executeQuery();
			if (rs.next()) {
				vo = new Local();
				vo.setDesLoc(rs.getString(1));
				vo.setDireccion(rs.getString(2));
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
	
	public Collection<Local> buscarPorPersona(int codPersona) throws DAOExcepcion {
		System.out.println("LocalDAO: buscarPorPersona(int codPersona)");
		String query = "SELECT codLoc, desLoc FROM Local WHERE Persona_codPer = ?";
		Collection<Local> lista = new ArrayList<Local>();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setInt(1, codPersona);
			rs = stmt.executeQuery();
			while (rs.next()) {
				Local vo = new Local();
				vo.setCodLoc(rs.getInt("codLoc"));
				vo.setDesLoc(rs.getString("desLoc"));
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
	
	
	
		public Collection<Local> ListarLocales() throws DAOExcepcion {
			System.out.println("Local: ListarLocales");
			String query = "SELECT codLoc,desLoc FROM local";
			Collection<Local> lstLocal = new ArrayList<Local>();
			Connection con = null;
			PreparedStatement stmt = null;
			ResultSet rs = null;
			try {
				con = ConexionBD.obtenerConexion();
				stmt = con.prepareStatement(query);
				rs = stmt.executeQuery();
				while (rs.next()) {
					Local objLocal = new Local();
								objLocal.setCodLoc(rs.getInt("codLoc"));
								objLocal.setDesLoc(rs.getString("desLoc"));						
								lstLocal.add(objLocal);
				}
			} catch (SQLException e) {
				System.err.println(e.getMessage());
				throw new DAOExcepcion(e.getMessage());
			} finally {
				this.cerrarResultSet(rs);
				this.cerrarStatement(stmt);
				this.cerrarConexion(con);
			}
			return lstLocal;
		}	
	}
