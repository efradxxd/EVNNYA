/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package procedimientos;

import java.sql.CallableStatement;
import java.sql.Connection;
import javax.swing.JOptionPane;

/**
 *
 * @author Alex
 */
public class PersonaPresentesEvaluacion {

    int id_evaluacion;
    String nombres;
    String apellido_paterno;
    String apellido_materno;
    String parentesco;

    //AGREGAR PERSONA PRESENTE EVALUACION
    public void agregarPersonasPresentesEvaluacion(Connection con, int id_evaluacion, String nombres, String apellido_paterno,
            String apellido_materno, String parentesco) {

        try {

            CallableStatement pstmt = con.prepareCall("{call dbo.AgregarPersonasPresentesEvaluacion(?,?,?,?,?)}");

           
            pstmt.setInt(1, id_evaluacion);
            pstmt.setString(2, nombres);
            pstmt.setString(3, apellido_paterno);
            pstmt.setString(4, apellido_materno);
            pstmt.setString(5, parentesco);

            pstmt.execute();

            System.out.println("SE AGREGO PERSONA CORRECTAMENTE");

            pstmt.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    public int getId_evaluacion() {
        return id_evaluacion;
    }

    public void setId_evaluacion(int id_evaluacion) {
        this.id_evaluacion = id_evaluacion;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellido_paterno() {
        return apellido_paterno;
    }

    public void setApellido_paterno(String apellido_paterno) {
        this.apellido_paterno = apellido_paterno;
    }

    public String getApellido_materno() {
        return apellido_materno;
    }

    public void setApellido_materno(String apellido_materno) {
        this.apellido_materno = apellido_materno;
    }

    public String getParentesco() {
        return parentesco;
    }

    public void setParentesco(String parentesco) {
        this.parentesco = parentesco;
    }

}
