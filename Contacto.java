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
public class Contacto 
{
    private String cedula;
    private String nombre;
    private String apellidoUno;
    private String apellidoDos;
    private String correo;
    private String telefono;

    public Contacto() 
    {
        
    }

    public Contacto(String cedula, String nombre, String apellidoUno, String apellidoDos, String correo, String telefono) 
    {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellidoUno = apellidoUno;
        this.apellidoDos = apellidoDos;
        this.correo = correo;
        this.telefono = telefono;
    }
    
    public Contacto(String cedula, String nombre, String apellidoUno, String apellidoDos, String telefono) 
    {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellidoUno = apellidoUno;
        this.apellidoDos = apellidoDos;
        this.telefono = telefono;
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

    public String getTelefono() 
    {
        return telefono;
    }

    public void setTelefono(String telefono) 
    {
        this.telefono = telefono;
    }

    @Override
    public String toString() 
    {
        return "Contacto:" + "cedula=" + cedula + ", nombre=" + nombre + ", apellidoUno=" + apellidoUno + ", apellidoDos=" + apellidoDos + ", correo=" + correo + ", telefono=" + telefono;
    }
    
    
}
