<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>Essenbestellung bei der Schleizer Werkstätten gGmbH</title>
		<link href="css/bootstrap-5.1.3.min.css" rel="stylesheet">
		<link href="favicon.ico" rel="shortcut icon">
		<script type="text/javascript" src="js/jquery-3.6.0.min.js"></script>
		<script type="text/javascript" src="js/bootstrap-5.1.3.min.js"></script>
	</head>
	
	<body>
		<div class="container-fluid">
			<h2>Login</h2>
			
			<div class="alert alert-error text-uppercase fw-bold">Div-Block für Fehlermeldungen</div>
			
			<form action="login.html" method="post">
				<div class="mb-3">
					<label class="form-label">E-Mail-Adresse:</label>
					<input type="email" name="email" class="form-control" required="required">
				</div>
				<div class="mb-3">
					<label class="form-label">Passwort:</label>
					<input type="password" name="password" class="form-control" required="required">
				</div>
				<input type="submit" class="btn btn-primary" value="Anmelden">
			</form>
		</div>
	</body>
</html>