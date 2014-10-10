package fulbito.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import fulbito.exception.DAOExcepcion;
import fulbito.model.Comentario;
import fulbito.util.ConexionBD;



public class ComentarioDAO extends BaseDAO {


	
public void insertar(Comentario vo) throws DAOExcepcion {
		System.out.println("ComentarioDAO: insertar(Comentario vo)");
		String query = "INSERT INTO comentario(texto,calificacion,nivel,Comentario_idComent,Persona_codPer,Cancha_numCancha) VALUES (?,?,?,?,?,?)";
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			
			stmt.setString(1, vo.getTexto());
			stmt.setInt(2, vo.getCalificacion());
			stmt.setInt(3, vo.getNivel());
			stmt.setInt(4, vo.getoComentario().getCodComent());
			stmt.setInt(5, vo.getoCliente().getCodPer());
			stmt.setInt(6, vo.getoCancha().getNumCan());
			
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


}

