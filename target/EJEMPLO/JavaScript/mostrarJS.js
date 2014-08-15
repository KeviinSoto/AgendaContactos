function validarBusqueda()
{
    var buscar = document.forms["formularioMostrar"]["buscar"].value;
    var buscar_expr = /^\s*$/;
    if (buscar === null || buscar === "" || buscar_expr.test(buscar))
    {
        alert("Debe introducir el dato a buscar");
        document.forms["formularioMostrar"]["buscar"].focus();
        return false;
    }
}

function validarEliminacion()
{
    var posicion = document.forms["formularioMostrar"]["posicion"].value;
    var posicion_expr = /^\s*$/;
    if (posicion === null || posicion === "" || posicion_expr.test(posicion))
    {
        alert("Debe introducir el numero de orden del contacto a eliminar/editar");
        document.forms["formularioMostrar"]["posicion"].focus();
        return false;
    }
}
