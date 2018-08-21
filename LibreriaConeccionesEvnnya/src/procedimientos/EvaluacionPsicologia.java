/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package procedimientos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author jahir
 */
public class EvaluacionPsicologia {
    
    public void agregarEvaluacionPsicologia(Connection con, int id_psicologo, String fecha_evaluacion, String hora_evaluacion, String fecha_alta
                                           , String hora_alta, String fecha_nacimiento, String lugar_nacimiento, String nacionalidad, String sexo
                                           , String escolaridad, String religion, String estado_civil, String discapacidad, String tipo_discapacidad
                                           , String idioma, String tipo_idioma, String grupo_etnico, String restricciones_evaluacion, String motivo_evaluacion
                                           , String tecnicas_utilizadas, String tecnicas_utilizadas_otra, String material_psicopedagogico
                                           , String material_psicopedagogico_otro, int id_peticion, int id_reporte){
        
        try {
            
            CallableStatement pstmt = con.prepareCall("{call dbo.AgregarEvaluacionPsicologia(?,?,?,?,?,?,?,?,?,?,"
                                                                                          + "?,?,?,?,?,?,?,?,?,?,"
                                                                                          + "?,?,?,?,?)}");
            
            pstmt.setInt(1, id_psicologo);
            pstmt.setString(2, fecha_evaluacion);
            pstmt.setString(3, hora_evaluacion);
            pstmt.setString(4, fecha_alta);
            pstmt.setString(5, hora_alta);
            pstmt.setString(6, fecha_nacimiento);
            pstmt.setString(7, lugar_nacimiento);
            pstmt.setString(8, nacionalidad);
            pstmt.setString(9, sexo);
            pstmt.setString(10, escolaridad);
            pstmt.setString(11, religion);
            pstmt.setString(12, estado_civil);
            pstmt.setString(13, discapacidad);
            pstmt.setString(14, tipo_discapacidad);
            pstmt.setString(15, idioma);
            pstmt.setString(16, tipo_idioma);
            pstmt.setString(17, grupo_etnico);
            pstmt.setString(18, restricciones_evaluacion);
            pstmt.setString(19, motivo_evaluacion);
            pstmt.setString(20, tecnicas_utilizadas);
            pstmt.setString(21, tecnicas_utilizadas_otra);
            pstmt.setString(22, material_psicopedagogico);
            pstmt.setString(23, material_psicopedagogico_otro);
            pstmt.setInt(24, id_peticion);
            pstmt.setInt(25, id_reporte);

 
            pstmt.execute();
            
                System.out.println("SE AGREGO EVALUACION_PSICOLOGIA CORRECTAMENTE");
            
            pstmt.close();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
    }
    
    //ACTUALIZAR EVALUACION PSICOLOGIA //ACTUALIZA POR MEDIO DEL ID_EVALUACION
    public void actualizarEvaluacionPsicologia(Connection con, int id_psicologo, String fecha_evaluavion, String hora_evaluacion
                                               , String fecha_alta, String hora_alta, String fecha_nacimineto
                                               , String lugar_nacimineto, String nacionalidad, String sexo, String escolaridad
                                               , String religion, String estado_civil, String discapacidad, String tipo_discapacidad
                                               , String idioma, String tipo_idioma, String grupo_etnico, int id_direccion
                                               , String restricciones_evaluacion, String motivo_evaluacion, String tecnicas_utilizadas
                                               , String tecnicas_utilizadas_otra, String material_psicopedagogico
                                               , String material_psicopedagogico_otro, int id_peticion, int id_reporte){
        
        try {
            
            CallableStatement pstmt = con.prepareCall("{call dbo.ActualizarEvaluacionPsicologia(?,?,?,?,?,?,?,?,?,?"
                                                                                             + "?,?,?,?,?,?,?,?,?,?"
                                                                                             + "?,?,?,?,?,?)}");
            
            pstmt.setInt(1, id_psicologo);
            pstmt.setString(2, fecha_evaluavion);
            pstmt.setString(3, hora_evaluacion);
            pstmt.setString(4, fecha_alta);
            pstmt.setString(5, hora_alta);
            pstmt.setString(6, fecha_nacimineto);
            pstmt.setString(7, lugar_nacimineto);
            pstmt.setString(8, nacionalidad);
            pstmt.setString(9, sexo);
            pstmt.setString(10, escolaridad);
            pstmt.setString(11, religion);
            pstmt.setString(12, estado_civil);
            pstmt.setString(13, discapacidad);
            pstmt.setString(14, tipo_discapacidad);
            pstmt.setString(15, idioma);
            pstmt.setString(16, tipo_idioma);
            pstmt.setString(17, grupo_etnico);
            pstmt.setInt(18, id_direccion);
            pstmt.setString(19, restricciones_evaluacion);
            pstmt.setString(20, motivo_evaluacion);
            pstmt.setString(21, tecnicas_utilizadas);
            pstmt.setString(22, tecnicas_utilizadas_otra);
            pstmt.setString(23, material_psicopedagogico);
            pstmt.setString(24, material_psicopedagogico_otro);
            pstmt.setInt(25, id_peticion);
            pstmt.setInt(26, id_reporte);
            
            pstmt.execute();
            
                System.out.println("SE MODIFICO Evaluacion Psicologia CORRECTAMENTE");
            
            pstmt.close();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
    }
    
}
