<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: johan
  Date: 20/06/2024
  Time: 10:10 a. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--
  Created by IntelliJ IDEA.
  User: johan
  Date: 20/06/2024
  Time: 10:10 a. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>SIRBEV</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
    <link rel="icon" href="${pageContext.request.contextPath}/resource/icon/logo.ico">
</head>
<body>
<header>
    <h1>Modificaciones</h1>
    <nav>
        <ul>
            <li><a href="${pageContext.request.contextPath}/views/admin/inicio.jsp">Inicio</a></li>
            <li><a href="${pageContext.request.contextPath}/views/admin/altas.jsp">Registrar</a></li>
            <li><a href="${pageContext.request.contextPath}//views/admin/consultas.jsp">Consultas</a></li>
            <li><a href="${pageContext.request.contextPath}/views/admin/modificaciones.jsp">Modificaciones</a></li>
            <li><a href="${pageContext.request.contextPath}/views/admin/bajas.jsp">Eliminaciones</a></li>
            <li class="logout"><a href="${pageContext.request.contextPath}/AdministradorServlet?accion=cerrarsesion"><i class="fas fa-sign-out-alt"></i>Cerrar sesión</a></li>
        </ul>
    </nav>
</header>
<div class="container">
    <main>
        <form id="modificaciones" method="post" class="sesion needs-validation" action="${pageContext.request.contextPath}/DocenteServlet" enctype="multipart/form-data">

            <div class="tablas">
                <table>
                    <tr>
                        <td><strong>ID:</strong></td>
                        <td><input type="text" name="iddoc" value="${user.iddoc}" class="line-input" readonly></td>
                    </tr>
                    <tr>
                        <td><strong>Nombre:</strong></td>
                        <td><input type="text" name="nomdoc" value="${user.nomdoc}" class="line-input"></td>
                    </tr>
                    <tr>
                        <td><strong>Apellido paterno:</strong></td>
                        <td><input type="text" name="apePdoc" value="${user.apePdoc}" class="line-input"></td>
                    </tr>
                    <tr>
                        <td><strong>Apellido materno:</strong></td>
                        <td><input type="text" name="apeMdoc" value="${user.apeMdoc}" class="line-input"></td>
                    </tr>
                    <tr>
                        <td><strong>Contraseña:</strong></td>
                        <td><input type="password" name="passdoc" value="${user.passdoc}" class="line-input"></td>
                    </tr>
                    <tr>
                        <td><strong>Correo:</strong></td>
                        <td><input type="email" name="correodoc" value="${user.correodoc}" class="line-input" ></td>
                    </tr>
                    <tr>
                        <td><strong>Teléfono:</strong></td>
                        <td><input type="text" name="teldoc" value="${user.teldoc}" class="line-input"></td>
                    </tr>
                    <tr>
                        <td><strong>Foto:</strong></td>
                        <td><img src="${pageContext.request.contextPath}/DocenteServlet?accion=mostrarImagen&iddocente=${user.iddoc}" width="150px"/>
                            <br><input type="file" id="foto" name="foto"></td><br>

                    </tr>
                    <tr>
                        <td colspan="2">
                            <center>
                                <input type="hidden" name="accion" value="modificaciones">
                                <button type="submit" onclick="inicio()" class="boton">Guardar</button>
                            </center>
                        </td>
                    </tr>
                </table>
            </div><br><br><br>
        </form>
    </main>
</div>
<footer>
    <p>© 2024 SIRBEV. Vulnerabilidad transformada en oportunidad.</p>
</footer>
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
<script src="js/index.js"></script>
<script>
    function inicio(){
        Swal.fire({
            position: "center",
            icon: "success",
            title: "Modificado exitosamente",
            showConfirmButton: false,
            timer: 1500
        });
    }

</script>
</body>
</html>