/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author angel
 */
public class Reserva {
    private Date fecha;
    private ArrayList<String> reservado = new ArrayList<String>();
    
    public Reserva(Date fecha, String dnijugador){
        this.fecha = fecha;
        reservado.add(dnijugador);
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public boolean comprobarDisponibilidad(String dni) {
        boolean disponible = false;
        
        if(!(reservado.size()==2)){
            if(!reservado.get(0).equals(dni))
                disponible = true;
        }
        
        return disponible;
    }
    
   
}
