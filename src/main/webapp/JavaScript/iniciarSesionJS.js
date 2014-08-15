function validarInicioDeSesion()
{
    var usuario = document.forms["formulario"]["usuario"].value;
    var password = document.forms["formulario"]["password"].value;
    var usuario_expr = /^\s*$/;
    var password_expr = /^\s*$/;
    if (usuario === null || usuario === "" || usuario_expr.test(usuario))
    {
        alert("Debe introducir un usuario para iniciar sesión");
        document.forms["formulario"]["usuario"].focus();
        return false;
    }
    else if(password === null || password ==="" || password_expr.text(password))
    {
        alert("Debe introducir una contraseña para iniciar sesión");
        document.forms["formulario"]["password"].focus();
        return false;
    }
}
