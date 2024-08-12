<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
        <div class="tablas">
            <table>
                <tr>
                    <td colspan="2"><strong>${user.nomdoc} ${user.apePdoc} ${user.apeMdoc}</strong></td>
                </tr>
                <tr>
                    <td><strong>Imagen:</strong></td>
                    <td><img src="${pageContext.request.contextPath}/DocenteServlet?accion=mostrarImagen&iddocente=${user.iddoc}" width="150px"/></td>
                </tr>
                <tr>
                    <td><strong>Número de identificador del docente:</strong></td>
                    <td>${user.iddoc}</td>
                </tr>
                <tr>
                    <td><strong>Contraseña:</strong></td>
                    <td>${user.passdoc}</td>
                </tr>
                <tr>
                    <td><strong>Correo:</strong></td>
                    <td>${user.correodoc}</td>
                </tr>
                <tr>
                    <td><strong>Teléfono:</strong></td>
                    <td>${user.teldoc}</td>
                </tr>
                <tr>
                    <td><strong>Número de identificador del administrador:</strong></td>
                    <td>${user.idadministrador}</td>
                </tr>
            </table>
        </div>
    </main>
</div>
<footer>
    <p>© 2024 SIRBEV. Vulnerabilidad transformada en oportunidad.</p>
</footer>
</body>
</html>