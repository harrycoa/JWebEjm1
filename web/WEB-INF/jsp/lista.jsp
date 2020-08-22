<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bienvenido</title>
    </head>

    <body>
        <p>Haaaarry.</p>
        <p><i>Proyecto Spring</i>         
            
            
            <form action="save_marca" method="post">
                <input name="nombre" type="text" class="form-control" placeholder="Toyota">
                <input name="descripcion" type="text" class="form-control" placeholder="Marca Japonesa">
                <button type="submit" class="btn btn-success">Guardar</button>
            </form>
            
             <c:forEach items="${lista_marcas}" var="obj">
                <li>${obj.nombre} - ${obj.descripcion}</li>
             </c:forEach>
            
    </body>
</html>
