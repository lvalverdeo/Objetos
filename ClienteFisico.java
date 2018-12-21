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
public class ClienteFisico extends Cliente
{
    private String cedula;
    private String nombre;
    private String apellidoUno;
    private String apellidoDos;
    private String correo;

    public ClienteFisico() 
    {
        
    }

    public ClienteFisico(String cedula,String nombre, String apellidoUno, String apellidoDos, String correo, String provincia, String canton, String distrito, String telefono) 
    {
        super(provincia, canton, distrito, telefono);
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellidoUno = apellidoUno;
        this.apellidoDos = apellidoDos;
        this.correo = correo;
    }
    
    public ClienteFisico(String cedula,String nombre, String apellidoUno, String apellidoDos, String provincia, String canton, String distrito, String telefono) 
    {
        super(provincia, canton, distrito, telefono);
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellidoUno = apellidoUno;
        this.apellidoDos = apellidoDos;
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

    @Override
    public String toString() {
        return "ClienteFisico: " + "nombre=" + nombre + ", apellidoUno=" + apellidoUno + ", apellidoDos=" + apellidoDos + ", correo=" + correo + super.toString();
    }
    
    
    
    
}
