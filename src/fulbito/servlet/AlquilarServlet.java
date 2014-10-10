package fulbito.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fulbito.business.SeguridadNegocioHorario;
import fulbito.exception.DAOExcepcion;
import fulbito.model.Cancha;
import fulbito.model.Horario;

/**
 * Servlet implementation class sercerrarsesion
 */
public class AlquilarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AlquilarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession sesion = request.getSession();
		sesion.invalidate();
		response.sendRedirect("index.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String numCancha = request.getParameter("numCancha");
		String nomCancha = request.getParameter("nomCan");
		String caracCancha = request.getParameter("caracCan");
		String tarifaDiurna = request.getParameter("tarifaDiurna");
		String tarifaNocturna = request.getParameter("tarifaNocturna");
		String nomLocal = request.getParameter("nomLocal");
		String promocion = request.getParameter("promocion");
		String foto = request.getParameter("foto");
		String diasAtencion = request.getParameter("diasAtencion");
		
		int idia = 0;
		if(diasAtencion.equals("LUN")) idia = 1;
		else if(diasAtencion.equals("MAR")) idia = 2;
		else if(diasAtencion.equals("MIE")) idia = 3;
		else if(diasAtencion.equals("JUE")) idia = 4;
		else if(diasAtencion.equals("VIE")) idia = 5;
		else if(diasAtencion.equals("SAB")) idia = 6;
		else if(diasAtencion.equals("DOM")) idia = 0;
		//String mes = request.getParameter("mes");
		//String anio = request.getParameter("anio");
		String horasAtencion = request.getParameter("horasAtencion");
		String horaInicio = horasAtencion.substring(0,4);
		String horaFin = horasAtencion.substring(5);
		SeguridadNegocioHorario negocio = new SeguridadNegocioHorario();
		Collection<Horario> horarios = new ArrayList<Horario>();
		try {
			Collection<String> lista =  negocio.obtenerDiasSemana();
			//Collection<Horario> horarios =  negocio.buscarPorDiaHoras(diasAtencion, horaInicio, horaFin);
			for(String x: lista) {
				String fecha = (String)x;
				String[] arrFecha = fecha.split(" ");
				if(arrFecha[0].equals(idia)) {
					Horario horario = new Horario();
					horario.setFecha(arrFecha[1]);
					horario.setHoraInicio(horaInicio);
					horario.setHoraFin(horaFin);
					horarios.add(horario);
				}
			}
			//request.setAttribute("listaCanchas", canchas);
			//request.setAttribute("MENSAJE", "ERROR NO SE INSERTO");
			//response.sendRedirect(request.getContextPath() + "alquilarcancha.jsp");
			request.setAttribute("numCancha", numCancha);
			request.setAttribute("nomCancha", nomCancha);
			request.setAttribute("caracCancha", caracCancha);
			request.setAttribute("tarifaDiurna", tarifaDiurna);
			request.setAttribute("tarifaNocturna", tarifaNocturna);
			request.setAttribute("nomCancha", nomCancha);
			request.setAttribute("nomLocal", nomLocal);
			request.setAttribute("promocion", promocion);
			request.setAttribute("foto", foto);
			request.setAttribute("listaHorarios", horarios);
			//request.setAttribute("MENSAJE", "ERROR NO SE INSERTO");
			//response.sendRedirect(request.getContextPath() + "alquilarcancha.jsp");
			RequestDispatcher rd = request.getRequestDispatcher("teofilo.jsp");
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
