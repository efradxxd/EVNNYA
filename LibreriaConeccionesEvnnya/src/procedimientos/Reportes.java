/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package procedimientos;

import conecciones.Pruebas_coneccion_evnnya;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author jahir
 */
public class Reportes {
    
    int id_reporte;
    String numero_expediente_pertenece;
    int tipo_documento;
    String fecha_creacion;
    String hora_creacion;
    int id_usuario_recibio;
    String numero_oficio;
    String fecha_oficio;
    String quien_envia_oficio;
    String medio_reporte;
    int anonimato;
    int id_custodia;
    String resenia_situacion;
    String observacion_situacion;
    String lugar_receptor;
    String etapa_actual;
    boolean existe_reporte;
    
    
    //AGREGAR REPORTE
    public void agregarReporte(Connection con, String numero_expedinte_pertenece, int tipo_documento,
                                String fecha_creacion, String hora_creacion, int id_usuario_recibio,
                                String numero_oficio, String fecha_oficio, String quien_envia_oficio,
                                String medio_reporte, int anonimato, int id_custodia, String resenia_situacion,
                                String observacion_situacion, String lugar_receptor, String etapa_actual){
        
        try {
            
            CallableStatement pstmt = con.prepareCall("{call dbo.AgregarReporte(?,?,?,?,?,"
                                                                                + "?,?,?,?,?,"
                                                                                + "?,?,?,?,?)}");
            
            pstmt.setString(1, numero_expedinte_pertenece);
            pstmt.setInt(2, tipo_documento);
            pstmt.setString(3, fecha_creacion);
            pstmt.setString(4, hora_creacion);
            pstmt.setInt(5, id_usuario_recibio);
            pstmt.setString(6, numero_oficio);
            pstmt.setString(7, fecha_oficio);
            pstmt.setString(8, quien_envia_oficio);
            pstmt.setString(9, medio_reporte);
            pstmt.setInt(10, anonimato);
            pstmt.setInt(11, id_custodia);
            pstmt.setString(12, resenia_situacion);
            pstmt.setString(13, observacion_situacion);
            pstmt.setString(14, lugar_receptor);
            pstmt.setString(15, etapa_actual);        
            
            pstmt.execute();
            
                System.out.println("SE AGREGO REPORTE CORRECTAMENTE");
            
            pstmt.close();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
    }
    
    //SELECCIONAR ULTIMO REPORTE
    public int seleccionarUltimoReporte(Connection con){
        
        int id_reporte = 0;
        
        try {
            
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("{Call dbo.SeleccionarUltimoReporte()}");
            
            if(rs.next()){
                
                id_reporte = (rs.getInt(1));
                
            }
            
            rs.close();
            stmt.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(Usuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return id_reporte;
    }
    
    public void seleccionarReportes(Connection con, int reporte){
        
        try {
            
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("{Call dbo.SeleccionarReporte("+reporte+")}");
            
            if(rs.next()){
                
                setExiste_reporte(true);
                setId_reporte(rs.getInt(1));
                setNumero_expediente_pertenece(rs.getString(2));
                setTipo_documento(rs.getInt(3));
                setFecha_creacion(rs.getString(4));
                setHora_creacion(rs.getString(5));
                setId_usuario_recibio(rs.getInt(6));
                setNumero_oficio(rs.getString(7));
                setFecha_oficio(rs.getString(8));
                setQuien_envia_oficio(rs.getString(9));
                setMedio_reporte(rs.getString(10));
                setAnonimato(rs.getInt(11));
                setId_custodia(rs.getInt(12));
                setResenia_situacion(rs.getString(13));
                setObservacion_situacion(rs.getString(14));
                setLugar_receptor(rs.getString(15));
                setEtapa_actual(rs.getString(16));
                
            }else{
                
                setExiste_reporte(false);
                
            }
            
            rs.close();
            stmt.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(Reportes.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    public int getId_reporte() {
        return id_reporte;
    }

    public void setId_reporte(int id_reporte) {
        this.id_reporte = id_reporte;
    }

    public String getNumero_expediente_pertenece() {
        return numero_expediente_pertenece;
    }

    public void setNumero_expediente_pertenece(String numero_expediente_pertenece) {
        this.numero_expediente_pertenece = numero_expediente_pertenece;
    }

    public int getTipo_documento() {
        return tipo_documento;
    }

    public void setTipo_documento(int tipo_documento) {
        this.tipo_documento = tipo_documento;
    }

    public String getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(String fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public String getHora_creacion() {
        return hora_creacion;
    }

    public void setHora_creacion(String hora_creacion) {
        this.hora_creacion = hora_creacion;
    }

    
    public int getId_usuario_recibio() {
        return id_usuario_recibio;
    }

    public void setId_usuario_recibio(int id_usuario_recibio) {
        this.id_usuario_recibio = id_usuario_recibio;
    }

    public String getNumero_oficio() {
        return numero_oficio;
    }

    public void setNumero_oficio(String numero_oficio) {
        this.numero_oficio = numero_oficio;
    }

    public String getFecha_oficio() {
        return fecha_oficio;
    }

    public void setFecha_oficio(String fecha_oficio) {
        this.fecha_oficio = fecha_oficio;
    }

    public String getQuien_envia_oficio() {
        return quien_envia_oficio;
    }

    public void setQuien_envia_oficio(String quien_envia_oficio) {
        this.quien_envia_oficio = quien_envia_oficio;
    }

    public String getMedio_reporte() {
        return medio_reporte;
    }

    public void setMedio_reporte(String medio_reporte) {
        this.medio_reporte = medio_reporte;
    }

    public int getAnonimato() {
        return anonimato;
    }

    public void setAnonimato(int anonimato) {
        this.anonimato = anonimato;
    }

    public int getId_custodia() {
        return id_custodia;
    }

    public void setId_custodia(int id_custodia) {
        this.id_custodia = id_custodia;
    }

    public String getResenia_situacion() {
        return resenia_situacion;
    }

    public void setResenia_situacion(String resenia_situacion) {
        this.resenia_situacion = resenia_situacion;
    }

    public String getObservacion_situacion() {
        return observacion_situacion;
    }

    public void setObservacion_situacion(String observacion_situacion) {
        this.observacion_situacion = observacion_situacion;
    }

    public String getLugar_receptor() {
        return lugar_receptor;
    }

    public void setLugar_receptor(String lugar_receptor) {
        this.lugar_receptor = lugar_receptor;
    }

    public String getEtapa_actual() {
        return etapa_actual;
    }

    public void setEtapa_actual(String etapa_actual) {
        this.etapa_actual = etapa_actual;
    }

    public boolean isExiste_reporte() {
        return existe_reporte;
    }

    public void setExiste_reporte(boolean existe_reporte) {
        this.existe_reporte = existe_reporte;
    }
    
}
