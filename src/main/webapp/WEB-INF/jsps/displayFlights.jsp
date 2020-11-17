<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Flights</title>
</head>
<body>
<h2>Flights:</h2>
<table>
<tr><th>AirLines</th>
<th>Departure City</th>
<th>Arrival city</th>
<th>Departure Time</th>

</tr>


<c:forEach items = "${flights}" var="flight">
<tr>


<td>${flight.operatingAirlines}</td>
<td>${flight.departureCity}</td>
<td>${flight.arrivalCity}</td>
<td>${flight.estimatedDepartureTime}</td>
<td><a href="showCompleteReservation?flightId=${flight.id}">select</a></td>

</tr>


</c:forEach>
</table>
</body>
</html>