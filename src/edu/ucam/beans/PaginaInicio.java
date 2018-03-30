package edu.ucam.beans;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ucam.clases.Enlace;
import edu.ucam.vistas.Pagina;


@WebServlet(urlPatterns = { "/inicio" })
public class PaginaInicio extends HttpServlet {

       
    public PaginaInicio() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("recibido post en pagina de inicio");
		Pagina p=new Pagina();
		p.setTitulo("Página de inicio Blog ");
		
		
		ArrayList<Enlace> menu=new ArrayList<>();
		Enlace e1=new Enlace("texto1","inicio");
		Enlace e2=new Enlace("texto2","dos");
		menu.add(e1);
		menu.add(e2);
		p.setMenu(menu);
		
		p.crearPagina(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
