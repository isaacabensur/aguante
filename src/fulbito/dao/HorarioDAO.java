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
import fulbito.model.Horario;
import fulbito.util.ConexionBD;



public class HorarioDAO extends BaseDAO {

	public Collection<Horario> buscarPorFecha(String fecha) throws DAOExcepcion {
		System.out.println("HorarioDAO: buscarPorFecha(String fecha)");
		String query = "SELECT codHorario, horaInicio, horaFin, estado, Cancha_numCancha, Alquiler_codAlquiler FROM horario WHERE fecha = STR_TO_DATE(?,'%d/%m/%Y')";
		Collection<Horario> lista = new ArrayList<Horario>();
		Cancha cancha = new Cancha();
		Alquiler alquiler = new Alquiler();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, fecha);
			rs = stmt.executeQuery();
			while (rs.next()) {
				Horario vo = new Horario();
				vo.setCodHorario(rs.getInt("codHorario"));
				vo.setHoraInicio(rs.getString("horaInicio"));
				vo.setHoraFin(rs.getString("horaFin"));
				vo.setEstado(rs.getString("estado"));
				cancha.setNumCan(rs.getInt("Cancha_numCancha"));
				vo.setoCancha(cancha);
				alquiler.setCodAlquiler(rs.getInt("Alquiler_codAlquiler"));
				vo.setoAlquiler(alquiler);
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

	public Collection<Horario> buscarPorDiaHoras(String dia, String horaInicio, String horaFin) throws DAOExcepcion {
		System.out.println("HorarioDAO: buscarPorDiaHoras(String dia, String horainicio, String HoraFin)");
		String query = "SELECT codHorario, fecha, horaInicio, HoraFin, estado, Cancha_numCancha, Alquiler_codAlquiler FROM horario WHERE DATE_FORMAT(fecha, '%w') = ? and horaInicio = ? and HoraFin = ? and fecha <= DATE_ADD(CURDATE(),INTERVAL 30 DAY);";
		Collection<Horario> lista = new ArrayList<Horario>();
		Cancha cancha = new Cancha();
		Alquiler alquiler = new Alquiler();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		int idia = getDia(dia);
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setInt(1, idia);
			stmt.setString(2, horaInicio);
			stmt.setString(3, horaFin);
			rs = stmt.executeQuery();
			while (rs.next()) {
				Horario vo = new Horario();
				vo.setCodHorario(rs.getInt("codHorario"));
				vo.setFecha(rs.getString("fecha"));
				vo.setHoraInicio(rs.getString("horaInicio"));
				vo.setHoraFin(rs.getString("horaFin"));
				vo.setEstado(rs.getString("estado"));
				cancha.setNumCan(rs.getInt("Cancha_numCancha"));
				vo.setoCancha(cancha);
				alquiler.setCodAlquiler(rs.getInt("Alquiler_codAlquiler"));
				vo.setoAlquiler(alquiler);
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
	
	public Collection<String> obtenerDiasSemana() throws DAOExcepcion {
		System.out.println("HorarioDAO: obtenerDiasSemana()");
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String out = "";
		Collection<String> lista = new ArrayList<String>();
		String query = "select DATE_FORMAT(a.Date, '%w %d/%m/%Y) fecha " +
			"from ( " +
			"    select curdate() - INTERVAL (a.a + (10 * b.a) + (100 * c.a)) DAY as Date " +
			"    from (select 0 as a union all select 1 union all select 2 union all select 3 union all select 4 union all select 5 union all select 6 union all select 7 union all select 8 union all select 9) as a " +
			"    cross join (select 0 as a union all select 1 union all select 2 union all select 3 union all select 4 union all select 5 union all select 6 union all select 7 union all select 8 union all select 9) as b " +
			"    cross join (select 0 as a union all select 1 union all select 2 union all select 3 union all select 4 union all select 5 union all select 6 union all select 7 union all select 8 union all select 9) as c " +
			") a " +
			"where a.Date <= DATE_ADD(CURDATE(),INTERVAL 30 DAY);";
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			rs = stmt.executeQuery();
			while (rs.next()) {
				out = (rs.getString("fecha"));
				lista.add(out);
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
	
	public void insertar(Horario vo) throws DAOExcepcion {
		System.out.println("HorarioDAO: insertar(Horario vo)");
		String query = "INSERT INTO horario(fecha,horaInicio,horaFin,estado,Cancha_numCancha,Alquiler_codAlquiler) VALUES (STR_TO_DATE(?,'%d/%m/%Y'),?,?,?,?,?)";
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, vo.getFecha());
			stmt.setString(2, vo.getHoraInicio());
			stmt.setString(3, vo.getHoraFin());
			stmt.setString(4, vo.getEstado());
			stmt.setInt(5, vo.getoCancha().getNumCan());
			stmt.setInt(6, vo.getoAlquiler().getCodAlquiler());
			
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

	public Horario obtener(String codigoHorario) throws DAOExcepcion {
		System.out.println("HorarioDAO: obtener(String codigoHorario)");
		Horario vo = new Horario();
		Cancha ca = new Cancha();
		Alquiler al = new Alquiler();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			String query = "select fecha, horaInicio, horaFin, estado, Cancha_numCancha, Alquiler_codAlquiler from horario where codHorario=?";
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, codigoHorario);
			rs = stmt.executeQuery();
			if (rs.next()) {
				vo.setFecha(rs.getString(1));
				vo.setHoraInicio(rs.getString(2));
				vo.setHoraFin(rs.getString(3));
				vo.setEstado(rs.getString(4));
				ca.setNumCan(rs.getInt(5));
				vo.setoCancha(ca);
				al.setCodAlquiler(rs.getInt(6));
				vo.setoAlquiler(al);
				
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

	public void eliminar(String codigoHorario) throws DAOExcepcion {
		System.out.println("HorarioDAO: eliminar(String codigoHorario)");
		String query = "DELETE FROM horario WHERE codHorario=?";
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, codigoHorario);
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

	public void actualizar(Horario vo) throws DAOExcepcion {
		System.out.println("HorarioDAO: actualizar(Horario vo)");
		String query = "update horario set fecha=?, horaInicio=?, horaFin=?, estado=?, Cancha_numCancha=?, Alquiler_codAlquiler=? where codHorario=?";
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, vo.getFecha());
			stmt.setString(2, vo.getHoraInicio());
			stmt.setString(3, vo.getHoraFin());
			stmt.setString(4, vo.getEstado());
			stmt.setInt(5, vo.getoCancha().getNumCan());
			stmt.setInt(6, vo.getoAlquiler().getCodAlquiler());
			stmt.setInt(7, vo.getCodHorario());
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

	
	public Collection<Horario> listar() throws DAOExcepcion {
		System.out.println("HorarioDAO: listar()");
		Collection<Horario> c = new ArrayList<Horario>();
		Cancha ca = new Cancha();
		Alquiler al = new Alquiler();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			String query = "SELECT codHorario, fecha, horaInicio, horaFin, estado, Cancha_numCancha, Alquiler_codAlquiler from horario";
			stmt = con.prepareStatement(query);
			rs = stmt.executeQuery();
			while (rs.next()) {
				Horario vo = new Horario();
				vo.setCodHorario(rs.getInt("codHorario"));
				vo.setFecha(rs.getString("fecha"));
				vo.setHoraInicio(rs.getString("horaInicio"));
				vo.setHoraFin(rs.getString("horaFin"));
				vo.setEstado(rs.getString("estado"));
				ca.setNumCan(rs.getInt("Cancha_numCancha"));
				vo.setoCancha(ca);
				al.setCodAlquiler(rs.getInt("Alquiler_codAlquiler"));
				vo.setoAlquiler(al);
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
	
	private int getDia(String dia) {
		int idia = 0;
		if(dia.equals("LUN")) idia = 1;
		else if(dia.equals("MAR")) idia = 2;
		else if(dia.equals("MIE")) idia = 3;
		else if(dia.equals("JUE")) idia = 4;
		else if(dia.equals("VIE")) idia = 5;
		else if(dia.equals("SAB")) idia = 6;
		else if(dia.equals("DOM")) idia = 0;
		return idia;
	}

}

