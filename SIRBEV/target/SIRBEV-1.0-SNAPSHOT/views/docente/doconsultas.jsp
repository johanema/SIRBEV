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
        <div class="tablas">
            <table>
                <tr>
                    <td colspan="2"><strong>${user.nombre} ${user.apellidoP} ${user.apellidoM}</strong></td>
                </tr>
                <tr>
                    <td><strong>Matrícula:</strong></td>
                    <td>${user.matricula}</td>
                </tr>
                <tr>
                    <td><strong>Correo:</strong></td>
                    <td>${user.correo}</td>
                </tr>
                <tr>
                    <td><strong>Teléfono:</strong></td>
                    <td>${user.tel}</td>
                </tr>
                <tr>
                    <td><strong>Sexo:</strong></td>
                    <td>${user.sexo}</td>
                </tr>
                <tr>
                    <td><strong>Cuatrimestre:</strong></td>
                    <td>${user.cuatrimestre}</td>
                </tr>
                <tr>
                    <td><strong>Grupo:</strong></td>
                    <td>${user.grupo}</td>
                </tr>
                <tr>
                    <td><strong>Descripción:</strong></td>
                    <td>${user.descripcion}</td>
                </tr>
                <tr>
                    <td><strong>Identificador carrera:</strong></td>
                    <td>${user.idcarrera}</td>
                </tr>
                <tr>
                    <td><strong>Carrera:</strong></td>
                    <td>${user.carrera}</td>
                </tr>
            </table>
        </div>
        <br><br><br><br>
    </main>
</div>
<footer>
    <p>© 2024 SIRBEV. Vulnerabilidad transformada en oportunidad.</p>
</footer>
</body>
</html>