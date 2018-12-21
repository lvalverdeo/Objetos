/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl;

import java.time.LocalDate;

/**
 *
 * @author LVO-27111989
 */
public class ProyectoAcademico extends Proyecto
{
    private Usuario elUsuario;

    public ProyectoAcademico() 
    {
        this.elUsuario = new Usuario();
    }

    public ProyectoAcademico(Usuario elUsuario, String codigo, String nombre, String descripcion, int dia, int mes, int anio) 
    {
        super(codigo, nombre, descripcion, dia, mes, anio);
        this.elUsuario = elUsuario;
    }

    public ProyectoAcademico(Usuario elUsuario, String codigo, String nombre, String descripcion, int diaI, int mesI, 
            int anioI, int diaF, int mesF, int anioF) 
    {
        super(codigo, nombre, descripcion, diaI, mesI, anioI, diaF, mesF, anioF);
        this.elUsuario = elUsuario;
    }
    
    public ProyectoAcademico(Usuario elUsuario, String codigo, String nombre, String descripcion,LocalDate fechaInicio)
    {
        super(codigo,nombre,descripcion,fechaInicio);
        this.elUsuario = elUsuario;
    }
    
    public ProyectoAcademico(Usuario elUsuario, String codigo, String nombre, String descripcion,
            LocalDate fechaInicio,LocalDate fechaFin)
    {
        super(codigo,nombre,descripcion,fechaInicio,fechaFin);
        this.elUsuario = elUsuario;
    }
    public Usuario getElUsuario() 
    {
        return elUsuario;
    }

    public void setElUsuario(Usuario elUsuario) 
    {
        this.elUsuario = elUsuario;
    }

    @Override
    public String toString() {
        return "ProyectoAcademico{" + "elUsuario=" + elUsuario + super.toString();
    }
    
    
}
