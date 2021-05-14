<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>
            <c:if test="${blog.id == 0}">Nuevo</c:if>
            <c:if test="${blog.id != 0}">Editar</c:if>
            Nueva / Editar entrada
        </h1> <hr>
         <form action="Inicio" method="POST">    
                <input type="hidden" name="id" value="${blog.id}"/>
                <br>
                <label>Fecha: </label>
                <input type="date" name='fecha' value='${blog.fecha}'><br>
                <br>
                <label>Titulo:</label>
                <input type="text" name="titulo" value="${blog.titulo}"><br>
                <br>
                <label>Contenido:</label>
                <br>
                <textarea name="contenido" cols="40" rows="5">${blog.contenido}</textarea><br>
                <br>
                <input type="submit" value="Enviar">
        </form>
    </body>
</html>
