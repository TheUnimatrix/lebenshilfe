<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark mb-2">
	<div class="container-fluid">
		<a class="navbar-brand mb-0 h1"
			href="${pageContext.request.contextPath}/startseite.html">
			Essenbestellung
		</a>
		
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbar-supported-content"
			aria-controls="navbar-supported-content"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		
		<div class="collapse navbar-collapse" id="navbar-supported-content">
			<ul class="navbar-nav me-auto mb-2 mb-lg-0">
				<li class="nav-item">
					<a href="${pageContext.request.contextPath}/login.html"
						class="nav-link">Login</a>
				</li>
				<li class="nav-item">
					<a href="${pageContext.request.contextPath}/logout.html"
						class="nav-link">Logout</a>
				</li>
				<li class="nav-item">
					<a href="${pageContext.request.contextPath}/startseite.html"
						class="nav-link">Startseite</a>
				</li>
				<li class="nav-item">
					<a href="${pageContext.request.contextPath}/uebersicht.html"
						class="nav-link">Übersicht</a>
				</li>
				<li class="nav-item">
					<a href="${pageContext.request.contextPath}/abschluss.html"
						class="nav-link">Abschluss</a>
				</li>
				<li class="nav-item">
					<a href="${pageContext.request.contextPath}/manager/uebersicht.html"
						class="nav-link">Verwaltung</a>
				</li>
				<c:if test='${sessionScope.user.role.name eq "ADMIN"}'>
					<li class="nav-item">
						<a href="#" class="nav-link">Administration</a>
					</li>
				</c:if>
			</ul>
		</div>
		
		<form class="d-flex" method="post" action="${pageContext.request.contextPath}/logout.html">
			<input type="submit" class="btn btn-outline-danger" value="Ausloggen">
		</form>
	</div>
</nav>