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
public class Torneo implements Serializable{

    private static final long serialVersionUID = 1L;
    private boolean inicio;
    private String nombre;
    private Jugador espPartida = null;
    //protected Federacion federacion;
    protected ArrayList<Club> clubes = new ArrayList<Club>();
    protected ArrayList<Partida> partidas = new ArrayList<Partida>();
    protected ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
    
    public Torneo(String nom/*, Federacion fede*/){
        this.nombre = nom;
        //this.federacion = fede;
        this.inicio = false;
    }

    public Torneo() {
        
    }

    public ArrayList<Club> getClubes() {
        return clubes;
    }
    
    public ArrayList<Jugador> getJugadores(){
        return jugadores;
    }

    public void setInicio(boolean inicio) {
        this.inicio = inicio;
    }

    public boolean isInicio() {
        return inicio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    

    public boolean buscarClub(Club club) {
        boolean encontrado = false;
        int i = 0;
        while(!encontrado && i<clubes.size()){
            if(clubes.get(i).getNombre().equals(club.getNombre())){
                encontrado = true;
            }
            i++;
        }
        return encontrado;
    }

    public boolean buscarJugador(String dni) {
        boolean encontrado = false;
        int i = 0;
        while(!encontrado && i<jugadores.size()){
            if(jugadores.get(i).getDNI().equals(dni)){
                encontrado = true;
            }
            i++;
        }
        return encontrado;
    }

    public boolean addJugador(Jugador jugador) {
        return jugadores.add(jugador);
    }

    public void addClub(Club club) {
        clubes.add(club);
    }
    
    public String toString(){
            return nombre;
    }

    /*public Federacion getFederacion() {
        return federacion;
    }*/

    public int getNumJugadores() {
        return jugadores.size();
    }

    public Partida siguientePartida(Jugador jugador) {
        boolean encontrado = false;
        int i = 0;
        Partida nuevaPartida = null;
        
        if(jugadores.size()>2){
            while(!encontrado && i<jugadores.size()){
                if(jugadores.get(i).getNombre().equals(jugador.getNombre())){
                    if(espPartida != null){
                        nuevaPartida = new Partida(espPartida,jugador.getClub().getSede(),this);
                        jugadores.get(i).addPartida(nuevaPartida);
                    }
                    else
                        espPartida = jugadores.get(i); 
                    encontrado = true;
                }
                i++;                
            }                
        }
        
        return nuevaPartida;
    }

    public boolean eliminarJugadorTorneo(Jugador oponente) {
        return jugadores.remove(oponente);
    }
            
    
}
