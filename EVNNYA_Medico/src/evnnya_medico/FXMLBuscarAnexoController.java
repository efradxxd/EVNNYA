/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evnnya_medico;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import conecciones.Conexion;
import java.net.URL;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import procedimientos.PeticionesMedico;

/**
 * FXML Controller class
 *
 * @author lucia
 */
public class FXMLBuscarAnexoController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        mostrarTablaBuscarAnexo();
    }
    int tamanioLista;

    @FXML
    void verFormato(ActionEvent event) {
        for (int i = 0; i < tamanioLista; i++) {
            if (txtFolioBuscar.getText().equals(tablaInterna.get(i).getFolio())) {
                try {
                    FXMLLoader nuevaVentana = new FXMLLoader(getClass().getResource("FXMLFormatoMedico.fxml"));
                    Parent padre = (Parent) nuevaVentana.load();
                    Stage escenario = new Stage();
                    escenario.setScene(new Scene(padre));
                    escenario.setResizable(false);
                    escenario.sizeToScene();
                    escenario.show();
                } catch (Exception e) {

                }
                break;
            } else {
                JOptionPane.showMessageDialog(null, "No hay ningun folio llamado así");
                 i = tamanioLista + 1;
            }
           
        }//FOR
        

    }

    String numero_expediente;
    ObservableList<BuscarAnexo> tablaInterna = FXCollections.observableArrayList();

    @FXML
    private void mostrarTablaBuscarAnexo() {
        if (tablaInterna.size() != 0) {
            tablaInterna = FXCollections.observableArrayList();
        }

        try {
            PeticionesMedico peticion = new PeticionesMedico();
            Conexion conexion = new Conexion();
            peticion.seleccionarBandejaPeticionesMed(conexion.cadena_conexion());

            //peticion.
            List<String> Folio = peticion.getListaIdPeticion();
            List<String> fecha = peticion.getListaFechaEnvio();
            List<String> numeroE = peticion.getListaGravedad();
            tamanioLista = fecha.size();
            for (int i = 0; i < numeroE.size(); i++) {
                tablaInterna.add(new BuscarAnexo(Folio.get(i),
                        numeroE.get(i),
                        fecha.get(i)));
            }
            colFolio.setCellValueFactory(new PropertyValueFactory<BuscarAnexo, String>("folio"));
            colFecha.setCellValueFactory(new PropertyValueFactory<BuscarAnexo, String>("fecha"));
            colNumeroExpe.setCellValueFactory(new PropertyValueFactory<BuscarAnexo, String>("numeroE"));

            tablaFolios.setItems(tablaInterna);
        } catch (Exception e) {
            System.out.println("Error" + e);
        }
    }
    

    @FXML
    private TableView<BuscarAnexo> tablaFolios = new TableView<>();

    @FXML
    private TableColumn<BuscarAnexo, String> colFecha;

    @FXML
    private JFXTextField txtFolioBuscar;

    @FXML
    private TableColumn<BuscarAnexo, String> colNumeroExpe;

    @FXML
    private TableColumn<BuscarAnexo, String> colFolio;

    @FXML
    private JFXButton btnVerAnexo;
}
