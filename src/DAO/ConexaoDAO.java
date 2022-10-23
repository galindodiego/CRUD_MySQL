package DAO;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.DriverManager;
import java.sql.*;

/**
 *
 * @author Diego
 */
public class ConexaoDAO {

    public Connection conectaBD() throws ClassNotFoundException {
        Connection conn = null;
     //  Class.forName("com.mysql.jdbc.Driver");
        
        try {
           
            String url = "jdbc:mysql://localhost:3306/bancoteste?user=root&password=";
           // String url = "jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=CONVERT_TO_NULL";
          conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return conn;
    }
}
