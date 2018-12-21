/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_final2;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import tl.Gestor;

/**
 *
 * @author LVO-27111989
 */
public class GestorUsuario implements Initializable
{
    Gestor gt = new Gestor();
    
    ObservableList listaGeneros = FXCollections.observableArrayList();
    
    
    
    @FXML
    Button botonCrearUsuario ;
    @FXML
    TextField espacioCedula;
    @FXML
    TextField espacioUsuarioNom;
    @FXML
    TextField espacioApUno;
    @FXML
    TextField espacioApDos;
    @FXML
    TextField espacioMail;
    @FXML
    TextField espacioClaveUno;
    @FXML
    ChoiceBox <String> dropGenero;

    public GestorUsuario() 
    {
        this.botonCrearUsuario = new Button();
        this.espacioCedula = new TextField();
        this.espacioUsuarioNom = new TextField();
        this.espacioApUno = new TextField();
        this.espacioApDos = new TextField();
        this.espacioMail = new TextField();
        this.espacioClaveUno = new TextField();
        this.dropGenero = new ChoiceBox();
        
        
    }
    
    @FXML
    public void desplegarGeneros()
    {  
        listaGeneros.removeAll(listaGeneros);
        
        String f = "Femenino";
        String m = "Masculino";
        
        listaGeneros.addAll(f,m);
        
        dropGenero.getItems().addAll(listaGeneros);
//        dropGenero.getItems().clear();
    }
    

    public void crearUsuario(ActionEvent e) throws IOException
    {
        String ced = espacioCedula.getText();
        String nom = espacioUsuarioNom.getText();
        String apellUno = espacioApUno.getText();
        String apellDos = espacioApDos.getText();
        String correo = espacioMail.getText();
        String gen = dropGenero.getValue();
        String clave = espacioClaveUno.getText();
        
        gt.crearUsuario(ced, nom, apellUno, apellDos, correo, gen, clave);
//        Stage ventanaActual = (Stage) botonCrearUsuario.getScene().getWindow();
//        ventanaActual.close();
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) 
    {
        desplegarGeneros();

    }

    
}
