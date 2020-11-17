/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.TimeZone;

/**
 *
 * @author angel
 */
public class Conexion {
    Connection conexionBD = null;
    public Conexion(){        
        String bd = "jdbc:mysql://localhost/LigaAjedrez?serverTimezone=" + TimeZone.getDefault().getID();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Driver de mysql
            // Conexión usando usuario y clave de administrador de la BD
            conexionBD = DriverManager.getConnection(bd, "root", "ISIIPassword");
        } catch (Exception e) { // Error en la conexión con la BD
            System.out.println("Error de conexión");
        }       
        
    }
    
    public Connection getConnection(){
            return conexionBD;
    }
    
    public void desconectar(){
            conexionBD=null;
    }   
    
}
