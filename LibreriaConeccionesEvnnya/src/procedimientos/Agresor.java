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
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author jahir
 */
public class Agresor {
    
    //VARIABLES PARA TRAER AGRESOR
    int id_agresor;
    String numero_expediente;
    String nombre;
    String apellido_paterno;
    String apellido_materno;
    int edad;
    String sexo;
    String escolaridad;
    String ocupacion;
    String lugar_trabajo;
    String estado_civil;
    String relacion_victima;
    int id_direccion;
    String fecha_nacimiento;
    String lugar_nacimiento;
    String nacionalidad;
    String religion;
    int discapacidad;
    String cual_discapacidad;
    String idioma_dialecto;
    String grupo_etnico;
    int id_reporte;
    boolean existe_agresor;
    
    //VARIABLES PARA TRAER N AGRESORES
    List<String> ListaIdAgresor = new ArrayList<String>();
    List<String> ListaNumeroExpediente = new ArrayList<String>();
    List<String> ListaNombres = new ArrayList<String>();
    List<String> ListaApellidoPaterno = new ArrayList<String>();
    List<String> ListaApellidoMaterno = new ArrayList<String>();
    List<String> ListaEdad = new ArrayList<String>();
    List<String> ListaSexo = new ArrayList<String>();
    List<String> ListaEscolaridad = new ArrayList<String>();
    List<String> ListaOcupacion = new ArrayList<String>();
    List<String> ListaLugarTrabajo = new ArrayList<String>();
    List<String> ListaEstadoCivil = new ArrayList<String>();
    List<String> ListaRelacionVictima = new ArrayList<String>();
    List<String> ListaIdDireccion = new ArrayList<String>();
    List<String> ListaLugarNacimiento = new ArrayList<String>();
    List<String> ListaFechaNacimiento = new ArrayList<String>();
    List<String> ListaNacionalidad = new ArrayList<String>();
    List<String> ListaReligion = new ArrayList<String>();  
    List<String> ListaDiscapacidad = new ArrayList<String>();
    List<String> ListaCualDiscapacidad = new ArrayList<String>();
    List<String> ListaIdiomaDialecto = new ArrayList<String>();
    List<String> ListaGrupoEtnico = new ArrayList<String>();
    List<String> ListaIdReporte = new ArrayList<String>();
    
    boolean existen_agresores;
    
    List<String> ListaIdAgresorAux = new ArrayList<String>();
    List<String> ListaNumeroExpedienteAux = new ArrayList<String>();
    List<String> ListaNombresAux = new ArrayList<String>();
    List<String> ListaApellidoPaternoAux = new ArrayList<String>();
    List<String> ListaApellidoMaternoAux = new ArrayList<String>();
    List<String> ListaEdadAux = new ArrayList<String>();
    List<String> ListaSexoAux = new ArrayList<String>();
    List<String> ListaEscolaridadAux = new ArrayList<String>();
    List<String> ListaOcupacionAux = new ArrayList<String>();
    List<String> ListaLugarTrabajoAux = new ArrayList<String>();
    List<String> ListaEstadoCivilAux = new ArrayList<String>();
    List<String> ListaRelacionVictimaAux = new ArrayList<String>();
    List<String> ListaIdDireccionAux = new ArrayList<String>();
    List<String> ListaLugarNacimientoAux = new ArrayList<String>();
    List<String> ListaFechaNacimientoAux = new ArrayList<String>();
    List<String> ListaNacionalidadAux = new ArrayList<String>();
    List<String> ListaReligionAux = new ArrayList<String>();
    List<String> ListaDiscapacidadAux = new ArrayList<String>();
    List<String> ListaCualDiscapacidadAux = new ArrayList<String>();
    List<String> ListaIdiomaDialectoAux = new ArrayList<String>();
    List<String> ListaGrupoEtnicoAux = new ArrayList<String>();
    List<String> ListaIdReporteAux = new ArrayList<String>();
    
    
    //AGREGAR AGRESOR
    public void agregarAgresor(Connection con, String numero_expediente, String nombres, String apellido_paterno,
                                String apellido_materno, int edad, String sexo, String escolaridad,String ocupacion,
                                String lugar_trabajo, String estado_civil, String relacion_victima, String fecha_nacimiento,
                                String lugar_nacimiento, String nacionalidad, String religion, int discapacidad,
                                String cual_discapacidad, String idioma_dialecto, String grupo_etnico){
        
        try {
            
            CallableStatement pstmt = con.prepareCall("{call dbo.AgregarAgresor(?,?,?,?,?,"
                                                                                + "?,?,?,?,?,"
                                                                                + "?,?,?,?,?,"
                                                                                + "?,?,?,?)}");
            
            pstmt.setString(1, numero_expediente);
            pstmt.setString(2, nombres);
            pstmt.setString(3, apellido_paterno);
            pstmt.setString(4, apellido_materno);
            pstmt.setInt(5, edad);
            pstmt.setString(6, sexo);
            pstmt.setString(7, escolaridad);
            pstmt.setString(8, ocupacion);
            pstmt.setString(9, lugar_trabajo);
            pstmt.setString(10, estado_civil);
            pstmt.setString(11, relacion_victima);
            pstmt.setString(12, fecha_nacimiento);
            pstmt.setString(13, lugar_nacimiento);
            pstmt.setString(14, nacionalidad);
            pstmt.setString(15, religion);
            pstmt.setInt(16, discapacidad);
            pstmt.setString(17, cual_discapacidad);
            pstmt.setString(18, idioma_dialecto);
            pstmt.setString(19, grupo_etnico);
            
            pstmt.execute();
            
                System.out.println("SE AGREGO AGRESOR CORRECTAMENTE");
            
            pstmt.close();
            
        } catch (Exception e) {
            Logger.getLogger(Pruebas_coneccion_evnnya.class.getName()).log(Level.SEVERE, null, e);
        }
        
    }
    
    //ACTUALIZAR AGRESOR //SE ACTUALIZA POR ID_AGRESOR
    public void actualizarAgresor(Connection con, String numero_expediente, String nombres, String apellido_paterno,
                                String apellido_materno, int edad, String sexo, String escolaridad,String ocupacion,
                                String lugar_trabajo, String estado_civil, String relacion_victima, int id_agresor){
        
        try {
            
            CallableStatement pstmt = con.prepareCall("{call dbo.ActualizarAgresor(?,?,?,?,?,"
                                                                                + "?,?,?,?,?,"
                                                                                + "?,?)}");
            
            pstmt.setString(1, numero_expediente);
            pstmt.setString(2, nombres);
            pstmt.setString(3, apellido_paterno);
            pstmt.setString(4, apellido_materno);
            pstmt.setInt(5, edad);
            pstmt.setString(6, sexo);
            pstmt.setString(7, escolaridad);
            pstmt.setString(8, ocupacion);
            pstmt.setString(9, lugar_trabajo);
            pstmt.setString(10, estado_civil);
            pstmt.setString(11, relacion_victima);
            pstmt.setInt(12, id_agresor);
            
            pstmt.execute();
            
                System.out.println("SE MODIFICO AGRESOR CORRECTAMENTE");
            
            pstmt.close();
            
        } catch (Exception e) {
            Logger.getLogger(Pruebas_coneccion_evnnya.class.getName()).log(Level.SEVERE, null, e);
        }
        
    }
    
    //TRAER AGRESOR
    public void seleccionarAgresor(Connection con, int id_agresor){
        
        try {
            
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("{Call dbo.SeleccionarAgresor('"+id_agresor+"')}");
            
            if(rs.next()){
                
                setExiste_agresor(true);
                setId_agresor(rs.getInt(1));
                setNumero_expediente(rs.getString(2));
                setNombre(rs.getString(3));
                setApellido_paterno(rs.getString(4));
                setApellido_materno(rs.getString(5));
                setEdad(rs.getInt(6));
                setSexo(rs.getString(7));
                setEscolaridad(rs.getString(8));
                setOcupacion(rs.getString(9));
                setLugar_trabajo(rs.getString(10));
                setEstado_civil(rs.getString(11));
                setRelacion_victima(rs.getString(12));
                setId_direccion(rs.getInt(13));
                setLugar_nacimiento(rs.getString(14));
                setFecha_nacimiento(rs.getString(15));
                setNacionalidad(rs.getString(16));
                setReligion(rs.getString(17));
                setDiscapacidad(rs.getInt(18));
                setCual_discapacidad(rs.getString(19));
                setIdioma_dialecto(rs.getString(20));
                setGrupo_etnico(rs.getString(21));
                setId_reporte(rs.getInt(22));
                
            }else{
                
                setExiste_agresor(false);
                
            }
            
            rs.close();
            stmt.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        
    }
    
    //TRAER LISTA DE AGRESORES
    public void seleccionarListaAgresor(Connection con, String numero_expediente){
        
        ListaIdAgresorAux.clear();
        ListaNumeroExpedienteAux.clear();
        ListaNombresAux.clear();
        ListaApellidoPaternoAux.clear();
        ListaApellidoMaternoAux.clear();
        ListaEdadAux.clear();
        ListaSexoAux.clear();
        ListaEscolaridadAux.clear();
        ListaOcupacionAux.clear();
        ListaLugarTrabajoAux.clear();
        ListaEstadoCivilAux.clear();
        ListaRelacionVictimaAux.clear();
        ListaIdDireccionAux.clear();
        ListaLugarNacimientoAux.clear();
        ListaFechaNacimientoAux.clear();
        ListaNacionalidadAux.clear();
        ListaReligionAux.clear();
        ListaDiscapacidadAux.clear();
        ListaCualDiscapacidadAux.clear();
        ListaIdiomaDialectoAux.clear();
        ListaGrupoEtnicoAux.clear();
        ListaIdReporteAux.clear();
        
        try {
            
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("{Call dbo.SeleccionarListaAgresorReporte('"+numero_expediente+"')}");
            
            while(rs.next()){
                
                setExisten_agresores(true);
                
                ListaIdAgresorAux.add(String.valueOf(rs.getInt(1)));
                ListaNumeroExpedienteAux.add(rs.getString(2));
                ListaNombresAux.add(rs.getString(3));
                ListaApellidoPaternoAux.add(rs.getString(4));
                ListaApellidoMaternoAux.add(rs.getString(5));
                ListaEdadAux.add(String.valueOf(rs.getInt(6)));
                ListaSexoAux.add(rs.getString(7));
                ListaEscolaridadAux.add(rs.getString(8));
                ListaOcupacionAux.add(rs.getString(9));
                ListaLugarTrabajoAux.add(rs.getString(10));
                ListaEstadoCivilAux.add(rs.getString(11));
                ListaRelacionVictimaAux.add(rs.getString(12));
                ListaIdDireccionAux.add(String.valueOf(rs.getInt(13)));
                ListaFechaNacimientoAux.add(rs.getString(14));
                ListaLugarNacimientoAux.add(rs.getString(15));
                ListaNacionalidadAux.add(rs.getString(16));
                ListaReligionAux.add(rs.getString(17));
                ListaDiscapacidadAux.add(String.valueOf(rs.getInt(18)));
                ListaCualDiscapacidadAux.add(rs.getString(19));
                ListaIdiomaDialectoAux.add(rs.getString(20));
                ListaGrupoEtnicoAux.add(rs.getString(21));
                ListaIdReporteAux.add(String.valueOf(rs.getInt(22)));
                
            }
            
            setListaIdAgresor(ListaIdAgresorAux);
            setListaNumeroExpediente(ListaNumeroExpedienteAux);
            setListaNombres(ListaNombresAux);
            setListaApellidoPaterno(ListaApellidoPaternoAux);
            setListaApellidoMaterno(ListaApellidoMaternoAux);
            setListaEdad(ListaEdadAux);
            setListaSexo(ListaSexoAux);
            setListaEscolaridad(ListaEscolaridadAux);
            setListaOcupacion(ListaOcupacionAux);
            setListaLugarTrabajo(ListaLugarTrabajoAux);
            setListaEstadoCivil(ListaEstadoCivilAux);
            setListaRelacionVictima(ListaRelacionVictimaAux);
            setListaIdDireccion(ListaIdDireccionAux);
            setListaLugarNacimiento(ListaLugarNacimientoAux);
            setListaFechaNacimiento(ListaFechaNacimientoAux);
            setListaNacionalidad(ListaNacionalidadAux);
            setListaReligion(ListaReligionAux);
            setListaDiscapacidad(ListaDiscapacidadAux);
            setListaCualDiscapacidad(ListaCualDiscapacidadAux);
            setListaIdiomaDialecto(ListaIdiomaDialectoAux);
            setListaGrupoEtnico(ListaGrupoEtnicoAux);
            setListaIdReporte(ListaIdReporteAux);
            
            rs.close();
            stmt.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        
    }
    
    //TRAER LISTA DE AGRESORES (REPORTE)
    public void seleccionarListaAgresoresReporte(Connection con, int id_reporte){
        
        ListaIdAgresorAux.clear();
        ListaNumeroExpedienteAux.clear();
        ListaNombresAux.clear();
        ListaApellidoPaternoAux.clear();
        ListaApellidoMaternoAux.clear();
        ListaEdadAux.clear();
        ListaSexoAux.clear();
        ListaEscolaridadAux.clear();
        ListaOcupacionAux.clear();
        ListaLugarTrabajo.clear();
        ListaEstadoCivilAux.clear();
        ListaRelacionVictimaAux.clear();
        ListaIdDireccionAux.clear();
        ListaLugarNacimientoAux.clear();
        ListaFechaNacimientoAux.clear();
        ListaNacionalidadAux.clear();
        ListaReligionAux.clear();
        ListaDiscapacidadAux.clear();
        ListaCualDiscapacidadAux.clear();
        ListaIdiomaDialectoAux.clear();
        ListaGrupoEtnicoAux.clear();
        ListaIdReporteAux.clear();
        
        try {
            
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("{Call dbo.SeleccionarListaAgreoresReporte('"+id_reporte+"')}");
            
            while(rs.next()){
                
                setExisten_agresores(true);
                
                ListaIdAgresorAux.add(String.valueOf(rs.getInt(1)));
                ListaNumeroExpedienteAux.add(rs.getString(2));
                ListaNombresAux.add(rs.getString(3));
                ListaApellidoPaternoAux.add(rs.getString(4));
                ListaApellidoMaternoAux.add(rs.getString(5));
                ListaEdadAux.add(String.valueOf(rs.getInt(6)));
                ListaSexoAux.add(rs.getString(7));
                ListaEscolaridadAux.add(rs.getString(8));
                ListaOcupacionAux.add(rs.getString(9));
                ListaLugarTrabajoAux.add(rs.getString(10));
                ListaEstadoCivilAux.add(rs.getString(11));
                ListaRelacionVictimaAux.add(rs.getString(12));
                ListaIdDireccionAux.add(String.valueOf(rs.getInt(13)));
                ListaLugarNacimientoAux.add(rs.getString(14));
                ListaFechaNacimientoAux.add(rs.getString(15));
                ListaNacionalidadAux.add(rs.getString(16));
                ListaReligionAux.add(rs.getString(17));
                ListaDiscapacidadAux.add(String.valueOf(rs.getInt(18)));
                ListaCualDiscapacidadAux.add(rs.getString(19));
                ListaIdiomaDialectoAux.add(rs.getString(20));
                ListaGrupoEtnicoAux.add(rs.getString(21));
                ListaIdReporteAux.add(String.valueOf(rs.getInt(22)));
                
            }
            
            setListaIdAgresor(ListaIdAgresorAux);
            setListaNumeroExpediente(ListaNumeroExpedienteAux);
            setListaNombres(ListaNombresAux);
            setListaApellidoPaterno(ListaApellidoPaternoAux);
            setListaApellidoMaterno(ListaApellidoMaternoAux);
            setListaEdad(ListaEdadAux);
            setListaSexo(ListaSexoAux);
            setListaEscolaridad(ListaEscolaridadAux);
            setListaOcupacion(ListaOcupacionAux);
            setListaLugarTrabajo(ListaLugarTrabajoAux);
            setListaEstadoCivil(ListaEstadoCivilAux);
            setListaRelacionVictima(ListaRelacionVictimaAux);
            setListaIdDireccion(ListaIdDireccionAux);
            setListaFechaNacimiento(ListaFechaNacimientoAux);
            setListaLugarNacimiento(ListaLugarNacimientoAux);
            setListaNacionalidad(ListaNacionalidadAux);
            setListaReligion(ListaReligionAux);
            setListaDiscapacidad(ListaDiscapacidadAux);
            setListaCualDiscapacidad(ListaCualDiscapacidadAux);
            setListaIdiomaDialecto(ListaIdiomaDialectoAux);
            setListaGrupoEtnico(ListaGrupoEtnicoAux);
            setListaIdReporte(ListaIdReporteAux);
            
            rs.close();
            stmt.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        
    }

    public int getId_agresor() {
        return id_agresor;
    }

    public void setId_agresor(int id_agresor) {
        this.id_agresor = id_agresor;
    }

    public String getNumero_expediente() {
        return numero_expediente;
    }

    public void setNumero_expediente(String numero_expediente) {
        this.numero_expediente = numero_expediente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
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

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    public String getLugar_trabajo() {
        return lugar_trabajo;
    }

    public void setLugar_trabajo(String lugar_trabajo) {
        this.lugar_trabajo = lugar_trabajo;
    }

    public String getEstado_civil() {
        return estado_civil;
    }

    public void setEstado_civil(String estado_civil) {
        this.estado_civil = estado_civil;
    }

    public String getRelacion_victima() {
        return relacion_victima;
    }

    public void setRelacion_victima(String relacion_victima) {
        this.relacion_victima = relacion_victima;
    }

    public int getId_direccion() {
        return id_direccion;
    }

    public void setId_direccion(int id_direccion) {
        this.id_direccion = id_direccion;
    }

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getLugar_nacimiento() {
        return lugar_nacimiento;
    }

    public void setLugar_nacimiento(String lugar_nacimiento) {
        this.lugar_nacimiento = lugar_nacimiento;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public int getDiscapacidad() {
        return discapacidad;
    }

    public void setDiscapacidad(int discapacidad) {
        this.discapacidad = discapacidad;
    }

    public String getCual_discapacidad() {
        return cual_discapacidad;
    }

    public void setCual_discapacidad(String cual_discapacidad) {
        this.cual_discapacidad = cual_discapacidad;
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

    public int getId_reporte() {
        return id_reporte;
    }

    public void setId_reporte(int id_reporte) {
        this.id_reporte = id_reporte;
    }

    public boolean isExiste_agresor() {
        return existe_agresor;
    }

    public void setExiste_agresor(boolean existe_agresor) {
        this.existe_agresor = existe_agresor;
    }

    public List<String> getListaIdAgresor() {
        return ListaIdAgresor;
    }

    public void setListaIdAgresor(List<String> ListaIdAgresor) {
        this.ListaIdAgresor = ListaIdAgresor;
    }

    public List<String> getListaNumeroExpediente() {
        return ListaNumeroExpediente;
    }

    public void setListaNumeroExpediente(List<String> ListaNumeroExpediente) {
        this.ListaNumeroExpediente = ListaNumeroExpediente;
    }

    public List<String> getListaNombres() {
        return ListaNombres;
    }

    public void setListaNombres(List<String> ListaNombres) {
        this.ListaNombres = ListaNombres;
    }

    public List<String> getListaApellidoPaterno() {
        return ListaApellidoPaterno;
    }

    public void setListaApellidoPaterno(List<String> ListaApellidoPaterno) {
        this.ListaApellidoPaterno = ListaApellidoPaterno;
    }

    public List<String> getListaApellidoMaterno() {
        return ListaApellidoMaterno;
    }

    public void setListaApellidoMaterno(List<String> ListaApellidoMaterno) {
        this.ListaApellidoMaterno = ListaApellidoMaterno;
    }

    public List<String> getListaEdad() {
        return ListaEdad;
    }

    public void setListaEdad(List<String> ListaEdad) {
        this.ListaEdad = ListaEdad;
    }

    public List<String> getListaSexo() {
        return ListaSexo;
    }

    public void setListaSexo(List<String> ListaSexo) {
        this.ListaSexo = ListaSexo;
    }

    public List<String> getListaEscolaridad() {
        return ListaEscolaridad;
    }

    public void setListaEscolaridad(List<String> ListaEscolaridad) {
        this.ListaEscolaridad = ListaEscolaridad;
    }

    public List<String> getListaRelacionVictima() {
        return ListaRelacionVictima;
    }

    public void setListaRelacionVictima(List<String> ListaRelacionVictima) {
        this.ListaRelacionVictima = ListaRelacionVictima;
    }

    public List<String> getListaIdDireccion() {
        return ListaIdDireccion;
    }

    public void setListaIdDireccion(List<String> ListaIdDireccion) {
        this.ListaIdDireccion = ListaIdDireccion;
    }

    public List<String> getListaLugarNacimiento() {
        return ListaLugarNacimiento;
    }

    public void setListaLugarNacimiento(List<String> ListaLugarNacimiento) {
        this.ListaLugarNacimiento = ListaLugarNacimiento;
    }

    public List<String> getListaFechaNacimiento() {
        return ListaFechaNacimiento;
    }

    public void setListaFechaNacimiento(List<String> ListaFechaNacimiento) {
        this.ListaFechaNacimiento = ListaFechaNacimiento;
    }

    public List<String> getListaNacionalidad() {
        return ListaNacionalidad;
    }

    public void setListaNacionalidad(List<String> ListaNacionalidad) {
        this.ListaNacionalidad = ListaNacionalidad;
    }

    public List<String> getListaReligion() {
        return ListaReligion;
    }

    public void setListaReligion(List<String> ListaReligion) {
        this.ListaReligion = ListaReligion;
    }

    public List<String> getListaEstadoCivil() {
        return ListaEstadoCivil;
    }

    public void setListaEstadoCivil(List<String> ListaEstadoCivil) {
        this.ListaEstadoCivil = ListaEstadoCivil;
    }

    public List<String> getListaDiscapacidad() {
        return ListaDiscapacidad;
    }

    public void setListaDiscapacidad(List<String> ListaDiscapacidad) {
        this.ListaDiscapacidad = ListaDiscapacidad;
    }

    public List<String> getListaCualDiscapacidad() {
        return ListaCualDiscapacidad;
    }

    public void setListaCualDiscapacidad(List<String> ListaCualDiscapacidad) {
        this.ListaCualDiscapacidad = ListaCualDiscapacidad;
    }

    public List<String> getListaIdiomaDialecto() {
        return ListaIdiomaDialecto;
    }

    public void setListaIdiomaDialecto(List<String> ListaIdiomaDialecto) {
        this.ListaIdiomaDialecto = ListaIdiomaDialecto;
    }

    public List<String> getListaGrupoEtnico() {
        return ListaGrupoEtnico;
    }

    public void setListaGrupoEtnico(List<String> ListaGrupoEtnico) {
        this.ListaGrupoEtnico = ListaGrupoEtnico;
    }

    public List<String> getListaIdReporte() {
        return ListaIdReporte;
    }

    public void setListaIdReporte(List<String> ListaIdReporte) {
        this.ListaIdReporte = ListaIdReporte;
    }

    public boolean isExisten_agresores() {
        return existen_agresores;
    }

    public void setExisten_agresores(boolean existen_agresores) {
        this.existen_agresores = existen_agresores;
    }

    public List<String> getListaIdAgresorAux() {
        return ListaIdAgresorAux;
    }

    public void setListaIdAgresorAux(List<String> ListaIdAgresorAux) {
        this.ListaIdAgresorAux = ListaIdAgresorAux;
    }

    public List<String> getListaNumeroExpedienteAux() {
        return ListaNumeroExpedienteAux;
    }

    public void setListaNumeroExpedienteAux(List<String> ListaNumeroExpedienteAux) {
        this.ListaNumeroExpedienteAux = ListaNumeroExpedienteAux;
    }

    public List<String> getListaNombresAux() {
        return ListaNombresAux;
    }

    public void setListaNombresAux(List<String> ListaNombresAux) {
        this.ListaNombresAux = ListaNombresAux;
    }

    public List<String> getListaApellidoPaternoAux() {
        return ListaApellidoPaternoAux;
    }

    public void setListaApellidoPaternoAux(List<String> ListaApellidoPaternoAux) {
        this.ListaApellidoPaternoAux = ListaApellidoPaternoAux;
    }

    public List<String> getListaApellidoMaternoAux() {
        return ListaApellidoMaternoAux;
    }

    public void setListaApellidoMaternoAux(List<String> ListaApellidoMaternoAux) {
        this.ListaApellidoMaternoAux = ListaApellidoMaternoAux;
    }

    public List<String> getListaEdadAux() {
        return ListaEdadAux;
    }

    public void setListaEdadAux(List<String> ListaEdadAux) {
        this.ListaEdadAux = ListaEdadAux;
    }

    public List<String> getListaSexoAux() {
        return ListaSexoAux;
    }

    public void setListaSexoAux(List<String> ListaSexoAux) {
        this.ListaSexoAux = ListaSexoAux;
    }

    public List<String> getListaEscolaridadAux() {
        return ListaEscolaridadAux;
    }

    public void setListaEscolaridadAux(List<String> ListaEscolaridadAux) {
        this.ListaEscolaridadAux = ListaEscolaridadAux;
    }

    public List<String> getListaRelacionAgresorAux() {
        return ListaRelacionVictimaAux;
    }

    public void setListaRelacionAgresorAux(List<String> ListaRelacionVictimaAux) {
        this.ListaRelacionVictimaAux = ListaRelacionVictimaAux;
    }

    public List<String> getListaIdDireccionAux() {
        return ListaIdDireccionAux;
    }

    public void setListaIdDireccionAux(List<String> ListaIdDireccionAux) {
        this.ListaIdDireccionAux = ListaIdDireccionAux;
    }

    public List<String> getListaLugarNacimientoAux() {
        return ListaLugarNacimientoAux;
    }

    public void setListaLugarNacimientoAux(List<String> ListaLugarNacimientoAux) {
        this.ListaLugarNacimientoAux = ListaLugarNacimientoAux;
    }

    public List<String> getListaFechaNacimientoAux() {
        return ListaFechaNacimientoAux;
    }

    public void setListaFechaNacimientoAux(List<String> ListaFechaNacimientoAux) {
        this.ListaFechaNacimientoAux = ListaFechaNacimientoAux;
    }

    public List<String> getListaNacionalidadAux() {
        return ListaNacionalidadAux;
    }

    public void setListaNacionalidadAux(List<String> ListaNacionalidadAux) {
        this.ListaNacionalidadAux = ListaNacionalidadAux;
    }

    public List<String> getListaReligionAux() {
        return ListaReligionAux;
    }

    public void setListaReligionAux(List<String> ListaReligionAux) {
        this.ListaReligionAux = ListaReligionAux;
    }

    public List<String> getListaEstadoCivilAux() {
        return ListaEstadoCivilAux;
    }

    public void setListaEstadoCivilAux(List<String> ListaEstadoCivilAux) {
        this.ListaEstadoCivilAux = ListaEstadoCivilAux;
    }

    public List<String> getListaDiscapacidadAux() {
        return ListaDiscapacidadAux;
    }

    public void setListaDiscapacidadAux(List<String> ListaDiscapacidadAux) {
        this.ListaDiscapacidadAux = ListaDiscapacidadAux;
    }

    public List<String> getListaCualDiscapacidadAux() {
        return ListaCualDiscapacidadAux;
    }

    public void setListaCualDiscapacidadAux(List<String> ListaCualDiscapacidadAux) {
        this.ListaCualDiscapacidadAux = ListaCualDiscapacidadAux;
    }

    public List<String> getListaIdiomaDialectoAux() {
        return ListaIdiomaDialectoAux;
    }

    public void setListaIdiomaDialectoAux(List<String> ListaIdiomaDialectoAux) {
        this.ListaIdiomaDialectoAux = ListaIdiomaDialectoAux;
    }

    public List<String> getListaGrupoEtnicoAux() {
        return ListaGrupoEtnicoAux;
    }

    public void setListaGrupoEtnicoAux(List<String> ListaGrupoEtnicoAux) {
        this.ListaGrupoEtnicoAux = ListaGrupoEtnicoAux;
    }

    public List<String> getListaIdReporteAux() {
        return ListaIdReporteAux;
    }

    public void setListaIdReporteAux(List<String> ListaIdReporteAux) {
        this.ListaIdReporteAux = ListaIdReporteAux;
    }

    public List<String> getListaOcupacion() {
        return ListaOcupacion;
    }

    public void setListaOcupacion(List<String> ListaOcupacion) {
        this.ListaOcupacion = ListaOcupacion;
    }

    public List<String> getListaLugarTrabajo() {
        return ListaLugarTrabajo;
    }

    public void setListaLugarTrabajo(List<String> ListaLugarTrabajo) {
        this.ListaLugarTrabajo = ListaLugarTrabajo;
    }

    public List<String> getListaOcupacionAux() {
        return ListaOcupacionAux;
    }

    public void setListaOcupacionAux(List<String> ListaOcupacionAux) {
        this.ListaOcupacionAux = ListaOcupacionAux;
    }

    public List<String> getListaLugarTrabajoAux() {
        return ListaLugarTrabajoAux;
    }

    public void setListaLugarTrabajoAux(List<String> ListaLugarTrabajoAux) {
        this.ListaLugarTrabajoAux = ListaLugarTrabajoAux;
    }

    public List<String> getListaRelacionVictimaAux() {
        return ListaRelacionVictimaAux;
    }

    public void setListaRelacionVictimaAux(List<String> ListaRelacionVictimaAux) {
        this.ListaRelacionVictimaAux = ListaRelacionVictimaAux;
    }
    
    
    
}
