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
       <h1>Add Flight</h1>
       <% if(request.getParameter("error") != null){
           out.println("<h2>Please fill the form</h2>");
       }%>
       <form class="form" action="${pageContext.request.contextPath}/dashboard/add-flight" method="post">
           <div>
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
           </div>
           <button type="submit">Add new flight</button>
       </form>
   </div>
</body>
</html>
