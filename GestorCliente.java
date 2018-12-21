/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_final2;

import accesoBaseDatos.Conector;
import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import tl.Gestor;
/**
 *
 * @author LVO-27111989
 */
public class GestorCliente implements Initializable
{
    Gestor gt = new Gestor();
    
    ObservableList listaTipos;
    ObservableList listaProvincias;
    ObservableList listaCantones;
    ObservableList listaDistritos;
    
    @FXML
    ChoiceBox <String> creaTipoCliente;
    @FXML
    ChoiceBox <String> creaProvCliente;
    @FXML
    ChoiceBox <String> creaCantCliente;
    @FXML
    ChoiceBox <String> creaDistrCliente;
    
    @FXML
    TextField creaIdContacto;
    @FXML
    TextField creaNomContacto;
    @FXML
    TextField creaAUnoContacto;
    @FXML
    TextField creaADosContacto;
    @FXML
    TextField creaTelefonoCliente;
    @FXML
    TextField creaEmailContacto;
    @FXML
    TextField creaIdJuridico;
    @FXML
    TextField creaNomJuridico;

    public GestorCliente() 
    {
        listaTipos = FXCollections.observableArrayList();
        listaProvincias = FXCollections.observableArrayList();
        listaCantones = FXCollections.observableArrayList();
        listaDistritos = FXCollections.observableArrayList();
        creaTipoCliente = new ChoiceBox();
        this.creaProvCliente  = new ChoiceBox();
        this.creaCantCliente = new ChoiceBox();
        this.creaDistrCliente = new ChoiceBox();
        this.creaIdContacto = new TextField();
        this.creaNomContacto = new TextField();
        this.creaAUnoContacto = new TextField();
        this.creaADosContacto = new TextField();
        this.creaTelefonoCliente = new TextField();
        this.creaEmailContacto = new TextField();
        this.creaIdJuridico = new TextField();
        this.creaNomJuridico = new TextField();
    }
    
    
    public void desplegarTipo()
    {
        creaTipoCliente.getItems().clear();
        listaTipos.removeAll(listaTipos);
        
        String f = "Físico";
        String j = "Jurídico";
        
        listaTipos.addAll(f,j);
        
        creaTipoCliente.getItems().addAll(listaTipos);
    }
    
    public void desplegarProvincia()
    {
        try
        {
            creaProvCliente.getItems().clear();
            listaProvincias = FXCollections.observableList(gt.listaProvincias());
            creaProvCliente.getItems().addAll(listaProvincias);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public void desplegarCanton()
    {
        String provincia = creaProvCliente.getValue();
        try
        {
            creaCantCliente.getItems().clear();
            listaCantones = FXCollections.observableList(gt.listaCantones(creaProvCliente.getValue()));
            creaCantCliente.getItems().addAll(listaCantones);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public void desplegarDistrito()
    {
        String canton = creaCantCliente.getValue();
        try
        {
            creaDistrCliente.getItems().clear();
            listaDistritos = FXCollections.observableList(gt.listaDistritos(creaCantCliente.getValue()));
            creaDistrCliente.getItems().addAll(listaDistritos);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public void crearCliente(ActionEvent e)
    {
        String tipo = this.creaTipoCliente.getValue();
        System.out.println(tipo);
        String ced = this.creaIdContacto.getText();
        String nom = this.creaNomContacto.getText();
        String aUno = this.creaAUnoContacto.getText();
        String aDos = this.creaADosContacto.getText();
        String tel = this.creaTelefonoCliente.getText();
        String correo = this.creaEmailContacto.getText();
        String prov = this.creaProvCliente.getValue();
        String cant = this.creaCantCliente.getValue();
        String distr = this.creaDistrCliente.getValue();
        String cedJ = this.creaIdJuridico.getText();
        String nomJ = this.creaNomJuridico.getText();
        
        if(tipo.startsWith("F"))
        {
            gt.crearClienteFisico(prov, cant, distr, tel, ced, nom, aUno, aDos, correo, tipo);
        }
        else if(tipo.startsWith("J"))
        {
            gt.crearClienteJuridico(prov, cant, distr, tel, ced, nom, aUno, aDos, correo, tipo, cedJ, nomJ);
        }
        else
        {
            System.out.println("No esta leyendo bien el tipo");
        }
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) 
    {
        desplegarTipo();
        desplegarProvincia();
        
    }
}
