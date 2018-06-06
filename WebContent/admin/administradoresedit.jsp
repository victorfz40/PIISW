<%@page import="edu.ucam.modelos.Administradores"%>
<%@page import="java.util.Set"%>
<%@ page import="edu.ucam.modelos.Post"%>
<%@ include file="header.jsp"%>

<%
	Administradores administradores = (Administradores)request.getAttribute("administradores");
%>









	<div class="col-lg-8 mx-auto">		
		<article class="post">
		<h2>
			Administrador
		</h2>
		<section class="comentarios">				
			<table id="comentarios" class="display" width="100%"></table>
		</section>
		
		<hr />

		<section class="entradas">			


		<form action="administradores?edit=<%=request.getParameter("edit") %>" method="post" id="form">
		
		<div class="form-group">
		<label for="titulo">Usuario</label>
		<input type="text" class="form-control" id="usuario" name="usuario"  placeholder="Nobre de usuario" value="<%=administradores.getUsuario() %>">
		</div>

	  
		<div class="form-group">
		<label for="titulo">Email</label>
		<input type="text" class="form-control" id="email" name="email"  placeholder="Email" value="<%=administradores.getEmail() %>">
		</div>

	  
		<div class="form-group">
		<label for="titulo">Contraseña</label>
		<input type="password" class="form-control" id="password" name="password"  placeholder="password" value="">
		</div>

	  
	  


		<button type="submit" class="btn btn-primary mb-2">OK</button>
		</form>

			
		</section>		
	</div>


	
	


<%@ include file="../footer.jsp"%>