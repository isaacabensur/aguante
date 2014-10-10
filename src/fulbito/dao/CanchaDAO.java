package fulbito.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import fulbito.exception.DAOExcepcion;
import fulbito.model.Cancha;
import fulbito.model.Horario;
import fulbito.model.Local;
import fulbito.util.ConexionBD;



public class CanchaDAO extends BaseDAO {


	
public int insertar(Cancha vo) throws DAOExcepcion {
		System.out.println("CanchaDAO: insertar(Cancha vo)");
		String query = "INSERT INTO cancha(nombre,caracteristicas,diasAtencion,horasAtencion,tarifaDiurna,tarifaNocturna,promo,foto,Local_codLoc) VALUES (?,?,?,?,?,?,?,?,?)";
		Connection con = null;
		PreparedStatement stmt = null;
		int state = 0;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			
			stmt.setString(1, vo.getNombre());
			stmt.setString(2, vo.getCaracteristicas());
			stmt.setString(3, vo.getDiasAtencion());
			stmt.setString(4, vo.getHorasAtencion());
			stmt.setDouble(5, vo.getTarifaDiurna());
			stmt.setDouble(6, vo.getTarifaNocturna());
			stmt.setString(7, vo.getPromo());
			stmt.setString(8, vo.getFoto());
			//stmt.setString(8, vo.getDisponible());
			stmt.setInt(9, vo.getoLocal().getCodLoc());
			
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

public Collection<Cancha> buscarcanchafulbito(String distrito, String diasAtencion, String horasAtencion) throws DAOExcepcion {
	System.out.println("CanchaDAO: buscarcanchafulbito(String distrito, String diasAtencion, String horasAtencion)");
	String query = "select a.numCancha, a.nombre, a.caracteristicas, a.diasAtencion, a.horasAtencion, a.tarifaDiurna, a.tarifaNocturna, a.promo, a.foto, a.Local_codLoc, b.distrito from cancha a, local b where a.Local_codLoc = b.codLoc and b.distrito like ? and a.diasAtencion like ? and a.horasAtencion like ? ";
	Collection<Cancha> lista = new ArrayList<Cancha>();
	//Collection<Horario> horarios = new ArrayList<Horario>();
	HorarioDAO hdao = new HorarioDAO();
	Connection con = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;
	String horaInicio = horasAtencion.substring(0,4);
	String horaFin = horasAtencion.substring(5);
	try {
		
		con = ConexionBD.obtenerConexion();
		stmt = con.prepareStatement(query);
		stmt.setString(1, "%" + distrito + "%");
		stmt.setString(2, "%" + diasAtencion + "%");
		stmt.setString(3, "%" + horasAtencion + "%");
		rs = stmt.executeQuery();
		while (rs.next()) {
			Cancha vo = new Cancha();
			Local _vo = new Local();
			Collection<Horario> horarios = new ArrayList<Horario>();
			Horario voH = new Horario();
			vo.setNumCan(rs.getInt("numCancha"));
			vo.setNombre(rs.getString("nombre"));
			vo.setCaracteristicas(rs.getString("caracteristicas"));
			String dAtencion = rs.getString("diasAtencion");
			dAtencion = dAtencion.replaceAll(",", " ");
			vo.setDiasAtencion(dAtencion);
			String[] hAtencion = rs.getString("horasAtencion").split(",");
			//hAtencion = hAtencion.replaceAll(",", " ");
			String atencion = "";
			for(int i=0; i<hAtencion.length;i++) {
				//atencion = "";
				//System.out.println(hAtencion[i]);
				for(int j=0; j<hAtencion[i].length();j++) {
					//if(i%8 == 0 && i>0) atencion += " "+hAtencion[i].charAt(i);
					if(j==hAtencion[i].length()-1) atencion += hAtencion[i].charAt(j)+" ";
					else if(j%4 == 0 && j>0) atencion += "-"+hAtencion[i].charAt(j);
					else if(j%2 == 0 && j>0) atencion += ":"+hAtencion[i].charAt(j);
					else atencion += hAtencion[i].charAt(j);
				}
			}
			vo.setHorasAtencion(atencion);
			vo.setTarifaDiurna(rs.getDouble("tarifaDiurna"));
			vo.setTarifaNocturna(rs.getDouble("tarifaNocturna"));
			vo.setPromo(rs.getString("promo"));
			vo.setFoto(rs.getString("foto"));
			//vo.setDisponible(rs.getString("disponible"));
			//voH.setEstado("Disponible");
			//horarios.add(voH);
			horarios = hdao.buscarPorDiaHoras(diasAtencion, horaInicio, horaFin);
			_vo.setCodLoc(rs.getInt("Local_codLoc"));
			_vo.setDistrito(rs.getString("distrito"));
			vo.setHorarios(horarios);
			vo.setoLocal(_vo);
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

