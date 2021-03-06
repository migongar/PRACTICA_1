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
public class Usuario extends Persona implements Serializable{

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

    public Usuario() {
        
    }

    public void setTipousuario(int tipousuario) {
        this.tipousuario = tipousuario;
    }
    
    public boolean registrarJugador(String nom, String ape, String dni, Object club, int edad, String user, String pass) {
        Club clubi = (Club)club;
        return liga.registrarJugador(nom,ape,dni,clubi.getNombre(),edad, user, pass);            
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

    public void setLiga(Liga liga) {
        this.liga = liga;
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

    public boolean comprobarDNI(String dni) {
        if(!(dni.length()==9))
            return false;
        
        String numeros = dni.substring(0,dni.length()-1);
        
        int numdni = 0;
        
        try{
            numdni = Integer.parseInt(numeros);
        }catch(NumberFormatException e){
            return false;
        }
        
        return Character.isLetter(dni.charAt(dni.length()-1));
    }

    public ArrayList buscarHorasDisponibles(String dni, Date fecha) {
        return liga.buscarHorasDisponibles(dni, fecha);
    }
    
}
