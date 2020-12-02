/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import javax.swing.DefaultListModel;

/**
 *
 * @author angel
 */
public class Administrador extends Usuario implements Serializable{

    private static final long serialVersionUID = 1L;
    public Administrador() {
    }

    public Administrador(String nom, String ape, String dni, Liga liga) {
        super(nom, ape, dni, nom.substring(0,2).toLowerCase() + ape.substring(0, 2).toLowerCase(),"contrasenya", 1, liga);   
    }

    public boolean registrarFederacion(String nomFede) {
        return liga.registrarFederacion(nomFede);
    }

    public boolean registrarGerente(String nombre, String apellidos, String dni) {
        return liga.registrarGerente(nombre,apellidos,dni);
    }

    public boolean registrarEntrenador(String nombre, String apellidos, String dni) {
        return liga.registrarEntrenador(nombre,apellidos,dni);
    }
    
    public boolean registrarClub(String club, String federacion, String sede, String gerente, String entrenador) {        
        return liga.registrarClub(club, federacion, sede, gerente, entrenador);
    }

    public Datos buscarGerente(String DNIgerente) {
        Gerente gerente = null;
        Datos datosGerente = null;
        gerente = liga.buscarGerente(DNIgerente);
        if(gerente != null)
            datosGerente = new Datos(gerente.getNombre(), gerente.getApellidos(), gerente.getDNI());
        
        return datosGerente;
    }

    public Datos buscarEntrenador(String DNIentrenador) {
        Entrenador entrenador = null;
        Datos datosGerente = null;
        entrenador = liga.buscarEntrenador(DNIentrenador);
        if(entrenador != null)
            datosGerente = new Datos(entrenador.getNombre(), entrenador.getApellidos(), entrenador.getDNI());
        
        return datosGerente;
    }

    public boolean registrarTorneo(String nombreTorneo, DefaultListModel listaTorneo, String federacion) {
        return liga.registrarTorneo(nombreTorneo, listaTorneo, federacion);
    }
    

    /*public ArrayList<DatosTorneo> buscarTorneosSinPartidas(String federacion) {
        ArrayList<DatosTorneo> torneos = null;
        torneos = liga.buscarTorneosSinPartidas(federacion);
        
        return torneos;
    }*/
}
