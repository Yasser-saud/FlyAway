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
