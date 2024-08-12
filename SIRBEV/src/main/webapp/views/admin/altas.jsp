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
    <h1>Registrar</h1>
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
        <section class="login">
            <!-- Sección para el formulario de consulta -->
            <br><br>
            <!-- Saltos de línea para espaciado -->
            <form action="${pageContext.request.contextPath}/DocenteServlet" enctype="multipart/form-data" method="post">
                <!-- Campos del formulario -->
                <label for="iddoc">Número de identificador del Docente:</label>
                <input type="text" id="iddoc" name="iddoc" required><br><br>
                <label for="passdoc">Contraseña:</label>
                <input type="password" id="passdoc" name="passdoc" required><br><br>
                <label for="nomdoc">Nombre:</label>
                <input type="text" id="nomdoc" name="nomdoc" required><br><br>
                <label for="apePdoc">Apellido paterno:</label>
                <input type="text" id="apePdoc" name="apePdoc" required><br><br>
                <label for="apeMdoc">Apellido materno:</label>
                <input type="text" id="apeMdoc" name="apeMdoc"><br><br>
                <label for="correodoc">Correo:</label>
                <input type="email" id="correodoc" name="correodoc" required><br><br>
                <label for="teldoc">Teléfono:</label>
                <input type=text id="teldoc" name="teldoc" required><br><br>
                <label for="apeMdoc">Foto:</label>
                <input type="file" id="foto" name="foto"><br><br>

                <label for="idadministrador">ID adminstrador:</label>
                <input type="text" id="idadministrador" name="idadministrador" required><br><br>
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
            title: "Usuario registrado exitosamente",
            showConfirmButton: false,
            timer: 1500
        });
    }

</script>
</body>
</html>