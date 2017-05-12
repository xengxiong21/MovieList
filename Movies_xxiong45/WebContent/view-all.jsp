<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!doctype html>
<html>
	<head>
		<title>Movies List</title>
		<meta name="description" content="This is the movies list.">
<%@ include file="includes/styles.jsp" %>		
	</head>
	<body>
		<div class="container">
			<div class="hero-unit">
				<h1>Movie List</h1>
			</div>
<%@ include file="includes/navigation.jsp" %>
			<div class="container">
				<c:forEach var="movies" items="${movie}">
					<div class="span4">
						<h2>${movies.title}</h2>
						<p>${movies.director} was the director and it was ${movies.lengthInMinutes} minutes long.</p>
					</div>
				</c:forEach>
			</div>
<%@ include file="includes/footer.jsp" %>
		</div>
<%@ include file="includes/scripts.jsp" %>
	</body>
</html>