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
public class Cliente 
{
//    private String tipo;
    private String provincia;
    private String canton;
    private String distrito;
    private String telefono;

    public Cliente() 
    {
        
    }

    public Cliente(String provincia, String canton, String distrito, String telefono) 
    {
//        this.tipo = tipo;
        this.provincia = provincia;
        this.canton = canton;
        this.distrito = distrito;
        this.telefono = telefono;
    }

//    public String getTipo() 
//    {
//        return tipo;
//    }
//
//    public void setTipo(String tipo) 
//    {
//        this.tipo = tipo;
//    }

    public String getProvincia() 
    {
        return provincia;
    }

    public void setProvincia(String provincia) 
    {
        this.provincia = provincia;
    }

    public String getCanton() 
    {
        return canton;
    }

    public void setCanton(String canton) 
    {
        this.canton = canton;
    }

    public String getDistrito() 
    {
        return distrito;
    }

    public void setDistrito(String distrito) 
    {
        this.distrito = distrito;
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
        return "Cliente:" + "provincia=" + provincia + ", canton=" + canton + ", distrito=" + distrito + ", telefono=" + telefono;
    }
    
    
}
