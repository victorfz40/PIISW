<%@page import="edu.ucam.vistas.PaginaContenido"%>
<%@page import="edu.ucam.clases.Enlace"%>
<%@page import="edu.ucam.vistas.PaginaContenido"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import=" edu.ucam.clases.Post"%>
    
    
    
<!DOCTYPE html>
<html dir="ltr" lang="en-US"><head><!-- Created by Artisteer v4.3.0.60745 -->
    <meta charset="utf-8">
    <title><% out.print(((PaginaContenido)request.getAttribute("pagina")).getTitulo() ); %></title>
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
    <a href="/">CALIDAD Y RENTABILIDAD,</a>
</h1>
<h2 class="slogan">PROFESIONALES</h2>





<nav class="nav">
    <ul class="hmenu">
    <% 
    for (Enlace e :((PaginaContenido)request.getAttribute("pagina")).getMenu() )  {
    	%><li><a href="<% out.print(e.getVinculo()); %>" class=""><% out.print(e.getTexto()); %></a></li><%
    }
    %>    
    </ul> 
</nav>

                    
</header>
<div class="layout-wrapper">
                <div class="content-layout">
                    <div class="content-layout-row">
                        <div class="layout-cell sidebar1"><div class="block clearfix">
        <div class="blockheader">
            <h3 class="t">Categories</h3>
        </div>
        <div class="blockcontent"><div>
		<ul>
		<% for (Enlace e :((PaginaContenido)request.getAttribute("pagina")).getMenuLateral())   { %>
		<li><a href="<% out.print(e.getVinculo()); %>" title="<% out.print(e.getTexto()); %>"><% out.print(e.getTexto()); %></a> </li>
		<% } %>
		</ul>
		</div>
		</div>
</div>
</div>
                        <div class="layout-cell content">
                        

<article class="post article">
                                <h2 class="postheader"><a href="post/<% ((PaginaContenido)request.getAttribute("pagina")).getContenido().getId(); %>; %>"><% ((PaginaContenido)request.getAttribute("pagina")).getTitulo(); %></a>
                                </h2>

                <div class="postcontent postcontent-0 clearfix">
<% out.print(((PaginaContenido)request.getAttribute("pagina")).getContenido().getContenido()); %>

<br>
                </div>
                                <div class="postfootericons metadata-icons">
                    <span class="postcategoryicon">Category: No Category</span>
                     | <span class="posttagicon">Tags: <a href="#" title="link">link</a>, <a href="#" title="visited link" class="visited">visited</a>, <a href="#" title="hovered link" class="hover">hovered</a></span>
                     | <span class="postcommentsicon"><a href="#comments" title="Comments">Sin comentarios»</a></span>
                                    </div>
                
</article>




</div>
                    </div>
                </div>
            </div><footer class="footer">
<p><a href="#">Política de privacidad</a>|<a href="#">Términos de uso</a>|<a href="#">Feedback</a></p><br><p>Servicios profesionales.</p>
</footer>

    </div>
</div>


</body></html>