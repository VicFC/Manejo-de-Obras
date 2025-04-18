/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * Clase para gestionar las entradas a la bitácora
 */
public class EntradaBitacora implements Serializable {
    private String inspector;
    private Calendar fechaInspeccion;
    private Empleado empleado;
    private ArrayList<Medida> cumplidas;
    private ArrayList<Medida> faltas;
    private String observaciones;

    public EntradaBitacora() {
    }

    public EntradaBitacora(String inspector, Empleado empleado) {
        this.inspector = inspector;
        this.empleado = empleado;
    }

    public EntradaBitacora(String inspector, Calendar fechaInspeccion, Empleado empleado, 
            ArrayList<Medida> cumplidasIn, ArrayList<Medida> faltasIn, String observaciones) {
        this.inspector = inspector;
        this.fechaInspeccion = fechaInspeccion;
        this.empleado = empleado;
        if (cumplidasIn == null)
        {
          this.cumplidas = new ArrayList<>();
        }
        else
        {
          this.cumplidas = cumplidasIn;
        }
       
         if (faltasIn == null)
        {
          this.faltas = new ArrayList<>();
        }
        else
        {
           this.faltas = faltasIn;
        }
       
        this.observaciones = observaciones;
    }

    public String getInspector() {
        return inspector;
    }

    public void setInspector(String inspector) {
        this.inspector = inspector;
    }

    public String getFechaInspeccion() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); // Formato deseado
        String LafechaFormateada = (fechaInspeccion != null) ? sdf.format(fechaInspeccion.getTime()) : "Fecha no disponible";
        return LafechaFormateada;
    }
    
     public String getFechaHHMM() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm"); // Formato con horas y minutos
        String LafechaFormateada = (fechaInspeccion != null) ? sdf.format(fechaInspeccion.getTime()) : "Fecha no disponible";
        return LafechaFormateada;
    }

    public void setFechaInspeccion(Calendar fechaInspeccion) {
        this.fechaInspeccion = fechaInspeccion;
    }
    
    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public String getCumplidas() {
        return (cumplidas != null && !cumplidas.isEmpty()) 
            ? cumplidas.stream()
                .filter(medida -> medida != null) // Filtra medidas nulas
                .map(Medida::getNombre)
                .reduce((a, b) -> a + "\n" + b)
                .orElse("No hay medidas cumplidas") 
            : "No hay medidas cumplidas";
    }

    public String getCumplidasString() {
        return (cumplidas != null && !cumplidas.isEmpty()) 
            ? cumplidas.stream()
                .filter(medida -> medida != null) // Filtra medidas nulas
                .map(Medida::getNombre)
                .reduce((a, b) -> a + ", " + b)
                .orElse("No hay medidas cumplidas") 
            : "No hay medidas cumplidas";
    }
    
    public void setCumplidas(ArrayList<Medida> cumplidas) {
        this.cumplidas = cumplidas;
    }

    public String getFaltas() {
        return (faltas != null && !faltas.isEmpty()) 
            ? faltas.stream()
                .filter(medida -> medida != null) // Filtra medidas nulas
                .map(Medida::getNombre)
                .reduce((a, b) -> a + "\n" + b)
                .orElse("No hay medidas faltantes") 
            : "No hay medidas faltantes";
    }
    
    public String getFaltasString() {
        return (faltas != null && !faltas.isEmpty()) 
            ? faltas.stream()
                .filter(medida -> medida != null) // Filtra medidas nulas
                .map(Medida::getNombre)
                .reduce((a, b) -> a + ", " + b)
                .orElse("No hay medidas faltantes") 
            : "No hay medidas faltantes";
    }

    public void setFaltas(ArrayList<Medida> faltas) {
        this.faltas = faltas;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
    
    

    @Override
    public String toString() {
        return "EntradaBitacora{" + "inspector=" + inspector + ", fechaInspeccion=" + fechaInspeccion + ", empleado=" + empleado + ", cumplidas=" + cumplidas + ", faltas=" + faltas + ", observaciones=" + observaciones + '}';
    }

    
   

   

   

    
    
    

    
    
    

   
    
    
    
}
