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
            height: 300px;
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
            height: 200px;
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
    </style>
</head>
<body>
    <div class="container">
        <h1>Checkout</h1>
        <form class="form" action="${pageContext.request.contextPath}/checkout" method="post">
            <div>
                <label>Full name</label>
                <br/>
                <input name="fname" type="text"/>
                <br/>
                <label>Credit card number</label>
                <br/>
                <input name="cc" type="text"/>
                <br/>
            </div>
            <button type="submit">Book</button>
        </form>
    </div>
</body>
</html>
