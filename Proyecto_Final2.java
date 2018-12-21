/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_final2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author LVO-27111989
 */
public class Proyecto_Final2 extends Application 
{
    
    @Override
    public void start(Stage stage) throws Exception 
    {
        Parent rootLogin = FXMLLoader.load(getClass().getResource("Login.fxml"));
        
        Scene sceneLogin = new Scene(rootLogin);
        
        stage.setScene(sceneLogin);
        stage.show();
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        launch(args);
        
        
    }
    
}
