<%-- 
    Document   : index
    Created on : 21/08/2018, 08:33:55 PM
    Author     : Wallas
--%>

<%@page import="Servicios.Mensajes.Msj"%>
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
        <%
            HttpSession ses = request.getSession(true);
            if (ses.getAttribute("msj") != null) {
                Msj m = (Msj) ses.getAttribute("msj");
                out.print(m.toString());
            }
        %>


    <nav style="background: #2e648f;" role="navigation">
        <div class="nav-wrapper container"><a id="logo-container" href="#" class="brand-logo"><img src="img/logo.png" width="50px" alt=""></a>
          <ul class="right hide-on-med-and-down">
            <li><a class="modal-trigger" href="#modal1">Ingresar</a></li>
          </ul>

          <ul id="nav-mobile" class="sidenav">
          <h1 style="color: black;"><img src="img/logo.png" width="100px" alt=""></h1>
            <li><a class="modal-trigger" href="#modal1">Ingresar</a></li>
          </ul>
          <a href="#" data-target="nav-mobile" class="sidenav-trigger"><i class="material-icons">menu</i></a>
        </div>
    </nav> 



        <!-- Modal Structure -->

        <div id="modal1" class="modal">
            <div class="modal-content center">
              <h4>Ingresar</h4>
              <div class="row">
                <form class="col s12">
                  <div class="row">
                    <div class="input-field col s12">
                      <i class="material-icons prefix">email</i>
                      <input id="email" type="email" class="validate">
                      <label for="email">correo</label>
                    </div>
                    <div class="input-field col s12">
                      <i class="material-icons prefix">https</i>
                      <input id="password" type="password" class="validate">
                      <label for="password">contraseña</label>
                    </div>
                    <div class="col s6">
                      <button class="btn waves-effect orange" type="submit" name="action">Ingresar
                        <i class="material-icons right">send</i>
                      </button>
                    </div>
                    <div class="col s6">
                      <a href="#!" class="modal-close waves-effect waves-green btn-flat">cancelar</a>
                    </div>
                  </div>
                </form>
              </div>
            </div>
        </div>

        <div class="slider">
            <ul class="slides">
              <li>
                <img src="img/buses1.jpeg"> <!-- random image -->
                <div class="caption center-align">
                  <h3>Mas de todo!!</h3>
                  <h5 class="light grey-text text-lighten-3">cooperativa de transporte</h5>
                </div>
              </li>
              <li>
                <img src="img/buses3.jpeg"> <!-- random image -->
                <div class="caption left-align">
                  <h3>Mas economico</h3>
                  <h5 class="light grey-text text-lighten-3">cooperativa de transporte</h5>
                </div>
              </li>
              <li>
                <img src="img/buses2.jpeg"> <!-- random image -->
                <div class="caption right-align">
                  <h3>Mas rapido</h3>
                  <h5 class="light grey-text text-lighten-3">cooperativa de transporte</h5>
                </div>
              </li>
              <li>
                <img src="img/buses4.jpg"> <!-- random image -->
                <div class="caption center-align">
                  <h3>Mas comodo</h3>
                  <h5 class="light grey-text text-lighten-3">cooperativa de transporte</h5>
                </div>
              </li>
            </ul>
        </div>

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
