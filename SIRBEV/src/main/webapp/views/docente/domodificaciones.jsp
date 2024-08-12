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
            <li><a href="${pageContext.request.contextPath}/views/docente/inicio.jsp">Inicio</a></li>
            <li><a href="${pageContext.request.contextPath}/views/docente/altas.jsp">Registrar</a></li>
            <li><a href="${pageContext.request.contextPath}//views/docente/consultas.jsp">Consultas</a></li>
            <li><a href="${pageContext.request.contextPath}/views/docente/modificaciones.jsp">Modificaciones</a></li>
            <li><a href="${pageContext.request.contextPath}/views/docente/bajas.jsp">Eliminaciones</a></li>
            <li class="logout"><a href="${pageContext.request.contextPath}/DocenteServlet?accion=cerrarsesion"><i class="fas fa-sign-out-alt"></i>Cerrar sesión</a></li>
        </ul>
    </nav>
</header>
<div class="container">
    <main>
        <form id="modificaciones" method="post" class="sesion needs-validation" action="${pageContext.request.contextPath}/AlumnoServlet" enctype="multipart/form-data">

            <div class="tablas">
                <table>
                    <tr>
                        <td><strong>ID:</strong></td>
                        <td><input type="text" name="matricula" value="${user.matricula}" class="line-input" readonly></td>
                    </tr>
                    <tr>
                        <td><strong>Nombre:</strong></td>
                        <td><input type="text" name="nombre" value="${user.nombre}" class="line-input"></td>
                    </tr>
                    <tr>
                        <td><strong>Apellido paterno:</strong></td>
                        <td><input type="text" name="apellidoP" value="${user.apellidoP}" class="line-input"></td>
                    </tr>
                    <tr>
                        <td><strong>Apellido materno:</strong></td>
                        <td><input type="text" name="apellidoM" value="${user.apellidoM}" class="line-input"></td>
                    </tr>
                    <tr>
                        <td><strong>Correo:</strong></td>
                        <td><input type="email" name="correo" value="${user.correo}" class="line-input"></td>
                    </tr>
                    <tr>
                        <td><strong>Teléfono:</strong></td>
                        <td><input type="text" name="tel" value="${user.tel}" class="line-input" ></td>
                    </tr>
                    <tr>
                        <td><strong>Sexo:</strong></td>
                        <td><input type="text" name="sexo" value="${user.sexo}" class="line-input"></td>
                    </tr>
                    <tr>
                        <td><strong>Cuatrimestre:</strong></td>
                        <td><input type="text" name="cuatrimestre" value="${user.cuatrimestre}" class="line-input"></td>
                    </tr>
                    <tr>
                        <td><strong>Grupo:</strong></td>
                        <td><input type="text" name="grupo" value="${user.grupo}" class="line-input"></td>
                    </tr>
                    <tr>
                        <td><strong>Descripción:</strong></td>
                        <td><input type="text" name="descripcion" value="${user.descripcion}" class="line-input"></td>
                    </tr>
                    <tr>
                        <td><strong>Identificador del docente:</strong></td>
                        <td><input type="text" name="iddocente" value="${user.iddocente}" class="line-input"></td>
                    </tr>
                    <tr>
                        <td><strong>Carrera:</strong></td>
                        <td><input type="text" name="idcarrera" value="${user.idcarrera}" class="line-input"></td>
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