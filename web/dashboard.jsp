<%-- 
    Document   : dashboard
    Created on : Jul 27, 2016, 12:06:43 PM
    Author     : Kevin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Tareas Test Page</h1>
        <c:forEach items="${proyectos}" var="proyecto">
            <c:forEach items="${tareas}" var="tarea">
                <c:if test="${tarea.id_proyecto == proyecto.id}">
                    <h4>${proyecto.nombre}</h4>
                    <p>   Titulo: ${tarea.titulo} | Estado: ${tarea.estado}   </p>
                </c:if>
            </c:forEach>
        </c:forEach>
    </body>
</html>
