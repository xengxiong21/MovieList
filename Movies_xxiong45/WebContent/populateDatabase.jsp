
<!doctype html>
<html>
	<head>
		<title>Populate Database</title>
		<meta name="description" content="This is a JSP page that populates a database.">
<%@ include file="includes/styles.jsp" %>		
	</head>
	<body>
		<div class="container">
			<div class="hero-unit">
				<h1>Populate Database</h1>
			</div>
<%@ include file="includes/navigation.jsp" %>
			<div class="container">
				<form action="PopulateDatabase" method="post">
					<p>Click on the populate button to populate the Movie database.</p>
					<p>This will reset the current database if there is one and will add my favorite movies.</p>
					<input type="submit" value="Populate!">
				</form>
			</div>
<%@ include file="includes/footer.jsp" %>
		</div>
<%@ include file="includes/scripts.jsp" %>
	</body>
</html>