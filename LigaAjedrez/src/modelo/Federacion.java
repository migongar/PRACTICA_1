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
public class Federacion implements Serializable{

    private static final long serialVersionUID = 1L;
    private String nombre;
    protected ArrayList<Club> clubes = new ArrayList<Club>();
    
    public Federacion(String nom){
        this.nombre = nom;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public ArrayList<Club> getClubes(){
        return clubes;
    }
    
    public String toString(){
            return nombre;
    }

    public boolean anyadirClub(Club club) {
        return clubes.add(club);
    }
}
