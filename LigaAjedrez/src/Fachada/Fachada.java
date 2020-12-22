/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fachada;

import java.util.ArrayList;
import java.util.Date;
import javax.swing.DefaultListModel;
import modelo.Administrador;
import modelo.Datos;
import modelo.GestorLiga;
import modelo.Liga;
import modelo.Usuario;

/**
 *
 * @author angel
 */
public class Fachada {
    private Usuario usuario;
    private GestorLiga gestor;
    private Administrador administrador;
    
    public Fachada(){
        gestor = new GestorLiga();
        usuario = new Usuario(gestor.getLiga());
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public GestorLiga getGestor() {
        return gestor;
    }

    public void setGestor(GestorLiga gestor) {
        this.gestor = gestor;
    }
    
    public Usuario buscarUsuario(String user) {
        return gestor.buscarUsuario(user);
    }

    public void setAdministrador(Usuario usuario) {        
        administrador = (Administrador)usuario;
    }

    public Liga getLiga() {
        return administrador.getLiga();
    }

    public boolean registrarClub(String club, String federacion, String sede, String dniGerente, String dniEntrenador) {
        return administrador.registrarClub(club, federacion, sede, dniGerente, dniEntrenador);
    }

    public Datos buscarGerente(String DNIgerente) {
        return administrador.buscarGerente(DNIgerente);
    }

    public Datos buscarEntrenador(String DNIentrenador) {
        return administrador.buscarEntrenador(DNIentrenador);
    }

    public boolean comprobarDNI(String dniJugador) {
        return usuario.comprobarDNI(dniJugador);
    }

    public boolean registrarJugadorTorneo(String dniJugador, Object object) {
        return usuario.registrarJugadorTorneo(dniJugador, object);
    }

    public ArrayList buscarTorneos(String dniJugador) {
        return usuario.buscarTorneos(dniJugador);
    }

    public boolean introducirResultado(String jugador, String torneo, String ganador, String rival, Date fecha, String tiempo) {
        return usuario.introducirResultado(jugador, torneo, ganador, rival, fecha, tiempo);
    }

    public ArrayList buscarTorneosJugador(String dniJugador) {
        return usuario.buscarTorneosJugador(dniJugador);
    }

    public ArrayList verPartidas(String dniJugador, String torneo) {
        return usuario.verPartidas(dniJugador, torneo);
    }

    public boolean registrarEntrenador(String nombre, String apellidos, String dni) {
        return administrador.registrarEntrenador(nombre, apellidos, dni);
    }

    public boolean registrarFederacion(String federacion) {
        return administrador.registrarFederacion(federacion);
    }

    public boolean registrarGerente(String nombre, String apellidos, String dni) {
        return administrador.registrarGerente(nombre, apellidos, dni);
    }

    public boolean registrarJugador(String nom, String ape, String dni, Object club, int edad, String user, String pass) {
        return usuario.registrarJugador(nom, ape, dni, club, edad, user, pass);
    }

    public ArrayList buscarClubes(String federacion) {
        return usuario.buscarClubes(federacion);
    }

    public boolean registrarTorneo(String nombreTorneo, DefaultListModel listaTorneo, String federacion) {
        return administrador.registrarTorneo(nombreTorneo, listaTorneo, federacion);
    }

    public ArrayList buscarHorasDisponibles(String dni, Date fecha) {
        return usuario.buscarHorasDisponibles(dni, fecha);
    }
}
