<%--
  Created by IntelliJ IDEA.
  User: yasse
  Date: 6/6/2021
  Time: 5:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Checkout</title>
    <style>
        body{
            height: 100vh;
            display: grid;
            place-content: center;
            font-size: 20px;
        }
        .container{
            height: auto;
            display: flex;
            flex-direction: column;
            justify-content: space-around;
            align-items: center;

        }
        .form{
            display: flex;
            align-items: center;
            flex-direction: column;
            justify-content: space-around;
            height: 500px;
        }
        input{
            height: 35px;
            width: 300px;
            margin-bottom: 10px;
        }
        button{
            height: 35px;
            width: 250px;
        }
        .wrapper{
            display: flex;
            flex-direction: row-reverse;
            align-items: flex-start;
            justify-content: space-around;
            width: 800px;
            height: auto;
        }
        .flight{
            display: flex;
            flex-direction: column;
            align-items: center;
        }
        .card{
            display: flex;
            flex-direction: column;
            margin: 30px 0;
        }
        small{
            color: #949494;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Checkout</h1>
        <div class="wrapper">
            <div class="flight">
                <h4>Flight Details</h4>
                <div>
                    <hr/>
                    <p>From: <strong>${flight.place.source}</strong></p>
                    <p>To: <strong>${flight.place.destination}</strong></p>
                    <p>Airline: <strong>${flight.airLine.name}</strong></p>
                    <p>Price: <strong>$${flight.price}</strong></p>
                </div>
            </div>

            <form class="form" action="${pageContext.request.contextPath}/checkout" method="post">
                <%
                    if(request.getParameter("error") != null){
                        String param = request.getParameter("error");
                        if(param.equals("2")){
                            out.println("<h4 style=\"color: red\">please enter a valid credit card number</h3>");
                        }
                        else if(param.equals("3")){
                            out.println("<h4 style=\\\"color: red\\\">please enter a valid security code</h3>");
                        }
                        else {
                            out.println("<h4 style=\"color: red\">Please complete the field</h3>");
                        }
                    }%>
                <div>
                    <label>Full name</label>
                    <br/>
                    <input name="fname" type="text"/>
                    <br/>
                    <div class="card">
                        <label>Credit card number</label>
                        <br/>
                        <input name="cardNum" type="text"/>
                        <br/>
                        <small>◾ Only numbers</small>
                        <small>◾ Minimum 10 numbers</small>
                        <small>◾ Maximum 20 numbers</small>
                        <br/>
                    </div>
                    <label>Security code</label>
                    <br/>
                    <input name="cc" type="text">
                    <br/>
                    <small>◾ 3 numbers on the back of the card</small>
                    <br/>
                </div>
                <button type="submit">Book</button>
            </form>
        </div>
    </div>
</body>
</html>
