<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!doctype html>
<html>
	<head>
		<title>Java Web Programming: Class List</title>
		<meta name="description" content="This is a JSP example that demonstrates how to output every person in our excel 
		spreadsheet to a web page.">		
	</head>
	<body>
		<div class="container">
			<div class="hero-unit">
				<h1>Movies List</h1>
			</div>
			<div class="container">
				<c:choose>
					<c:when test="${empty movies}">
						<p>Sorry, the list of movies is empty.</p>
					</c:when>
					<c:otherwise>
						<c:forEach var="movie" items="${movies}">
							<div class="span4">
								<h2>${movie.title}</h2>
								<p>${movie.title} is directed by ${movie.director} and is ${movie.lengthInMinutes} minutes long.</p>
							</div>
						</c:forEach>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
	</body>
</html>