<%@ include file="header.jsp" %>
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
 <script>
$(document).ready(function(){
	//alert('documento listo');
	$("#myTable").hide();  
	$("#myInput").on("keyup", function() {
		if($("#myInput").val().length  >= 2){
			$("#myTable").show();
			//alert('caracteres suficientes');
		}else{
			$("#myTable").hide();
		}
		var value = $(this).val().toLowerCase();
		$("#myTable tr").filter(function() {
			$(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
		});
	});
});
</script>

<%
	List<Post> posts = (List<Post>)request.getAttribute("content");
%>
	<div class="col-lg-8 mx-auto">
	
	
		<div class="post-preview">
              <h2 class="post-title">Buscador</h2>
            <p class="post-meta "><input id="myInput" type="text" placeholder="Encontrar" style="width: 100%;"></p>
        </div>
        <hr>
	
	
	<%
		if(posts == null) { %>
		<h2 class="post-title">Actualmente no hay entradas.</h2>	
	<%	} else { %>
		<table>
		  <tbody id="myTable">
	<% 
			for (Post p : posts) {
	%>
	
		    <tr>
		      <td>
				<div class="post-preview">
		            <a href="post?id=<%=p.getId()%>">
		              <h2 class="post-title">
		                <%=p.getTitulo()%>
		              </h2>
		              <h3 class="post-subtitle">
		                <%=p.getHtmlCorto() %>
		              </h3>
		            </a> <hr>
		
		        </div>
		      </td>
		    </tr>

	

       
       <% } %>
		  </tbody>
		</table>
	<%	
		}
		%>          

      </div>

<%@ include file="footer.jsp" %>
