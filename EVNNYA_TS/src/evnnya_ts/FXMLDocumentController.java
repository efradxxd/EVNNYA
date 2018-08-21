/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evnnya_ts;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import conecciones.Conexion; 
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import procedimientos.PeticionesTrabajoSocial;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.swing.JOptionPane;


public class FXMLDocumentController implements Initializable {
    private static int id_direccion;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        mostrarTablaBandejaEntrada();
        listenerTabla();
        txtFolio.setText("");
    }    

    public static int getId_direccion() {
        return id_direccion;
    }

    public static void setId_direccion(int id_direccion) {
        FXMLDocumentController.id_direccion = id_direccion;
    }

    @FXML
    void buscarAnexo(ActionEvent event) {
        try{
            FXMLLoader nuevaVentana= new FXMLLoader(getClass().getResource("FXMLBuscarAnexo.fxml"));
            Parent padre= (Parent)nuevaVentana.load();
            Stage escenario= new Stage();
            escenario.setScene(new Scene(padre));
            escenario.setResizable(false);
            escenario.sizeToScene();
            escenario.show();
        }catch(Exception e){
        
        }
    }   
    @FXML
    void btn_verPeticiones() {
        try{

            FXMLLoader nuevaVentana= new FXMLLoader(getClass().getResource("FXMLBuscarPeticiones.fxml"));
            Parent padre= (Parent)nuevaVentana.load();
            Stage escenario= new Stage();
            escenario.setScene(new Scene(padre));
            escenario.setResizable(false);
            escenario.sizeToScene();
            escenario.show();

        }catch(Exception e){
        
        }
    }
    @FXML
    void btn_verDatosVisita() {
        try{
            System.out.println("Hola");
            if(!"".equals(txtFolio.getText())){
            id_direccion = Integer.parseInt(txtFolio.getText());
            System.out.println("id direccion "+id_direccion);
            FXMLLoader nuevaVentana= new FXMLLoader(getClass().getResource("FXMLDatosVisita.fxml"));
            Parent padre= (Parent)nuevaVentana.load();
            Stage escenario= new Stage();
            escenario.setScene(new Scene(padre));
            escenario.setResizable(false);
            escenario.sizeToScene();
            escenario.show();
            }else
                JOptionPane.showMessageDialog(null, "Debe seleccionar un folio de la tabla");
            }catch(Exception e){
        
        }
    }
    
   String numero_expediente;
   ObservableList<BandejaEntrada> tablaInterna = FXCollections.observableArrayList();     
   
   @FXML
    private void mostrarTablaBandejaEntrada(){
      if(tablaInterna.size() != 0)
          tablaInterna = FXCollections.observableArrayList();
          
      
        try {
           
           PeticionesTrabajoSocial peticion = new PeticionesTrabajoSocial();
           Conexion conexion = new Conexion();
           peticion.seleccionarBandejaPeticionesTS(conexion.cadena_conexion());
           
           List<String> numeroDeFolio = peticion.getListaIdPeticion();
           List<String> fecha = peticion.getListaFechaEnvio();
           List<String> direccion = peticion.getListaDireccionCompleta();
           
           
           
            for (int i = 0; i < direccion.size(); i++) 
                tablaInterna.add(new BandejaEntrada(numeroDeFolio.get(i),
                                                    fecha.get(i),
                                                    direccion.get(i)));
            
            columnDireccion.setCellValueFactory(new PropertyValueFactory<BandejaEntrada, String>("direccion"));
            columnFecha.setCellValueFactory(new PropertyValueFactory<BandejaEntrada, String>("fecha"));
            columnNumeroFolio.setCellValueFactory(new PropertyValueFactory<BandejaEntrada, String>("numeroFolio"));
           
           tablaBandejaEntrada.setItems(tablaInterna);
        } catch (Exception e) {
            System.out.println("Error"+e);
        }
    }
    
    
    
    
    
    
    
    @FXML
    private JFXButton btn_datos_ninio111;

    @FXML
    private TableColumn<BandejaEntrada,String> columnFecha;
    
    @FXML
    private TableColumn<BandejaEntrada, String> columnDireccion;

    @FXML
    private TableColumn<BandejaEntrada, String> columnNumeroFolio;
    
    @FXML
    private TableView<BandejaEntrada> tablaBandejaEntrada = new TableView<>();

    @FXML
    private JFXButton btnBuscarA;

    @FXML
    private JFXButton btn_ver_peticiones;

    @FXML
    private Label txtUsuario,txtFolio;

    @FXML
    private JFXButton btnActualizar;

    @FXML
    private JFXButton btn_ver;
    
    
    private void listenerTabla(){
    final ObservableList<TablePosition> selectedCells = tablaBandejaEntrada.getSelectionModel().getSelectedCells();
    selectedCells.addListener(new ListChangeListener<TablePosition>() {
        @Override
        public void onChanged(ListChangeListener.Change change) {
           TablePosition pos = tablaBandejaEntrada.getSelectionModel().getSelectedCells().get(0);
            row = pos.getRow();
            obtenerObservable(row);
            //Item item tablaBandejaEntrada.getItems().get(row);
            
        }
    }); 
    }
    int row;
    private void obtenerObservable(int row){
        System.out.println(row);
        txtFolio.setText(tablaInterna.get(row).getNumeroFolio());
    }

}
