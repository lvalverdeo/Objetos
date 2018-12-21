/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl;

import java.util.*;
/**
 *
 * @author LVO-27111989
 */
public class Bitacora 
{
    private ArrayList<Registro> listaRegistros;
    private String codigo;

    public Bitacora() 
    {
        this.listaRegistros = new ArrayList<>();
    }

    public Bitacora(String codigo, Registro actividad) 
    {
        this.codigo = codigo;
        this.listaRegistros = new ArrayList<>();
        listaRegistros.add(actividad);
    }

    public ArrayList<Registro> getListaActividades() 
    {
        return listaRegistros;
    }

    public void setActividad(Registro a) 
    {
        this.listaRegistros.add(a);
    }

    public String getCodigo() 
    {
        return codigo;
    }

    public void setCodigo(String codigo) 
    {
        this.codigo = codigo;
    }
    
    public String getProyecto()
    {
        String infoProyecto;
        
        if(listaRegistros.isEmpty())
        {
            infoProyecto=null;
        }
        else
        {
            infoProyecto = listaRegistros.get(0).getLaActividad().getElProyecto().getCodigo()+
                    " - "+listaRegistros.get(0).getLaActividad().getElProyecto().getNombre();
        }
        
        return infoProyecto;
    }
    
    @Override
    public String toString() 
    {
        return "Bitacora:" + codigo + ", Proyecto: "+getProyecto();
    }
    
    
}
