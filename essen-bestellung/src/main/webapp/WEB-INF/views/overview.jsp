<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:set var="orderArray" value='${sessionScope["order-array"]}'/>
<c:set var="sum" value="${0}"/>

<!DOCTYPE html>
<html>
	
	<!-- Setze Lokalisierung auf Deutschland (für Ausgabe von Datum und Währung) -->
	<fmt:setLocale value="de_DE"/>

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
			<h2>Übersicht</h2>
			<p>
				Hier finden Sie eine Übersicht der einzelnen Speisen sowie der
				jeweiligen Preise. Über einen Klick auf die darunter befindliche
				Schaltfläche können Sie Ihre Bestellung verbindlich bestätigen.
				Erst danach wird diese abgeschickt und im System verarbeitet.
			</p>
			<p>
				Über den folgenden Link kommen Sie wieder auf die Startseite
				zurück:
				<a href="startseite.html" class="link-success">HIER KLICKEN</a>
			</p>
			
			<table class="table">
				<thead>
					<tr>
						<th class="text-center">Datum</th>
						<th>Speisen</th>
						<th class="text-end">Menge</th>
						<th class="text-end">Einzelpreis</th>
						<th class="text-end">Gesamt</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="i" begin="0" end="${orderArray.length() - 1}">
						<c:set var="currentDayObject" value="${orderArray.getJSONObject(i)}"/>
						<c:set var="currentDayArray" value='${currentDayObject.getJSONArray("food")}'/>
						
						<c:forEach var="j" begin="0" end="${currentDayArray.length() - 1}">
							<c:set var="currentMeal" value="${currentDayArray.getJSONObject(j)}"/>
							<c:set var="sum" value='${sum + currentMeal.get("preis") * currentMeal.get("menge")}'/>
							
							<tr>
								<c:if test="${j == 0}">
									<td class="text-center align-middle" rowspan="${currentDayArray.length()}">
										<fmt:parseDate var="orderDate" value='${currentDayObject.get("date")}' pattern="yyyy-MM-dd"/>
										<fmt:formatDate value='${orderDate}'/>
									</td>
								</c:if>
								<td>${currentMeal.get("nr")}: ${currentMeal.get("essen")}</td>
								<td class="text-end">${currentMeal.get("menge")}</td>
								<td class="text-end">
									<fmt:formatNumber value='${currentMeal.get("preis")}' type="currency"/>
								</td>
								<td class="text-end">
									<fmt:formatNumber value='${currentMeal.get("preis") * currentMeal.get("menge")}' type="currency"/>
								</td>
							</tr>
						</c:forEach>
					</c:forEach>
				</tbody>
				<tfoot>
					<tr>
						<td class="text-end fw-bold" colspan="5">
							Summe: <fmt:formatNumber value="${sum}" type="currency"/>
						</td>
					</tr>
				</tfoot>
			</table>
			
			<form action="abschluss.html" method="post">
				<input type="hidden" name="input-test" value="5">
				<input type="submit" name="button-order-2" class="btn btn-primary float-end"
					value="Verbindlich bestellen">
			</form>
		</div>
	</body>
</html>