<%@ include file="header.jsp" %>

<%
	List<Post> posts = (List<Post>)request.getAttribute("content");
%>

<div class="layout-cell content">
	<%
		for (Post p : posts) {
	%>
	<article class="post article">
		<h2 class="postheader">
			<a href="post?id=<%out.print(p.getId());%>">
				<%=p.getTitulo()%>
			</a>
		</h2>

		<div class="postcontent postcontent-0 clearfix">
			<%=p.getHtmlCorto() %>
			<br>
			<a href="post?id=<%out.print(p.getId());%>">Leer más</a>
		</div>
		<div class="postfootericons metadata-icons">
			<span class="postcategoryicon">Categorías: <%
				out.print((p.getCategorias() != null
							? "<a href='/listadoCategoria.jsp?id=" + p.getCategorias().getId() + ">"
									+ p.getCategorias().getNombre() + "</a>"
							: "No categorizada"));
			%>
			</span> | <span class="posttagicon">Tags: <a href="#" title="link">link</a>,
				<a href="#" title="visited link" class="visited">visited</a>, <a
				href="#" title="hovered link" class="hover">hovered</a></span> | <span
				class="postcommentsicon"><a href="#comments"
				title="Comments">
					<%
						out.print((p.getComentarioses() != null && p.getComentarioses().size() > 0
									? p.getComentarioses().size() + " comentario(s)"
									: "Sin comentarios"));
					%>
			</a></span>
		</div>
	</article>
	<%
		}
	%>
</div>


<%@ include file="footer.jsp" %>