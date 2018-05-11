<%@page import="java.util.Set"%>
<%@page import="edu.ucam.modelos.Comentarios"%>
<%@ include file="header.jsp"%>
<%
	Post post = (Post) request.getAttribute("content");
%>

	<div class="col-lg-8 mx-auto">
		<article class="post">
		<h2>
			<%=post.getTitulo()%>
		</h2>

		<div>
			<%=post.getHtml()%>
			<br>
		</div>
		
		<div>
			<span class="postcategoryicon">Categorías: <%
				out.print((post.getCategorias() != null
							? "<a href='/listadoCategoria?id=" + post.getCategorias().getId() + "'>"
									+ post.getCategorias().getNombre() + "</a>"
							: "No categorizada"));
			%></span> | <span
				class="postcommentsicon"><%
						out.print((post.getComentarioses() != null && post.getComentarioses().size() > 0
									? post.getComentarioses().size() + " comentario(s)"
									: "Sin comentarios"));
					%></span>
			</div>
		</article>
		<hr />
		<section class="comentarios">
			<form action="post?id=<%=request.getParameter("id") %>" method="post">
				<div class="row">
					<div class="col-12 form-group">
						<label for="email">Nombre</label>
						<input type="text" name="nombre" class="form-control" />					
					</div>
					<div class="col-12 form-group">
						<label for="email">Email</label>
						<input type="text" name="email" class="form-control" />					
					</div>
					<div class="col-12 form-group">
						<label for="comentario">Comentario</label>
						<textarea name="comentario" class="form-control"></textarea>										
					</div>
					<button type="submit" class="btn btn-primary">Enviar</button>
				</div>				
			</form>
			<%
				Set<Comentarios> comentarios = post.getComentarioses();
				for(Comentarios comentario : comentarios) {		
			%>
				<article class="comentario">
					<div class="row">
			            <div class="col-sm-2 review-info">
			                <span class="avatar"><%=comentario.getNombre().charAt(0) %></span>
			                <p>
			                    <span class="nombre"><%=comentario.getNombre() %></span> <br>
			                    <small class="date">Escrita el <%=comentario.getFecha() %></small>
			                </p>
			            </div>
			            <div class="col-sm-10 review-detalle">                            
                             <p style="margin-top: 10px;"><%=comentario.getComentario() %></p>
			
			            </div>
			        </div>					
				</article>
			<% } %>
		</section>
	</div>

<%@ include file="footer.jsp"%>