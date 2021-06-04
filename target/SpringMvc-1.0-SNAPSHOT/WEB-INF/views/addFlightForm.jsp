<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <title>Add flight form</title>
</head>
<body>
    <% if(request.getParameter("error") != null){
        out.println("<h2>Please fill the form</h2>");
    }%>
    <form action="${pageContext.request.contextPath}/dashboard/add-flight" method="post">
        <label>Choose source >> destination</label>
        <br/>
        <br/>
        <select name="placeId">
            <c:forEach var="place" items="${placeList}">
                <option value="${place.id}">${place.source} >> ${place.destination}</option>
            </c:forEach>
        </select>
        <br/>
        <br/>
        <label>Choose airline</label>
        <br/>
        <br/>
        <select name="airlineId">
            <c:forEach var="airline" items="${airlineList}">
                <option value="${airline.id}">${airline.name}</option>
            </c:forEach>
        </select>
        <br/>
        <br/>
        <label>Price</label>
        <br/>
        <input name="price" type="number" min="0" value="0"/>
        <br/>
        <br/>
        <button type="submit">Add new flight</button>
    </form>
</body>
</html>
