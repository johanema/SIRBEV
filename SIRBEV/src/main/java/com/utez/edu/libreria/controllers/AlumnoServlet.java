package com.utez.edu.libreria.controllers;

import com.utez.edu.libreria.dao.AlumnoDAO;
import com.utez.edu.libreria.models.AlumnoBean;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.InputStream;

@MultipartConfig
@WebServlet(name = "AlumnoServlet", value = "/AlumnoServlet")
public class AlumnoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        RequestDispatcher dispatcher = null;
        String peticion = request.getParameter("accion");
        String mensaje = "";
        String id = request.getParameter("matricula");
        System.out.println(peticion + id);
        switch (peticion) {
            case "consultar":
                request.setAttribute("ListaUsuarios", new AlumnoDAO().consultarTodos());
                dispatcher = request.getRequestDispatcher("/views/docente/Usuarios.jsp");
                dispatcher.forward(request, response);
                break;

            default:
                break;
        }
        request.setAttribute("mensaje", mensaje);
        dispatcher.forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        RequestDispatcher dispatcher = null;
        String peticion = request.getParameter("accion");
        System.out.println(peticion);
        String mensaje = "";
        switch (peticion) {
            case "consulta": {
                if (request.getParameter("matricula") != null) {
                    String id = request.getParameter("matricula");
                    AlumnoDAO nu = new AlumnoDAO();

                    if (nu.consultarID(id) != null) {
                        request.setAttribute("user", nu.consultarID(id));
                        request.getRequestDispatcher("/views/docente/doconsultas.jsp").forward(request, response);
                    } else {
                        request.setAttribute("mensaje", "ERROR EN EL ALUMNO");
                        request.getRequestDispatcher("/views/docente/consultas.jsp").forward(request, response);
                    }
                } else {
                    request.setAttribute("mensaje", "ERROR EN EL ALUMNO");
                    request.getRequestDispatcher("/views/docente/inicio.jsp").forward(request, response);
                }
                break;
            }
            case "registro": {
                String matricula = request.getParameter("matricula");
                String nombre = request.getParameter("nombre");
                String apellidoP = request.getParameter("apellidoP");
                String apellidoM = request.getParameter("apellidoM");
                String correo = request.getParameter("correo");
                String tel = request.getParameter("tel");
                String sexo = request.getParameter("sexo");
                int cuatrimestre = Integer.parseInt(request.getParameter("cuatrimestre"));
                String grupo = request.getParameter("grupo");
                String descripcion = request.getParameter("descripcion");
                String iddocente = request.getParameter("iddocente");
                int idcarrera = Integer.parseInt(request.getParameter("idcarrera"));

                AlumnoBean nuevoUsuario = new AlumnoBean(matricula, nombre, apellidoP, apellidoM, correo, tel, sexo, cuatrimestre, grupo, descripcion, iddocente, idcarrera);
                if (new AlumnoDAO().registrar(nuevoUsuario)) {
                    mensaje = "Alumno registrado exitosamente";
                    dispatcher = request.getRequestDispatcher("/views/docente/inicio.jsp");
                } else {
                    mensaje = "Error al registrar el alumno";
                    dispatcher = request.getRequestDispatcher("/views/docente/altas.jsp");
                }
                break;
            }
            case "ingresarmodificaciones": {
                if (request.getParameter("matricula") != null) {
                    String id = request.getParameter("matricula");
                    AlumnoDAO nu = new AlumnoDAO();

                    if (nu.consultarID(id) != null) {
                        request.setAttribute("user", nu.consultarID(id));
                        request.getRequestDispatcher("/views/docente/domodificaciones.jsp").forward(request, response);
                    } else {
                        request.setAttribute("mensaje", "ERROR EN EL ALUMNO");
                        request.getRequestDispatcher("/views/docente/modificaciones.jsp").forward(request, response);
                    }
                } else {
                    request.setAttribute("mensaje", "ERROR EN EL ALUMNO");
                    request.getRequestDispatcher("/views/docente/inicio.jsp").forward(request, response);
                }
                break;
            }
            case "modificaciones": {
                String matricula = request.getParameter("matricula");
                String nombre = request.getParameter("nombre");
                String apellidoP = request.getParameter("apellidoP");
                String apellidoM = request.getParameter("apellidoM");
                String correo = request.getParameter("correo");
                String tel = request.getParameter("tel");
                String sexo = request.getParameter("sexo");
                int cuatrimestre = Integer.parseInt(request.getParameter("cuatrimestre"));
                String grupo = request.getParameter("grupo");
                String descripcion = request.getParameter("descripcion");
                String iddocente = request.getParameter("iddocente");
                int idcarrera = Integer.parseInt(request.getParameter("idcarrera"));

                AlumnoBean alumnoActualizado = new AlumnoBean(matricula, nombre, apellidoP, apellidoM, correo, tel, sexo, cuatrimestre, grupo, descripcion, iddocente, idcarrera);
                if (new AlumnoDAO().modificar(alumnoActualizado)) {
                    mensaje = "Alumno actualizado exitosamente";
                    dispatcher = request.getRequestDispatcher("/views/docente/consultas.jsp");
                } else {
                    mensaje = "Error al modificar el alumno";
                    dispatcher = request.getRequestDispatcher("/views/docente/modificaciones.jsp");
                }
                break;
            }

            case "eliminar": {
                String matriculaEliminar = request.getParameter("matricula");
                AlumnoBean usuarioEliminar = new AlumnoBean();
                usuarioEliminar.setMatricula(String.valueOf(matriculaEliminar));
                AlumnoDAO daoUser = new AlumnoDAO();
                if (daoUser.eliminar(usuarioEliminar)) {
                    mensaje = "Alumno eliminado correctamente";
                    request.setAttribute("ListaUsuarios", new AlumnoDAO().consultarTodos());
                    dispatcher = request.getRequestDispatcher("/views/docente/inicio.jsp");
                } else {
                    mensaje = "Error al eliminar alumno";
                    request.setAttribute("ListaUsuarios", new AlumnoDAO().consultarTodos());
                    dispatcher = request.getRequestDispatcher("/views/docente/inicio.jsp");
                }
                break;
            }
            default:
                break;
        }

        request.setAttribute("mensaje", mensaje);
        dispatcher.forward(request, response);
    }
}
