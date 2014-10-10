package fulbito.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fulbito.exception.DAOExcepcion;
import fulbito.business.InsertarCancha;
import fulbito.business.SeguridadNegocioPersona;

/**
 * Servlet implementation class SerRegCliente
 */
public class RegistroCanchaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistroCanchaServlet() {
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
		InsertarCancha negocio = new InsertarCancha();
		int local = Integer.parseInt(request.getParameter("local"));
		String nombre = request.getParameter("nombre");
		String caracteristicas = request.getParameter("caracteristicas");
		String diasAtencion = request.getParameter("diasAtencion");
		String horasAtencion = request.getParameter("horasAtencion");
		double tarifaDiurna = Double.parseDouble(request.getParameter("tarifaDiurna"));
		double tarifaNocturna = Double.parseDouble(request.getParameter("tarifaNocturna"));
		String promo = request.getParameter("promo");
		String foto = request.getParameter("foto");
		String respuesta = "";
		//System.out.println("local="+local+" nombre="+nombre+" caracteristicas="+caracteristicas+" diasAtencion="+diasAtencion+" horasAtencion="+horasAtencion+" tarifaDiurna="+tarifaDiurna+" tarifaNocturna="+tarifaNocturna+" promo="+promo+" foto="+foto);
		try {
			
			respuesta = negocio.insertarCancha(nombre, caracteristicas, diasAtencion, horasAtencion, tarifaDiurna, tarifaNocturna, promo, foto, local);
			request.setAttribute("MENSAJE", respuesta);
			RequestDispatcher rd = request.getRequestDispatcher("index-duenio.jsp");
			rd.forward(request, response);
		} catch (DAOExcepcion e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("MENSAJE", respuesta);
			RequestDispatcher rd = request.getRequestDispatcher("cancha.jsp");
			rd.forward(request, response);
		}
		
		
	}

}
