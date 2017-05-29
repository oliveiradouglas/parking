<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf8" />
		<title>
			<fmt:message key="app.name" />
		</title>
		
		<link href="<c:url value="/public/css/bootstrap.min.css"/>" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="<c:url value="/public/js/jquery-3.2.1.min.js"/>"></script>
	</head>
	<body>