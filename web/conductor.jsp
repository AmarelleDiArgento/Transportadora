<%-- 
    Document   : conductor
    Created on : 5/09/2018, 02:53:26 PM
    Author     : HP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0"/>
        <title>conductor</title>
        <!-- CSS  -->
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <link href="css/materialize.css" type="text/css" rel="stylesheet" media="screen,projection"/>
        <link href="css/style.css" type="text/css" rel="stylesheet" media="screen,projection"/>
    </head>
<body>
<%@ include file="includes/menu.jsp"  %>
        <h1>Hello </h1>

<div class="row" style="margin: 0;">
  <div class=" col s12 m12 l4 z-depth-1">
    <p>nombre: conductor</p>
    <p>telefono:</p>
    <p>dirección:</p>
  </div>
</div>

    <table class="responsive-table striped center">
        <thead>
          <tr>
              <th>Nombre</th>
              <th>Placa</th>
              <th>Ruta</th>
              <th>Fecha</th>
          </tr>
        </thead>

        <tbody>
          <tr>
            <td>Alvin</td>
            <td>Ecl836</td>
            <td>8</td>
            <td>08/09/2018</td>
          </tr>
          <tr>
            <td>Alan</td>
            <td>Jel537</td>
            <td>6</td>
            <td>08/09/2018</td>
          </tr>
          <tr>
            <td>Jonathan</td>
            <td>Lol645</td>
            <td>7</td>
            <td>08/09/2018</td>
          </tr>
        </tbody>
    </table>

    
    <footer class="page-footer" style="background: #e68900;">
        <div class="container">
          Made by <a class="orange-text text-lighten-3" href="">SENA</a>
        </div>
    </footer>


    <!--  Scripts-->
    <script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
    <script src="js/materialize.js"></script>
    <script src="js/init.js"></script>


</body>
</html>
