<%@page import="java.util.Set"%>
<%@ page import="edu.ucam.modelos.Post"%>
<%@ include file="header.jsp"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%
	List<Post> posts2 = (List<Post>)request.getAttribute("posts");	
%>









	<div class="col-lg-8 mx-auto">		
		<article class="post">
		<h2>
			Entradas
		</h2>
		
		<a class="btn" href="post?edit=new">Nueva entrada</a>
		<section class="comentarios">				
			<table id="comentarios" class="display" width="100%"></table>
		</section>
		
		<hr />

		<section class="entradas">			
			<table id="entradas" class="display" width="100%" >
			 <tr>
			    <th>T�tulo</th>
			    <th>Eliminar</th>
			  </tr>
	<%
		if(posts2 == null) { %>
		<tr><td>Actualmente no hay entradas.</td><td></td></tr>	
	<%	} else {
			for (Post p : posts2) {
	%><tr><td><a href="post?edit=<%= p.getId()%>"><%= p.getTitulo()%></a></td><td><a href="post?del=<%= p.getId()%>">Eliminar</td></tr><%
		        }
			}
				%>
			
			</table>
			
		</section>		
	</div>


	
	


<%@ include file="../footer.jsp"%>