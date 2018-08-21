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
public class Victima {
    
    //VARIABLES TRAER VICTIMA
    int id_victima;
    String numero_expediente;
    String nombres;
    String apellido_paterno;
    String apellido_materno;
    int edad;
    String sexo;
    String escolaridad;
    String relacion_agresor;
    int id_direccion;
    String lugar_nacimiento;
    String fecha_nacimiento;
    String nacionalidad;
    String religion;
    String estado_civil;
    int discapacidad;
    String cual_discapacidad;
    String idioma_dialecto;
    String grupo_etnico;
    int id_reporte;
    boolean existe_victima;
    
    //VARIABLES PARA TRAER N VICTIMAS
    List<String> ListaIdVictima = new ArrayList<String>();
    List<String> ListaNumeroExpediente = new ArrayList<String>();
    List<String> ListaNombres = new ArrayList<String>();
    List<String> ListaApellidoPaterno = new ArrayList<String>();
    List<String> ListaApellidoMaterno = new ArrayList<String>();
    List<String> ListaEdad = new ArrayList<String>();
    List<String> ListaSexo = new ArrayList<String>();
    List<String> ListaEscolaridad = new ArrayList<String>();
    List<String> ListaRelacionAgresor = new ArrayList<String>();
    List<String> ListaIdDireccion = new ArrayList<String>();
    List<String> ListaLugarNacimiento = new ArrayList<String>();
    List<String> ListaFechaNacimiento = new ArrayList<String>();
    List<String> ListaNacionalidad = new ArrayList<String>();
    List<String> ListaReligion = new ArrayList<String>();
    List<String> ListaEstadoCivil = new ArrayList<String>();
    List<String> ListaDiscapacidad = new ArrayList<String>();
    List<String> ListaCualDiscapacidad = new ArrayList<String>();
    List<String> ListaIdiomaDialecto = new ArrayList<String>();
    List<String> ListaGrupoEtnico = new ArrayList<String>();
    List<String> ListaIdReporte = new ArrayList<String>();
    
    boolean existen_victimas;
    
    List<String> ListaIdVictimaAux = new ArrayList<String>();
    List<String> ListaNumeroExpedienteAux = new ArrayList<String>();
    List<String> ListaNombresAux = new ArrayList<String>();
    List<String> ListaApellidoPaternoAux = new ArrayList<String>();
    List<String> ListaApellidoMaternoAux = new ArrayList<String>();
    List<String> ListaEdadAux = new ArrayList<String>();
    List<String> ListaSexoAux = new ArrayList<String>();
    List<String> ListaEscolaridadAux = new ArrayList<String>();
    List<String> ListaRelacionAgresorAux = new ArrayList<String>();
    List<String> ListaIdDireccionAux = new ArrayList<String>();
    List<String> ListaLugarNacimientoAux = new ArrayList<String>();
    List<String> ListaFechaNacimientoAux = new ArrayList<String>();
    List<String> ListaNacionalidadAux = new ArrayList<String>();
    List<String> ListaReligionAux = new ArrayList<String>();
    List<String> ListaEstadoCivilAux = new ArrayList<String>();
    List<String> ListaDiscapacidadAux = new ArrayList<String>();
    List<String> ListaCualDiscapacidadAux = new ArrayList<String>();
    List<String> ListaIdiomaDialectoAux = new ArrayList<String>();
    List<String> ListaGrupoEtnicoAux = new ArrayList<String>();
    List<String> ListaIdReporteAux = new ArrayList<String>();
    
    
    //AGREGAR VICTIMA
    public void agregarVictima(Connection con, String numero_expediente, String nombres, String apellido_paterno,
                                String apellido_materno, int edad, String sexo, String escolaridad, String relacion_agresor,
                                String lugar_nacimiento, String fecha_nacimiento, String nacionalidad, String religion,
                                String estado_civil, int discapacidad, String cual_discapacidad, String idioma_dialecto,
                                String grupo_etnico){
        
        try {
            
            CallableStatement pstmt = con.prepareCall("{call dbo.AgregarVictima(?,?,?,?,?,"
                                                                                + "?,?,?,?,?,"
                                                                                + "?,?,?,?,?,?,?)}");
            
            pstmt.setString(1, numero_expediente);
            pstmt.setString(2, nombres);
            pstmt.setString(3, apellido_paterno);
            pstmt.setString(4, apellido_materno);
            pstmt.setInt(5, edad);
            pstmt.setString(6, sexo);
            pstmt.setString(7, escolaridad);
            pstmt.setString(8, relacion_agresor);
            pstmt.setString(9, lugar_nacimiento);
            pstmt.setString(10, fecha_nacimiento);
            pstmt.setString(11, nacionalidad);
            pstmt.setString(12, religion);
            pstmt.setString(13, estado_civil);
            pstmt.setInt(14, discapacidad);
            pstmt.setString(15, cual_discapacidad);
            pstmt.setString(16, idioma_dialecto);
            pstmt.setString(17, grupo_etnico);
            
            pstmt.execute();
            
                System.out.println("SE AGREGO VICTIMA CORRECTAMENTE");
            
            pstmt.close();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
    }
    
    //ACTUALIZAR VICTIMA  //SE ACTUALIZAR POR MEDIO DEL ID
    public void actualizarVictima(Connection con, String numero_expediente, String nombres, String apellido_paterno,
                                String apellido_materno, int edad, String sexo, String escolaridad, String relacion_agresor,
                                int id_direccion, String lugar_nacimiento, String fecha_nacimiento, String nacionalidad,
                                String religion, String estado_civil, int discapacidad, String cual_discapacidad,
                                String idioma_dialecto, String grupo_etnico, int id_reporte, int id_victima){
        
        try {
            
            CallableStatement pstmt = con.prepareCall("{call dbo.ActualizarVictima(?,?,?,?,?,"
                                                                                + "?,?,?,?,?,"
                                                                                + "?,?,?,?,?,"
                                                                                + "?,?,?,?,?)}");
            
            pstmt.setString(1, numero_expediente);
            pstmt.setString(2, nombres);
            pstmt.setString(3, apellido_paterno);
            pstmt.setString(4, apellido_materno);
            pstmt.setInt(5, edad);
            pstmt.setString(6, sexo);
            pstmt.setString(7, escolaridad);
            pstmt.setString(8, relacion_agresor);
            pstmt.setInt(9, id_direccion);
            pstmt.setString(10, lugar_nacimiento);
            pstmt.setString(11, fecha_nacimiento);
            pstmt.setString(12, nacionalidad);
            pstmt.setString(13, religion);
            pstmt.setString(14, estado_civil);
            pstmt.setInt(15, discapacidad);
            pstmt.setString(16, cual_discapacidad);
            pstmt.setString(17, idioma_dialecto);
            pstmt.setString(18, grupo_etnico);
            pstmt.setInt(19, id_reporte);
            pstmt.setInt(20, id_victima);
            
            pstmt.execute();
            
                System.out.println("SE ACTUALIZO VICTIMA CORRECTAMENTE");
            
            pstmt.close();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
    }
    
    //TRAER VICTIMA
    public void seleccionarVictima(Connection con, int id_victima){
        
        try {
            
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("{Call dbo.SeleccionarVictima('"+id_victima+"')}");
            
            if(rs.next()){
                
                setExiste_victima(true);
                setId_victima(rs.getInt(1));
                setNumero_expediente(rs.getString(2));
                setNombres(rs.getString(3));
                setApellido_paterno(rs.getString(4));
                setApellido_materno(rs.getString(5));
                setEdad(rs.getInt(6));
                setSexo(rs.getString(7));
                setEscolaridad(rs.getString(8));
                setRelacion_agresor(rs.getString(9));
                setId_direccion(rs.getInt(10));
                setLugar_nacimiento(rs.getString(11));
                setFecha_nacimiento(rs.getString(12));
                setNacionalidad(rs.getString(13));
                setReligion(rs.getString(14));
                setEstado_civil(rs.getString(15));
                setDiscapacidad(rs.getInt(16));
                setCual_discapacidad(rs.getString(17));
                setIdioma_dialecto(rs.getString(18));
                setGrupo_etnico(rs.getString(19));
                setId_reporte(rs.getInt(20));
                
            }else{
                
                setExiste_victima(false);
                
            }
            
            rs.close();
            stmt.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        
    }
    
    //TRAER LISTA DE VICTIMAS
    public void seleccionarListaVictimas(Connection con, String numero_expediente){
        
        ListaIdVictimaAux.clear();
        ListaNumeroExpedienteAux.clear();
        ListaNombresAux.clear();
        ListaApellidoPaternoAux.clear();
        ListaApellidoMaternoAux.clear();
        ListaEdadAux.clear();
        ListaSexoAux.clear();
        ListaEscolaridadAux.clear();
        ListaRelacionAgresorAux.clear();
        ListaIdDireccionAux.clear();
        ListaLugarNacimientoAux.clear();
        ListaFechaNacimientoAux.clear();
        ListaNacionalidadAux.clear();
        ListaReligionAux.clear();
        ListaEstadoCivilAux.clear();
        ListaDiscapacidadAux.clear();
        ListaCualDiscapacidadAux.clear();
        ListaIdiomaDialectoAux.clear();
        ListaGrupoEtnicoAux.clear();
        ListaIdReporteAux.clear();
        
        try {
            
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("{Call dbo.SeleccionarListaVictimas('"+numero_expediente+"')}");
            
            while(rs.next()){
                
                setExisten_victimas(true);
                
                ListaIdVictimaAux.add(String.valueOf(rs.getInt(1)));
                ListaNumeroExpedienteAux.add(rs.getString(2));
                ListaNombresAux.add(rs.getString(3));
                ListaApellidoPaternoAux.add(rs.getString(4));
                ListaApellidoMaternoAux.add(rs.getString(5));
                ListaEdadAux.add(String.valueOf(rs.getInt(6)));
                ListaSexoAux.add(rs.getString(7));
                ListaEscolaridadAux.add(rs.getString(8));
                ListaRelacionAgresorAux.add(rs.getString(9));
                ListaIdDireccionAux.add(String.valueOf(rs.getInt(10)));
                ListaLugarNacimientoAux.add(rs.getString(11));
                ListaFechaNacimientoAux.add(rs.getString(12));
                ListaNacionalidadAux.add(rs.getString(13));
                ListaReligionAux.add(rs.getString(14));
                ListaEstadoCivilAux.add(rs.getString(15));
                ListaDiscapacidadAux.add(String.valueOf(rs.getInt(16)));
                ListaCualDiscapacidadAux.add(rs.getString(17));
                ListaIdiomaDialectoAux.add(rs.getString(18));
                ListaGrupoEtnicoAux.add(rs.getString(19));
                ListaIdReporteAux.add(String.valueOf(rs.getInt(20)));
                
            }
            
            setListaIdVictima(ListaIdVictimaAux);
            setListaNumeroExpediente(ListaNumeroExpedienteAux);
            setListaNombres(ListaNombresAux);
            setListaApellidoPaterno(ListaApellidoPaternoAux);
            setListaApellidoMaterno(ListaApellidoMaternoAux);
            setListaEdad(ListaEdadAux);
            setListaSexo(ListaSexoAux);
            setListaEscolaridad(ListaEscolaridadAux);
            setListaRelacionAgresor(ListaRelacionAgresorAux);
            setListaIdDireccion(ListaIdDireccionAux);
            setListaLugarNacimiento(ListaLugarNacimientoAux);
            setListaFechaNacimiento(ListaFechaNacimientoAux);
            setListaNacionalidad(ListaNacionalidadAux);
            setListaReligion(ListaReligionAux);
            setListaEstadoCivil(ListaEstadoCivilAux);
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
    
    //TRAER LISTA DE VICTIMAS (REPORTE)
    public void seleccionarListaVictimasReporte(Connection con, int id_reporte){
        
        ListaIdVictimaAux.clear();
        ListaNumeroExpedienteAux.clear();
        ListaNombresAux.clear();
        ListaApellidoPaternoAux.clear();
        ListaApellidoMaternoAux.clear();
        ListaEdadAux.clear();
        ListaSexoAux.clear();
        ListaEscolaridadAux.clear();
        ListaRelacionAgresorAux.clear();
        ListaIdDireccionAux.clear();
        ListaLugarNacimientoAux.clear();
        ListaFechaNacimientoAux.clear();
        ListaNacionalidadAux.clear();
        ListaReligionAux.clear();
        ListaEstadoCivilAux.clear();
        ListaDiscapacidadAux.clear();
        ListaCualDiscapacidadAux.clear();
        ListaIdiomaDialectoAux.clear();
        ListaGrupoEtnicoAux.clear();
        ListaIdReporteAux.clear();
        
        try {
            
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("{Call dbo.SeleccionarListaVictimasReporte('"+id_reporte+"')}");
            
            while(rs.next()){
                
                setExisten_victimas(true);
                
                ListaIdVictimaAux.add(String.valueOf(rs.getInt(1)));
                ListaNumeroExpedienteAux.add(rs.getString(2));
                ListaNombresAux.add(rs.getString(3));
                ListaApellidoPaternoAux.add(rs.getString(4));
                ListaApellidoMaternoAux.add(rs.getString(5));
                ListaEdadAux.add(String.valueOf(rs.getInt(6)));
                ListaSexoAux.add(rs.getString(7));
                ListaEscolaridadAux.add(rs.getString(8));
                ListaRelacionAgresorAux.add(rs.getString(9));
                ListaIdDireccionAux.add(String.valueOf(rs.getInt(10)));
                ListaLugarNacimientoAux.add(rs.getString(11));
                ListaFechaNacimientoAux.add(rs.getString(12));
                ListaNacionalidadAux.add(rs.getString(13));
                ListaReligionAux.add(rs.getString(14));
                ListaEstadoCivilAux.add(rs.getString(15));
                ListaDiscapacidadAux.add(String.valueOf(rs.getInt(16)));
                ListaCualDiscapacidadAux.add(rs.getString(17));
                ListaIdiomaDialectoAux.add(rs.getString(18));
                ListaGrupoEtnicoAux.add(rs.getString(19));
                ListaIdReporteAux.add(String.valueOf(rs.getInt(20)));
                
            }
            
            setListaIdVictima(ListaIdVictimaAux);
            setListaNumeroExpediente(ListaNumeroExpedienteAux);
            setListaNombres(ListaNombresAux);
            setListaApellidoPaterno(ListaApellidoPaternoAux);
            setListaApellidoMaterno(ListaApellidoMaternoAux);
            setListaEdad(ListaEdadAux);
            setListaSexo(ListaSexoAux);
            setListaEscolaridad(ListaEscolaridadAux);
            setListaRelacionAgresor(ListaRelacionAgresorAux);
            setListaIdDireccion(ListaIdDireccionAux);
            setListaLugarNacimiento(ListaLugarNacimientoAux);
            setListaFechaNacimiento(ListaFechaNacimientoAux);
            setListaNacionalidad(ListaNacionalidadAux);
            setListaReligion(ListaReligionAux);
            setListaEstadoCivil(ListaEstadoCivilAux);
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
    
    //ACTUALIZAR NIÑ0S Y NIÑAS
    public void actualizarNinoNina(Connection con, String numero_expediente, String nombres, String apellido_paterno,
                                String apellido_materno, int edad, String sexo, String escolaridad, String relacion_agresor,
                                int id_direccion, String lugar_nacimiento, String fecha_nacimiento, String nacionalidad,
                                String religion, String estado_civil, int discapacidad, String cual_discapacidad,
                                String idioma_dialecto, String grupo_etnico, int id_reporte){
        
        try {
            
            CallableStatement pstmt = con.prepareCall("{call dbo.ActualizarNinoNina(?,?,?,?,?,"
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
            pstmt.setString(8, relacion_agresor);
            pstmt.setInt(9, id_direccion);
            pstmt.setString(10, lugar_nacimiento);
            pstmt.setString(11, fecha_nacimiento);
            pstmt.setString(12, nacionalidad);
            pstmt.setString(13, religion);
            pstmt.setString(14, estado_civil);
            pstmt.setInt(15, discapacidad);
            pstmt.setString(16, cual_discapacidad);
            pstmt.setString(17, idioma_dialecto);
            pstmt.setString(18, grupo_etnico);
            pstmt.setInt(19, id_reporte);
            
            pstmt.execute();
            
                System.out.println("SE ACTUALIZO VICTIMA  (NINO Y NINA)  CORRECTAMENTE");
            
            pstmt.close();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
    }

    public int getId_victima() {
        return id_victima;
    }

    public void setId_victima(int id_victima) {
        this.id_victima = id_victima;
    }

    public String getNumero_expediente() {
        return numero_expediente;
    }

    public void setNumero_expediente(String numero_expediente) {
        this.numero_expediente = numero_expediente;
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

    public String getRelacion_agresor() {
        return relacion_agresor;
    }

    public void setRelacion_agresor(String relacion_agresor) {
        this.relacion_agresor = relacion_agresor;
    }

    public int getId_direccion() {
        return id_direccion;
    }

    public void setId_direccion(int id_direccion) {
        this.id_direccion = id_direccion;
    }

    public String getLugar_nacimiento() {
        return lugar_nacimiento;
    }

    public void setLugar_nacimiento(String lugar_nacimiento) {
        this.lugar_nacimiento = lugar_nacimiento;
    }

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
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

    public String getEstado_civil() {
        return estado_civil;
    }

    public void setEstado_civil(String estado_civil) {
        this.estado_civil = estado_civil;
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

    public boolean isExiste_victima() {
        return existe_victima;
    }

    public void setExiste_victima(boolean existe_victima) {
        this.existe_victima = existe_victima;
    }

    public List<String> getListaIdVictima() {
        return ListaIdVictima;
    }

    public void setListaIdVictima(List<String> ListaIdVictima) {
        this.ListaIdVictima = ListaIdVictima;
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

    public List<String> getListaRelacionAgresor() {
        return ListaRelacionAgresor;
    }

    public void setListaRelacionAgresor(List<String> ListaRelacionAgresor) {
        this.ListaRelacionAgresor = ListaRelacionAgresor;
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

    public boolean isExisten_victimas() {
        return existen_victimas;
    }

    public void setExisten_victimas(boolean existen_victimas) {
        this.existen_victimas = existen_victimas;
    }
    
    
    
}
