/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.io.Serializable;

/**
 *
 * clase Medida con la información de las medidas preventivas para cada tipo de riesgo
 */
public class Medida implements Serializable {
    private String nombre;
    private String descripcion;

    public Medida() {
    }

    public Medida(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }
    
    public Medida(String nombre) {
        this.nombre = nombre;
        this.descripcion = "";
    }

    public String getNombre() {
        return nombre;
    }
   
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Medida{" + "nombre=" + nombre + ", descripcion=" + descripcion + '}';
    }
    
    
    
    
}
