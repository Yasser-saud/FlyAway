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
       <h1>Add Place</h1>
       <% if(request.getParameter("error") != null){
           out.println("<h2>Please fill the form</h2>");
       }%>
       <form class="form" action="${pageContext.request.contextPath}/dashboard/add-place" method="post">
           <div>
               <label>source</label>
               <br/>
               <input name="source">
               <br/>
               <label>destination</label>
               <br/>
               <input name="destination">
               <br/>
           </div>
           <button type="submit">Add</button>
       </form>
   </div>
</body>
</html>
