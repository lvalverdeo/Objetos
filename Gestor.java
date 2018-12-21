/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tl;

import accesoBaseDatos.Conector;
import bl.*;
import dl.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
/**
 *
 * @author LVO-27111989
 */
public class Gestor 
{
    private MultiCliente clienteCL;
    private MultiProyecto proyectoCL;
    private MultiUsuario usuarioCL;
    public Usuario u= new Usuario();
    public String correo;

    public Gestor() 
    {
        clienteCL = new MultiCliente();
        proyectoCL = new MultiProyecto();
        usuarioCL = new MultiUsuario();
        u = new Usuario();
    }
    
    public void crearUsuario(String ced,String nom,String apellUno,String apellDos,String correo,String gen,String clave)
    {
        String genero;
        if(gen.equals("Femenino"))
        {
            genero = "F";
        }
        else
        {
            genero = "M";
        }
        
        try
        {
            usuarioCL.crearUsuario(ced, nom, apellUno, apellDos, correo, genero, clave);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public boolean validarContrasenna(String correo,String clave)
    {
        boolean correcto = false;
        correcto = usuarioCL.validarContrasenna(correo, clave);
        
        if(correcto==true)
        {
            u = usuarioCL.getUsuarioBD(correo);
            guardarCorreoUsuario(correo);
        }
        return usuarioCL.validarContrasenna(correo, clave);
    }
    
    public ArrayList<String> listaProvincias()
    {
        return clienteCL.listaProvincias();
    }
    
    public ArrayList<String> listaCantones(String p)
    {
        return clienteCL.listaCantones(p);
    }
    
    public ArrayList<String> listaDistritos(String c)
    {
        return clienteCL.listaDistritos(c);
    }
    
    public void crearClienteJuridico(String provincia, String canton, String distrito, String telefono,String cedula,
       String nombre, String apellidoUno, String apellidoDos, String correo,String tipo,String id_empresa,String empresa)
    {
        clienteCL.crearClienteJuridico(provincia, canton, distrito, telefono, cedula, nombre, apellidoUno, apellidoDos, correo, tipo, id_empresa, empresa);
    }
    
    public void crearClienteFisico(String provincia, String canton, String distrito, String telefono,String cedula,
            String nombre, String apellidoUno, String apellidoDos, String correo,String tipo)
    {
        clienteCL.crearClienteFisico(provincia, canton, distrito, telefono, cedula, nombre, apellidoUno, apellidoDos, correo, tipo);
    }
    
    public Usuario getUsuarioBD(String email)
    {
        Usuario elUsuario = usuarioCL.getUsuarioBD(email);
        
        return elUsuario;
    }
    
    public ArrayList<String> getClientes()
    {
        ArrayList<String> listaClientes = new ArrayList<String>();
//        System.out.println("Entro al gestor de logica");
        listaClientes = proyectoCL.getClientes();
        
        return listaClientes;
    }
    
    public Cliente getClienteBD(int id)
    {
        Cliente unCliente = new Cliente();
        ResultSet rs = null;
        
        try
        {
            java.sql.CallableStatement cs = Conector.getConector().aplicarProcedimiento("{call infoClienteID(?)}");
            cs.setInt(1, id);
            rs = cs.executeQuery();
            
            String tipo = rs.getString(1);
            String prov = rs.getString(2);
            String cant = rs.getString(3);
            String distr = rs.getString(4);
            String tel = rs.getString(5);
            String ced = rs.getString(6);
            
            if(tipo.startsWith("F"))
            {
                Contacto unContacto = clienteCL.getContacto(ced);
                ClienteFisico unClienteFisico = new ClienteFisico(unContacto.getCedula(),unContacto.getNombre(),
                unContacto.getApellidoUno(),unContacto.getApellidoDos(),prov,cant,distr,tel);
                unCliente = unClienteFisico;
            }
            else if(tipo.startsWith("J"))
            {
                Contacto unContacto = clienteCL.getContacto(ced);
                String[] datosJuridico = clienteCL.datosClienteJuridico(ced);
                String idEmpresa = datosJuridico[0];
                String empresa = datosJuridico[1];
                ClienteJuridico unClienteJuridico= new ClienteJuridico
                    (empresa,idEmpresa,unContacto,prov,cant,distr,tel);
                unCliente = unClienteJuridico;
            }
            else
            {
                unCliente = new Cliente(prov,cant,distr,tel);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return unCliente;
    }
    
    public int getIDCliente(String c)
    {
        String []datos = c.split(" - ");
        String idCliente = datos[1];
        
        int id = Integer.parseInt(idCliente);
        
        return id;
    }
    
//    public void crearProyectoAcademico(String idProy,String nombre,String descripcion,LocalDate fechaInicio,
//            LocalDate fechaFin,Usuario u)
//    {
//        proyectoCL.crearProyecto(idProy, nombre, descripcion, fechaInicio, LocalTime.MIN, fechaFin, LocalTime.MIN);
//    }
    
    public void crearProyectoAcademico(String idProy,String nombre,String descripcion,LocalDate fechaInicio,
            LocalDate fechaFin,String correo)
    {
        proyectoCL.crearProyectoAcademico(idProy, nombre, descripcion, fechaInicio, fechaFin, correo);
    }
    
    public void crearProyectoComercial(String idProy,String nombre,String descripcion,LocalDate fechaInicio,
            LocalDate fechaFin,String correo,int idCliente)
    {
        proyectoCL.crearProyectoComercial(idProy, nombre, descripcion, fechaInicio, fechaFin,correo, idCliente);
    }
    
    public void guardarCorreoUsuario(String mail)
    {
        correo=mail;
    }
    
    public void guardarCorreoTexto(String mail)
    {
        try 
        {
            FileWriter writer = new FileWriter("Correo.txt", true);
            BufferedWriter buffer = new BufferedWriter(writer);

            buffer.write(mail);
            buffer.newLine();

            buffer.close();
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
    }
    
    public String getCorreoTXT()
    {
//        ArrayList<String> lista = new ArrayList<>();
        String correo="";
        try
        {
            FileReader reader = new FileReader("Correo.txt");
            BufferedReader buffer = new BufferedReader(reader);
//            String datos;
            correo =buffer.readLine();
            //el bufferedReader extrae cada línea, y verrifica si el resultado es nulo. Si es nulo es que ya llegó al final del texto.
            //De ahi la condición del ciclo while.
            
            reader.close();//se cierra el reader.
        }
        catch(IOException e)
        {
            e.printStackTrace();//se imprime la pila de llamadas para ver dónde está el error.
        }
        
        return correo;
    }
}
