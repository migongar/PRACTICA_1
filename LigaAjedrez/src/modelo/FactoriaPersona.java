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
public class FactoriaPersona implements Serializable{

    private static final long serialVersionUID = 1L;
    protected Liga liga; 
    
    public Persona crearPersona(String nombre, String ape, String dni, int tipo){
        Persona persona = null;
        switch(tipo){
            case 1:
                persona = new Jugador();
                persona.setNombre(nombre);
                persona.setApellidos(ape);
                persona.setDni(dni);
                break;
            case 2:
                persona = new Gerente();
                persona.setNombre(nombre);
                persona.setApellidos(ape);
                persona.setDni(dni);
                break;
            case 3:
                persona = new Entrenador();
                persona.setNombre(nombre);
                persona.setApellidos(ape);
                persona.setDni(dni);
                break;
            case 4:
                persona = new Administrador();
                persona.setNombre(nombre);
                persona.setApellidos(ape);
                persona.setDni(dni);
                break;
        }       
        
        return persona;
    }

    public void setLiga(Liga liga) {
        this.liga = liga;
    }
    
    
}
