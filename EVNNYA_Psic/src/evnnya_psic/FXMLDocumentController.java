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
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import procedimientos.PeticionesPsicologia;
import conecciones.Conexion;
import javafx.collections.ListChangeListener;
import javafx.scene.control.TablePosition;
import javax.swing.JOptionPane;
import procedimientos.Agresor;
import procedimientos.Custodia;
import procedimientos.PeticionesMedico;
import procedimientos.Victima;

/**
 *
 * @author lucia
 */
public class FXMLDocumentController implements Initializable {

    List<String> idPaciente;
    List<String> tipoPaciente;
    
    Conexion con = new Conexion();
    PeticionesPsicologia psicologia = new PeticionesPsicologia();
    static int usuario = 2;

    @FXML
    JFXButton btn_formato_terapia, btn_buscar, btn_cerrar_sesion, btn_ver, btnActualizar;

    public void TraerPeticiones() {
        psicologia.seleccionarBandejaPeticionesPsi(con.cadena_conexion(), usuario/* int id_receptor*/);

    }

    @FXML
    void formatoTerapia() {

        try {
            FXMLLoader nuevaVentana = new FXMLLoader(getClass().getResource("FXMLFormatoPsic.fxml"));
            Parent padre = (Parent) nuevaVentana.load();
            Stage escenario = new Stage();
            escenario.setScene(new Scene(padre));
            escenario.setResizable(false);
            escenario.sizeToScene();
            escenario.show();
        } catch (Exception e) {

        }
    }

    @FXML
    void buscar(ActionEvent event) {
        try {
            FXMLLoader nuevaVentana = new FXMLLoader(getClass().getResource("FXMLBuscar.fxml"));
            Parent padre = (Parent) nuevaVentana.load();
            Stage escenario = new Stage();
            escenario.setScene(new Scene(padre));
            escenario.setResizable(false);
            escenario.sizeToScene();
            escenario.show();
        } catch (Exception e) {

        }
    }

    @FXML
    void btn_ver(ActionEvent event) {
        if (fila==-1) {
            JOptionPane.showMessageDialog(null, "No hay ningun folio Seleccionado");
        }
        else
        {
            try {
            FXMLLoader nuevaVentana = new FXMLLoader(getClass().getResource("FXMLDatosPsic.fxml"));
            Parent padre = (Parent) nuevaVentana.load();
            Stage escenario = new Stage();
            escenario.setScene(new Scene(padre));
            escenario.setResizable(false);
            escenario.sizeToScene();
            escenario.show();
        } catch (Exception e) {

        }
        }
        
    }

    @FXML
    void btn_BuscarPeticion(ActionEvent event) {
        try {
            FXMLLoader nuevaVentana = new FXMLLoader(getClass().getResource("FXMLBuscarPeticion.fxml"));
            Parent padre = (Parent) nuevaVentana.load();
            Stage escenario = new Stage();
            escenario.setScene(new Scene(padre));
            escenario.setResizable(false);
            escenario.sizeToScene();
            escenario.show();
        } catch (Exception e) {

        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        cargarTabla();
        listenerBandeja();
    }
    static int fila = -1;
    PeticionesPsicologia peticion = new PeticionesPsicologia();
    List<String> numeroExp = peticion.getListaIdPeticion();

    public void cargarTabla() {
        listenerBandeja();
        //numeroExp="",fecha="",gravedad="",nombrePac="";
        TableColumn<BandejaEntrada, String> columnPeticion = new TableColumn<>("Número de petición");
        columnPeticion.setCellValueFactory(new PropertyValueFactory<BandejaEntrada, String>("numeroExp"));

        TableColumn<BandejaEntrada, String> columnFecha = new TableColumn<>("Fecha");
        columnFecha.setCellValueFactory(new PropertyValueFactory<BandejaEntrada, String>("fecha"));

        TableColumn<BandejaEntrada, String> columnGravedad = new TableColumn<>("Gravedad");
        columnGravedad.setCellValueFactory(new PropertyValueFactory<BandejaEntrada, String>("gravedad"));

        TableColumn<BandejaEntrada, String> columnNombre = new TableColumn<>("Nombre del paciente");
        columnNombre.setCellValueFactory(new PropertyValueFactory<BandejaEntrada, String>("nombrePac"));

        if (tablaInterna.size() != 0) {
            tablaInterna = FXCollections.observableArrayList();
        }

        try {
            PeticionesPsicologia peticion = new PeticionesPsicologia();
            Conexion conexion = new Conexion();
            peticion.seleccionarBandejaPeticionesPsi(conexion.cadena_conexion(), usuario/*int id_receptor*/);

            //peticion.
            numeroExp = peticion.getListaIdPeticion();
            List<String> fecha = peticion.getListaFechaEnvio();
            List<String> gravedad = peticion.getListaGravedad();
            List<String> nombrePac = peticion.getListaNombre();
            idPaciente = peticion.getListaIdPaciente();
            tipoPaciente = peticion.getListaTipoPaciente();

            tamanioLista = fecha.size();
            for (int i = 0; i < numeroExp.size(); i++) {
                
                if(nombrePac.get(i).length()<5){
                    
                    if(tipoPaciente.get(i).equalsIgnoreCase("victima")){
                        
                        Victima victima = new Victima();
                        victima.seleccionarVictima(conexion.cadena_conexion(), Integer.parseInt(idPaciente.get(i)));
                        
                        tablaInterna.add(new BandejaEntrada(numeroExp.get(i),
                        fecha.get(i), gravedad.get(i), victima.getNombres()));
                        
                    }else if(tipoPaciente.get(i).equalsIgnoreCase("agresor")){
                        
                        Agresor agresor = new Agresor();
                        agresor.seleccionarAgresor(conexion.cadena_conexion(), Integer.parseInt(idPaciente.get(i)));
                        
                        tablaInterna.add(new BandejaEntrada(numeroExp.get(i),
                        fecha.get(i), gravedad.get(i), agresor.getNombre()+" "+agresor.getApellido_paterno()+" "+agresor.getApellido_materno()));
                        
                    }else if(tipoPaciente.get(i).equalsIgnoreCase("custodia")){
                        
                        Custodia custodia = new Custodia();
                        custodia.seleccionarCustodia(conexion.cadena_conexion(), Integer.parseInt(idPaciente.get(i)));
                        
                        tablaInterna.add(new BandejaEntrada(numeroExp.get(i),
                        fecha.get(i), gravedad.get(i), custodia.getNombres()+" "+custodia.getApellido_paterno()+" "+custodia.getApellido_materno()));
                        
                    }
                    
                    
                }else{
                    tablaInterna.add(new BandejaEntrada(numeroExp.get(i),
                        fecha.get(i), gravedad.get(i), nombrePac.get(i)));
                }
            }

            for (int j = 0; j < numeroExp.size(); j++) {
                System.out.println(numeroExp.get(j) + " " + nombrePac.get(j));
            }

        } catch (Exception e) {
            System.out.println("Error" + e);
        }
        tablaBandeja.getColumns().addAll(columnPeticion, columnFecha, columnGravedad, columnNombre);
        tablaBandeja.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        tablaBandeja.setItems(tablaInterna);
    }

    //Codigo para ir mostrando al seleccionado
    int posicionColumna = 0;

    static int pos = 2;
    int sicion = 0;
    
    
    
    private void listenerBandeja() {
        final ObservableList<TablePosition> selectedCells = tablaBandeja.getSelectionModel().getSelectedCells();
        selectedCells.addListener(new ListChangeListener<TablePosition>() {
            @Override
            public void onChanged(ListChangeListener.Change change) {
                for (TablePosition pos : selectedCells) {
                    System.out.println("Cell selected in row " + pos.getRow() + " and column " + pos.getColumn());
                    posicionColumna = pos.getRow();
                    sicion = pos.getRow();

                    Global.id_paciente = idPaciente.get(pos.getRow());
                    Global.tipo_paciente = tipoPaciente.get(pos.getRow());
                    
                }
                if (posicionColumna == 0) {
                    Object folio = tablaBandeja.getItems().get(tablaBandeja.getFocusModel().getFocusedIndex());
                    System.out.println(folio);
                }
                mostrarIndice();
            }
        });
    }

        public void mostrarIndice() {
        fila = Integer.parseInt(numeroExp.get(sicion));
        indice.setText(String.valueOf(fila));
        Global.id_peticion = String.valueOf(fila);
    }

    public static int getFila() {
        return fila;
    }

    public static void setFila(int fila) {
        FXMLDocumentController.fila = fila;
    }
        
        
    int tamanioLista;
    ObservableList<BandejaEntrada> tablaInterna = FXCollections.observableArrayList();

    @FXML
    private Label indice;
    @FXML
    private TableColumn<BandejaEntrada, String> columnFecha;

    @FXML
    private TableColumn<BandejaEntrada, String> columnExpediente;

    @FXML
    private TableColumn<BandejaEntrada, String> columnNombre;

    @FXML
    private TableColumn<BandejaEntrada, String> columnGravedad;

    @FXML
    private TableView<BandejaEntrada> tablaBandeja = new TableView<>();

}
