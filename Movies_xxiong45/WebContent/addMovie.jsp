<!doctype html>
<html>
	<head>
		<title>Add Movie</title>
		<meta name="description" content="This is a jsp page for adding a movie.">
<%@ include file="includes/styles.jsp" %>		
	</head>
	<body>
		<div class="container">
			<div class="hero-unit">
				<h1>Add Movie</h1>
			</div>
<%@ include file="includes/navigation.jsp" %>
			<div class="container">
				<form action="AddMovie" method="post">
				
					<label for="title"><strong>Title:</strong></label>
					<input name="title"><br>
					
					<label for="director"><strong>Director: </strong></label>
					<input name="director"><br>
					
					<label for="lengthInMinutes"><strong>Length In Minutes: </strong></label>
					<input name="lengthInMinutes"><br>
					
					<input type="submit" value="Add Movie">
					
				</form>
			</div>
<%@ include file="includes/footer.jsp" %>
		</div>
<%@ include file="includes/scripts.jsp" %>		
	</body>
</html>