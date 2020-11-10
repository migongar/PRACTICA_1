/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author angel
 */
public class Resultado implements Serializable{
    
    private static final long serialVersionUID = 1L;
    private String ganador, rival, tiempo;
    private Date fecha;
    
    public Resultado(String ganador, String rival, String tiempo, Date fecha){
        this.ganador = ganador;
        this.rival = rival;
        this.tiempo = tiempo;
        this.fecha = fecha;
    }
    
    
}
