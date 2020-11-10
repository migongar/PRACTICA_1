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

    private static final long serialVersionUID = 1L;
    private String nombre;
    protected Liga liga;
    protected Federacion federacion;
    protected Sede sede;
    protected Gerente gerente;
    protected Entrenador entrenador;
    protected ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
    
    public Club(String nom,Federacion fede,Sede sede, Gerente gerente, Entrenador entrenador, Liga liga){
        this.nombre = nom;
        this.federacion = fede;
        this.sede = sede;
        this.liga = liga;
        this.gerente = gerente;
        this.entrenador = entrenador;
        
    }

    public Club() {
        
    }

    public String getNombre() {
        return nombre;
    }
    
    public String toString(){
        return nombre;
    }

    public boolean addJugador(Jugador jug) {
        return jugadores.add(jug);
    }
    
    public Sede getSede(){
        return sede;
    }
    
}
