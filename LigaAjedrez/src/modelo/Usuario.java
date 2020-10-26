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
    
    public Usuario(){
    }
    
    public Usuario(Liga lig){
        this.liga = lig;
    }

    public boolean registrarJugador(String nom, String ape, String dni, String club, int edad, int cat) {
        if(liga.registrarJugador(nom,ape,dni,club,edad, cat)){
            tipousuario = 0;
            login = nom.substring(0,3) + ape.substring(0, 3);
            password = "contraseña";
            return true;
        }
        else
            return false;
    }
    
    public String getLogin(){
        return login;
    }
    
    public String getPassword(){
        return login;
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
}
