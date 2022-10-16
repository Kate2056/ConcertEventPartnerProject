<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>View All Events</title>
</head>
<style>
	form{
		margin:10px;
	}
	
	body{
		background-color:#f0eee9;
	}

</style>
<body>
<h1>List of All Events:</h1>
<form method ="post" action="navigationServlet">
<table>
	<c:forEach items="${requestScope.allEventss}" var="currentevent">
	<tr>
		<td><input type="radio" name="id" value="${currentevent.id}"></td>
		<td>${currentevent.artist}</td>
		<td>${currentevent.date}</td>
		<td>${currentevent.time}</td>
	</tr>
	</c:forEach>
</table>
<input type ="submit" value ="edit" name="doThisToEvent">
<input type ="submit" value ="delete" name="doThisToEvent">
<input type="submit" value ="add" name ="doThisToEvent">
</form>
</body>
</html>