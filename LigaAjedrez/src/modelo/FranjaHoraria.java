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
public class FranjaHoraria {
    private ArrayList<Reserva> reservas;
    private String hora;
    
    public FranjaHoraria(String h){
        this.hora = h;
        reservas = new ArrayList<Reserva>();
    }

    public boolean comprobarDisponiblidad(String dni, Date fecha) {
        boolean disponible = true;
        if(!reservas.isEmpty()){
            System.out.println("no esta vacio");
            for(int i = 0; i < reservas.size();i++){
                if(fecha.equals(reservas.get(i).getFecha()))
                    disponible = reservas.get(i).comprobarDisponibilidad(dni);
            }
        }
            
        return disponible;
    }

    public void addReserva(Reserva reserva) {
        reservas.add(reserva);
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String toString(){
        return hora;
    }
}
