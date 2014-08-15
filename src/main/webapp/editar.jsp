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
        <title>Editar contactos</title>
        <link type="text/css" rel="stylesheet" href="CSS/editarCSS.css"/>
        <link rel="shortcut icon" type="image/x-icon" href="imagenes/Agenda.png">
        <script type="text/javascript" src="JavaScript/agendaJS.js"/></script>
</head>
<body >

    <form method="POST" action="Servlet" id="formularioAgenda">
        <%
            String msg1 = (String) session.getAttribute("Valor1");
            String msg2 = (String) session.getAttribute("Valor2");
            String msg3 = (String) session.getAttribute("Valor3");
            String msg4 = (String) session.getAttribute("Valor4");
            String msg5 = (String) session.getAttribute("Valor5");
        %> 
        <table class="datos">
            <tr><td>
                    <h1>Editar contacto</h1>
                    <label>Nombre:</label> 
                    <input type="text" name="nombreED" min ="3" maxlength="45" class="nombre" value="<%=msg1%>"><br/>

                    <label>Apellido:</label> 
                    <input type="text" name="apellidoED" min="3" maxlength="45" class="apellido" value="<%=msg2%>"><br/>

                    <label>Telefono:</label> 
                    <input type="text" name="telefonoED" class="telefono" value="<%=msg3%>"><br/>

                    <label>Celular:</label>  
                    <input type="text" name="celularED" class="celular" value="<%=msg4%>"><br/>

                    <label>Email: </label>   
                    <input type="email" name="emailED" min="11" maxlength="45" class="email" value="<%=msg5%>"><br/>
                    <label class="agregadoED"> <%if (Session.getAttribute("editado") != null) {
                            out.println(Session.getAttribute("editado"));
                        }%></label><br/><br/>
                    <div>
                        <input type="submit" value="Atras" name="botonAtras1" class="btnAtras1">
                        <input type="submit" value="Actualizar" name="botonActualizar" onclick="return validarAgenda()" class="btnActualizar">
                        <input type="submit" value="Inicio" name="botonInicio" class="btnInicio">
                    </div>
                </td></tr>
        </table> 
    </form>

</body>
</html>
