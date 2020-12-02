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
public class Jugador extends Usuario implements Serializable{

    private static final long serialVersionUID = 1L;
    private int  edad, categoria;
    protected Club club;
    protected ArrayList<Torneo> torneos = new ArrayList<Torneo>();
    protected ArrayList<Partida> partidas = new ArrayList<Partida>();
    protected ArrayList<Partida> historial = new ArrayList<Partida>();

    public Jugador(){
        
    }
    
    public Jugador(String nom, String ape, String dni, Club cl, int ed, Liga liga, String user, String pass){
        super(nom,ape,dni,user,pass, 0, liga);
        this.club = cl;
        this.edad = ed;
        this.liga = liga;
        
        if(edad>=18)
            categoria = 1;
        else if(edad<=15)
                categoria = 3;
            else
                categoria = 2;  
        
        club.addJugador(this);        
        
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    public Club getClub(){
        return club;
    }    

    public boolean addTorneo(Torneo tor) {
        return torneos.add(tor);
    }

    public ArrayList<Torneo> getTorneos() {
        return torneos;
    }

    public String toString(){
        return super.toString() + " Club: " + club;
    }

    public ArrayList<Partida> getPartidas() {
        return partidas;
    }

    public boolean eliminarRivalPartidas(Partida partida) {
        return partidas.remove(partida);
    }

    public void addPartida(Partida nuevaPartida) {
        partidas.add(nuevaPartida);
    }

    public void elimnarTorneoJugador(Torneo torneo) {
        torneos.remove(torneo);
    }
    
    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    public void setClub(Club club) {
        this.club = club;
    }
    
}
