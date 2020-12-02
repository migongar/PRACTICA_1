/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fachada;

import java.util.ArrayList;
import javax.swing.DefaultListModel;
import modelo.Administrador;
import modelo.Datos;
import modelo.GestorLiga;
import modelo.Liga;
import modelo.Torneo;
import modelo.Usuario;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author angel
 */
public class FachadaTest {
    
    public FachadaTest() {
    }    

    @Test
    public void testBuscarUsuario() {        
        Liga liga = new Liga();
        liga.cargarDatos();
        GestorLiga gestor = new GestorLiga();
        String dniReal = "52967432W";        
        String dniEsperado = gestor.buscarUsuario("maal").getDNI();
        
        assertEquals(dniEsperado,dniReal);
    }
    
    @Test
    public void testRegistrarClub() {
        Liga liga = new Liga();
        liga.cargarDatos();
        Administrador admin = new Administrador();
        admin.setLiga(liga);
        
        //No deberia registrar un club que ya está en la base de datos
        assertFalse(admin.registrarClub("Valencia FC", "Federacion de Barcelona", "Pabellon Oeste", "78451936U", "78459745U"));
        
    }

    @Test
    public void testBuscarGerente() {
        Datos datosEsperado;
        Liga liga = new Liga();
        liga.cargarDatos();
        Administrador admin = new Administrador();
        admin.setLiga(liga);
        
        datosEsperado = admin.buscarGerente("25836417H");
        
        assertNull(datosEsperado); //BuscarGerente devuelve un gerente si no esta vinculado a un club
    }

    @Test
    public void testBuscarEntrenador() {
        Datos datosEsperado;
        Liga liga = new Liga();
        liga.cargarDatos();
        Administrador admin = new Administrador();
        admin.setLiga(liga);
        
        datosEsperado = admin.buscarEntrenador("78451296R");
        
        assertNull(datosEsperado); //BuscarEntrenador devuelve un entrenador si no esta vinculado a un club
    }

    @Test
    public void testComprobarDNI() {
        Liga liga = new Liga();
        liga.cargarDatos();
        Usuario usuario = new Usuario();
        usuario.setLiga(liga);
        assertFalse(usuario.comprobarDNI("748521369O")); //Mas de 8 digitos
        assertTrue(usuario.comprobarDNI("74852136O"));
    }

    @Test
    public void testRegistrarJugadorTorneo() {
        Liga liga = new Liga();
        liga.cargarDatos();
        Usuario usuario = new Usuario();
        usuario.setLiga(liga);       
        
        /*No se que como testear el registrarse en un torneo, porque antes de lanzar la funcion 
        solo le muestro torneos en el que el usuario pueda incribirse proporcionando un dni correcto
        Así que comprobar que el dni y el torneo son correctos para inscribirse es repetitivo pero es
        lo unico que se me ocurre*/
        
        ArrayList<Torneo> torneos = usuario.buscarTorneosJugador("52967432W");//Nombre: Marcos Alonso
        
        boolean existe = false;        
        int i =0;
        Torneo torneo = new Torneo();
        
        while(!existe && i < torneos.size()){
            if(torneos.get(i).getNombre().equals("Torneo Smart")){
                existe = true;
                torneo = torneos.get(i);
            }
            i++;
        }
        //No puede inscribirse en un torneo en el que ya lo esta
        assertFalse(usuario.registrarJugadorTorneo("52967432W", torneo));
        
        ArrayList<Torneo> torneosdisponibles = usuario.buscarTorneos("52967432W");//Nombre: Marcos Alonso
                
        //No puede inscribirse un usuario que no esta en la base de datos
        assertFalse(usuario.registrarJugadorTorneo("47485784F", torneosdisponibles.get(0)));
    }

    @Test
    public void testBuscarTorneos() {
        Liga liga = new Liga();
        liga.cargarDatos();
        Usuario usuario = new Usuario();
        usuario.setLiga(liga);
        
        int tamEsperado = usuario.buscarTorneos("78412635N").size();
        int tamReal = 0; //numero de torneos en los que se puede inscribir(su club no esta vinculado a ningun torneo)
        
        assertEquals(tamEsperado, tamReal);
    }
/*
    @Test
    public void testIntroducirResultado() {
        //esta funcion no funciona aunque este implementada porque no hay partidas en la Base de datos;
        fail("el test falla");
    }

    @Test
    public void testBuscarTorneosJugador() {
        //esta funcion no funciona aunque este implementada porque no hay partidas en la Base de datos;
        fail("El test falla");
    }

    @Test
    public void testVerPartidas() {
        //esta funcion no funciona aunque este implementada porque no hay partidas en la Base de datos;
        fail("el test falla");
    }
*/
    @Test
    public void testRegistrarEntrenador() {
        Liga liga = new Liga();
        liga.cargarDatos();
        Administrador admin = new Administrador();
        admin.setLiga(liga);
        
        //no deberia poder registrar un entrenador que ya está en la base de datos
        assertFalse(admin.registrarEntrenador("Javier", "Maroto", "78451296R")); 
    }

    @Test
    public void testRegistrarFederacion() {
        Liga liga = new Liga();
        liga.cargarDatos();
        Administrador admin = new Administrador();
        admin.setLiga(liga);
        
        //no deberia poder registrar una federacion que ya está en la base de datos
        assertFalse(admin.registrarFederacion("Federacion de Valencia"));
    }

    @Test
    public void testRegistrarGerente() {
        Liga liga = new Liga();
        liga.cargarDatos();
        Administrador admin = new Administrador();
        admin.setLiga(liga);
        
        //no deberia poder registrar un gerente que ya está en la base de datos
        assertFalse(admin.registrarGerente("Manuel", "Carrera", "25836417H"));
    }

    @Test
    public void testRegistrarJugador() {
        Liga liga = new Liga();
        liga.cargarDatos();
        Administrador admin = new Administrador();
        admin.setLiga(liga);
        
        ArrayList clubes = admin.buscarClubes("Federacion de Valencia");
        
        //no deberia poder registrar un jugador que ya está en la base de datos
        assertFalse(admin.registrarJugador("Antonio", "Recio", "78412635N", clubes.get(0), 25, "popeye", "otracontra"));
    }

    @Test
    public void testBuscarClubes() {
        Liga liga = new Liga();
        liga.cargarDatos();
        Usuario usuario = new Usuario();
        usuario.setLiga(liga);
        
        int tamEsperado = usuario.buscarClubes("Federacion de Valencia").size();
        int tamReal = 3;
        
        assertEquals(tamEsperado, tamReal);
    }

    @Test
    public void testRegistrarTorneo() {
        Liga liga = new Liga();
        liga.cargarDatos();
        Administrador admin = new Administrador();
        admin.setLiga(liga);
        
        ArrayList clubes = new ArrayList();
        DefaultListModel lista = new DefaultListModel();
        
        clubes = admin.buscarClubes("Federacion de Valencia");
               
        for(int i = 0; i < clubes.size(); i++){
            lista.addElement(clubes.get(i));                   
        }
        
        //No deberia de registrar un torneo que ya está en la base de datos
        assertFalse(admin.registrarTorneo("Torneo Smart", lista, "Federacion de Valencia"));
    }
    
}
