<%@page import="java.util.Set"%>
<%@page import="edu.ucam.modelos.Post"%>
<%@ include file="header.jsp"%>
<%
	//String posts = (String) request.getAttribute("entradas");
	//String comentarios = (String) request.getAttribute("comentarios");
	
%>

	<div class="col-lg-8 mx-auto">		
		<article class="post">
		<h2>
			Últimos comentarios
		</h2>
		<section class="comentarios">				
			<table id="comentarios" class="display" width="100%"></table>
		</section>
		
		<hr />

		<h2>
			Últimas entradas
		</h2>
		
		<section class="entradas">			
			<table id="entradas" class="display" width="100%"></table>
		</section>		
	</div>
	<div id="#contenido">
	
	</div>
	
	
	<script>
		
		//$(document).ready(function() {
			
			

			
			/*$(document).ready(function(){
			    $("#Post").click(function(){
			        $("#contenido").load("/admin/index?action=Post");
			    });
			});
			
			

			debugger;*/
			/*
			
			/*var entradas = [
				{ "id": "25", "titulo": "titulo del post", "htmlCorto": "html corto", "fecha": "fecha" },
				  { "id": "25", "titulo": "titulo del post", "htmlCorto": "html corto", "fecha": "fecha" },
				  { "id": "25", "titulo": "titulo del post", "htmlCorto": "html corto", "fecha": "fecha" }
				];*/
			//var entradas = { "id": "25", "titulo": "titulo del posy", "htmlCorto": "html corto", "fecha": "fecha" };
			
			/*var entradas =
			{
					 "Result":"OK",
					   "Records":
						   [
							{ "id": "25", "titulo": "titulo del post", "htmlCorto": "html corto", "fecha": "fecha" },
							  { "id": "25", "titulo": "titulo del post", "htmlCorto": "html corto", "fecha": "fecha" },
							  { "id": "25", "titulo": "titulo del post", "htmlCorto": "html corto", "fecha": "fecha" }
					   ]
					};

			 $('#entradas').DataTable( {
			        data:entradas,
			        columns: [
			            { title: "id" },
			            { title: "titulo" },
			            { title: "htmlCorto" },
			            { title: "fecha" }
			        ]
			    } );*/

			/* $('#comentarios').DataTable( {
			        data: comentarios,
			        columns: [
			            { title: "id" },
			            { title: "idpost" },
			            { title: "email" },
			            { title: "nombre" },
			            { title: "comentario" }
			        ]
			    } );*/
			
		//});
	
	</script>
	
	


<%@ include file="../footer.jsp"%>