package fulbito.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fulbito.exception.DAOExcepcion;
import fulbito.exception.LoginExcepcion;
import fulbito.model.Persona;
import fulbito.business.SeguridadNegocioPersona;

/**
 * Servlet implementation class for Servlet: LoginServlet
 * 
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends javax.servlet.http.HttpServlet implements
		javax.servlet.Servlet {
	static final long serialVersionUID = 1L;

	/*
	 * (non-Java-doc)
	 * 
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
	}

	/*
	 * (non-Java-doc)
	 * 
	 * @see javax.servlet.http.HttpServlet#doGet(HttpServletRequest request,
	 *      HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/*
	 * (non-Java-doc)
	 * 
	 * @see javax.servlet.http.HttpServlet#doPost(HttpServletRequest request,
	 *      HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String correo = request.getParameter("correo");
		String password = request.getParameter("password");

		SeguridadNegocioPersona negocio = new SeguridadNegocioPersona();

		try {
			Persona vo = negocio.validarPersona(correo, password);
			String tipoPer = vo.getTipoPer();
			if (tipoPer!=null) {
				//si el tipo es igual a 1, es administrador,si es 2 es un cliente
				HttpSession session = request.getSession();
				session.setAttribute("USUARIO_ACTUAL", vo);
				if(tipoPer.equals("dueno")) response.sendRedirect("index-duenio.jsp");
				else if(tipoPer.equals("cliente")) response.sendRedirect("index-cliente.jsp");
				else if(tipoPer.equals("admin")) response.sendRedirect("index-administrador.jsp");
			} else {
				RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
				rd.forward(request, response);	
			}
		} catch (DAOExcepcion e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("MENSAJE", "Correo o contraseña inválido.");
			RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
			rd.forward(request, response);
		}

	}
}