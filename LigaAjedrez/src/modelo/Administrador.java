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
public class Administrador extends Usuario{
    private String nombre, apellidos, dni;
    
    /*public Administrador() {
    }
*/
    public Administrador(String nom, String ape, String dni, Liga liga) {
        super(nom.substring(0,2).toLowerCase() + ape.substring(0, 2).toLowerCase(),"contrasenya", 1, liga);        
        this.nombre = nom;
        this.apellidos = ape;
        this.dni = dni;
        System.out.println("Admin: " + (nom.substring(0,2).toLowerCase() + ape.substring(0, 2).toLowerCase()) +
                "Contraseña: contrasenya" + "DNI: " + this.dni);
    }
    
}
