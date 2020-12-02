/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author angel
 */
public class JugadorTest {
    
    public JugadorTest() {
    }
    
    @Test
    public void JugadorTest() {
        Liga liga = new Liga();
        liga.cargarDatos();
        
        Jugador jugador = new Jugador("Adrian", "Montero", "25959852R", liga.buscarClubes("Federacion de Valencia").get(0), 15, liga, "mapache", "unacualquiera");
        int categoriaEsperada = jugador.getCategoria();
        int categoriaReal = 3;
        
        assertEquals(categoriaEsperada,categoriaReal);
        
    }  
    
}
