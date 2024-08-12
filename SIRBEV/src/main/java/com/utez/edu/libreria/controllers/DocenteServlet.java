package com.utez.edu.libreria.controllers;

import com.utez.edu.libreria.dao.DocenteDAO;
import com.utez.edu.libreria.models.DocenteBean;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.InputStream;

@MultipartConfig
@WebServlet(name = "DocenteServlet", value = "/DocenteServlet")
public class DocenteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        RequestDispatcher dispatcher = null;
        String peticion = request.getParameter("accion");
        String mensaje = "";
        String id= (request.getParameter("iddo"));
        System.out.println(peticion + id);


        switch (peticion) {
            case "cerrarsesion":
                HttpSession sesion = request.getSession(false);
                mensaje = "Saliendo del sistema";
                sesion.invalidate();
                dispatcher = request.getRequestDispatcher("/index.jsp");
                break;

            case "consultar":
                request.setAttribute("ListaUsuarios", new DocenteDAO().consultarTodos());
                dispatcher = request.getRequestDispatcher("/views/admin/Usuarios.jsp");
                dispatcher.forward(request, response);
                break;

            case "mostrarImagen":
                DocenteDAO img=new DocenteDAO();
                img.mostrarImagen(id,response);
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
        //InputStream fotodoc=null;
        String peticion = request.getParameter("accion");

        //fotodoc=null;


        System.out.println(peticion);
        String mensaje = "";

        switch (peticion) {

            case "consulta":{
                if (request.getParameter("iddoc")!=null){
                    String id=request.getParameter("iddoc");
                    DocenteDAO nu=new DocenteDAO();

                    if (nu.consultarID(id) != null) {
                        request.setAttribute("user", nu.consultarID(id));
                        request.getRequestDispatcher("/views/admin/doconsultas.jsp").forward(request,response);
                    }else{
                        request.setAttribute("mensaje","ERROR EN EL DOCENTE") ;
                        request.getRequestDispatcher("/views/admin/consultas.jsp").forward(request,response);
                    }
                }else{
                    //request.setAttribute("ListaUsuarios", new UsuarioDAO().consultarTodos()) ;
                    request.setAttribute("mensaje","ERROR EN EL DOCENTE") ;
                    request.getRequestDispatcher("/views/admin/inicio.jsp").forward(request,response);
                }

                break;
            }

            case "inicioSesion": {
                HttpSession sesion = request.getSession(true);
                DocenteBean usuario = new DocenteBean(request.getParameter("iddoc"), request.getParameter("passdoc"));
                DocenteDAO dao = new DocenteDAO();
                usuario = dao.consultarUsuario(usuario);
                if (usuario != null) {
                    sesion.setAttribute("iddoc", usuario.getIddoc());
                    sesion.setAttribute("passdoc", usuario.getPassdoc());
                    sesion.setAttribute("nomdoc", usuario.getNomdoc());
                    sesion.setAttribute("apePdoc", usuario.getApePdoc());
                    sesion.setAttribute("apeMdoc", usuario.getApeMdoc());
                    sesion.setAttribute("correodoc", usuario.getCorreodoc());
                    sesion.setAttribute("teldoc", usuario.getTeldoc());
                    sesion.setAttribute("sesionValida", "true");
                    mensaje = usuario.getNomdoc();

                    // Realizar la consulta después de iniciar sesión
                    String id = usuario.getIddoc();
                    DocenteDAO nu = new DocenteDAO();

                    if (nu.consultarID(id) != null) {
                        request.setAttribute("user", nu.consultarID(id));
                        dispatcher = request.getRequestDispatcher("/views/docente/inicio.jsp");
                    } else {
                        request.setAttribute("mensaje", "ERROR EN EL DOCENTE");
                        dispatcher = request.getRequestDispatcher("/views/docente/index.jsp");
                    }
                } else {
                    mensaje = "Datos incorrectos, verifica tu usuario y/o contraseña.";
                    sesion.invalidate();
                    dispatcher = request.getRequestDispatcher("/index.jsp");
                }

                break;
            }


            case "registro": {
                InputStream fotodoc = null;
                Part filePart = request.getPart("foto");
                if (filePart != null) {
                    fotodoc = filePart.getInputStream();
                }

                String iddoc = request.getParameter("iddoc");
                String passdoc = request.getParameter("passdoc");
                String nomdoc = request.getParameter("nomdoc");
                String apePdoc = request.getParameter("apePdoc");
                String apeMdoc = request.getParameter("apeMdoc");
                String correodoc = request.getParameter("correodoc");
                String teldoc = request.getParameter("teldoc");

                String idadministrador = request.getParameter("idadministrador");
                DocenteBean nuevoUsuario = new DocenteBean(iddoc, passdoc, nomdoc, apePdoc, apeMdoc, correodoc, teldoc, fotodoc, idadministrador);
                if (new DocenteDAO().registrar(nuevoUsuario)) {
                    mensaje = "Usuario registrado exitosamente";
                    dispatcher = request.getRequestDispatcher("/views/admin/inicio.jsp");
                } else {
                    mensaje = "Error al registrar el usuario";
                    dispatcher = request.getRequestDispatcher("/views/admin/inicio.jsp");
                }
                break;
            }

            case "ingresarmodificaciones":{
                if (request.getParameter("iddoc")!=null){
                    String id=request.getParameter("iddoc");
                    DocenteDAO nu=new DocenteDAO();

                    if (nu.consultarID(id) != null) {
                        request.setAttribute("user", nu.consultarID(id));
                        request.getRequestDispatcher("/views/admin/domodificaciones.jsp").forward(request,response);
                    }else{
                        request.setAttribute("mensaje","ERROR EN EL DOCENTE") ;
                        request.getRequestDispatcher("/views/admin/modificaciones.jsp").forward(request,response);
                    }
                }else{
                    //request.setAttribute("ListaUsuarios", new UsuarioDAO().consultarTodos()) ;
                    request.setAttribute("mensaje","ERROR EN EL DOCENTE") ;
                    request.getRequestDispatcher("/views/admin/inicio.jsp").forward(request,response);
                }

                break;
            }


            case "modificaciones": {
                InputStream fotodoc = null;
                Part filePart = request.getPart("foto");
                if (filePart != null) {
                    fotodoc = filePart.getInputStream();
                }

                String iddoc = request.getParameter("iddoc");
                String passdoc = request.getParameter("passdoc");
                String nomdoc = request.getParameter("nomdoc");
                String apePdoc = request.getParameter("apePdoc");
                String apeMdoc = request.getParameter("apeMdoc");
                String correodoc = request.getParameter("correodoc");
                String teldoc = request.getParameter("teldoc");

                DocenteBean docenteactualizado = new DocenteBean(iddoc, passdoc, nomdoc, apePdoc, apeMdoc, correodoc, teldoc, fotodoc);
                if (new DocenteDAO().modificar(docenteactualizado)) {
                    mensaje = "Docente actualizado exitosamente";
                    dispatcher = request.getRequestDispatcher("/views/admin/consultas.jsp");
                } else {
                    mensaje = "Error al modificar el docente";
                    dispatcher = request.getRequestDispatcher("/views/admin/modificaciones.jsp");
                }
                break;
            }

            case "modificacionesinicio": {
                InputStream fotodoc = null;
                Part filePart = request.getPart("foto");
                if (filePart != null) {
                    fotodoc = filePart.getInputStream();
                }

                String iddoc = request.getParameter("iddoc");
                String passdoc = request.getParameter("passdoc");
                String nomdoc = request.getParameter("nomdoc");
                String apePdoc = request.getParameter("apePdoc");
                String apeMdoc = request.getParameter("apeMdoc");
                String correodoc = request.getParameter("correodoc");
                String teldoc = request.getParameter("teldoc");

                DocenteBean docenteactualizado = new DocenteBean(iddoc, passdoc, nomdoc, apePdoc, apeMdoc, correodoc, teldoc, fotodoc);
                if (new DocenteDAO().modificar(docenteactualizado)) {
                    mensaje = "Docente actualizado exitosamente";
                    dispatcher = request.getRequestDispatcher("/views/docente/inicio.jsp");
                } else {
                    mensaje = "Error al modificar el docente";
                    dispatcher = request.getRequestDispatcher("/views/docente/inicio.jsp");
                }
                break;
            }



            case "eliminar": {
                String iddocEliminar = request.getParameter("iddoc");
                DocenteBean usuarioEliminar = new DocenteBean();
                usuarioEliminar.setIddoc(String.valueOf(iddocEliminar));
                DocenteDAO daoUser = new DocenteDAO();
                if (daoUser.eliminar(usuarioEliminar)) {
                    mensaje = "Usuario eliminado correctamente";
                    request.setAttribute("ListaUsuarios", new DocenteDAO().consultarTodos());
                    dispatcher = request.getRequestDispatcher("/views/admin/inicio.jsp");
                } else {
                    mensaje = "Error al eliminar usuario";
                    request.setAttribute("ListaUsuarios", new DocenteDAO().consultarTodos());
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