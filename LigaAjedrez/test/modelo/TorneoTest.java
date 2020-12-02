/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author angel
 */
public class TorneoTest {
    
    public TorneoTest() {
    }

    @Test
    public void testBuscarClub() {
        Liga liga = new Liga();
        liga.cargarDatos();
        Torneo torneo = new Torneo();
        Club club = new Club();
        boolean encontrado = false;
        int i = 0;
        
        ArrayList<Torneo> torneos = liga.getTorneos();        
        
        while(!encontrado && i<torneos.size()){
            if(torneos.get(i).getNombre().equals("Torneo BBVA")){
                encontrado = true;
                torneo = torneos.get(i);
            }
            i++;
        }
        
        ArrayList<Club> clubes = liga.buscarClubes("Federacion de Valencia");
        
        encontrado = false;
        i=0;
        
        while(!encontrado && i<clubes.size()){
            if(clubes.get(i).getNombre().equals("Levante FC")){
                encontrado = true;
                club = clubes.get(i);
            }
            i++;
        }
        
        //Este club participa en este torneo
        assertTrue(torneo.buscarClub(club));
        
    }

    @Test
    public void testBuscarJugador() {
        Liga liga = new Liga();
        liga.cargarDatos();
        Torneo torneo = new Torneo();
        boolean encontrado = false;
        int i = 0;
        
        ArrayList<Torneo> torneos = liga.getTorneos();
        
        while(!encontrado && i<torneos.size()){
            if(torneos.get(i).getNombre().equals("Torneo BBVA")){
                encontrado = true;
                torneo = torneos.get(i);
            }
            i++;
        }
        
        //Este jugador no participa en el torneo
        assertFalse(torneo.buscarJugador("52967432W")); //Nombre: Marcos Alonso
    }
/*
    @Test
    public void testSiguientePartida() {
        //esta funcion no funciona aunque este implementada porque no hay partidas en la Base de datos;
        fail("El test falla");
    }
*/
}
