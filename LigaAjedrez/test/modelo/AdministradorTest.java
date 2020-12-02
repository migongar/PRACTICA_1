/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import javax.swing.DefaultListModel;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author angel
 */
public class AdministradorTest {
    
    public AdministradorTest() {
    }

    @Test
    public void testRegistrarFederacion() {
        Liga liga = new Liga();
        liga.cargarDatos();
        
        //no deberia poder registrar una federacion que ya está en la base de datos
        assertFalse(liga.registrarFederacion("Federacion de Valencia"));    
    }

    @Test
    public void testRegistrarGerente() {
        Liga liga = new Liga();
        liga.cargarDatos();
        
        //no deberia poder registrar un gerente que ya está en la base de datos
        assertFalse(liga.registrarGerente("Manuel", "Carrera", "25836417H"));
    }

    @Test
    public void testRegistrarEntrenador() {
        Liga liga = new Liga();
        liga.cargarDatos();
        
        //no deberia poder registrar un entrenador que ya está en la base de datos
        assertFalse(liga.registrarEntrenador("Javier", "Maroto", "78451296R")); 
    }

    @Test
    public void testRegistrarClub() {
        Liga liga = new Liga();
        liga.cargarDatos();
        
        //No deberia registrar un club que ya está en la base de datos
        assertFalse(liga.registrarClub("Valencia FC", "Federacion de Barcelona", "Pabellon Oeste", "78451936U", "78459745U"));
    }

    @Test
    public void testBuscarGerente() {
        Gerente gerenteEsperado;
        Liga liga = new Liga();
        liga.cargarDatos();
        
        gerenteEsperado = liga.buscarGerente("25836417H");
        
        assertNull(gerenteEsperado); //BuscarGerente devuelve un gerente si no esta vinculado a un club
    }

    @Test
    public void testBuscarEntrenador() {
        Entrenador entrenadorsEsperado;
        Liga liga = new Liga();
        liga.cargarDatos();
        
        entrenadorsEsperado = liga.buscarEntrenador("78451296R");
        
        assertNull(entrenadorsEsperado); //BuscarEntrenador devuelve un entrenador si no esta vinculado a un club
    }

    @Test
    public void testRegistrarTorneo() {
        Liga liga = new Liga();
        liga.cargarDatos();
        
        ArrayList clubes = new ArrayList();
        DefaultListModel lista = new DefaultListModel();
        
        clubes = liga.buscarClubes("Federacion de Valencia");
               
        for(int i = 0; i < clubes.size(); i++){
            lista.addElement(clubes.get(i));                   
        }
        
        //No deberia de registrar un torneo que ya está en la base de datos
        assertFalse(liga.registrarTorneo("Torneo Smart", lista, "Federacion de Valencia"));
    }
    
}
