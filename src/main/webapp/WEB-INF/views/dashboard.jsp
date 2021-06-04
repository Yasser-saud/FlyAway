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
        .header{
            width: 100%;
            display: flex;
            justify-content: space-between;
            align-items: center;
        }
        .flight-container{
            font-size: 13px;
            width: 100%;
            display: flex;
            justify-content: space-around;
            align-items: center;
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
    </style>
</head>
<body class="container">
    <h1>Dashboard</h1>
    <div class="wrapper">
        <div>
            <div class="col-wrapper">
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
                <a class="btn" href="dashboard/add-place">Add Places</a>
            </div>
        </div>

        <div>
           <div class="col-wrapper">
               <div class="col">
                   <h2>AirLines</h2>
                   <c:forEach items="${airLineList}" var="airline">
                       <p>${airline.name}</p>
                   </c:forEach>
               </div>
               <a class="btn" href="dashboard/add-airline">Add AirLine</a>
           </div>
        </div>
        <div class="col-wrapper">
            <div class="col">
                <h2>Flights</h2>
                <c:forEach items="${flightList}" var="flight">
                    <div class="flight-container">
                        <p>${flight.getPlace().getSource()}</p>
                        >>
                        <p>${flight.getPlace().getDestination()}</p>
                        <p>✈ ${flight.getAirLine().getName()}</p>
                        <p>$${flight.price}</p>
                    </div>
                </c:forEach>
            </div>
            <a class="btn" href="dashboard/add-flight">Add Flight</a>
        </div>
    </div>
</body>
</html>

