<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
    <h1>FlyAway</h1>
    <br/>
    <br/>
    <form method="get" action="${pageContext.request.contextPath}/search">
        <label>Source</label>
        <br/>
        <input name="source"/>
        <br/>
        <label>Destination</label>
        <br/>
        <input name="destination"/>
        <br/>
        <label>Date</label>
        <br/>
        <input name="date"/>
        <br/>
        <label>Passengers</label>
        <br/>
        <input name="passengers"/>
        <br/>
        <button type="submit">Search</button>
        <br/>
    </form>
    <a href="login">Admin dashboard</a>

</body>
</html>