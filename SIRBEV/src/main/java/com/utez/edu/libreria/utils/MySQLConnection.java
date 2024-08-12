package com.utez.edu.libreria.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MySQLConnection {
    private static String ipAddress;
    private static String dbName;
    private static String user;
    private static String password;
    private static String service;
    private static ResourceBundle properties;

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            Logger.getLogger(MySQLConnection.class.getName()).log(Level.SEVERE, null, e);
        }

        if (properties == null) {
            properties = ResourceBundle.getBundle("db_connection");
            ipAddress = properties.getString("ip_address");
            dbName = properties.getString("db_name");
            user = properties.getString("user");
            password = properties.getString("password");
            service = properties.getString("service");
        }

        return DriverManager.getConnection("jdbc:mysql://" + ipAddress + ":" + service + "/" + dbName, user, password);
    }

    public static void main(String [] args){
        try{
            Connection connection = getConnection();
            System.out.println("Si se conectó");
            connection.close();
        }catch(SQLException e){
            Logger.getLogger(MySQLConnection.class.getName()).log(Level.SEVERE, null, e);
        }
    }

}
