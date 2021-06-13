<%--
  Created by IntelliJ IDEA.
  User: yasse
  Date: 6/4/2021
  Time: 12:50 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin login</title>
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
        <h1>Login</h1>
        <%
            if(request.getParameter("error") != null){
                String param = request.getParameter("error");
                if(param.equals("2")){
                    out.println("<h3>username does not exist</h3>");
                }
                else if(param.equals("3")){
                    out.println("<h3>username or password is wrong</h3>");
                }
                else {
                    out.println("<h3>Please fill the field</h3>");
                }
            }%>
        <form class="form" action="login" method="post">
            <div>
                <label>username</label>
                <br/>
                <input name="username" type="text">
                <br/>
                <label>password</label>
                <br/>
                <input name="password" type="password">
                <br/>
            </div>
            <button type="submit">Login</button>
        </form>
    </div>
</body>
</html>
