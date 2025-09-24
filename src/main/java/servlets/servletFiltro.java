package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.DaoSeguro;
import dominio.Seguro;
import dominio.seguroConDescTipo;

@WebServlet("/servletFiltro")
public class servletFiltro extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public servletFiltro() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("fitrarTabla")!=null)
		{
			DaoSeguro daoSeg = new DaoSeguro();
			int tipoFilas = Integer.parseInt(request.getParameter("tipoSeguro"));
			ArrayList<seguroConDescTipo> listaFiltro = daoSeg.filtrarSeguros(tipoFilas);
			
			request.setAttribute("filtroU",listaFiltro);
			
			RequestDispatcher rd = request.getRequestDispatcher("/ListarSeguros.jsp");
			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}