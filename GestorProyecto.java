/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_final2;

import bl.Cliente;
import java.sql.Date;
import java.time.LocalDate;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import tl.Gestor;

/**
 *
 * @author LVO-27111989
 */
public class GestorProyecto 
{
    GestorUI gestorUI = new GestorUI();
    Gestor gt;
    ObservableList listaClientesBD;
    @FXML
    TextField creaCodProyecto;
    @FXML
    TextField creaNomProyecto;
    @FXML
    TextField creaDescProyecto;
    @FXML
    DatePicker creaFechaInicio;
    @FXML
    DatePicker creaFechaFin;
    @FXML
    ChoiceBox<String> listaClientes;
    
    public GestorProyecto() 
    {
        this.gt = new Gestor();
        this.creaCodProyecto = new TextField();
        this.creaNomProyecto = new TextField();
        this.creaDescProyecto = new TextField();
        this.creaFechaInicio = new DatePicker();
        this.creaFechaFin = new DatePicker();
        this.listaClientesBD = FXCollections.observableArrayList();
        this.listaClientes = new ChoiceBox();
    }
    
    public void desplegarClientes()
    {
        try
        {
            listaClientes.getItems().clear();
            listaClientesBD = FXCollections.observableArrayList(gt.getClientes());
            listaClientes.getItems().addAll(listaClientesBD);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public void crearProyecto()
    {
        String cliente = listaClientes.getValue();
        String id = this.creaCodProyecto.getText();
        String nom = this.creaNomProyecto.getText();
        String des = this.creaDescProyecto.getText();
        String correo = gt.getCorreoTXT();
        String tipo = " ";
        LocalDate fechaInicio = this.creaFechaInicio.getValue();
        LocalDate fechaFin = this.creaFechaFin.getValue();
        int idCliente = 0;
        try
        {
            if(cliente==null)
            {
                gt.crearProyectoAcademico(id, nom, des,fechaInicio,fechaFin,correo);

            }
            else
            {
                tipo = "Comercial";
//                Cliente elCliente = gt.getClienteBD(gt.getIDCliente(cliente));
                idCliente = gt.getIDCliente(cliente);
                gt.crearProyectoComercial(id, nom, des, fechaInicio, fechaFin,correo, idCliente);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
