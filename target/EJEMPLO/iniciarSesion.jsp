<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Inicio de sesión</title>
        <link rel="shortcut icon" type="image/x-icon" href="imagenes/session.png">
        <link type="text/css" rel="stylesheet" href="CSS/iniciarSesionCSS.css"/>
        <script type="text/javascript" src="JavaScript/iniciarSesionJS.js"/></script>
</head>
<body>  
    <form action="Servlet" method="POST" id="formulario" onsubmit="return validarInicioDeSesion()">
        <table class="iniciarSesion" >
            <tr><td>
                    <h1>Iniciar sesión</h1>
                    <label><%
                        if (request.getParameter("error") != null) {
                            out.println(request.getParameter("error"));
                        }
                        %></label><br/> 
                    <label>Usuario:</label>
                    <input type="text" name="usuario" class="usuario"/><br/>
                    <label>Contraseña:</label>
                    <input type="password" name="password" class="password"/><br/>
                    <label> <%if (request.getAttribute("incorrecto") != null) {
                            out.println(request.getAttribute("incorrecto"));
                        }%></label>
                    <input type="submit" value="Iniciar sesión" name ="botonIniciarSesion" class="boton"/>
                </td></tr>
        </table>
    </form>
</body>
</html>
