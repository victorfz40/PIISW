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
			<span class="postcategoryicon">Category: No Category</span> | <span
				class="posttagicon">Tags: <a href="#" title="link">link</a>,
				<a href="#" title="visited link" class="visited">visited</a>, <a
				href="#" title="hovered link" class="hover">hovered</a></span> | <span
				class="postcommentsicon"><a href="#comments"
				title="Comments">Sin comentarios»</a></span>
		</div>
	</article>
</div>

<%@ include file="footer.jsp"%>