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
public class Custodia {
    
    //VARIABLES SELECCIONAR CUSTIDIA
    String id_custodia;
    String nombres;
    String apellido_paterno;
    String apellido_materno;
    String edad;
    String sexo;
    String escolaridad;
    String relacion_victima;
    String id_direccion;
    String fecha_nacimiento;
    String estado_civil;
    String idioma_dialecto;
    String grupo_etnico;
    String religion;
    String discapacidad;
    String cual_discapacidad;
    
    //AGREGAR CUSTODIA
    public void agregarCustodia(Connection con, String nombres, String apellido_paterno, String apellido_materno,
                                int edad, String sexo, String escolaridad, String relacion_victima, String fecha_nacimiento,
                                String estado_civil, String idioma_dialecto, String grupo_etnico, String religion,
                                int discapacidad, String cual_discapacidad){
        
        try {
            
            CallableStatement pstmt = con.prepareCall("{call dbo.AgregarCustodia(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
            
            pstmt.setString(1, nombres);
            pstmt.setString(2, apellido_paterno);
            pstmt.setString(3, apellido_materno);
            pstmt.setInt(4, edad);
            pstmt.setString(5, sexo);
            pstmt.setString(6, escolaridad);
            pstmt.setString(7, relacion_victima);
            pstmt.setString(8, fecha_nacimiento);
            pstmt.setString(9, estado_civil);
            pstmt.setString(10, idioma_dialecto);
            pstmt.setString(11, grupo_etnico);
            pstmt.setString(12, religion);
            pstmt.setInt(13, discapacidad);
            pstmt.setString(14, cual_discapacidad);
            
            pstmt.execute();
            
                System.out.println("SE AGREGO CUSTODIA CORRECTAMENTE");
            
            pstmt.close();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
    }
    
    //ACTUALIZAR CUSTODIA //ACTUALIZA POR MEDIO DEL ID_CUSTODIA
    public void actualizarCustodia(Connection con, String nombres, String apellido_paterno, String apellido_materno,
                                int edad, String sexo, String escolaridad, String relacion_victima, int id_custodia){
        
        try {
            
            CallableStatement pstmt = con.prepareCall("{call dbo.ActualizarCustodia(?,?,?,?,?,"
                                                                                + "?,?,?)}");
            
            pstmt.setString(1, nombres);
            pstmt.setString(2, apellido_paterno);
            pstmt.setString(3, apellido_materno);
            pstmt.setInt(4, edad);
            pstmt.setString(5, sexo);
            pstmt.setString(6, escolaridad);
            pstmt.setString(7, relacion_victima);
            pstmt.setInt(8, id_custodia);
            
            pstmt.execute();
            
                System.out.println("SE MODIFICO CUSTODIA CORRECTAMENTE");
            
            pstmt.close();
            
        } catch (Exception e) {
            Logger.getLogger(Pruebas_coneccion_evnnya.class.getName()).log(Level.SEVERE, null, e);
        }
        
    }
    
    //SELECCIONAR CUSTODIA //POR MEDIO DEL ID
    public void seleccionarCustodia(Connection con, int id_custodia){
        
        try {
            
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("{Call dbo.SeleccionarCustodia("+id_custodia+")}");
            
            if(rs.next()){
                
                setId_custodia(String.valueOf(rs.getInt(1)));
                setNombres(rs.getString(2));
                setApellido_paterno(rs.getString(3));
                setApellido_materno(rs.getString(4));
                setEdad(String.valueOf(rs.getInt(5)));
                setSexo(rs.getString(6));
                setEscolaridad(rs.getString(7));
                setRelacion_victima(rs.getString(8));
                setId_direccion(String.valueOf(rs.getInt(9)));
                setFecha_nacimiento(rs.getString(10));
                setEstado_civil(rs.getString(11));
                setIdioma_dialecto(rs.getString(12));
                setGrupo_etnico(rs.getString(13));
                setReligion(rs.getString(14));
                setDiscapacidad(String.valueOf(rs.getInt(15)));
                setCual_discapacidad(rs.getString(16));
                
            }
            
            rs.close();
            stmt.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(Usuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    //SELECCIONAR ULTIMO ID CUSTODIA
    public int seleccionarUltimoCustodia(Connection con){
        
        int id_custodia = 0;
        
        try {
            
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("{Call dbo.SeleccionarUltimoCustodia()}");
            
            if(rs.next()){
                
                id_custodia = (rs.getInt(1));
                
            }
            
            rs.close();
            stmt.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(Usuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return id_custodia;
    }

    public String getId_custodia() {
        return id_custodia;
    }

    public void setId_custodia(String id_custodia) {
        this.id_custodia = id_custodia;
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

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getEstado_civil() {
        return estado_civil;
    }

    public void setEstado_civil(String estado_civil) {
        this.estado_civil = estado_civil;
    }

    public String getIdioma_dialecto() {
        return idioma_dialecto;
    }

    public void setIdioma_dialecto(String idioma_dialecto) {
        this.idioma_dialecto = idioma_dialecto;
    }

    public String getGrupo_etnico() {
        return grupo_etnico;
    }

    public void setGrupo_etnico(String grupo_etnico) {
        this.grupo_etnico = grupo_etnico;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public String getDiscapacidad() {
        return discapacidad;
    }

    public void setDiscapacidad(String discapacidad) {
        this.discapacidad = discapacidad;
    }

    public String getCual_discapacidad() {
        return cual_discapacidad;
    }

    public void setCual_discapacidad(String cual_discapacidad) {
        this.cual_discapacidad = cual_discapacidad;
    }
    
    
    
}
