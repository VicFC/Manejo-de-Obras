/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * Clase hija Empleado
 */
public class Empleado implements Serializable{
    private static final long serialVersionUID = 1L;
    private String id;
    private String nombre;
    private String correo;
    private String telefono;
    private String direccion;
    private Calendar fechaIngreso; 
    private double salarioHora;
    private Puesto puesto;

    public Empleado() {
    }

    public Empleado(String id, String nombre, String correo, String telefono, String direccion, Calendar fechaIngreso, double salarioHora, Puesto puesto) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
        this.direccion = direccion;
        this.fechaIngreso = fechaIngreso;
        this.salarioHora = salarioHora;
        this.puesto = puesto;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getFechaIngreso() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); // Formato deseado
        String LafechaFormateada = (fechaIngreso != null) ? sdf.format(fechaIngreso.getTime()) : "Fecha no disponible";
        return LafechaFormateada;
    }

    public void setFechaIngreso(Calendar fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public double getSalarioHora() {
        return salarioHora;
    }

    public void setSalarioHora(double salarioHora) {
        this.salarioHora = salarioHora;
    }

    public Puesto getPuesto() {
        return puesto;
    }

    public void setPuesto(Puesto puesto) {
        this.puesto = puesto;
    }

    @Override
    public String toString() {
        return "Empleado{" + "id=" + id + ", nombre=" + nombre + ", correo=" + correo + ", telefono=" + telefono + ", direccion=" + direccion + ", fechaIngreso=" + fechaIngreso + ", salarioHora=" + salarioHora + ", puesto=" + puesto + '}';
    }
       
    
    
}
