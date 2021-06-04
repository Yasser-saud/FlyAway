<%--
  Created by IntelliJ IDEA.
  User: yasse
  Date: 6/4/2021
  Time: 3:09 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <% if(request.getParameter("error") != null){
        out.println("<h2>Please fill the form</h2>");
    }%>
    <form action="${pageContext.request.contextPath}/dashboard/add-place" method="post">
        <label>source</label>
        <br/>
        <input name="source">
        <br/>
        <label>destination</label>
        <br/>
        <input name="destination">
        <br/>
        <button type="submit">Add</button>
    </form>
</body>
</html>
