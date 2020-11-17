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
public class FactoriaPersona {
    private Club club;
    private int edad;
    private String user;
    private String password;
    private Liga liga;
    private int tipo;
    
    public Persona crearPersona(String nombre, String ape, String dni, int tipo){
        Persona persona = new Persona();
        switch(tipo){
            case 1:
                persona = new Jugador(nombre, ape, dni, club, edad, liga, user, password);
                break;
            case 2:
                persona = new Gerente(nombre,ape,dni,false);
                break;
            case 3:
                persona = new Entrenador(nombre,ape,dni,false);
                break;
            case 4:
                persona = new Administrador(nombre,ape,dni,liga);
                break;
        }
        
        return persona;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public void setClub(Club club) {
        this.club = club;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setLiga(Liga liga) {
        this.liga = liga;
    }
    
    
}
