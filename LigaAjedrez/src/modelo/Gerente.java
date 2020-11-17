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

    Gerente() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean isContratado() {
        return contratado;
    }

    public void setContratado(boolean contratado) {
        this.contratado = contratado;
    }
        

    public boolean getContratado() {
        return contratado;
    }
    
}
