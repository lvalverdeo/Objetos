/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_final2;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 *
 * @author LVO-27111989
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    @FXML
    private Button button;
    @FXML
    private Button prueba;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        try
        {
            FXMLLoader cargadorFXML = new FXMLLoader(getClass().getResource("Ventana2.fxml"));
            Parent root1 = (Parent) cargadorFXML.load();
            Stage tarima = new Stage();
            
            tarima.setTitle("Escenario 2");
            tarima.setScene(new Scene(root1));
            tarima.show();
        }
        catch(Exception e)
        {
            System.out.println("No se puede cargar la ventana");
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handlePrueba(ActionEvent event) 
    {
        System.out.print("Hola");
        label.setText("Hola ula");
    }
    
    @FXML
    private void handleSalir(ActionEvent event)
    {
        System.exit(0);
    }
}
