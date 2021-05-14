<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            body{
                padding: 30px;
            }
            .top{
                margin: none;
            }
            .menu{
                float: right;
            }
            .menu li{
                display: inline-block;
            }
            .menu a{
                color: blue;
                text-decoration: none;
            }
            h1{
                text-align: center;
            }
        </style>
    </head>
    <body>
        <header>
                <ul class="menu top">
                    <li><a href="#">Administrador</a></li>
                    <li><a href="#">Salir</a></li>			
                </ul>
        </header>
        <br>
        <h1><font face="Comic Sans MS">Blog de Salud</font></h1>
        
        <p><a href="Inicio?action=add">Nueva entrada</a></p>        
        <c:forEach var ="item" items="${posts}">
        
        ${item.fecha} 
        <h3>${item.titulo}</h3>
        ${item.contenido}
        <p align="right"><a href="Inicio?action=edit&id=${item.id}">Editar </a>
        <a href="Inicio?action=delete&id=${item.id}">Eliminar</a></p>   
        Autor: Administrador
        <hr>
        </c:forEach>       
    </body>
</html>
