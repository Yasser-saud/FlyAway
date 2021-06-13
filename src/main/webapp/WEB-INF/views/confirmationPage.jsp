<%--<jsp:useBean id="flight" scope="request" type="com.example.SpringMvc.model.Flight"/>--%>
<%--
  Created by IntelliJ IDEA.
  User: yasse
  Date: 6/6/2021
  Time: 5:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Confirmation</title>
    <style>
        body{
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .container{
            display: flex;
            flex-direction: column;
            justify-content: space-evenly;
            align-items: flex-start;

        }
        table.customTable {
            width: 100%;
            background-color: #FFFFFF;
            border-collapse: collapse;
            border-width: 2px;
            border-color: #7EA8F8;
            border-style: solid;
            color: #000000;
        }

        table.customTable td, table.customTable th {
            border-width: 2px;
            border-color: #7EA8F8;
            border-style: solid;
            padding: 5px;
            text-align: center;
        }

        table.customTable thead {
            background-color: #80a1e9;
        }
        .wrapper{
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: space-around;
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="wrapper">
            <h1>Congratulations</h1>
            <h3>Ticket Information can be found below</h3>
            <table class="customTable">
                <thead>
                <tr>
                    <th>Name</th>
                    <th>Date</th>
                    <th>Source</th>
                    <th>destination</th>
                    <th>Airlines</th>
                    <th>Passengers</th>
                    <th>Ticket number</th>
                    <th>Payment Status</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>${ticket.fname}</td>
                    <td>${ticket.date}</td>
                    <td>${ticket.flight.place.source}</td>
                    <td>${ticket.flight.place.destination}</td>
                    <td>${ticket.flight.airLine.name}</td>
                    <td>${ticket.pass}</td>
                    <td>${ticket.ticketNumber}</td>
                    <td style="color: #44c044">Done</td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
</body>
</html>
