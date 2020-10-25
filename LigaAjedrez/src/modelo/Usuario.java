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
public class Usuario {
    private String login, password;
    protected Liga liga;
    
    public Usuario(){
    }
    
    public Usuario(Liga lig){
        this.liga = lig;
    }    

    public boolean registrarJugador(String nom, String ape, String dni, String club, int edad) {
        if(liga.registrarJugador(nom,ape,dni,club,edad)){
            login = nom.substring(0,3) + ape.substring(0, 3);
            password = "contraseña";
            return true;
        }
        else
            return false;
    }
    
    public String getLogin(){
        return login;
    }
    
    public String getPassword(){
        return login;
    }
}
