/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;
import Modelo.IArchivoService;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * Clase para la gestión de archivos binarios de datos
 * @param <T>
 */
public class ArchivoBinarioService<T> implements IArchivoService<T> {
    
    // Método para guardar una lista de cualquier tipo en un archivo binario
    @Override
    public void guardarLista(List<T> lista, String nombreArchivo) throws Exception {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(nombreArchivo))) {
            out.writeObject(lista);
        } catch (IOException e) {
            throw new Exception("Error al guardar la lista en el archivo " + nombreArchivo, e);
        }
    }
    
    
    // Método para cargar una lista desde un archivo binario
    @Override
    public List<T> cargarLista(String nombreArchivo) throws Exception {
        List<T> lista = new ArrayList<>();
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(nombreArchivo))) {
            lista = (List<T>) in.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("Archivo " + nombreArchivo + " no encontrado. Se creará uno nuevo.");
        } catch (IOException | ClassNotFoundException e) {
            throw new Exception("Error al cargar la lista desde el archivo " + nombreArchivo, e);
        }
        return lista;
    }
    
    
}
