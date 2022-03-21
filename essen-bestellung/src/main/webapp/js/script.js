$(document).ready(function () {
	// Registriere Event-Handler
	$("#form-table-food").submit(submitFoodTableForm);
	$("#table-food input[type=number]").change(onAmountValueChange);
	$("#table-food input[type=number]").keypress(checkForNonNumericKeys);
	$("#table-food input[type=number]").keyup(checkForValidInputNumber);
});

/** */
function submitFoodTableForm(event) {
	
	// Verhindere das Absenden des Formulars
	//event.preventDefault(true);
	
	// Lies hidden Input-Feld für Gesamtmenge aus
	var totalAmount = parseInt($("#currentFoodAmount").val(), 10);
	
	// Wenn die Gesamtmenge gleich 0 ist, weil keine Gerichte ausgewählt wurden,
	// dann soll das Formular nicht abgeschickt werden
	if (totalAmount === 0) {
		// Blende einen DIV-Block mit einer Warnmeldung ein
		$("#alert-total-amount")
			.removeClass("visually-hidden")
			.addClass("show");
		return false;
	}
	
	/*
	// Anlegen eines JSON-Objekts zum Abbilden der Inhalte
	var jsonTableFood = [];
	
	// Lies die Tabelle zeilenweise aus
	$("#table-food tbody tr").each(function () {
		
		// Beginne JSON-Objekt für ein einzelnes Datum
		var jsonDailyReservation = {};
		
		var jsonArrayFood = [];
		var jsonSingleFood = {};
		
		// Iteriere über jede einzelne Zelle innerhalb der Zeile
		$(this).find("td").each(function (index, elem) {
			//console.log(index, elem);
			
			var innerText = $(elem).text().trim();
			var regexPttrnDate = /[0-9]{4}-[0-9]{2}-[0-9]{2}/gi;
			
			// Überprüfe, ob es sich bei dem Zelleninhalt um ein Datum handelt
			if (regexPttrnDate.test(innerText)) {
				jsonDailyReservation["datum"] = innerText.toString();
				return;
			}
			
			jsonSingleFood["x"] = "y";
			jsonArrayFood.push(jsonSingleFood);
			
			jsonDailyReservation["food"] = jsonArrayFood;
			
			//console.log($(elem).text().trim());
			
		});
		
		//jsonDailyReservation["food"] = jsonArrayFood;
		jsonTableFood.push(jsonDailyReservation);
	});
	//*/
	
	//console.log(jsonTableFood);
	
	/*
	// Sende Formulardaten aus der Tabelle als Ajax-Request an das Servlet
	$.post({
		url: $(this).attr("action"),
		data: "data=" + JSON.stringify(jsonTableFood),
		success: function (data) {
			document.open();
			document.write(data);
			document.close();
			//console.log(data);
		},
		error: (data) => console.log(data)
	});
	//*/
}

/**
 * Funktion, welche aufgerufen wird, wenn sich der Wert in einem Input-Feld
 * ändert. Dann wird jedes einzelne Input-Feld ausgelesen und die Gesamtmenge
 * berechnet, welche in einem eigenen hidden Input-Feld hinterlegt wird.
 */
function onAmountValueChange() {
	// Gesamtmenge
	var totalAmount = 0;
	
	// Lies alle Input-Elemente in der Tabelle aus und addiere deren Werte
	$("#table-food input[type=number]").each(function () {
		var elemValue = parseInt($(this).val(), 10);
		totalAmount += elemValue;
	});
	
	// Setze den Wert der Gesamtmenge in das hidden Input-Feld
	$("#currentFoodAmount").val(totalAmount);
}

/**
 * Funktion zum Unterdrücken der Eingabe von nicht-numerischen Zeichen (Plus,
 * Minus, Punkt und Komma)
 */
function checkForNonNumericKeys(event) {
	// Hat der Benutzer Plus, Komma, Punkt oder Minus eingegeben?
	// Wenn ja, dann soll diese Eingabe unterdrückt werden
	if (event.charCode >= 43 && event.charCode <= 46)
		event.preventDefault(true);
}

/**
 * Funktion zum Überprüfen, ob der Benutzer mit seiner Eingabe den Maximalwert
 * des Input-Felds überschritten hat. Sollte dies der Fall sein, wird stattdessen
 * der Maximalwert im Feld eingetragen, ansonsten der jeweils aktuelle Wert.
 */
function checkForValidInputNumber() {
	// Hole die benötigten Angaben aus dem Input-Feld
	var currentInputValue = parseInt($(this).val(), 10);
	var currentInputMinimum = parseInt($(this).attr("min"), 10);
	var currentInputMaximum = parseInt($(this).attr("max"), 10);
	
	// Ersetze den derzeitigen Wert aus dem jeweiligen Input-Feld, wodurch die
	// führende "0" verschwindet. Sollte durch Copy & Paste eine ungültige Zahl
	// eingegeben werden, wird diese durch das Minimum ersetzt
	$(this).val(isNaN(currentInputValue) ? currentInputMinimum : currentInputValue);
	
	// Überprüfe, ob die eingegebene Zahl kleiner als das zulässige Minimum ist
	// (z.B. weil diese per Copy & Paste eingefügt wurde) und ersetze diese
	// ggf. durch das aktuelle Minimum
	if (currentInputValue < currentInputMinimum)
		$(this).val(currentInputMinimum);
	
	// Überprüfe, wie groß der derzeitige Wert im Feld ist und passe diesen auf
	// den Maximalwert an, sofern er darüberliegen sollte
	if (currentInputValue > currentInputMaximum)
		$(this).val(currentInputMaximum);
	
	// Rufe Methode auf, um neue Gesamtmenge zu berechnen
	onAmountValueChange();
}