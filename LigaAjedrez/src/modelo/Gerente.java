/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;

/**
 *
 * @author angel
 */
public class Gerente extends Persona implements Serializable{

    private static final long serialVersionUID = 1L;
    private boolean contratado;

    public Gerente(String nombre, String apellidos, String dni, boolean contrato) {
        super(nombre,apellidos,dni);
        this.contratado = contrato;
    }
    
    public void setContratado(boolean contrato){
        contratado = contrato;
    }    

    public boolean getContratado() {
        return contratado;
    }
    
}
