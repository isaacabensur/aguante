package fulbito.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fulbito.exception.DAOExcepcion;
import fulbito.business.SeguridadNegocioPersona;

/**
 * Servlet implementation class SerRegCliente
 */
public class RegistroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistroServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		SeguridadNegocioPersona negocio = new SeguridadNegocioPersona();
		String tipoPer = request.getParameter("tipoPer");
		String nombres = request.getParameter("nombres");
		String paterno = request.getParameter("paterno");
		String materno = request.getParameter("materno");
		String sexo = request.getParameter("sexo");
		String tipoDoc = request.getParameter("tipoDoc");
		String numDoc = request.getParameter("numDoc");
		String correo = request.getParameter("correo");
		String correoconf = request.getParameter("correoconf");
		String password = request.getParameter("password");
		String passwordconf = request.getParameter("passwordconf");
		String dia = request.getParameter("dia");
		String mes = request.getParameter("mes");
		String anio = request.getParameter("anio");
		int celular = Integer.parseInt(request.getParameter("celular"));
		String fecNac = dia+"/"+mes+"/"+anio;
		String respuesta = "";
		try {
			if(correo.equals(correoconf)) {
				if(password.equals(passwordconf)) {
					respuesta = negocio.insertarPersona(tipoPer, nombres, paterno, materno, sexo, tipoDoc, numDoc, correo, password, fecNac, celular);
					request.setAttribute("MENSAJE", respuesta);
					RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
					rd.forward(request, response);
				} else {
					request.setAttribute("MENSAJE", "La contraseña y la confimación de la constraseña no son iguales.");
					RequestDispatcher rd = request.getRequestDispatcher("registro.jsp");
					rd.forward(request, response);
				}
			} else {
				request.setAttribute("MENSAJE", "El correo electrónico y la confimación del correo electrónico no son iguales.");
				RequestDispatcher rd = request.getRequestDispatcher("registro.jsp");
				rd.forward(request, response);
			}
		} catch (DAOExcepcion e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("MENSAJE", respuesta);
			RequestDispatcher rd = request.getRequestDispatcher("registro.jsp");
			rd.forward(request, response);
		}
	}

}
