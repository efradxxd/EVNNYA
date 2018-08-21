package evnnya_ts;


import javafx.scene.control.TableColumn;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import conecciones.Conexion;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import procedimientos.PeticionesTrabajoSocial;
import procedimientos.Usuarios;
import procedimientos.Victima;
/**
 * FXML Controller class
 *
 * @author Pablo
 */
public class FXMLFormatoTSController implements Initializable {

    Herramientas herramientas = new Herramientas();
    double total0, total1;
    
    @FXML
    private void mostrarVentanaDatos(){
        try{
            System.out.println("HOla");
            FXMLLoader nuevaVentana= new FXMLLoader(getClass().getResource("FXMLDatosNinos.fxml"));
            Parent padre= (Parent)nuevaVentana.load();
            Stage escenario= new Stage();
            escenario.setScene(new Scene(padre));
            escenario.setResizable(false);
            escenario.sizeToScene();
            escenario.show();
                        System.out.println("HOla2");

        }catch(Exception e){
            System.out.println("PUTOOOOOO"+e);
        }
    }
       
    @FXML
    private void mostrarPaneles(ActionEvent event) {
        if(event.getTarget() == btn_datos_ninio) 
            mostrarPanel(pnlDatosNinio, true, pnlDatosTutor, false, pnlTecnicas, false, pnlEstructuraFamiliar, false, 
                                                    pnlDinamicaFamiliar, false, pnlSituacionEconomica,false, 
                                                    pnlSituacionEconomica2, false, pnlProblematica, false, 
                                                    pnlEntrevista,false, pnlDiagnosticoSocial,false, 
                                                    pnlPlanAccion,false, pnlObservacion, false, 
                                                    pnlArchivos,false);
        else if (event.getTarget() == btn_datos_custodia)
            mostrarPanel(pnlDatosNinio, false, pnlDatosTutor, true, pnlTecnicas, false, pnlEstructuraFamiliar, false, 
                                                    pnlDinamicaFamiliar, false, pnlSituacionEconomica,false, 
                                                    pnlSituacionEconomica2, false, pnlProblematica, false, 
                                                    pnlEntrevista,false, pnlDiagnosticoSocial,false, 
                                                    pnlPlanAccion,false, pnlObservacion, false, 
                                                    pnlArchivos,false);
        else if (event.getTarget() == btn_tecnicas_utilizadas)
            mostrarPanel(pnlDatosNinio, false, pnlDatosTutor, false, pnlTecnicas, true, pnlEstructuraFamiliar, false, 
                                                    pnlDinamicaFamiliar, false, pnlSituacionEconomica,false, 
                                                    pnlSituacionEconomica2, false, pnlProblematica, false, 
                                                    pnlEntrevista,false, pnlDiagnosticoSocial,false, 
                                                    pnlPlanAccion,false, pnlObservacion, false, 
                                                    pnlArchivos,false);
        else if (event.getTarget() == btn_estructura_familiar)
            mostrarPanel(pnlDatosNinio, false, pnlDatosTutor, false, pnlTecnicas, false, pnlEstructuraFamiliar, true, 
                                                    pnlDinamicaFamiliar, false, pnlSituacionEconomica,false, 
                                                    pnlSituacionEconomica2, false, pnlProblematica, false, 
                                                    pnlEntrevista,false, pnlDiagnosticoSocial,false, 
                                                    pnlPlanAccion,false, pnlObservacion, false, 
                                                    pnlArchivos,false);
        else if (event.getTarget() == btn_dinamica_familiar)
            mostrarPanel(pnlDatosNinio, false, pnlDatosTutor, false, pnlTecnicas, false, pnlEstructuraFamiliar, false, 
                                                    pnlDinamicaFamiliar, true, pnlSituacionEconomica,false, 
                                                    pnlSituacionEconomica2, false, pnlProblematica, false, 
                                                    pnlEntrevista,false, pnlDiagnosticoSocial,false, 
                                                    pnlPlanAccion,false, pnlObservacion, false, 
                                                    pnlArchivos,false);
        else if (event.getTarget() == btn_situacion_economica)
            mostrarPanel(pnlDatosNinio, false, pnlDatosTutor, false, pnlTecnicas, false, pnlEstructuraFamiliar, false, 
                                                    pnlDinamicaFamiliar, false, pnlSituacionEconomica,true, 
                                                    pnlSituacionEconomica2, false, pnlProblematica, false, 
                                                    pnlEntrevista,false, pnlDiagnosticoSocial,false, 
                                                    pnlPlanAccion,false, pnlObservacion, false, 
                                                    pnlArchivos,false);
        else if (event.getTarget() == btn_datos_vivienda)
            mostrarPanel(pnlDatosNinio, false, pnlDatosTutor, false, pnlTecnicas, false, pnlEstructuraFamiliar, false, 
                                                    pnlDinamicaFamiliar, false, pnlSituacionEconomica,false, 
                                                    pnlSituacionEconomica2, true, pnlProblematica, false, 
                                                    pnlEntrevista,false, pnlDiagnosticoSocial,false, 
                                                    pnlPlanAccion,false, pnlObservacion, false, 
                                                    pnlArchivos,false);
        else if (event.getTarget() == btn_antecedentes_problematica)
            mostrarPanel(pnlDatosNinio, false, pnlDatosTutor, false, pnlTecnicas, false, pnlEstructuraFamiliar, false, 
                                                    pnlDinamicaFamiliar, false, pnlSituacionEconomica,false, 
                                                    pnlSituacionEconomica2, false, pnlProblematica,true, 
                                                    pnlEntrevista,false, pnlDiagnosticoSocial,false, 
                                                    pnlPlanAccion,false, pnlObservacion, false, 
                                                    pnlArchivos,false);
        else if (event.getTarget() == btn_entrevista_nnoa)
            mostrarPanel(pnlDatosNinio, false, pnlDatosTutor, false, pnlTecnicas, false, pnlEstructuraFamiliar, false, 
                                                    pnlDinamicaFamiliar, false, pnlSituacionEconomica,false, 
                                                    pnlSituacionEconomica2, false, pnlProblematica, false, 
                                                    pnlEntrevista,true, pnlDiagnosticoSocial,false, 
                                                    pnlPlanAccion,false, pnlObservacion, false, 
                                                    pnlArchivos,false);
        else if (event.getTarget() == btn_diagnostico_social)
            mostrarPanel(pnlDatosNinio, false, pnlDatosTutor, false, pnlTecnicas, false, pnlEstructuraFamiliar, false, 
                                                    pnlDinamicaFamiliar, false, pnlSituacionEconomica,false, 
                                                    pnlSituacionEconomica2, false, pnlProblematica, false, 
                                                    pnlEntrevista,false, pnlDiagnosticoSocial,true, 
                                                    pnlPlanAccion,false, pnlObservacion, false, 
                                                    pnlArchivos,false);
        else if (event.getTarget() == btn_plan_accion)
            mostrarPanel(pnlDatosNinio, false, pnlDatosTutor, false, pnlTecnicas, false, pnlEstructuraFamiliar, false, 
                                                    pnlDinamicaFamiliar, false, pnlSituacionEconomica,false, 
                                                    pnlSituacionEconomica2, false, pnlProblematica, false, 
                                                    pnlEntrevista,false, pnlDiagnosticoSocial,false, 
                                                    pnlPlanAccion,true, pnlObservacion, false, 
                                                    pnlArchivos,false);
        else if (event.getTarget() == btn_observaciones)
            mostrarPanel(pnlDatosNinio, false, pnlDatosTutor, false, pnlTecnicas, false, pnlEstructuraFamiliar, false, 
                                                    pnlDinamicaFamiliar, false, pnlSituacionEconomica,false, 
                                                    pnlSituacionEconomica2, false, pnlProblematica, false, 
                                                    pnlEntrevista,false, pnlDiagnosticoSocial,false, 
                                                    pnlPlanAccion,false, pnlObservacion, true, 
                                                    pnlArchivos,false);
        else if (event.getTarget() == btn_archivos)
            mostrarPanel(pnlDatosNinio, false, pnlDatosTutor, false, pnlTecnicas, false, pnlEstructuraFamiliar, false, 
                                                    pnlDinamicaFamiliar, false, pnlSituacionEconomica,false, 
                                                    pnlSituacionEconomica2, false, pnlProblematica, false, 
                                                    pnlEntrevista,false, pnlDiagnosticoSocial,false, 
                                                    pnlPlanAccion,false, pnlObservacion, false, 
                                                    pnlArchivos,true);
    }
    
     //METODO QUE MUESTRA EL PANEL CORRESPONDIENDE AL BOTON SELECCIONADO
    public void mostrarPanel(Pane pnl1, Boolean bl1, Pane pnl2, Boolean bl2, Pane pnl3, Boolean bl3,
                            Pane pnl4, Boolean bl4, Pane pnl5, Boolean bl5, Pane pnl6, Boolean bl6,
                            Pane pnl7, Boolean bl7, Pane pnl8, Boolean bl8, Pane pnl9, Boolean bl9,
                            Pane pnl10, Boolean bl10, Pane pnl11, Boolean bl11, Pane pnl12, Boolean bl12,
                            Pane pnl13, Boolean bl13){
        pnl1.setVisible(bl1);
        pnl2.setVisible(bl2);
        pnl3.setVisible(bl3);
        pnl4.setVisible(bl4);
        pnl5.setVisible(bl5);
        pnl6.setVisible(bl6);
        pnl7.setVisible(bl7);
        pnl8.setVisible(bl8);
        pnl9.setVisible(bl9);
        pnl10.setVisible(bl10);
        pnl11.setVisible(bl11);
        pnl12.setVisible(bl12);
        pnl13.setVisible(bl13);
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        mostrarTabla();
        
        comboGenero.getItems().addAll(herramientas.getSexo());
        comboGenero.setValue(herramientas.getSexo()[0]);
        comboMunicipio.getItems().addAll(herramientas.getMunicipios());
        comboMunicipio.setValue(herramientas.getMunicipios()[0]);
        comboEstadoCivil.getItems().addAll(herramientas.getEdoCivil());
        comboEstadoCivil.setValue(herramientas.getEdoCivil()[0]);
        comboSexoEstrucFam.getItems().addAll(herramientas.getSexo());
        comboSexoEstrucFam.setValue(herramientas.getSexo()[0]);
        comboEscolaridadTutor.getItems().addAll(herramientas.getEscolaridad());
        comboEscolaridadTutor.setValue(herramientas.getEscolaridad()[0]);
        comboEscolaridadEstrucFam.getItems().addAll(herramientas.getEscolaridad());
        comboEscolaridadEstrucFam.setValue(herramientas.getEscolaridad()[0]);
        comboMunicipioTutor.getItems().addAll(herramientas.getMunicipios());
        comboMunicipio.setValue(herramientas.getMunicipios()[0]);
        comboEstadoCivilEstrucFam.getItems().addAll(herramientas.getEdoCivil());
        comboEscolaridadEstrucFam.setValue(herramientas.getEdoCivil()[0]);
        
        dateFechaNacTutor.setEditable(false);
        dateFechaNacTutor.setPromptText("28/10/2016");
        
        situacionEconomica();
        datosDeLaVivienda();
        
    }   
    //1
    String variables1[] = new String[11];
    @FXML
    private void datosGenerales(){
        try {
            
            variables1 [0] = txtNombre.getText();
            variables1 [1] = txtApellidoPaterno.getText();
            variables1 [2] = ApellidoMaterno.getText();
            variables1 [3] = txtCalle.getText();
            variables1 [4] = txtNumero.getText();
            variables1 [5] = txtColonia.getText();
            variables1 [6] = txtCodigoPostal.getText();
            variables1 [7] = (String) comboMunicipio.getValue();
            variables1 [8] = txtEntreCalles.getText();
            variables1 [9] = txtEntreCalles.getText();
            variables1 [10] = txtNoExpediente.getText();
          
            limpiarVariables(variables1);
                 
        } catch (Exception e) {
        
        }
        
    }
    //2
    private void datosGeneralesCustodia(){
        
    }
    //3
    private void tecnicasUtilizadas(){
        
    }
    //4
    private void estructuraUtilizada(){
        
    }
    //5
    private void dinamicaFamiliarFamiliograma(){
        
    }
     
    //6
    private void situacionEconomica(){
        txtPadreSituacionEco = realizarSumaEnTiempoReal(txtPadreSituacionEco);
        txtMadreSituacionEco = realizarSumaEnTiempoReal(txtMadreSituacionEco);
        txtHermanoSituacionEco = realizarSumaEnTiempoReal(txtHermanoSituacionEco);
        txtOtrosSituacionEco = realizarSumaEnTiempoReal(txtOtrosSituacionEco);
        situacionEgresos();
    }
    //7
    
    ToggleGroup grupoVivienda = new ToggleGroup();
    ToggleGroup tipoDeVivienda = new ToggleGroup();
    ToggleGroup zona = new ToggleGroup();
    
    int piso;
    int muro;
    int techo;
    int serviciosPublicos;
    
    private void datosDeLaVivienda(){
        //Grupos viviendas
        
        radioPropiaVivienda.setToggleGroup(grupoVivienda);
        radioRentadaVivienda.setToggleGroup(grupoVivienda);
        radioPrestadaVivienda.setToggleGroup(grupoVivienda);
        
        //Grupos tipo de viviendas
        
        radioCasaSolaTipo.setToggleGroup(tipoDeVivienda);
        radioDepartamentoTipo.setToggleGroup(tipoDeVivienda);
        radioVecindadTipo.setToggleGroup(tipoDeVivienda);
        radioImprovisadoTipo.setToggleGroup( tipoDeVivienda);
        radioOtroTipo.setToggleGroup(tipoDeVivienda);
        
        //Zona
        
        radioRuralZona.setToggleGroup(zona);
        radioUrbanaZona.setToggleGroup(zona); 
            
    }
    
    String vivienda,tipoVivienda,zona0;
    
    private void getAllDatosViviendas(){

        vivienda = herramientas.obtenerElString(herramientas.obtenerValoresRadioButon(grupoVivienda));
        tipoVivienda = herramientas.obtenerElString(herramientas.obtenerValoresRadioButon(tipoDeVivienda));
        zona0 = herramientas.obtenerElString(herramientas.obtenerValoresRadioButon(zona));
        
        if (radioAdobeMuros.isSelected()) 
            radioAdobeMuros.getText().toString();
        
    }
    //8
    String antecedeDeLaProb;
    private void antecedentesDeLaProblematica(){
        antecedeDeLaProb =  areaAntecedentes.getText();
    }
    //9
    String entrevistaConNNOA;
    private void entrevistaConNNOA(){
        entrevistaConNNOA = areaEntrevistaNinio.getText();
    }
    //10
    String diagnosticoSocial;
    private void diagnosticoSocial(){
        diagnosticoSocial = areaDiagnosticoSocial.getText();
    }
    //11
    String planAccion;
    private void planAccion(){
        planAccion = areaPlanAccion.getText();
    }
    //12
    String observaciones;
    private void observaciones(){
        observaciones = areaObservaciones.getText();
    }
    //13 
    private void aniadirArchivos(){
        
    }
    //14
    
    private void soloGuardarCambios(){
        observaciones();
        planAccion();
        diagnosticoSocial();
        tecnicasUtilizadas();
        
        
        
        
    }
    //15
    private void terminarEnviar(){
        
    }
    
    
    double mandarDinero;
    
    private JFXTextField realizarSumaEnTiempoReal(JFXTextField variables){
        variables.setOnKeyReleased(new EventHandler<KeyEvent>(){
            @Override
            public void handle(KeyEvent event) {
                char car = event.getCharacter().charAt(0);
                if (Character.isLetter(car)){
                    event.consume();                    
                }
                else
                {
                    try{
             
                    double padreSit = 0;
                    double madreSit = 0;
                    double hermanSit = 0;
                    double otrosSit = 0;
                    
                    if(!txtPadreSituacionEco.getText().equals("")){
                        padreSit = Double.parseDouble(txtPadreSituacionEco.getText());
                    }
                    if(!txtMadreSituacionEco.getText().equals("")){
                        madreSit = Double.parseDouble(txtMadreSituacionEco.getText());
                    }
                    if(!txtHermanoSituacionEco.getText().equals("")){
                        hermanSit = Double.parseDouble(txtHermanoSituacionEco.getText());
                    }
                    if(!txtOtrosSituacionEco.getText().equals("")){
                        otrosSit = Double.parseDouble(txtOtrosSituacionEco.getText());
                    }
                        
                        double x;
                        total0 = x = padreSit + madreSit + hermanSit + otrosSit;
                    
                    txtTotalSituacionEco.setText("$ "+ herramientas.quitarNotacionCientifica(x));

                    double activo = 0,pasivo = 0;
                    activo = (total1 - total0);
                    pasivo = (total0 - total1);
                    if (activo >= pasivo) {
                        mandarDinero = (total1 - total0);
                        txtDeficitSituacionEco.setText("$ " + herramientas.quitarNotacionCientifica((total1 - total0))); 
                        txtSuperavitSituacionEco.setText("");
                    }else{
                        mandarDinero = (total0 - total1);
                        txtSuperavitSituacionEco.setText("$ " + herramientas.quitarNotacionCientifica((total0 - total1)));
                        txtDeficitSituacionEco.setText("");
                    }
                        }catch(Exception e){
                            System.out.println(e);
                        }
                    
                   
                }
                    
            } 
        });
        return variables;
    }
    int activo = 0,pasivo = 0;

    private void situacionEgresos(){
        txtAlimentacionSituacionEco = realizarSumaEgresos(txtAlimentacionSituacionEco);
        txtTransporteSituacionEco = realizarSumaEgresos(txtTransporteSituacionEco);
        txtEducacionSituacionEco = realizarSumaEgresos(txtEducacionSituacionEco);
        txtSaludSituacionEco = realizarSumaEgresos(txtSaludSituacionEco);
        txtServiciosSituacionEco = realizarSumaEgresos(txtServiciosSituacionEco);
        txtVestidoSituacionEco = realizarSumaEgresos(txtVestidoSituacionEco);
        txtRentaSituacionEco = realizarSumaEgresos(txtRentaSituacionEco);
    }
    private JFXTextField realizarSumaEgresos(JFXTextField variables){
        variables.setOnKeyReleased(new EventHandler<KeyEvent>(){
            @Override
            public void handle(KeyEvent event) {
                char car = event.getCharacter().charAt(0);
                if (Character.isLetter(car) /*&& Character.isSpaceChar(car)*/){
                    event.consume();                    
                }
                else
                {
                    try{
             
                    double alimentacom = 0;
                    double educacion = 0;
                    double salud = 0;
                    double vestido = 0;
                    double servicios = 0;
                    double transportes = 0;
                    double renta = 0;
                    
                    
                    if(!txtAlimentacionSituacionEco.getText().equals("")){
                        alimentacom = Double.parseDouble(txtAlimentacionSituacionEco.getText());
                    }
                    if(!txtEducacionSituacionEco.getText().equals("")){
                        educacion = Double.parseDouble(txtEducacionSituacionEco.getText());
                    }
                    if(!txtSaludSituacionEco.getText().equals("")){
                        salud = Double.parseDouble(txtSaludSituacionEco.getText());
                    }
                    if(!txtVestidoSituacionEco.getText().equals("")){
                        vestido = Double.parseDouble(txtVestidoSituacionEco.getText());
                    }
                    if(!txtServiciosSituacionEco.getText().equals("")){
                        servicios = Double.parseDouble(txtServiciosSituacionEco.getText());
                    }                    
                    if(!txtTransporteSituacionEco.getText().equals("")){
                        transportes = Double.parseDouble(txtTransporteSituacionEco.getText());
                    }            
                    if(!txtRentaSituacionEco.getText().equals("")){
                        renta = Double.parseDouble(txtRentaSituacionEco.getText());
                    }                    
                        double x;
                        total1 = x = alimentacom + educacion + salud + vestido + servicios + transportes + renta;
                    
                    txtTotalEgresosSituacionEco.setText("$ "+ herramientas.quitarNotacionCientifica(x));

                    double activo = 0,pasivo = 0;
                    activo = (total1 - total0);
                    pasivo = (total0 - total1);
                    if (activo >= pasivo) {
                        mandarDinero = (total1 - total0);
                        txtDeficitSituacionEco.setText("$ " + herramientas.quitarNotacionCientifica((total1 - total0))); 
                        txtSuperavitSituacionEco.setText("");
                    }else{
                        mandarDinero = (total0 - total1);
                        txtSuperavitSituacionEco.setText("$ " + herramientas.quitarNotacionCientifica((total0 - total1)));
                        txtDeficitSituacionEco.setText("");
                    }
                    
                        }catch(Exception e){
                            System.out.println(e);
                        }
                    
                   
                }
                    
            } 
        });        
    return variables;
    }
    
    private String[] limpiarVariables(String limpiar[]){
        for (int i = 0; i < limpiar.length; i++) 
            limpiar[i] = "";
    return limpiar;
    }
    private double[] limpiarNumeros(double limpiar[]){
        for (int i = 0; i < limpiar.length; i++) 
                limpiar[i] = 0;
    return limpiar;
  }
    
    
 @FXML
 private void guardar(ActionEvent e){
     
 }
 @FXML
 private void terminarEnviar2(ActionEvent e){
    Conexion conexion = new Conexion();
    PeticionesTrabajoSocial trabajoSocial = new PeticionesTrabajoSocial();
     // trabajoSocial.agregarPeticionTrabajoSocial(conexion.cadena_conexion(), vivienda, vivienda, piso, techo, techo, tipoVivienda, serviciosPublicos, planAccion, pasivo, vivienda, piso, planAccion, pasivo, tipoVivienda);
 }
    
 
    
    
    
   String numeroExpediente; 
private void mostrarTabla(){
    
    columApeMaterno.setCellValueFactory(new PropertyValueFactory<Victimas,String> ("apeMa"));
    columApeMaterno.setCellValueFactory(new PropertyValueFactory<Victimas, String> ("apePa"));
    columnSexo.setCellValueFactory(new PropertyValueFactory<Victimas, String> ("sexo"));
    columnNombre.setCellValueFactory(new PropertyValueFactory<Victimas, String> ("nombre"));
    columnEdad.setCellValueFactory(new PropertyValueFactory<Victimas, Integer> ("edad"));
    
    try{
       
    Victima trabajoSocial = new Victima();
    Conexion conexion = new Conexion();
    trabajoSocial.seleccionarListaVictimas(conexion.cadena_conexion(), numeroExpediente);
    
    List listaNombre = trabajoSocial.getListaNombres();
    List listaApePa = trabajoSocial.getListaApellidoPaterno();
    List listaApeMa = trabajoSocial.getListaApellidoMaterno();
    List listaSexo = trabajoSocial.getListaSexo();
    List listaEdad = trabajoSocial.getListaEdad();
    
    ObservableList<Victimas> tablaInterna = FXCollections.observableArrayList();
    
        for (int i = 0; i < 10; i++) 
            tablaInterna.add(new Victimas( (String)listaNombre.get(i),
                                           (String)listaApePa.get(i),
                                           (String)listaApeMa.get(i),
                                           (int)listaEdad.get(i),
                                           (String)listaSexo.get(i)));
        
    tablaVictimas.setItems(tablaInterna);
        
    }catch(Exception e){
            
            }
}   
    
    
    @FXML
    private JFXButton btn_observaciones;

    @FXML
    private JFXButton btnBuscarDinamicaFam;

    @FXML
    private TableColumn<Victimas, Integer> columnEdad;

    @FXML
    private JFXTextField ApellidoMaterno;

    @FXML
    private JFXTextField txtTransporteSituacionEco;

    @FXML
    private JFXTextField txtNumero;

    @FXML
    private JFXTextField txtTelefonoFijoTutor;

    @FXML
    private TableColumn<Victimas, String> columnApePaterno;

    @FXML
    private JFXRadioButton radioTabiqueMuros;

    @FXML
    private JFXTextField txtColonia;

    @FXML
    private JFXTextField txtNombre;

    @FXML
    private JFXButton btn_datos_vivienda;

    @FXML
    private JFXTextField txtOtrosSituacionEco;

    @FXML
    private JFXComboBox<String> comboGenero;

    @FXML
    private TableView<Victimas> tablaVictimas = new TableView<>();

    @FXML
    private TextArea areaDinamicaFamiliar;

    @FXML
    private TextArea areaEntrevistaNinio;

    @FXML
    private JFXButton btn_antecedentes_problematica;

    @FXML
    private JFXRadioButton radioTierraPiso;

    @FXML
    private Pane pnlEstructuraFamiliar;

    @FXML
    private JFXComboBox<String> comboMunicipio;

    @FXML
    private JFXRadioButton radioDrenajeServicios;

    @FXML
    private JFXButton btn_archivos1;

    @FXML
    private JFXTextField txtNoExpediente;

    @FXML
    private JFXButton btn_archivos2;

    @FXML
    private JFXTextField txtOcupacionEstrucFam;

    @FXML
    private JFXButton btn_tecnicas_utilizadas;

    @FXML
    private Pane pnlSituacionEconomica2;

    @FXML
    private JFXTextField txtApellidoMaternoEstrucFam;

    @FXML
    private JFXRadioButton radioOtroTipo;

    @FXML
    private JFXTextField txtCodigoPostal;

    @FXML
    private JFXTextField txtHermanoSituacionEco;

    @FXML
    private JFXTextField txtApellidoPaterno;

    @FXML
    private JFXComboBox<String> comboEstadoCivilEstrucFam;

    @FXML
    private Pane pnlObservacion;

    @FXML
    private JFXRadioButton radioAdobeMuros;

    @FXML
    private TextArea areaDiagnosticoSocial;

    @FXML
    private JFXRadioButton radioRentadaVivienda;

    @FXML
    private JFXCheckBox checkDiscapacidadSiTutor;

    @FXML
    private JFXTextField txtRentaSituacionEco;

    @FXML
    private JFXComboBox<String> comboEscolaridadTutor;

    @FXML
    private JFXTextField txtIdioma;

    @FXML
    private JFXRadioButton radioLimpServicio;

    @FXML
    private JFXRadioButton radioCocinaDistribucion;

    @FXML
    private JFXTextField txtHacinamientoDistribucion;

    @FXML
    private JFXComboBox<String> comboEscolaridadEstrucFam;

    @FXML
    private JFXButton btn_plan_accion;

    @FXML
    private JFXRadioButton radioBañoDistribucion;

    @FXML
    private JFXRadioButton radioOtrosMuros;

    @FXML
    private ImageView btnRegresar;

    @FXML
    private Pane pnlEntrevista;

    @FXML
    private JFXTextField txtApellidoPaternoEstrucFam;

    @FXML
    private JFXRadioButton radioPiedraPiso;

    @FXML
    private JFXButton btnAgregarEstrucFam;

    @FXML
    private JFXTextField txtMadreSituacionEco;

    @FXML
    private JFXRadioButton radioDepartamentoTipo;

    @FXML
    private JFXRadioButton radioAlumbradoServicios;

    @FXML
    private JFXRadioButton radioOtroPiso;

    @FXML
    private JFXTextField txtVestidoSituacionEco;

    @FXML
    private JFXRadioButton radioMaderaPiso;

    @FXML
    private JFXTextField txtParentesco;

    @FXML
    private JFXCheckBox checkDiscapacidadNoTutor;

    @FXML
    private JFXTextField txtEntreCalles;

    @FXML
    private TextArea areaPlanAccion;

    @FXML
    private Pane pnlDatosNinio;

    @FXML
    private JFXTextField txtPadreSituacionEco;

    @FXML
    private JFXButton btn_situacion_economica;

    @FXML
    private JFXRadioButton radioPavimentacionServicios;

    @FXML
    private JFXTextField txtRecamarasDistribucion;

    @FXML
    private TableColumn<Victimas, String> columApeMaterno;

    @FXML
    private JFXRadioButton radioImprovisadoTipo;

    @FXML
    private JFXRadioButton radioRuralZona;

    @FXML
    private JFXRadioButton radioElectricidadServicios;

    @FXML
    private TextArea areaAntecedentes;

    @FXML
    private Pane pnlArchivos;

    @FXML
    private JFXRadioButton radioAguaServicios;

    @FXML
    private JFXRadioButton radioComedorDistribucion;

    @FXML
    private JFXTextField txtCalleTutor;

    @FXML
    private JFXTextField txtNumeroTutor;

    @FXML
    private JFXTextField txtEducacionSituacionEco;

    @FXML
    private JFXRadioButton radioUrbanaZona;

    @FXML
    private Pane pnlDatosTutor;

    @FXML
    private JFXTextField txtCualDiscapacidad;

    @FXML
    private JFXButton btn_diagnostico_social;

    @FXML
    private JFXCheckBox checkEntrevistaTecnicasUtilizadas;

    @FXML
    private JFXTextField txtEdadEstrucFam;

    @FXML
    private JFXRadioButton radioCasaSolaTipo;

    @FXML
    private JFXButton btn_datos_custodia;

    @FXML
    private JFXTextField txtNombreEstrucFam;

    @FXML
    private JFXRadioButton radioSalaDistribucion;

    @FXML
    private JFXButton btn_entrevista_nnoa;

    @FXML
    private JFXComboBox<String> comboMunicipioTutor;

    @FXML
    private JFXRadioButton radioMaderaMuros;

    @FXML
    private JFXTextField txtNombreTutor;

    @FXML
    private JFXTextField txtCodigoPostalTutor;

    @FXML
    private JFXTextField txtReligionTutor;

    @FXML
    private JFXCheckBox checkVisitaDomicilTecnicasUtil;

    @FXML
    private JFXButton btn_estructura_familiar;

    @FXML
    private Pane pnlDiagnosticoSocial;

    @FXML
    private JFXCheckBox checkMixtaTecnicasUtilizadas;

    @FXML
    private JFXRadioButton radioVecindadTipo;

    @FXML
    private Pane pnlSituacionEconomica;

    @FXML
    private JFXRadioButton radioConcretoPiso;

    @FXML
    private TableColumn<Victimas, String> columnSexo;

    @FXML
    private JFXTextField txtApellidoPaternoTutor;

    @FXML
    private JFXTextField txtGrupoEtnicoTutor;

    @FXML
    private TextArea areaObservaciones;

    @FXML
    private JFXTextField txtAlimentacionSituacionEco;

    @FXML
    private JFXComboBox<String> comboSexoEstrucFam;

    @FXML
    private Pane pnlDinamicaFamiliar;

    @FXML
    private JFXTextField txtApellidoMaternoTutor;

    @FXML
    private TableView<?> tablaEstructuraFamiliar;

    @FXML
    private JFXTextField txtTelefonoMovilTutor;

    @FXML
    private JFXTextField txtServiciosSituacionEco;

    @FXML
    private JFXTextField txtColoniaTutor;

    @FXML
    private JFXTextField txtSaludSituacionEco;

    @FXML
    private JFXTextField txtDeficitSituacionEco;

    @FXML
    private Pane pnlTecnicas;

    @FXML
    private JFXTextField txtHabitacionesDistribucion;

    @FXML
    private JFXTextField txtTotalEgresosSituacionEco;

    @FXML
    private JFXRadioButton radioCartonMuros;

    @FXML
    private Pane pnlProblematica;

    @FXML
    private JFXButton btn_datos_ninio;

    @FXML
    private DatePicker dateFechaNacTutor;

    @FXML
    private JFXButton btn_archivos;

    @FXML
    private JFXComboBox<String> comboEstadoCivil;

    @FXML
    private JFXTextField txtTotalSituacionEco;

    @FXML
    private JFXCheckBox checkObservacionTecnicasUtilizadas;

    @FXML
    private TableColumn<Victimas, String> columnNombre;

    @FXML
    private TextArea txtAreaRefDomi;

    @FXML
    private JFXRadioButton radioPropiaVivienda;

    @FXML
    private JFXRadioButton radioPrestadaVivienda;

    @FXML
    private JFXTextField txtSuperavitSituacionEco;

    @FXML
    private JFXButton btnComplementarDatos;

    @FXML
    private JFXTextField txtCalle;

    @FXML
    private JFXButton btn_dinamica_familiar;

    @FXML
    private JFXTextField txtParentescoEstrucFam;

    @FXML
    private Pane pnlPlanAccion;

}