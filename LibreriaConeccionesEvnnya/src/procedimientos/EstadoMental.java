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
public class EstadoMental {
    
    //AGREGAR ESTADO MENTAL
    public void agregarEstadoMental(Connection con, int id_estado_mental, int id_evaluacion, int id_psicologo, String apariencia_fisica, String conducta_motriz,
                                    String habla_lenguaje, String socializacion, String orientacion, String consciencia, String memoria, String percepcion,
                                    String pensamiento, String afecto_emocion, String ineteligencia, String resultado_tecnica, String conclusiones, String sugerencias) {
        
        try {
            
            CallableStatement pstmt = con.prepareCall("{call dbo.AgregarEstadoMental(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
            
            pstmt.setInt(1, id_evaluacion);
            pstmt.setInt(2, id_psicologo);
            pstmt.setString(3, apariencia_fisica);
            pstmt.setString(4, conducta_motriz);
            pstmt.setString(5, habla_lenguaje);
            pstmt.setString(6, socializacion);
            pstmt.setString(7, orientacion);
            pstmt.setString(8, consciencia);
            pstmt.setString(9, memoria);
            pstmt.setString(10, percepcion);
            pstmt.setString(11, pensamiento);
            pstmt.setString(12, afecto_emocion);
            pstmt.setString(13, ineteligencia);
            pstmt.setString(14, resultado_tecnica);
            pstmt.setString(15, conclusiones);
            pstmt.setString(16, sugerencias);
      
            
            pstmt.execute();
            
                System.out.println("SE AGREGO ESTADO MENTAL CORRECTAMENTE");
            
            pstmt.close();
            
        } catch (Exception e) {
            Logger.getLogger(Pruebas_coneccion_evnnya.class.getName()).log(Level.SEVERE, null, e);
        }
        
    }
    
}
