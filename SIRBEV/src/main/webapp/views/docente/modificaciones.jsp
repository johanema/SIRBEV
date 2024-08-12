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
        <section class="login">
            <!-- Sección para el formulario de consulta -->
            <br><br>
            <!-- Saltos de línea para espaciado -->
            <form id="ingresarmodificaciones" method="post" class="sesion needs-validation" action="${pageContext.request.contextPath}/AlumnoServlet" enctype="multipart/form-data">
                <center>
                    <label for="matricula" style="font-weight: bold;">Matrícula a modificar:</label>
                    <div class="input-container">
                        <input type="text" id="matricula" name="matricula" required class="line-input">
                    </div>
                    <input type="hidden" name="accion" value="ingresarmodificaciones">
                </center>
                <br><br>
                <center>
                    <button type="submit" onclick="inicio()" class="boton">Siguiente</button>
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
            title: "Procesando",
            showConfirmButton: false,
            timer: 1500
        });
    }

</script>
</body>
</html>