<%--
  Created by IntelliJ IDEA.
  User: yasse
  Date: 6/6/2021
  Time: 7:56 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Checkout</title>
</head>
<body>
    <% if(request.getParameter("error")!=null){
        out.println("<h1>please fill the form</h1>");
    }%>
    <form method="post" action="${pageContext.request.contextPath}/register">
        <label>Username</label>
        <br/>
        <input name="username"/>
        <br/>
        <label>password</label>
        <br/>
        <input name="password"/>
        <br/>
        <button type="submit">Register</button>
    </form>
</body>
</html>
