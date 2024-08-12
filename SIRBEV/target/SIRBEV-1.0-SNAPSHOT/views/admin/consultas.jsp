<%--
  Created by IntelliJ IDEA.
  User: johan
  Date: 20/06/2024
  Time: 10:10 a. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.utez.edu.libreria.models.DocenteBean" %>
<%@ page import="java.sql.Blob" %>
<%@ page import="java.io.InputStream" %>
<%@ page import="java.io.ByteArrayOutputStream" %>
<%--<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>SIRBEV - Consultar</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/general.css">
    <link rel="icon" href="${pageContext.request.contextPath}/resource/icon/logo.ico">

    <style>

        .boton {
            width: 20%;
            padding: 10px;
            font-size: 18px;
            background-color: #008F70;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }
        .boton:hover {
            background-color: #009d7b;
        }

        .input-container {
            width: 200px; /* Ajusta el ancho según tus necesidades */
            margin: 0 auto; /* Centra el contenedor horizontalmente */
        }

        .line-input {
            border: none;
            border-bottom: 2px solid #707070; /* Línea inferior */
            background: none;
            padding: 8px 0;
            font-size: 16px;
            width: 100%; /* Ocupa todo el ancho del contenedor */
            box-sizing: border-box; /* Para incluir el padding en el ancho total */
        }

        .line-input:focus {
            outline: none; /* Eliminar el contorno al enfocar */
            border-bottom-color: #707070; /* Cambiar el color de la línea inferior al enfocar, opcional */
        }


    </style>
</head>


<body>

<header>
    <input type="checkbox" id="menu-toggle">
    <label for="menu-toggle" class="menu-icon">
        <div class="bar"></div>
        <div class="bar"></div>
        <div class="bar"></div>
    </label>
    <section class="title">
        <h1>CONSULTAR</h1>
    </section>
    <section class="logos">
        <img src="${pageContext.request.contextPath}/resource/img/logo.png" alt="SIRBEV Logo">
    </section>
    <div class="dropdown-content">
        <div class="dropdown">
            <a href="${pageContext.request.contextPath}/views/admin/inicio.jsp">Inicio</a>
        </div>
        <div class="dropdown">
            <a href="${pageContext.request.contextPath}/views/admin/altas.jsp">Registrar</a>
        </div>
        <div class="dropdown">
            <a href="${pageContext.request.contextPath}/views/admin/modificaciones.jsp">Modificar</a>
        </div>
        <div class="dropdown">
            <a href="${pageContext.request.contextPath}/views/admin/bajas.jsp">Eliminar</a>
        </div>
    </div>
</header>
<form id="consulta" method="post" class="sesion needs-validation" action="${pageContext.request.contextPath}/DocenteServlet" enctype="multipart/form-data">
    <center>
        <label for="iddoc" style="font-weight: bold;">ID a consultar:</label>
        <div class="input-container">
            <input type="text" id="iddoc" name="iddoc" required class="line-input">
        </div>
        <input type="hidden" name="accion" id="accion" value="consulta">
    </center>
    <br><br>
    <center>
        <button type="submit" class="boton">Consultar</button>
    </center>
</form>






<script src="${pageContext.request.contextPath}/js/admin/script.js"></script>
<!-- Script personalizado -->
</body>

</html>--%>




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
    <h1>Consultas</h1>
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
    <aside>
        <img src="${pageContext.request.contextPath}/resource/img/logo.png" class="sirbev" alt="UTEZ Logo">
        <p>En esta sección puedes realizar consultas de los docentes registrados mediante un identificador único.</p>
    </aside>
    <main>
        <form id="consulta" method="post" class="sesion needs-validation" action="${pageContext.request.contextPath}/DocenteServlet" enctype="multipart/form-data">
            <center>
                <label for="iddoc" style="font-weight: bold;">Número de identificador a consultar:</label>
                <div class="input-container">
                    <input type="text" id="iddoc" name="iddoc" required class="line-input">
                </div>
                <input type="hidden" name="accion" id="accion" value="consulta">
            </center>
            <br><br>
            <center>
                <button type="submit" class="boton">Aceptar</button>
            </center>
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
            title: "Consultando",
            showConfirmButton: false,
            timer: 1500
        });
    }

</script>
</body>
</html>