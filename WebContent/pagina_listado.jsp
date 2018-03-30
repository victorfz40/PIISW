<%@page import="edu.ucam.clases.Enlace"%>
<%@page import="edu.ucam.vistas.PaginaListado"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="edu.ucam.beans.User, edu.ucam.beans.Login, edu.ucam.clases.Post"%>
    
    
    
<!DOCTYPE html>
<html dir="ltr" lang="en-US"><head>
    <meta charset="utf-8">
    <title><% out.print(((PaginaListado)request.getAttribute("pagina")).getTitulo() ); %></title>
    <meta name="viewport" content="initial-scale = 1.0, maximum-scale = 1.0, user-scalable = no, width = device-width">

    <!--[if lt IE 9]><script src="https://html5shiv.googlecode.com/svn/trunk/html5.js"></script><![endif]-->
    <link rel="stylesheet" href="style.css" media="screen">
    <!--[if lte IE 7]><link rel="stylesheet" href="style.ie7.css" media="screen" /><![endif]-->
    <link rel="stylesheet" href="style.responsive.css" media="all">


    <script src="jquery.js"></script>
    <script src="script.js"></script>
    <script src="script.responsive.js"></script>


</head>
<body>
<div id="main">
    <div class="sheet clearfix">
<header class="header">

    <div class="shapes">
        
            </div>

<h1 class="headline">
    <a href="/">QUALITY, RELIABILITY,</a>
</h1>
<h2 class="slogan">Soluciones integrales</h2>





<nav class="nav">
    <ul class="hmenu">
    <% 
    for (Enlace e :((PaginaListado)request.getAttribute("pagina")).getMenu() )  {
    	%><li><a href="<% out.print(e.getVinculo()); %>" class=""><% out.print(e.getTexto()); %></a></li><%
    }
    %>    
    </ul> 
</nav>

                    
</header>
<div class="layout-wrapper">
                <div class="content-layout">
                    <div class="content-layout-row">
                        <div class="layout-cell content">
                        
<% for (Post p :((PaginaListado)request.getAttribute("pagina")).getContenido() )  { 
	%>
<article class="post article">
                                <h2 class="postheader"><a href="Blog Posts/publicar-2.html"><% out.print(p.getTitulo()); %></a>
                                </h2>

                <div class="postcontent postcontent-0 clearfix">
<% out.print(p.getContenidoComienzo()); %>

<br><a href="Blog Posts/publicar-2.html">Leer más</a>
                </div>
                                <div class="postfootericons metadata-icons">
                    <span class="postcategoryicon">Category: No Category</span>
                     | <span class="posttagicon">Tags: <a href="#" title="link">link</a>, <a href="#" title="visited link" class="visited">visited</a>, <a href="#" title="hovered link" class="hover">hovered</a></span>
                     | <span class="postcommentsicon"><a href="#comments" title="Comments">Sin comentarios»</a></span>
                                    </div>
                
</article>
<% } %>




</div>
                    </div>
                </div>
            </div><footer class="footer">
<p><a href="#">Privacy Policy</a>|<a href="#">Terms Of Use</a>|<a href="#">Feedback</a></p><br><p>Bibendum rutrum blandit augue sed at nibh.</p>
</footer>

    </div>
</div>


</body></html>