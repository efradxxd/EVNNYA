/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package procedimientos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jahir
 */
public class PeticionesTrabajoSocial_2 {
    
    //VARIABLES PARA TRAER VISITA DOMICILIARIA
    String id_peticion;
    String fecha_envio;
    String fecha_maxima_visita;
    String id_emisor;
    String id_coordinador;
    String id_receptor;
    String numero_expediente;
    String gravedad_peticion;
    String descripcion;
    String apertura_mensaje;
    String fecha_apertura;
    String id_domicilio;
    String estatus_peticion;
    String id_persona_visita;
    String tipo_persona_visita;
    String id_folio;
    String domicilio_completo;
    String delegacion_municipal;
    
    //VARIABLES REASIGNACION VISITAS TS
    List<String> ListaIdPeticionVisita = new ArrayList<String>();
    List<String> ListaIdPeticionVisitaVisita = new ArrayList<String>();
    List<String> ListaFechaPeticionVisita = new ArrayList<String>();
    List<String> ListaFechaReasignacionVisita = new ArrayList<String>();
    List<String> ListaIdActualTsVisita = new ArrayList<String>();
    List<String> ListaIdNuevoTsVisita = new ArrayList<String>();
    List<String> ListaMotivoReasignacionTsVisita = new ArrayList<String>();
    
    List<String> ListaIdPeticionVisitaAux = new ArrayList<String>();
    List<String> ListaIdPeticionVisitaVisitaAux = new ArrayList<String>();
    List<String> ListaFechaPeticionVisitaAux = new ArrayList<String>();
    List<String> ListaFechaReasignacionVisitaAux = new ArrayList<String>();
    List<String> ListaIdActualTsVisitaAux = new ArrayList<String>();
    List<String> ListaIdNuevoTsVisitaAux = new ArrayList<String>();
    List<String> ListaMotivoReasignacionTsVisitaAux = new ArrayList<String>();
    
    //SELECCIONAR PETICION TS COORDI ID
    public void seleccionarPeticionTSCoordiId(Connection con, int id_peticion){
        
        try {
            
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("{Call dbo.SeleccionarPeticionTSCoordiId("+id_peticion+")}");
            
            if(rs.next()){
                
                setId_peticion(String.valueOf(rs.getInt(1)));
                setFecha_envio(rs.getString(2));
                setFecha_maxima_visita(rs.getString(3));
                setId_emisor(String.valueOf(rs.getInt(4)));
                setId_coordinador(String.valueOf(rs.getInt(5)));
                setId_receptor(String.valueOf(rs.getInt(6)));
                setNumero_expediente(rs.getString(7));
                setGravedad_peticion(rs.getString(8));
                setDescripcion(rs.getString(9));
                setApertura_mensaje(String.valueOf(rs.getInt(10)));
                setFecha_apertura(rs.getString(11));
                setId_domicilio(String.valueOf(rs.getInt(12)));
                setEstatus_peticion(rs.getString(13));
                setId_persona_visita(String.valueOf(rs.getString(14)));
                setTipo_persona_visita(rs.getString(15));
                setId_folio(rs.getString(16));
                
                
                Direcciones direccion = new Direcciones();
                
                direccion.seleccionarDireccion(con, rs.getInt(12));
                setDomicilio_completo(direccion.getCalle()+ " " +direccion.getNumero()+ " " +direccion.getColonia()+", "+direccion.getMunicipio());
                setDelegacion_municipal(direccion.getMunicipio());
                
            }
            
            rs.close();
            stmt.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(Usuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    //SELECCIONAR REASIGNACION VISITA TS
    public void seleccionarReasignacionVisitaTS(Connection con, int id_peticion){
        
        try {
            
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("{Call dbo.SeleccionarReasignacionVisitaTS("+id_peticion+")}");
            
            ListaIdPeticionVisitaAux.clear();
            ListaIdPeticionVisitaVisitaAux.clear();
            ListaFechaPeticionVisitaAux.clear();
            ListaFechaReasignacionVisitaAux.clear();
            ListaIdActualTsVisitaAux.clear();
            ListaIdNuevoTsVisitaAux.clear();
            ListaMotivoReasignacionTsVisitaAux.clear();
            
            if(rs.next()){
                
                ListaIdPeticionVisitaAux.add(String.valueOf(rs.getInt(1)));
                ListaIdPeticionVisitaVisitaAux.add(String.valueOf(rs.getInt(2)));
                ListaFechaPeticionVisitaAux.add(rs.getString(3));
                ListaFechaReasignacionVisitaAux.add(rs.getString(4));
                ListaIdActualTsVisitaAux.add(String.valueOf(rs.getInt(5)));
                ListaIdNuevoTsVisitaAux.add(String.valueOf(rs.getInt(6)));
                ListaMotivoReasignacionTsVisitaAux.add(rs.getString(7));
                
            }
            
            setListaIdPeticionVisita(ListaIdPeticionVisitaAux);
            setListaIdPeticionVisitaVisita(ListaIdPeticionVisitaVisitaAux);
            setListaFechaPeticionVisita(ListaFechaPeticionVisitaAux);
            setListaFechaReasignacionVisita(ListaFechaReasignacionVisitaAux);
            setListaIdActualTsVisita(ListaIdActualTsVisitaAux);
            setListaIdNuevoTsVisita(ListaIdNuevoTsVisitaAux);
            setListaMotivoReasignacionTsVisita(ListaMotivoReasignacionTsVisitaAux);
            
            rs.close();
            stmt.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(Usuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public String getId_peticion() {
        return id_peticion;
    }

    public void setId_peticion(String id_peticion) {
        this.id_peticion = id_peticion;
    }

    public String getFecha_envio() {
        return fecha_envio;
    }

    public void setFecha_envio(String fecha_envio) {
        this.fecha_envio = fecha_envio;
    }

    public String getFecha_maxima_visita() {
        return fecha_maxima_visita;
    }

    public void setFecha_maxima_visita(String fecha_maxima_visita) {
        this.fecha_maxima_visita = fecha_maxima_visita;
    }

    public String getId_emisor() {
        return id_emisor;
    }

    public void setId_emisor(String id_emisor) {
        this.id_emisor = id_emisor;
    }

    public String getId_coordinador() {
        return id_coordinador;
    }

    public void setId_coordinador(String id_coordinador) {
        this.id_coordinador = id_coordinador;
    }

    public String getId_receptor() {
        return id_receptor;
    }

    public void setId_receptor(String id_receptor) {
        this.id_receptor = id_receptor;
    }

    public String getNumero_expediente() {
        return numero_expediente;
    }

    public void setNumero_expediente(String numero_expediente) {
        this.numero_expediente = numero_expediente;
    }

    public String getGravedad_peticion() {
        return gravedad_peticion;
    }

    public void setGravedad_peticion(String gravedad_peticion) {
        this.gravedad_peticion = gravedad_peticion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getApertura_mensaje() {
        return apertura_mensaje;
    }

    public void setApertura_mensaje(String apertura_mensaje) {
        this.apertura_mensaje = apertura_mensaje;
    }

    public String getFecha_apertura() {
        return fecha_apertura;
    }

    public void setFecha_apertura(String fecha_apertura) {
        this.fecha_apertura = fecha_apertura;
    }

    public String getId_domicilio() {
        return id_domicilio;
    }

    public void setId_domicilio(String id_domicilio) {
        this.id_domicilio = id_domicilio;
    }

    public String getEstatus_peticion() {
        return estatus_peticion;
    }

    public void setEstatus_peticion(String estatus_peticion) {
        this.estatus_peticion = estatus_peticion;
    }

    public String getId_persona_visita() {
        return id_persona_visita;
    }

    public void setId_persona_visita(String id_persona_visita) {
        this.id_persona_visita = id_persona_visita;
    }

    public String getTipo_persona_visita() {
        return tipo_persona_visita;
    }

    public void setTipo_persona_visita(String tipo_persona_visita) {
        this.tipo_persona_visita = tipo_persona_visita;
    }

    public String getId_folio() {
        return id_folio;
    }

    public void setId_folio(String id_folio) {
        this.id_folio = id_folio;
    }

    public String getDomicilio_completo() {
        return domicilio_completo;
    }

    public void setDomicilio_completo(String domicilio_completo) {
        this.domicilio_completo = domicilio_completo;
    }

    public String getDelegacion_municipal() {
        return delegacion_municipal;
    }

    public void setDelegacion_municipal(String delegacion_municipal) {
        this.delegacion_municipal = delegacion_municipal;
    }

    public List<String> getListaIdPeticionVisita() {
        return ListaIdPeticionVisita;
    }

    public void setListaIdPeticionVisita(List<String> ListaIdPeticionVisita) {
        this.ListaIdPeticionVisita = ListaIdPeticionVisita;
    }

    public List<String> getListaIdPeticionVisitaVisita() {
        return ListaIdPeticionVisitaVisita;
    }

    public void setListaIdPeticionVisitaVisita(List<String> ListaIdPeticionVisitaVisita) {
        this.ListaIdPeticionVisitaVisita = ListaIdPeticionVisitaVisita;
    }

    public List<String> getListaFechaPeticionVisita() {
        return ListaFechaPeticionVisita;
    }

    public void setListaFechaPeticionVisita(List<String> ListaFechaPeticionVisita) {
        this.ListaFechaPeticionVisita = ListaFechaPeticionVisita;
    }

    public List<String> getListaFechaReasignacionVisita() {
        return ListaFechaReasignacionVisita;
    }

    public void setListaFechaReasignacionVisita(List<String> ListaFechaReasignacionVisita) {
        this.ListaFechaReasignacionVisita = ListaFechaReasignacionVisita;
    }

    public List<String> getListaIdActualTsVisita() {
        return ListaIdActualTsVisita;
    }

    public void setListaIdActualTsVisita(List<String> ListaIdActualTsVisita) {
        this.ListaIdActualTsVisita = ListaIdActualTsVisita;
    }

    public List<String> getListaIdNuevoTsVisita() {
        return ListaIdNuevoTsVisita;
    }

    public void setListaIdNuevoTsVisita(List<String> ListaIdNuevoTsVisita) {
        this.ListaIdNuevoTsVisita = ListaIdNuevoTsVisita;
    }

    public List<String> getListaMotivoReasignacionTsVisita() {
        return ListaMotivoReasignacionTsVisita;
    }

    public void setListaMotivoReasignacionTsVisita(List<String> ListaMotivoReasignacionTsVisita) {
        this.ListaMotivoReasignacionTsVisita = ListaMotivoReasignacionTsVisita;
    }
    
    
    
}
