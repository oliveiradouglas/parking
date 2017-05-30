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
		<link href="<c:url value="/public/css/font-awesome.min.css"/>" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="<c:url value="/public/js/jquery-3.2.1.min.js"/>"></script>
	</head>
	<body>

	<nav class="navbar navbar-inverse navbar-static-top">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">Project name</a>
			</div>
			<div id="navbar" class="navbar-collapse collapse">
				<ul class="nav navbar-nav navbar-right">
					<li>
						<a href="#">
							<i class="fa fa-car"></i>
							<fmt:message key="inputs" />
						</a>
					</li>
					<li class="active">
						<a href="#">
							<i class="fa fa-cog"></i>
							<fmt:message key="settings"/>
						</a>
					</li>
					<!--<li>
						<p class="navbar-text">
							User Name
							<a href="#" class="navbar-link">
								<i class="fa fa-sign-out"></i>
							</a>
						</p>
					</li> -->
				</ul>
			</div>
			<!--/.nav-collapse -->
		</div>
	</nav>

	<div class="container">
		<ol class="breadcrumb">
			<c:forEach var="breadcrumb" items="${breadcrumbList}">
				<li class="${breadcrumb.active ? "active" : ""}">
					<a href="${breadcrumb.link}">
						${breadcrumb.text}
					</a>
				</li>
			</c:forEach>	
		</ol>
	</div>
	