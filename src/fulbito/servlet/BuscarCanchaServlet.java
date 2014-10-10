package fulbito.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fulbito.exception.DAOExcepcion;
import fulbito.model.Cancha;
import fulbito.business.InsertarCancha;
import fulbito.business.SeguridadNegocioCancha;
import fulbito.business.SeguridadNegocioPersona;

/**
 * Servlet implementation class SerRegCliente
 */
public class BuscarCanchaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuscarCanchaServlet() {
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
		SeguridadNegocioCancha negocio = new SeguridadNegocioCancha();
		Collection<Cancha> canchas = new ArrayList<Cancha>();
		//int local = Integer.parseInt(request.getParameter("local"));
		String distrito = request.getParameter("distrito");
		String diasAtencion = request.getParameter("diasAtencion");
		//String mes = request.getParameter("mes");
		//String anio = request.getParameter("anio");
		String horasAtencion = request.getParameter("horasAtencion");
		request.setAttribute("distrito",distrito);
		request.setAttribute("diasAtencion",diasAtencion);
		request.setAttribute("horasAtencion",horasAtencion);
		//System.out.println("distrito:"+distrito+" diasAtencion:"+diasAtencion+" horasAtencion:"+horasAtencion);
		//double tarifaNocturna = Double.parseDouble(request.getParameter("tarifaNocturna"));
		//String promo = request.getParameter("promo");
		//String foto = request.getParameter("foto");
		try {
			canchas = negocio.BuscarCanchaFulbito(distrito, diasAtencion, horasAtencion);
			request.setAttribute("listaCanchas", canchas);
			//request.setAttribute("MENSAJE", "ERROR NO SE INSERTO");
			//response.sendRedirect(request.getContextPath() + "alquilarcancha.jsp");
			RequestDispatcher rd = request.getRequestDispatcher("alquilarcancha.jsp");
			rd.forward(request, response);
		} catch (DAOExcepcion e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("MENSAJE", "No se encontraron datos.");
			RequestDispatcher rd = request.getRequestDispatcher("alquilarcancha.jsp");
			rd.forward(request, response);
		}
		
		
	}

}
