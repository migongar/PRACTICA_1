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
public class GestorLigaTest {
    
    public GestorLigaTest() {
    }
    

    @Test
    public void testBuscarUsuario() {
        Liga liga = new Liga();
        liga.cargarDatos();
        String dniReal = "52967432W";
        String dniEsperado = liga.buscarUsuario("maal").getDNI();
        
        assertEquals(dniEsperado,dniReal);
    }
    
}
