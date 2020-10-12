<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>

<html>
<head>
<title>Save Book</title>

	<link href="<c:url value="/resources/style.css" />"rel="stylesheet" type="text/css" >

	<link href="<c:url value="/resources/add-book-style.css" />"rel="stylesheet" type="text/css" >

</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>Save Book Page</h2>
		</div>
	</div>
	<div id="container">
		<h3>Save Book</h3>
	
	<form:form action="saveBook" modelAttribute="book" method="POST">
		
		<form:hidden path="id"/>
		<table>
			<tbody>
				<tr>
					<td><label>Name:</label></td>
					<td><form:input path="name" /></td>
				</tr>
				
				<tr>
					<td><label>Subtitle:</label></td>
					<td><form:input path="subtitle" /></td>
				</tr>
				
				<tr>
					<td><label>Series Name:</label></td>
					<td><form:input path="series_name" /></td>
				</tr>
				
				<tr>
					<td><label>Author:</label></td>
					<td><form:select path="author">
   				 <c:forEach items="${author}" var="author">
       		 		<option value="${author.id}">${author.name}</option>
    			</c:forEach>
    			</form:select>
					</td>
				</tr>

				<tr>
					<td><label>Publisher:</label></td>
					<td><form:select path="publisher">
   				 <c:forEach items="${publisher}" var="publisher">
       		 		<option value="${publisher.id}">${publisher.name}</option>
    			</c:forEach>
    			</form:select>
					</td>
				</tr>
				
				<tr>
					<td><label>Isbn:</label></td>
					<td><form:input path="isbn" /></td>
				</tr>
				
				<tr>
					<td><label>Details:</label></td>
					<td><form:input path="details" /></td>
				</tr>
				
				<tr>
					<td><label></label></td>
					<td><input type="submit" value="Save"/></td>
				</tr>
			</tbody>
		</table>
	</form:form>
	
	<div style="clear; both;"> </div>
	
	<p>
		<a href="${pageContext.request.contextPath}/book/list">Back to List</a> 
	
	</p>
	</div>
</body>
</html>