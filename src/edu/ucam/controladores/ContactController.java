package edu.ucam.controladores;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



@WebServlet(urlPatterns = { "/contact" })
public class ContactController extends MainController {
	private static final long serialVersionUID = 1933599531034509234L;
	
    public ContactController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Contacto");
		
		getBlocks(request, response, false);		
		request.setAttribute("titulo", prop.getProperty("Formulario de contacto"));		
		request.getRequestDispatcher("/contact.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("nombre");
		String email = request.getParameter("email");
		String comentario= request.getParameter("comentario");
		HttpSession sesionHttp = request.getSession();
		Properties props = new Properties();
		props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(prop.getProperty("contact.email"), prop.getProperty("contact.password"));
            }
          });
		System.out.println(name +"-"+email+"-"+comentario);
		
		try {
		  Message msg = new MimeMessage(session);
		  msg.setFrom(new InternetAddress(email, name));
		  msg.addRecipient(Message.RecipientType.TO,
		                   new InternetAddress(prop.getProperty("contact.email"), prop.getProperty("empresa") + " - contacto"));
		  msg.setSubject(name + " ha mandado un nuevo mensaje");
		  msg.setText(comentario);
		  Transport.send(msg);
		  sesionHttp.setAttribute("msg", "Se ha enviado el mensaje correctamente. Gracias por contactar con nosotros.");
		} catch (Exception e) {
			System.out.println(e);
			sesionHttp.setAttribute("msg", "En un principio el correo se hubiese mandado si se hubiera configurado una cuenta smtp para el envío.");
		}
		getBlocks(request, response, false);		
		request.setAttribute("titulo", prop.getProperty("Formulario de contacto"));		
		request.getRequestDispatcher("/contact.jsp").forward(request, response);
		
	}
}
