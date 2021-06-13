<%--
  Created by IntelliJ IDEA.
  User: yasse
  Date: 6/5/2021
  Time: 4:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Password reset</title>
    <style>
        body{
            height: 100vh;
            display: grid;
            place-content: center;
            font-size: 20px;
        }
        .container{
            height: 400px;
            display: flex;
            flex-direction: column;
            justify-content: space-around;
            align-items: center;
        }
        .form{
            display: flex;
            flex-direction: column;
            justify-content: space-around;
            align-items: center;
            height: 100%;
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
        <h1>Change Password</h1>
        <% if(request.getParameter("error") != null){
            out.println("<h3>please fill the form</h3>");
        }%>
        <form class="form" action="${pageContext.request.contextPath}/admin/reset" method="post">
            <div>
                <label>password</label>
                <br/>
                <input name="password" type="password">
                <br/>
            </div>
            <button type="submit">Change</button>
        </form>
    </div>
</body>
</html>
