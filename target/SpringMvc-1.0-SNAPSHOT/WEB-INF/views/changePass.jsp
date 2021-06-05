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
</head>
<body>
<% if(request.getParameter("error") != null){
    out.println("<h1>please fill the form</h1>");
}%>
<form action="${pageContext.request.contextPath}/admin/reset" method="post">
    <h1>Reset password</h1>
    <label>password</label>
    <br/>
    <input name="password" type="password">
    <br/>
    <button type="submit">Reset</button>
</form>
</body>
</html>
