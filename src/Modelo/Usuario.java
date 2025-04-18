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
 * Clase madre Usuario
 */
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    private String username;
    private String password;
    private String nombre;   
    private RolUsuario rol;
    
    // Constructor, getters, setters
    public Usuario(){
        
    }

    public Usuario(String username, String password, String nombre) {
        this.username = username;
        this.password = password;
        this.nombre = nombre;
    }

    public Usuario(String username, String password, String nombre, RolUsuario rol) {
        this.username = username;
        this.password = password;
        this.nombre = nombre;
        this.rol = rol;
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public RolUsuario getRol() {
        return rol;
    }

    public void setRol(RolUsuario rol) {
        this.rol = rol;
    }

    @Override
    public String toString() {
        return "Usuario{" + "username=" + username + ", password=" + password + ", nombre=" + nombre + ", rol=" + rol + '}';
    }
    
    

    

    
    
    
}

