/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conecciones;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jahir
 */
public class ProcedimientoAlmacenado {
    
    public void procedimiento(Connection con){
        
        try {
            
            PreparedStatement pstmt = con.prepareStatement("{call dbo.ProcedimientoPrueba(?)}");
            pstmt.setInt(1, 2);
            
            ResultSet rs = pstmt.executeQuery();
            
            while(rs.next()){
                
                System.out.println("Nombre: " + rs.getString("nombre_prueba"));
                
            }
            
            rs.close();
            pstmt.close();
            
        } catch (Exception e) {
            Logger.getLogger(Pruebas_coneccion_evnnya.class.getName()).log(Level.SEVERE, null, e);
        }
        
    }
    
}
