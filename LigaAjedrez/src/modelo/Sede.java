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
public class Sede implements Serializable {

    private static final long serialVersionUID = 1L;
    private String nombre;
    //protected Federacion federacion;
    protected ArrayList<Partida> partidas = new ArrayList<Partida>();
    
    public Sede(String nom/*, Federacion fede*/){
        this.nombre = nom;
        //this.federacion = fede;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public String toString(){
            return nombre;
    }
}
