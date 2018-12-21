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
public class ClienteJuridico extends Cliente
{
    private String nombre;
    private String identificacion;
    private Contacto elContacto;

    public ClienteJuridico() 
    {
        
    }

    public ClienteJuridico(String nombre, String identificacion, Contacto elContacto, String provincia, String canton, 
            String distrito, String telefono) 
    {
        super(provincia, canton, distrito, telefono);
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.elContacto = elContacto;
    }

    public String getNombre() 
    {
        return nombre;
    }

    public void setNombre(String nombre) 
    {
        this.nombre = nombre;
    }

    public String getIdentificacion() 
    {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) 
    {
        this.identificacion = identificacion;
    }

    public Contacto getElContacto() 
    {
        return elContacto;
    }

    public void setElContacto(Contacto elContacto) 
    {
        this.elContacto = elContacto;
    }

    @Override
    public String toString() 
    {
        return "ClienteJuridico{" + "nombre=" + nombre + ", identificacion=" + identificacion + ", elContacto=" + elContacto + super.toString();
    }
    
    
}
