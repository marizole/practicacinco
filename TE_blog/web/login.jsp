<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <center><h1>Login </h1></center>
    <form action="LoginSession" method="POST">    
        <input type="hidden" name="id" value="${usu.id}"/>
        <br>
        <label>Usuario: </label>
        <input type="text" name='usuario' value='${usu.usuario}'><br>
        <br>
        <label>Clave:</label>
        <input type="text" name="password" value="${usu.password}"><br>
        <br>
        <a href="index.jsp" ><input type="submit" value="Ingresar"></a>
    </form>
    
</body>
</html>
