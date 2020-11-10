/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author angel
 */
public class DatosTorneo {
    private String torneo;
    private int jugadores;

    public DatosTorneo(String torneo, int jugadores) {
        this.torneo = torneo;
        this.jugadores = jugadores;
    }
    
    public String getTorneo() {
        return torneo;
    }

    public int getJugadores() {
        return jugadores;
    }

    public void setTorneo(String torneo) {
        this.torneo = torneo;
    }

    public void setJugadores(int jugadores) {
        this.jugadores = jugadores;
    }
    
    
}
