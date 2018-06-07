<%@page import="java.util.Set"%>
<%@ page import="edu.ucam.modelos.Comentarios"%>
<%@ include file="header.jsp"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%
	List<Comentarios> comentarios2 = (List<Comentarios>)request.getAttribute("comentarios");	
%>









	<div class="col-lg-8 mx-auto">		
		<article class="post">
		<h2>
			Comentarios
		</h2>
		
		<section class="comentarios">				
			<table id="comentarios" class="display" width="100%"></table>
		</section>
		
		<hr />

		<section class="entradas">			
			<table id="entradas" class="display" width="100%" >
			 <tr>
			    <th>Nombre</th>
			    <th>Email</th>
			    <th>Eliminar</th>
			  </tr>
	<%
		if(comentarios2 == null) { %>
		<tr><td>Actualmente no hay comentarios.</td><td></td></tr>	
	<%	} else {
			for (Comentarios c : comentarios2) {
	%><tr>
	<td><a href="comentarios?edit=<%= c.getId()%>"><%= c.getNombre()%></a></td>
	<td><a href="comentarios?edit=<%= c.getId()%>"><%= c.getEmail()%></a></td>
	<td><a href="comentarios?del=<%= c.getId()%>">Eliminar</td>
	</tr><%
		        }
			}
				%>
			
			</table>
			
		</section>		
	</div>


	
	


<%@ include file="../footer.jsp"%>