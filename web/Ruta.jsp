<%-- 
    Document   : Ruta
    Created on : 5/09/2018, 09:52:34 AM
    Author     : Wallas
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
        <form action="ruta.do" method="get">
            <input type="text" name="nombre" placeholder="Nombre"/>
            <input type="time" name="horaini" placeholder="Hora de inicio"/>
            <input type="time" name="horafin" placeholder="Horario final"/>
            <input type="number" name="km" placeholder="Km"/>
            <input type="text" name="lugarinicio" placeholder="Lugar de inicio"/>
            <input type="text" name="lugarfin" placeholder="Lugar de llegada">
            <input type="submit" name="Accion" value="Registrar">
        </form>
    </body>
</html>
