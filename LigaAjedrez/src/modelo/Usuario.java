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
public class Usuario {
    private String login, password;
    private int tipousuario;
    protected Liga liga;
    
    public Usuario(Liga liga){
        this.liga = liga;
    }
    
    public Usuario(String log, String pass,int tipo,Liga lig){        
        this.login = log;
        this.password = pass;
        this.tipousuario = tipo;
        this.liga = lig;
    }

    public boolean registrarJugador(String nom, String ape, String dni, String club, int edad) {
        return liga.registrarJugador(nom,ape,dni,club,edad);            
    }
    
    public String getLogin(){
        return login;
    }
    
    public String getPassword(){
        return password;
    }

    public int getTipo() {
        return tipousuario;
    }

    public ArrayList buscarTorneos(String dni) {
        ArrayList<Torneo> torneos = null;
        Jugador jug = liga.buscarJugador(dni);
        if(jug != null){
            torneos = liga.buscarTorneos(jug);
        }
        
        return torneos;
    }

    public boolean registrarJugadorTorneo(Usuario jugador, Object torneo) {
        Jugador jug = (Jugador)jugador;
        Torneo tor = (Torneo) torneo;
        return liga.inscrbirTorneo(jug,tor);
    }
    
    public void setLogin(String user) {
        login = user;
    }
    
    public void setContraseña(String pass) {
        password = pass;
    }

    public ArrayList getFederaciones() {
        return liga.getFederaciones();
    }

    public ArrayList buscarClubes(String federacion) {
        return liga.buscarClubes(federacion);
    }
}
