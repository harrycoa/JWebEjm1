<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ESTE ES MI PRIMER PROYECTO CON SPRING</title>
    </head>

    <body>
       ESTOY EN LA EDICION DE UNA MARCA

        <form action="edit_marca" method="post">
            <input name="id_marca" type="hidden"    value="${me.idMarca}" >
            <input name="nombre" type="text"      value="${me.nombre}">
            <input name="descripcion" type="text"  value="${me.descripcion}">
            <button type="submit" class="btn btn-success">Guardar</button>
        </form>
</body>
</html>
