function iniciarSesion() {
    const userId = document.getElementById('userId').value;
    const password = document.getElementById('password').value;
    
    if (userId && password) {
        alert('Inicio de sesión exitoso.\nID: ' + userId + '\nContraseña: ' + password);
    } else {
        alert('Por favor, complete todos los campos.');
    }
}
