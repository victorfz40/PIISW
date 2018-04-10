<%@page import="edu.ucam.clases.Enlace"%>
<%@page import="edu.ucam.vistas.PaginaListado"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import=""%>
    
    
    
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
                        <div class="layout-cell content"><article class="post article">
                                <h2 class="postheader"><a href="Blog Posts/publicar-2.html">Publicar 2</a>
                                </h2>
                                                <div class="postheadericons metadata-icons">
                    <span class="postdateicon"></span>
                     | <span class="postpdficon"></span>
                     | <span class="postprinticon"></span>
                     | <span class="postemailicon"></span>
                     | <span class="postediticon"></span>
                                    </div>
                <div class="postcontent postcontent-0 clearfix">
<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc rutrum, enim eu elementum ornare, nulla odio vulputate magna, nec vehicula nisi tellus quis sapien. Etiam quis mattis diam, a accumsan quam. Morbi faucibus sem at cursus efficitur. Aenean quam ligula, ultricies sit amet odio non, ornare semper elit. Vestibulum porttitor feugiat magna, quis maximus mauris consequat tristique. Donec pellentesque porta egestas. Suspendisse condimentum ex quis lobortis porta.</p><br><a href="Blog Posts/publicar-2.html">Read more...</a>
                </div>
                                <div class="postfootericons metadata-icons">
                    <span class="postcategoryicon">Category: No Category</span>
                     | <span class="posttagicon">Tags: <a href="#" title="link">link</a>, <a href="#" title="visited link" class="visited">visited</a>, <a href="#" title="hovered link" class="hover">hovered</a></span>
                     | <span class="postcommentsicon"><a href="#comments" title="Comments">No Comments »</a></span>
                                    </div>
                
</article>
<article class="post article">
                                <h2 class="postheader"><a href="Blog Posts/publicar.html">Publicar</a>
                                </h2>
                                                <div class="postheadericons metadata-icons">
                    <span class="postdateicon"></span>
                     | <span class="postpdficon"></span>
                     | <span class="postprinticon"></span>
                     | <span class="postemailicon"></span>
                     | <span class="postediticon"></span>
                                    </div>
                <div class="postcontent postcontent-1 clearfix">
<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc rutrum, enim eu elementum ornare, nulla odio vulputate magna, nec vehicula nisi tellus quis sapien. Etiam quis mattis diam, a accumsan quam. Morbi faucibus sem at cursus efficitur. Aenean quam ligula, ultricies sit amet odio non, ornare semper elit. Vestibulum porttitor feugiat magna, quis maximus mauris consequat tristique. Donec pellentesque porta egestas. Suspendisse condimentum ex quis lobortis porta.</p><br><a href="Blog Posts/publicar.html">Read more...</a>
                </div>
                                <div class="postfootericons metadata-icons">
                    <span class="postcategoryicon">Category: No Category</span>
                     | <span class="posttagicon">Tags: <a href="#" title="link">link</a>, <a href="#" title="visited link" class="visited">visited</a>, <a href="#" title="hovered link" class="hover">hovered</a></span>
                     | <span class="postcommentsicon"><a href="#comments" title="Comments">No Comments »</a></span>
                                    </div>
                
</article>
</div>
                    </div>
                </div>
            </div><footer class="footer">
<p><a href="#">Privacy Policy</a>|<a href="#">Terms Of Use</a>|<a href="#">Feedback</a></p><br><p>Bibendum rutrum blandit augue sed at nibh.</p>
</footer>

    </div>
</div>


</body></html>