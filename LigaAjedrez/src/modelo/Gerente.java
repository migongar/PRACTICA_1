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
public class Gerente {
    private String nombre,apellidos,dni;
    private boolean contratado;

    public Gerente(String nombre, String apellidos, String dni) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.contratado = false;
    }
    
}
