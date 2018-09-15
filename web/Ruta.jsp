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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0"/>
        <title>Agencia transporte</title>
        <!-- CSS  -->
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <link href="css/materialize.css" type="text/css" rel="stylesheet" media="screen,projection"/>
        <link href="css/style.css" type="text/css" rel="stylesheet" media="screen,projection"/>
    </head>
    <body>
        <h1>Hello World!</h1>
        <div class="row">
        <form action="ruta.do" method="get">
        <div class="input.field col s12 m12 l6">
            <input type="text" name="nombre" placeholder="nombre" />
        </div>
        <div class="input.field col s12 m12 l6">
            <input class="timepicker" type="text" name="horaini" placeholder="Hora de inicio"/>
        </div>
        <div class="input.field col s12 m12 l6">
            <input class="timepicker" type="text" name="horafin" placeholder="Horario final"/>
        </div>
        <div class="input.field col s12 m12 l6">        
            <input type="number" name="km" placeholder="Km"/>
        </div>
        <div class="input.field col s12 m12 l6">
            <input type="text" name="lugarinicio" placeholder="Lugar de inicio"/>
        </div>
        <div class="input.field col s12 m12 l6">
            <input type="text" name="lugarfin" placeholder="Lugar de llegada">
        </div>
        <div class="input.field col s12 m12 l12 center">
            <input class="btn" type="submit" name="Accion" value="Registrar">
        </div>
        </form>
        </div>


    <script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
    <script src="js/materialize.js"></script>
    <script src="js/init.js"></script>
    </body>
</html>
