/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl;

import java.time.*;
import java.util.*;
/**
 *
 * @author LVO-27111989
 */
public class Proyecto 
{
    private String codigo;
    private String nombre;
    private String descripcion;
    private LocalDate fechaInicio;
    private LocalDate fechaFinal;
    private ArrayList<Tecnologia> listaTecnologias;
//    private Cliente elCliente;

    public Proyecto() 
    {
        this.listaTecnologias = new ArrayList<>();
    }

    public Proyecto(String codigo, String nombre, String descripcion,int dia, int mes,int anio) 
    {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaInicio = LocalDate.of(anio, mes, dia);
        this.fechaFinal = null;
        this.listaTecnologias = new ArrayList<>();
    }
    
    public Proyecto(String codigo, String nombre, String descripcion,LocalDate fechaInicio) 
    {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = null;
        this.listaTecnologias = new ArrayList<>();
    }
    
    public Proyecto(String codigo, String nombre, String descripcion,LocalDate fechaInicio,LocalDate fechaFin) 
    {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFin;
        this.listaTecnologias = new ArrayList<>();
    }
    public Proyecto(String codigo, String nombre, String descripcion,int diaI, int mesI,int anioI,int diaF, int mesF,int anioF) 
    {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaInicio = LocalDate.of(anioI, mesI, diaI);
        this.fechaFinal = LocalDate.of(anioF, mesF, diaF);
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

    public String getDescripcion() 
    {
        return descripcion;
    }

    public void setDescripcion(String descripcion) 
    {
        this.descripcion = descripcion;
    }

    public LocalDate getFechaInicio() 
    {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) 
    {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFinal() 
    {
        return fechaFinal;
    }

    public void setFechaFinal(LocalDate fechaFinal) 
    {
        this.fechaFinal = fechaFinal;
    }

    public void setTecnologia(Tecnologia tec) 
    {
        this.listaTecnologias.add(tec);
    }

    public ArrayList<Tecnologia> getListaTecnologias() 
    {
        return listaTecnologias;
    }

    public Tecnologia getTecnologiaCodigo(String codigo) 
    {
        Tecnologia laTecnologia = new Tecnologia();
        
        if(listaTecnologias.isEmpty())
        {
   
        }
        else
        {
            for(Tecnologia tec : listaTecnologias)
            {
                if(codigo.equals(tec.getCodigo()))
                {
                    laTecnologia = tec;
                }
            }
        }
            
        return laTecnologia;
    }
    
    public Tecnologia getTecnologiaNombre(String nombre) 
    {
        Tecnologia laTecnologia = new Tecnologia();
        
        if(listaTecnologias.isEmpty())
        {
            laTecnologia=null;
        }
        else
        {
            for(Tecnologia tec : listaTecnologias)
            {
                if(codigo.equals(tec.getNombre()))
                {
                    laTecnologia = tec;
                }
                else
                {
                    laTecnologia=null;
                }
            }
        }
            
        return laTecnologia;
    }

//    public Cliente getElCliente() 
//    {
//        return elCliente;
//    }
//
//    public void setElCliente(Cliente elCliente) {
//        this.elCliente = elCliente;
//    }
    
    @Override
    public String toString() 
    {
        return "Proyecto:" + "codigo=" + codigo + ", nombre=" + nombre + ", descripcion=" + descripcion + ", fechaInicio=" + fechaInicio + ", fechaFinal=" + fechaFinal;
    }
    
}
