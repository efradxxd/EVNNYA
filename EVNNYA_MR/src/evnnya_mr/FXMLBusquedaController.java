/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evnnya_mr;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;
import procedimientos.*;

/**
 * FXML Controller class
 *
 * @author lucia
 */
public class FXMLBusquedaController implements Initializable {

   
    @FXML
    JFXButton btnExpediente, btnDireccion, btnVictima, btnVictimaDireccion;
    @FXML
    Pane pnlExpediente, pnlDireccion, pnlVictima, pnlVictimaDireccion;
    
    private void handleButton(ActionEvent event){
        if(event.getTarget()==btnExpediente){
            pnlExpediente.setVisible(true);
            pnlDireccion.setVisible(false);
            pnlVictima.setVisible(false);
            pnlVictimaDireccion.setVisible(false);
        } else if(event.getTarget()==btnDireccion){
            pnlExpediente.setVisible(false);
            pnlDireccion.setVisible(true);
            pnlVictima.setVisible(false);
            pnlVictimaDireccion.setVisible(false);
        } else if(event.getTarget()==btnVictima){
            pnlExpediente.setVisible(false);
            pnlDireccion.setVisible(false);
            pnlVictima.setVisible(true);
            pnlVictimaDireccion.setVisible(false);
        } else if(event.getTarget()==btnVictimaDireccion){
            pnlExpediente.setVisible(false);
            pnlDireccion.setVisible(false);
            pnlVictima.setVisible(false);
            pnlVictimaDireccion.setVisible(true);
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
