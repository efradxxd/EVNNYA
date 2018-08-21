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
public class Denuncias {
    
    //AGREGAR DENUNCIA
    public void agregarDenuncia(Connection con, int id_denunciante, String numero_expediente,
                                String fecha, int id_usuario) {
        
        try {
            
            CallableStatement pstmt = con.prepareCall("{call dbo.AgregarDenuncias(?,?,?,?)}");
            
            pstmt.setInt(1, id_denunciante);
            pstmt.setString(2, numero_expediente);
            pstmt.setString(3, fecha);
            pstmt.setInt(4, id_usuario);
      
            
            pstmt.execute();
            
                System.out.println("SE AGREGO DENUNCIA CORRECTAMENTE");
            
            pstmt.close();
            
        } catch (Exception e) {
            Logger.getLogger(Pruebas_coneccion_evnnya.class.getName()).log(Level.SEVERE, null, e);
        }
        
    }
    
}
