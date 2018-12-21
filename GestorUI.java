/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_final2;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.fxml.Initializable;
import javafx.scene.*;
import javafx.stage.Stage;
import bl.*;
import dl.MultiUsuario;
import java.awt.event.MouseEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import tl.Gestor;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import testemail.*;
/**
 *
 * @author LVO-27111989
 */
public class GestorUI implements Initializable
{
    Gestor gt = new Gestor();
    ObservableList listaGeneros = FXCollections.observableArrayList();
    @FXML
    MultiUsuario multiUsuario;
    
    @FXML
    AnchorPane AnchorPane = new AnchorPane();
    
    Usuario elUsuario;
    public String mail;
    public int contador=0;
    
    @FXML
    private Button botonIngreso;
    @FXML
    TextField emailEntrada;
    @FXML
    TextField claveEntrada;
    @FXML
    TextField correoOlvidoClave;
    
    @FXML
    Label msgLoginFallido;
    
    public GestorUI() 
    {
        emailEntrada = new TextField();
        claveEntrada = new TextField();
        correoOlvidoClave = new TextField();
        msgLoginFallido = new Label();
//        elUsuario = gt.getUsuarioBD(emailEntrada.getText());
    }
    
    
    @FXML
    public void handleBotonIngreso() throws IOException
    {
        multiUsuario = new MultiUsuario();
        System.out.println("Ingreso");
        String clave = claveEntrada.getText();
        String correo = emailEntrada.getText();
        System.out.println(clave+correo);
        boolean login = gt.validarContrasenna(correo, clave); 
        gt.guardarCorreoTexto(correo);
        if(login==true)
        {
            Parent root = FXMLLoader.load(getClass().getResource("Principal.fxml"));
            Stage ventana = new Stage();
            
            Scene scene = new Scene(root);
            ventana.setScene(scene);
            elUsuario = gt.getUsuarioBD(correo);
            contador++;
            System.out.println(contador);
            mail=correo;
            ventana.show();
        }
        else
        {
            System.out.println("Usuario o clave incorrectas.");
            msgLoginFallido.setTextFill(Color.RED);
            elUsuario = new Usuario();
        }
    }
    
    public void handleBtnEnviarCorreoClave()
    {
        String correo = correoOlvidoClave.getText();
        
        MultiUsuario multi = new MultiUsuario();
        System.out.println(correo);
        boolean validacionCorreo = true;
//        boolean validacionCorreo = multiUsuario.validarCorreoExiste(correo);//Aqui esta el error
        
        System.out.println(multiUsuario.validarCorreoExiste(correo));
        
        if(multiUsuario.validarCorreoExiste(correo)==true) //No he podido probar esto
        {
            Proceso envioMail = new Proceso();
        
            envioMail.run();
        }
        else
        {
            System.out.println("El correo no existe, no se puede enviar correo.");
        }
        
    }
    
    @FXML
    public void crearUsuarioForm() throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource("CrearUsuario.fxml"));
        Stage ventana = new Stage();
        Scene scene = new Scene(root);
        ventana.setScene(scene);
        
        ventana.show();
        
    }
    

    public void olvidoClaveForm() throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource("OlvidoClave.fxml"));
        Stage ventana = new Stage();
        Scene scene = new Scene(root);
        ventana.setScene(scene);
        
        ventana.show();
    }
    

    @Override
    public void initialize(URL location, ResourceBundle resources) 
    {
        
        
    }
}
