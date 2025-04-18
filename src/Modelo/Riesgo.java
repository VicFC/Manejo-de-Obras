/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.io.Serializable;

/**
 *
 * clase con la información de cada riesgo
 */
public class Riesgo implements Serializable {
    private String nombre;
    private String descripcion;

    public Riesgo() {
    }

    public Riesgo(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }
    
    /**
     *
     * @param nombre
     */
    public Riesgo(String nombre) {
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
        return "Riesgo{" + "nombre=" + nombre + ", descripcion=" + descripcion + '}';
    }
    
    
    
    
}
