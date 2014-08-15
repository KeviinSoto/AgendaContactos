package controladores;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Contacto;
import modelo.Operaciones;

public class Servlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //CODIGO PARA INICIO DE SESION
        String usuario, password, botonIniciarSesion, usuario_valor, password_valor, label1;
        boolean autentificacion;
        usuario = request.getParameter("usuario");
        password = request.getParameter("password");
        label1 = request.getParameter("label1");
        botonIniciarSesion = request.getParameter("botonIniciarSesion");
        usuario_valor = getServletConfig().getInitParameter("usuario").toString();
        password_valor = getServletConfig().getInitParameter("password").toString();
        if (botonIniciarSesion != null) {
            try {
                autentificacion = usuario_valor.equals(usuario) && password_valor.equals(password);
                if (autentificacion == true) {
                    HttpSession Session = request.getSession();
                    Session.setAttribute("usuario", usuario);
                    response.sendRedirect("agenda.jsp");
                } else {
                    request.setAttribute("incorrecto", "El usuario/contraseña es incorrecto. \n Verifique.");
                    RequestDispatcher rd = request.getRequestDispatcher("iniciarSesion.jsp");
                    rd.forward(request, response);

                }
            } catch (IOException e) {
                e.getStackTrace();
            }
        }

        //CODIGO PARA OPERACIONES
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String telefono = request.getParameter("telefono");
        String celular = request.getParameter("celular");
        String email = request.getParameter("email");
        String nombre1 = request.getParameter("nombreED");
        String apellido1 = request.getParameter("apellidoED");
        String telefono1 = request.getParameter("telefonoED");
        String celular1 = request.getParameter("celularED");
        String email1 = request.getParameter("emailED");
        String botonLimpiar = request.getParameter("botonLimpiar");
        String botonInsertar = request.getParameter("botonInsertar");
        String botonListar = request.getParameter("botonListar");
        String AreaListado = request.getParameter("AreaListado");
        String botonAtras = request.getParameter("botonAtras");
        String botonEliminar = request.getParameter("botonEliminar");
        String posicion = request.getParameter("posicion");
        String buscar = request.getParameter("buscar");
        String botonBuscar = request.getParameter("botonBuscar");
        String botonActualizar = request.getParameter("botonActualizar");
        String botonEditar = request.getParameter("botonEditar");
        String botonAtras1 = request.getParameter("botonAtras1");
        String botonInicio = request.getParameter("botonInicio");
        String botonListarTodo = request.getParameter("botonListarTodo");
        String botonCerrarSesion = request.getParameter("botonCerrarSesion");
        Contacto contacto = new Contacto(nombre, apellido, telefono, celular, email);
        Operaciones operacion = new Operaciones();

        if (botonInsertar != null) {
            operacion.guardar(contacto);
            request.getSession().setAttribute("agregado", "Su contacto ha sido guardado correctamente.");
            RequestDispatcher rd = request.getRequestDispatcher("agenda.jsp");
            rd.forward(request, response);
        }
        if (botonListar != null) {
            request.getSession().setAttribute("Lista", operacion.listar());
            AreaListado = operacion.listar();
            response.sendRedirect("mostrar.jsp");

        }
        if (botonLimpiar != null) {
            nombre = " ";
            apellido = " ";
            telefono = " ";
            celular = " ";
            email = " ";
            RequestDispatcher rd = request.getRequestDispatcher("agenda.jsp");
            rd.forward(request, response);
        }
        if (botonAtras != null) {
            RequestDispatcher rd = request.getRequestDispatcher("agenda.jsp");
            rd.forward(request, response);
        }
        if (botonEliminar != null) {
            operacion.borrar(contacto, Integer.valueOf(posicion));
            request.getSession().setAttribute("Lista", operacion.listar());
            response.sendRedirect("mostrar.jsp");
            AreaListado = operacion.listar();
        }
        if (botonBuscar != null) {
            request.getSession().setAttribute("Lista", operacion.buscar(buscar));
            RequestDispatcher rd = request.getRequestDispatcher("mostrar.jsp");
            rd.forward(request, response);
        }

        if (botonEditar != null) {
            String valor1 = "", valor2 = "", valor3 = "", valor4 = "", valor5 = "";
            for (int i = 0; i <= 5; i++) {
                valor1 = operacion.editar(Integer.valueOf(posicion))[0];
                valor2 = operacion.editar(Integer.valueOf(posicion))[1];
                valor3 = operacion.editar(Integer.valueOf(posicion))[2];
                valor4 = operacion.editar(Integer.valueOf(posicion))[3];
                valor5 = operacion.editar(Integer.valueOf(posicion))[4];
                request.getSession().setAttribute("Valor1", valor1);
                request.getSession().setAttribute("Valor2", valor2);
                request.getSession().setAttribute("Valor3", valor3);
                request.getSession().setAttribute("Valor4", valor4);
                request.getSession().setAttribute("Valor5", valor5);
            }
            request.getSession().setAttribute("Posicion", posicion);
            RequestDispatcher rd = request.getRequestDispatcher("editar.jsp");
            rd.forward(request, response);
        }
        if (botonActualizar != null) {

            String position = (String) request.getSession().getAttribute("Posicion");
            operacion.actualizar(Integer.valueOf(position), nombre1, apellido1, telefono1, celular1, email1);
            request.getSession().setAttribute("Valor1", " ");
            request.getSession().setAttribute("Valor2", " ");
            request.getSession().setAttribute("Valor3", " ");
            request.getSession().setAttribute("Valor4", " ");
            request.getSession().setAttribute("Valor5", " ");
            request.getSession().setAttribute("editado", "Su contacto ha sido actualizado correctamente.");
            RequestDispatcher rd = request.getRequestDispatcher("editar.jsp");
            rd.forward(request, response);
        }
        if (botonAtras1 != null) {
            RequestDispatcher rd = request.getRequestDispatcher("mostrar.jsp");
            rd.forward(request, response);
        }
        if (botonInicio != null) {
            RequestDispatcher rd = request.getRequestDispatcher("agenda.jsp");
            rd.forward(request, response);
        }
        if (botonListarTodo != null) {
            request.getSession().setAttribute("Lista", operacion.listar());
            RequestDispatcher rd = request.getRequestDispatcher("mostrar.jsp");
            rd.forward(request, response);
        }
        if (botonCerrarSesion != null) {
            request.getSession().invalidate();
            RequestDispatcher rd = request.getRequestDispatcher("iniciarSesion.jsp");
            rd.forward(request, response);
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
