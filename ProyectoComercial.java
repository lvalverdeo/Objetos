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
public class ProyectoComercial extends Proyecto
{
    private Cliente elCliente;
    private Usuario elUsuario;

    public ProyectoComercial() 
    {
        this.elCliente = new Cliente();
        this.elUsuario = new Usuario();
    }

    public ProyectoComercial(Cliente elCliente, String codigo, String nombre, String descripcion, int dia, int mes, int anio) 
    {
        super(codigo, nombre, descripcion, dia, mes, anio);
        this.elCliente = elCliente;
        this.elUsuario = new Usuario();
    }

    public ProyectoComercial(Cliente elCliente, String codigo, String nombre, String descripcion, int diaI, int mesI, int anioI, int diaF, int mesF, int anioF) 
    {
        super(codigo, nombre, descripcion, diaI, mesI, anioI, diaF, mesF, anioF);
        this.elCliente = elCliente;
        this.elUsuario = new Usuario();
    }
    
     public ProyectoComercial(Cliente elCliente, String codigo, String nombre, String descripcion, int dia, int mes, 
             int anio,Usuario u) 
    {
        super(codigo, nombre, descripcion, dia, mes, anio);
        this.elCliente = elCliente;
        this.elUsuario = u;
    }

    public ProyectoComercial(Cliente elCliente, String codigo, String nombre, String descripcion, int diaI, int mesI, 
            int anioI, int diaF, int mesF, int anioF,Usuario u) 
    {
        super(codigo, nombre, descripcion, diaI, mesI, anioI, diaF, mesF, anioF);
        this.elCliente = elCliente;
        this.elUsuario = u;
    }
    
    public ProyectoComercial(Cliente elCliente,Usuario u,String codigo, String nombre, String descripcion,
            LocalDate fechaInicio,LocalDate fechaFin)
    {
        super(codigo,nombre,descripcion,fechaInicio,fechaFin);
        this.elCliente = elCliente;
        this.elUsuario = u;
    }
    public ProyectoComercial(Cliente elCliente,Usuario u,String codigo, String nombre, String descripcion,
            LocalDate fechaInicio)
    {
        super(codigo,nombre,descripcion,fechaInicio);
        this.elCliente = elCliente;
        this.elUsuario = u;
    }
    public Cliente getElCliente() 
    {
        return elCliente;
    }

    public void setElCliente(Cliente elCliente) 
    {
        this.elCliente = elCliente;
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
    public String toString() 
    {
        return "ProyectoComercial{" + "elCliente=" + elCliente + super.toString();
    }
    
}
