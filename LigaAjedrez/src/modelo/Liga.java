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
public class Liga {
    protected ArrayList<Club> clubes;
    protected ArrayList<Jugador> jugadores;
    protected ArrayList<Administrador> administradores;
    protected ArrayList<Torneo> torneos;

    public void cargarDatos() {
        
    }

    public boolean registrarJugador(String nom, String ape, String dni, String club, int edad, int cat) {
        boolean encontrado = false;
        Club clubencontrado = null;
        int i = 0;
        while(!encontrado && i<clubes.size()){
            if(clubes.get(i).getNombre().equals(club)){
                clubencontrado = clubes.get(i);
                encontrado = true;
            }
        }
        
        Jugador nuevo = new Jugador(nom,ape,dni,clubencontrado,edad, cat);
        
        return jugadores.add(nuevo);            
    }

    public Usuario buscarUsuario(String user) {
        boolean encontrado = false;
        int i = 0;
        Usuario usuario = null;
        while(!encontrado && i < jugadores.size()){
            if(jugadores.get(i).getLogin().equals(user)){
                encontrado = true;
                usuario = jugadores.get(i);
            }
            i++;
        }
        i=0;
        while(!encontrado && i < administradores.size()){
            if(administradores.get(i).getLogin().equals(user)){
                encontrado = true;
                usuario = administradores.get(i);
            }
            i++;
        }
        return usuario;
    }

    public ArrayList<Torneo> buscarTorneos(Jugador jug) {
        ArrayList<Torneo> encontrados = null;
        for(int i=0;i<torneos.size();i++){
            if(torneos.get(i).buscarClub(jug.getNombre()) && !torneos.get(i).buscarJugador(jug.getNombre()))
                encontrados.add(torneos.get(i));
        }
        
        return encontrados;
    }

    public boolean inscrbirTorneo(Jugador jugador, Torneo tor) {
        boolean encontrado = false, inscrito = false;
        int i = 0;        
        while(!encontrado && i<torneos.size()){
            if(torneos.get(i) == tor){
                encontrado = true;
                inscrito = torneos.get(i).addJugador(jugador);
            }
            i++;
        }
        
        return inscrito;
        
    }

    public Jugador buscarJugador(String dni) {
        boolean encontrado = false;
        int i = 0;
        Jugador jugador = null;
        
        while(!encontrado && i < jugadores.size()){
            if(jugadores.get(i).getDNI().equals(dni)){
                encontrado = true;
                jugador = jugadores.get(i);
            }
            i++;
        }
        
        return jugador;
    }
}
