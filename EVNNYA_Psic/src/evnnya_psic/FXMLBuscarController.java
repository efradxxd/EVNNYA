/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evnnya_psic;

import com.jfoenix.controls.JFXButton;
import conecciones.Conexion;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import procedimientos.PeticionesMedico;
import procedimientos.PeticionesPsicologia;

/**
 * FXML Controller class
 *
 * @author lucia
 */
public class FXMLBuscarController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

    }
    static int usuario = 2;

    @FXML
    void verAnexo() {
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

     ObservableList<BuscarAnxF> tablaInterna = FXCollections.observableArrayList();

    @FXML
    private void mostrarTablaBuscarAnexo() {
        if (tablaInterna.size() != 0) {
            tablaInterna = FXCollections.observableArrayList();
        }

        try {
            PeticionesMedico peticion = new PeticionesMedico();
            Conexion conexion = new Conexion();
            peticion.seleccionarBandejaPeticionesMed(conexion.cadena_conexion(),1/*int id_receptor*/);
            
            //peticion.                            FALTA_PROCEDIMIENTO
            List<String> folio = peticion.getListaIdPeticion();
            List<String> fecha = peticion.getListaFechaEnvio();
            List<String> numeroE = peticion.getListaGravedad();
            tamanioLista = fecha.size();
            for (int i = 0; i < numeroE.size(); i++) {
                tablaInterna.add(new BuscarAnxF(folio.get(i),
                        numeroE.get(i),
                        fecha.get(i)));
            }
            tab_Folio.setCellValueFactory(new PropertyValueFactory<BuscarAnxF, String>("folio"));
            tab_NumeroExp.setCellValueFactory(new PropertyValueFactory<BuscarAnxF, String>("fecha"));
            tab_Fecha.setCellValueFactory(new PropertyValueFactory<BuscarAnxF, String>("numeroE"));

            tablaFolios.setItems(tablaInterna);
        } catch (Exception e) {
            System.out.println("Error" + e);
        }
    }
    void selecionarDatosDePeticionesPsicologia() {
        PeticionesPsicologia peticion = new PeticionesPsicologia();
        Conexion conexion = new Conexion();
        peticion.seleccionarPeticionesPsicologiaIdPeticion(conexion.cadena_conexion(), usuario);

    }
    int tamanioLista;

    @FXML
    private TableColumn<BuscarAnxF, String> tab_NumeroExp;

    @FXML
    private JFXButton btnVerAnexo;

    @FXML
    private TableColumn<BuscarAnxF, String> tab_Folio;

    @FXML
    private TableColumn<BuscarAnxF, String> tab_Fecha;
    @FXML
    private TableView<BuscarAnxF> tablaFolios = new TableView<>();

}
