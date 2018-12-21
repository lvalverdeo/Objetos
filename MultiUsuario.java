/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dl;

import bl.*;
import accesoBaseDatos.*;
//import com.sun.xml.internal.messaging.saaj.util.CharReader;
//import com.sun.xml.internal.ws.org.objectweb.asm.Type;
import java.sql.*;
import java.io.*;
import java.sql.SQLType;
//import jdk.internal.org.objectweb.asm.Type;

/**
 *
 * @author LVO-27111989
 */
public class MultiUsuario 
{
    Usuario elUsuario= new Usuario();
    

    public MultiUsuario() 
    {
        elUsuario = new Usuario();
    }
    
    public void crearUsuario(String ced, String nom,String apellUno,String apellDos,String correo,String gen,String clave) throws SQLException
    {
        
        int genCode =0;
        
        if("F".equals(gen))
        {
            genCode = 1;  
        }
        else
        {
            
        }
        
        Usuario nuevoUsuario = new Usuario(ced,nom,apellUno,apellDos,correo,genCode);
        
        try
        {
            CallableStatement cs = Conector.getConector().aplicarProcedimiento("{call crear_usuario(?,?,?,?,?,?,?)}");
            cs.setString(1,ced);
            cs.setString(2,nom);
            cs.setString(3,apellUno);
            cs.setString(4,apellDos);
            cs.setString(5,correo);
            cs.setString(6,gen);
            cs.setString(7,clave);
            cs.executeQuery();
//            int idUser = getIDUsuario(correo);
//            creaClave(nuevoUsuario,clave,idUser);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public void creaClave(Usuario u,String clave,int id)
    {
        u.setClave(clave);
        
        int idUser=0;
        
        try
        {
            idUser=id;
            CallableStatement csDos = Conector.getConector().aplicarProcedimiento("{call crear_clave(?,?)}");
            csDos.setInt(1, idUser);
            csDos.setString(2, clave);
            csDos.executeQuery();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public int getIDUsuario(String email)
    {
        int idUser = 0;
        try
        {
            CallableStatement cs = Conector.getConector().aplicarProcedimiento("{call obtener_idUsuario(?,?)}");
            cs.setString(1, email);
            cs.registerOutParameter(2,5);//Entero SQLType 5
//            System.out.println("Tipo entero:"+Type.INT);
            cs.execute();
            
            idUser = cs.getInt(2);
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return idUser;
    }
    
    public boolean validarContrasenna(String correo,String clave)
    {
        boolean claveCorrecta=false;
        
        try
        {
            CallableStatement cs = Conector.getConector().aplicarProcedimiento("{call validacion_acceso(?,?,?)}");
            cs.setString(1, correo);
            cs.setString(2, clave);
            cs.registerOutParameter(3,1);//Boolean es SQLType 1
     
            cs.execute();
            
            claveCorrecta = cs.getBoolean(3);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return claveCorrecta;
    }
    
    public Usuario getUsuarioBD(String email)
    {
        String ced = "";
        String nom = "";
        String aUno = "";
        String aDos = "";
        String correo = email;
        char genero = ' ';
        String clave = "";
        ResultSet rs = null;
        int tipoVarchar = 8;
        try
        {
            CallableStatement cs = Conector.getConector().aplicarProcedimiento("{call obtener_infoUsuario(?,?,?,?,?,?,?)}");
//            System.out.println("Tipo entero:"+Type.CHAR);
            cs.setString(1, email);
            cs.registerOutParameter(2,2);//cedula
            cs.registerOutParameter(3,2);//nombre
            cs.registerOutParameter(4,2);//apellido uno
            cs.registerOutParameter(5,2);//apellido dos
            cs.registerOutParameter(6,2);//genero
            cs.registerOutParameter(7,2);//clave
            
            cs.execute();
            
            elUsuario = new Usuario(cs.getString(2),cs.getString(3),cs.getString(4),cs.getString(5),correo,
                    cs.getString(6),cs.getString(7));
        }    
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        return elUsuario;
    }
    
     public boolean validarCorreoExiste(String correo)
    {
        boolean existe = false;
        
        try
        {
            CallableStatement cs = Conector.getConector().aplicarProcedimiento("{call clave_validacion_correo(?,?)}");
            cs.setString(1, correo);
            cs.registerOutParameter(2,1);//Boolean SQLType 1
            
            cs.execute();
            
            existe = cs.getBoolean(2);
            System.out.println("En MultiUsuario resultado query: "+existe);
        }
        catch(Exception e)
        {
//            e.printStackTrace();
        }
        
        return existe;
    }
}
