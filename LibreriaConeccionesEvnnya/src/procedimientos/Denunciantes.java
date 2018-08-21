/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package procedimientos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import conecciones.Pruebas_coneccion_evnnya;

/**
 *
 * @author jahir
 */
public class Denunciantes {
    //AGREGAR DENUNCIANTE
    public void agregarDenunciante(Connection con, int tipo_denunciante, String nombres, String apellido_paterno,
                                String apellido_materno, int edad, String sexo, String escolaridad, String relacion_victima){
        
        try {
            
            CallableStatement pstmt = con.prepareCall("{call dbo.AgregarDenunciante(?,?,?,?,?,"
                                                                                + "?,?,?)}");
            
            pstmt.setInt(1, tipo_denunciante);
            pstmt.setString(2, nombres);
            pstmt.setString(3, apellido_paterno);
            pstmt.setString(4, apellido_materno);
            pstmt.setInt(5, edad);
            pstmt.setString(6, sexo);
            pstmt.setString(7, escolaridad);
            pstmt.setString(8, relacion_victima);
            
            pstmt.execute();
            
                System.out.println("SE AGREGO DENUNCIANTE CORRECTAMENTE");
            
            pstmt.close();
            
        } catch (Exception e) {
            Logger.getLogger(Pruebas_coneccion_evnnya.class.getName()).log(Level.SEVERE, null, e);
        }
        
    }
    
    //ACTUALIZAR DENUNCIANTE  //SE ACTUALIZA POR MEDIO DEL ID
    public void actualizarDenunciante(Connection con, int tipo_denunciante, String nombres, String apellido_paterno,
                                String apellido_materno, int edad, String sexo, String escolaridad, String relacion_victima,
                                int id_denunciante){
        
        try {
            
            CallableStatement pstmt = con.prepareCall("{call dbo.ActualizarDenunciante(?,?,?,?,?,"
                                                                                + "?,?,?,?)}");
            
            pstmt.setInt(1, tipo_denunciante);
            pstmt.setString(2, nombres);
            pstmt.setString(3, apellido_paterno);
            pstmt.setString(4, apellido_materno);
            pstmt.setInt(5, edad);
            pstmt.setString(6, sexo);
            pstmt.setString(7, escolaridad);
            pstmt.setString(8, relacion_victima);
            pstmt.setInt(9, id_denunciante);
            
            pstmt.execute();
            
                System.out.println("SE ACTUALIZO DENUNCIANTE CORRECTAMENTE");
            
            pstmt.close();
            
        } catch (Exception e) {
            Logger.getLogger(Pruebas_coneccion_evnnya.class.getName()).log(Level.SEVERE, null, e);
        }
        
    }
}
