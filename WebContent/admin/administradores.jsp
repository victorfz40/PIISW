<%@page import="java.util.Set"%>
<%@ page import="edu.ucam.modelos.Administradores"%>
<%@ include file="header.jsp"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%
	List<Administradores> administradores2 = (List<Administradores>)request.getAttribute("administradores");	
%>









	<div class="col-lg-8 mx-auto">		
		<article class="post">
		<h2>
			Entradas
		</h2>
		
		<a class="btn" href="administradores?edit=new">Nueva entrada</a>
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
		if(administradores2 == null) { %>
		<tr><td>Actualmente no hay usuarios.</td><td></td></tr>	
	<%	} else {
			for (Administradores a : administradores2) {
	%><tr><td><a href="administradores?edit=<%= a.getId()%>"><%= a.getUsuario()%></a></td><td><a href="administradores?del=<%= a.getId()%>">Eliminar</td></tr><%
		        }
			}
				%>
			
			</table>
			
		</section>		
	</div>


	
	


<%@ include file="../footer.jsp"%>