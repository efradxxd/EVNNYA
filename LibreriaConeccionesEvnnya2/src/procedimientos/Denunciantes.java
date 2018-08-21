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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author jahir
 */
public class Denunciantes {
    
    //VARIABLES TRAER DENUNCIANTE POR ID REPORTE
    String id_denunciante, tipo_denunciante, nombres, apellido_paterno, apellido_materno, edad, sexo,
            escolaridad, relacion_victima, id_direccion, id_reporte;
    
    //boolean existe_reporte;
    
    //AGREGAR DENUNCIANTE
    public void agregarDenunciante(Connection con, int tipo_denunciante, String nombres, String apellido_paterno,
                                String apellido_materno, int edad, String sexo, String escolaridad, String relacion_victima,int id_reporte){
        
        try {
            
            CallableStatement pstmt = con.prepareCall("{call dbo.AgregarDenunciante(?,?,?,?,?,"
                                                                                + "?,?,?,?)}");
            
            pstmt.setInt(1, tipo_denunciante);
            pstmt.setString(2, nombres);
            pstmt.setString(3, apellido_paterno);
            pstmt.setString(4, apellido_materno);
            pstmt.setInt(5, edad);
            pstmt.setString(6, sexo);
            pstmt.setString(7, escolaridad);
            pstmt.setString(8, relacion_victima);
            pstmt.setInt(9, id_reporte);
            
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
    
    //SELECCIONAR DENUNCIANTE POR ID REPORTE
    public void seleccionarDenuncianteIdReporte(Connection con, int id_reporte){
        
        try {
            
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("{Call dbo.SeleccionarDenuncianteIdReporte('"+id_reporte+"')}");
            
            if(rs.next()){
                
                
                setId_denunciante(String.valueOf(1));
                setTipo_denunciante(String.valueOf(2));
                setNombres(rs.getString(3));
                setApellido_paterno(rs.getString(4));
                setApellido_materno(rs.getString(5));
                setEdad(String.valueOf(rs.getInt(6)));
                setSexo(rs.getString(7));
                setEscolaridad(rs.getString(8));
                setRelacion_victima(rs.getString(9));
                setId_direccion(String.valueOf(rs.getInt(10)));
                setId_reporte(String.valueOf(rs.getInt(11)));
                
            }else{
                
                JOptionPane.showMessageDialog(null, "NO EXISTE REPORTE CON ESE ID");
                
            }
            
            rs.close();
            stmt.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        
    }

    public String getId_denunciante() {
        return id_denunciante;
    }

    public void setId_denunciante(String id_denunciante) {
        this.id_denunciante = id_denunciante;
    }

    public String getTipo_denunciante() {
        return tipo_denunciante;
    }

    public void setTipo_denunciante(String tipo_denunciante) {
        this.tipo_denunciante = tipo_denunciante;
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

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEscolaridad() {
        return escolaridad;
    }

    public void setEscolaridad(String escolaridad) {
        this.escolaridad = escolaridad;
    }

    public String getRelacion_victima() {
        return relacion_victima;
    }

    public void setRelacion_victima(String relacion_victima) {
        this.relacion_victima = relacion_victima;
    }

    public String getId_direccion() {
        return id_direccion;
    }

    public void setId_direccion(String id_direccion) {
        this.id_direccion = id_direccion;
    }

    public String getId_reporte() {
        return id_reporte;
    }

    public void setId_reporte(String id_reporte) {
        this.id_reporte = id_reporte;
    }

    private void isExiste_reporte(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
