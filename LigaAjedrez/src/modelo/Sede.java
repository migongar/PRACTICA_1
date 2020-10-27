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
public class Sede {
    private String nombre;
    protected Federacion federacion;
    protected ArrayList<Partida> partidas = new ArrayList<Partida>();
    
    public Sede(String nom, Federacion fede){
        this.nombre = nom;
        this.federacion = fede;
    }
}
