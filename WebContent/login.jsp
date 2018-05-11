<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="edu.ucam.modelos.Categorias"%>
<%@page import="edu.ucam.clases.Enlace"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import=" edu.ucam.modelos.Post"%>
	
<%
	String titulo = (String) request.getAttribute("titulo");
	String empresa = (String) request.getAttribute("empresa");
	Enlace[] menu = (Enlace[])request.getAttribute("menu");
%>	
<!DOCTYPE html>
<html lang="es">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    
    <title><%=titulo %></title>

    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href='https://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>
    <link href="css/clean-blog.css" rel="stylesheet">
  </head>

  <body>

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
    
<div class="row">
	<div class="col-8 offset-2 col-lg-2 offset-lg-5 col-md-4 offset-sm-4 col-sm-6 offset-sm-3">
		<h1>Login de usuario</h1>
		<form action="login" method="post">
			 <div class="form-group">
			    <label for="email">Email</label>
			    <input type="email" class="form-control" id="email" />    
			  </div>
			  <div class="form-group">
			    <label for="password">Password</label>
			    <input type="password" class="form-control" id="password" />
			  </div>
			
			  <button type="submit" class="btn btn-primary">Entrar</button>
		  </form>
	</div>
</div>


<%@ include file="footer.jsp" %>