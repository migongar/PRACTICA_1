/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author angel
 */
public class Sede implements Serializable {

    private static final long serialVersionUID = 1L;
    private String nombre;
    protected ArrayList<FranjaHoraria> franja = new ArrayList<FranjaHoraria>();
    //protected Federacion federacion;
    //protected ArrayList<Partida> partidas = new ArrayList<Partida>();
    
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

    public ArrayList<FranjaHoraria> buscarHorasDisponibles(String dni, Date fecha) {
        ArrayList<FranjaHoraria> franjasDisponibles = new ArrayList<FranjaHoraria>();
        
        for(int i = 0;i<franja.size();i++ ){
            if(franja.get(i).comprobarDisponiblidad(dni, fecha)){
                franjasDisponibles.add(franja.get(i));
            }
        }
        
        return franjasDisponibles;
    }

    public void addFranja(FranjaHoraria franja) {
        this.franja.add(franja);
    }
    
    public void crearFranjaHoraria() {
        int hora = 8;
        for(int i = 0;i<7;i++ ){
            franja.add(new FranjaHoraria(hora + ":00"));
            hora = hora + 2;
        }
    }

    public ArrayList<FranjaHoraria> getFranjaHoraria() {
        return franja;
    }
}
