package com.utez.edu.libreria.dao;

import com.utez.edu.libreria.models.AlumnoBean;
import com.utez.edu.libreria.utils.MySQLConnection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AlumnoDAO {
    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;
    private String sqlConsultarUsuario = "SELECT * FROM alumnos WHERE matricula = ?";
    private Logger logger = LoggerFactory.getLogger(AlumnoDAO.class);


    public boolean registrar(AlumnoBean alumno) {
        boolean registrado = false;
        try {
            con = MySQLConnection.getConnection();
            String sql = "INSERT INTO alumnos (matricula, nombre, apellidoP, apellidoM, correo, tel, sexo, cuatrimestre, grupo, descripcion, iddocente, idcarrera) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, alumno.getMatricula());
            ps.setString(2, alumno.getNombre());
            ps.setString(3, alumno.getApellidoP());
            ps.setString(4, alumno.getApellidoM());
            ps.setString(5, alumno.getCorreo());
            ps.setString(6, alumno.getTel());
            ps.setString(7, alumno.getSexo());
            ps.setInt(8, alumno.getCuatrimestre());
            ps.setString(9, alumno.getGrupo());
            ps.setString(10, alumno.getDescripcion());
            ps.setString(11, alumno.getIddocente());
            ps.setInt(12, alumno.getIdcarrera());
            registrado = ps.executeUpdate() == 1;
        } catch (SQLException e) {
            logger.error("Error al registrar alumno: " + e.getMessage());
        } finally {
            close();
        }
        return registrado;
    }

    public AlumnoBean consultarUsuario(AlumnoBean alumno) {
        AlumnoBean alumnoEncontrado = null;
        try {
            con = MySQLConnection.getConnection();
            ps = con.prepareStatement(sqlConsultarUsuario);
            ps.setString(1, alumno.getMatricula());
            rs = ps.executeQuery();
            if (rs.next()) {
                alumnoEncontrado = new AlumnoBean();
                alumnoEncontrado.setMatricula(rs.getString("matricula"));
                alumnoEncontrado.setNombre(rs.getString("nombre"));
                alumnoEncontrado.setApellidoP(rs.getString("apellidoP"));
                alumnoEncontrado.setApellidoM(rs.getString("apellidoM"));
                alumnoEncontrado.setCorreo(rs.getString("correo"));
                alumnoEncontrado.setTel(rs.getString("tel"));
                alumnoEncontrado.setSexo(rs.getString("sexo"));
                alumnoEncontrado.setCuatrimestre(rs.getInt("cuatrimestre"));
                alumnoEncontrado.setGrupo(rs.getString("grupo"));
                alumnoEncontrado.setDescripcion(rs.getString("descripcion"));
                alumnoEncontrado.setIddocente(rs.getString("iddocente"));
                alumnoEncontrado.setIdcarrera(rs.getInt("idcarrera"));
            }
        } catch (SQLException e) {
            logger.error("Error al consultar alumno: " + e.getMessage());
        } finally {
            close();
        }
        return alumnoEncontrado;
    }

    public List<AlumnoBean> consultarTodos() {
        List<AlumnoBean> listaAlumnos = new ArrayList<>();
        try {
            con = MySQLConnection.getConnection();
            String todos = "SELECT * FROM alumnos";
            ps = con.prepareStatement(todos);
            rs = ps.executeQuery();
            while (rs.next()) {
                AlumnoBean alumno = new AlumnoBean();
                alumno.setMatricula(rs.getString("matricula"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setApellidoP(rs.getString("apellidoP"));
                alumno.setApellidoM(rs.getString("apellidoM"));
                alumno.setCorreo(rs.getString("correo"));
                alumno.setTel(rs.getString("tel"));
                alumno.setSexo(rs.getString("sexo"));
                alumno.setCuatrimestre(rs.getInt("cuatrimestre"));
                alumno.setGrupo(rs.getString("grupo"));
                alumno.setDescripcion(rs.getString("descripcion"));
                alumno.setIddocente(rs.getString("iddocente"));
                alumno.setIdcarrera(rs.getInt("idcarrera"));
                listaAlumnos.add(alumno);
            }
        } catch (SQLException e) {
            logger.error("Error al consultar todos los alumnos: " + e.getMessage());
        } finally {
            close();
        }
        return listaAlumnos;
    }

    public AlumnoBean consultarID(String matricula) {
        AlumnoBean alumnoEncontrado = null;
        try {
            con = MySQLConnection.getConnection();
            String sql = "SELECT a.*, c.carrera FROM alumnos a JOIN carreras c ON a.idcarrera = c.id WHERE a.matricula = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, matricula);
            rs = ps.executeQuery();
            if (rs.next()) {
                alumnoEncontrado = new AlumnoBean();
                alumnoEncontrado.setMatricula(rs.getString("matricula"));
                alumnoEncontrado.setNombre(rs.getString("nombre"));
                alumnoEncontrado.setApellidoP(rs.getString("apellidoP"));
                alumnoEncontrado.setApellidoM(rs.getString("apellidoM"));
                alumnoEncontrado.setCorreo(rs.getString("correo"));
                alumnoEncontrado.setTel(rs.getString("tel"));
                alumnoEncontrado.setSexo(rs.getString("sexo"));
                alumnoEncontrado.setCuatrimestre(rs.getInt("cuatrimestre"));
                alumnoEncontrado.setGrupo(rs.getString("grupo"));
                alumnoEncontrado.setDescripcion(rs.getString("descripcion"));
                alumnoEncontrado.setIddocente(rs.getString("iddocente"));
                alumnoEncontrado.setIdcarrera(rs.getInt("idcarrera"));
                alumnoEncontrado.setCarrera(rs.getString("carrera")); // Asignar el nombre de la carrera
            }
        } catch (SQLException e) {
            logger.error("Error al consultar alumno por matrícula: " + e.getMessage());
        } finally {
            close();
        }
        return alumnoEncontrado;
    }

    public boolean modificar(AlumnoBean alumno) {
        boolean modificado = false;
        try {
            con = MySQLConnection.getConnection();
            String sql = "UPDATE alumnos SET nombre=?, apellidoP=?, apellidoM=?, correo=?, tel=?, sexo=?, cuatrimestre=?, grupo=?, descripcion=?, iddocente=?, idcarrera=? WHERE matricula=?";
            ps = con.prepareStatement(sql);
            ps.setString(1, alumno.getNombre());
            ps.setString(2, alumno.getApellidoP());
            ps.setString(3, alumno.getApellidoM());
            ps.setString(4, alumno.getCorreo());
            ps.setString(5, alumno.getTel());
            ps.setString(6, alumno.getSexo());
            ps.setInt(7, alumno.getCuatrimestre());
            ps.setString(8, alumno.getGrupo());
            ps.setString(9, alumno.getDescripcion());
            ps.setString(10, alumno.getIddocente());
            ps.setInt(11, alumno.getIdcarrera());
            ps.setString(12, alumno.getMatricula());
            modificado = ps.executeUpdate() == 1;
        } catch (SQLException e) {
            logger.error("Error al modificar alumno: " + e.getMessage());
        } finally {
            close();
        }
        return modificado;
    }

    public boolean eliminar(AlumnoBean alumno) {
        boolean eliminado = false;
        try {
            con = MySQLConnection.getConnection();
            String sql = "DELETE FROM alumnos WHERE matricula=?;";
            ps = con.prepareStatement(sql);
            ps.setString(1, alumno.getMatricula());
            eliminado = ps.executeUpdate() == 1;
        } catch (SQLException e) {
            logger.error("Error al eliminar alumno: " + e.getMessage());
        } finally {
            close();
        }
        return eliminado;
    }

    private void close() {
        try {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (con != null) {
                con.close();
            }
        } catch (SQLException e) {
            logger.error("Error al cerrar recursos: " + e.getMessage());
        }
    }
}
