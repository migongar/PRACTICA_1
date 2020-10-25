/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author angel
 */
public class Jugador extends Usuario{
    private String nombre, apellidos, dni;
    private int  edad; 
    private Club club;
    
    public Jugador(Liga liga){
        super(liga);
    }
    
    public Jugador(String nom, String ape, String dni, Club club, int edad){
        
    }
    
}
