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

/**
 *
 * @author jahir
 */
public class Expedientes {

    //VARIABLES PARA TRAER EXPEDIENTE POR DIRECCION
    List<String> ListaIdDireccion = new ArrayList<String>();
    List<String> ListaDireccionCompleta = new ArrayList<String>();

    List<String> ListaNumeroExpedienteV = new ArrayList<String>();
    List<String> ListaNombreCompletoV = new ArrayList<String>();
    
    List<String> ListaFechaCreacion = new ArrayList<String>();
    List<String> ListaNumeroExpediente = new ArrayList<String>();

    List<String> ListaIdDireccionAux = new ArrayList<String>();
    List<String> ListaDireccionCompletaAux = new ArrayList<String>();

    List<String> ListaNumeroExpedienteVAux = new ArrayList<String>();
    List<String> ListaNombreCompletoVAux = new ArrayList<String>();
    
    List<String> ListaFechaCreacionAux = new ArrayList<String>();
    List<String> ListaNumeroExpedienteAux = new ArrayList<String>();
    
    //VARIABLES PARA TRAER EXPEDIENTE POR NOMBRE VICTIMA
    List<String> ListaNombreVictima = new ArrayList<String>();
    List<String> ListaNumeroExpedienteVictima = new ArrayList<String>();
    List<String> ListaIdDireccionVictima = new ArrayList<String>();
    
    //VARIABLES REASIGNAR AJ
    List<String> ListaIdReasignacionReasignar = new ArrayList<String>();
    List<String> ListaIdReporteReasignar = new ArrayList<String>();
    List<String> ListaNumeroExpedientenReasignar = new ArrayList<String>();
    List<String> ListaFechaPeticionReasignar = new ArrayList<String>();
    List<String> ListaIdAsesorAntiguoReasignar = new ArrayList<String>();
    List<String> ListaIdAsesorNuevoReasignar = new ArrayList<String>();
    List<String> ListaIdCoordinadorReasignoReasignar = new ArrayList<String>();
    List<String> ListaFechaReasignacionReasignar = new ArrayList<String>();
    List<String> ListaMotivoReasignacionReasignar = new ArrayList<String>();
    
    List<String> ListaIdReasignacionReasignarAux = new ArrayList<String>();
    List<String> ListaIdReporteReasignarAux = new ArrayList<String>();
    List<String> ListaNumeroExpedientenReasignarAux = new ArrayList<String>();
    List<String> ListaFechaPeticionReasignarAux = new ArrayList<String>();
    List<String> ListaIdAsesorAntiguoReasignarAux = new ArrayList<String>();
    List<String> ListaIdAsesorNuevoReasignarAux = new ArrayList<String>();
    List<String> ListaIdCoordinadorReasignoReasignarAux = new ArrayList<String>();
    List<String> ListaFechaReasignacionReasignarAux = new ArrayList<String>();
    List<String> ListaMotivoReasignacionReasignarAux = new ArrayList<String>();
    
    //VARIABLES SELECCIONAR EXPEDIENTE POR EXPEDIENTE
    List<String> ListaNumeroExpedienteExp = new ArrayList<String>();
    List<String> ListaFechaCreacionExp = new ArrayList<String>();
    List<String> ListaReseniaSituacionExp = new ArrayList<String>();
    
    List<String> ListaNumeroExpedienteExpAux = new ArrayList<String>();
    List<String> ListaFechaCreacionExpAux = new ArrayList<String>();
    List<String> ListaReseniaSituacionExpAux = new ArrayList<String>();
    
    //VARIABLES TRAER DATOS DE EXPEDIENTE POR EXPEDIENTE
    String numero_expediente;
    String tipo_documento;
    String fecha_creacion;
    String hora_creacion;
    String id_usuario_recibio;
    String numero_oficion;
    String fecha_oficio;
    String quien_envia_oficio;
    String medio_reporte;
    String anonimato;
    String id_custodia;
    String resenia_situacion;
    String observacion_situacion;
    String lugar_receptor;
    String id_usuario_asesor;
    String fecha_asignacion_asesor;
    String etapa_actual;
            
            
    //AGREGAR EXPEDIENTE
    public void agregarExpediente(Connection con, String numero_expedinte, int tipo_documento, String fecha_creacion,
            String hora_creacion, int id_usuario_recibio, String numero_oficio,
            String fecha_oficio, String quien_envia_oficio, String medio_reporte,
            int anonimato, int id_custodia, String resenia_situacion,
            String observacion_situacion, String lugar_receptor, int id_usuario_asesor,
            String fecha_asignacion_asesor, String etapa_actual) {

        try {

            CallableStatement pstmt = con.prepareCall("{call dbo.AgregarExpediente(?,?,?,?,?,"
                    + "?,?,?,?,?,"
                    + "?,?,?,?,?,"
                    + "?,?)}");

            pstmt.setString(1, numero_expedinte);
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
            pstmt.setInt(15, id_usuario_asesor);
            pstmt.setString(16, fecha_asignacion_asesor);
            pstmt.setString(17, etapa_actual);

            pstmt.execute();

            System.out.println("SE AGREGO EXPEDIENTE CORRECTAMENTE");

            pstmt.close();

        } catch (Exception e) {
            Logger.getLogger(Pruebas_coneccion_evnnya.class.getName()).log(Level.SEVERE, null, e);
        }

    }

    //TRAER LISTA DE EXPEDIENTES POR DIRECCION
    public void seleccionarExpedienteSubDireccion(Connection con, String calle, String numero, String colonia, String municipio) {

        try {

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("{Call dbo.SeleccionarDireccionExpedientes('" + calle + "','" + numero + "','" + colonia + "','" + municipio + "')}");

            ListaIdDireccionAux.clear();
            ListaDireccionCompletaAux.clear();

            ListaNumeroExpedienteVAux.clear();
            ListaNombreCompletoVAux.clear();
            
            ListaFechaCreacionAux.clear();
            ListaNumeroExpedienteAux.clear();

            while (rs.next()) {

                ListaIdDireccionAux.add(String.valueOf(rs.getInt(1)));

                String direccion_completa = rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4);

                seleccionarVictimaExpediente(con, rs.getInt(1), direccion_completa);

            }
            
            for(int i = 0; i < ListaNumeroExpedienteVAux.size(); i++){
                
                seleccionarListaExpedientesDireccion(con, ListaNumeroExpedienteVAux.get(i));
                
            }

            setListaIdDireccion(ListaIdDireccionAux);
            setListaDireccionCompleta(ListaDireccionCompletaAux);

            setListaNumeroExpedienteV(ListaNumeroExpedienteVAux);
            setListaNombreCompletoV(ListaNombreCompletoVAux);
            
            setListaFechaCreacion(ListaFechaCreacionAux);
            setListaNumeroExpediente(ListaNumeroExpedienteAux);

            rs.close();
            stmt.close();

        } catch (SQLException ex) {
            Logger.getLogger(Usuarios.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    //TRAER NOMBRES DE VICTIMAS CON EXPEDIENTE
    private void seleccionarVictimaExpediente(Connection con, int id_direccion, String direccion_completa) {

        try {

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("{Call dbo.SeleccionarVictimaExpedientes('" + id_direccion + "')}");

            if (rs.next()) {

                if (!rs.getString(1).equals("")) {
                    ListaNumeroExpedienteVAux.add(rs.getString(1));
                    ListaNombreCompletoVAux.add(rs.getString(2));

                    ListaDireccionCompletaAux.add(direccion_completa);
                }

            }

            rs.close();
            stmt.close();

        } catch (SQLException ex) {
            Logger.getLogger(Usuarios.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    //SELECCIONAR LISTA EXPEDIENTES
    private void seleccionarListaExpedientesDireccion(Connection con, String numero_expediente) {

        try {

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("{Call dbo.SeleccionarExpedientesDireccion('" + numero_expediente + "')}");

            if (rs.next()) {

                    ListaFechaCreacionAux.add(rs.getString(1));
                    ListaNumeroExpedienteAux.add(rs.getString(2));

            }

            rs.close();
            stmt.close();

        } catch (SQLException ex) {
            Logger.getLogger(Usuarios.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    //SELECCIONAR EXPEDIENTE POR EL NOMBRE DE LA VICTIMA
    public void seleccionarExpedienteSubVictima(Connection con, String nombre, String apellido_paterno, String apellido_materno){
        
        
        
    }
    
    //SELECCIONAR LISTA EXPEDIENTES REASIGNAR AJ
    public void seleccionarListaExpedientesReasignarAJ(Connection con) {

        try {

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("{Call dbo.SeleccionarExpedientesReasignarAJ()}");
            
            ListaIdReasignacionReasignarAux.clear();
            ListaIdReporteReasignarAux.clear();
            ListaNumeroExpedientenReasignarAux.clear();
            ListaFechaPeticionReasignarAux.clear();
            ListaIdAsesorAntiguoReasignarAux.clear();
            ListaIdAsesorNuevoReasignarAux.clear();
            ListaIdCoordinadorReasignoReasignarAux.clear();
            ListaFechaReasignacionReasignarAux.clear();
            ListaMotivoReasignacionReasignarAux.clear();

            while (rs.next()) {

                    ListaIdReasignacionReasignarAux.add(String.valueOf(rs.getInt(1)));
                    ListaIdReporteReasignarAux.add(String.valueOf(rs.getInt(2)));
                    ListaNumeroExpedientenReasignarAux.add(rs.getString(3));
                    ListaFechaPeticionReasignarAux.add(rs.getString(4));
                    ListaIdAsesorAntiguoReasignarAux.add(String.valueOf(rs.getInt(5)));
                    ListaIdAsesorNuevoReasignarAux.add(String.valueOf(rs.getInt(6)));
                    ListaIdCoordinadorReasignoReasignarAux.add(String.valueOf(rs.getInt(7)));
                    ListaFechaReasignacionReasignarAux.add(rs.getString(8));
                    ListaMotivoReasignacionReasignarAux.add(rs.getString(9));
                    

            }
            
            setListaIdReasignacionReasignar(ListaIdReasignacionReasignarAux);
            setListaIdReporteReasignar(ListaIdReporteReasignarAux);
            setListaNumeroExpedientenReasignar(ListaNumeroExpedientenReasignarAux);
            setListaFechaPeticionReasignar(ListaFechaPeticionReasignarAux);
            setListaIdAsesorAntiguoReasignar(ListaIdAsesorAntiguoReasignarAux);
            setListaIdAsesorNuevoReasignar(ListaIdAsesorNuevoReasignarAux);
            setListaIdCoordinadorReasignoReasignar(ListaIdCoordinadorReasignoReasignarAux);
            setListaFechaReasignacionReasignar(ListaFechaReasignacionReasignarAux);
            setListaMotivoReasignacionReasignar(ListaMotivoReasignacionReasignarAux);

            rs.close();
            stmt.close();

        } catch (SQLException ex) {
            Logger.getLogger(Usuarios.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    //SELECCIONAR LISTA EXPEDIENTES POR EXPEDIENTE
    public void seleccionarExpedientePorExpediente(Connection con, String numero_expediente) {

        try {

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("{Call dbo.SeleccionarExpedientePorExpediente('"+numero_expediente+"')}");
            
            ListaNumeroExpedienteExpAux.clear();
            ListaFechaCreacionExpAux.clear();
            ListaReseniaSituacionExpAux.clear();

            while (rs.next()) {

                   ListaNumeroExpedienteExpAux.add(rs.getString(1));
                   ListaFechaCreacionExpAux.add(rs.getString(2));
                   ListaReseniaSituacionExpAux.add(rs.getString(3));

            }
            
            setListaNumeroExpedienteExp(ListaNumeroExpedienteExpAux);
            setListaFechaCreacionExp(ListaFechaCreacionExpAux);
            setListaReseniaSituacionExp(ListaReseniaSituacionExpAux);

            rs.close();
            stmt.close();

        } catch (SQLException ex) {
            Logger.getLogger(Usuarios.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    //SELECCIONAR EXPEDIENTE UNICO
    public void seleccionarExpedienteUnico(Connection con, String numero_expediente) {

        try {

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("{Call dbo.SeleccionarExpedienteUnico('"+numero_expediente+"')}");
            
            

            if(rs.next()) {

                   setNumero_expediente(rs.getString(1));
                   setTipo_documento(rs.getString(2));
                   setFecha_creacion(rs.getString(3));
                   setHora_creacion(rs.getString(4));
                   setId_usuario_recibio(String.valueOf(rs.getInt(5)));
                   setNumero_oficion(String.valueOf(rs.getInt(6)));
                   setFecha_oficio(rs.getString(7));
                   setQuien_envia_oficio(rs.getString(8));
                   setMedio_reporte(rs.getString(9));
                   setAnonimato(String.valueOf(rs.getInt(10)));
                   setId_custodia(String.valueOf(rs.getInt(11)));
                   setResenia_situacion(rs.getString(12));
                   setObservacion_situacion(rs.getString(13));
                   setLugar_receptor(rs.getString(14));
                   setId_usuario_asesor(String.valueOf(rs.getInt(15)));
                   setFecha_asignacion_asesor(rs.getString(16));
                   setEtapa_actual(rs.getString(17));

            }

            rs.close();
            stmt.close();

        } catch (SQLException ex) {
            Logger.getLogger(Usuarios.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public List<String> getListaIdDireccion() {
        return ListaIdDireccion;
    }

    public void setListaIdDireccion(List<String> ListaIdDireccion) {
        this.ListaIdDireccion = ListaIdDireccion;
    }

    public List<String> getListaDireccionCompleta() {
        return ListaDireccionCompleta;
    }

    public void setListaDireccionCompleta(List<String> ListaDireccionCompleta) {
        this.ListaDireccionCompleta = ListaDireccionCompleta;
    }

    public List<String> getListaNumeroExpedienteV() {
        return ListaNumeroExpedienteV;
    }

    public void setListaNumeroExpedienteV(List<String> ListaNumeroExpedienteV) {
        this.ListaNumeroExpedienteV = ListaNumeroExpedienteV;
    }

    public List<String> getListaNombreCompletoV() {
        return ListaNombreCompletoV;
    }

    public void setListaNombreCompletoV(List<String> ListaNombreCompletoV) {
        this.ListaNombreCompletoV = ListaNombreCompletoV;
    }

    public List<String> getListaFechaCreacion() {
        return ListaFechaCreacion;
    }

    public void setListaFechaCreacion(List<String> ListaFechaCreacion) {
        this.ListaFechaCreacion = ListaFechaCreacion;
    }

    public List<String> getListaNumeroExpediente() {
        return ListaNumeroExpediente;
    }

    public void setListaNumeroExpediente(List<String> ListaNumeroExpediente) {
        this.ListaNumeroExpediente = ListaNumeroExpediente;
    }

    public List<String> getListaIdReasignacionReasignar() {
        return ListaIdReasignacionReasignar;
    }

    public void setListaIdReasignacionReasignar(List<String> ListaIdReasignacionReasignar) {
        this.ListaIdReasignacionReasignar = ListaIdReasignacionReasignar;
    }

    public List<String> getListaIdReporteReasignar() {
        return ListaIdReporteReasignar;
    }

    public void setListaIdReporteReasignar(List<String> ListaIdReporteReasignar) {
        this.ListaIdReporteReasignar = ListaIdReporteReasignar;
    }

    public List<String> getListaNumeroExpedientenReasignar() {
        return ListaNumeroExpedientenReasignar;
    }

    public void setListaNumeroExpedientenReasignar(List<String> ListaNumeroExpedientenReasignar) {
        this.ListaNumeroExpedientenReasignar = ListaNumeroExpedientenReasignar;
    }

    public List<String> getListaFechaPeticionReasignar() {
        return ListaFechaPeticionReasignar;
    }

    public void setListaFechaPeticionReasignar(List<String> ListaFechaPeticionReasignar) {
        this.ListaFechaPeticionReasignar = ListaFechaPeticionReasignar;
    }

    public List<String> getListaIdAsesorAntiguoReasignar() {
        return ListaIdAsesorAntiguoReasignar;
    }

    public void setListaIdAsesorAntiguoReasignar(List<String> ListaIdAsesorAntiguoReasignar) {
        this.ListaIdAsesorAntiguoReasignar = ListaIdAsesorAntiguoReasignar;
    }

    public List<String> getListaIdAsesorNuevoReasignar() {
        return ListaIdAsesorNuevoReasignar;
    }

    public void setListaIdAsesorNuevoReasignar(List<String> ListaIdAsesorNuevoReasignar) {
        this.ListaIdAsesorNuevoReasignar = ListaIdAsesorNuevoReasignar;
    }

    public List<String> getListaIdCoordinadorReasignoReasignar() {
        return ListaIdCoordinadorReasignoReasignar;
    }

    public void setListaIdCoordinadorReasignoReasignar(List<String> ListaIdCoordinadorReasignoReasignar) {
        this.ListaIdCoordinadorReasignoReasignar = ListaIdCoordinadorReasignoReasignar;
    }

    public List<String> getListaFechaReasignacionReasignar() {
        return ListaFechaReasignacionReasignar;
    }

    public void setListaFechaReasignacionReasignar(List<String> ListaFechaReasignacionReasignar) {
        this.ListaFechaReasignacionReasignar = ListaFechaReasignacionReasignar;
    }

    public List<String> getListaMotivoReasignacionReasignar() {
        return ListaMotivoReasignacionReasignar;
    }

    public void setListaMotivoReasignacionReasignar(List<String> ListaMotivoReasignacionReasignar) {
        this.ListaMotivoReasignacionReasignar = ListaMotivoReasignacionReasignar;
    }

    public List<String> getListaNumeroExpedienteExp() {
        return ListaNumeroExpedienteExp;
    }

    public void setListaNumeroExpedienteExp(List<String> ListaNumeroExpedienteExp) {
        this.ListaNumeroExpedienteExp = ListaNumeroExpedienteExp;
    }

    public List<String> getListaFechaCreacionExp() {
        return ListaFechaCreacionExp;
    }

    public void setListaFechaCreacionExp(List<String> ListaFechaCreacionExp) {
        this.ListaFechaCreacionExp = ListaFechaCreacionExp;
    }

    public List<String> getListaReseniaSituacionExp() {
        return ListaReseniaSituacionExp;
    }

    public void setListaReseniaSituacionExp(List<String> ListaReseniaSituacionExp) {
        this.ListaReseniaSituacionExp = ListaReseniaSituacionExp;
    }

    public String getNumero_expediente() {
        return numero_expediente;
    }

    public void setNumero_expediente(String numero_expediente) {
        this.numero_expediente = numero_expediente;
    }

    public String getTipo_documento() {
        return tipo_documento;
    }

    public void setTipo_documento(String tipo_documento) {
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

    public String getId_usuario_recibio() {
        return id_usuario_recibio;
    }

    public void setId_usuario_recibio(String id_usuario_recibio) {
        this.id_usuario_recibio = id_usuario_recibio;
    }

    public String getNumero_oficion() {
        return numero_oficion;
    }

    public void setNumero_oficion(String numero_oficion) {
        this.numero_oficion = numero_oficion;
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

    public String getAnonimato() {
        return anonimato;
    }

    public void setAnonimato(String anonimato) {
        this.anonimato = anonimato;
    }

    public String getId_custodia() {
        return id_custodia;
    }

    public void setId_custodia(String id_custodia) {
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

    public String getId_usuario_asesor() {
        return id_usuario_asesor;
    }

    public void setId_usuario_asesor(String id_usuario_asesor) {
        this.id_usuario_asesor = id_usuario_asesor;
    }

    public String getFecha_asignacion_asesor() {
        return fecha_asignacion_asesor;
    }

    public void setFecha_asignacion_asesor(String fecha_asignacion_asesor) {
        this.fecha_asignacion_asesor = fecha_asignacion_asesor;
    }

    public String getEtapa_actual() {
        return etapa_actual;
    }

    public void setEtapa_actual(String etapa_actual) {
        this.etapa_actual = etapa_actual;
    }

    
}
