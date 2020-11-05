/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author angel
 */
public class Club implements Serializable{
    private String nombre;
    protected Liga liga;
    protected Federacion federacion;
    protected Sede sede;
    protected ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
    
    public Club(String nom,Federacion fede,Sede sede,Liga liga){
        this.nombre = nom;
        this.federacion = fede;
        this.sede = sede;
        this.liga = liga;
    }

    public Club() {
        
    }

    public String getNombre() {
        return nombre;
    }
    
    public String toString(){
        return nombre;
    }

    public void addJugador(Jugador jug) {
        jugadores.add(jug);
    }
    
}
