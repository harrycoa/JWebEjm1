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
        <p>Harry.</p>
        <p><i>Proyecto Spring</i>         
            
            
            <form action="save_marca" method="post">
                <input name="nombre" type="text" class="form-control" placeholder="Toyota">
                <input name="descripcion" type="text" class="form-control" placeholder="Marca Japonesa">
                <button type="submit" class="btn btn-success">Guardar</button>
            </form>
            <br>
            <table style="border:1px solid black">
            <thead>
                <th>Accion</th>
                <th>Accion</th>
                <th>Nombre</th>
                <th>Descripcion</th>
            </thead>
            <tbody>
                <c:forEach items="${lista_marcas}" var="obj">
                    <tr>    
                        <td style="border:1px solid black">
                            
                            <form action="eliminar_marca" method="post">
                                <input name="id_marca" type="hidden" value="${obj.idMarca}">                             
                                <button type="submit" class="btn btn-success">Eliminar</button>
                            </form>                            
                                                      </td>
                        <td style="border:1px solid black">
                             <form action="view_edit_marca" method="post">
                                <input name="id_marca" type="hidden" value="${obj.idMarca}">
                                <button type="submit" class="btn btn-success">Editar</button>
                            </form>
                        </td>
                        
                        <td style="border:1px solid black">${obj.nombre}</td>
                        <td style="border:1px solid black" >${obj.descripcion}</td>
                    </tr>
                </c:forEach>
            </tbody>        
        </table>
        

            
    </body>
</html>
