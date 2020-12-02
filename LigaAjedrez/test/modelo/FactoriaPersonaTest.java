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
public class FactoriaPersonaTest {
    
    public FactoriaPersonaTest() {
        
    }
    
    @Test
    public void FactoriaPersonaTest() {
        FactoriaPersona factoria = new FactoriaPersona();
        
        assertNull(factoria.crearPersona("Juan", "Cañadas", "47851236O", 5));
        
    }

        
}
