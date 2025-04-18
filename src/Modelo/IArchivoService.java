/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Modelo;
import java.util.List;

/**
 *
 * Interfaz para el manejo de archivos
 * @param <T>
 */
public interface IArchivoService<T> {
    void guardarLista(List<T> lista, String nombreArchivo) throws Exception;
    List<T> cargarLista(String nombreArchivo) throws Exception;
}   
