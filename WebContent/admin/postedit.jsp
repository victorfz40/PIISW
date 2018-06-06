<%@page import="edu.ucam.modelos.Administradores"%>
<%@page import="java.util.Set"%>
<%@ page import="edu.ucam.modelos.Post"%>
<%@ include file="header.jsp"%>

<%
	Post post = (Post)request.getAttribute("post");	
	List<Administradores> administradores = (List<Administradores>)request.getAttribute("administradores");	
	List<Categorias> categorias = (List<Categorias>)request.getAttribute("categorias");	
%>









	<div class="col-lg-8 mx-auto">		
		<article class="post">
		<h2>
			Entrada
		</h2>
		<section class="comentarios">				
			<table id="comentarios" class="display" width="100%"></table>
		</section>
		
		<hr />

		<section class="entradas">			


		<form action="post?edit=<%=request.getParameter("edit") %>" method="post" id="form">
		
		<div class="form-group">
		<label for="titulo">Título</label>
		<input type="text" class="form-control" id="titulo" name="titulo"  placeholder="Título" value="<%=post.getTitulo() %>">
		</div>
		
	  <div class="form-group">
	    <label for="htmlCorto">HTML corto</label>
	    <textarea class="form-control" id="htmlCorto" name ="htmlCorto" rows="3"><%=post.getHtmlCorto() %></textarea>
	  </div>
	  
		
	  <div class="form-group">
	    <label for="html">HTML</label>
	    <textarea class="form-control" id="html" name ="html" rows="5"><%=post.getHtml() %></textarea>
	  </div>
		
	  <div class="form-group">
	    <label for="idCategoria">Categoria</label>
	    <select class="form-control" id="idCategoria" name ="idCategoria">
	    <%
	    for (Categorias c: categorias){
	    	%><option value="<%=c.getId()%>"><%=c.getNombre() %></option><% 
	    }
		if(post.getCategorias()!=null){
			%><option value="<%=post.getCategorias().getId()%>" selected="selected"><%=post.getCategorias().getNombre()%></option><%
		}
	    %>
		
	    </select>
	  </div>
	  
	  <div class="form-group">
	    <label for="idAdministrador">Usuario creador</label>
	    <select class="form-control" id="idAdministrador" name ="idAdministrador">
	    <%
	    for (Administradores a: administradores){
	    	%><option value="<%=a.getId()%>"><%=a.getUsuario() %></option><% 
	    }
		if(post.getAdministradores()!=null){
			%><option value="<%=post.getAdministradores().getId()%>" selected="selected"><%=post.getAdministradores().getUsuario()%></option><%
		}
	    %>
	    </select>
	  </div>
		
		
		<div class="form-group">
		<label for="fecha">Fecha</label>
		<input type="text" class="form-control" id="fecha" name="fecha"  placeholder="YYYY-MM-DD" value="<%= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(post.getFecha())  %>">
		</div>

		<button type="submit" class="btn btn-primary mb-2">OK</button>
		</form>

			
		</section>		
	</div>


	
	


<%@ include file="../footer.jsp"%>