<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>

<html>

<head>
	
	<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
	
	<link href="<c:url value="/resources/style.css" />"rel="stylesheet" type="text/css" >
		
		<title>List Books</title>
</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>Search Result</h2>
		</div>
	</div>
	<div id="container">
		<div id="content">
		
			<table class="table table-bordered table-striped">
			<thead class="thead-dark">
				<tr>
				<th>Name </th>
				<th>Series Name </th>
				<th>Isbn </th>
				</tr>
				</thead>
			
			<c:forEach var="tempBook" items="${books}">
			
				<tr>
					<td> ${tempBook.name }</td>
					<td> ${tempBook.series_name }</td>
					<td> ${tempBook.isbn }</td>
					</tr>
					
			</c:forEach>
			</table>
		</div>

		<div style="clear; both;"> </div>
	
	<p>
		<a href="${pageContext.request.contextPath}/book/list">Back to List</a> 

	</p>
	</div>


</body>

</html>