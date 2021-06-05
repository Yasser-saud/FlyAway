<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.example.SpringMvc.model.Place" %>
<%--
  Created by IntelliJ IDEA.
  User: yasse
  Date: 6/4/2021
  Time: 1:26 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dashboard</title>
    <style>
        .container{
            display: flex;
            flex-direction: column;
            justify-content: space-around;
            align-items: center;
        }
        .wrapper{
            width: 100%;
            display: flex;
            justify-content: space-evenly;
        }
        .col{
            background-color: #eeeeee;
            max-width: 500px;
            min-width: 300px;
            height: 50vh;
            overflow: scroll;
            overflow-x: hidden;
            display: flex;
            flex-direction: column;
            justify-content: flex-start;
            align-items: center;
            padding: 0 20px;
            border-radius: 8px;
        }
        .inner-container{
            width: 100%;
            display: flex;
            justify-content: space-between;
            align-items: center;
        }
        .inner-container-items > p{
            display: flex;
            justify-content: center;
            align-items: center;
            min-width: 50px;
        }
        .col-wrapper{
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: space-evenly;
            height: 70vh;
        }
        .btn{
            background-color: #094dec;
            color: white;
            padding: 10px 30px;
            text-decoration: none;
            border-radius: 50px;

        }
        table.greyGridTable {
            border: 2px solid #FFFFFF;
            width: 100%;
            text-align: center;
            border-collapse: collapse;
            border-radius: 8px;
        }
        table.greyGridTable td, table.greyGridTable th {
            border: 1px solid #FFFFFF;
            padding: 3px 4px;
        }
        table.greyGridTable tbody td {
            font-size: 10px;
        }
        table.greyGridTable td:nth-child(even) {
            background: #EBEBEB;
        }
        table.greyGridTable thead {
            background: #FFFFFF;
            border-bottom: 4px solid #333333;
        }
        table.greyGridTable thead th {
            font-size: 12px;
            font-weight: bold;
            color: #333333;
            text-align: center;
            border-left: 2px solid #333333;
        }
        table.greyGridTable thead th:first-child {
            border-left: none;
        }

    </style>
</head>
<body class="container">
    <h1>Dashboard</h1>
    <a class="btn" href="${pageContext.request.contextPath}/">Home page</a>
    <a href="${pageContext.request.contextPath}/admin/reset">Change password</a>
    <div class="wrapper">
        <div>
            <div class="col-wrapper">
                <div class="col">
                    <h2>Places</h2>
                    <div class="inner-container">
                        <p><strong>Source</strong></p>
                        <p><strong>Destination</strong></p>
                    </div>
                    <c:forEach items="${placeList}" var="place">
                        <div class="inner-container-items inner-container">
                            <p>${place.source}</p>
                            <p>➡</p>
                            <p>${place.destination}</p>
                        </div>
                    </c:forEach>
                </div>
                <a class="btn" href="dashboard/add-place">Add Places</a>
            </div>
        </div>

        <div>
           <div class="col-wrapper">
               <div class="col">
                   <h2>Airlines</h2>
                   <c:forEach items="${airlineList}" var="airline">
                       <p>✈ ${airline.name}</p>
                   </c:forEach>
               </div>
               <a class="btn" href="dashboard/add-airline">Add Airline</a>
           </div>
        </div>
        <div class="col-wrapper">
            <div class="col">
                <h2>Flights</h2>
                <table class="greyGridTable">
                    <thead>
                    <tr>
                        <th>Source</th>
                        <th>Destination</th>
                        <th>Airline</th>
                        <th>Price</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${flightList}" var="flight">
                        <tr>
                            <td>${flight.getPlace().getSource()}</td>
                            <td>${flight.getPlace().getDestination()}</td>
                            <td>✈ ${flight.getAirLine().getName()}</td>
                            <td>$ ${flight.price}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
            <a class="btn" href="dashboard/add-flight">Add Flight</a>
        </div>
    </div>
</body>
</html>

