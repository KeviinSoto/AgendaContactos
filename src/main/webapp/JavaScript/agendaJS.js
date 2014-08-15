function validarAgenda()
{
    var nombre = document.forms["formularioAgenda"]["nombre"].value;
    var apellido = document.forms["formularioAgenda"]["apellido"].value;
    var telefono = document.forms["formularioAgenda"]["telefono"].value;
    var celular = document.forms["formularioAgenda"]["celular"].value;
    var email = document.forms["formularioAgenda"]["email"].value;

    var nombre_expr = /^\s*$/;
    var apellido_expr = /^\s*$/;
    var email_expr = /^(.+\@.+\..+)$/;
    var telefono_expr = /^\d{7,15}$/;
    var celular_expr = /^\d{7,15}$/;

    if (nombre === null || nombre === "" || nombre_expr.test(nombre))
    {
        alert("El campo nombre es obligatorio.");
        document.forms["formularioAgenda"]["nombre"].focus();
        return false;
    }
    else if (apellido === null || apellido === "" || apellido_expr.test(apellido))
    {
        alert("El campo apellido es obligatorio.");
        document.forms["formularioAgenda"]["apellido"].focus();
        return false;
    }
    else if (isNaN(telefono) || !telefono_expr.test(telefono))
    {
        alert("Telefono introducido no valido");
        document.forms["formularioAgenda"]["telefono"].focus();
        return false;
    }
    else if (isNaN(celular) || !celular_expr.test(celular))
    {
        alert("Celular introducido no valido");
        document.forms["formularioAgenda"]["celular"].focus();
        return false;
    }
    else if (!email_expr.test(email))
    {
        alert("La direccion de email introducida no es valida");
        document.forms["formularioAgenda"]["email"].focus();
        return false;
    }
}