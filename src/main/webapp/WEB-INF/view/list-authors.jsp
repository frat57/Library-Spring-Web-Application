<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>

<html>

<head>
<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">

	<title>List Authors</title>
	
<link href="<c:url value="/resources/style.css" />"rel="stylesheet" type="text/css" >
		
</head>

<body>

	<div class="container" id="wrapper">
		<div id="header">
			<h2>Author List </h2>
		</div>
	</div>
	<div id="container">
		<div id="content">
			<security:authorize access="hasRole('ADMIN')">
			<input type="button" value="Add Author"
					onclick="window.location.href='showFormForAdd';return false;"
					class="add-button"
			/>
			</security:authorize>
			<table class="table table-bordered table-striped">
			<thead class="thead-dark">
				<tr>
				<th>Name</th>
				<th>Details </th>
				<th>Action </th>
				</tr>
			</thead>
			<c:forEach var="tempAuthor" items="${authors}">
			
				<c:url var="updateLink" value="/author/showFormForUpdate">
					<c:param name="authorId" value="${tempAuthor.id}" />
				</c:url>
				
				<c:url var="deleteLink" value="/author/delete">
					<c:param name="authorId" value="${tempAuthor.id}" />
				</c:url>
				
				<tr>
					<td> ${tempAuthor.name }</td>
					<td> ${tempAuthor.details }</td>
				
					<td>
						<a href="${updateLink}">Update</a>
						<security:authorize access="hasRole('ADMIN')">
						|
						<a href="${deleteLink}"
							onclick="if (!(confirm('Are you sure you want to delete this Author?'))) return false">Delete</a>
					</security:authorize>
					</td>
					
					</tr>
					
			</c:forEach>
			</table>
		</div>
	</div>


</body>

</html>