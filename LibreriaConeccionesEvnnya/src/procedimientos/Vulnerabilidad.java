/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package procedimientos;

import conecciones.Pruebas_coneccion_evnnya;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jahir
 */
public class Vulnerabilidad {
    
    //AGREGAR VULNERABILIDAD
    public void agregarVulnerabilidad(Connection con, String numero_expedinte, String tipo_vulnerabilidad) {
        
        try {
            
            CallableStatement pstmt = con.prepareCall("{call dbo.AgregarVulnerabilidad(?,?)}");
            
            pstmt.setString(1, numero_expedinte);
            pstmt.setString(2, tipo_vulnerabilidad);
      
            
            pstmt.execute();
            
                System.out.println("SE AGREGO VULNERABILIDAD CORRECTAMENTE");
            
            pstmt.close();
            
        } catch (Exception e) {
            Logger.getLogger(Pruebas_coneccion_evnnya.class.getName()).log(Level.SEVERE, null, e);
        }
        
    }
    
}
