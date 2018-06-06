<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="edu.ucam.modelos.Categorias"%>
<%@page import="edu.ucam.clases.Enlace"%>
<%@page import="java.text.SimpleDateFormat"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import=" edu.ucam.modelos.Post"%>
	
<%
	String titulo = (String) request.getAttribute("titulo");
	String empresa = (String) request.getAttribute("empresa");
	Enlace[] menu = (Enlace[])request.getAttribute("menu");
	Enlace[] enlaces = (Enlace[])request.getAttribute("enlaces");
	
	String msg = (String) session.getAttribute("msg");
	if(msg == null) {
		msg = "";
	} else {
		session.removeAttribute("msg");
	}
%>	
<!DOCTYPE html>
<html lang="es">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    
    <title><%=titulo %></title>
	<script
			  src="https://code.jquery.com/jquery-3.3.1.min.js"
			  integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
			  crossorigin="anonymous"></script>
    <link href="../vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="../vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="https://cdn.datatables.net/1.10.16/css/jquery.dataTables.min.css" type="text/css">
    <link href='https://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>
    <link href="../css/clean-blog.css" rel="stylesheet">
    <script src="../js/jquery.datatable.js"></script>
  </head>

  <body class="admin">

    <!-- Navigation -->
    <nav class="navbar navbar-expand-lg navbar-light fixed-top" id="mainNav">
      <div class="container">
        <a class="navbar-brand" href="inicio"><%=empresa %></a>
        <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
          Menu
          <i class="fa fa-bars"></i>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
          <ul class="navbar-nav ml-auto">
          	<%
				for (Enlace e : menu) {
			%><li class="nav-item"><a class="nav-link" href="<%=e.getVinculo() %>"><%=e.getTexto() %></a></li>
			<%
				}
			%>          
          </ul>
        </div>
      </div>
    </nav>

    <header class="masthead" style="background-image: url('img/home-bg.jpg')">
      <div class="overlay"></div>
      <div class="container">
        <div class="row">
          <div class="col-lg-8 col-md-10 mx-auto">
            <div class="site-heading">
              <h1>Blog de Lorem Ipsum</h1>
              <span class="subheading">Creado por <%=empresa %></span>
            </div>
          </div>
        </div>
      </div>
    </header>
    
    <div class="container">
    <%
    	if(msg != "") {
    %>
    <div class="alert alert-primary" role="alert">
	  <%=msg %>
	</div>
    <% } %>
    	<div class="row">
    		<div class="col-lg-3">
		    	<section class="categories">
		        	<h3>Administrar</h3>
		        	<nav>
			            <ul class="nav flex-column">
		             		<%
								for (Enlace e : enlaces) {
							%><li class="nav-item"><a id="<%=e.getTexto() %>" class="nav-link" href="<%=e.getVinculo() %>"><%=e.getTexto() %></a></li>
							<%
								}
							%>          
			            </ul>
		            </nav>
		    	</section>
		    </div>    