/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author angel
 */
public class Partida implements Serializable{

    private static final long serialVersionUID = 1L;
    //private Date fecha;
    protected Resultado resultado;
    protected Jugador oponente;
    protected Torneo torneo;
    protected Sede sede;    
    
    public Partida(Jugador op, Sede lugar, Torneo torneo){
        this.oponente = op;
        this.torneo = torneo;
        this.sede = lugar;
        this.resultado = null;
    }

    public Resultado getResultado() {
        return resultado;
    }

    public Jugador getOponente() {
        return oponente;
    }

    public Torneo getTorneo() {
        return torneo;
    }

    public Sede getSede() {
        return sede;
    }
    
    public String toString(){
        return oponente.getNombre();
    }

    public void setResultado(Resultado resultado) {
        this.resultado = resultado;
    }

    public void setOponente(Jugador oponente) {
        this.oponente = oponente;
    }

    public void setTorneo(Torneo torneo) {
        this.torneo = torneo;
    }

    public void setSede(Sede sede) {
        this.sede = sede;
    }   
    
    
}
    
    
    
    
    
    
    

