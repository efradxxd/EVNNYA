/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evnnya_coord_ases_jur;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author lucia
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    JFXButton btnActualizar, btnReportesNuevos, btnReasignacionReportes;
    @FXML
    Pane pnlReasignacionReportes,pnl_reportes_nuevos;
    
//    @FXML
//    JFXComboBox combo_asesor_juridico;
//    @FXML
//    Pane pnl_bandeja_entrada, pnl_estadisticas;
//    @FXML
//    JFXButton btn_bandeja_entrada, btn_reporte_estadistico;
//    
    @FXML
    private void handleButtonAction(ActionEvent event) {
      
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }    
    
    @FXML
    public void btnActualizar(ActionEvent event) {
        
    }
    @FXML
    void actualizarNuevoReporte(ActionEvent event) {

    }

   
    @FXML
    void asignarAJ(ActionEvent event) {
        try{
            FXMLLoader nuevaVentana= new FXMLLoader(getClass().getResource("FXMLAsignarAJ.fxml"));
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
    void panelReasignacionReportes(ActionEvent event) {
        try{
            FXMLLoader nuevaVentana= new FXMLLoader(getClass().getResource("FXMLReasignacionExp.fxml"));
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
    void  panelReportesNuevos(ActionEvent event) {
        System.out.println("Panel nuevo");
        pnlReasignacionReportes.setVisible(false);
        pnl_reportes_nuevos.setVisible(true);
    }
    
    @FXML
    void verPanelReasignacion(ActionEvent event) {
        pnlReasignacionReportes.setVisible(true);
        pnl_reportes_nuevos.setVisible(false);
    }
    
    
     @FXML
    private JFXButton btnVerReportes;

   
    @FXML
    private JFXButton btnActualizarReasignarRep;


    @FXML
    private JFXButton btnCerrarSesion;

    @FXML
    private JFXButton btnAsignarAJ;

    @FXML
    private JFXButton btnActualizarNuevoReporte;

    @FXML
    private JFXButton btnReasignarReporte;

    @FXML
    private Pane pnlNuevosReportes;
    
    @FXML
    private TableView<TablaBandejaReportes> TablaBandejaReportes = new TableView<TablaBandejaReportes>();
    
}
