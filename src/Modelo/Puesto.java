/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * Clase Puesto para trabajar los puestos en la obra de construcción
 */
public class Puesto implements Serializable {
    private static final long serialVersionUID = 1L;
    private String nombre;
    private int codigo;
    private String descripcion;
    private ArrayList<Riesgo> riesgos;
    private ArrayList<Medida> medidas;
    private String rutaImagen;
    
    public Puesto() {
        
    }

    public Puesto(String nombre, int codigo, String descripcion, ArrayList<Riesgo> riesgos, ArrayList<Medida> medidas, String rutaImagen) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.riesgos = riesgos;
        this.medidas = medidas;
        this.rutaImagen = rutaImagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public ArrayList<Riesgo> getRiesgos() {
        return riesgos;
    }

    public void setRiesgos(ArrayList<Riesgo> riesgos) {
        this.riesgos = riesgos;
    }

    public ArrayList<Medida> getMedidas() {
        return medidas;
    }
    
    public Medida getMedida(String nombreIn) {
        for (int i = 0; i < medidas.size(); i++) {            
            Medida actual = medidas.get(i);
            if (actual.getNombre().equalsIgnoreCase((nombreIn))){
                return actual;
            }
        }
        return null;
    }

    public void setMedidas(ArrayList<Medida> medidas) {
        this.medidas = medidas;
    }

    public String getRutaImagen() {
        return rutaImagen;
    }

    public void setRutaImagen(String rutaImagen) {
        this.rutaImagen = rutaImagen;
    }

    @Override
    public String toString() {
        return "Puesto{" + "nombre=" + nombre + ", codigo=" + codigo + ", descripcion=" + descripcion + ", riesgos=" + riesgos + ", medidas=" + medidas + ", rutaImagen=" + rutaImagen + '}';
    }
    
    
    
    
}
