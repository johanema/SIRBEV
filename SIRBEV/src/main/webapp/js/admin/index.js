document.getElementById('login').addEventListener('submit', function (event) {
    event.preventDefault(); // Prevenir la acción de envío predeterminada del formulario

    console.log("Inicio de sesión en proceso..."); // Mensaje en la consola para depuración

    let id = document.getElementById('id').value; // Obtener el valor del ID de usuario
    let password = document.getElementById('password').value; // Obtener el valor de la contraseña

    // Verificar las credenciales
    if (id === 'beatrizamado' && password === 'cisco123') {
        // Mostrar una alerta de éxito usando SweetAlert2
        Swal.fire({
            title: "¡Bienvenido!",
            text: "Acceso autorizado",
            icon: "success",
            // Eliminar el botón de confirmación
            showConfirmButton: false,
            allowOutsideClick: true,
            allowEscapeKey: true,
            customClass: {
                confirmButton: 'boton',
                cancelButton: 'boton',
            }
        });

        // Redirigir automáticamente después de 2 segundos
        setTimeout(() => {
            window.location.href = '../html/inicio.html'; // Redirigir a la página de sesión
        }, 2000); // 2000 milisegundos = 2 segundos
    } else {
        // Mostrar una alerta de error usando SweetAlert2
        Swal.fire({
            title: "Error",
            text: "El usuario o la contraseña son incorrectos",
            icon: "error",
            showConfirmButton: false, // Ocultar el botón de confirmación
            timer: 3000 
        });
        setTimeout(() => {
            window.location.href = 'index.html'; // Redirigir a la página de sesión
        }, 2000);
    }
});
