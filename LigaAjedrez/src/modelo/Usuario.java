/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.DefaultListModel;

/**
 *
 * @author angel
 */
public class Usuario extends Persona implements Serializable {

    private static final long serialVersionUID = 1L;    
    private String login, password;
    private int tipousuario;
    protected Liga liga;
    
    public Usuario(Liga liga){
        this.liga = liga;
    }
    
    public Usuario(String nom, String ape, String dni, String log, String pass,int tipo,Liga lig){        
        super(nom,ape,dni);
        this.login = log;
        this.password = pass;
        this.tipousuario = tipo;
        this.liga = lig;
    }

    public boolean registrarJugador(String nom, String ape, String dni, Object club, int edad) {
        Club clubi = (Club)club;
        return liga.registrarJugador(nom,ape,dni,clubi.getNombre(),edad);            
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
    
    public Liga getLiga(){
        return liga;
    }

    public ArrayList buscarTorneos(String dniJugador) {
        return liga.buscarTorneos(dniJugador);
    }

    public boolean registrarJugadorTorneo(String jugador, Object torneo) {        
        Torneo tor = (Torneo) torneo;
        return liga.inscrbirTorneo(jugador,tor);
    }
    
    public void setLogin(String user) {
        login = user;
    }
    
    public void setContraseña(String pass) {
        password = pass;
    }
    
    public ArrayList buscarClubes(String federacion) {
        return liga.buscarClubes(federacion);
    }
    
    public String toString(){
        return super.toString() + " Usuario: " + login +  " Contraseña: " + password ;
    }

    public ArrayList buscarPartidasEnCurso(String dniJugador) {
        return liga.buscarPartidasEnCurso(dniJugador);
    }

    public boolean introducirResultado(String jugador, String torneo, String ganador, String rival, Date fecha, String tiempo) {
        return liga.introducirResultado(jugador, torneo, ganador, rival, fecha, tiempo);
    }

    public ArrayList buscarTorneosJugador(String jugador) {
        return liga.buscarTorneosJugador(jugador);
    }

    public ArrayList verPartidas(String jugador, String torneo) {
        return liga.buscarPartidasJugador(jugador,torneo);
    }
    
}
