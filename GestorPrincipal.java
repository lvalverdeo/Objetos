/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_final2;

import accesoBaseDatos.Conector;
import bl.Actividad;
import bl.Registro;
//import com.mysql.jdbc.CallableStatement;
import java.io.IOException;
import java.net.URL;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author LVO-27111989
 */
public class GestorPrincipal implements Initializable
{
    @FXML
    Button botonRegistrarCliente;
    
    ObservableList listaBitacora;
    ObservableList listaRegistro;
    GestorUI loginInicio = new GestorUI();
    String correo=loginInicio.mail;
    
    @FXML
    ChoiceBox<String> bitacora;
    @FXML
    TableColumn columnaFecha;
    @FXML
    TableColumn columnaHora;
    @FXML
    TableColumn columnaActividad;
    @FXML
    TableColumn columnaDescripcion;
    @FXML
    TableView tablaActividades;

    public GestorPrincipal() 
    {
        botonRegistrarCliente = new Button();
        bitacora = new ChoiceBox();
        this.listaBitacora= FXCollections.observableArrayList();
        this.columnaFecha = new TableColumn<>("Fecha");
        this.columnaHora = new TableColumn<>("Hora");
        this.columnaActividad = new TableColumn<>("Actividad");
        this.columnaDescripcion = new TableColumn<>("Descripción");
    }
    
    public void desplegarBitacora()
    {
        ArrayList<String> listaProyectos = new ArrayList<>();
        ResultSet rs = null;
        try
        {
            CallableStatement cs = Conector.getConector().aplicarProcedimiento("call listar_proyectos()");
//            cs.execute();
            rs =cs.executeQuery();
            
            while(rs.next())
            {
                String p = rs.getString(1);
                listaProyectos.add(p);
            }
            this.listaBitacora = FXCollections.observableArrayList(listaProyectos);
            this.bitacora.getItems().clear();
            this.bitacora.getItems().addAll(listaBitacora);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    public void handleGoToRegistroCliente() throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource("CrearCliente.fxml"));
        Stage ventana = new Stage();
        Scene vista = new Scene(root);
        ventana.setScene(vista);
        
        ventana.show();
    }
    public void handleGoToCrearProyecto() throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource("CrearProyecto.fxml"));
        Stage ventana = new Stage();
        Scene vista = new Scene(root);
        ventana.setScene(vista);
        
        ventana.show();
    }
    public void handleGoToAgregarTec() throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource("AgregarTecnologia.fxml"));
        Stage ventana = new Stage();
        Scene vista = new Scene(root);
        ventana.setScene(vista);
        
        ventana.show();
    }
    
    public void llenarTabla()
    {
        String proyecto = bitacora.getValue();
        ArrayList<Registro> listaRegistros = new ArrayList<>();
        ResultSet rs = null;
        try
        {
            CallableStatement cs = Conector.getConector().aplicarProcedimiento("{call traerBitacoraPorProyecto(?)}");
            cs.setString(1,proyecto);
            
            rs = cs.executeQuery();
            
            while(rs.next())
            {
               Date tmpFecha = rs.getDate(1);
               LocalDate fecha = tmpFecha.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
               Time tmpHora = rs.getTime(2);
               LocalTime hora = tmpHora.toLocalTime();
               String nom = rs.getString(3);
               String desc = rs.getString(4);
               
               Registro unRegistro = new Registro(new Actividad(nom,desc,proyecto),fecha,hora);
               listaRegistros.add(unRegistro);
            }
            this.columnaFecha.setCellValueFactory(new PropertyValueFactory<>("fechaInicio"));
            this.columnaHora.setCellValueFactory(new PropertyValueFactory<>("horaInicio"));
            this.columnaActividad.setCellValueFactory(new PropertyValueFactory<>("nombre"));
            this.columnaDescripcion.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public ObservableList<Registro> getObservableListTabla(ArrayList<Registro> listaR)
    {
        listaRegistro = FXCollections.observableArrayList(listaR);
        
        return listaRegistro;
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) 
    {
        llenarTabla();
    }
    
}
