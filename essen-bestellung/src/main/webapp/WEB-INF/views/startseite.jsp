<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:set var="foodArray" value="${requestScope.food}"/>

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
		<script type="text/javascript" src="js/script.js"></script>
	</head>
	
	<body>
		<div class="container-fluid">
			<h2>Essenbestellung</h2>
			
			<form method="post" action="startseite.html">
			
				<div class="mb-3">
					<label for="price-group" class="form-label">Preisgruppe:</label>
					
					<select id="price-group" name="price-group" class="form-select">
						<option value="" selected disabled>--</option>
						<c:forEach var="i" begin="1" end="16" step="1">
							<option value="${i}">${i}</option>
						</c:forEach>
					</select>
				</div>				
				
				<div class="mb-3">
					<input type="submit" class="btn btn-primary">
				</div>
			</form>
			
			<div id="alert-total-amount" class="alert alert-warning fade visually-hidden" role="alert">
				<h4 class="alert-heading">Warnung</h4>
				<p class="mb-0">
					Sie müssen mindestens eine Speise ausgewählt haben. Die
					Gesamtmenge aller ausgewählten Speisen muss größer als 0 sein,
					damit Ihre Bestellung abgeschickt und bearbeitet werden kann.
				</p>
			</div>
			
			<c:if test="${foodArray ne null}">
				<form id="form-table-food" action="uebersicht.html" method="post">
					<table id="table-food" class="table table-sm">
						<thead>
							<tr>
								<th class="text-center">Datum</th>
								<th>Speisen</th>
								<th>Einzelpreis</th>
								<th>Menge</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="i" begin="0" end="${foodArray.length() - 1}">
								<c:set var="currentFoodDayArray" value="${foodArray.getJSONArray(i)}"/>
								
								<c:if test="${currentFoodDayArray.isEmpty()}">
									<tr>
										<td class="text-center" colspan="4">
											Für Ihre Preisgruppe wurden leider keine Speisenangebote gefunden
										</td>
									</tr>
								</c:if>
								
								<c:if test="${not currentFoodDayArray.isEmpty()}">
									<c:forEach var="j" begin="0" end="${currentFoodDayArray.length() - 1}">
										<c:set var="currentFood" value="${currentFoodDayArray.getJSONObject(j)}"/>
										<tr>
											<c:if test="${j == 0}">
												<td class="align-middle text-center" rowspan="${currentFoodDayArray.length()}">
													<fmt:parseDate var="orderDate" value='${currentFood.get("datum")}' pattern="yyyy-MM-dd"/>
													<fmt:formatDate value='${orderDate}'/>
													<input type="hidden" name="date-${i}" value='${currentFood.get("datum")}'>
												</td>
											</c:if>
											<td class="align-middle">
												${currentFood.get("nr").toString().toUpperCase()}: ${currentFood.get("essen")}
												<input type="hidden" name="food-nr-${i}-${j}" value='${currentFood.get("nr").toString().toUpperCase()}'>
												<input type="hidden" name="food-text-${i}-${j}" value='${currentFood.get("essen")}'>
											</td>
											<td class="align-middle">
												${currentFood.get("preis")} &euro;
												<input type="hidden" name="price-${i}-${j}" value='${currentFood.get("preis")}'>
											</td>
											<td class="align-middle">
												<input type="number" class="form-control"
												 	name="amount-${i}-${j}" min="0" max="20" value="0" step="1">
												<input type="hidden" name="food-id-${i}-${j}" value='${currentFood.get("id")}'>
											</td>
										</tr>
									</c:forEach>
								</c:if>
							</c:forEach>
						</tbody>
						<tfoot>
							<tr>
								<td colspan="4">&nbsp;</td>
							</tr>
						</tfoot>
					</table>
					<input type="hidden" id="currentFoodAmount" value="0">
					<input type="submit" class="btn btn-primary float-end" value="Weiter">
				</form>
			</c:if>
		</div>
	</body>
</html>