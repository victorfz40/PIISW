<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="edu.ucam.modelos.Categorias"%>
<%@page import="edu.ucam.clases.Enlace"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import=" edu.ucam.modelos.Post"%>
	
<%
	ArrayList<Enlace> menu = (ArrayList<Enlace>)request.getAttribute("menu");
	List<Categorias> cats = (List<Categorias>)request.getAttribute("categorias");
%>
	
<!DOCTYPE html>
<html dir="ltr" lang="en-US">
<head>
	<!-- Created by Artisteer v4.3.0.60745 -->
	<meta charset="utf-8">
	<title>
		<%
			out.print(request.getAttribute("titulo"));
		%>
	</title>
	<meta name="viewport"
		content="initial-scale = 1.0, maximum-scale = 1.0, user-scalable = no, width = device-width">	
	<!--[if lt IE 9]><script src="https://html5shiv.googlecode.com/svn/trunk/html5.js"></script><![endif]-->
	<link rel="stylesheet" href="css/style.css" media="screen">
	<!--[if lte IE 7]><link rel="stylesheet" href="css/style.ie7.css" media="screen" /><![endif]-->
	<link rel="stylesheet" href="css/style.responsive.css" media="all">	
	<script src="js/jquery.js"></script>
	<script src="js/script.js"></script>
<script src="js/script.responsive.js"></script>
</head>
<body>
	<div id="main">
		<div class="sheet clearfix">
			<header class="header">

				<div class="shapes"></div>

				<h1 class="headline">
					<a href="/">CALIDAD Y RENTABILIDAD,</a>
				</h1>
				<h2 class="slogan">PROFESIONALES</h2>

				<nav class="nav">
					<ul class="hmenu">
						<%
							for (Enlace e : menu) {
						%><li><a href="<%out.print(e.getVinculo());%>" class="">
								<%
									out.print(e.getTexto());
								%>
						</a></li>
						<%
							}
						%>
					</ul>
				</nav>
			</header>
			<div class="layout-wrapper">
				<div class="content-layout">
					<div class="content-layout-row">
						<div class="layout-cell sidebar1">
							<div class="block clearfix">
								<div class="blockheader">
									<h3 class="t">Categories</h3>
								</div>
								<div class="blockcontent">
									<div>
										<ul>
											<%
												for (Categorias e : cats) {
											%>
											<li><a
												href="/listadoCategoria.jsp?id=<%out.print(e.getId());%>"
												title="<%out.print(e.getNombre());%>">
													<%
														out.print(e.getNombre());
													%>
											</a></li>
											<%
												}
											%>
										</ul>
									</div>
								</div>
							</div>
						</div>