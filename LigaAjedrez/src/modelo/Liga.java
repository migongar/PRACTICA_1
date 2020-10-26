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
    protected ArrayList<Club> clubes = new ArrayList<Club>();
    protected ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
    protected ArrayList<Administrador> administradores = new ArrayList<Administrador>();
    protected ArrayList<Torneo> torneos = new ArrayList<Torneo>();
    protected ArrayList<Federacion> federaciones = new ArrayList<Federacion>();


    public void cargarDatos() {        
        Administrador admin = new Administrador("Julian", "Lopez","89657412P", this);
        Federacion fede = new Federacion("Federacion de Valencia");
        Sede sede = new Sede("Sede Levante");
        Club club = new Club("Levante FC",fede,sede,this);
        Jugador jugador = new Jugador("Juan" , "Vazquez", "12256848L", club,  16, this);
        
        fede.anyadirClub(club);
        
        Torneo torneo = new Torneo("Torneo Smart");
        torneo.addClub(club);
        
        jugadores.clear();
        administradores.clear();
        federaciones.clear();
        torneos.clear();
        
        administradores.add(admin);
        jugadores.add(jugador);
        federaciones.add(fede);
        torneos.add(torneo);
        
        
    }

    public boolean registrarJugador(String nom, String ape, String dni, String club, int edad) {
        boolean encontrado = false;
        Club clubencontrado = null;
        int i = 0;
        while(!encontrado && i<clubes.size()){
            if(clubes.get(i).getNombre().equals(club)){
                clubencontrado = clubes.get(i);
                encontrado = true;
            }
        }
        
        Jugador nuevo = new Jugador(nom,ape,dni,clubencontrado,edad,this);
        
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
        ArrayList<Torneo> encontrados = new ArrayList<Torneo>();
        for(int i=0;i<torneos.size();i++){
            if(torneos.get(i).buscarClub(jug.getClub()) && !torneos.get(i).buscarJugador(jug.getNombre()))
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
                inscrito = torneos.get(i).addJugador(jugador) && jugador.addTorneo(tor);
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

    public ArrayList<Federacion> getFederaciones() {
        return federaciones;
    }

    public ArrayList buscarClubes(String federacion) {
        boolean encontrado = false;
        int i = 0;
        ArrayList<Club> clubes= null;
        
        while(!encontrado && i < federaciones.size()){
            if(federaciones.get(i).getNombre().equals(federacion)){
                encontrado = true;
                clubes = federaciones.get(i).getClubes();
            }
            i++;
        }
        
        return clubes;
    }
}
