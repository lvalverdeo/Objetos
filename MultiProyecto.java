/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dl;

import accesoBaseDatos.*;
import bl.Cliente;
import bl.Registro;
import bl.Usuario;
import java.sql.*;
import java.sql.Date;
import java.sql.JDBCType;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

/**
 *
 * @author LVO-27111989
 */
public class MultiProyecto 
{

    public MultiProyecto() 
    {
        
    }
    
    public void crearProyecto(String idProy,String nombre,String descripcion,LocalDate fechaInicio,
            LocalTime horaInicio,LocalDate fechaFin,LocalTime horaFin)
    {
        
    }
    
//    public void crearProyectoComercial(String idProy,String nombre,String descripcion,LocalDate fechaInicio,LocalDate fechaFin,String cliente)
//    {
//        try
//        {
//            CallableStatement cs = Conector.getConector().aplicarProcedimiento("{call crear_proyecto_comercial()}");
//        }
//        catch(Exception e)
//        {
//            e.printStackTrace();
//        }
//    }
    
    public void crearProyectoAcademico(String idProy,String nombre,String descripcion,LocalDate fechaInicio,
            LocalDate fechaFin,Usuario u)
    {
        Date fechaI = Date.valueOf(fechaInicio);
        Date fechaF = Date.valueOf(fechaFin);
        String tipo = "Académico";
        String correo = u.getCorreo();
        try
        {
            CallableStatement cs = Conector.getConector().aplicarProcedimiento(
                    "{call crear_proyecto_academico(?,?,?,?,?,?,?)}");
            cs.setString(1,idProy);
            cs.setString(2, nombre);
            cs.setString(3,descripcion);
            cs.setDate(4, fechaI);
            cs.setDate(5, fechaF);
            cs.setString(6, tipo);
            cs.setString(7,correo);
            
            cs.execute();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }            
    public void crearProyectoAcademico(String idProy,String nombre,String descripcion,LocalDate fechaInicio,
            LocalDate fechaFin,String correo)
    {
        Date fechaI = Date.valueOf(fechaInicio);
        Date fechaF = Date.valueOf(fechaFin);
        String tipo = "Académico";
        
        try
        {
            CallableStatement cs = Conector.getConector().aplicarProcedimiento(
                    "{call crear_proyecto_academico(?,?,?,?,?,?,?)}");
            cs.setString(1,idProy);
            cs.setString(2, nombre);
            cs.setString(3,descripcion);
            cs.setDate(4, fechaI);
            cs.setDate(5, fechaF);
            cs.setString(6, tipo);
            cs.setString(7,correo);
            
            cs.execute();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }     
    public void crearProyectoComercial(String idProy,String nombre,String descripcion,LocalDate fechaInicio,
            LocalDate fechaFin,String correo,int idCliente)
    {
        Date fechaI = Date.valueOf(fechaInicio);                                                                
        Date fechaF = Date.valueOf(fechaFin);
        String tipo = "Comercial";
         
        try
        {
            CallableStatement cs = Conector.getConector().aplicarProcedimiento(
                    "{call crear_proyecto_comercial(?,?,?,?,?,?,?,?)}");
            cs.setString(1,idProy);
            cs.setString(2, nombre);
            cs.setString(3,descripcion);
            cs.setDate(4, fechaI);
            cs.setDate(5, fechaF);
            cs.setString(6, tipo);
            cs.setString(7,correo);
            cs.setInt(8,idCliente);
            
            cs.execute();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }     
    public ArrayList<String> getClientes()
    {
        ArrayList<String> listaClientes = new ArrayList<String>();
        ResultSet rs = null;
        try
        {
//            System.out.println("Entro al try de MultiProyecto logica");
            CallableStatement cs = Conector.getConector().aplicarProcedimiento("{call listarClientes()}");
            rs = cs.executeQuery();
            
            while(rs.next())
            {
                String c = rs.getString(1);
                listaClientes.add(c);
            }
        }    
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return listaClientes;
    }
    
    public String getIDClienteBD(String ced)
    {
        String id="";
        
        try
        {
            CallableStatement cs = Conector.getConector().aplicarProcedimiento("{call traerIDClienteCed(?,?)}");
            cs.setString(1,ced);
            cs.registerOutParameter(2,JDBCType.INTEGER);
            
            cs.execute();
            
            id= cs.getString(2);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return id;
    }
    
    
}
