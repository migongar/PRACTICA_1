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
public class GestorLiga {
    private Liga liga;
    
    public GestorLiga(){
        liga = new Liga(); 
        liga.cargarDatos();
    }

    public Liga getLiga() {
        return liga;
    }

    public Usuario buscarUsuario(String user) {
        return liga.buscarUsuario(user);
    }
    
}
