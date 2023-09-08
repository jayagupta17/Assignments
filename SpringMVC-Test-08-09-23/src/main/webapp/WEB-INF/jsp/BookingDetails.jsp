<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib   prefix="c"     uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Flights</title>
    </head>
    <body>
        <table>
            <tr>
                <th>PassengerId</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Mobile</th>
                <th>Email</th>
                <th>FlightId</th>
                <th>Source</th>
                <th>Destination</th>
                <th>Fare</th>
            </tr>
            <tr>
                <td>${passenger.passengerId}</td>
                <td>${passenger.firstName}</td>
                <td>${passenger.lastName}</td>
                <td>${passenger.mobile}</td>
                <td>${passenger.email}</td>
                <td>${flight.flightId}</td>
                <td>${flight.source}</td>
                <td>${flight.destination}</td>
                <td>${flight.fare}</td>
            </tr>
        </table>
    </body>
</html>