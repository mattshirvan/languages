<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Language</title>
</head>
<body>
	<h3>Edit ${language.name}</h3>
	<form:form action="/languages/${language.id}" method="POST" modelAttribute="language">
	<input type="hidden" name="_method" value="put"/>
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
	  <input type="submit" value="Edit">
	</form:form>
</body>
</html>