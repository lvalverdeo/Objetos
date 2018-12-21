/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dl;

import accesoBaseDatos.Conector;
import bl.*;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
/**
 *
 * @author LVO-27111989
 */
public class MultiCliente 
{

    public MultiCliente() 
    {
        
    }
    
    
    public void crearClienteFisico(String provincia, String canton, String distrito, String telefono,String cedula,
            String nombre, String apellidoUno, String apellidoDos, String correo,String tipo)
    { 
        ClienteFisico unClienteF = new ClienteFisico(cedula,nombre,apellidoUno,apellidoDos,correo,provincia,canton,
                                    distrito,telefono);
        
        try
        {
            CallableStatement cs = Conector.getConector().aplicarProcedimiento("{call crear_cliente(?,?,?,?,?,?,?,?,?)}");
            cs.setString(1, cedula);
            cs.setString(2, nombre);
            cs.setString(3, apellidoUno);
            cs.setString(4, apellidoDos);
            cs.setString(5, telefono);
            cs.setString(6, tipo);
            cs.setString(7, provincia);
            cs.setString(8, canton);
            cs.setString(9, distrito);
            
            cs.execute();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public void crearClienteJuridico(String provincia, String canton, String distrito, String telefono,String cedula,
            String nombre, String apellidoUno, String apellidoDos, String correo,String tipo,String id_empresa,String empresa)
    { 
        Contacto elContacto = new Contacto(cedula,nombre,apellidoUno,apellidoDos,correo,telefono);
        ClienteJuridico unClienteJ = new ClienteJuridico(empresa,id_empresa,elContacto,provincia,canton,distrito,telefono);
        
        try
        {
            CallableStatement cs = Conector.getConector().aplicarProcedimiento(
                    "{call crear_cliente_juridico(?,?,?,?,?,?,?,?,?,?,?)}");
            cs.setString(1, cedula);
            cs.setString(2, nombre);
            cs.setString(3, apellidoUno);
            cs.setString(4, apellidoDos);
            cs.setString(5, telefono);
            cs.setString(6, tipo);
            cs.setString(7, provincia);
            cs.setString(8, canton);
            cs.setString(9, distrito);
            cs.setString(10, empresa);
            cs.setString(11,id_empresa);
            
            cs.execute();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public ArrayList<String> listaProvincias()
    {
        ArrayList<String> provincias = new ArrayList<>();
        
        ResultSet rs = null;
        String sql="";
        try
        {
            sql = "Select provincia from provincias;";
            rs = Conector.getConector().ejecutarSQL(sql, true);
            
            while(rs.next())
            {
                String provincia = rs.getString(1);
                provincias.add(provincia);
            }

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return provincias;
    }
    
    public ArrayList<String> listaCantones(String provincia)
    {
        ArrayList<String> cantones = new ArrayList<>();
        ResultSet rs = null;
        try
        {
            CallableStatement cs = Conector.getConector().aplicarProcedimiento("{call traer_cantones(?)}");
            cs.setString(1, provincia);
            rs = cs.executeQuery();
            
            while(rs.next())
            {
                String c = rs.getString(1);
                cantones.add(c);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return cantones;
    }
    
    public ArrayList<String> listaDistritos(String canton)
    {
        ArrayList<String> distritos = new ArrayList<>();
        ResultSet rs = null;
        try
        {
            CallableStatement cs = Conector.getConector().aplicarProcedimiento("{call traer_distritos(?)}");
            cs.setString(1, canton);
            rs = cs.executeQuery();
            
            while(rs.next())
            {
                String distrito = rs.getString(1);
                distritos.add(distrito);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return distritos;
    }
    
    public Contacto getContacto(String ced)
    {
        Contacto elContacto = new Contacto();
        ResultSet rs = null;
        try
        {
            CallableStatement cs = Conector.getConector().aplicarProcedimiento("{call infoContactoCed(?)}");
            cs.setString(1, ced);
            rs = cs.executeQuery();
            String nom = rs.getString(1);
            String aUno = rs.getString(2);
            String aDos = rs.getString(3);
            String tel = rs.getString(4);
            
            elContacto = new Contacto(ced,nom,aUno,aDos,tel);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return elContacto;
    }
    
    public String[] datosClienteJuridico(String cedContacto)
    {
        String[] datos = new String[2];
        ResultSet rs = null;
        try
        {
            CallableStatement cs = Conector.getConector().aplicarProcedimiento("[call infoClienteJuridicoCed(?)}");
            cs.setString(1, cedContacto);
            rs = cs.executeQuery();
            
            datos[0] = rs.getString(1);
            datos[1] = rs.getString(2);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return datos;
    }
}
