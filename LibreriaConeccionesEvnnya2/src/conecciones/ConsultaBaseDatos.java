/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conecciones;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jahir
 */
public class ConsultaBaseDatos {
    
    public void consultaBaseDatos(){
        
        try {
            
            Conexion cn = new Conexion();
            Connection con = cn.cadena_conexion();
            
            int conexion = 0;
            PreparedStatement ps = null;
            ResultSet rs = null;
            
            ps = con.prepareStatement("select COUNT(*) from tabla_pruebas");
            rs = ps.executeQuery();
            
            if(rs.next()){
                
                System.out.println("Count: "+rs.getString(1));
                
            }
            
        } catch (Exception e) {
            Logger.getLogger(Pruebas_coneccion_evnnya.class.getName()).log(Level.SEVERE, null, e);
        }
        
    }
    
}
