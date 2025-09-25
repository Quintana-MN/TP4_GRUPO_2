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
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        DaoSeguro dao = new DaoSeguro();

        if (request.getParameter("btnCargaTS") != null) {        	
        	// OBTENEMOS TODOS LOS TIPOS DE SEGUROS
        	ArrayList<tipoSeguro> listaTipoSeguros = dao.listarTipoSeguros();
        	request.setAttribute("listaTS", listaTipoSeguros);
        	
        	// OBTENEMOS PRIXIMO ID DE SEGURO
        	int proximoId  = dao.obtenerProximoIdSeguro();
        	request.setAttribute("proximoId", proximoId);
        }

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
        
        // MOSTRAMOS TODOS LOS SEGUROS UTILIZANDO HYPERLINK EN ListarSeguros.jsp
		if(request.getParameter("MostrarSeguros") != null) {
			ArrayList<seguroConDescTipo> lista = dao.listarSeguros();			
			request.setAttribute("listaS", lista);
			
			RequestDispatcher rd = request.getRequestDispatcher("/ListarSeguros.jsp");
			rd.forward(request, response);
		}

        // REQUESTDISPACHER
        RequestDispatcher rd = request.getRequestDispatcher("/AgregarSeguro.jsp");
        rd.forward(request, response);
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		if(request.getParameter("fitrarTabla") != null) {
			DaoSeguro daoSeg = new DaoSeguro();
			int idTipoSeguro = Integer.parseInt(request.getParameter("tipoSeguro"));
			ArrayList<seguroConDescTipo> listaFiltro = daoSeg.filtrarSeguros(idTipoSeguro);
			
			request.setAttribute("listaS", listaFiltro);
			
			RequestDispatcher rd = request.getRequestDispatcher("/ListarSeguros.jsp");
			rd.forward(request, response);				
		}		
	}

}
