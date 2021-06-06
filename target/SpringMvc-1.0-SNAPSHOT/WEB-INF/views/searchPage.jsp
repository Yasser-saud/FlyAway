<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: yasse
  Date: 6/5/2021
  Time: 9:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Search result</title>
    <style>
        .parent{
            display: grid;
            place-content: center;
            height: 90vh;
        }
        .container{
            display: flex;
            flex-direction: column;
            width: 100vh;
            align-items: center;
            justify-content: space-evenly;
        }
        table.blueTable {
            border: 1px solid #1C6EA4;
            background-color: #EEEEEE;
            width: 100%;
            text-align: left;
            border-collapse: collapse;
        }
        table.blueTable td, table.blueTable th {
            border: 1px solid #AAAAAA;
            padding: 3px 2px;
        }
        table.blueTable tbody td {
            font-size: 13px;
        }
        table.blueTable tr:nth-child(even) {
            background: #D0E4F5;
        }
        table.blueTable thead {
            background: #1C6EA4;
            background: -moz-linear-gradient(top, #5592bb 0%, #327cad 66%, #1C6EA4 100%);
            background: -webkit-linear-gradient(top, #5592bb 0%, #327cad 66%, #1C6EA4 100%);
            background: linear-gradient(to bottom, #5592bb 0%, #327cad 66%, #1C6EA4 100%);
            border-bottom: 2px solid #444444;
        }
        table.blueTable thead th {
            font-size: 15px;
            font-weight: bold;
            color: #FFFFFF;
            border-left: 2px solid #D0E4F5;
        }
        table.blueTable thead th:first-child {
            border-left: none;
        }

    </style>
</head>
<body class="parent">
    <div class="container">
        <h1>Search result</h1>
        <table class="blueTable">
            <thead>
            <tr>
                <th>Source</th>
                <th>Destination</th>
                <th>Airline</th>
                <th>Price</th>
                <th>Book</th>
            </tr>
            </thead>
            <tbody>
            <jsp:useBean id="result" scope="request" type="java.util.List<com.example.SpringMvc.model.Flight>"/>
            <c:forEach var="flight" items="${result}">
                <tr>
                    <td>${flight.place.source}</td>
                    <td>${flight.place.destination}</td>
                    <td>${flight.airLine.name}</td>
                    <td>$${flight.price}</td>
                    <td><a href="${pageContext.request.contextPath}/checkout?fno=${flight.id}&pass=${pass}">Book this flight$</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>
