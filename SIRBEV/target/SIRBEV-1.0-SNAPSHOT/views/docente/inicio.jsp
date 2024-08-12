<%-- Created by IntelliJ IDEA. User: johan Date: 20/06/2024 Time: 10:09 a. m. To change this template use File | Settings | File Templates. --%>
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
  <h1>Sistema Integral de Registro de Becas de Vulnerabilidad</h1>
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
  <aside>
    <img src="${pageContext.request.contextPath}/resource/img/logo.png" class="sirbev" alt="UTEZ Logo">
    <h3>Objetivo</h3>
    <p>Mejorar el registro y seguimiento de solicitudes de becas para estudiantes en situación de vulnerabilidad.</p> <br> <br>
  </aside>
  <main>
    <%
      String iddoc= (String)(session.getAttribute("iddoc"));
      String passdoc= (String)(session.getAttribute("passdoc"));
      String nomdoc= (String)(session.getAttribute("nomdoc"));
      String apePdoc= (String)(session.getAttribute("apePdoc"));
      String apeMdoc= (String)(session.getAttribute("apeMdoc"));
      String correodoc= (String)(session.getAttribute("correodoc"));
      String teldoc= (String)(session.getAttribute("teldoc"));
    %>
    <h2>Docente</h2>
    <form id="modificacionesinicio" method="post" class="sesion needs-validation" action="${pageContext.request.contextPath}/DocenteServlet" enctype="multipart/form-data">
      <div class="tablas">
        <table>
          <tr>
            <td><strong>Número de identificador de docente:</strong></td>
            <td><input type="text" name="iddoc" value="<%=iddoc%>" class="line-input" readonly></td>
          </tr>
          <tr>
            <td><strong>Nombre:</strong></td>
            <td><input type="text" name="nomdoc" value="<%=nomdoc%>" class="line-input"></td>
          </tr>
          <tr>
            <td><strong>Apellido paterno:</strong></td>
            <td><input type="text" name="apePdoc" value="<%=apePdoc%>" class="line-input"></td>
          </tr>
          <tr>
            <td><strong>Apellido materno:</strong></td>
            <td><input type="text" name="apeMdoc" value="<%=apeMdoc%>" class="line-input"></td>
          </tr>
          <tr>
            <td><strong>Contraseña:</strong></td>
            <td><input type="password" name="passdoc" value="<%=passdoc%>" class="line-input"></td>
          </tr>
          <tr>
            <td><strong>Correo:</strong></td>
            <td><input type="email" name="correodoc" value="<%=correodoc%>" class="line-input"></td>
          </tr>
          <tr>
            <td><strong>Teléfono:</strong></td>
            <td><input type="text" name="teldoc" value="<%=teldoc%>" class="line-input"></td>
          </tr>
          <tr>
            <td><strong>Foto:</strong></td>
            <td>
              <img src="${pageContext.request.contextPath}/DocenteServlet?accion=mostrarImagen&iddoc=<%=iddoc%>" class="foto" width="150px"/>
            </td>
          </tr>
          <tr>
            <td><input type="file" id="fotodoc" name="fotodoc"></td>
          </tr>
          <tr>
            <td colspan="2">
              <center>
                <input type="hidden" name="accion" value="modificacionesinicio">
                <button type="submit" onclick="inicio()" class="boton">Guardar</button>
              </center>
            </td>
          </tr>
        </table><br><br>
      </div>
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
      title: "Datos guardados exitosamente",
      showConfirmButton: false,
      timer: 1500
    });
  }
</script>
</body>
</html>
