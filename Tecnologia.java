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
public class Tecnologia 
{
    private String codigo;
    private String nombre;

    public Tecnologia() 
    {
        
    }

    public Tecnologia(String codigo, String nombre) 
    {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public String getCodigo() 
    {
        return codigo;
    }

    public void setCodigo(String codigo) 
    {
        this.codigo = codigo;
    }

    public String getNombre() 
    {
        return nombre;
    }

    public void setNombre(String nombre) 
    {
        this.nombre = nombre;
    }

    @Override
    public String toString() 
    {
        return "Tecnologia:" + "codigo=" + codigo + ", nombre=" + nombre;
    }
    
}
