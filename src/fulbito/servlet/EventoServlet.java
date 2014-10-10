package fulbito.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fulbito.exception.DAOExcepcion;
import fulbito.business.InsertarEvento;
/**
 * Servlet implementation class SerRegCliente
 */
public class EventoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EventoServlet() {
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
		InsertarEvento negocio = new InsertarEvento();
		
		String nombre = request.getParameter("nombre");
		String premio = request.getParameter("premio");
		int limiteCantidad = Integer.parseInt(request.getParameter("limiteCantidad"));
		String dia = request.getParameter("dia");
		String mes = request.getParameter("mes");
		String anio = request.getParameter("anio");
		int local = Integer.parseInt(request.getParameter("local"));
		String plazoInscripcion = dia+"/"+mes+"/"+anio;
		String respuesta = "";
		try {
			respuesta = negocio.insertarEvento(nombre, premio, limiteCantidad, plazoInscripcion, local);
			request.setAttribute("MENSAJE", respuesta);
			RequestDispatcher rd = request.getRequestDispatcher("index-duenio.jsp");
			rd.forward(request, response);
		} catch (DAOExcepcion e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("MENSAJE", respuesta);
			RequestDispatcher rd = request.getRequestDispatcher("evento.jsp");
			rd.forward(request, response);
		}
		
		
	}

}
