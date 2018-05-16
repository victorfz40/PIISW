<%@ include file="header.jsp" %>

<%
	List<Post> posts = (List<Post>)request.getAttribute("content");
%>
	<div class="col-lg-8 mx-auto">
	
	<%
		if(posts == null) { %>
		<h2 class="post-title">Actualmente no hay entradas.</h2>	
	<%	} else {
			for (Post p : posts) {
	%>
		<div class="post-preview">
            <a href="post?id=<%=p.getId()%>">
              <h2 class="post-title">
                <%=p.getTitulo()%>
              </h2>
              <h3 class="post-subtitle">
                <%=p.getHtmlCorto() %>
              </h3>
            </a>
            <p class="post-meta ">Categoría:<%=(p.getCategorias() != null
							? "<a href='listadoCategoria?id=" + p.getCategorias().getId() + "'>"
									+ p.getCategorias().getNombre() + "</a>"
							: "No categorizada") %>              
              el <%=p.getFecha().toString() %></p>
        </div>
        <hr>
       <% }
		}
		%>          
          <!-- Pager -->
        <div class="clearfix">
          <a class="btn btn-primary float-right" href="#">Antiguos &rarr;</a>
        </div>
      </div>

<%@ include file="footer.jsp" %>