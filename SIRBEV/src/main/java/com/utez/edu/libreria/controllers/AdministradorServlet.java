package com.utez.edu.libreria.controllers;

import com.utez.edu.libreria.dao.AdministradorDAO;
import com.utez.edu.libreria.models.AdministradorBean;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.InputStream;

@MultipartConfig
@WebServlet(name = "AdministradorServlet", value = "/AdministradorServlet")
public class AdministradorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        RequestDispatcher dispatcher = null;
        String peticion = request.getParameter("accion");
        String mensaje = "";
        String id = request.getParameter("idadmin");
        System.out.println(peticion + id);

        switch (peticion) {
            case "cerrarsesion":
                HttpSession sesion = request.getSession(false);
                mensaje = "Saliendo del sistema";
                sesion.invalidate();
                dispatcher = request.getRequestDispatcher("/index.jsp");
                break;

            case "consultar":
                request.setAttribute("ListaUsuarios", new AdministradorDAO().consultarTodos());
                dispatcher = request.getRequestDispatcher("/views/admin/Usuarios.jsp");
                dispatcher.forward(request, response);
                break;

            case "mostrarImagen":
                AdministradorDAO img = new AdministradorDAO();
                img.mostrarImagen(id, response);
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
                if (request.getParameter("idadmin") != null) {
                    String id = request.getParameter("idadmin");
                    AdministradorDAO nu = new AdministradorDAO();

                    if (nu.consultarID(id) != null) {
                        request.setAttribute("user", nu.consultarID(id));
                        request.getRequestDispatcher("/views/admin/doconsultas.jsp").forward(request, response);
                    } else {
                        request.setAttribute("mensaje", "ERROR EN EL ADMINISTRADOR");
                        request.getRequestDispatcher("/views/admin/consultas.jsp").forward(request, response);
                    }
                } else {
                    request.setAttribute("mensaje", "ERROR EN EL ADMINISTRADOR");
                    request.getRequestDispatcher("/views/admin/inicio.jsp").forward(request, response);
                }
                break;
            }

            case "inicioSesion": {
                HttpSession sesion = request.getSession(true);
                AdministradorBean usuario = new AdministradorBean(request.getParameter("idadmin"), request.getParameter("passadmin"));
                AdministradorDAO dao = new AdministradorDAO();
                usuario = dao.consultarUsuario(usuario);
                if (usuario != null) {
                    sesion.setAttribute("idadmin", usuario.getIdadmin());
                    sesion.setAttribute("passadmin", usuario.getPassadmin());
                    sesion.setAttribute("nomadmin", usuario.getNomadmin());
                    sesion.setAttribute("apePadmin", usuario.getApePadmin());
                    sesion.setAttribute("apeMadmin", usuario.getApeMadmin());
                    sesion.setAttribute("correoadmin", usuario.getCorreoadmin());
                    sesion.setAttribute("teladmin", usuario.getTeladmin());

                    sesion.setAttribute("sesionValida", "true");
                    mensaje = usuario.getNomadmin();

                    String id = usuario.getIdadmin();
                    AdministradorDAO nu = new AdministradorDAO();

                    if (nu.consultarID(id) != null) {
                        request.setAttribute("user", nu.consultarID(id));
                        dispatcher = request.getRequestDispatcher("/views/admin/inicio.jsp");
                    } else {
                        request.setAttribute("mensaje", "ERROR EN EL ADMINISTRADOR");
                        dispatcher = request.getRequestDispatcher("/views/admin/indez.jsp");
                    }
                } else {
                    mensaje = "Datos incorrectos, verifica tu usuario y/o contraseña.";
                    sesion.invalidate();
                    dispatcher = request.getRequestDispatcher("/index.jsp");
                }
                break;
            }

            case "registro": {
                InputStream fotoadmin = null;
                Part filePart = request.getPart("foto");
                if (filePart != null) {
                    fotoadmin = filePart.getInputStream();
                }

                String idadmin = request.getParameter("idadmin");
                String passadmin = request.getParameter("passadmin");
                String nomadmin = request.getParameter("nomadmin");
                String apePadmin = request.getParameter("apePadmin");
                String apeMadmin = request.getParameter("apeMadmin");
                String correoadmin = request.getParameter("correoadmin");
                String teladmin = request.getParameter("teladmin");

                AdministradorBean nuevoUsuario = new AdministradorBean(idadmin, passadmin, nomadmin, apePadmin, apeMadmin, correoadmin, teladmin, fotoadmin);
                if (new AdministradorDAO().registrar(nuevoUsuario)) {
                    mensaje = "Usuario registrado exitosamente";
                    dispatcher = request.getRequestDispatcher("/views/admin/inicio.jsp");
                } else {
                    mensaje = "Error al registrar el usuario";
                    dispatcher = request.getRequestDispatcher("/views/admin/inicio.jsp");
                }
                break;
            }

            case "ingresarmodificaciones": {
                if (request.getParameter("idadmin") != null) {
                    String id = request.getParameter("idadmin");
                    AdministradorDAO nu = new AdministradorDAO();

                    if (nu.consultarID(id) != null) {
                        request.setAttribute("user", nu.consultarID(id));
                        request.getRequestDispatcher("/views/admin/domodificaciones.jsp").forward(request, response);
                    } else {
                        request.setAttribute("mensaje", "ERROR EN EL ADMINISTRADOR");
                        request.getRequestDispatcher("/views/admin/modificaciones.jsp").forward(request, response);
                    }
                } else {
                    request.setAttribute("mensaje", "ERROR EN EL ADMINISTRADOR");
                    request.getRequestDispatcher("/views/admin/inicio.jsp").forward(request, response);
                }
                break;
            }

            case "modificaciones": {
                InputStream fotoadmin = null;
                Part filePart = request.getPart("fotoadmin");
                if (filePart != null) {
                    fotoadmin = filePart.getInputStream();
                }

                String idadmin = request.getParameter("idadmin");
                String passadmin = request.getParameter("passadmin");
                String nomadmin = request.getParameter("nomadmin");
                String apePadmin = request.getParameter("apePadmin");
                String apeMadmin = request.getParameter("apeMadmin");
                String correoadmin = request.getParameter("correoadmin");
                String teladmin = request.getParameter("teladmin");

                AdministradorBean adminActualizado = new AdministradorBean(idadmin, passadmin, nomadmin, apePadmin, apeMadmin, correoadmin, teladmin, fotoadmin);
                if (new AdministradorDAO().modificar(adminActualizado)) {
                    mensaje = "Administrador actualizado exitosamente";
                    dispatcher = request.getRequestDispatcher("/views/admin/consultas.jsp");
                } else {
                    mensaje = "Error al modificar el administrador";
                    dispatcher = request.getRequestDispatcher("/views/admin/modificaciones.jsp");
                }
                break;
            }

            case "eliminar": {
                String idadminEliminar = request.getParameter("idadmin");
                AdministradorBean usuarioEliminar = new AdministradorBean();
                usuarioEliminar.setIdadmin(String.valueOf(idadminEliminar));
                AdministradorDAO daoUser = new AdministradorDAO();
                if (daoUser.eliminar(usuarioEliminar)) {
                    mensaje = "Usuario eliminado correctamente";
                    request.setAttribute("ListaUsuarios", new AdministradorDAO().consultarTodos());
                    dispatcher = request.getRequestDispatcher("/views/admin/inicio.jsp");
                } else {
                    mensaje = "Error al eliminar usuario";
                    request.setAttribute("ListaUsuarios", new AdministradorDAO().consultarTodos());
                    dispatcher = request.getRequestDispatcher("/views/admin/inicio.jsp");
                }
                break;
            }

            case "cierreSesion": {
                HttpSession session = request.getSession(false);
                mensaje = "Saliendo del sistema";
                session.invalidate();
                dispatcher = request.getRequestDispatcher("/index.jsp");
                break;
            }

            default:
                break;
        }

        request.setAttribute("mensaje", mensaje);
        dispatcher.forward(request, response);
    }
}
