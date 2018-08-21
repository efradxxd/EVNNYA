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
import conecciones.Conexion;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.regex.Pattern;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextFormatter;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import procedimientos.Agresor;
import procedimientos.Custodia;
import procedimientos.Direcciones;
import procedimientos.EvaluacionMedico;
import procedimientos.EvaluacionPsicologia;
import procedimientos.PersonaPresentesEvaluacion;
import procedimientos.PeticionesMedico;
import procedimientos.PeticionesPsicologia;
import procedimientos.Victima;

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
    String cDiscapacidad;
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
    String habla;
    String conclucion;
    String pensamiento;
    int discN;
    String consciencia;
    String restriccion;
    String reportN1;
    String parentescoPPre;
    int htp;
    String motivoEva;
    int memorama;
    int testFam;
    int entrevista;
    String resultados;
    int masa;
    String nombrePerPresente;
    String sugerencias;
    String memoriaAtnConcen;
    int testMachover;
    String apellidoMaterPerPresente;
    int testGestalico;
    String orientacion;
    int testApercep;
    String percepcion;
    int cuentos;
    String aparienciaFisica;
    int rompeCabezas;
    int titeres;
    int testPersonalLuvia;
    int discS;
    String inteligencia;
    String apellidoPatNin;
    String socializacion;
    String afectoEmo;
    int testArbol;
    int juguetes;
    String conductaMotriz;
    //VARIABLES INTERNAS
    String regex = "10|[1-9]";
    String fecha_evaluacion_alta = "";
    String hora_evaluacion_alta = "";

    @FXML
    private void mostrarPaneles(ActionEvent event) {
        if (event.getTarget() == btnDatosGenerales) {
            mostrarPanel(pnlDatosGenerales, true, pnlEvaluacion, false, pnlMotivo, false, pnlApariencia, false,
                    pnlSocializacion, false, pnlMemoria, false,
                    pnlAfecto, false, pnlResultados, false);
        } else if (event.getTarget() == btnEvaluacion) {
            mostrarPanel(pnlDatosGenerales, false, pnlEvaluacion, true, pnlMotivo, false, pnlApariencia, false,
                    pnlSocializacion, false, pnlMemoria, false,
                    pnlAfecto, false, pnlResultados, false);
        } else if (event.getTarget() == btnMotivo) {
            mostrarPanel(pnlDatosGenerales, false, pnlEvaluacion, false, pnlMotivo, true, pnlApariencia, false,
                    pnlSocializacion, false, pnlMemoria, false,
                    pnlAfecto, false, pnlResultados, false);
        } else if (event.getTarget() == btnApariencia) {
            mostrarPanel(pnlDatosGenerales, false, pnlEvaluacion, false, pnlMotivo, false, pnlApariencia, true,
                    pnlSocializacion, false, pnlMemoria, false,
                    pnlAfecto, false, pnlResultados, false);
        } else if (event.getTarget() == btnSocializacion) {
            mostrarPanel(pnlDatosGenerales, false, pnlEvaluacion, false, pnlMotivo, false, pnlApariencia, false,
                    pnlSocializacion, true, pnlMemoria, false,
                    pnlAfecto, false, pnlResultados, false);
        } else if (event.getTarget() == btnMemoria) {
            mostrarPanel(pnlDatosGenerales, false, pnlEvaluacion, false, pnlMotivo, false, pnlApariencia, false,
                    pnlSocializacion, false, pnlMemoria, true,
                    pnlAfecto, false, pnlResultados, false);
        } else if (event.getTarget() == btnAfecto) {
            mostrarPanel(pnlDatosGenerales, false, pnlEvaluacion, false, pnlMotivo, false, pnlApariencia, false,
                    pnlSocializacion, false, pnlMemoria, false,
                    pnlAfecto, true, pnlResultados, false);
        } else if (event.getTarget() == btnResultados) {
            mostrarPanel(pnlDatosGenerales, false, pnlEvaluacion, false, pnlMotivo, false, pnlApariencia, false,
                    pnlSocializacion, false, pnlMemoria, false,
                    pnlAfecto, false, pnlResultados, true);
        }

    }

    @FXML
    private void escribirSoloNumeros(java.awt.event.KeyEvent evt) {
        char car = evt.getKeyChar();
        if ((car < '0' || car > '9') && (car < ',' || car > '.')) {
            evt.consume();
        }

    }

    void insertarDatosTerapia() {
        /*if (FXMLDatosPsicController.tipo.equals("A")) {
            Conexion conexion = new Conexion();
            Agresor agrede = new Agresor();
            int numero = Integer.parseInt(FXMLDatosPsicController.id_Personal);
            agrede.seleccionarAgresor(conexion.cadena_conexion(), numero);
            txtNombreNinia.setText(agrede.getNombre());
            txtApellidoPaternoNinia.setText(agrede.getApellido_paterno());
            txtApellidoMaternoNinia.setText(agrede.getApellido_materno());
            txtReporteNo.setText(agrede.getNumero_expediente());
        } else {
            Conexion conexion = new Conexion();
            Victima victim = new Victima();
            int numero = Integer.parseInt(FXMLDatosPsicController.id_Personal);
            victim.seleccionarVictima(conexion.cadena_conexion(), numero);
            txtNombreNinia.setText(victim.getNombres());
            txtApellidoPaternoNinia.setText(victim.getApellido_paterno());
            txtApellidoMaternoPerPresente.setText(victim.getApellido_materno());
            txtReporteNo.setText(victim.getNumero_expediente());

        }*/
        
        String tipo_paciente = Global.tipo_paciente;
        String id_paciente = Global.id_paciente;
        Conexion conexion = new Conexion();
        
        if(tipo_paciente.equalsIgnoreCase("agresor")){
            
            Agresor agresor = new Agresor();
            
            agresor.seleccionarAgresor(conexion.cadena_conexion(), Integer.parseInt(id_paciente));
            
            txtReporteNo.setText(agresor.getNumero_expediente());
            txtNombreNinia.setText(agresor.getNombre());
            txtApellidoPaternoNinia.setText(agresor.getApellido_paterno());
            txtApellidoMaternoNinia.setText(agresor.getApellido_materno());
            dateNacimientoNinio.setPromptText(agresor.getFecha_nacimiento());
            comboLugarNac.setPromptText(agresor.getLugar_nacimiento());
            txtNacionalidad.setText(agresor.getNacionalidad());
            comboGénero.setPromptText(agresor.getSexo());
            txtEscolaridad.setText(agresor.getEscolaridad());
            comboEstadoCivil.setPromptText(agresor.getEstado_civil());
            
            if(agresor.getDiscapacidad() == 0){
                checkDiscapacidadNo.setSelected(true);
                checkDiscapacidadSi.setSelected(false);
            }
            if(agresor.getDiscapacidad() == 1){
                checkDiscapacidadNo.setSelected(false);
                checkDiscapacidadSi.setSelected(true);
            }
            
            txtCualDiscapacidad.setText(agresor.getCual_discapacidad());
            txtIdioma.setText(agresor.getIdioma_dialecto());
            txtGrupoEtnico.setText(agresor.getGrupo_etnico());
            txtReligion.setText(agresor.getReligion());
            
            Direcciones direccion = new Direcciones();
            
            direccion.seleccionarDireccion(conexion.cadena_conexion(), agresor.getId_direccion());
            
            txtCalle.setText(direccion.getCalle());
            txtNumero.setText(direccion.getNumero());
            txtColonia.setText(direccion.getColonia());
            txtCodigoPostal.setText(direccion.getCodigo_postal()+"");
            txtMunicipio.setPromptText(direccion.getMunicipio());
            
        }
        
        if(tipo_paciente.equalsIgnoreCase("victima")){
            
            Victima victima = new Victima();
            
            victima.seleccionarVictima(conexion.cadena_conexion(), Integer.parseInt(id_paciente));
            
            txtReporteNo.setText(victima.getNumero_expediente());
            txtNombreNinia.setText(victima.getNombres());
            txtApellidoPaternoNinia.setText(victima.getApellido_paterno());
            txtApellidoMaternoNinia.setText(victima.getApellido_materno());
            //dateNacimientoNinio.setValue(LocalDate.parse(agresor.getFecha_nacimiento()));
            comboLugarNac.setPromptText(victima.getLugar_nacimiento());
            txtNacionalidad.setText(victima.getNacionalidad());
            comboGénero.setPromptText(victima.getSexo());
            txtEscolaridad.setText(victima.getEscolaridad());
            comboEstadoCivil.setPromptText(victima.getEstado_civil());
            
            if(victima.getDiscapacidad() == 0){
                checkDiscapacidadNo.setSelected(true);
                checkDiscapacidadSi.setSelected(false);
            }
            if(victima.getDiscapacidad() == 1){
                checkDiscapacidadNo.setSelected(false);
                checkDiscapacidadSi.setSelected(true);
            }
            
            txtCualDiscapacidad.setText(victima.getCual_discapacidad());
            txtIdioma.setText(victima.getIdioma_dialecto());
            txtGrupoEtnico.setText(victima.getGrupo_etnico());
            txtReligion.setText(victima.getReligion());
            
            Direcciones direccion = new Direcciones();
            
            direccion.seleccionarDireccion(conexion.cadena_conexion(), victima.getId_direccion());
            
            txtCalle.setText(direccion.getCalle());
            txtNumero.setText(direccion.getNumero());
            txtColonia.setText(direccion.getColonia());
            txtCodigoPostal.setText(direccion.getCodigo_postal()+"");
            txtMunicipio.setPromptText(direccion.getMunicipio());
            
        }
        
        if(tipo_paciente.equalsIgnoreCase("custodia")){
            
            Custodia custodia = new Custodia();
            
            custodia.seleccionarCustodia(conexion.cadena_conexion(), Integer.parseInt(id_paciente));
            
            txtReporteNo.setText("");
            txtNombreNinia.setText(custodia.getNombres());
            txtApellidoPaternoNinia.setText(custodia.getApellido_paterno());
            txtApellidoMaternoNinia.setText(custodia.getApellido_materno());
            dateNacimientoNinio.setPromptText(custodia.getFecha_nacimiento());
            comboLugarNac.setPromptText("");
            txtNacionalidad.setText("");
            comboGénero.setPromptText(custodia.getSexo());
            txtEscolaridad.setText(custodia.getEscolaridad());
            comboEstadoCivil.setPromptText(custodia.getEstado_civil());
            
            if(Integer.parseInt(custodia.getDiscapacidad()) == 0){
                checkDiscapacidadNo.setSelected(true);
                checkDiscapacidadSi.setSelected(false);
            }
            if(Integer.parseInt(custodia.getDiscapacidad()) == 1){
                checkDiscapacidadNo.setSelected(false);
                checkDiscapacidadSi.setSelected(true);
            }
            
            txtCualDiscapacidad.setText(custodia.getCual_discapacidad());
            txtIdioma.setText(custodia.getIdioma_dialecto());
            txtGrupoEtnico.setText(custodia.getGrupo_etnico());
            txtReligion.setText(custodia.getReligion());
            
            Direcciones direccion = new Direcciones();
            
            direccion.seleccionarDireccion(conexion.cadena_conexion(), Integer.parseInt(custodia.getId_direccion()));
            
            txtCalle.setText(direccion.getCalle());
            txtNumero.setText(direccion.getNumero());
            txtColonia.setText(direccion.getColonia());
            txtCodigoPostal.setText(direccion.getCodigo_postal()+"");
            txtMunicipio.setPromptText(direccion.getMunicipio());
            
        }
        
        //RESTO DE LOS DATOS DEL FOMULARIO
        
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        insertarDatosTerapia();
        listenerTabla();
        
        colNom.setCellValueFactory(new PropertyValueFactory<TabAgregar, String>("nombreP"));
        colAP.setCellValueFactory(new PropertyValueFactory<TabAgregar, String>("apellPP"));
        colAM.setCellValueFactory(new PropertyValueFactory<TabAgregar, String>("apellMP"));
        colP.setCellValueFactory(new PropertyValueFactory<TabAgregar, String>("parentesco"));
        
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
        items_genero.addAll("HOMBRE", "MUJER");
        comboGénero.getItems().clear();
        comboGénero.setItems(items_genero);

        ObservableList items_lugar_nacimiento = FXCollections.observableArrayList();
        items_lugar_nacimiento.addAll("OTRO", "Coneto de Comonfort", "Cuencamé",
                "Victoria de Durango", "El Oro", "Gómez Palacio",
                "Gral. Simón Boívar", "Guadalupe Victoria", "Guanaceví",
                "Hidalgo", "Indé", "Lerdo", "Mapimí", "Mezquital", "Nazas",
                "Nombre de Dios", "Nuevo Ideal", "Ocampo", "Otáez",
                "Pánuco de Coronado", "Peñón Blanco", "Poanas", "Pueblo Nuevo",
                "Rodeo", "San Bernardo", "San Dimas", "San Juan de Guadalupe",
                "San Juan del Río", "San Luis del Cordero", "San Pedro del Gallo",
                "Santa Clara", "Santiago Papasquiaro", "Súchil", "Tamazula", "Tepehuanes",
                "Tlahualilo", "Topia", "Vicente Guerrero");
        comboLugarNac.getItems().clear();
        comboLugarNac.setItems(items_lugar_nacimiento);

        ObservableList items_estado_civil = FXCollections.observableArrayList();
        items_estado_civil.addAll("CASADO", "UNION LIBRE", "SOLTERO", "HIJOS");
        comboEstadoCivil.getItems().clear();
        comboEstadoCivil.setItems(items_estado_civil);

        txtMunicipio.getItems().clear();
        txtMunicipio.setItems(items_lugar_nacimiento);

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

    private void handleFinalizarReporte() {

        numero_expediente = txtReporteNo.getText();
        numero_psicologo = id_usuario_inicio_sesion;
        fecha_evaluacion = String.valueOf(Fechaevaluacion.getValue());
        habla = areaHabla.getText();
        conclucion = areaConclusiones.getText();
        discN = (checkDiscapacidadNo.isSelected()) ? 1 : 0;
        pensamiento = areaPensamiento.getText();
        consciencia = areaConsciencia.getText();
        restriccion = areaRestriccion.getText();
        reportN1 = txtReporteNo1.getText();
        parentescoPPre = txtParentescoPerPresente.getText();
        motivoEva = areaMotivoEvaluacion.getText();
        memorama = (checkMemorama.isSelected()) ? 1 : 0;
        testFam = (checkTestFamilia.isSelected()) ? 1 : 0;
        conductaMotriz = areaConductaMotriz.getText();
        apellido_paterno_paciente = txtApellidoPaternoPerPresente.getText();
        htp = (checkHTP.isSelected()) ? 1 : 0;
        entrevista = (checkEntrevista.isSelected()) ? 1 : 0;
        resultados = areaResultados.getText();
        masa = (checkMasa.isSelected()) ? 1 : 0;
        nombrePerPresente = txtNombrePersonaPresente.getText();
        sugerencias = areaSugerencias.getText();
        memoriaAtnConcen = areaMemoriaAtencionConcentracion.getText();
        testMachover = (checkTestMachover.isSelected()) ? 1 : 0;
        apellidoMaterPerPresente = txtApellidoMaternoPerPresente.getText();
        testGestalico = (checkTestGestalico.isSelected()) ? 1 : 0;
        orientacion = areaOrientacion.getText();
        testApercep = (checkTestApercepcion.isSelected()) ? 1 : 0;
        percepcion = areaPercepcion.getText();
        cuentos = (checkCuentos.isSelected()) ? 1 : 0;
        aparienciaFisica = areaAparienciaFisica.getText();
        rompeCabezas = (checkRompecabezas.isSelected()) ? 1 : 0;
        titeres = (checkTiteres.isSelected()) ? 1 : 0;
        testPersonalLuvia = (checkTestPersonaLluvia.isSelected()) ? 1 : 0;
        discS = (checkDiscapacidadSi.isSelected()) ? 1 : 0;
        inteligencia = areaInteligencia.getText();
        apellidoPatNin = txtApellidoPaternoNinia.getText();
        socializacion = areaSocializacion.getText();
        afectoEmo = areaAfectoEmocion.getText();
        testArbol = (checkTestArbol.isSelected()) ? 1 : 0;
        juguetes = (checkJuguetes.isSelected()) ? 1 : 0;
//     nombres_paciente = txtNombreNinia.getText();
//     apellido_paterno_paciente = txtApellidoMaternoNinia.getText();
//     apellido_materno_paciente = txtApellidoMaternoNinia.getText();
        fecha_nacimiento = String.valueOf(dateNacimientoNinio.getValue());
        lugar_nacimiento = String.valueOf(comboLugarNac.getValue());
        nacionalidad = txtNacionalidad.getText();
        sexo = String.valueOf(comboGénero.getValue());
        escolaridad = txtEscolaridad.getText();
        religion = txtReligion.getText();
        estado_civil = String.valueOf(comboEstadoCivil.getValue());
        cDiscapacidad = txtCualDiscapacidad.getText();
        idioma = txtIdioma.getText();
        grupo_etnico = txtGrupoEtnico.getText();
        Religion = txtReligion.getText();
        Calle = txtCalle.getText();
        Numero = txtNumero.getText();
        Colonia = txtColonia.getText();
        CodigoPos = txtCodigoPostal.getText();
        Municipio = String.valueOf(txtMunicipio.getValue());
    }

    ObservableList<TabAgregar> tablaInterna = FXCollections.observableArrayList();
    int tamanioLista;
    
    @FXML
    void agreg(ActionEvent event) {
        
        mostrarTablaBuscarPeticion();
        //tablaInterna.add(new TabAgregar( txtNombrePersonaPresente.getText(),txtApellidoPaternoPerPresente.getText(),txtApellidoMaternoPerPresente.getText(),txtParentescoPerPresente.getText()));
    }

    private void mostrarTablaBuscarPeticion() {

        try {
           

            tablaInterna.add(new TabAgregar(txtNombrePersonaPresente.getText(), txtApellidoPaternoPerPresente.getText(),
                                               txtApellidoMaternoPerPresente.getText(), txtParentescoPerPresente.getText()));
                
            

            tablaPersonasPresentes.setItems(tablaInterna);
        } catch (Exception e) {
            System.out.println("Error" + e);
        }
    }
    
    //Codigo para ir mostrando al seleccionado
    int posicionColumna = 0;

    static String foliu="";

    private void listenerTabla() {
        final ObservableList<TablePosition> selectedCells = tablaFor.getSelectionModel().getSelectedCells();
        selectedCells.addListener(new ListChangeListener<TablePosition>() {
            @Override
            public void onChanged(ListChangeListener.Change change) {
                for (TablePosition pos : selectedCells) {
                    System.out.println("Cell selected in row " + pos.getRow() + " and column " + pos.getColumn());
                    posicionColumna = pos.getRow();
                }
                if (posicionColumna == 0) {
                    Object folio = tablaFor.getItems().get(tablaFor.getFocusModel().getFocusedIndex());
                    System.out.println(folio);
                }
                mostrarFolio();
            }
        });
    }
    public void mostrarFolio() {
//        id_identi.setText(tablaInterna.get(posicionColumna).getFolioP());
//        foliu = (tablaInterna.get(posicionColumna).getFolioP());

    }
    
    @FXML
    private void eliminarTablaPersonasPresentes(ActionEvent event){
        System.out.println("Eliminar");
       // TablaVictmas = new TableView<TablaVictima>();
        tablaInterna.remove(posicionColumna);
        tablaPersonasPresentes.setItems(tablaInterna);
    }

    @FXML
    void terminEnvia(ActionEvent event) {
        //handleFinalizarReporte();
        
        //VALIDACIONES ANTES DE ENVIAR
        String discapacidad = "";
        String tecnicas_utilizadas = "";
        String material_psicopedagogico = "";
        
        //discapacidad
        if(checkDiscapacidadNo.isSelected()){
            discapacidad = "NO";
        }
        if(checkDiscapacidadSi.isSelected()){
            discapacidad = "SI";
        }
        
        //tecnicas utilizadas
        if(checkEntrevista.isSelected()){
            tecnicas_utilizadas += "ENTREVISTA,";
        }
        if(checkHTP.isSelected()){
            tecnicas_utilizadas += "HTP (HOUSE-TREE-PERSON,";
        }
        if(checkTestArbol.isSelected()){
            tecnicas_utilizadas += "TEST DEL ARBOL,";
        }
        if(checkTestFamilia.isSelected()){
            tecnicas_utilizadas += "TEST DE LA FAMILIA,";
        }
        if(checkTestMachover.isSelected()){
            tecnicas_utilizadas += "TEST DE MACHOVER,";
        }
        if(checkTestApercepcion.isSelected()){
            tecnicas_utilizadas += "TEST DE APERCEPCION INFANTIL,";
        }
        if(checkTestPersonaLluvia.isSelected()){
            tecnicas_utilizadas += "TEST DE PERSONA BAJO LA LLUVIA,";
        }
        
        //MATERIAL PSICOPEDAGOGICO
        if(checkTestGestalico.isSelected()){
            material_psicopedagogico += "TEST GESTALICO VISOMOTOR BENDER,";
        }
        if(checkRompecabezas.isSelected()){
            material_psicopedagogico += "ROMPECABEZAS (EN FUNCION DE LAS EDADES),";
        }
        if(checkJuguetes.isSelected()){
            material_psicopedagogico += "JUGUETES (CARROS, PELUCHES, MUÑECAS),";
        }
        if(checkMasa.isSelected()){
            material_psicopedagogico += "MASA (PLAY DOH),";
        }
        if(checkMemorama.isSelected()){
            material_psicopedagogico += "MEMORAMA,";
        }
        if(checkCuentos.isSelected()){
            material_psicopedagogico += "CUENTOS,";
        }
        if(checkTiteres.isSelected()){
            material_psicopedagogico += "TITERES,";
        }
        
        Conexion conexion = new Conexion();
        
        //AGREGAR EVALUACION PSICOLOGIA
        EvaluacionPsicologia agrega = new EvaluacionPsicologia();//*********AREGLO--->>>>>*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>Aqui debe ser String>>> y >>>>AQUI>
        agrega.agregarEvaluacionPsicologia(conexion.cadena_conexion(), Global.id_psicologo,
                                            String.valueOf(Fechaevaluacion.getValue()), obtenerHoraActual(),
                                            obtenerFechaSistema(), obtenerHoraActual(),
                                            String.valueOf(dateNacimientoNinio.getValue()),
                                            comboLugarNac.getSelectionModel().getSelectedItem().toString(),
                                            txtNacionalidad.getText(), comboGénero.getSelectionModel().getSelectedItem().toString(),
                                            txtEscolaridad.getText(), txtReligion.getText(),
                                            comboEstadoCivil.getSelectionModel().getSelectedItem().toString(),
                                            discapacidad, txtCualDiscapacidad.getText(), txtIdioma.getText(),
                                            txtIdioma.getText(), txtGrupoEtnico.getText(), areaRestriccion.getText(),
                                            areaMotivoEvaluacion.getText(), tecnicas_utilizadas, "", material_psicopedagogico,
                                            "", Integer.parseInt(Global.id_peticion), txtReporteNo.getText());
        
        int ultimo_id_evaluacion = agrega.seleccionarUltimoEvaluacionPsicologia(conexion.cadena_conexion());
        
        //AGREGAR PERSONAS PRESENTES
        PersonaPresentesEvaluacion personas_presentes = new PersonaPresentesEvaluacion();
        
        System.out.println(tablaInterna.size());
        
    }
    
    public void resetearCampos(){
        
            txtReporteNo.setText("");
            txtNombreNinia.setText("");
            txtApellidoPaternoNinia.setText("");
            txtApellidoMaternoNinia.setText("");
            dateNacimientoNinio.setPromptText("");
            Fechaevaluacion.setPromptText("");
            comboLugarNac.setPromptText("");
            txtNacionalidad.setText("");
            comboGénero.setPromptText("");
            txtEscolaridad.setText("");
            comboEstadoCivil.setPromptText("");
            
            checkDiscapacidadNo.setSelected(false);
            checkDiscapacidadSi.setSelected(false);
            
            
            txtCualDiscapacidad.setText("");
            txtIdioma.setText("");
            txtGrupoEtnico.setText("");
            txtReligion.setText("");
            
            txtCalle.setText("");
            txtNumero.setText("");
            txtColonia.setText("");
            txtCodigoPostal.setText("");
            txtMunicipio.setPromptText("");
            
            checkEntrevista.setSelected(false);
            checkHTP.setSelected(false);
            checkTestArbol.setSelected(false);
            checkTestFamilia.setSelected(false);
            checkTestMachover.setSelected(false);
            checkTestApercepcion.setSelected(false);
            checkTestPersonaLluvia.setSelected(false);
    }

    @FXML
    void soloGuardaa(ActionEvent event) {
        handleFinalizarReporte();

    }
    
    public String obtenerFechaSistema()
    {
        Calendar fechaSistema= Calendar.getInstance();
        return fechaSistema.get(Calendar.DAY_OF_MONTH) + "/" + (fechaSistema.get(Calendar.MONTH)+1) + "/" + fechaSistema.get(Calendar.YEAR);
    }
    
    public static String obtenerHoraActual() {
    Date hoy = new Date();
    SimpleDateFormat formateador = new SimpleDateFormat("hh:mm:ss");
    return formateador.format(hoy);
    }


    @FXML
    private TableColumn<TabAgregar, String> colAP;
    @FXML
    private TableColumn<TabAgregar, String> colAM;
    @FXML
    private TableColumn<TabAgregar, String> colP;
    @FXML
    private TableColumn<TabAgregar, String> colNom;

    @FXML
    private TableView<TabAgregar> tablaFolios = new TableView<>();
    @FXML
    private TableView<TabAgregar> tablaFor = new TableView<>();
    @FXML
    private TableView<TabAgregar> tablaPersonasPresentes = new TableView<>();
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
    
    @FXML
    private JFXButton btnEliminarTabla, btnTerminarEnviar;

}
