<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            justify-content: space-between;
        }
        .col{
            background-color: beige;
            max-width: 500px;
            min-width: 300px;
            height: 50vh;
            overflow: scroll;
            display: flex;
            flex-direction: column;
            justify-content: flex-start;
            align-items: center;
            padding: 0 20px;
        }
        .header{
            width: 100%;
            display: flex;
            justify-content: space-between;
            align-items: center;
        }
    </style>
</head>
<body class="container">
    <h1>Dashboard</h1>
    <div class="wrapper">
        <div>
            <div class="col">
                <h2>Places</h2>
                <div class="header">
                    <p><strong>Source</strong></p>
                    <p><strong>Destination</strong></p>
                </div>
                <c:forEach items="${placeList}" var="place">
                    <div class="header">
                        <p>${place.source}</p>
                        >>>
                        <p>${place.destination}</p>
                    </div>
                </c:forEach>
            </div>
            <a href="dashboard/add-place">Add Places</a>
        </div>
        <div class="col">
            flights
        </div>
        <div class="col">
            Airlines
        </div>
    </div>
</body>
</html>

