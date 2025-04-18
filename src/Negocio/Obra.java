/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import Modelo.Empleado;
import Modelo.EntradaBitacora;
import Modelo.Puesto;
import Modelo.Usuario;
import Negocio.ArchivoBinarioService;
import java.util.ArrayList;

/**
 *
 * Clase Obra
 */
public class Obra {
    private String nombre;
    private String codigo;
    private ArrayList<Empleado> planillaEmpleados;
    private ArrayList<Usuario> listaUsuarios;
    private ArrayList<Puesto> listaPuestos; 
    private ArrayList<EntradaBitacora> bitacora; 
        
    private ArchivoBinarioService<Empleado> archivoEmpleado = new ArchivoBinarioService<>();
    private ArchivoBinarioService<Usuario> archivoUsuarios = new ArchivoBinarioService<>();
    private ArchivoBinarioService<Puesto> archivoPuestos = new ArchivoBinarioService<>();
    private ArchivoBinarioService<EntradaBitacora> archivoBitacora = new ArchivoBinarioService<>();
    
    public Obra()
    {
        
    }

    public Obra(String nombre, String codigo, ArrayList<Empleado> planillaEmpleados, ArrayList<Usuario> listaUsuarios, ArrayList<Puesto> listaPuestos) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.planillaEmpleados = planillaEmpleados;
        this.listaUsuarios = listaUsuarios;
        this.listaPuestos = listaPuestos;
    }

    public Obra(String nombre, String codigo) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.planillaEmpleados =  new ArrayList<>();
        this.listaUsuarios =  new ArrayList<>();
        this.listaPuestos =  new ArrayList<>();
        this.bitacora =  new ArrayList<>();
    }
       
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public ArrayList<Empleado> getPlanillaEmpleados() {
        return planillaEmpleados;
    }

    public void setPlanillaEmpleados(ArrayList<Empleado> planillaEmpleados) {
        this.planillaEmpleados = planillaEmpleados;
    }

    public ArrayList<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(ArrayList<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    public ArrayList<Puesto> getListaPuestos() {
        return listaPuestos;
    }

    public void setListaPuestos(ArrayList<Puesto> listaPuestos) {
        this.listaPuestos = listaPuestos;
    }

    public ArchivoBinarioService<Empleado> getArchivoEmpleado() {
        return archivoEmpleado;
    }

    public void setArchivoEmpleado(ArchivoBinarioService<Empleado> archivoEmpleado) {
        this.archivoEmpleado = archivoEmpleado;
    }

    public ArchivoBinarioService<Usuario> getArchivoUsuarios() {
        return archivoUsuarios;
    }

    public void setArchivoUsuarios(ArchivoBinarioService<Usuario> archivoUsuarios) {
        this.archivoUsuarios = archivoUsuarios;
    }

    public ArchivoBinarioService<Puesto> getArchivoPuestos() {
        return archivoPuestos;
    }

    public void setArchivoPuestos(ArchivoBinarioService<Puesto> archivoPuestos) {
        this.archivoPuestos = archivoPuestos;
    }

    public ArrayList<EntradaBitacora> getBitacora() {
        return bitacora;
    }

    public void setBitacora(ArrayList<EntradaBitacora> bitacora) {
        this.bitacora = bitacora;
    }

    public ArchivoBinarioService<EntradaBitacora> getArchivoBitacora() {
        return archivoBitacora;
    }

    public void setArchivoBitacora(ArchivoBinarioService<EntradaBitacora> archivoBitacora) {
        this.archivoBitacora = archivoBitacora;
    }
    
    public Puesto obtenerPuesto(String nombrePuesto) {
        // Recorrer la lista de puestos
        for (Puesto puesto : listaPuestos) {
            // Comparar el nombre del puesto
            if (puesto.getNombre().equalsIgnoreCase(nombrePuesto)) {
                return puesto; // Devolver el objeto si coincide
            }
        }
        // Si no se encuentra el puesto, devolver null
        return null;
    }
    
    /***
     * Método para agregar un empleado a la planilla
     * @param nuevoEmpleado
     * @return true si lo logra, false si no
     */
    public boolean agregarCliente(Empleado nuevoEmpleado) {
        // Verifica ya existe el nuevo empleado   
        for (int i = 0; i < planillaEmpleados.size(); i++) {            
            Empleado actual = planillaEmpleados.get(i);
            if (actual.getId().equals(nuevoEmpleado.getId())){
                return false;
            }
        }
        return planillaEmpleados.add(nuevoEmpleado);
    }
    
     
    /***
     * Método para agregar un usuario
     * @param nuevoUsuario
     * @return true si lo logra, false si no
     */
    public boolean agregarUsuario(Usuario nuevoUsuario) {
        // Verifica ya existe el nuevo usuario   
        for (int i = 0; i < listaUsuarios.size(); i++) {            
            Usuario actual = listaUsuarios.get(i);
            if (actual.getUsername().equals(nuevoUsuario.getUsername())){
                return false;
            }
        }
        return listaUsuarios.add(nuevoUsuario);
    }
    
    
    /***
     * Método para buscar un inspector por nombre
     * @param inspectorBuscar
     * @return true si lo logra, false si no
     */
    public boolean buscarInspector(String inspectorBuscar) {
        // Verifica ya existe el nuevo usuario   
        for (int i = 0; i < listaUsuarios.size(); i++) {            
            Usuario actual = listaUsuarios.get(i);
            if (actual.getRol().toString().equalsIgnoreCase("Inspector"))
            {
               if (actual.getNombre().equalsIgnoreCase(inspectorBuscar)){
                return true;
            } 
            }
            
        }
        return false;
    }
    
    
    /***
     * Método para buscar un empleado de la planilla
     * @param id
     * @return true si lo logra, false si no
     */
    public Empleado buscarEmpleado(String id) {
        // Verifica ya existe el nuevo empleado   
        for (int i = 0; i < planillaEmpleados.size(); i++) {            
            Empleado actual = planillaEmpleados.get(i);
            if (actual.getId().equals(id)){
                return actual;
            }
        }
        return null;
    }
    
    /***
     * Método para buscar un usuario
     * @param id
     * @return true si lo logra, false si no
     */
    public Usuario buscarUsuario(String id) {
        // Verifica ya existe el nuevo empleado   
        for (int i = 0; i < listaUsuarios.size(); i++) {            
            Usuario actual = listaUsuarios.get(i);
            if (actual.getUsername().equals(id)){
                return actual;
            }
        }
        return null;
    }
    
    /***
     * Método para buscar un puesto por código
     * @param id
     * @return true si lo logra, false si no
     */
    public Puesto buscarPuesto(String id) {
        // Verifica ya existe el nuevo empleado   
        for (int i = 0; i < listaPuestos.size(); i++) {            
            Puesto actual = listaPuestos.get(i);
            if (String.valueOf(actual.getCodigo()).equals(id)){
                return actual;
            }
        }
        return null;
    }
    
    
    /***
     * Eliminar empleado
     * @param id 
     */
    public void eliminarEmpleado(String id) {
        Empleado empleado = buscarEmpleado(id);
        if (empleado != null) {
            planillaEmpleados.remove(empleado);  // Eliminar el empleado de la lista
        }
    }
    
    /***
     * Eliminar usuario
     * @param id 
     */
    public void eliminarUsuario(String id) {
        Usuario usuario = buscarUsuario(id);
        if (usuario != null) {
            listaUsuarios.remove(usuario);  // Eliminar el empleado de la lista
        }
    }

          
    public void guardarPlanillas() throws Exception {
        archivoEmpleado.guardarLista(planillaEmpleados, "empleados.dat");
        archivoUsuarios.guardarLista(listaUsuarios, "usuarios.dat");
        archivoPuestos.guardarLista(listaPuestos, "puestos.dat");
        archivoBitacora.guardarLista(bitacora, "bitacora.dat");
    }

    public void cargarPlanillas() throws Exception {
        planillaEmpleados = (ArrayList<Empleado>) archivoEmpleado.cargarLista("empleados.dat");
        listaUsuarios = (ArrayList<Usuario>) archivoUsuarios.cargarLista("usuarios.dat");
        listaPuestos = (ArrayList<Puesto>) archivoPuestos.cargarLista("puestos.dat");
        bitacora = (ArrayList<EntradaBitacora>) archivoBitacora.cargarLista("bitacora.dat");
    }

    @Override
    public String toString() {
        return "Obra{" + "nombre=" + nombre + ", codigo=" + codigo + ", planillaEmpleados=" + planillaEmpleados + ", listaUsuarios=" + listaUsuarios + ", listaPuestos=" + listaPuestos + ", bitacora=" + bitacora + ", archivoEmpleado=" + archivoEmpleado + ", archivoUsuarios=" + archivoUsuarios + ", archivoPuestos=" + archivoPuestos + ", archivoBitacora=" + archivoBitacora + '}';
    }

    
    
    
}
