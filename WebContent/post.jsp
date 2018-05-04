<%@ include file="header.jsp"%>
<%
	Post post = (Post) request.getAttribute("content");
%>

<div class="layout-cell content">
	<article class="post article">
		<h2 class="postheader">
			<%=post.getTitulo()%>
		</h2>

		<div class="postcontent postcontent-0 clearfix">
			<%=post.getHtml()%>
			<br>
		</div>
		
		<div class="postfootericons metadata-icons">
			<span class="postcategoryicon">Categorías: <%
				out.print((post.getCategorias() != null
							? "<a href='/listadoCategoria.jsp?id=" + post.getCategorias().getId() + ">"
									+ post.getCategorias().getNombre() + "</a>"
							: "No categorizada"));
			%></span> | <span
				class="postcommentsicon"><a href="#comments"
				title="Comments"><%
						out.print((post.getComentarioses() != null && post.getComentarioses().size() > 0
									? post.getComentarioses().size() + " comentario(s)"
									: "Sin comentarios"));
					%></span>
		</div>
	</article>
</div>

<%@ include file="footer.jsp"%>