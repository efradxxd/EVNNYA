/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evnnya_psic;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Pattern;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextFormatter;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author lucia
 */
public class FXMLFormatoPsicController implements Initializable {
    //VARIABLES DEL LOGIN
    int id_usuario_inicio_sesion = 1;
    
    
    String numero_expediente; 
    int numero_psicologo;
    String fecha_evaluacion;
    String hora_evaluacion;
    String fecha_alta;
    String hora_alta;
    int id_victima;
    int id_custodia;
    int id_agresor;
    String nombres_paciente;
    String apellido_paterno_paciente;
    String apellido_materno_paciente;
    String fecha_nacimiento;
    String lugar_nacimiento;
    String nacionalidad;
    String sexo;
    String escolaridad;
    String religion;
    String estado_civil;
    String discapacidad;
    String idioma;
    String grupo_etnico;
    int id_direccion;
    String restricciones_evaluaciones;
    String motivo_evaluacion;
    String tecnicas_utilizadas;
    String tecnicas_utilizadas_otras;
    String material_psicopedagogico;
    String material_psicopedagogico_otro;
    String Religion;
    String Calle;
    String Numero;
    String Colonia;
    String CodigoPos;
    String Municipio;
    
    
    
   
    
    //VARIABLES INTERNAS
    String regex = "10|[1-9]";
    
     @FXML
    private void mostrarPaneles(ActionEvent event) {
        if(event.getTarget() == btnDatosGenerales)
             mostrarPanel(pnlDatosGenerales, true, pnlEvaluacion, false, pnlMotivo, false, pnlApariencia, false, 
                                                    pnlSocializacion, false, pnlMemoria,false, 
                                                    pnlAfecto, false, pnlResultados, false);
        else if(event.getTarget() == btnEvaluacion)
             mostrarPanel(pnlDatosGenerales, false, pnlEvaluacion, true, pnlMotivo, false, pnlApariencia, false, 
                                                    pnlSocializacion, false, pnlMemoria,false, 
                                                    pnlAfecto, false, pnlResultados, false);
        else if(event.getTarget() == btnMotivo)
             mostrarPanel(pnlDatosGenerales, false, pnlEvaluacion, false, pnlMotivo, true, pnlApariencia, false, 
                                                    pnlSocializacion, false, pnlMemoria,false, 
                                                    pnlAfecto, false, pnlResultados, false);
        else if(event.getTarget() == btnApariencia)
             mostrarPanel(pnlDatosGenerales, false, pnlEvaluacion, false, pnlMotivo, false, pnlApariencia, true, 
                                                    pnlSocializacion, false, pnlMemoria,false, 
                                                    pnlAfecto, false, pnlResultados, false);
        else if(event.getTarget() == btnSocializacion)
             mostrarPanel(pnlDatosGenerales, false, pnlEvaluacion, false, pnlMotivo, false, pnlApariencia, false, 
                                                    pnlSocializacion, true, pnlMemoria,false, 
                                                    pnlAfecto, false, pnlResultados, false);
        else if(event.getTarget() == btnMemoria)
             mostrarPanel(pnlDatosGenerales, false, pnlEvaluacion, false, pnlMotivo, false, pnlApariencia, false, 
                                                    pnlSocializacion, false, pnlMemoria,true, 
                                                    pnlAfecto, false, pnlResultados, false);
        else if(event.getTarget() == btnAfecto)
             mostrarPanel(pnlDatosGenerales, false, pnlEvaluacion, false, pnlMotivo, false, pnlApariencia, false, 
                                                    pnlSocializacion, false, pnlMemoria,false, 
                                                    pnlAfecto, true, pnlResultados, false);
        else if(event.getTarget() == btnResultados)
             mostrarPanel(pnlDatosGenerales, false, pnlEvaluacion, false, pnlMotivo, false, pnlApariencia, false, 
                                                    pnlSocializacion, false, pnlMemoria,false, 
                                                    pnlAfecto, false, pnlResultados, true);
      
    }
    
    @FXML
    private void escribirSoloNumeros(java.awt.event.KeyEvent evt) {                                         
        char car = evt.getKeyChar();
        if((car<'0' || car>'9') && (car<',' || car>'.')) evt.consume();
        
    }    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        //FORMATEO DE JTEXTFIELD
        txtCodigoPostal.setOnKeyTyped(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                
                char car = event.getCharacter().charAt(0);
                if (Character.isLetter(car)) {
                    event.consume();
                }
                
            }
        });
        
        //RELLENAR COMBOBOX
        ObservableList items_genero = FXCollections.observableArrayList();
        items_genero.addAll("HOMBRE","MUJER");
        comboGénero.getItems().clear();
        comboGénero.setItems(items_genero);
        
        ObservableList items_lugar_nacimiento = FXCollections.observableArrayList();
        items_lugar_nacimiento.addAll("OTRO","Coneto de Comonfort","Cuencamé" ,
                                        "Victoria de Durango","El Oro","Gómez Palacio",
                                        "Gral. Simón Boívar","Guadalupe Victoria","Guanaceví",
                                        "Hidalgo","Indé","Lerdo","Mapimí","Mezquital","Nazas",
                                        "Nombre de Dios","Nuevo Ideal","Ocampo","Otáez",
                                        "Pánuco de Coronado","Peñón Blanco","Poanas","Pueblo Nuevo",
                                        "Rodeo","San Bernardo","San Dimas","San Juan de Guadalupe",
                                        "San Juan del Río","San Luis del Cordero","San Pedro del Gallo",
                                        "Santa Clara","Santiago Papasquiaro","Súchil","Tamazula","Tepehuanes",
                                        "Tlahualilo","Topia","Vicente Guerrero");
        comboLugarNac.getItems().clear();
        comboLugarNac.setItems(items_lugar_nacimiento);
        
        ObservableList items_estado_civil = FXCollections.observableArrayList();
        items_estado_civil.addAll("CASADO","UNION LIBRE","SOLTERO","HIJOS");
        comboEstadoCivil.getItems().clear();
        comboEstadoCivil.setItems(items_estado_civil);
        
        txtMunicipio.getItems().clear();
        txtMunicipio.setItems(items_lugar_nacimiento);
        
    }    
    
    //METODO QUE MUESTRA EL PANEL CORRESPONDIENDE AL BOTON SELECCIONADO
    public void mostrarPanel(Pane pnl1, Boolean bl1, Pane pnl2, Boolean bl2, Pane pnl3, Boolean bl3,
                            Pane pnl4, Boolean bl4, Pane pnl5, Boolean bl5, Pane pnl6, Boolean bl6,
                            Pane pnl7, Boolean bl7, Pane pnl8, Boolean bl8){
        pnl1.setVisible(bl1);
        pnl2.setVisible(bl2);
        pnl3.setVisible(bl3);
        pnl4.setVisible(bl4);
        pnl5.setVisible(bl5);
        pnl6.setVisible(bl6);
        pnl7.setVisible(bl7);
        pnl8.setVisible(bl8);
        
    }
    
    @FXML
    private void handleFinalizarReporte(ActionEvent event) {
      
         numero_expediente = txtReporteNo.getText();
     numero_psicologo = id_usuario_inicio_sesion;
     fecha_evaluacion = String.valueOf(Fechaevaluacion.getValue());
    
     nombres_paciente = txtNombreNinia.getText();
     apellido_paterno_paciente = txtApellidoMaternoNinia.getText();
     apellido_materno_paciente = txtApellidoMaternoNinia.getText();
     fecha_nacimiento = String.valueOf(dateNacimientoNinio.getValue());
     lugar_nacimiento = String.valueOf(comboLugarNac.getValue());
     nacionalidad = txtNacionalidad.getText();
     sexo = String.valueOf(comboGénero.getValue());
     escolaridad = txtEscolaridad.getText();
     religion = txtReligion.getText();
     estado_civil = String.valueOf(comboEstadoCivil.getValue());
     discapacidad = txtCualDiscapacidad.getText();
     idioma = txtIdioma.getText();
     grupo_etnico = txtGrupoEtnico.getText();
     Religion = txtReligion.getText();
     Calle = txtCalle.getText();
     Numero = txtNumero.getText();
     Colonia = txtColonia.getText();
     CodigoPos = txtCodigoPostal.getText();
     Municipio = String.valueOf(txtMunicipio.getValue());
    }
    
      @FXML
    private TextArea areaHabla;

    @FXML
    private TextArea areaConclusiones;

    @FXML
    private JFXCheckBox checkDiscapacidadNo;

    @FXML
    private TextArea areaPensamiento;

    @FXML
    private Pane pnlAfecto;

    @FXML
    private JFXTextField txtReligion;

    @FXML
    private JFXTextField txtNacionalidad;

    @FXML
    private JFXTextField txtCualDiscapacidad;

    @FXML
    private JFXButton btnEvaluacion;

    @FXML
    private JFXTextField txtNumero;

    @FXML
    private TextArea areaConsciencia;

    @FXML
    private TextArea areaRestriccion;

    @FXML
    private JFXButton btnApariencia;

    @FXML
    private DatePicker dateNacimientoNinio;

    @FXML
    private JFXTextField txtColonia;

    @FXML
    private JFXTextField txtReporteNo1;

    @FXML
    private JFXTextField txtParentescoPerPresente;

    @FXML
    private TextArea areaMotivoEvaluacion;

    @FXML
    private JFXCheckBox checkMemorama;

    @FXML
    private Pane pnlApariencia;

    @FXML
    private JFXCheckBox checkTestFamilia;

    @FXML
    private TextArea areaConductaMotriz;

    @FXML
    private JFXTextField txtReporteNo;

    @FXML
    private JFXTextField txtApellidoPaternoPerPresente;

    @FXML
    private Pane pnlEvaluacion;

    @FXML
    private JFXCheckBox checkHTP;

    @FXML
    private DatePicker Fechaevaluacion;

    @FXML
    private JFXCheckBox checkEntrevista;

    @FXML
    private Pane pnl;

    @FXML
    private JFXTextField txtNombreNinia;

    @FXML
    private JFXComboBox<?> comboLugarNac;

    @FXML
    private JFXTextField txtGrupoEtnico;

    @FXML
    private TextArea areaResultados;

    @FXML
    private JFXCheckBox checkMasa;

    @FXML
    private JFXTextField txtNombrePersonaPresente;

    @FXML
    private Pane pnlSocializacion;

    @FXML
    private Pane pnlDatosGenerales;

    @FXML
    private JFXTextField txtCodigoPostal;

    @FXML
    private JFXButton btnMemoria;

    @FXML
    private TextArea areaSugerencias;

    @FXML
    private TextArea areaMemoriaAtencionConcentracion;

    @FXML
    private JFXButton btnDatosGenerales;

    @FXML
    private JFXButton btnSocializacion;

    @FXML
    private JFXCheckBox checkTestMachover;

    @FXML
    private JFXTextField txtIdioma;

    @FXML
    private JFXTextField txtApellidoMaternoPerPresente;

    @FXML
    private JFXCheckBox checkTestGestalico;

    @FXML
    private TextArea areaOrientacion;

    @FXML
    private JFXButton btnResultados;

    @FXML
    private JFXTextField txtApellidoMaternoNinia;

    @FXML
    private JFXCheckBox checkTestApercepcion;

    @FXML
    private JFXButton btnMotivo;

    @FXML
    private Pane pnlMotivo;

    @FXML
    private Pane pnlMemoria;

    @FXML
    private TextArea areaPercepcion;

    @FXML
    private Pane pnlResultados;

    @FXML
    private JFXButton btnAfecto;

    @FXML
    private JFXCheckBox checkCuentos;

    @FXML
    private TextArea areaAparienciaFisica;

    @FXML
    private JFXCheckBox checkRompecabezas;

    @FXML
    private JFXComboBox<?> comboEstadoCivil;

    @FXML
    private JFXComboBox<?> comboGénero;

    @FXML
    private JFXCheckBox checkTiteres;

    @FXML
    private JFXCheckBox checkTestPersonaLluvia;

    @FXML
    private JFXCheckBox checkDiscapacidadSi;

    @FXML
    private JFXComboBox<?> txtMunicipio;

    @FXML
    private TextArea areaInteligencia;

    @FXML
    private JFXButton btnAgregar;

    @FXML
    private JFXTextField txtApellidoPaternoNinia;

    @FXML
    private JFXTextField txtEscolaridad;

    @FXML
    private JFXTextField txtCalle;

    @FXML
    private TextArea areaSocializacion;

    @FXML
    private TextArea areaAfectoEmocion;

    @FXML
    private JFXCheckBox checkTestArbol;

    @FXML
    private JFXCheckBox checkJuguetes;

}
