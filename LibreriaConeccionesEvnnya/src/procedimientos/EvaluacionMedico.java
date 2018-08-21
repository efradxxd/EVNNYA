/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package procedimientos;

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
public class EvaluacionMedico {
    
    //VARIABLES TRAER EXPLORACION FISICA    
    int id_exploracion;
    int id_evaluacion;
    int id_medico;
    double signo_ta ;
    double signo_fc;
    double signo_fr;
    double signo_pulso;
    double temperatura;
    double estatura;
    double peso;
    double icc;
    int deformidad_cabeza;
    int deformidad_craneo;
    int deformidad_cara;
    int deformidad_cuello;
    String deformidad_observacion;
    int oido_der;
    int oido_izq;
    int vision_cron;
    int reflejos_oc;
    int region_prec;
    int campos_pulmon;
    int visceromegalias;
    int hernias;
    int genitourinario;
    int region_perineal;
    int coordinacion;
    int sensibilidad;
    int marcha;
    int pares_craneales;
    int equilibrio;
    int insuf_ven;
    int ulceraciones;
    int escoliosis;
    int xifosis;
    int cicatrices;
    String descripcion;
    int nevos;
    int tatuajes;
    int integridades_extrem;
    int fuerza_muscular;
    int tono;
    int sensibilidad_musc;
    int rot;
    int articulaciones;
    int arcos_movilidad;
    int discapacidad;
    String observaciones;
    String nota_agregada;
    String recomendaciones;
    boolean existe_exploracion;
    
    public void agregarEvaluacionMedico(Connection con,String numero_expediente, int id_medico, String fecha_evaluacion,
                                        String hora_evaluacion,String fecha_alta, String hora_alta, String nombres_paciente,
                                        String apellido_paterno_paciente, String apellido_materno_paciente, String fecha_nacimiento,
                                        String sexo, String estado_civil, String escolaridad, String religion,
                                        int evaluacion_medica,int tipo_interrogatorio, String nombres_acompanante, String apellido_paterno_acompanante,
                                        String apellido_materno_acompanante,String relacion_acompanante_menor,
                                        int  actividad_fisica,int tipo_alimentacion, int tipo_aseo_personal,int aseo_bucal,
                                        int no_aseo_bucal, String piso_vivienda,String techo_vivienda, String ventilacion_vivienda,
                                        String zoonosis, String tipo_zoonosis, String inmunizaciones, String inspeccion_general,
                                        int id_reporte,int id_persona, String tipo_persona){
        
        try {
            
            CallableStatement pstmt = con.prepareCall("{call dbo.AgregarEvaluacionMedico(?,?,?,?,?,?,?,?,?,?,"
                                                                                      + "?,?,?,?,?,?,?,?,?,?,"
                                                                                      + "?,?,?,?,?,?,?,?,?,?,"
                                                                                      + "?,?,?,?,?)}");
            
            pstmt.setString(1, numero_expediente);
            pstmt.setInt(2, id_medico);
            pstmt.setString(3, fecha_evaluacion);
            pstmt.setString(4, hora_evaluacion);
            pstmt.setString(5, fecha_alta);
            pstmt.setString(6, hora_alta);
            pstmt.setString(7, nombres_paciente);
            pstmt.setString(8, apellido_paterno_paciente);
            pstmt.setString(9, apellido_materno_paciente);
            pstmt.setString(10, fecha_nacimiento);
            pstmt.setString(11, sexo);
            pstmt.setString(12, estado_civil);
            pstmt.setString(13, escolaridad);
            pstmt.setString(14, religion);
            pstmt.setInt(15, evaluacion_medica);
            pstmt.setInt(16, tipo_interrogatorio);
            pstmt.setString(17, nombres_acompanante);
            pstmt.setString(18, apellido_paterno_acompanante);
            pstmt.setString(19, apellido_materno_acompanante);
            pstmt.setString(20, relacion_acompanante_menor);
            pstmt.setInt(21, actividad_fisica);
            pstmt.setInt(22, tipo_alimentacion);
            pstmt.setInt(23, tipo_aseo_personal);
            pstmt.setInt(24, aseo_bucal);
            pstmt.setInt(25, no_aseo_bucal);
            pstmt.setString(26, piso_vivienda);
            pstmt.setString(27, techo_vivienda);
            pstmt.setString(28, ventilacion_vivienda);
            pstmt.setString(29, zoonosis);
            pstmt.setString(30, inspeccion_general);
            pstmt.setString(31, tipo_zoonosis);
            pstmt.setString(32, inmunizaciones);
            pstmt.setString(33, inspeccion_general);
            pstmt.setInt(34, id_persona);
            pstmt.setString(35, tipo_persona);
 
            pstmt.execute();
            
                System.out.println("SE AGREGO EVALUACION_MEDICO CORRECTAMENTE");
            
            pstmt.close();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
    }
    
    //AGREGAR EXPLORACION FISICA MEDICA
    public void agregarExploracionFisicaMedica(Connection con, int id_exploracion, int id_medico, double signo_ta
                                              , double signo_fc, double signo_fr, double signo_pulso, double temperatura, double estatura
                                              , double peso, double icc, int deformidad_cabeza, int deformidad_craneo, int deformidad_cara
                                              , int deformidad_cuello, String deformidad_observacion, int oido_der, int oido_izq, int vision_cron
                                              , int reflejos_oc, int region_prec, int campos_pulmon, int visceromegalias, int hernias, int genitourinario
                                              , int region_perineal, int coordinacion, int sensibilidad, int marcha, int pares_craneales, int equilibrio
                                              , int insuf_ven, int ulceraciones, int escoliosis, int xiofosis, int cicatrices, String descripcion, int nevos
                                              , int tatuajes, int integridades_extrem, int fuerza_muscular, int tono, int sensibilidad_musc, int rot, int articulaciones
                                              , int arcos_movilidad, int discapacidad, String observaciones, String nota_agregada, String recomendaciones){
        
        try {
            
            CallableStatement pstmt = con.prepareCall("{call dbo.AgregarEvaluacionMedico(?,?,?,?,?,?,?,?,?,?,"
                                                                                      + "?,?,?,?,?,?,?,?,?,?,"
                                                                                      + "?,?,?,?,?,?,?,?,?,?,"
                                                                                      + "?,?,?,?,?,?,?,?,?,?,"
                                                                                      + "?,?,?,?,?,?,?,?,?)}");
            
            pstmt.setInt(1, id_exploracion);
            pstmt.setInt(2, id_medico);
            pstmt.setDouble(3, signo_ta);
            pstmt.setDouble(4, signo_fc);
            pstmt.setDouble(5, signo_fr);
            pstmt.setDouble(6, signo_pulso);
            pstmt.setDouble(7, temperatura);
            pstmt.setDouble(8, estatura);
            pstmt.setDouble(9, peso);
            pstmt.setDouble(10, icc);
            pstmt.setDouble(11, deformidad_cabeza);
            pstmt.setDouble(12, deformidad_craneo);
            pstmt.setDouble(13, deformidad_cara);
            pstmt.setDouble(14, deformidad_cuello);
            pstmt.setString(15, deformidad_observacion);
            pstmt.setInt(16, oido_der);
            pstmt.setInt(17, oido_izq);
            pstmt.setInt(18, vision_cron);
            pstmt.setInt(19, reflejos_oc);
            pstmt.setInt(20, region_prec);
            pstmt.setInt(21, campos_pulmon);
            pstmt.setInt(22, visceromegalias);
            pstmt.setInt(23, hernias);
            pstmt.setInt(24, genitourinario);
            pstmt.setInt(25, region_perineal);
            pstmt.setInt(26, coordinacion);
            pstmt.setInt(27, sensibilidad);
            pstmt.setInt(28, marcha);
            pstmt.setInt(29, pares_craneales);
            pstmt.setInt(30, equilibrio);
            pstmt.setInt(31, insuf_ven);
            pstmt.setInt(32, ulceraciones);
            /*pstmt.setString(32, zoonosis);
            pstmt.setString(33, tipo_zoonosis);
            pstmt.setString(34, inmunizaciones);
            pstmt.setString(35, inspeccion_general);
            pstmt.setInt(36, id_reporte);*/
 
            pstmt.execute();
            
                System.out.println("SE AGREGO EVALUACION_MEDICO CORRECTAMENTE");
            
            pstmt.close();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
    }
    
    //TRAER EXPLORACION FISICA //POR MEDIO DEL ID_EVALUAVION
    public void seleccionarExploracionFisica(Connection con, int id_evaluacion){
        
        try {
            
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("{Call dbo.SeleccionarExploracionFisica('"+id_evaluacion+"')}");
            
            if(rs.next()){
                
                setExiste_exploracion(true);
                setId_exploracion(rs.getInt(1));
                setId_evaluacion(rs.getInt(2));
                setId_medico(rs.getInt(3));
                setSigno_ta(rs.getDouble(4));
                setSigno_fc(rs.getDouble(5));
                setSigno_fr(rs.getDouble(6));
                setSigno_pulso(rs.getDouble(7));
                setTemperatura(rs.getDouble(8));
                setEstatura(rs.getDouble(9));
                setPeso(rs.getDouble(10));
                setIcc(rs.getDouble(11));
                setDeformidad_cabeza(rs.getInt(12));
                setDeformidad_craneo(rs.getInt(13));
                setDeformidad_cara(rs.getInt(14));
                setDeformidad_cuello(rs.getInt(15));
                setDeformidad_observacion(rs.getString(16));
                setOido_der(rs.getInt(17));
                setOido_izq(rs.getInt(18));
                setVision_cron(rs.getInt(19));
                setReflejos_oc(rs.getInt(20));
                setRegion_prec(rs.getInt(21));
                setCampos_pulmon(rs.getInt(22));
                setVisceromegalias(rs.getInt(23));
                setHernias(rs.getInt(24));
                setGenitourinario(rs.getInt(25));
                setRegion_perineal(rs.getInt(26));
                setCoordinacion(rs.getInt(27));
                setSensibilidad(rs.getInt(28));
                setMarcha(rs.getInt(29));
                setPares_craneales(rs.getInt(30));
                setEquilibrio(rs.getInt(31));
                setInsuf_ven(rs.getInt(32));
                setUlceraciones(rs.getInt(33));
                setEscoliosis(rs.getInt(34));
                setXifosis(rs.getInt(35));
                setCicatrices(rs.getInt(36));
                setDescripcion(rs.getString(37));
                setNevos(rs.getInt(38));
                setTatuajes(rs.getInt(39));
                setIntegridades_extrem(rs.getInt(40));
                setFuerza_muscular(rs.getInt(41));
                setTono(rs.getInt(42));
                setSensibilidad_musc(rs.getInt(43));
                setRot(rs.getInt(44));
                setArticulaciones(rs.getInt(45));
                setArcos_movilidad(rs.getInt(46));
                setDiscapacidad(rs.getInt(47));
                setObservaciones(rs.getString(48));
                setNota_agregada(rs.getString(49));
                setRecomendaciones(rs.getString(50));
                
            }else{
                
                setExiste_exploracion(false);
                
            }
            
            rs.close();
            stmt.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(EvaluacionMedico.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    //SELECCIONAR ULTIMO REPORTE
    public int seleccionarUltimoEvaluacion_medico(Connection con){
        
        int id_evaluacion = 0;
        
        try {
            
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("{Call dbo.SeleccionarUltimoEvaluacionMedica()}");
            
            if(rs.next()){
                
                id_evaluacion = (rs.getInt(1));
                
            }
            
            rs.close();
            stmt.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(EvaluacionMedico.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return id_evaluacion;
    }

    public int getId_exploracion() {
        return id_exploracion;
    }

    public void setId_exploracion(int id_exploracion) {
        this.id_exploracion = id_exploracion;
    }
    

    public int getId_evaluacion() {
        return id_evaluacion;
    }

    public void setId_evaluacion(int id_evaluacion) {
        this.id_evaluacion = id_evaluacion;
    }

    public int getId_medico() {
        return id_medico;
    }

    public void setId_medico(int id_medico) {
        this.id_medico = id_medico;
    }

    public double getSigno_ta() {
        return signo_ta;
    }

    public void setSigno_ta(double signo_ta) {
        this.signo_ta = signo_ta;
    }

    public double getSigno_fc() {
        return signo_fc;
    }

    public void setSigno_fc(double signo_fc) {
        this.signo_fc = signo_fc;
    }

    public double getSigno_fr() {
        return signo_fr;
    }

    public void setSigno_fr(double signo_fr) {
        this.signo_fr = signo_fr;
    }

    public double getSigno_pulso() {
        return signo_pulso;
    }

    public void setSigno_pulso(double signo_pulso) {
        this.signo_pulso = signo_pulso;
    }

    public double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
    }

    public double getEstatura() {
        return estatura;
    }

    public void setEstatura(double estatura) {
        this.estatura = estatura;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getIcc() {
        return icc;
    }

    public void setIcc(double icc) {
        this.icc = icc;
    }

    public int getDeformidad_cabeza() {
        return deformidad_cabeza;
    }

    public void setDeformidad_cabeza(int deformidad_cabeza) {
        this.deformidad_cabeza = deformidad_cabeza;
    }

    public int getDeformidad_craneo() {
        return deformidad_craneo;
    }

    public void setDeformidad_craneo(int deformidad_craneo) {
        this.deformidad_craneo = deformidad_craneo;
    }

    public int getDeformidad_cara() {
        return deformidad_cara;
    }

    public void setDeformidad_cara(int deformidad_cara) {
        this.deformidad_cara = deformidad_cara;
    }

    public int getDeformidad_cuello() {
        return deformidad_cuello;
    }

    public void setDeformidad_cuello(int deformidad_cuello) {
        this.deformidad_cuello = deformidad_cuello;
    }

    public String getDeformidad_observacion() {
        return deformidad_observacion;
    }

    public void setDeformidad_observacion(String deformidad_observacion) {
        this.deformidad_observacion = deformidad_observacion;
    }

    public int getOido_der() {
        return oido_der;
    }

    public void setOido_der(int oido_der) {
        this.oido_der = oido_der;
    }

    public int getOido_izq() {
        return oido_izq;
    }

    public void setOido_izq(int oido_izq) {
        this.oido_izq = oido_izq;
    }

    public int getVision_cron() {
        return vision_cron;
    }

    public void setVision_cron(int vision_cron) {
        this.vision_cron = vision_cron;
    }

    public int getReflejos_oc() {
        return reflejos_oc;
    }

    public void setReflejos_oc(int reflejos_oc) {
        this.reflejos_oc = reflejos_oc;
    }

    public int getRegion_prec() {
        return region_prec;
    }

    public void setRegion_prec(int region_prec) {
        this.region_prec = region_prec;
    }

    public int getCampos_pulmon() {
        return campos_pulmon;
    }

    public void setCampos_pulmon(int campos_pulmon) {
        this.campos_pulmon = campos_pulmon;
    }

    public int getVisceromegalias() {
        return visceromegalias;
    }

    public void setVisceromegalias(int visceromegalias) {
        this.visceromegalias = visceromegalias;
    }

    public int getHernias() {
        return hernias;
    }

    public void setHernias(int hernias) {
        this.hernias = hernias;
    }

    public int getGenitourinario() {
        return genitourinario;
    }

    public void setGenitourinario(int genitourinario) {
        this.genitourinario = genitourinario;
    }

    public int getRegion_perineal() {
        return region_perineal;
    }

    public void setRegion_perineal(int region_perineal) {
        this.region_perineal = region_perineal;
    }

    public int getCoordinacion() {
        return coordinacion;
    }

    public void setCoordinacion(int coordinacion) {
        this.coordinacion = coordinacion;
    }

    public int getSensibilidad() {
        return sensibilidad;
    }

    public void setSensibilidad(int sensibilidad) {
        this.sensibilidad = sensibilidad;
    }

    public int getMarcha() {
        return marcha;
    }

    public void setMarcha(int marcha) {
        this.marcha = marcha;
    }

    public int getPares_craneales() {
        return pares_craneales;
    }

    public void setPares_craneales(int pares_craneales) {
        this.pares_craneales = pares_craneales;
    }

    public int getEquilibrio() {
        return equilibrio;
    }

    public void setEquilibrio(int equilibrio) {
        this.equilibrio = equilibrio;
    }

    public int getInsuf_ven() {
        return insuf_ven;
    }

    public void setInsuf_ven(int insuf_ven) {
        this.insuf_ven = insuf_ven;
    }

    public int getUlceraciones() {
        return ulceraciones;
    }

    public void setUlceraciones(int ulceraciones) {
        this.ulceraciones = ulceraciones;
    }

    public int getEscoliosis() {
        return escoliosis;
    }

    public void setEscoliosis(int escoliosis) {
        this.escoliosis = escoliosis;
    }

    public int getXifosis() {
        return xifosis;
    }

    public void setXifosis(int xifosis) {
        this.xifosis = xifosis;
    }

    public int getCicatrices() {
        return cicatrices;
    }

    public void setCicatrices(int cicatrices) {
        this.cicatrices = cicatrices;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getNevos() {
        return nevos;
    }

    public void setNevos(int nevos) {
        this.nevos = nevos;
    }

    public int getTatuajes() {
        return tatuajes;
    }

    public void setTatuajes(int tatuajes) {
        this.tatuajes = tatuajes;
    }

    public int getIntegridades_extrem() {
        return integridades_extrem;
    }

    public void setIntegridades_extrem(int integridades_extrem) {
        this.integridades_extrem = integridades_extrem;
    }

    public int getFuerza_muscular() {
        return fuerza_muscular;
    }

    public void setFuerza_muscular(int fuerza_muscular) {
        this.fuerza_muscular = fuerza_muscular;
    }

    public int getTono() {
        return tono;
    }

    public void setTono(int tono) {
        this.tono = tono;
    }

    public int getSensibilidad_musc() {
        return sensibilidad_musc;
    }

    public void setSensibilidad_musc(int sensibilidad_musc) {
        this.sensibilidad_musc = sensibilidad_musc;
    }

    public int getRot() {
        return rot;
    }

    public void setRot(int rot) {
        this.rot = rot;
    }

    public int getArticulaciones() {
        return articulaciones;
    }

    public void setArticulaciones(int articulaciones) {
        this.articulaciones = articulaciones;
    }

    public int getArcos_movilidad() {
        return arcos_movilidad;
    }

    public void setArcos_movilidad(int arcos_movilidad) {
        this.arcos_movilidad = arcos_movilidad;
    }

    public int getDiscapacidad() {
        return discapacidad;
    }

    public void setDiscapacidad(int discapacidad) {
        this.discapacidad = discapacidad;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getNota_agregada() {
        return nota_agregada;
    }

    public void setNota_agregada(String nota_agregada) {
        this.nota_agregada = nota_agregada;
    }

    public String getRecomendaciones() {
        return recomendaciones;
    }

    public void setRecomendaciones(String recomendaciones) {
        this.recomendaciones = recomendaciones;
    }

    public boolean isExiste_exploracion() {
        return existe_exploracion;
    }

    public void setExiste_exploracion(boolean existe_exploracion) {
        this.existe_exploracion = existe_exploracion;
    }
    
    
}
