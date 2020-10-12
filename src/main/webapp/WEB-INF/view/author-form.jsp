<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>

<html>
<head>

<title>Save Author</title>

	<link href="<c:url value="/resources/style.css" />"rel="stylesheet" type="text/css" >

	<link href="<c:url value="/resources/add-book-style.css" />"rel="stylesheet" type="text/css" >

</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>Author List Page</h2>
		</div>
	</div>
	<div id="container">
		<h3>Save Author</h3>
		
	<form:form action="saveAuthor" modelAttribute="author" method="POST">
		
		<form:hidden path="id"/>
		<table>
			<tbody>
				<tr>
					<td><label>Name:</label></td>
					<td><form:input path="name" /></td>
				</tr>
				
				<tr>
					<td><label>Details:</label></td>
					<td><form:input path="details" /></td>
				</tr>
				
				<tr>
					<td><label></label></td>
					<td><input type="submit" value="save"/></td>
				</tr>
			</tbody>
		</table>
	</form:form>
	
	<div style="clear; both;"> </div>
	
	<p>
		<a href="${pageContext.request.contextPath}/author/list">Back to List</a> 

	</p>
	</div>
</body>
</html>