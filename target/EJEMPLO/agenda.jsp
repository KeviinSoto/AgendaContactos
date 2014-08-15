<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String usuario = "";
    HttpSession Session = request.getSession();
    if (Session.getAttribute("usuario") == null) {
%>
<jsp:forward page="iniciarSesion.jsp">
    <jsp:param name="error" value="Es obligatorio identificarse para acceder a esta seccion"/>
</jsp:forward>
<%
    } else {
        usuario = (String) Session.getAttribute("usuario");
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <title>Agenda contactos</title>
        <link type="text/css" rel="stylesheet" href="CSS/agendaCSS.css"/>
        <link rel="shortcut icon" type="image/x-icon" href="imagenes/Agenda.png">
        <script type="text/javascript" src="JavaScript/agendaJS.js"/></script>
    </head>
    <body >
       
        <form method="POST" action="Servlet" id="formularioAgenda">
            <input type="submit" value="Cerrar sesión" name="botonCerrarSesion" class="btnCerrarSesion">
            <table class="datos">
                <tr><td>
                        <h1>Agenda contactos</h1>
                        
                        <label>Nombre:</label> 
                        <input type="text" name="nombre" min ="3" maxlength="45" class="nombre"><br/>

                        <label>Apellido:</label> 
                        <input type="text" name="apellido" min="3" maxlength="45" class="apellido"><br/>

                        <label>Telefono:</label> 
                        <input type="text" name="telefono" class="telefono"><br/>

                        <label>Celular:</label>  
                        <input type="text" name="celular" class="celular"><br/>

                        <label>Email: </label>   
                        <input type="email" name="email" min="11" maxlength="45" class="email"><br/>
                        <label class="agregado"> <%if (Session.getAttribute("agregado") != null) {
                            out.println(Session.getAttribute("agregado"));
                        }%></label><br/><br/>
                        <div>
                            <input type="submit" value="Limpiar" name="botonLimpiar" class="btnLimpiar">
                            <input type="submit" value="Insertar" name="botonInsertar" class="btnInsertar" onclick="return validarAgenda()">
                            <input type="submit" value="Listar" name="botonListar" class="btnListar">
                        </div>
                    </td></tr>
            </table> 
        </form>
    </body>
</html>
