/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.ArrayList;

/**
 *
 * Clase hija Cristalero
 */
public class Cristalero extends Puesto {

    public Cristalero() {
    }

    public Cristalero(String nombre, int codigo, String descripcion, ArrayList<Riesgo> riesgos, ArrayList<Medida> medidas, String rutaImagen) {
        super(nombre, codigo, descripcion, riesgos, medidas, rutaImagen);
    }

    @Override
    public String toString() {
        return "Cristalero{" + super.toString() + '}';
    }
    
    
}
