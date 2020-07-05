<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Insert title here</title>
</head>
<body>
	<h3>Programming Language: <c:out value="${language.name}"/></h3>
	<h4>Created By: <c:out value="${language.creator}"/></h4>
	<h5>Version: <c:out value="${language.version}"/></h5>
	<p><a href="/languages/${language.id}/edit"><button>Edit</button></a> | <a href="/languages/${language.id}/delete"><button>Delete</button></a></p>
	<a href="/languages"><button>Dashboard</button></a>
</body>
</html>