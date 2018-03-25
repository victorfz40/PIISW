package edu.ucam.beans;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ucam.vistas.Pagina;


@WebServlet(urlPatterns = { "/" })
public class PaginaInicio extends HttpServlet {

       
    public PaginaInicio() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("recibido post en pagina de inicio");
		Pagina p=new Pagina();
		p.crearPagina(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
