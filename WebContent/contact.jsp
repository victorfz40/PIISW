<%@ include file="header.jsp"%>
<%
	Post post = (Post) request.getAttribute("content");
%>	
	<div class="col-lg-8 mx-auto">
		<h1>Formulario de contacto</h1>
		<section class="comentarios">
			<form action="contact" method="post">
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
		</section>
	</div>

<%@ include file="footer.jsp"%>