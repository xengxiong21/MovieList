
<!doctype html>
<html>
	<head>
		<title>Success Page</title>
		<meta name="description" content="This is a JSP page for successfull things.">
<%@ include file="includes/styles.jsp" %>		
	</head>
	<body>
		<div class="container">
			<div class="hero-unit">
				<h1>Success Page</h1>
			</div>
<%@ include file="includes/navigation.jsp" %>
			<div class="container">
				<p>${message}</p>
			</div>
<%@ include file="includes/footer.jsp" %>
		</div>
<%@ include file="includes/scripts.jsp" %>
	</body>
</html>