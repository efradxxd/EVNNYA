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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author jahir
 */
public class PeticionesPsicologia {
    
    //VARIABLES TARER DATOS
    int id_peticion;
    String fecha_envio;
    int id_emisor;
    int id_coordinador;
    int id_receptor;
    String numero_expediente;
    String nombre_paciente;
    String apellido_paterno_paciente;
    String apellido_materno_paciente;
    int gravedad_peticion;
    String descripcion;
    int apertura_mensaje;
    String fecha_apertura;
    int id_paciente;
    String tipo_paciente;
    String estatus_peticion;
    boolean existe_peticion;
    
    //VARIABLES TRAER BANDEJA ENTRADA
    List<String> ListaIdPeticion = new ArrayList<String>();
    List<String> ListaFechaEnvio = new ArrayList<String>();
    List<String> ListaGravedad = new ArrayList<String>();
    List<String> ListaNombre = new ArrayList<String>();
    List<String> ListaIdPaciente = new ArrayList<String>();
    List<String> ListaTipoPaciente = new ArrayList<String>();
    
    List<String> ListaIdPeticionAux = new ArrayList<String>();
    List<String> ListaFechaEnvioAux = new ArrayList<String>();
    List<String> ListaGravedadAux = new ArrayList<String>();
    List<String> ListaNombreAux = new ArrayList<String>();
    List<String> ListaIdPacienteAux = new ArrayList<String>();
    List<String> ListaTipoPacienteAux = new ArrayList<String>();
    
    //AGREGAR PETICION PSICOLOGIA
    public void agregarPeticion(Connection con, String fecha_envio, int id_emisor, int id_coordinador, int id_receptor,
                                String numero_expediente, String nombre_paciente, String apellido_paterno_paciente,
                                String apellido_materno_paciente, int gravedad_peticion, String descripcion,
                                int apertura_mensaje, String fecha_apertura, int id_paciente, String tipo_paciente,
                                String estatus_peticion) {
        
        try {
            
            CallableStatement pstmt = con.prepareCall("{call dbo.AgregarPeticionesPsicologia(?,?,?,?)}");
            
            pstmt.setString(1, fecha_envio);
            pstmt.setInt(2, id_emisor);
      
            
            pstmt.execute();
            
                System.out.println("SE AGREGO PETICION A PSICOLOGIA CORRECTAMENTE");
            
            pstmt.close();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR: " + e);
        }
        
    }
    
    //TRAER DATOS PETICIONES PSICOLOGIA
    public void seleccionarPeticionesPsicologiaIdPeticion(Connection con, int id_peticion){
        
        try {
            
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("{Call dbo.SeleccionarPeticionesPsicologiaIdPeticion('"+id_peticion+"')}");
            
            if(rs.next()){
                
                setExiste_peticion(true);
                setId_peticion(rs.getInt(1));
                setFecha_envio(rs.getString(2));
                setId_emisor(rs.getInt(3));
                setId_coordinador(rs.getInt(4));
                setId_receptor(rs.getInt(5));
                setNumero_expediente(rs.getString(6));
                setNombre_paciente(rs.getString(7));
                setApellido_paterno_paciente(rs.getString(8));
                setApellido_materno_paciente(rs.getString(9));
                setGravedad_peticion(rs.getInt(10));
                setDescripcion(rs.getString(11));
                setApertura_mensaje(rs.getInt(12));
                setFecha_apertura(rs.getString(13));
                setId_paciente(rs.getInt(14));
                setTipo_paciente(rs.getString(15));
                setEstatus_peticion(rs.getString(16));
                
                
            }else{
                
                setExiste_peticion(false);
                
            }
            
            rs.close();
            stmt.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(PeticionesPsicologia.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    //ACTUALIZAR ESTATUS DE PETICION
    public void actualizarEstatusPeticion(Connection con, String estatus_peticion, int id_peticion){
        
        try {
            
            CallableStatement pstmt = con.prepareCall("{call dbo.ActualizarEstatusPeticionesPsicologia(?,?)}");
            
            pstmt.setString(1, estatus_peticion);
            pstmt.setInt(2, id_peticion);
            
            pstmt.execute();
            
                System.out.println("SE MODIFICO ESTATUS PETICION CORRECTAMENTE");
            
            pstmt.close();
            
        } catch (Exception e) {
            Logger.getLogger(PeticionesPsicologia.class.getName()).log(Level.SEVERE, null, e);
        }
        
    }
    
    //TRAER BANDEJA DE ENTRADA PSICOLOGIA
    public void seleccionarBandejaPeticionesPsi(Connection con, int id_receptor){
        
        try {
            
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("{Call dbo.SeleccionarPeticionesPsicologia('"+id_receptor+"')}");
            
            ListaIdPeticionAux.clear();
            ListaFechaEnvioAux.clear();
            ListaGravedadAux.clear();
            ListaNombreAux.clear();
            ListaIdPacienteAux.clear();
            ListaTipoPacienteAux.clear();
            
            while(rs.next()){
                
                ListaIdPeticionAux.add(String.valueOf(rs.getInt(1)));
                ListaFechaEnvioAux.add(rs.getString(2));
                ListaGravedadAux.add(String.valueOf(rs.getInt(3)));
                ListaNombreAux.add(rs.getString(4));
                ListaIdPacienteAux.add(String.valueOf(rs.getInt(5)));
                ListaTipoPacienteAux.add(rs.getString(6));
                
            }
            
            setListaIdPeticion(ListaIdPeticionAux);
            setListaFechaEnvio(ListaFechaEnvioAux);
            setListaGravedad(ListaGravedadAux);
            setListaNombre(ListaNombreAux);
            setListaIdPaciente(ListaIdPacienteAux);
            setListaTipoPaciente(ListaTipoPacienteAux);
            
            rs.close();
            stmt.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(Usuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public List<String> getListaIdPeticion() {
        return ListaIdPeticion;
    }

    public void setListaIdPeticion(List<String> ListaIdPeticion) {
        this.ListaIdPeticion = ListaIdPeticion;
    }

    public List<String> getListaFechaEnvio() {
        return ListaFechaEnvio;
    }

    public void setListaFechaEnvio(List<String> ListaFechaEnvio) {
        this.ListaFechaEnvio = ListaFechaEnvio;
    }

    public List<String> getListaGravedad() {
        return ListaGravedad;
    }

    public void setListaGravedad(List<String> ListaGravedad) {
        this.ListaGravedad = ListaGravedad;
    }

    public List<String> getListaNombre() {
        return ListaNombre;
    }

    public void setListaNombre(List<String> ListaNombre) {
        this.ListaNombre = ListaNombre;
    }

    public int getId_peticion() {
        return id_peticion;
    }

    public void setId_peticion(int id_peticion) {
        this.id_peticion = id_peticion;
    }

    public String getFecha_envio() {
        return fecha_envio;
    }

    public void setFecha_envio(String fecha_envio) {
        this.fecha_envio = fecha_envio;
    }

    public int getId_emisor() {
        return id_emisor;
    }

    public void setId_emisor(int id_emisor) {
        this.id_emisor = id_emisor;
    }

    public int getId_coordinador() {
        return id_coordinador;
    }

    public void setId_coordinador(int id_coordinador) {
        this.id_coordinador = id_coordinador;
    }

    public int getId_receptor() {
        return id_receptor;
    }

    public void setId_receptor(int id_receptor) {
        this.id_receptor = id_receptor;
    }

    public String getNumero_expediente() {
        return numero_expediente;
    }

    public void setNumero_expediente(String numero_expediente) {
        this.numero_expediente = numero_expediente;
    }

    public String getNombre_paciente() {
        return nombre_paciente;
    }

    public void setNombre_paciente(String nombre_paciente) {
        this.nombre_paciente = nombre_paciente;
    }

    public String getApellido_paterno_paciente() {
        return apellido_paterno_paciente;
    }

    public void setApellido_paterno_paciente(String apellido_paterno_paciente) {
        this.apellido_paterno_paciente = apellido_paterno_paciente;
    }

    public String getApellido_materno_paciente() {
        return apellido_materno_paciente;
    }

    public void setApellido_materno_paciente(String apellido_materno_paciente) {
        this.apellido_materno_paciente = apellido_materno_paciente;
    }

    public int getGravedad_peticion() {
        return gravedad_peticion;
    }

    public void setGravedad_peticion(int gravedad_peticion) {
        this.gravedad_peticion = gravedad_peticion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getApertura_mensaje() {
        return apertura_mensaje;
    }

    public void setApertura_mensaje(int apertura_mensaje) {
        this.apertura_mensaje = apertura_mensaje;
    }

    public String getFecha_apertura() {
        return fecha_apertura;
    }

    public void setFecha_apertura(String fecha_apertura) {
        this.fecha_apertura = fecha_apertura;
    }

    public int getId_paciente() {
        return id_paciente;
    }

    public void setId_paciente(int id_paciente) {
        this.id_paciente = id_paciente;
    }

    public String getTipo_paciente() {
        return tipo_paciente;
    }

    public void setTipo_paciente(String tipo_paciente) {
        this.tipo_paciente = tipo_paciente;
    }

    public String getEstatus_peticion() {
        return estatus_peticion;
    }

    public void setEstatus_peticion(String estatus_peticion) {
        this.estatus_peticion = estatus_peticion;
    }

    public List<String> getListaIdPeticionAux() {
        return ListaIdPeticionAux;
    }

    public void setListaIdPeticionAux(List<String> ListaIdPeticionAux) {
        this.ListaIdPeticionAux = ListaIdPeticionAux;
    }

    public List<String> getListaFechaEnvioAux() {
        return ListaFechaEnvioAux;
    }

    public void setListaFechaEnvioAux(List<String> ListaFechaEnvioAux) {
        this.ListaFechaEnvioAux = ListaFechaEnvioAux;
    }

    public List<String> getListaGravedadAux() {
        return ListaGravedadAux;
    }

    public void setListaGravedadAux(List<String> ListaGravedadAux) {
        this.ListaGravedadAux = ListaGravedadAux;
    }

    public List<String> getListaNombreAux() {
        return ListaNombreAux;
    }

    public void setListaNombreAux(List<String> ListaNombreAux) {
        this.ListaNombreAux = ListaNombreAux;
    }

    public boolean isExiste_peticion() {
        return existe_peticion;
    }

    public void setExiste_peticion(boolean existe_peticion) {
        this.existe_peticion = existe_peticion;
    }

    public List<String> getListaIdPaciente() {
        return ListaIdPaciente;
    }

    public void setListaIdPaciente(List<String> ListaIdPaciente) {
        this.ListaIdPaciente = ListaIdPaciente;
    }

    public List<String> getListaTipoPaciente() {
        return ListaTipoPaciente;
    }

    public void setListaTipoPaciente(List<String> ListaTipoPaciente) {
        this.ListaTipoPaciente = ListaTipoPaciente;
    }
    
    
    
}
