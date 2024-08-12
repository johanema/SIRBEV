package com.utez.edu.libreria.dao;



import com.utez.edu.libreria.models.DocenteBean;
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

public class DocenteDAO {
    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;
    private String sqlConsultarUsuario = "SELECT * FROM docentes WHERE iddoc = ? AND passdoc = ?;";
    private Logger logger = LoggerFactory.getLogger(DocenteDAO.class);


    //Metodo para visualizar una imagen
    public void mostrarImagen(String id, HttpServletResponse response){
        InputStream inputStream=null;
        OutputStream outputStream=null;
        BufferedInputStream bufferedInputStream=null;
        BufferedOutputStream bufferedOutputStream=null;
        response.setContentType("image/jpg");
        try{
            outputStream=response.getOutputStream();
            Connection con=MySQLConnection.getConnection();
            String consultaImagen="SELECT * FROM docentes WHERE iddoc=" +"'"+ id+"'";
            PreparedStatement pstm=con.prepareStatement(consultaImagen);
            ResultSet rs=pstm.executeQuery();
            if(rs.next()){
                inputStream=rs.getBinaryStream("fotodoc");
            }
            bufferedInputStream=new BufferedInputStream(inputStream);
            bufferedOutputStream=new BufferedOutputStream(outputStream);
            int i=0;
            while ((i=bufferedInputStream.read())!=-1){
                bufferedOutputStream.write(i);
            }
            bufferedInputStream.close();
            bufferedOutputStream.close();
            pstm.close();
            con.close();
        }catch (Exception e){
            logger.error(e.getMessage());
        }
    }



    public boolean registrar(DocenteBean usuario) {
        boolean registrado = false;
        try {
            con = MySQLConnection.getConnection();
            String sql = "INSERT INTO docentes (iddoc,passdoc,nomdoc,apePdoc,apeMdoc,correodoc,teldoc,fotodoc,idadministrador) VALUES (?,?,?,?,?,?,?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, usuario.getIddoc());
            ps.setString(2, usuario.getPassdoc());
            ps.setString(3, usuario.getNomdoc());
            ps.setString(4, usuario.getApePdoc());
            ps.setString(5, usuario.getApeMdoc());
            ps.setString(6, usuario.getCorreodoc());
            ps.setString(7, usuario.getTeldoc());
            // Para el campo de imagen
            if (usuario.getFotodoc() != null) {
                ps.setBlob(8, usuario.getFotodoc());
            } else {
                ps.setNull(8, Types.BLOB);
            }
            ps.setString(9, usuario.getIdadministrador());
            registrado = ps.executeUpdate() == 1;
        } catch (SQLException e) {
            logger.error("Error al registrar usuario: " + e.getMessage());
        } finally {
            close();
        }
        return registrado;
    }

    public DocenteBean consultarUsuario(DocenteBean usuario) {
        DocenteBean usuarioEncontrado = null;
        try {
            con = MySQLConnection.getConnection();
            ps = con.prepareStatement(sqlConsultarUsuario);
            ps.setString(1, usuario.getIddoc());
            ps.setString(2, usuario.getPassdoc());
            rs = ps.executeQuery();
            if (rs.next()) {
                usuarioEncontrado = new DocenteBean();
                usuarioEncontrado.setIddoc(rs.getString("iddoc"));
                usuarioEncontrado.setPassdoc(rs.getString("passdoc"));
                usuarioEncontrado.setNomdoc(rs.getString("nomdoc"));
                usuarioEncontrado.setApePdoc(rs.getString("apePdoc"));
                usuarioEncontrado.setApeMdoc(rs.getString("apeMdoc"));
                usuarioEncontrado.setCorreodoc(rs.getString("correodoc"));
                usuarioEncontrado.setTeldoc(rs.getString("teldoc"));
                // Aquí puedes establecer más atributos del bean según tu aplicación
            }
        } catch (SQLException e) {
            logger.error("Error al consultar usuario: " + e.getMessage());
        } finally {
            close();
        }
        return usuarioEncontrado;
    }

    public List<DocenteBean> consultarTodos() {
        List<DocenteBean> ListaUsuarios = new ArrayList<>();
        try {
            con = MySQLConnection.getConnection();
            String todos = "SELECT * FROM docentes";
            ps = con.prepareStatement(todos);
            rs = ps.executeQuery();
            while (rs.next()) {
                DocenteBean usuario = new DocenteBean();
                usuario.setIddoc(rs.getString("iddoc"));
                usuario.setPassdoc(rs.getString("passdoc"));
                usuario.setNomdoc(rs.getString("nomdoc"));
                usuario.setApePdoc(rs.getString("apePdoc"));
                usuario.setApeMdoc(rs.getString("apeMdoc"));
                usuario.setCorreodoc(rs.getString("correodoc"));
                usuario.setTeldoc(rs.getString( "teldoc"));
                usuario.setFotodoc(rs.getBytes("fotodoc"));

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

    public DocenteBean consultarID(String iddoc) {
        DocenteBean usuarioEncontrado = null;
        try {
            con = MySQLConnection.getConnection();
            String sql = "SELECT * FROM docentes WHERE iddoc = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, iddoc);
            rs = ps.executeQuery();
            if (rs.next()) {
                usuarioEncontrado = new DocenteBean();
                usuarioEncontrado.setIddoc(rs.getString("iddoc"));
                usuarioEncontrado.setPassdoc(rs.getString("passdoc"));
                usuarioEncontrado.setNomdoc(rs.getString("nomdoc"));
                usuarioEncontrado.setApePdoc(rs.getString("apePdoc"));
                usuarioEncontrado.setApeMdoc(rs.getString("apeMdoc"));
                usuarioEncontrado.setCorreodoc(rs.getString("correodoc"));
                usuarioEncontrado.setTeldoc(rs.getString( "teldoc"));
                usuarioEncontrado.setFotodoc(rs.getBytes("fotodoc"));
                usuarioEncontrado.setIdadministrador(rs.getString("idadministrador"));

                // Aquí puedes establecer más atributos del bean según tu aplicación
            }
        } catch (SQLException e) {
            logger.error("Error al consultar usuario por ID: " + e.getMessage());
        } finally {
            close();
        }
        return usuarioEncontrado;
    }


    public List<String> consultarcarrera(String id) {
        List<String> carrera = new ArrayList<>();
        List<String> carrera2 = null;
        try {
            con = MySQLConnection.getConnection();
            String sql = "SELECT * FROM carreras";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                carrera2 = new ArrayList<>();
                carrera2.add(rs.getString("id"));
                carrera2.add(rs.getString("carrera"));
                // Aquí puedes establecer más atributos del bean según tu aplicación
            }
        } catch (SQLException e) {
            logger.error("Error al consultar usuario por ID: " + e.getMessage());
        } finally {
            close();
        }
        return carrera;
    }

    public boolean modificar(DocenteBean usuario) {
        boolean modificado = false;
        try {
            con = MySQLConnection.getConnection();
            String sql = "UPDATE docentes SET passdoc=?,nomdoc=?,apePdoc=?,apeMdoc=?,correodoc=?,teldoc=?,fotodoc=? WHERE iddoc=?";
            ps = con.prepareStatement(sql);
            ps.setString(1, usuario.getPassdoc());
            ps.setString(2, usuario.getNomdoc());
            ps.setString(3, usuario.getApePdoc());
            ps.setString(4, usuario.getApeMdoc());
            ps.setString(5, usuario.getCorreodoc());
            ps.setString(6, usuario.getTeldoc());
            // Para el campo de imagen
            if (usuario.getFotodoc() != null) {
                ps.setBlob(7, usuario.getFotodoc());
            } else {
                ps.setNull(7, Types.BLOB);
            }
            ps.setString(8, usuario.getIddoc());
            modificado = ps.executeUpdate() == 1;
        } catch (SQLException e) {
            logger.error("Error al modificar usuario: " + e.getMessage());
        } finally {
            close();
        }
        return modificado;
    }



    public boolean eliminar(DocenteBean usuario) {
        boolean eliminado = false;
        try {
            con = MySQLConnection.getConnection();
            String sql = "DELETE FROM docentes WHERE iddoc=?;";
            ps = con.prepareStatement(sql);
            ps.setString(1, usuario.getIddoc());

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

