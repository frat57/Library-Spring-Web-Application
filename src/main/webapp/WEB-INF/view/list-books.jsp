<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>

<html lang="tr" xmlns:th="http://www.thymeleaf.org">

<head>
	<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">

	<link href="<c:url value="/resources/style.css" />"rel="stylesheet" type="text/css" >
		
		<title>List Books</title>
</head>

<body>

	<div class="container" id="wrapper">
		<div id="header">
			<h2>Welcome to Library</h2>
		</div>
	</div>
	<div  id="container">
		<div id="content">
		<security:authorize access="hasRole('ADMIN')">
			<input type="button" value="Add Book"
					onclick="window.location.href='/SpringLibrary/book/showFormForAdd';return false;"
					class="add-button"
			/>
			</security:authorize>
			<input type="button" value="List Author"
					onclick="window.location.href='/SpringLibrary/author/list';return false;"
					class="add-button"
			/>
			<input type="button" value="List Publisher"
					onclick="window.location.href='/SpringLibrary/publisher/list';return false;"
					class="add-button"
			/>
			<form method="get" action="search">
				<input type="text" name="keyword" /> &nbsp;
				<input type="submit" class="add-button" value="Search" />
			</form>
			<div>	
  			 &nbsp&nbsp&nbsp 
			</div>

			
			<table class="table table-bordered table-striped">
			<thead class="thead-dark">
				<tr>
				<th>Name </th>
				<th>Subtitle </th>
				<th>Series Name </th>
				<th>Author </th>
				<th>Publisher </th>
				<th>Isbn </th>
				<th>Details </th>
				<th>Actions </th>
				</tr>
			</thead>
			
			<c:forEach var="tempBook" items="${books}">
			
				<c:url var="updateLink" value="/book/showFormForUpdate">
					<c:param name="bookId" value="${tempBook.id}" />
				</c:url>
				
				<c:url var="deleteLink" value="/book/delete">
					<c:param name="bookId" value="${tempBook.id}" />
				</c:url>
				
				<tr>
					<td> ${tempBook.name }</td>
					<td> ${tempBook.subtitle }</td>
					<td> ${tempBook.series_name }</td>
					<td> ${tempBook.author.getName() }</td>
					<td> ${tempBook.publisher.getName() }</td>
					<td> ${tempBook.isbn }</td>
					<td> ${tempBook.details }</td>
					
					<td>
						<a href="${updateLink}">Update</a>
						<security:authorize access="hasRole('ADMIN')">
						|
						<a href="${deleteLink}"
							onclick="if (!(confirm('Are you sure you want to delete this Book?'))) return false">Delete</a>
					</security:authorize>
					</td>
					
					</tr>
					
			</c:forEach>
			</table>
		</div>
	</div>


</body>

</html>