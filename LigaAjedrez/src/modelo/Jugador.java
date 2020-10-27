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
public class Jugador extends Usuario{
    private String nombre, apellidos, dni;
    private int  edad, categoria; 
    protected Club club;
    protected ArrayList<Torneo> torneos = new ArrayList<Torneo>();
    
    /*public Jugador(){
        
    }
    */
    public Jugador(String nom, String ape, String dni, Club cl, int ed, Liga liga){
        super(nom.substring(0,2).toLowerCase() + ape.substring(0, 2).toLowerCase(),"contrasenya", 0, liga);        
        this.nombre = nom;
        this.apellidos = ape;
        this.dni = dni;
        this.club = cl;
        this.edad = ed;
        this.liga = liga;
        
        if(edad>=18)
            categoria = 1;
        else if(edad<=15)
                categoria = 3;
            else
                categoria = 2;  
        
        club.addJugador(this);
        
        System.out.println("Jugador: " + (nom.substring(0,2).toLowerCase() + ape.substring(0, 2).toLowerCase())+
                " Contraseña: contrasenya" + " DNI: " + this.dni);
    }
    
    public Club getClub(){
        return club;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDNI() {
        return dni;
    }

    public boolean addTorneo(Torneo tor) {
        return torneos.add(tor);
    }

    public ArrayList getTorneos() {
        return torneos;
    }


}
