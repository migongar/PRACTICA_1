/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;

/**
 *
 * @author angel
 */
public class Persona implements Serializable{

    private static final long serialVersionUID = 1L;
    private String nombre, apellidos, dni;
    
    public Persona(){
        
    }
    
    public Persona(String nom, String ape, String dni){
        this.nombre = nom;
        this.apellidos = ape;
        this.dni = dni;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public String getDNI() {
        return dni;
    }
    
    public String getApellidos() {
        return apellidos;
    }
    
    public String toString(){
        return "Nombre: " + nombre + " " + apellidos + " DNI: " + dni;
    } 
}
