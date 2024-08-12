package com.utez.edu.libreria.models;

public class AlumnoBean {
    String matricula;
    String nombre;
    String apellidoP;
    String apellidoM;
    String correo;
    String tel;
    String sexo;
    int cuatrimestre;
    String grupo;
    String descripcion;
    String iddocente;
    int idcarrera;

    public AlumnoBean() {
    }

    public AlumnoBean(String matricula, String nombre, String apellidoP, String apellidoM, String correo, String tel, String sexo, int cuatrimestre, String grupo, String descripcion, String iddocente, int idcarrera) {
        this.matricula = matricula;
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.correo = correo;
        this.tel = tel;
        this.sexo = sexo;
        this.cuatrimestre = cuatrimestre;
        this.grupo = grupo;
        this.descripcion = descripcion;
        this.iddocente = iddocente;
        this.idcarrera = idcarrera;
    }

    public AlumnoBean(String nombre, String apellidoP, String apellidoM, String correo, String tel, String sexo, int cuatrimestre, String grupo, String descripcion, String iddocente, int idcarrera) {
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.correo = correo;
        this.tel = tel;
        this.sexo = sexo;
        this.cuatrimestre = cuatrimestre;
        this.grupo = grupo;
        this.descripcion = descripcion;
        this.iddocente = iddocente;
        this.idcarrera = idcarrera;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoP() {
        return apellidoP;
    }

    public void setApellidoP(String apellidoP) {
        this.apellidoP = apellidoP;
    }

    public String getApellidoM() {
        return apellidoM;
    }

    public void setApellidoM(String apellidoM) {
        this.apellidoM = apellidoM;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getCuatrimestre() {
        return cuatrimestre;
    }

    public void setCuatrimestre(int cuatrimestre) {
        this.cuatrimestre = cuatrimestre;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getIddocente() {
        return iddocente;
    }

    public void setIddocente(String iddocente) {
        this.iddocente = iddocente;
    }

    public int getIdcarrera() {
        return idcarrera;
    }

    public void setIdcarrera(int idcarrera) {
        this.idcarrera = idcarrera;
    }
    private String carrera;

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getCarrera() {
        return carrera;
    }
}
