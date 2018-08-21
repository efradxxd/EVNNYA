/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesionesaparentes;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javax.imageio.ImageIO;

/**
 *
 * @author jahir
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Canvas canvas;
    
    @FXML
    private Button btnGenerarImagen;
    
    @FXML
    private Pane panelCaptura;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        final GraphicsContext gc = canvas.getGraphicsContext2D();
        
        canvas.addEventHandler(MouseEvent.MOUSE_PRESSED, 
        new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {  
                
                
                int x=(int) t.getX();
                int y=(int) t.getY();
                
                if (t.getClickCount() ==1) {
                    reset(canvas, Color.RED, x, y);
                }  
            }
        });
        
    }
    
    @FXML
    private void handleGenerarImagen(ActionEvent event) throws IOException {
        
        WritableImage image = panelCaptura.snapshot(new SnapshotParameters(), null);

        // TODO: probably use a file chooser here
        File file = new File("C:\\evnnya\\lesiones_aparentes.png");

        ImageIO.write(SwingFXUtils.fromFXImage(image, null), "png", file);
        
    }

private void reset(Canvas canvas, Color color, int x, int y) {
    GraphicsContext gc = canvas.getGraphicsContext2D();
    gc.setFill(color);
    gc.fillRect(x, y, 15, 15);
}    
    
    
    
    
}
