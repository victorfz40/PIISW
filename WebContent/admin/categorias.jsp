<%@page import="java.util.Set"%>
<%@ page import="edu.ucam.modelos.Categorias"%>
<%@ include file="header.jsp"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%
	List<Categorias> categorias2 = (List<Categorias>)request.getAttribute("categorias");	
%>









	<div class="col-lg-8 mx-auto">		
		<article class="post">
		<h2>
			Entradas
		</h2>
		
		<a class="btn" href="categorias?edit=new">Nueva categoria</a>
		<section class="comentarios">				
			<table id="comentarios" class="display" width="100%"></table>
		</section>
		
		<hr />

		<section class="entradas">			
			<table id="entradas" class="display" width="100%" >
			 <tr>
			    <th>Título</th>
			    <th>Eliminar</th>
			  </tr>
	<%
		if(categorias2 == null) { %>
		<tr><td>Actualmente no hay categorias.</td><td></td></tr>	
	<%	} else {
			for (Categorias c : categorias2) {
	%><tr><td><a href="categorias?edit=<%= c.getId()%>"><%= c.getNombre()%></a></td><td><a href="categorias?del=<%= c.getId()%>">Eliminar</td></tr><%
		        }
			}
				%>
			
			</table>
			
		</section>		
	</div>


	
	


<%@ include file="../footer.jsp"%>