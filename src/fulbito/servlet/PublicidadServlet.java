package fulbito.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fulbito.exception.DAOExcepcion;
import fulbito.model.Persona;
import fulbito.business.InsertarEvento;
import fulbito.business.SeguridadNegocioPublicidad;
import fulbito.business.SeguridadNegocioPersona;

/**
 * Servlet implementation class PublicidadServlet
 */
public class PublicidadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PublicidadServlet() {
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
		
		SeguridadNegocioPublicidad negocio = new SeguridadNegocioPublicidad();
		
		String titulo = request.getParameter("titulo");
		String contenido = request.getParameter("contenido");
		String diaInicio = request.getParameter("diaInicio");
		String mesInicio = request.getParameter("mesInicio");
		String anioInicio = request.getParameter("añoInicio");
		String diaFin = request.getParameter("diaFin");
		String mesFin = request.getParameter("mesFin");
		String anioFin = request.getParameter("añoFin");
		double tarifa = Double.parseDouble(request.getParameter("tarifa"));
		int clicks = Integer.parseInt(request.getParameter("clicks"));
		String seccion = request.getParameter("seccion");
		HttpSession sesion = request.getSession();
		Persona vo = (Persona)sesion.getAttribute("USUARIO_ACTUAL");
		int codPer = vo.getCodPer();
		String fecInicio = diaInicio+"/"+mesInicio+"/"+anioInicio;
		String fecFin = diaFin+"/"+mesFin+"/"+anioFin;
		String respuesta ="";
		try {
			respuesta = negocio.isertarPublicidad(titulo, contenido, fecInicio, fecFin, tarifa, clicks, seccion, codPer);
			request.setAttribute("MENSAJE", respuesta);
			RequestDispatcher rd = request.getRequestDispatcher("index-administrador.jsp");
			rd.forward(request, response);
		} catch (DAOExcepcion e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("MENSAJE", respuesta);
			RequestDispatcher rd = request.getRequestDispatcher("publicidad.jsp");
			rd.forward(request, response);
		}
		
		
	}

}
