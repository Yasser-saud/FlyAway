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
</head>
<body>
    <h1>Login</h1>
    <% if(request.getParameter("error") != null){
        out.println("<h3>username or password is wrong</h3>");
    }%>
    <form action="login" method="post">
        <label>username</label>
        <br/>
        <input name="username" type="text">
        <br/>
        <label>password</label>
        <br/>
        <input name="password" type="password">
        <br/>
        <button type="submit">Login</button>
    </form>
</body>
</html>
