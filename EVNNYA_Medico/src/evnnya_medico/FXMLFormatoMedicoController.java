/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evnnya_medico;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Pane;
import conecciones.Conexion;
import java.sql.Connection;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javax.swing.JOptionPane;
import procedimientos.EvaluacionMedico;
import procedimientos.PeticionesMedico;

/**
 * FXML Controller class
 *
 * @author lucia
 */
public class FXMLFormatoMedicoController implements Initializable {

    ToggleGroup group1 = new ToggleGroup();
    ToggleGroup group2 = new ToggleGroup();
    ToggleGroup group3 = new ToggleGroup();
    ToggleGroup group4 = new ToggleGroup();
    ToggleGroup group5 = new ToggleGroup();
    ToggleGroup group6 = new ToggleGroup();
    ToggleGroup group7 = new ToggleGroup();
    ToggleGroup group8 = new ToggleGroup();
    ToggleGroup group9 = new ToggleGroup();
    ToggleGroup group10 = new ToggleGroup();
    ToggleGroup group11 = new ToggleGroup();
    ToggleGroup group12 = new ToggleGroup();
    ToggleGroup group13 = new ToggleGroup();
    ToggleGroup group14 = new ToggleGroup();
    ToggleGroup group15 = new ToggleGroup();
    ToggleGroup group16 = new ToggleGroup();
    ToggleGroup group17 = new ToggleGroup();
    ToggleGroup group18 = new ToggleGroup();
    ToggleGroup group19 = new ToggleGroup();
    ToggleGroup group20 = new ToggleGroup();
    ToggleGroup group21 = new ToggleGroup();
    ToggleGroup group22 = new ToggleGroup();
    ToggleGroup group23 = new ToggleGroup();
    ToggleGroup group24 = new ToggleGroup();
    ToggleGroup group25 = new ToggleGroup();
    ToggleGroup group26 = new ToggleGroup();
    ToggleGroup group27 = new ToggleGroup();
    ToggleGroup group28 = new ToggleGroup();
    ToggleGroup group29 = new ToggleGroup();
    ToggleGroup group30 = new ToggleGroup();
    ToggleGroup group31 = new ToggleGroup();
    ToggleGroup group32 = new ToggleGroup();
    ToggleGroup group33 = new ToggleGroup();
    ToggleGroup group34 = new ToggleGroup();
    ToggleGroup group35 = new ToggleGroup();
    ToggleGroup group36 = new ToggleGroup();
    ToggleGroup group37 = new ToggleGroup();
    ToggleGroup group38 = new ToggleGroup();
    ToggleGroup group39 = new ToggleGroup();
    ToggleGroup group40 = new ToggleGroup();
    ToggleGroup group41 = new ToggleGroup();

    private void asignarGrupos() {
        rad_eval_inicial.setToggleGroup(group1);
        rad_eval_subsec.setToggleGroup(group1);
        rad_interrogat_directo.setToggleGroup(group2);
        rad_interrogat_indirecto.setToggleGroup(group2);
        combo_act_fis_diaria.setToggleGroup(group3);
        combo_act_fis_semanal.setToggleGroup(group3);
        combo_act_fis_ocasional.setToggleGroup(group3);
        combo_alim_balanceada.setToggleGroup(group4);
        combo_alim_no_balanceada.setToggleGroup(group4);
        combo_aseo_pers_diario.setToggleGroup(group5);
        combo_aseo_pers_semanal.setToggleGroup(group5);
        combo_aseo_pers_cterc.setToggleGroup(group5);
        combo_aseo_bucal_diario.setToggleGroup(group6);
        combo_aseo_bucal_semanal.setToggleGroup(group6);
        combo_aseo_bucal_cterc.setToggleGroup(group6);
        radio_deform_si.setToggleGroup(group7);
        radio_deform_no.setToggleGroup(group7);
        radio_cara_si.setToggleGroup(group8);
        radio_cara_no.setToggleGroup(group8);
        radio_craneo_si.setToggleGroup(group9);
        radio_craneo_no.setToggleGroup(group9);
        radio_cuello_si.setToggleGroup(group10);
        radio_cuello_no.setToggleGroup(group10);
        radio_oid_der_si.setToggleGroup(group11);
        radio_oid_der_no.setToggleGroup(group11);
        radio_oid_izq_si.setToggleGroup(group12);
        radio_oid_izq_no.setToggleGroup(group12);
        radio_vision_si.setToggleGroup(group13);
        radio_vision_no.setToggleGroup(group13);
        radio_reflejos_si.setToggleGroup(group14);
        radio_reflejos_no.setToggleGroup(group14);
        radio_region_precordial_si.setToggleGroup(group15);
        radio_region_precordial_no.setToggleGroup(group15);
        radio_campos_si.setToggleGroup(group16);
        radio_campos_no.setToggleGroup(group16);
        radio_viscer_si.setToggleGroup(group17);
        radio_viscer_no.setToggleGroup(group17);
        radio_hernias_si.setToggleGroup(group18);
        radio_hernias_no.setToggleGroup(group18);
        radio_genit_si.setToggleGroup(group19);
        radio_genit_no.setToggleGroup(group19);
        radio_region_perineal_si.setToggleGroup(group20);
        radio_region_perineal_no.setToggleGroup(group20);
        radio_coord_si.setToggleGroup(group21);
        radio_coord_no.setToggleGroup(group21);
        radio_sensib_si.setToggleGroup(group22);
        radio_sensib_no.setToggleGroup(group22);
        radio_marcha_si.setToggleGroup(group23);
        radio_marcha_no.setToggleGroup(group23);
        radioi_pares_cran_si.setToggleGroup(group24);
        radioi_pares_cran_no.setToggleGroup(group24);
        radio_equilib_si.setToggleGroup(group25);
        radio_equilib_no.setToggleGroup(group25);
        radio_insuf_ven_si.setToggleGroup(group26);
        radio_insuf_ven_no.setToggleGroup(group26);
        radio_ulcer_si.setToggleGroup(group27);
        radio_ulcer_no.setToggleGroup(group27);
        radio_escoliosis_si.setToggleGroup(group28);
        radio_escoliosis_no.setToggleGroup(group28);
        radio_xifosis_si.setToggleGroup(group29);
        radio_xifosis_no.setToggleGroup(group29);
        radio_cicatrices_si.setToggleGroup(group30);
        radio_cicatrices_no.setToggleGroup(group30);
        radio_nevos_si.setToggleGroup(group31);
        radio_nevos_no.setToggleGroup(group31);
        radio_tatuajes_si.setToggleGroup(group32);
        radio_tatuajes_no.setToggleGroup(group32);
        radio_integridad_si.setToggleGroup(group33);
        radio_integridad_no.setToggleGroup(group33);
        radio_fuerzaM_si.setToggleGroup(group34);
        radio_fuerzaM_no.setToggleGroup(group34);
        radio_tono_si.setToggleGroup(group35);
        radio_tono_no.setToggleGroup(group35);
        radio_sensibilidad_si.setToggleGroup(group36);
        radio_sensibilidad_no.setToggleGroup(group36);
        radio_rot_si.setToggleGroup(group37);
        radio_rot_no.setToggleGroup(group37);
        radio_articulaciones_si.setToggleGroup(group38);
        radio_articulaciones_no.setToggleGroup(group38);
        radio_arcos_si.setToggleGroup(group39);
        radio_arcos_no.setToggleGroup(group39);
        radio_discapacidad_si.setToggleGroup(group40);
        radio_discapacidad_no.setToggleGroup(group40);

    }
    //DATOS GENERALES DE NIÑO, NIÑA O ADOLESCENTE
    String nombreVictima = "", apellido1Victima = "", apellido2Victima = "", sexoVictima = "",
            eCivilVictima = "", escolaridad = "", religion = "";
    int evMedica = -1, tipoInterrogatorio = -1, edadVictima = 0;
    String nombreAcomp = "", apellidoAcomp = "", apellido2Acomp = "", relacionMenor = "";
    //ANTECEDENTES PERSONALES NO PATOLOGICOS
    int activFisica = -1, alimentacion = -1, aseoPers = -1, aseoBucal = -1, noAseoBucal = 0, zoonosis = -1;
    String pisoVivienda = "", techoVivienda = "", ventilacionVivienda = "", tipoZoonosis = "",
            inmunizaciones = "", inspeccionGeneral = "";
    //EXPLORACION FISICA PARTE 1 

    double signoTA = 0, signoFC = 0.0, signoFR = 0.0, signoPulso = 0.0, temperatura = 0.0, estatura = 0.0, peso = 0.0,
            IMC = 0.0, ICC = 0.0;
    int cabeza = -1, cara = -1, craneo = -1, cuello = -1, oidoDer = -1, oidoIzq = -1, visionComatica = -1, reflejosOc = -1,
            regionPrecordial = -1, camposPulmo = -1, visceromegalias = -1, hernias = -1, genitourinario = -1, regionPerineal = -1,
            coordinacion = -1, sensibilidadSistNerv = -1, marcha = -1, paresCraneales = -1, equilibrio = -1;
    //EXPLORACION FISICA PARTE 2 
    int insufVen = -1, ulveraciones = -1, escoliosis = -1, xifosis = -1, cicatrices = -1, nevos = -1, tatuajes = -1, integridad = -1,
            fuerzaMusc = -1, tono = -1, sensibilidadExtrem = -1, rot = -1, articulaciones = -1, arcosMov = -1, discapacidad = -1;
    String descripcion = "";
    //OBSERVACIONES
    String observaciones = "";
    //NOTA AGREGADA
    String notaAgregaga = "";
    String fech = "";
    String fechF = "";
    String hora = "";
    String horaF = "";

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Herramientas herramienta = new Herramientas();
        Herramientas fecha = new Herramientas();
        hora = fecha.getHoraActual();
        fech = fecha.obtenerFechaSistema();
        txt_edad_victima = herramienta.validar(txt_edad_victima);
        txt_sexo_victima.getItems().addAll(herramienta.getSexo());
        combo_est_civ_victima.getItems().addAll(herramienta.getEdoCivil());
        combo_escolaridad_victima.getItems().addAll(herramienta.getEscolaridad());
        txt_zoonosis.setDisable(true);
        immc();
        asignarGrupos();

    }

    @FXML
    private void calcularIMMC() {
        //Peso/ Estarura ^2
        double IMMC = peso / (estatura * estatura);
    }

    @FXML
    private void mostrarPaneles(ActionEvent event) {
        if (event.getTarget() == btn_datos_ninio) {
            mostrarPanel(pnl_datos_generales, true, pnl_antecedentes, false,
                    pnl_inspeccion_general, false, pnl_exploracion1, false,
                    pnl_exploracion2, false, pnl_observaciones, false,
                    pnl_nota_agregada, false, pnl_aniadir_archivos, false);
        } else if (event.getTarget() == btn_antecedentes) {
            mostrarPanel(pnl_datos_generales, false, pnl_antecedentes, true,
                    pnl_inspeccion_general, false, pnl_exploracion1, false,
                    pnl_exploracion2, false, pnl_observaciones, false,
                    pnl_nota_agregada, false, pnl_aniadir_archivos, false);
        } else if (event.getTarget() == btn_inspeccion_general) {
            mostrarPanel(pnl_datos_generales, false, pnl_antecedentes, false,
                    pnl_inspeccion_general, true, pnl_exploracion1, false,
                    pnl_exploracion2, false, pnl_observaciones, false,
                    pnl_nota_agregada, false, pnl_aniadir_archivos, false);
        } else if (event.getTarget() == btn_exploracion_1) {
            mostrarPanel(pnl_datos_generales, false, pnl_antecedentes, false,
                    pnl_inspeccion_general, false, pnl_exploracion1, true,
                    pnl_exploracion2, false, pnl_observaciones, false,
                    pnl_nota_agregada, false, pnl_aniadir_archivos, false);
        } else if (event.getTarget() == btn_exploracion_2) {
            mostrarPanel(pnl_datos_generales, false, pnl_antecedentes, false,
                    pnl_inspeccion_general, false, pnl_exploracion1, false,
                    pnl_exploracion2, true, pnl_observaciones, false,
                    pnl_nota_agregada, false, pnl_aniadir_archivos, false);
        } else if (event.getTarget() == btn_observaciones) {
            mostrarPanel(pnl_datos_generales, false, pnl_antecedentes, false,
                    pnl_inspeccion_general, false, pnl_exploracion1, false,
                    pnl_exploracion2, false, pnl_observaciones, true,
                    pnl_nota_agregada, false, pnl_aniadir_archivos, false);
        } else if (event.getTarget() == btn_nota_agregada) {
            mostrarPanel(pnl_datos_generales, false, pnl_antecedentes, false,
                    pnl_inspeccion_general, false, pnl_exploracion1, false,
                    pnl_exploracion2, false, pnl_observaciones, false,
                    pnl_nota_agregada, true, pnl_aniadir_archivos, false);
        } else if (event.getTarget() == btn_aniadir_archivos) {
            mostrarPanel(pnl_datos_generales, false, pnl_antecedentes, false,
                    pnl_inspeccion_general, false, pnl_exploracion1, false,
                    pnl_exploracion2, false, pnl_observaciones, false,
                    pnl_nota_agregada, false, pnl_aniadir_archivos, true);
        }
    }

    //METODO QUE MUESTRA EL PANEL CORRESPONDIENDE AL BOTON SELECCIONADO
    public void mostrarPanel(Pane pnl1, Boolean bl1, Pane pnl2, Boolean bl2, Pane pnl3, Boolean bl3,
            Pane pnl4, Boolean bl4, Pane pnl5, Boolean bl5, Pane pnl6, Boolean bl6,
            Pane pnl7, Boolean bl7, Pane pnl8, Boolean bl8) {
        pnl1.setVisible(bl1);
        pnl2.setVisible(bl2);
        pnl3.setVisible(bl3);
        pnl4.setVisible(bl4);
        pnl5.setVisible(bl5);
        pnl6.setVisible(bl6);
        pnl7.setVisible(bl7);
        pnl8.setVisible(bl8);

    }

    public void obtenerDatos() {

        //Datos Generales Niñ@
        nombreVictima = txt_nombre_victima.getText();
        apellido1Victima = txt_apellido_pat_victima.getText();
        apellido2Victima = txt_apellido_mat_victima.getText();
        nombreAcomp = txt_nombre_acompaniante.getText();
        apellidoAcomp = txt_apell_pat_acompaniante.getText();
        apellido2Acomp = txt_apell_mat_acompaniante.getText();
        relacionMenor = txt_relacion_acompaniante.getText();
        int valor;
        valor = txt_edad_victima.getText().equals("") ? 0 : Integer.parseInt(txt_edad_victima.getText());
        edadVictima = (valor);
        sexoVictima = (String) txt_sexo_victima.getValue();
        eCivilVictima = (String) combo_est_civ_victima.getValue();
        escolaridad = (String) combo_escolaridad_victima.getValue();
        religion = (String) txt_religion_victima.getText();
        evMedica = (rad_eval_inicial.isSelected()) ? 1 : 0;
        tipoInterrogatorio = (rad_interrogat_directo.isSelected()) ? 1 : 0;
        //Antecedentes Personales
        //Diario=0 Semanal=1 Ocacional=2
        activFisica = (combo_act_fis_diaria.isSelected()) ? 0 : 1;
        if (activFisica != 0) {
            activFisica = (combo_act_fis_semanal.isSelected()) ? 1 : 2;
        }

        //Blanceada=1 NoB=0
        alimentacion = (combo_alim_balanceada.isSelected()) ? 1 : 0;

        //Diario=0 Cterce=1 Semanal=2
        aseoPers = (combo_aseo_pers_diario.isSelected()) ? 0 : 1;
        if (aseoPers != 0) {
            aseoPers = (combo_aseo_pers_cterc.isSelected()) ? 1 : 2;
        }

        aseoBucal = (combo_aseo_bucal_diario.isSelected()) ? 0 : 1;
        if (aseoBucal != 0) {
            aseoBucal = (combo_aseo_bucal_semanal.isSelected()) ? 1 : 2;
        }
        valor = txt_aseo_veces.getText().equals("") ? 0 : Integer.parseInt(txt_aseo_veces.getText());
        noAseoBucal = (valor);
        pisoVivienda = txt_piso_vivienda.getText();
        techoVivienda = txt_techo_vivienda.getText();
        ventilacionVivienda = txt_ventilacion_vivienda.getText();
        zoonosis = (check_zoonosis.isSelected()) ? 1 : 0;
        tipoZoonosis = txt_zoonosis.getText();
        inmunizaciones = txtArea_inmunizaciones.getText();
        inspeccionGeneral = txtArea_inspeccion_general.getText();

        //IV EXPLORACION FISICA
        valor = txt_TA.getText().equals("") ? 0 : Integer.parseInt(txt_TA.getText());
        signoTA = (valor);
        valor = txt_FC.getText().equals("") ? 0 : Integer.parseInt(txt_FC.getText());
        signoFC = (valor);
        valor = txt_FR.getText().equals("") ? 0 : Integer.parseInt(txt_FR.getText());
        signoFR = (valor);
        valor = txt_pulso.getText().equals("") ? 0 : Integer.parseInt(txt_pulso.getText());
        signoPulso = (valor);
        valor = txt_temperatura.getText().equals("") ? 0 : Integer.parseInt(txt_temperatura.getText());
        temperatura = (valor);
        valor = txt_estatura.getText().equals("") ? 0 : Integer.parseInt(txt_estatura.getText());
        estatura = (valor);
        valor = txt_peso.getText().equals("") ? 0 : Integer.parseInt(txt_peso.getText());
        peso = (valor);
        valor = txt_IMC.getText().equals("") ? 0 : Integer.parseInt(txt_IMC.getText());
        IMC = (valor);
        valor = txt_ICC.getText().equals("") ? 0 : Integer.parseInt(txt_ICC.getText());
        ICC = (valor);
        cabeza = (radio_deform_si.isSelected()) ? 1 : 0;
        cara = (radio_cara_si.isSelected()) ? 1 : 0;
        craneo = (radio_craneo_si.isSelected()) ? 1 : 0;
        cuello = (radio_cuello_si.isSelected()) ? 1 : 0;
        oidoDer = (radio_oid_der_si.isSelected()) ? 1 : 0;
        oidoIzq = (radio_oid_izq_si.isSelected()) ? 1 : 0;
        visionComatica = (radio_vision_si.isSelected()) ? 1 : 0;
        reflejosOc = (radio_reflejos_si.isSelected()) ? 1 : 0;
        regionPrecordial = (radio_region_precordial_si.isSelected()) ? 1 : 0;
        camposPulmo = (radio_campos_si.isSelected()) ? 1 : 0;
        visceromegalias = (radio_viscer_si.isSelected()) ? 1 : 0;
        hernias = (radio_hernias_si.isSelected()) ? 1 : 0;
        genitourinario = (radio_genit_si.isSelected()) ? 1 : 0;
        regionPerineal = (radio_region_perineal_si.isSelected()) ? 1 : 0;
        coordinacion = (radio_coord_si.isSelected()) ? 1 : 0;
        sensibilidadSistNerv = (radio_sensib_si.isSelected()) ? 1 : 0;
        marcha = (radio_marcha_si.isSelected()) ? 1 : 0;
        paresCraneales = (radioi_pares_cran_si.isSelected()) ? 1 : 0;
        equilibrio = (radio_equilib_si.isSelected()) ? 1 : 0;

        //IV EXPLORACION FISICA II
        insufVen = (radio_insuf_ven_si.isSelected()) ? 1 : 0;
        ulveraciones = (radio_ulcer_si.isSelected()) ? 1 : 0;
        escoliosis = (radio_escoliosis_si.isSelected()) ? 1 : 0;
        xifosis = (radio_xifosis_si.isSelected()) ? 1 : 0;
        cicatrices = (radio_cicatrices_si.isSelected()) ? 1 : 0;
        descripcion = txtArea_descripcion_piel.getText();
        nevos = (radio_nevos_si.isSelected()) ? 1 : 0;
        tatuajes = (radio_tatuajes_si.isSelected()) ? 1 : 0;
        integridad = (radio_integridad_si.isSelected()) ? 1 : 0;
        fuerzaMusc = (radio_fuerzaM_si.isSelected()) ? 1 : 0;
        tono = (radio_tono_si.isSelected()) ? 1 : 0;
        sensibilidadExtrem = (radio_sensibilidad_si.isSelected()) ? 1 : 0;
        rot = (radio_rot_si.isSelected()) ? 1 : 0;
        articulaciones = (radio_articulaciones_si.isSelected()) ? 1 : 0;
        arcosMov = (radio_arcos_si.isSelected()) ? 1 : 0;
        discapacidad = (radio_discapacidad_si.isSelected()) ? 1 : 0;

        //Observacioes
        observaciones = txtArea_observaciones_2.getText();
        notaAgregaga = txtArea_nota_agregada.getText();

    }

    void limpiar() {
        txt_nombre_victima.setText("");
        txt_apellido_pat_victima.setText("");
        txt_apellido_mat_victima.setText("");
        txt_nombre_acompaniante.setText("");
        txt_apell_pat_acompaniante.setText("");
        txt_apell_mat_acompaniante.setText("");
        txt_relacion_acompaniante.setText("");
        txt_edad_victima.setText("");
        txt_sexo_victima.setValue("");
        combo_est_civ_victima.setValue("");
        combo_escolaridad_victima.setValue("");
        txt_religion_victima.setText("");
        rad_eval_inicial.setSelected(false);
        rad_eval_subsec.setSelected(false);
        rad_interrogat_directo.setSelected(false);
        rad_interrogat_indirecto.setSelected(false);
        combo_act_fis_diaria.setSelected(false);
        combo_act_fis_semanal.setSelected(false);
        combo_act_fis_ocasional.setSelected(false);
        combo_alim_balanceada.setSelected(false);
        combo_alim_no_balanceada.setSelected(false);
        combo_aseo_pers_diario.setSelected(false);
        combo_aseo_pers_cterc.setSelected(false);
        combo_aseo_pers_semanal.setSelected(false);
        combo_aseo_bucal_diario.setSelected(false);
        combo_aseo_bucal_semanal.setSelected(false);
        combo_aseo_bucal_cterc.setSelected(false);
        txt_aseo_veces.setText("");
        txt_piso_vivienda.setText("");
        txt_techo_vivienda.setText("");
        txt_ventilacion_vivienda.setText("");
        check_zoonosis.setSelected(false);
        txt_zoonosis.setText("");
        txtArea_inmunizaciones.setText("");
        txtArea_inspeccion_general.setText("");
        txt_TA.setText("");
        txt_FC.setText("");
        txt_FR.setText("");
        txt_pulso.setText("");
        txt_temperatura.setText("");
        txt_estatura.setText("");
        txt_peso.setText("");
        txt_IMC.setText("");
        txt_ICC.setText("");
        radio_deform_si.setSelected(false);
        radio_cara_si.setSelected(false);
        radio_craneo_si.setSelected(false);
        radio_cuello_si.setSelected(false);
        radio_oid_der_si.setSelected(false);
        radio_oid_izq_si.setSelected(false);
        radio_vision_si.setSelected(false);
        radio_reflejos_si.setSelected(false);
        radio_deform_no.setSelected(false);
        radio_cara_no.setSelected(false);
        radio_craneo_no.setSelected(false);
        radio_cuello_no.setSelected(false);
        radio_oid_der_no.setSelected(false);
        radio_oid_izq_no.setSelected(false);
        radio_vision_no.setSelected(false);
        radio_reflejos_no.setSelected(false);
        radio_region_precordial_si.setSelected(false);
        radio_campos_si.setSelected(false);
        radio_viscer_si.setSelected(false);
        radio_hernias_si.setSelected(false);
        radio_genit_si.setSelected(false);
        radio_region_perineal_si.setSelected(false);
        radio_coord_si.setSelected(false);
        radio_sensib_si.setSelected(false);
        radio_marcha_si.setSelected(false);
        radioi_pares_cran_si.setSelected(false);
        radio_equilib_si.setSelected(false);
        radio_insuf_ven_si.setSelected(false);
        radio_ulcer_si.setSelected(false);
        radio_escoliosis_si.setSelected(false);
        radio_xifosis_si.setSelected(false);
        radio_cicatrices_si.setSelected(false);
        radio_region_precordial_no.setSelected(false);
        radio_campos_no.setSelected(false);
        radio_viscer_no.setSelected(false);
        radio_hernias_no.setSelected(false);
        radio_genit_no.setSelected(false);
        radio_region_perineal_no.setSelected(false);
        radio_coord_no.setSelected(false);
        radio_sensib_no.setSelected(false);
        radio_marcha_no.setSelected(false);
        radioi_pares_cran_no.setSelected(false);
        radio_equilib_no.setSelected(false);
        radio_insuf_ven_no.setSelected(false);
        radio_ulcer_no.setSelected(false);
        radio_escoliosis_no.setSelected(false);
        radio_xifosis_no.setSelected(false);
        radio_cicatrices_no.setSelected(false);
        txtArea_descripcion_piel.setText("");
        radio_nevos_si.setSelected(false);
        radio_tatuajes_si.setSelected(false);
        radio_integridad_si.setSelected(false);
        radio_fuerzaM_si.setSelected(false);
        radio_tono_si.setSelected(false);
        radio_sensibilidad_si.setSelected(false);
        radio_rot_si.setSelected(false);
        radio_articulaciones_si.setSelected(false);
        radio_arcos_si.setSelected(false);
        radio_discapacidad_si.setSelected(false);
        radio_nevos_no.setSelected(false);
        radio_tatuajes_no.setSelected(false);
        radio_integridad_no.setSelected(false);
        radio_fuerzaM_no.setSelected(false);
        radio_tono_no.setSelected(false);
        radio_sensibilidad_no.setSelected(false);
        radio_rot_no.setSelected(false);
        radio_articulaciones_no.setSelected(false);
        radio_arcos_no.setSelected(false);
        radio_discapacidad_no.setSelected(false);
        txtArea_observaciones_2.setText("");
        txtArea_nota_agregada.setText("");
        txt_zoonosis.setDisable(true);
    }

    @FXML
    void terminarEnviarFormato(ActionEvent event) {
        System.out.println("Entra");

        agregarEvaluacion();

        System.out.println("Evaluacion creado");
        limpiar();
        System.out.println("Limpio");
    }

    void agregarEvaluacion() {

        EvaluacionMedico usuarioAgregar = new EvaluacionMedico();
        Herramientas herra = new Herramientas();
        horaF = herra.getHoraActual();
        fechF = herra.obtenerFechaSistema();
        Conexion conexion = new Conexion();
        System.out.println("Conexion creadad");
        int zoo = (check_zoonosis.isSelected()) ? 1 : 0;

       //-SelectPeticionesMedicio--------ExploracionFisicaMedica
        
       
        usuarioAgregar.agregarEvaluacionMedico(conexion.cadena_conexion(), "DIF/PPNNA-002/2018", 1, fech, hora, fechF, horaF, 1, 1, 1, nombreVictima, apellido1Victima, apellido2Victima, "Fecha nacimiento", sexoVictima, eCivilVictima, escolaridad, religion, evMedica, tipoInterrogatorio, nombreAcomp, apellidoAcomp, apellido2Acomp, relacionMenor, activFisica, alimentacion, aseoPers, aseoBucal, noAseoBucal, pisoVivienda, techoVivienda, ventilacionVivienda, String.valueOf(zoo), tipoZoonosis, inmunizaciones, inspeccionGeneral, 1);
        System.out.println("Sujeto agregado");
        int idEvaluacionMed  = usuarioAgregar.seleccionarUltimoEvaluacion_medico(conexion.cadena_conexion());
        usuarioAgregar.agregarExploracionFisicaMedica(conexion.cadena_conexion(), idEvaluacionMed,  /*"id_medico*/1, signoTA, signoFC, signoFR, signoPulso, temperatura, estatura, peso, ICC, cabeza, craneo, evMedica, cuello, observaciones, oidoDer, oidoIzq,/*"este nose pero es "Vision_cron"*/ alimentacion, reflejosOc, regionPerineal, camposPulmo, visceromegalias, hernias, genitourinario, regionPerineal, coordinacion, sensibilidadExtrem, marcha, paresCraneales, equilibrio, insufVen, ulveraciones, escoliosis, xifosis, cicatrices, descripcion, nevos, tatuajes, integridad, fuerzaMusc, tono, sensibilidadExtrem, rot, articulaciones, arcosMov, discapacidad, observaciones, notaAgregaga, inmunizaciones);
    }

    
    @FXML
    void guardarSoloCambiosFormato(ActionEvent event) {
        obtenerDatos();
        limpiar();
        System.out.println("debug{" + "nombreVictima=" + nombreVictima + ", apellido1Victima=" + apellido1Victima + ", apellido2Victima=" + apellido2Victima + "\n, sexoVictima=" + sexoVictima + ", eCivilVictima=" + eCivilVictima + ", escolaridad=" + escolaridad + "\n, religion=" + religion + ", evMedica=" + evMedica + ", tipoInterrogatorio=" + tipoInterrogatorio + "\n, edadVictima=" + edadVictima + ", nombreAcomp=" + nombreAcomp + ", apellidoAcomp=" + apellidoAcomp + ", apellido2Acomp=" + apellido2Acomp + "\n, relacionMenor=" + relacionMenor + ", activFisica=" + activFisica + ", alimentacion=" + alimentacion + ", aseoPers=" + aseoPers + "\n, aseoBucal=" + aseoBucal + ", noAseoBucal=" + noAseoBucal + ", pisoVivienda=" + pisoVivienda + "\n, techoVivienda=" + techoVivienda + ", ventilacionVivienda=" + ventilacionVivienda + ", tipoZoonosis=" + tipoZoonosis + "\n, inmunizaciones=" + inmunizaciones + ", inspeccionGeneral=" + inspeccionGeneral + ", zoonosis=" + zoonosis + "\n, signoTA=" + signoTA + ", signoFC=" + signoFC + ", signoFR=" + signoFR + ", signoPulso=" + signoPulso + ", temperatura=" + temperatura + ", estatura=" + estatura + ", peso=" + peso + ", IMC=" + IMC + ", ICC=" + ICC + "\n, cabeza=" + cabeza + ", cara=" + cara + ", craneo=" + craneo + ", cuello=" + cuello + ", oidoDer=" + oidoDer + ", oidoIzq=" + oidoIzq + "\n, visionComatica=" + visionComatica + ", reflejosOc=" + reflejosOc + ", regionPrecordial=" + regionPrecordial + ", camposPulmo=" + camposPulmo + "\n, visceromegalias=" + visceromegalias + ", hernias=" + hernias + ", genitourinario=" + genitourinario + ", regionPerineal=" + regionPerineal + ", coordinacion=" + coordinacion + "\n, sensibilidadSistNerv=" + sensibilidadSistNerv + ", marcha=" + marcha + ", paresCraneales=" + paresCraneales + ", equilibrio=" + equilibrio + "\n, insufVen=" + insufVen + ", ulveraciones=" + ulveraciones + ", escoliosis=" + escoliosis + ", xifosis=" + xifosis + "\n, cicatrices=" + cicatrices + ", nevos=" + nevos + ", tatuajes=" + tatuajes + ", integridad=" + integridad + ", fuerzaMusc=" + fuerzaMusc + "\n, tono=" + tono + ", sensibilidadExtrem=" + sensibilidadExtrem + ", rot=" + rot + ", articulaciones=" + articulaciones + "\n, arcosMov=" + arcosMov + ", discapacidad=" + discapacidad + ", descripcion=" + descripcion + ", observaciones=" + observaciones + "\n, notaAgregaga=" + notaAgregaga + '}');

    }
    
    @FXML
    private void check(ActionEvent event) {
        if (check_zoonosis.isSelected() == true) {
            txt_zoonosis.setDisable(false);
        } else {
            txt_zoonosis.setDisable(true);
        }
    }
    @FXML
    private JFXButton btn_observaciones;

    @FXML
    private JFXRadioButton radio_escoliosis_no;

    @FXML
    private JFXRadioButton radio_hernias_no;

    @FXML
    private JFXRadioButton radio_oid_der_si;

    @FXML
    private JFXRadioButton radioi_pares_cran_si;

    @FXML
    private JFXRadioButton rad_eval_inicial;

    @FXML
    private JFXRadioButton radio_nevos_si;

    @FXML
    private JFXButton btn_solo_guardar;

    @FXML
    private JFXRadioButton radio_xifosis_si;

    @FXML
    private JFXRadioButton radio_campos_si;

    @FXML
    private JFXRadioButton radio_cuello_no;

    @FXML
    private JFXRadioButton radio_oid_izq_no;

    @FXML
    private JFXRadioButton radio_region_perineal_no;

    @FXML
    private JFXComboBox<String> combo_est_civ_victima;

    @FXML
    private JFXRadioButton radio_reflejos_si;

    @FXML
    private JFXTextField txt_piso_vivienda;

    @FXML
    private JFXRadioButton radio_tatuajes_no;

    @FXML
    private JFXTextField txt_apell_mat_acompaniante;

    @FXML
    private JFXRadioButton combo_act_fis_ocasional;

    @FXML
    private JFXRadioButton radio_integridad_no;

    @FXML
    private JFXRadioButton radio_sensib_si;

    @FXML
    private Pane pnl_observaciones;

    @FXML
    private JFXRadioButton radio_cicatrices_no;

    @FXML
    private JFXTextField txt_FC;

    @FXML
    private JFXRadioButton radio_vision_no;

    @FXML
    private JFXRadioButton radio_genit_no;

    @FXML
    private JFXRadioButton radio_sensibilidad_no;

    @FXML
    private JFXRadioButton radio_region_precordial_si;

    @FXML
    private JFXRadioButton radio_discapacidad_si;

    @FXML
    private JFXButton btn_exploracion_1;

    @FXML
    private JFXButton btn_exploracion_2;

    @FXML
    private JFXTextField txt_FR;

    @FXML
    private JFXRadioButton radio_insuf_ven_si;

    @FXML
    private JFXRadioButton radio_coord_si;

    @FXML
    private JFXRadioButton radio_articulaciones_no;

    @FXML
    private JFXButton btn_terminar_enviar;

    @FXML
    private TextArea txtArea_descripcion_piel;

    @FXML
    private Pane pnl_datos_generales;

    @FXML
    private Label lbl_folio;

    @FXML
    private JFXRadioButton radio_fuerzaM_si;

    @FXML
    private JFXTextField txt_apell_pat_acompaniante;

    @FXML
    private JFXRadioButton radio_discapacidad_no;

    @FXML
    private JFXRadioButton radio_integridad_si;

    @FXML
    private JFXTextField txt_pulso;

    @FXML
    private JFXRadioButton combo_alim_balanceada;

    @FXML
    private JFXRadioButton radio_deform_no;

    @FXML
    private JFXCheckBox check_zoonosis;

    @FXML
    private JFXRadioButton combo_aseo_pers_semanal;

    @FXML
    private Pane pnl_nota_agregada;

    @FXML
    private JFXRadioButton radio_ulcer_si;

    @FXML
    private JFXTextField txt_estatura;

    @FXML
    private JFXRadioButton radio_sensibilidad_si;

    @FXML
    private JFXRadioButton radio_arcos_no;

    @FXML
    private TextArea txtArea_observaciones_2;

    @FXML
    private JFXTextField txt_TA;

    @FXML
    private JFXButton btn_antecedentes;

    @FXML
    private JFXComboBox<String> txt_sexo_victima;

    @FXML
    private JFXRadioButton combo_act_fis_diaria;

    @FXML
    private JFXTextField txt_ventilacion_vivienda;

    @FXML
    private JFXRadioButton combo_aseo_bucal_semanal;

    @FXML
    private JFXRadioButton combo_alim_no_balanceada;

    @FXML
    private JFXRadioButton radio_craneo_no;

    @FXML
    private JFXRadioButton radio_equilib_si;

    @FXML
    private JFXRadioButton radio_marcha_si;

    @FXML
    private JFXRadioButton rad_interrogat_indirecto;

    @FXML
    private JFXRadioButton radio_tono_no;

    @FXML
    private JFXRadioButton rad_interrogat_directo;

    @FXML
    private JFXTextField txt_apellido_pat_victima;

    @FXML
    private JFXTextField txt_aseo_veces;

    @FXML
    private JFXRadioButton radio_xifosis_no;

    @FXML
    private JFXRadioButton combo_aseo_pers_diario;

    @FXML
    private JFXTextField txt_religion_victima;

    @FXML
    private JFXRadioButton radio_cuello_si;

    @FXML
    private JFXTextField txt_apellido_mat_victima;

    @FXML
    private JFXRadioButton radio_coord_no;

    @FXML
    private TextArea txtArea_inmunizaciones;

    @FXML
    private JFXRadioButton radioi_pares_cran_no;

    @FXML
    private JFXTextField txt_nombre_acompaniante;

    @FXML
    private JFXRadioButton radio_articulaciones_si;

    @FXML
    private JFXRadioButton radio_hernias_si;

    @FXML
    private JFXRadioButton radio_cicatrices_si;

    @FXML
    private JFXTextField txt_edad_victima;

    @FXML
    private JFXRadioButton combo_aseo_bucal_cterc;

    @FXML
    private JFXRadioButton radio_equilib_no;

    @FXML
    private JFXTextField txt_relacion_acompaniante;

    @FXML
    private JFXRadioButton radio_oid_der_no;

    @FXML
    private JFXRadioButton radio_nevos_no;

    @FXML
    private JFXRadioButton radio_rot_no;

    @FXML
    private JFXButton btn_nota_agregada;

    @FXML
    private JFXRadioButton radio_campos_no;

    @FXML
    private JFXRadioButton radio_insuf_ven_no;

    @FXML
    private JFXRadioButton radio_genit_si;

    @FXML
    private JFXButton btn_aniadir_archivos;

    @FXML
    private Pane pnl_exploracion1;

    @FXML
    private JFXRadioButton radio_deform_si;

    @FXML
    private Pane pnl_exploracion2;

    @FXML
    private JFXRadioButton radio_reflejos_no;

    @FXML
    private JFXRadioButton radio_oid_izq_si;

    @FXML
    private JFXRadioButton radio_region_precordial_no;

    @FXML
    private JFXRadioButton radio_arcos_si;

    @FXML
    private JFXRadioButton radio_cara_no;

    @FXML
    private JFXRadioButton combo_aseo_bucal_diario;

    @FXML
    private Pane pnl_inspeccion_general;

    @FXML
    private JFXRadioButton radio_region_perineal_si;

    @FXML
    private JFXRadioButton combo_aseo_pers_cterc;

    @FXML
    private JFXRadioButton radio_escoliosis_si;

    @FXML
    private JFXRadioButton radio_ulcer_no;

    @FXML
    private JFXTextField txt_ICC;

    @FXML
    private JFXRadioButton radio_viscer_si;

    @FXML
    private JFXButton btn_inspeccion_general;

    @FXML
    private JFXRadioButton radio_sensib_no;

    @FXML
    private TextArea txtArea_nota_agregada;

    @FXML
    private JFXRadioButton rad_eval_subsec;

    @FXML
    private JFXRadioButton radio_craneo_si;

    @FXML
    private JFXRadioButton radio_vision_si;

    @FXML
    private Pane pnl_aniadir_archivos;

    @FXML
    private Pane pnl_antecedentes;

    @FXML
    private TextArea txtArea_observaciones_fisica;

    @FXML
    private JFXRadioButton radio_viscer_no;

    @FXML
    private JFXRadioButton combo_act_fis_semanal;

    @FXML
    private JFXTextField txt_peso;

    @FXML
    private JFXTextField txt_nombre_victima;

    @FXML
    private JFXRadioButton radio_cara_si;

    @FXML
    private TextArea txtArea_inspeccion_general;

    @FXML
    private JFXRadioButton radio_marcha_no;

    @FXML
    private JFXRadioButton radio_tatuajes_si;

    @FXML
    private JFXButton btn_datos_ninio;

    @FXML
    private JFXComboBox<String> combo_escolaridad_victima;

    @FXML
    private JFXRadioButton radio_tono_si;

    @FXML
    private JFXRadioButton radio_rot_si;

    @FXML
    private JFXTextField txt_techo_vivienda;

    @FXML
    private JFXRadioButton radio_fuerzaM_no;

    @FXML
    private JFXTextField txt_IMC;

    @FXML
    private JFXTextField txt_temperatura;

    @FXML
    private JFXTextField txt_zoonosis;

    private void immc() {
        txt_peso = realizarSumaEgresos(txt_peso);
        txt_estatura = realizarSumaEgresos(txt_estatura);
        txt_IMC.setEditable(false);

    }
    double IMMC;

    private JFXTextField realizarSumaEgresos(JFXTextField variables) {
        variables.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                char car = event.getCharacter().charAt(0);
                if (Character.isLetter(car) /*&& Character.isSpaceChar(car)*/) {
                    event.consume();
                } else {
                    try {

                        double pes = 0;
                        double est = 0;

                        if (!txt_peso.getText().equals("")) {
                            pes = Double.parseDouble(txt_peso.getText());
                        }
                        if (!txt_estatura.getText().equals("")) {
                            est = Double.parseDouble(txt_estatura.getText());
                        }

                        IMMC = pes / (est * est);

                        txt_IMC.setText("" + IMMC);
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                }
            }
        });
        return variables;
    }
}
