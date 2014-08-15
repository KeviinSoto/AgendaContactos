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
        <title>Listado de contactos</title>
        <link type="text/css" rel="stylesheet" href="CSS/mostrarCSS.css"/>
        <link rel="shortcut icon" type="image/x-icon" href="imagenes/contact-list.png">
        <script type="text/javascript" src="JavaScript/mostrarJS.js"/></script>
</head>
<body> 
    <form method="POST" action="Servlet" id="formularioMostrar">

        <%
            String msg = (String) session.getAttribute("Lista");
            if (msg == null || msg == "") {
                msg = "NO EXISTE USUARIO CON ESE DATO.";
            }
        %>
        <table class="mostarr">
            <tr><td>
                    <h1>Mostrando contactos</h1>
                    <label class="lblBuscar">Intruduzca la informacion del contacto que desea buscar:</label><br/>
                    <input type="text" name="buscar" class="buscar">
                    <input type="submit" value="Buscar" name="botonBuscar" class="btnBuscar" onclick="return validarBusqueda()"><br/>
                    <textarea name="AreaListado" rows="10" cols="160" disabled="true" class="txtArea"><%=msg%></textarea><br/>
                    <label>Introduza el numero de order del contacto para eliminarlo o editarlo:</label>
                    <input type="text" name="posicion" size="5" max="5" min="1" class="txt">
                    <input type="submit" value="Eliminar" name="botonEliminar" class="btnBorrar" onclick="return validarEliminacion()">
                    <input type="submit" value="Editar" name="botonEditar" class="btnEditar" onclick="return validarEliminacion()">
                    <input type="submit" value="Listar todos" name="botonListarTodo" class="btnListarTodos">
                    <br><br>
                    <input type="submit" value="Atras" name="botonAtras" class="btnAtras">
                </td></tr>
        </table>
    </form>
</body>
</html>
