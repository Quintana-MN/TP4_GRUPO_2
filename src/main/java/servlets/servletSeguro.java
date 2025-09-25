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
import dominio.tipoSeguro;


@WebServlet("/servletSeguro")
public class servletSeguro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public servletSeguro() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        DaoSeguro dao = new DaoSeguro();

        // OBTENEMOS TODOS LOS TIPOS DE SEGUROS
        ArrayList<tipoSeguro> listaTipoSeguros = dao.listarTipoSeguros();
        request.setAttribute("listaTS", listaTipoSeguros);
        
        // OBTENEMOS PRIXIMO ID DE SEGURO
        int proximoId  = dao.obtenerProximoIdSeguro();
        request.setAttribute("proximoId", proximoId);

        if (request.getParameter("btnAceptar") != null) {
            String descripcion = request.getParameter("txtDescripcion");
            String tipoSeguroStr = request.getParameter("tipoSeguro");
            String contratacionStr = request.getParameter("txtContratacion");
            String costoAsegStr = request.getParameter("txtCostoAseg");

            Seguro seguro = new Seguro();
            seguro.setDescripcion(descripcion);
            seguro.setIdTipoSeguro(Integer.parseInt(tipoSeguroStr));
            seguro.setCostoContratacion(Double.parseDouble(contratacionStr.replace(",", ".")));
            seguro.setCostoMaximoAsegurado(Double.parseDouble(costoAsegStr.replace(",", ".")));

            int filas = dao.agregarSeguro(seguro);

            request.setAttribute("cantFilas", filas);
        }

        // REQUESTDISPACHER
        RequestDispatcher rd = request.getRequestDispatcher("/AgregarSeguro.jsp");
        rd.forward(request, response);
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
		
		
		DaoSeguro daoSeg = new DaoSeguro();
		ArrayList<seguroConDescTipo> lista= daoSeg.listarSeguros();
		
		request.setAttribute("listaSegurosConDescripcion", lista);
		
		RequestDispatcher rd = request.getRequestDispatcher("/ListarSeguros.jsp");
		rd.forward(request, response);
		
		if(request.getParameter("fitrarTabla")!=null)
		{
			int Filas = Integer.parseInt(request.getParameter("tipoSeguro"));
			ArrayList<seguroConDescTipo> listaFiltro = daoSeg.filtrarSeguros(Filas);
			
			request.setAttribute("filtroU",listaFiltro);
			
			rd = request.getRequestDispatcher("/ListarSeguros.jsp");
			rd.forward(request, response);
		}
		
	}

}
