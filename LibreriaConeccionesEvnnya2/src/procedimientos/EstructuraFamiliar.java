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
 * @author Alex
 */
public class EstructuraFamiliar {
    
    //AGREGAR USUARIO
    public void agregarEstructuraFamiliar(Connection con, int id_evaluacion, String nombres, String apellido_paterno,
                                            String apellido_materno,String parentezco, int edad, String sexo,
                                            String estado_civil, String escolaridad, String ocupacion){
        
        try {
            
            CallableStatement pstmt = con.prepareCall("{call dbo.AgregarUsuario(?,?,?,?,?,"
                                                                                + "?,?,?,?,?)}");
            
            pstmt.setInt(1, id_evaluacion);
            pstmt.setString(2, nombres);
            pstmt.setString(3, apellido_paterno);
            pstmt.setString(4, apellido_materno);
            pstmt.setString(5, parentezco);
            pstmt.setInt(6, edad);
            pstmt.setString(7, sexo);
            pstmt.setString(8, estado_civil);
            pstmt.setString(9, escolaridad);
            pstmt.setString(10, ocupacion);
            
            pstmt.execute();
            
                System.out.println("SE AGREGO ESTRUCTURA FAMILIAR CORRECTAMENTE");
            
            pstmt.close();
            
        } catch (Exception e) {
            Logger.getLogger(Pruebas_coneccion_evnnya.class.getName()).log(Level.SEVERE, null, e);
        }
        
    }
    
}
