<%-- 
    Document   : Rol
    Created on : 23/08/2018, 07:51:51 PM
    Author     : freyd
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <form action="rols.do" method="get">
        <div class="input.field col s12 m12 l6">
            <input type="text" name="nombre" placeholder="nombre"/>
        </div>
        <div class="input.field col s12 m12 l6">
            <input type="text" name="detalles" placeholder="detalles"/>
        </div>
        <div class="input.field col s12 m12 l6">
            <input type="checkbox" name="estado"/>
        </div>            
        </form>
            <input type="submit" name="Accion" value="Registrar">
    </body>
</html>
