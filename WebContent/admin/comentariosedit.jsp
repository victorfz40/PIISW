<%@page import="edu.ucam.modelos.Administradores"%>
<%@page import="java.util.Set"%>
<%@ page import="edu.ucam.modelos.Comentarios"%>
<%@ include file="header.jsp"%>

<%
	Comentarios comentarios = (Comentarios)request.getAttribute("comentarios");	
%>









	<div class="col-lg-8 mx-auto">		
		<article class="post">
		<h2>
			Comentario
		</h2>
		<section class="comentarios">				
			<table id="comentarios" class="display" width="100%"></table>
		</section>
		
		<hr />

		<section class="entradas">			


		<form action="comentarios?edit=<%=request.getParameter("edit") %>" method="post" id="form">
		
		<div class="form-group">
		<label for="titulo">Nombre</label>
		<input type="text" class="form-control" id="nombre" name="nombre"  placeholder="Nombre" value="<%=comentarios.getNombre() %>">
		</div>
		
		<div class="form-group">
		<label for="titulo">Email</label>
		<input type="text" class="form-control" id="email" name="email"  placeholder="Título" value="<%=comentarios.getEmail() %>">
		</div>
		
	  <div class="form-group">
	    <label for="htmlCorto">Comentario</label>
	    <textarea class="form-control" id="comentario" name ="comentario" rows="5"><%=comentarios.getComentario() %></textarea>
	  </div>
	  
		

		

	  

		
		
		<div class="form-group">
		<label for="fecha">Fecha</label>
		<input type="text" class="form-control" id="fecha" name="fecha"  placeholder="YYYY-MM-DD" value="<%= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(comentarios.getFecha())  %>">
		</div>

		<button type="submit" class="btn btn-primary mb-2">OK</button>
		</form>

			
		</section>		
	</div>


	
	


<%@ include file="../footer.jsp"%>