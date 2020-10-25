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
public class Liga {
    private ArrayList<Club> clubes;
    private ArrayList<Jugador> jugadores;

    public void cargarDatos() {
        
    }

    public boolean registrarJugador(String nom, String ape, String dni, String club, int edad) {
        boolean encontrado = false;
        Club clubencontrado = new Club();
        int i = 0;
        while(!encontrado && i<clubes.size()){
            if(clubes.get(i).getNombre().equals(club)){
                clubencontrado = clubes.get(i);
                encontrado = true;
            }    
        }
        
        Jugador nuevo = new Jugador(nom,ape,dni,clubencontrado,edad);
        
        return jugadores.add(nuevo);            
    }
    
}
