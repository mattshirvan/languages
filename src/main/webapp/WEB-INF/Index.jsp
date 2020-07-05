<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Insert title here</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
</head>
<body>
	<h1>Languages</h1>
	<table class="table">
	  <thead>
	    <tr>
	      <th scope="col">Name</th>
	      <th scope="col">Creator</th>
	      <th scope="col">Version</th>
	      <th scope="col">Action</th>	     
	    </tr>
	  </thead>
	  <tbody>
		  <c:forEach var="language" items="${languages}">
		    <tr>
		      <th scope="row"><c:out value="${language.name}"/></th>
		      <td><c:out value="${language.creator}"/></td>
		      <td><c:out value="${language.version}" /></td>
		      <td><a href="/languages/${language.id}/edit"><button>Edit</button></a> | <a href="/languages/${language.id}/delete"><button>Delete</button></a></td>
		    </tr>
		  </c:forEach>
	  </tbody>
	</table>
	<h3>Add a Language</h3>
	<form:form action="/languages" method="POST" modelAttribute="language">
	  <div class="form-group">
	    <form:label path="name">Name</form:label>
	    <form:errors path="name"/>
	    <form:input path="name" class="form-control"/>
	  </div>
	  <div class="form-group">
	    <form:label path="creator">Creator</form:label>
	    <form:errors path="creator" />
	    <form:input path="creator" class="form-control"/>
	  </div>
	  <div class="form-group">
	    <form:label path="version">Version</form:label>
	    <form:errors path="version" />
	    <form:input path="version" class="form-control"/>
	  </div>	  
	  <input type="submit" value="Submit">
	</form:form>
</body>
</html>