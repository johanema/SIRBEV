package com.utez.edu.libreria.dao;

import com.utez.edu.libreria.models.AdministradorBean;
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
/*
org.slf4j:sfl4j-api:1.7.30*/

public class AdministradorDAO {
    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;
    private String sqlConsultarUsuario = "SELECT * FROM administradores WHERE idadmin = ? AND passadmin = ?;";
    private Logger logger = LoggerFactory.getLogger(AdministradorDAO.class);

    // Metodo para visualizar una imagen
    public void mostrarImagen(String id, HttpServletResponse response) {
        InputStream inputStream = null;
        OutputStream outputStream = null;
        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null;
        response.setContentType("image/jpg");
        try {
            outputStream = response.getOutputStream();
            Connection con = MySQLConnection.getConnection();
            String consultaImagen = "SELECT * FROM administradores WHERE idadmin=" + "'" + id + "'";
            PreparedStatement pstm = con.prepareStatement(consultaImagen);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                inputStream = rs.getBinaryStream("fotoadmin");
            }
            bufferedInputStream = new BufferedInputStream(inputStream);
            bufferedOutputStream = new BufferedOutputStream(outputStream);
            int i = 0;
            while ((i = bufferedInputStream.read()) != -1) {
                bufferedOutputStream.write(i);
            }
            bufferedInputStream.close();
            bufferedOutputStream.close();
            pstm.close();
            con.close();
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }

    public boolean registrar(AdministradorBean usuario) {
        boolean registrado = false;
        try {
            con = MySQLConnection.getConnection();
            String sql = "INSERT INTO administradores (idadmin, passadmin, nomadmin, apePadmin, apeMadmin, correoadmin, teladmin, fotoadmin) VALUES (?,?,?,?,?,?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, usuario.getIdadmin());
            ps.setString(2, usuario.getPassadmin());
            ps.setString(3, usuario.getNomadmin());
            ps.setString(4, usuario.getApePadmin());
            ps.setString(5, usuario.getApeMadmin());
            ps.setString(6, usuario.getCorreoadmin());
            ps.setString(7, usuario.getTeladmin());
            // Para el campo de imagen
            if (usuario.getFotoadmin() != null) {
                ps.setBlob(8, usuario.getFotoadmin());
            } else {
                ps.setNull(8, Types.BLOB);
            }
            registrado = ps.executeUpdate() == 1;
        } catch (SQLException e) {
            logger.error("Error al registrar usuario: " + e.getMessage());
        } finally {
            close();
        }
        return registrado;
    }

    public AdministradorBean consultarUsuario(AdministradorBean usuario) {
        AdministradorBean usuarioEncontrado = null;
        try {
            con = MySQLConnection.getConnection();
            ps = con.prepareStatement(sqlConsultarUsuario);
            ps.setString(1, usuario.getIdadmin());
            ps.setString(2, usuario.getPassadmin());
            rs = ps.executeQuery();
            if (rs.next()) {
                usuarioEncontrado = new AdministradorBean();
                usuarioEncontrado.setIdadmin(rs.getString("idadmin"));
                usuarioEncontrado.setPassadmin(rs.getString("passadmin"));
                usuarioEncontrado.setNomadmin(rs.getString("nomadmin"));
                usuarioEncontrado.setApePadmin(rs.getString("apePadmin"));
                usuarioEncontrado.setApeMadmin(rs.getString("apeMadmin"));
                usuarioEncontrado.setCorreoadmin(rs.getString("correoadmin"));
                usuarioEncontrado.setTeladmin(rs.getString("teladmin"));
                // Aquí puedes establecer más atributos del bean según tu aplicación
            }
        } catch (SQLException e) {
            logger.error("Error al consultar usuario: " + e.getMessage());
        } finally {
            close();
        }
        return usuarioEncontrado;
    }

    public List<AdministradorBean> consultarTodos() {
        List<AdministradorBean> ListaUsuarios = new ArrayList<>();
        try {
            con = MySQLConnection.getConnection();
            String todos = "SELECT * FROM administradores";
            ps = con.prepareStatement(todos);
            rs = ps.executeQuery();
            while (rs.next()) {
                AdministradorBean usuario = new AdministradorBean();
                usuario.setIdadmin(rs.getString("idadmin"));
                usuario.setPassadmin(rs.getString("passadmin"));
                usuario.setNomadmin(rs.getString("nomadmin"));
                usuario.setApePadmin(rs.getString("apePadmin"));
                usuario.setApeMadmin(rs.getString("apeMadmin"));
                usuario.setCorreoadmin(rs.getString("correoadmin"));
                usuario.setTeladmin(rs.getString("teladmin"));
                usuario.setFotoadmin(rs.getBytes("fotoadmin"));

                // Aquí puedes establecer más atributos del bean según tu aplicación
                ListaUsuarios.add(usuario);
            }
        } catch (SQLException e) {
            logger.error("Error al consultar todos los usuarios: " + e.getMessage());
        } finally {
            close();
        }
        return ListaUsuarios;
    }

    public AdministradorBean consultarID(String idadmin) {
        AdministradorBean usuarioEncontrado = null;
        try {
            con = MySQLConnection.getConnection();
            String sql = "SELECT * FROM administradores WHERE idadmin = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, idadmin);
            rs = ps.executeQuery();
            if (rs.next()) {
                usuarioEncontrado = new AdministradorBean();
                usuarioEncontrado.setIdadmin(rs.getString("idadmin"));
                usuarioEncontrado.setPassadmin(rs.getString("passadmin"));
                usuarioEncontrado.setNomadmin(rs.getString("nomadmin"));
                usuarioEncontrado.setApePadmin(rs.getString("apePadmin"));
                usuarioEncontrado.setApeMadmin(rs.getString("apeMadmin"));
                usuarioEncontrado.setCorreoadmin(rs.getString("correoadmin"));
                usuarioEncontrado.setTeladmin(rs.getString("teladmin"));
                usuarioEncontrado.setFotoadmin(rs.getBytes("fotoadmin"));

                // Aquí puedes establecer más atributos del bean según tu aplicación
            }
        } catch (SQLException e) {
            logger.error("Error al consultar usuario por ID: " + e.getMessage());
        } finally {
            close();
        }
        return usuarioEncontrado;
    }

    public boolean modificar(AdministradorBean usuario) {
        boolean modificado = false;
        try {
            con = MySQLConnection.getConnection();
            String sql = "UPDATE administradores SET passadmin=?, nomadmin=?, apePadmin=?, apeMadmin=?, correoadmin=?, teladmin=?, fotoadmin=? WHERE idadmin=?";
            ps = con.prepareStatement(sql);
            ps.setString(1, usuario.getPassadmin());
            ps.setString(2, usuario.getNomadmin());
            ps.setString(3, usuario.getApePadmin());
            ps.setString(4, usuario.getApeMadmin());
            ps.setString(5, usuario.getCorreoadmin());
            ps.setString(6, usuario.getTeladmin());
            // Para el campo de imagen
            if (usuario.getFotoadmin() != null) {
                ps.setBlob(7, usuario.getFotoadmin());
            } else {
                ps.setNull(7, Types.BLOB);
            }
            ps.setString(8, usuario.getIdadmin());
            modificado = ps.executeUpdate() == 1;
        } catch (SQLException e) {
            logger.error("Error al modificar usuario: " + e.getMessage());
        } finally {
            close();
        }
        return modificado;
    }

    public boolean eliminar(AdministradorBean usuario) {
        boolean eliminado = false;
        try {
            con = MySQLConnection.getConnection();
            String sql = "DELETE FROM administradores WHERE idadmin=?;";
            ps = con.prepareStatement(sql);
            ps.setString(1, usuario.getIdadmin());

            eliminado = ps.executeUpdate() == 1;
        } catch (SQLException e) {
            logger.error("Error al eliminar usuario: " + e.getMessage());
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
