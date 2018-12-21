/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl;

/**
 *
 * @author LVO-27111989
 */
public class Usuario 
{
    private String cedula;
    private String nombre;
    private String apellidoUno;
    private String apellidoDos;
    private String correo;
    private char genero;
    private String clave;

    public Usuario() 
    {
        this.cedula ="Sin ID";
        this.nombre =" ";
        this.apellidoUno =" ";
        this.apellidoDos =" ";
        this.correo = "muestras@prueba.cr";
        this.genero = 'M';
    }

    public Usuario(String cedula, String nombre, String apellidoUno, String apellidoDos, String correo,int genero) 
    {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellidoUno = apellidoUno;
        this.apellidoDos = apellidoDos;
        this.correo = correo;
        
        if(genero==1)
        {
            this.genero = 'F';
        }
        else
        {
            this.genero = 'M';
        }
    }
    
    public Usuario(String cedula, String nombre, String apellidoUno, String apellidoDos, String correo,String genero,String clave) 
    {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellidoUno = apellidoUno;
        this.apellidoDos = apellidoDos;
        this.correo = correo;
        this.clave = clave;
        this.genero = genero.charAt(0);
        
    }
    
    public String getCedula() 
    {
        return cedula;
    }

    public void setCedula(String cedula) 
    {
        this.cedula = cedula;
    }

    public String getNombre() 
    {
        return nombre;
    }

    public void setNombre(String nombre) 
    {
        this.nombre = nombre;
    }

    public String getApellidoUno() 
    {
        return apellidoUno;
    }

    public void setApellidoUno(String apellidoUno) 
    {
        this.apellidoUno = apellidoUno;
    }

    public String getApellidoDos() 
    {
        return apellidoDos;
    }

    public void setApellidoDos(String apellidoDos) 
    {
        this.apellidoDos = apellidoDos;
    }

    public String getCorreo() 
    {
        return correo;
    }

    public void setCorreo(String correo) 
    {
        this.correo = correo;
    }

    public char getGenero() 
    {
        return genero;
    }

    public void setGenero(char genero) 
    {
        this.genero = genero;
    }

    public String getClave() 
    {
        return clave;
    }

    public void setClave(String clave) 
    {
        this.clave = clave;
    }

    @Override
    public String toString() 
    {
        return "Usuario: " + "cedula=" + cedula + ", nombre=" + nombre + ", apellidoUno=" + apellidoUno + ", apellidoDos=" + apellidoDos + ", correo=" + correo + ", genero=" + genero;
    }
    
        
}
