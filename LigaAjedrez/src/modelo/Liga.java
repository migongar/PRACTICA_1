/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author angel
 */
public class Liga implements Serializable{
    protected ArrayList<Club> clubes = new ArrayList<Club>();
    protected ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
    protected ArrayList<Administrador> administradores = new ArrayList<Administrador>();
    protected ArrayList<Torneo> torneos = new ArrayList<Torneo>();
    protected ArrayList<Federacion> federaciones = new ArrayList<Federacion>();
    protected ArrayList<Gerente> gerentes = new ArrayList<Gerente>();
    protected ArrayList<Entrenador> entrenadores = new ArrayList<Entrenador>();
    protected ArrayList<Sede> sedes = new ArrayList<Sede>();


    public void cargarDatos() {        
        
        ArrayList arrayList;
        
        jugadores.clear();
        administradores.clear();
        federaciones.clear();
        torneos.clear();
        clubes.clear();
        sedes.clear();        

        try {
            System.out.print("Leyendo ArrayList del fichero objetos.dat.. ");

            ObjectInputStream leyendoFichero = new ObjectInputStream( new FileInputStream("objetos.dat") );
            
            arrayList = ( ArrayList )leyendoFichero.readObject();

            leyendoFichero.close();

            System.out.println("ok!");
            /*System.out.println("Datos leídos del fichero:");
            
            for(int i = 0; i < arrayList.size(); i++) {
                System.out.println( arrayList.get(i));                
            }*/
            
            administradores = (ArrayList<Administrador>) arrayList.get(0);
            jugadores = (ArrayList<Jugador>) arrayList.get(1);
            federaciones = (ArrayList<Federacion>) arrayList.get(2);
            sedes = (ArrayList<Sede>) arrayList.get(3);
            clubes = (ArrayList<Club>) arrayList.get(4);
            torneos = (ArrayList<Torneo>) arrayList.get(5);
            
            System.out.println( "Administradores:"); 
            
            for(int i = 0; i < administradores.size(); i++) {
                System.out.println( administradores.get(i));                
            }
            
            System.out.println( "Jugadores:"); 
            
            for(int i = 0; i < jugadores.size(); i++) {
                System.out.println( jugadores.get(i));                
            }
            
            System.out.println( "Federaciones:"); 
            
            for(int i = 0; i < federaciones.size(); i++) {
                System.out.println( federaciones.get(i));                
            }
            
            System.out.println( "Sedes:"); 
            
            for(int i = 0; i < sedes.size(); i++) {
                System.out.println( sedes.get(i));                
            }
            
            System.out.println( "Clubes:"); 
            
            for(int i = 0; i < clubes.size(); i++) {
                System.out.println( clubes.get(i));                
            }
            
            System.out.println( "Torneos:"); 
            
            for(int i = 0; i < torneos.size(); i++) {
                System.out.println( torneos.get(i));                
            }          
            
        } catch (Exception e) {
            System.out.println( e.getMessage() );
        }

    
        /*Federacion fede = new Federacion("Federacion de Valencia");
        System.out.println("Federacion: " + fede.toString());
        
        Sede sede = new Sede("Sede Levante", fede);
        System.out.println("Sede: " + sede.toString());
        
        Club club = new Club("Levante FC",fede,sede,this);
        System.out.println("Club: " + fede.toString());       
        
        fede.anyadirClub(club);
        
        Torneo torneo = new Torneo("Torneo Smart");
        System.out.println("Torneo: " + torneo.toString());
        torneo.addClub(club);        
        
        Administrador admin = new Administrador("Julian", "Lopez","89657412P", this);
        Jugador jugador = new Jugador("Juan" , "Vazquez", "12256848L", club,  16, this);
               
        jugadores.clear();
        administradores.clear();
        federaciones.clear();
        torneos.clear();
        clubes.clear();
        sedes.clear();
                
        administradores.add(admin);
        jugadores.add(jugador);
        federaciones.add(fede);
        sedes.add(sede);
        clubes.add(club);
        torneos.add(torneo);
        
        ArrayList arrayList = new ArrayList ();

        System.out.println("Datos que vamos a escribir en el fichero:");      
        
        arrayList.add(0, administradores);
        arrayList.add(1, jugadores);
        arrayList.add(2, federaciones);
        arrayList.add(3, sedes);
        arrayList.add(4, clubes);
        arrayList.add(5, torneos);

        try {
            System.out.print("Guardando ArrayList en el fichero objetos.dat.. ");

            ObjectOutputStream escribiendoFichero = new ObjectOutputStream( new FileOutputStream("objetos.dat") );
            escribiendoFichero.writeObject(arrayList);
            escribiendoFichero.close();

            System.out.println("ok!");
            
            
        } catch (Exception e) {
            System.out.println( e.getMessage() );
        }*/

    }
    

    public boolean registrarJugador(String nom, String ape, String dni, String club, int edad) {
        boolean encontrado = false;
        Club clubencontrado = new Club();
        int i = 0;
        while(!encontrado && i<clubes.size()){
            if(clubes.get(i).getNombre().equals(club)){
                clubencontrado = clubes.get(i);
                encontrado = true;
            }
            i++;
        }
        
        Jugador nuevo = new Jugador(nom,ape,dni,clubencontrado,edad,this);
              
        if(jugadores.add(nuevo)){
            System.out.println("Nuevo: " + nuevo);                   
            this.guardarDatos();
            return true;
        }
        else
            return false;
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

    public boolean registrarFederacion(String nomFede) {
        Federacion fede = new Federacion(nomFede);
        return federaciones.add(fede);
    }

    public boolean registrarGerente(String nombre, String apellidos, String dni) {
        Gerente ger = new Gerente(nombre,apellidos,dni);
        return gerentes.add(ger);
    }

    public boolean registrarEntrenador(String nombre, String apellidos, String dni) {
        Entrenador ger = new Entrenador(nombre,apellidos,dni);
        return entrenadores.add(ger);
    }

    public boolean registrarSede(String nomSede, String nomFede) {
        Federacion fede = null;
        boolean encontrado = false;
        int i = 0;
        while(!encontrado && i < federaciones.size()){
            if(federaciones.get(i).getNombre().equals(nomFede)){
                encontrado = true;
                fede = federaciones.get(i);
            }
            i++;
        }
        
        Sede sede = new Sede(nomSede,fede);
        
        return sedes.add(sede);
    }

    public ArrayList<Entrenador> getEntrenadores() {
        return entrenadores;
    }

    public ArrayList<Sede> getSedes() {
        return sedes;
    }

    public ArrayList<Gerente> getGerentes() {
        return gerentes;
    }

    private void guardarDatos() {
         try {
             ArrayList arrayList = new ArrayList ();   
        
            arrayList.add(0, administradores);
            arrayList.add(1, jugadores);
            arrayList.add(2, federaciones);
            arrayList.add(3, sedes);
            arrayList.add(4, clubes);
            arrayList.add(5, torneos);
            
            System.out.print("Guardando ArrayList en el fichero objetos.dat.. ");

            ObjectOutputStream escribiendoFichero = new ObjectOutputStream( new FileOutputStream("objetos.dat") );
            escribiendoFichero.writeObject(arrayList);
            escribiendoFichero.close();

            System.out.println("ok!");
            
            
        } catch (Exception e) {
            System.out.println( e.getMessage() );
        }
    }
    
}
