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
    <style>
        body{
            display: grid;
            place-content: center;
            height: 100vh;
            font-size: 20px;
        }
        .container{
            display: flex;
            flex-direction: column;
            justify-content: space-between;
            align-items: center;
        }
        .form{
            display: flex;
            flex-direction: column;
            justify-content: space-between;
            align-items: center;
            height: 200px;
        }
        input{
            height: 35px;
            width: 300px;
        }
        button{
            height: 35px;
            width: 250px;
        }
    </style>
</head>
<body>

    <div class="container">
        <h1>Register</h1>
        <%
            if(request.getParameter("error") != null){
                String param = request.getParameter("error");
                if(param.equals("2")){
                    out.println("<h3 style=\"color: red\">Username is taken</h3>");
                }
                else {
                    out.println("<h3 style=\"color: red\">Please fill the form</h3>");
                }
            }%>
        <form class="form" method="post" action="${pageContext.request.contextPath}/register">
           <div>
               <label>Username</label>
               <br/>
               <input name="username"/>
               <br/>
               <label>password</label>
               <br/>
               <input name="password"/>
               <br/>
           </div>
            <button type="submit">Register</button>
        </form>
    </div>
</body>
</html>
