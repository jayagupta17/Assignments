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
                <th>FlightId</th>
                <th>Source</th>
                <th>Destination</th>
                <th>Fare</th>
                <th>Seats</th>
            </tr>
            <c:forEach var = "flg" items = "${flights}">
                <tr>
                    <td>${flg.flightId}</td>
                    <td>${flg.source}</td>
                    <td>${flg.destination}</td>
                    <td>${flg.fare}</td>
                    <td>${flg.seats}</td>
                </tr>
            </c:forEach>
        </table>
        <form action = "addPassengerDetails" method=post>
            <table width="50%" align="center"   bgcolor="pink">
                      <tr>
                                               <th>FlightId</th>
                                               <td><input type="text" name="flightId"></td>
                                             </tr>
                       <tr>
                         <th>First Name</th>
                         <td><input type="text" name="fname"></td>
                       </tr>
                       <tr>
                         <th>Last Name</th>
                         <td><input type="text" name="lname"></td>
                       </tr>
                       <tr>
                                                <th>Mobile</th>
                                                <td><input type="text" name="mobile"></td>
                                              </tr>
                                              <tr>
                                                                       <th>Email</th>
                                                                       <td><input type="text" name="email"></td>
                                                                     </tr>
                       <tr>
                         <td><input type="submit"  value="Add"></td>
                         <td><input type="reset"   value="Reset"></td>
                       </tr>
            </table>
        </form>
    </body>
</html>