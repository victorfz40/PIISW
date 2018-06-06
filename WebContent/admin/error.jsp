<%@page import="java.util.Set"%>
<%@ page import="edu.ucam.modelos.Post"%>
<%@ include file="header.jsp"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%
	String ms=(String)request.getAttribute("msg");
%>


	<div class="col-lg-8 mx-auto">		
		<article class="post">
		<h2>
			Error
		</h2>
		
		<section class="comentarios">				
			
		</section>
		
		<hr />

		<section class="entradas">			
			<p><%=ms %></p>
		</section>		
	</div>



<%@ include file="../footer.jsp"%>