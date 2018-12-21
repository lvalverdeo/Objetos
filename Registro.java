/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author LVO-27111989
 */
public class Registro 
{
    private Actividad laActividad;
    private LocalDate fechaInicio;
    private LocalTime horaInicio;
//    private LocalDate fechaFinal;
//    private LocalTime horaFinal;
    private String nombre;
    private String descripcion;
    public Registro() 
    {
        this.laActividad = new Actividad();
        this.nombre = laActividad.getNombre();
        this.descripcion = laActividad.getDescripcion();
    }

    public Registro(Actividad laActividad, LocalDate fechaInicio, LocalTime horaInicio) 
    {
        this.laActividad = laActividad;
        this.fechaInicio = fechaInicio;
        this.horaInicio = horaInicio;
        this.nombre = laActividad.getNombre();
        this.descripcion = laActividad.getDescripcion();
    }

    public Actividad getLaActividad() 
    {
        return laActividad;
    }
    
    public Actividad getActividadNombre(String nombre)
    {
        Actividad unaActividad = new Actividad();
        
        //recorrer la lista de actividades guardadas en la base de datos encontrar la que tiene ese nombre
        
        return unaActividad;
    }
    public void setLaActividad(Actividad laActividad) 
    {
        this.laActividad = laActividad;
    }

    public LocalDate getFechaInicio() 
    {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) 
    {
        this.fechaInicio = fechaInicio;
    }

    public LocalTime getHoraInicio() 
    {
        return horaInicio;
    }

    public void setHoraInicio(LocalTime horaInicio) 
    {
        this.horaInicio = horaInicio;
    }
    
    @Override
    public String toString() 
    {
        return "laActividad=" + laActividad + " - fechaInicio=" + fechaInicio + " - horaInicio=" + horaInicio;
    }
    
    
}
