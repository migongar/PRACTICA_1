/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author angel
 */
public class Torneo {
    private String nombre;
    protected ArrayList<Club> clubes;
    protected ArrayList<Jugador> jugadores;

    public boolean buscarClub(String nom) {
        boolean encontrado = false;
        int i = 0;
        while(!encontrado && i<clubes.size()){
            if(clubes.get(i).getNombre().equals(nom)){
                encontrado = true;
            }
        }
        return encontrado;
    }

    public boolean buscarJugador(String nombre) {
        boolean encontrado = false;
        int i = 0;
        while(!encontrado && i<jugadores.size()){
            if(jugadores.get(i).getNombre().equals(nombre)){
                encontrado = true;
            }
        }
        return encontrado;
    }

    public boolean addJugador(Jugador jugador) {
        return jugadores.add(jugador);
    }
    
    
            
    
}
