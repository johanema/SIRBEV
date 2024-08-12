<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.utez.edu.libreria.dao.DocenteDAO" %><%--
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
    <h1>Registrar</h1>
    <nav>
        <ul>
            <li><a href="${pageContext.request.contextPath}/views/docente/inicio.jsp">Inicio</a></li>
            <li><a href="${pageContext.request.contextPath}/views/docente/altas.jsp">Registrar</a></li>
            <li><a href="${pageContext.request.contextPath}/views/docente/consultas.jsp">Consultas</a></li>
            <li><a href="${pageContext.request.contextPath}/views/docente/modificaciones.jsp">Modificaciones</a></li>
            <li><a href="${pageContext.request.contextPath}/views/docente/bajas.jsp">Eliminaciones</a></li>
            <li class="logout"><a href="${pageContext.request.contextPath}/DocenteServlet?accion=cerrarsesion"><i class="fas fa-sign-out-alt"></i>Cerrar sesión</a></li>
        </ul>
    </nav>
</header>
<div class="container">
    <main>
        <section class="login">
            <!-- Sección para el formulario de consulta -->
            <br><br>
            <!-- Saltos de línea para espaciado -->
           <%-- <%
                DocenteDAO carrera=new DocenteDAO();
                List<String> carrera=new carrera.consultarcarrera(1);
                for


            %>--%>
            <form action="${pageContext.request.contextPath}/AlumnoServlet" enctype="multipart/form-data" method="post">
                <label for="matricula">Matrícula del alumno:</label>
                <input type="text" id="matricula" name="matricula" required><br><br>
                <label for="nombre">Nombre:</label>
                <input type="text" id="nombre" name="nombre" required><br><br>
                <label for="apellidoP">Apellido paterno:</label>
                <input type="text" id="apellidoP" name="apellidoP" required><br><br>
                <label for="apellidoM">Apellido materno:</label>
                <input type="text" id="apellidoM" name="apellidoM"><br><br>
                <label for="correo">Correo:</label>
                <input type="email" id="correo" name="correo" required><br><br>
                <label for="tel">Teléfono:</label>
                <input type="text" id="tel" name="tel" required><br><br>
                <label for="sexo">Sexo:</label>
                <input type="text" id="sexo" name="sexo" required><br><br>
                <label for="cuatrimestre">Cuatrimestre:</label>
                <input type="text" id="cuatrimestre" name="cuatrimestre" required><br><br>
                <label for="grupo">Grupo:</label>
                <input type="text" id="grupo" name="grupo" required><br><br>
                <label for="descripcion">Descripción:</label>
                <input type="text" id="descripcion" name="descripcion" required><br><br>
                <label for="iddocente">Identificador del docente:</label>
                <input type="text" id="iddocente" name="iddocente" required><br><br>
                <label for="idcarrera">Carrera:</label>
                <select id="idcarrera" name="idcarrera" required>
                    <option value="" disabled selected>Seleccione una carrera</option>
                    <!-- Add your options for carreras here -->
                    <option value="1">Ingeniería en Software</option>
                    <option value="2">Ingeniería en Redes</option>
                    <!-- You can dynamically generate these options from the database -->
                </select><br><br>
                <input type="hidden" id="accion" name="accion" value="registro" required><br><br>
                <center>
                    <!-- Botón de registro -->
                    <button type="submit" onclick="inicio()" class="boton registrar">Inscribir</button> <br><br> <br><br>
                </center>
            </form>
        </section>
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
            title: "Alumno registrado exitosamente",
            showConfirmButton: false,
            timer: 1500
        });
    }
</script>
</body>
</html>
