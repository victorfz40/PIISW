<%@page import="edu.ucam.modelos.Categorias"%>
<%@page import="java.util.Set"%>
<%@ page import="edu.ucam.modelos.Categorias"%>
<%@ include file="header.jsp"%>

<%
	Categorias categorias = (Categorias)request.getAttribute("categorias");
%>









	<div class="col-lg-8 mx-auto">		
		<article class="post">
		<h2>
			Categorias
		</h2>
		<section class="comentarios">				
			<table id="comentarios" class="display" width="100%"></table>
		</section>
		
		<hr />

		<section class="entradas">			


		<form action="categorias?edit=<%=request.getParameter("edit") %>" method="post" id="form">
		
		<div class="form-group">
		<label for="titulo">Categoria</label>
		<input type="text" class="form-control" id="nombre" name="nombre"  placeholder="Nobre de categoria" value="<%=categorias.getNombre() %>">
		</div>


	  
	  


		<button type="submit" class="btn btn-primary mb-2">OK</button>
		</form>

			
		</section>		
	</div>


	
	


<%@ include file="../footer.jsp"%>