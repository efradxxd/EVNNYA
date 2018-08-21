/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conecciones;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jahir
 */
public class Conexion {
    
    public Connection cadena_conexion(){
        Connection cn = null;
       
        try {
            
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            
            //cn = DriverManager.getConnection("jdbc:sqlserver://10.6.245.10;databaseName=EVNNYADB","sa","M7750la");
            cn = DriverManager.getConnection("jdbc:sqlserver://192.168.0.28\\sqlexpress;databaseName=EVNNYADB","sa","M7750la");
            
            System.out.println("Se connecto la base de datos correctamente...");
            
        } catch (Exception e) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, e);
        } 
        return cn;
        
    }
    
}
