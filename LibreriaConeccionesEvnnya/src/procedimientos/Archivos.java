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
public class Archivos {
    
    //AGREGAR ARCHIVO
    public void agregarArchivo(Connection con, int id_usuario, String numero_expediente, String ruta_archivo,
                                int estado, String fecha, String hora, String comentario){
        
        try {
            
            CallableStatement pstmt = con.prepareCall("{call dbo.AgregarArchivos(?,?,?,?,?,"
                                                                                + "?,?)}");
            
            pstmt.setInt(1, id_usuario);
            pstmt.setString(2, numero_expediente);
            pstmt.setString(3, ruta_archivo);
            pstmt.setInt(4, estado);
            pstmt.setString(5, fecha);
            pstmt.setString(6, hora);
            pstmt.setString(7, comentario);
            
            pstmt.execute();
            
                System.out.println("SE AGREGO ARCHIVO CORRECTAMENTE");
            
            pstmt.close();
            
        } catch (Exception e) {
            Logger.getLogger(Pruebas_coneccion_evnnya.class.getName()).log(Level.SEVERE, null, e);
        }
        
    }
    
    //AGREGAR ARCHIVO
    public void actualizarArchivo(Connection con, int id_usuario, String numero_expediente, String ruta_archivo,
                                int estado, String fecha, String hora, String comentario, int id_archivo){
        
        try {
            
            CallableStatement pstmt = con.prepareCall("{call dbo.ActualizarArchivos(?,?,?,?,?,"
                                                                                + "?,?,?)}");
            
            pstmt.setInt(1, id_usuario);
            pstmt.setString(2, numero_expediente);
            pstmt.setString(3, ruta_archivo);
            pstmt.setInt(4, estado);
            pstmt.setString(5, fecha);
            pstmt.setString(6, hora);
            pstmt.setString(7, comentario);
            pstmt.setInt(8, id_archivo);
            
            pstmt.execute();
            
                System.out.println("SE MODIFICO ARCHIVO CORRECTAMENTE");
            
            pstmt.close();
            
        } catch (Exception e) {
            Logger.getLogger(Pruebas_coneccion_evnnya.class.getName()).log(Level.SEVERE, null, e);
        }
        
    }
    
}
