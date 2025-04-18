/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.ArrayList;

/**
 *
 * Clase hija Albañil
 */
public class Albanil extends Puesto {

    public Albanil() {
    }

    public Albanil(String nombre, int codigo, String descripcion, ArrayList<Riesgo> riesgos, ArrayList<Medida> medidas, String rutaImagen) {
        super(nombre, codigo, descripcion, riesgos, medidas, rutaImagen);
    }

    @Override
    public String toString() {
        return "Albanil{" + super.toString() + '}';
    }
    
    
    
}
