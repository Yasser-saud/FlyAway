<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>FlyAway</title>
    <style>
        body{
            height: 90vh;
            display: grid;
            place-content: center;
            font-size: 20px;
        }
        .container{
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
            width: 500px;
        }
        .form{
            height: 100%;
            display: flex;
            justify-content: space-between;
            flex-direction: column;
            align-items: center;
        }
        .formWrapper{
            width: 100%;
            display: grid;
            min-height: 400px;
        }
        input{
            height: 35px;
            width: 300px;
            margin-bottom: 10px;
        }
        button{
            width: 200px;
            height: 35px;
            cursor: pointer;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>FlyAway</h1>

        <% if(request.getParameter("error") != null){
            out.println("<h3 style=\"color: red\">Please fill the form</h3>");
        }%>

        <div class="formWrapper">
            <form class="form" method="get" action="${pageContext.request.contextPath}/search">
                <div>
                    <label>Source</label>
                    <br/>
                    <input name="source" type="text"/>
                    <br/>
                    <label>Destination</label>
                    <br/>
                    <input name="destination" type="text"/>
                    <br/>
                    <label>Date</label>
                    <br/>
                    <input name="date" type="date"/>
                    <br/>
                    <label>Passengers</label>
                    <br/>
                    <input name="passengers" type="text"/>
                    <br/>
                </div>
                <button type="submit">Search</button>
                <br/>
            </form>
        </div>
        <a href="login">Admin dashboard</a>
    </div>

</body>
</html>