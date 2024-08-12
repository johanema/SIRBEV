<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/index.css">
    <title>SIRBEV - Inicio de sesión</title>
    <link rel="icon" href="${pageContext.request.contextPath}/resource/icon/logo.ico">
</head>
<body>
<header>
    <h1>INICIO DE SESIÓN</h1>
</header>
<section class="logos">
    <img src="${pageContext.request.contextPath}/resource/img/logo.png" class="sirbev" height="20%">
    <img src="${pageContext.request.contextPath}/resource/img/utez.png" class="utez" height="20%">
</section>

<section class="login">
    <br><br>
    <form class="sesion" id="loginForm" method="POST" onsubmit="return changeAction()">
        <section>
            <select id="accountType" name="accountType" onchange="changeAction()" required>
                <option value="" disabled selected>Iniciar como</option>
                <option value="administrador">Administrador</option>
                <option value="docente">Docente</option>
            </select>
        </section>
        <section>
            <label for="id">Identificador:</label>
            <input type="text" id="id" name="id" required>
        </section>
        <section>
            <label for="pass">Contraseña:</label>
            <input type="password" id="pass" name="pass" required>
        </section>
        <button class="boton" type="submit" onclick="inicio();">Entrar</button>
    </form>
</section>

<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
<script src="js/index.js"></script>
<script>
    function changeAction() {
        const form = document.getElementById('loginForm');
        const accountType = document.getElementById('accountType').value;
        const idField = document.getElementById('id');
        const passField = document.getElementById('pass');

        if (accountType === 'administrador') {
            form.action = '${pageContext.request.contextPath}/AdministradorServlet?accion=inicioSesion';
            idField.name = "idadmin";
            passField.name = "passadmin";
        } else if (accountType === 'docente') {
            form.action = '${pageContext.request.contextPath}/DocenteServlet?accion=inicioSesion';
            idField.name = "iddoc";
            passField.name = "passdoc";
        } else {
            alert("Por favor, seleccione un tipo de cuenta.");
            return false;
        }

        // Asegura que los nombres se han actualizado correctamente antes de enviar
        if (idField.name === "idadmin" || idField.name === "iddoc") {
            return true;  // Permite el envío del formulario
        } else {
            alert("Hubo un error al cambiar los nombres de los campos.");
            return false;  // Detiene el envío del formulario
        }
    }



    function inicio(){
        Swal.fire({
            position: "center",
            icon: "success",
            title: "Inicio correcto",
            showConfirmButton: false,
            timer: 1500
        });
    }
</script>
</body>
</html>
