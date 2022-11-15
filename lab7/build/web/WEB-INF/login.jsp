<%-- 
    Document   : login
    Created on : Nov 12, 2022, 12:40:41 p.m.
    Author     : joshs
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Login</h1>
        
        <h2>${message}</h2>
        
        <form action="login" method="post">
            <label>Username: <input type="text" name="username"></label>
            <label>Password: <input type="password" name="password"></label> 
            <button type="submit">Submit</button>

        </form>
    </body>
</html>
