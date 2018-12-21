/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl;

import java.time.*;
/**
 *
 * @author LVO-27111989
 */
public class Actividad
{
//    private int codigo;
    private String nombre;
    private String descripcion;
//    private LocalDate fechaInicio;
//    private LocalTime horaInicio;
//    private LocalDate fechaFinal;
//    private LocalTime horaFinal;
    private Proyecto elProyecto;

    public Actividad() 
    {
//        this.codigo = 0;
        this.nombre = "Indefinido";
        this.descripcion = "Indefinido";
//        this.fechaInicio = LocalDate.now();
//        this.horaInicio = LocalTime.now();
//        this.fechaFinal = LocalDate.MAX;
//        this.horaFinal = LocalTime.MAX;
        this.elProyecto = new Proyecto();
    }

    public Actividad(String nombre, String descripcion, LocalDate fechaInicio, LocalTime horaInicio, LocalDate fechaFinal, 
            LocalTime horaFinal,String codProyecto) 
    {
//        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
//        this.fechaInicio = fechaInicio;
//        this.horaInicio = horaInicio;
//        this.fechaFinal = fechaFinal;
//        this.horaFinal = horaFinal;
        this.elProyecto = new Proyecto();
    }
    
     public Actividad(String nombre, String descripcion, String codProyecto)
     {
         this.nombre = nombre;
        this.descripcion = descripcion;
        this.elProyecto = new Proyecto();
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

//    public LocalDate getFechaInicio() 
//    {
//        return fechaInicio;
//    }
//
//    public void setFechaInicio(LocalDate fechaInicio) 
//    {
//        this.fechaInicio = fechaInicio;
//    }
//
//    public LocalTime getHoraInicio() 
//    {
//        return horaInicio;
//    }
//
//    public void setHoraInicio(LocalTime horaInicio) 
//    {
//        this.horaInicio = horaInicio;
//    }
//
//    public LocalDate getFechaFinal() 
//    {
//        return fechaFinal;
//    }
//
//    public void setFechaFinal(LocalDate fechaFinal) 
//    {
//        this.fechaFinal = fechaFinal;
//    }

//    public LocalTime getHoraFinal() 
//    {
//        return horaFinal;
//    }

//    public void setHoraFinal(LocalTime horaFinal) 
//    {
//        this.horaFinal = horaFinal;
//    }

    public Proyecto getElProyecto() 
    {
        return elProyecto;
    }

    public void setElProyecto(Proyecto elProyecto) 
    {
        this.elProyecto = elProyecto;
    }

    @Override
    public String toString() 
    {
        return "Actividad: " + "nombre=" + nombre + ", descripcion=" + descripcion + ", elProyecto=" + elProyecto.getNombre();
    }
    
}
