/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evnnya_mr;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import conecciones.Conexion;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import procedimientos.Custodia;
import procedimientos.Direcciones;
import procedimientos.Reportes;
import procedimientos.Victima;
import utilidades.DatosSesion;

/**
 *
 * @author lucia
 */
public class FXMLMRController implements Initializable {

    @FXML
    JFXButton btn_recepcion, btn_custodia, btn_victima, btn_agresor, btn_vulnerabilidad, btn_resenia, btn_archivos;
    @FXML
    Pane pnl_recepcion, pnl_custodia, pnl_victima, pnl_agresor, pnl_vulnerabilidad, pnl_archivos;
    @FXML
    JFXCheckBox check_persona_moral, check_persona_fisica;
    @FXML
    JFXComboBox  combo_sexo_denunciante, combo_sexo_victima, combo_sexo_agresor, combo_estado_civil_agresor, combo_sexo_tutela, combo_escolaridad_victima, combo_escolaridad_denunciante, combo_escolaridad_agresor, combo_escolaridad_tutela;
    @FXML
    Button btnAdmin;
    @FXML
    ImageView iv_buscar_reporte;
    @FXML
    JFXTextField txt;
    
    //VARIABLES FXML JAHIR
    
    @FXML
    private JFXTextField txtRecibioReporte;
    @FXML
    private JFXTextField txtNumeroOficioReporte;
    @FXML
    private JFXTextField txtFechaReporte;
    @FXML
    private JFXTextField txtQuienEnviaReporte;
    @FXML
    private JFXRadioButton rbAnonimo;
    @FXML
    private JFXRadioButton rbPublico;
    @FXML
    private JFXRadioButton rbPrivado;
    @FXML
    private JFXRadioButton rbDirecta;
    @FXML
    private JFXRadioButton rbPersonal;
    @FXML
    private JFXRadioButton rbViaTelefonica;
    @FXML
    private JFXRadioButton rbEscrita;
    
    @FXML
    private JFXTextField txtApellidoPaternoReporte;
    @FXML
    private JFXTextField txtApellidoMaternoReporte;
    @FXML
    private JFXTextField txtNombreReporte;
    @FXML
    private JFXTextField txtEdadReporte;
    @FXML
    private JFXTextField txtRelacionReporte;
    @FXML
    private JFXTextField txtCalleReporte;
    @FXML
    private JFXTextField txtNumeroReporte;
    @FXML
    private JFXTextField txtColoniaReporte;
    @FXML
    private JFXTextField txtCodigoPostalReporte;
    @FXML
    private JFXTextField txtTelefonoFijoReporte;
    @FXML
    private JFXTextField txtTelefonoMovilReporte;
    @FXML
    private JFXTextField txtCorreoElectronicoReporte;
    @FXML
    private TextArea txtResena;
    @FXML
    private TextArea txtObservaciones;
    
    //CUSTODIA
    @FXML
    private JFXTextField txtNombreCustodia;
    @FXML
    private JFXTextField txtApellidoPaternoCustodia;
    @FXML
    private JFXTextField txtApellidoMaternoCustodia;
    @FXML
    private JFXTextField txtEdadCustodia;
    @FXML
    private JFXTextField txtRelacionCustodia;
    @FXML
    private JFXTextField txtCalleCustodia;
    @FXML
    private JFXTextField txtNumeroCustodia;
    @FXML
    private JFXTextField txtColoniaCustodia;
    @FXML
    private JFXTextField txtCodigoPostalCustodia;
    @FXML
    private JFXTextField txtTelefonoFijoCustodia;
    @FXML
    private JFXTextField txtTelefonoMovilCustodia;
    @FXML
    private JFXTextField txtCorreoElectronicoCustodia;
    
    @FXML
    JFXButton btn_finalizar_reporte;
    
    //VARIABLES NO FXML
    final ToggleGroup tipo_oficio = new ToggleGroup();
    final ToggleGroup tipo_denuncia = new ToggleGroup();

    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("Presiono: " + event.getTarget().toString());
        if (event.getTarget() == btn_recepcion) {
            pnl_recepcion.setVisible(true);
            pnl_custodia.setVisible(false);
            pnl_victima.setVisible(false);
            pnl_agresor.setVisible(false);
            pnl_vulnerabilidad.setVisible(false);
            pnl_archivos.setVisible(false);

        } else if (event.getTarget() == btn_custodia) {
            pnl_recepcion.setVisible(false);
            pnl_custodia.setVisible(true);
            pnl_victima.setVisible(false);
            pnl_agresor.setVisible(false);
            pnl_vulnerabilidad.setVisible(false);
            pnl_archivos.setVisible(false);

        } else if (event.getTarget() == btn_victima) {
            pnl_recepcion.setVisible(false);
            pnl_custodia.setVisible(false);
            pnl_victima.setVisible(true);
            pnl_agresor.setVisible(false);
            pnl_vulnerabilidad.setVisible(false);
            pnl_archivos.setVisible(false);

        } else if (event.getTarget() == btn_agresor) {
            pnl_recepcion.setVisible(false);
            pnl_custodia.setVisible(false);
            pnl_victima.setVisible(false);
            pnl_agresor.setVisible(true);
            pnl_vulnerabilidad.setVisible(false);
            pnl_archivos.setVisible(false);

        } else if (event.getTarget() == btn_vulnerabilidad) {
            pnl_recepcion.setVisible(false);
            pnl_custodia.setVisible(false);
            pnl_victima.setVisible(false);
            pnl_agresor.setVisible(false);
            pnl_vulnerabilidad.setVisible(true);
            pnl_archivos.setVisible(false);

        } else if (event.getTarget() == btn_resenia) {
            pnl_recepcion.setVisible(false);
            pnl_custodia.setVisible(false);
            pnl_victima.setVisible(false);
            pnl_agresor.setVisible(false);
            pnl_vulnerabilidad.setVisible(false);
            pnl_archivos.setVisible(false);

        } else if (event.getTarget() == btn_archivos) {
            pnl_recepcion.setVisible(false);
            pnl_custodia.setVisible(false);
            pnl_victima.setVisible(false);
            pnl_agresor.setVisible(false);
            pnl_vulnerabilidad.setVisible(false);
            pnl_archivos.setVisible(true);
            try {
                FXMLLoader nuevaVentana = new FXMLLoader(getClass().getResource("FXMLBusqueda.fxml"));
                Parent padre = (Parent) nuevaVentana.load();
                Stage escenario = new Stage();
                escenario.setScene(new Scene(padre));
                escenario.setResizable(false);
                escenario.sizeToScene();
                escenario.show();
            } catch (Exception e) {
                System.out.println("ERROR BUSQUEDA " + e);
            }

        } else if (event.getTarget() == check_persona_moral) {
            check_persona_fisica.setSelected(false);
            txtApellidoPaternoReporte.setText("MORAL");
            txtApellidoMaternoReporte.setText("MORAL");
        } else if (event.getTarget() == check_persona_fisica) {
            check_persona_moral.setSelected(false);
        } else if (event.getTarget() == iv_buscar_reporte) {

        }

    }

    @FXML
    private void eventoBoton(ActionEvent evento) {
        if (evento.getTarget() == btnAdmin) {
            try {
                FXMLLoader nuevaVentana = new FXMLLoader(getClass().getResource("FXMLBusqueda.fxml"));
                Parent padre = (Parent) nuevaVentana.load();
                Stage escenario = new Stage();
                escenario.setScene(new Scene(padre));
                escenario.setResizable(false);
                escenario.sizeToScene();
                escenario.show();
            } catch (Exception e) {
                System.out.println("ERROR BUSQUEDA " + e);
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        listenerTabla();
        inicializarColumnas();
        
        File af = new File("C:\\evnnya\\archivo.evn");

        if (af.exists()) {

            DatosSesion datos_sesion = new DatosSesion();

            try {

                datos_sesion.traerDatos();
                Global.id = datos_sesion.getId();
                Global.nombres = datos_sesion.getNombres();
                Global.apellido_paterno = datos_sesion.getApe_paterno();
                Global.apellido_materno = datos_sesion.getApe_materno();
                Global.departamento = datos_sesion.getDepartamento();
                Global.tipo_usuario = datos_sesion.getTipo_usuario();

                System.out.println(Global.nombres);

                txtRecibioReporte.setText((Global.nombres+" "+Global.apellido_paterno+" "+Global.apellido_materno).toUpperCase());
                
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
            
            
            
            
        }else{
            JOptionPane.showMessageDialog(null, "DEBE INICIAR SESION");
            System.exit(0);
        }
        
        //Jahir
        
        rbAnonimo.setToggleGroup(tipo_oficio);
        rbAnonimo.setUserData("0");
        rbPublico.setToggleGroup(tipo_oficio);
        rbPublico.setUserData("1");
        rbPrivado.setToggleGroup(tipo_oficio);
        rbPrivado.setUserData("2");
        
        rbDirecta.setToggleGroup(tipo_denuncia);
        rbDirecta.setUserData("DIRECTA");
        rbPersonal.setToggleGroup(tipo_denuncia);
        rbPersonal.setUserData("PERSONAL");
        rbViaTelefonica.setToggleGroup(tipo_denuncia);
        rbViaTelefonica.setUserData("VIA TELEFONICA");
        rbEscrita.setToggleGroup(tipo_denuncia);
        rbEscrita.setUserData("ESCRITA");
        
        //Jahir
        

        //DECLARACIÓN DE LISTAS PARA LOS COMBO BOX
        String[] sexos = new String[]{"Desconocido", "Hombre", "Mujer"};
        String[] escolaridades = new String[]{"Ninguna", "Primaria incompleta", "Primaria completa", "Secundaria incompleta",
            "Secundaria completa", "Estudios técnicos con primaria", "Preparatoria incompleta", "Preparatoria completa",
            "Estudios técnicos con preparatoria", "Licenciatura incompleta", "Licenciatura completa", "Postgrado"};
        String[] estados_civies = new String[]{"Soltero", "Casado", "Divorciado", "Separado", "Unión libre", "Viudo"};

        //SE RELLENA CADA COMBO BOX CON SU ARRAY CORRESPONDIENTE
        combo_sexo_denunciante.getItems().addAll(sexos);
        combo_sexo_victima.getItems().addAll(sexos);
        combo_sexo_agresor.getItems().addAll(sexos);
        combo_sexo_tutela.getItems().addAll(sexos);
        combo_estado_civil_agresor.getItems().addAll(estados_civies);
        combo_escolaridad_victima.getItems().addAll(escolaridades);
        combo_escolaridad_denunciante.getItems().addAll(escolaridades);
        combo_escolaridad_tutela.getItems().addAll(escolaridades);
        combo_escolaridad_agresor.getItems().addAll(escolaridades);
    }
    ObservableList<TablaVictima> tablaVictima = FXCollections.observableArrayList();;

    @FXML
    private void anadirVictimaTabla(ActionEvent event){
        System.out.println("anadir");
        //TablaVictmas = new TableView<TablaVictima>();
        tablaVictima.add(new TablaVictima(txtNom.getText(), txtApePa.getText(), txtApeMa.getText(),
                                         (String) combo_sexo_victima.getValue(), (String) combo_escolaridad_victima.getValue(),
                                          txtRela.getText(), txtCo.getText(), txtTeFi.getText(), txtTeMo.getText(),
                                          Integer.parseInt(txtEdad.getText())));
        TablaVictmas.setItems(tablaVictima);
        
    }
  
    @FXML
    private void eliminarTablaVictima(ActionEvent event){
        System.out.println("Eliminar");
       // TablaVictmas = new TableView<TablaVictima>();
        tablaVictima.remove(posicionColumna);
        TablaVictmas.setItems(tablaVictima);
    }
    private void inicializarColumnas(){
        
        System.out.println("Columnas");
        
        colApeMa.setCellValueFactory(new PropertyValueFactory<TablaVictima,String>("apeMa"));
        colApePa.setCellValueFactory(new PropertyValueFactory<TablaVictima,String>("apePa"));
        colCorreo.setCellValueFactory(new PropertyValueFactory<TablaVictima,String>("correoE"));
        colEdad.setCellValueFactory(new PropertyValueFactory<TablaVictima,Integer>("edad"));
        colEsco.setCellValueFactory(new PropertyValueFactory<TablaVictima,String>("escolaridad"));
        colNomV.setCellValueFactory(new PropertyValueFactory<TablaVictima,String>("nom"));
        colRela.setCellValueFactory(new PropertyValueFactory<TablaVictima,String>("relacion"));
        colSexo.setCellValueFactory(new PropertyValueFactory<TablaVictima,String>("sexo"));
        colTeleFi.setCellValueFactory(new PropertyValueFactory<TablaVictima,String>("telefonoFi"));
        colTeleMo.setCellValueFactory(new PropertyValueFactory<TablaVictima,String>("telefonoMo"));
    }
    
    int posicionColumna = 0;
    private void listenerTabla(){
    final ObservableList<TablePosition> selectedCells = TablaVictmas.getSelectionModel().getSelectedCells();
    selectedCells.addListener(new ListChangeListener<TablePosition>() {
        @Override
        public void onChanged(ListChangeListener.Change change) {
            for (TablePosition pos : selectedCells) {
               System.out.println("Cell selected in row "+pos.getRow()+" and column "+pos.getColumn());
                posicionColumna = pos.getRow();
            }
        }
    }); 
    }
        
    
   
    public String obtenerHora() {
        Calendar fechaSistema = Calendar.getInstance();
        return fechaSistema.get(Calendar.HOUR) + ":" + (fechaSistema.get(Calendar.MINUTE)) + ":" + fechaSistema.get(Calendar.SECOND);
    }
    
    public String obtenerFechaSistema() {
        Calendar fechaSistema = Calendar.getInstance();
        return fechaSistema.get(Calendar.DAY_OF_MONTH) + "/" + (fechaSistema.get(Calendar.MONTH) + 1) + "/" + fechaSistema.get(Calendar.YEAR);
    }

    
    @FXML
    private void eventoFinalizarReporte(ActionEvent evento) {
        
        
        
        Conexion conexion = new Conexion();
        Direcciones direccion = new Direcciones();
        
        //ENVIAR CUSTODIA
        direccion.agregarDireccion(conexion.cadena_conexion(), txtCalleCustodia.getText().toUpperCase(),
                                    txtNumeroCustodia.getText().toUpperCase(), txtColoniaCustodia.getText().toUpperCase(),
                                    Integer.parseInt(txtCodigoPostalCustodia.getText()),"", "", "VICTORIA DE DURANGO",
                                    "", txtCorreoElectronicoCustodia.getText().toUpperCase(), txtTelefonoFijoCustodia.getText(),
                                    txtTelefonoMovilCustodia.getText());
        
        Custodia custodia = new Custodia();
        custodia.agregarCustodia(conexion.cadena_conexion(), txtNombreCustodia.getText().toUpperCase(),
                                txtApellidoPaternoCustodia.getText().toUpperCase(),
                                txtApellidoMaternoCustodia.getText().toUpperCase(), Integer.parseInt(txtEdadCustodia.getText()),
                                combo_sexo_tutela.getSelectionModel().toString(),
                                combo_escolaridad_tutela.getSelectionModel().toString(),
                                txtRelacionCustodia.getText().toUpperCase(), "", "", "", "", "", 0, "");
        
        //ENVIAR REPORTE //agregar primero custodia
            Reportes reporte = new Reportes();
            
            String medio_reporte = tipo_denuncia.getSelectedToggle().getUserData().toString();
            String tipo_oficio_anom = tipo_oficio.getSelectedToggle().getUserData().toString();
            
            System.out.println(tipo_oficio.getSelectedToggle().getUserData().toString());
            
            reporte.agregarReporte(conexion.cadena_conexion(), "", 1, this.obtenerFechaSistema(),
                                this.obtenerHora(), Integer.parseInt(Global.id), txtNumeroOficioReporte.getText().toUpperCase(),
                                txtFechaReporte.getText().toUpperCase(), txtQuienEnviaReporte.getText().toUpperCase(), medio_reporte,
                                Integer.parseInt(tipo_oficio_anom), 2, txtResena.getText().toUpperCase(),
                                txtObservaciones.getText().toUpperCase(), "VICTORIA DE DURANGO", "REPORTE EXPEDIDO");
            
        //ENVIAR VICTIMAS
            Victima victima = new Victima();
            
            direccion.agregarDireccion(conexion.cadena_conexion(), txtCa.getText().toUpperCase(), txtNu.getText(), txtColo.getText().toUpperCase(), Integer.parseInt(txtCodigo.getText()),
                                        txtEntre.getText().toUpperCase(), "", "VICTORIA DE DURANGO", areaCaracteri.getText().toUpperCase(), txtCo.getText().toUpperCase(),
                                        txtTeFi.getText(), txtTeMo.getText());
            
            
            
    }
    
    
    @FXML
    private TableColumn<TablaVictima, String> colRela;

    @FXML
    private JFXTextField txtTeFi;

    @FXML
    private JFXTextField txtEdad;

    @FXML
    private JFXTextField txtApeMa;

    @FXML
    private TableColumn<TablaVictima, String> colCorreo;

    @FXML
    private TableView<TablaVictima> TablaVictmas = new TableView<TablaVictima>();

    @FXML
    private JFXCheckBox check_15;

    @FXML
    private ImageView iv_buscar_reporte111;

    @FXML
    private JFXCheckBox check_14;

    @FXML
    private JFXTextField txtTeMo;

    @FXML
    private JFXCheckBox check_13;

    @FXML
    private JFXCheckBox check_12;

    @FXML
    private TableColumn<TablaVictima, String> colNomV;

    @FXML
    private JFXCheckBox check_19;

    @FXML
    private JFXCheckBox check_18;

    @FXML
    private JFXCheckBox check_17;

    @FXML
    private JFXCheckBox check_16;

    @FXML
    private TableColumn<TablaVictima, Integer> colEdad;

    @FXML
    private JFXTextField txtEntre;

    @FXML
    private Pane pnl;

    @FXML
    private JFXCheckBox check_21;

    @FXML
    private JFXCheckBox check_20;

    @FXML
    private TableColumn<TablaVictima, String> colApeMa;
    
    @FXML
    private ImageView iv_buscar_reporte1;

    @FXML
    private ImageView iv_buscar_reporte1111;

    @FXML
    private JFXTextField txtCo;

    @FXML
    private JFXCheckBox check_31;

    @FXML
    private JFXTextField txtCa;

    @FXML
    private JFXCheckBox check_5;

    @FXML
    private JFXCheckBox check_6;

    @FXML
    private JFXCheckBox check_3;

    @FXML
    private Pane pnl_persona_fisica11;

    @FXML
    private JFXCheckBox check_4;

    @FXML
    private JFXCheckBox check_1;

    @FXML
    private JFXCheckBox check_2;

    @FXML
    private JFXComboBox<String> comboMuni;

    @FXML
    private TextArea areaCaracteri;

    @FXML
    private JFXTextField txtCodigo;

    @FXML
    private ImageView iv_buscar_reporte11111;

    @FXML
    private Pane pnl_persona_fisica3;

    @FXML
    private Pane pnl_persona_fisica1;

    @FXML
    private JFXTextField txtApePa;

    @FXML
    private TableColumn<TablaVictima, String> colEsco;

    @FXML
    private JFXTextField txtNu;

    @FXML
    private ImageView iv_buscar_reporte11;

    @FXML
    private AnchorPane root;

    @FXML
    private JFXTextField txtRela;

    @FXML
    private TableColumn<TablaVictima, String> colTeleMo;

    @FXML
    private JFXTextField txtColo;

    @FXML
    private TableColumn<TablaVictima, String> colSexo;

    @FXML
    private JFXCheckBox check_9;

    @FXML
    private TableColumn<TablaVictima ,String> colApePa;

    @FXML
    private JFXCheckBox check_7;

    @FXML
    private Pane pnl_persona_fisica;

    @FXML
    private TableColumn<TablaVictima, String> colTeleFi;

    @FXML
    private JFXCheckBox check_8;

    @FXML
    private JFXTextField txtNom;
    
}
