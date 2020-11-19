/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.DefaultListModel;

/**
 *
 * @author angel
 */
public class Liga implements Serializable{

    private static final long serialVersionUID = 1L;
    protected FactoriaPersona factoria = new FactoriaPersona();
    protected ArrayList<Club> clubes = new ArrayList<Club>();
    protected ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
    protected ArrayList<Administrador> administradores = new ArrayList<Administrador>();
    protected ArrayList<Torneo> torneos = new ArrayList<Torneo>();
    protected ArrayList<Federacion> federaciones = new ArrayList<Federacion>();
    protected ArrayList<Gerente> gerentes = new ArrayList<Gerente>();
    protected ArrayList<Entrenador> entrenadores = new ArrayList<Entrenador>();


    public void cargarDatos() {
        DAO cargarDatos = new DAO();
        
        jugadores.clear();
        administradores.clear();
        federaciones.clear();
        gerentes.clear();
        entrenadores.clear();
        torneos.clear();
        clubes.clear(); 
        
        factoria.setLiga(this);
        
        administradores = cargarDatos.getAdministradores(factoria);
        jugadores = cargarDatos.getJugadores(factoria);
        federaciones = cargarDatos.getFederaciones(factoria);
        gerentes = cargarDatos.getGerentes(factoria);
        entrenadores = cargarDatos.getEntrenadores(factoria);
        clubes = cargarDatos.getClubes(factoria);
        torneos = cargarDatos.getTorneos(factoria);
        
        System.out.println( "Administradores:"); 
            
        for(int i = 0; i < administradores.size(); i++) {
            System.out.println( administradores.get(i));                
        }

        System.out.println( "Jugadores:"); 

        for(int i = 0; i < jugadores.size(); i++) {
            System.out.println( jugadores.get(i));                
        }

        System.out.println( "Federaciones:"); 

        for(int i = 0; i < federaciones.size(); i++) {
            System.out.println( federaciones.get(i));                
        }

        System.out.println( "Gerentes:"); 

        for(int i = 0; i < gerentes.size(); i++) {
            System.out.println( gerentes.get(i));                
        }

        System.out.println( "Entrenadores:"); 

        for(int i = 0; i < entrenadores.size(); i++) {
            System.out.println( entrenadores.get(i));                
        }

        System.out.println( "Clubes:"); 

        for(int i = 0; i < clubes.size(); i++) {
            System.out.println( clubes.get(i));                
        }

        System.out.println( "Torneos:"); 

        for(int i = 0; i < torneos.size(); i++) {                
            System.out.println( torneos.get(i));
            if(torneos.get(i).isInicio())
                System.out.println("Iniciado");
        }
        
        /*ArrayList arrayList;
        
        jugadores.clear();
        administradores.clear();
        federaciones.clear();
        gerentes.clear();
        entrenadores.clear();
        torneos.clear();
        clubes.clear();    

        try {
            System.out.print("Leyendo ArrayList del fichero objetos.dat.. ");

            ObjectInputStream leyendoFichero = new ObjectInputStream( new FileInputStream("objetos.dat") );
            
            arrayList = ( ArrayList )leyendoFichero.readObject();

            leyendoFichero.close();

            System.out.println("ok!");
            /*System.out.println("Datos leídos del fichero:");
            
            for(int i = 0; i < arrayList.size(); i++) {
                System.out.println( arrayList.get(i));                
            }
            
            administradores = (ArrayList<Administrador>) arrayList.get(0);
            jugadores = (ArrayList<Jugador>) arrayList.get(1);
            federaciones = (ArrayList<Federacion>) arrayList.get(2);
            gerentes = (ArrayList<Gerente>) arrayList.get(3);
            entrenadores = (ArrayList<Entrenador>) arrayList.get(4);
            clubes = (ArrayList<Club>) arrayList.get(5);
            torneos = (ArrayList<Torneo>) arrayList.get(6);
            factoria = (FactoriaPersona) arrayList.get(7);
            
            System.out.println( "Administradores:"); 
            
            for(int i = 0; i < administradores.size(); i++) {
                System.out.println( administradores.get(i));                
            }
            
            System.out.println( "Jugadores:"); 
            
            for(int i = 0; i < jugadores.size(); i++) {
                System.out.println( jugadores.get(i));                
            }
            
            System.out.println( "Federaciones:"); 
            
            for(int i = 0; i < federaciones.size(); i++) {
                System.out.println( federaciones.get(i));                
            }
            
            System.out.println( "Gerentes:"); 
            
            for(int i = 0; i < gerentes.size(); i++) {
                System.out.println( gerentes.get(i));                
            }
            
            System.out.println( "Entrenadores:"); 
            
            for(int i = 0; i < entrenadores.size(); i++) {
                System.out.println( entrenadores.get(i));                
            }
            
            System.out.println( "Clubes:"); 
            
            for(int i = 0; i < clubes.size(); i++) {
                System.out.println( clubes.get(i));                
            }
            
            System.out.println( "Torneos:"); 
            
            for(int i = 0; i < torneos.size(); i++) {                
                System.out.println( torneos.get(i));
                if(torneos.get(i).isInicio())
                    System.out.println("Iniciado");
            }          
            
        } catch (Exception e) {
            System.out.println( e.getMessage() );
        }
    */
    /*
        
        
        Federacion fede = new Federacion("Federacion de Valencia");
        System.out.println("Federacion: " + fede.toString()); 
        
        //CLUB 1
        Gerente gerente = new Gerente("Manuel", "Carrera", "25836417H", true);
        System.out.println("Gerente: " + gerente.toString());  
        
        Entrenador entrenador = new Entrenador("Javier", "Maroto", "78451296R", true);
        System.out.println("Entrenador: " + entrenador.toString());
        
        Sede sede = new Sede("Pavellon Norman");
        System.out.println("Sede: " + sede.toString());
        
        Club club = new Club("Levante FC",fede,sede, gerente, entrenador, this);
        System.out.println("Club: " + club.toString());       
        
        if(!fede.anyadirClub(club))
            System.out.println("Error al añadir club a federacion");
        
        //CLUB 2
        Gerente gerente2 = new Gerente("Amador", "Contraras", "48521569L", true);
        System.out.println("Gerente: " + gerente.toString());  
        
        Entrenador entrenador2 = new Entrenador("Maria", "Valero", "41695278O", true);
        System.out.println("Entrenador: " + entrenador.toString());
        
        Sede sede2 = new Sede("Pavellon Este");
        System.out.println("Sede: " + sede.toString());
        
        Club club2 = new Club("Valencia FC",fede,sede2, gerente2, entrenador2, this);
        System.out.println("Club: " + club2.toString());       
        
        if(!fede.anyadirClub(club2))
            System.out.println("Error al añadir club a federacion");
        
        Torneo torneo = new Torneo("Torneo Smart");
        System.out.println("Torneo: " + torneo.toString());
        torneo.addClub(club);
        torneo.addClub(club2);
        
        Torneo torneo2 = new Torneo("Torneo Santander");
        System.out.println("Torneo: " + torneo2.toString());
        torneo2.addClub(club);
        torneo2.addClub(club2);        
        
        Administrador admin = new Administrador("Julian", "Lopez","89657412P", this);
        System.out.println("Administrador: " + admin.toString());
        
        Jugador jugador = new Jugador("Juan" , "Vazquez", "12256848L", club,  16, this, "juva", "contrasenya");
        System.out.println("Jugador: " + jugador.toString());
        Jugador jugador2 = new Jugador("Marcos" , "Alonso", "52967432W", club2,  17, this, "maal","contrasenya");
        System.out.println("Jugador: " + jugador2.toString());
        
        torneo2.addJugador(jugador);
        torneo2.addJugador(jugador2);
        jugador.addTorneo(torneo2);
        jugador2.addTorneo(torneo2);
        
        Partida partidajuagor = new Partida(jugador, sede, torneo2 );
        Partida partidajuagor2 = new Partida(jugador2, sede, torneo2 );
        
        jugador.addPartida(partidajuagor);
        jugador2.addPartida(partidajuagor2);
        
               
        jugadores.clear();
        administradores.clear();
        federaciones.clear();
        gerentes.clear();
        entrenadores.clear();
        torneos.clear();
        clubes.clear();  
                
        administradores.add(admin);
        
        jugadores.add(jugador);
        jugadores.add(jugador2);
        
        federaciones.add(fede);
        
        gerentes.add(gerente);
        gerentes.add(gerente2);
        
        entrenadores.add(entrenador);
        entrenadores.add(entrenador2);
        
        clubes.add(club);
        clubes.add(club2);
        
        torneos.add(torneo);
        torneos.add(torneo2);
        
        if(this.iniciarTorneo(torneo2))
            System.out.println(torneo2.toString() + "Iniciado");
        
        ArrayList arrayList = new ArrayList();

        System.out.println("Datos que vamos a escribir en el fichero:");      
        
        arrayList.add(0, administradores);
        arrayList.add(1, jugadores);
        arrayList.add(2, federaciones);
        arrayList.add(3, gerentes);
        arrayList.add(4, entrenadores);
        arrayList.add(5, clubes);
        arrayList.add(6, torneos);
        arrayList.add(7, factoria);

        try {
            System.out.print("Guardando ArrayList en el fichero objetos.dat.. ");

            ObjectOutputStream escribiendoFichero = new ObjectOutputStream( new FileOutputStream("objetos.dat") );
            escribiendoFichero.writeObject(arrayList);
            escribiendoFichero.close();

            System.out.println("ok!");
            
            
        } catch (Exception e) {
            System.out.println( e.getMessage() );
        }
*/
    }
    

    public boolean registrarJugador(String nom, String ape, String dni, String club, int edad, String user, String pass) {
        DAO jugadorDAO = new DAO();
        boolean encontrado = false;
        Club clubencontrado = new Club();
        int i = 0;
        while(!encontrado && i<clubes.size()){
            if(clubes.get(i).getNombre().equals(club)){
                clubencontrado = clubes.get(i);
                encontrado = true;
            }
            i++;
        }
        
        //Jugador nuevo = new Jugador(nom,ape,dni,clubencontrado,edad,this,user, pass);
        factoria.setClub(clubencontrado);
        factoria.setEdad(edad);
        factoria.setUser(user);
        factoria.setPassword(pass);  
        
        if(jugadorDAO.registrarJugador((Jugador)factoria.crearPersona(nom, ape, dni, 1))){
            System.out.println("Nuevo Jugador: " + (Jugador)factoria.crearPersona(nom, ape, dni, 1));                
            this.cargarDatos();
            return true;
        }
        else
            return false;
        
        }   
        

    public Usuario buscarUsuario(String user) {
        boolean encontrado = false;
        int i = 0;
        Usuario usuario = null;
        while(!encontrado && i < jugadores.size()){
            if(jugadores.get(i).getLogin().equals(user)){
                encontrado = true;
                usuario = jugadores.get(i);
            }
            i++;
        }
        i=0;
        while(!encontrado && i < administradores.size()){
            if(administradores.get(i).getLogin().equals(user)){
                encontrado = true;
                usuario = administradores.get(i);
            }
            i++;
        }
        return usuario;
    }

    public ArrayList<Torneo> buscarTorneos(String dniJugador) {        
        
        ArrayList<Torneo> encontrados = new ArrayList<Torneo>();
        int existe = this.buscarJugador(dniJugador);
        
        if(existe != -1){
            Jugador jug = jugadores.get(existe);
            for(int i=0;i<torneos.size();i++){
                if(!torneos.get(i).isInicio() && torneos.get(i).buscarClub(jug.getClub()) && !torneos.get(i).buscarJugador(jug.getNombre()))
                    encontrados.add(torneos.get(i));
            }
        }   
        
        return encontrados;
    }

    public boolean inscrbirTorneo(String dniJugador, Torneo tor) {
        DAO incribirDAO = new DAO();
        boolean encontrado = false, inscrito = false;
        int i = 0;
        Jugador jugador = jugadores.get(this.buscarJugador(dniJugador));       
        
        while(!encontrado && i<torneos.size()){
            if(torneos.get(i) == tor){
                encontrado = true;
                inscrito = incribirDAO.registrarJugadorTorneo(jugador,torneos.get(i));
                this.cargarDatos();
            }
            i++;
        }
        
        return inscrito;
        
    }

    public int buscarJugador(String dni) {
        boolean encontrado = false;
        int i = 0;
        
        while(!encontrado && i < jugadores.size()){
            if(jugadores.get(i).getDNI().equals(dni)){
                encontrado = true;
            }
            i++;
        }
        
        if(encontrado)
            return (i-1);
        else
            return (-1);
    }

    public ArrayList<Federacion> getFederaciones() {
        return federaciones;
    }

    public ArrayList<Club> buscarClubes(String federacion) {
        boolean encontrado = false;
        int i = 0;
        ArrayList<Club> clubes= null;
        
        while(!encontrado && i < federaciones.size()){
            if(federaciones.get(i).getNombre().equals(federacion)){
                encontrado = true;
                clubes = federaciones.get(i).getClubes();
            }
            i++;
        }
        
        return clubes;
    }

    public boolean registrarFederacion(String nomFede) {
        DAO federacionDAO = new DAO();
        Federacion fede = new Federacion(nomFede);
        
        if(federacionDAO.registrarFederacion(fede)){
            System.out.println("Nueva Federacion: " + fede); 
            this.cargarDatos();
            return true;
        }
        else
            return false;     
    }

    public boolean registrarGerente(String nombre, String apellidos, String dni) {
        DAO gerenteDAO = new DAO();        
        factoria.setContratado(false);
        
        if(gerenteDAO.registrarGerente((Gerente)factoria.crearPersona(nombre, apellidos, dni,2))){
            System.out.println("Nuevo Gerente: " + (Gerente)factoria.crearPersona(nombre, apellidos, dni, 2)); 
            this.cargarDatos();
            return true;
        }
        else
            return false;
    }

    public boolean registrarEntrenador(String nombre, String apellidos, String dni) {
        DAO entrenadorDAO = new DAO();
 
        factoria.setContratado(false);
        
        if(entrenadorDAO.registrarEntrenador((Entrenador)factoria.crearPersona(nombre,apellidos, dni, 3))){
            System.out.println("Nuevo Entrenador: " + (Entrenador) factoria.crearPersona(nombre, apellidos, dni, 3)); 
            this.cargarDatos();
            return true;
        }
        else
            return false;
    }

    public Sede crearSede(String nomSede/*, Federacion fede*/) {        
        boolean repetido = false;
        int i = 0;
        
        while(!repetido && i < clubes.size()){
            if(clubes.get(i).getSede().getNombre().equals(nomSede)){
                repetido = true;
            }
            i++;
        }          
        
        if(!repetido){
            Sede sede = new Sede(nomSede/*,fede*/);
            System.out.println("Nueva Sede: " + sede);
            return sede;
        }
        else{
            System.out.println("ERROR: Nombre Sede repetido");
            return null;
        }            
    }

    public ArrayList<Entrenador> getEntrenadores() {
        return entrenadores;
    }

    public ArrayList<Gerente> getGerentes() {
        return gerentes;
    }

    private void guardarDatos() {
         try {
             ArrayList arrayList = new ArrayList ();   
        
            arrayList.add(0, administradores);
            arrayList.add(1, jugadores);
            arrayList.add(2, federaciones);
            arrayList.add(3, gerentes);
            arrayList.add(4, entrenadores);
            arrayList.add(5, clubes);
            arrayList.add(6, torneos);
            arrayList.add(7, factoria);
            
            System.out.print("Guardando ArrayList en el fichero objetos.dat.. ");

            ObjectOutputStream escribiendoFichero = new ObjectOutputStream( new FileOutputStream("objetos.dat") );
            escribiendoFichero.writeObject(arrayList);
            escribiendoFichero.close();

            System.out.println("ok!");
            
            
        } catch (Exception e) {
            System.out.println( e.getMessage() );
        }
    }

    public boolean registrarClub(String club, String federacion, String sede, String gerente, String entrenador) {
        DAO clubDAO = new DAO();        
        Federacion fede = null;
        Sede nuevasede = null;
        boolean encontrado = false;
        int i = 0;
        while(!encontrado && i < federaciones.size()){
            if(federaciones.get(i).getNombre().equals(federacion)){
                encontrado = true;
                fede = federaciones.get(i);
            }
            i++;
        }
        
        nuevasede = this.crearSede(sede/*, fede*/);
        
        if(nuevasede != null){
            Gerente gerenteclub = this.contratarGerente(gerente);
            Entrenador entrenadorclub = this.contratarEntrenador(entrenador);
            System.out.println("gerente contratado: " + gerenteclub.getDNI()); 
            Club nuevoclub = new Club(club,fede,nuevasede,gerenteclub,entrenadorclub,this);
            
            if(clubDAO.registrarClub(nuevoclub)){
                    System.out.println("Nuevo Club: " + nuevoclub); 
                    this.cargarDatos();
                    return true;
            }
            else
                return false;         
        }
        else
            return false;
            
    }

    public Gerente contratarGerente(String gerente) {
        boolean encontrado = false;
        int i = 0;
        Gerente encGerente= null;
        
        while(!encontrado && i < gerentes.size()){
            if(gerentes.get(i).getDNI().equals(gerente)){
                encontrado = true;
                gerentes.get(i).setContratado(true);
                encGerente = gerentes.get(i);
            }
            i++;
        }
        
        return encGerente;
    }

    public Entrenador contratarEntrenador(String entrenador) {
        boolean encontrado = false;
        int i = 0;
        Entrenador encEntrenador= null;
        
        while(!encontrado && i < entrenadores.size()){
            if(entrenadores.get(i).getDNI().equals(entrenador)){
                encontrado = true;
                entrenadores.get(i).setContratado(true);
                encEntrenador = entrenadores.get(i);
            }
            i++;
        }
        
        return encEntrenador;
    }

    public Gerente buscarGerente(String DNIgerente) {
        boolean encontrado = false;
        int i = 0;
        Gerente encGerente= null;
        
        while(!encontrado && i < gerentes.size()){
            if(gerentes.get(i).getDNI().equals(DNIgerente) && !gerentes.get(i).isContratado()){
                encontrado = true;
                encGerente = gerentes.get(i);
            }
            i++;
        }
        
        return encGerente;
    }

    public Entrenador buscarEntrenador(String DNIentrenador) {
        boolean encontrado = false;
        int i = 0;
        Entrenador encEntrenador= null;
        
        while(!encontrado && i < entrenadores.size()){
            if(entrenadores.get(i).getDNI().equals(DNIentrenador)){
                encontrado = true;
                encEntrenador = entrenadores.get(i);
            }
            i++;
        }
        
        return encEntrenador;
    }

    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }

    public ArrayList getTorneos() {
        return torneos;
    }

    public boolean registrarTorneo(String nombreTorneo, DefaultListModel listaTorneo, String federacion) {
        DAO torneoDAO = new DAO();
        Club club = null;
        /*Federacion fede = null;
        boolean encFede = false;
        int k = 0;
        
        while(!encFede && k < federaciones.size()){
            if(federaciones.get(k).getNombre().equals(federacion)){
                encFede = true;
                fede = federaciones.get(k);
            }
            k++;
        }*/
        
        Torneo nuevoTorneo = new Torneo(nombreTorneo/*, fede*/);
                
        for(int i = 0;i<listaTorneo.size();i++){
            boolean encontrado = false;
            int j = 0;
            while(!encontrado && j<clubes.size()){
                if(clubes.get(j).getNombre().equals(listaTorneo.get(i).toString())){
                    club = clubes.get(j);
                    nuevoTorneo.addClub(club);
                    encontrado = true;
                }
                j++;
            }
        }       
        
        if(torneoDAO.registrarTorneo(nuevoTorneo)){
            System.out.println("Nuevo Torneo: " + nuevoTorneo); 
            this.cargarDatos();
            return true;
        }
        else
            return false;   
        
    }

    /*public ArrayList<DatosTorneo> buscarTorneosSinPartidas(String federacion) {
        ArrayList<DatosTorneo> torneosDisponibles = new ArrayList<DatosTorneo>();        
        String nomTorneo;
        for(int i = 0;i<torneos.size();i++){
            nomTorneo = torneos.get(i).getFederacion().getNombre();
            if(nomTorneo.equals(federacion)){
                DatosTorneo datos = new DatosTorneo(nomTorneo,torneos.get(i).getNumJugadores());
                torneosDisponibles.add(datos);
            }
        }
        
        return torneosDisponibles;
    }*/

    public ArrayList<Partida> buscarPartidasEnCurso(String dniJugador) {
        boolean encontrado = false;
        int i = 0;
        ArrayList<Partida> partidas=  new ArrayList<Partida>();
        ArrayList<Partida> encurso = new ArrayList<Partida>();
        Jugador jugador = null;
        
        while(!encontrado && i < jugadores.size()){
            if(jugadores.get(i).getDNI().equals(dniJugador)){
                partidas = jugadores.get(i).getPartidas();                
                for(int j = 0;j<partidas.size();j++){
                    if(partidas.get(i).getResultado() == null){
                        encurso.add(partidas.get(i));
                    }
                }
            }
            i++;
        }
        
        return encurso;
    }

    public boolean introducirResultado(String jugador, String torneo, String ganador, String rival, Date fecha, String tiempo) {
        boolean encPartida = false;
        int i = 0,indice = this.buscarJugador(jugador), indT = this.buscarTorneo(torneo);
        Jugador jug = jugadores.get(indice);
        
        while(!encPartida && i < jug.getPartidas().size()){
                if(jug.getPartidas().get(i).getOponente().getNombre().equals(rival)){
                        if(jug.getNombre().equals(ganador)){
                            torneos.get(i).eliminarJugadorTorneo(jug.getPartidas().get(i).getOponente());
                            Partida nuevaPartida = torneos.get(indT).siguientePartida(jugadores.get(indice));
                            jugadores.get(indice).addPartida(nuevaPartida);                            
                        }                        
                        else{
                            torneos.get(i).eliminarJugadorTorneo(jug);
                            jugadores.get(indice).elimnarTorneoJugador(torneos.get(indT));
                        }
                        Resultado resultado = new Resultado(ganador, rival, tiempo, fecha);
                        jugadores.get(indice).getPartidas().get(i).setResultado(resultado);
                        System.out.println(jugadores.get(indice).getPartidas().get(i).getResultado());

                        encPartida = true;
                }
                    i++;
            }
        
            return encPartida;
         
    }
    
    public int buscarTorneo(String torneo) {
        boolean encontrado = false;
        int i = 0;
        
        while(!encontrado && i < torneos.size()){
            if(torneos.get(i).getNombre().equals(torneo)){
                encontrado = true;
            }
            i++;
        }
        
        if(encontrado)
            return (i-1);
        else
            return (-1);
    }

    public ArrayList<Torneo> buscarTorneosJugador(String jugador) {
        int indice = this.buscarJugador(jugador);        
        ArrayList<Torneo> torneosEncurso = new ArrayList<Torneo>();
        
        if(indice >= 0){
            ArrayList<Torneo> torneosJugador = jugadores.get(indice).getTorneos();
            for(int i = 0;i<torneosJugador.size();i++){
                if(torneosJugador.get(i).isInicio())
                    torneosEncurso.add(torneosJugador.get(i));
            }
        }
        
        return torneosEncurso;
    }

    public ArrayList<Partida> buscarPartidasJugador(String jugador, String torneo) {
        int indice = this.buscarJugador(jugador);
        boolean encontrado = false;
        int i = 0;
        ArrayList<Partida> partidas = new ArrayList<Partida>();
        
        ArrayList<Partida> partidasJugador = jugadores.get(indice).getPartidas();
        
        try{
        while(!encontrado && i<partidasJugador.size()){
            if(partidasJugador.get(i).getTorneo().getNombre().equals(torneo) && partidasJugador.get(i).getResultado() == null){
                partidas.add(partidasJugador.get(i));
                encontrado = true;
            }
            i++;            
        }
        }catch(Exception e){
            System.out.println( e.getMessage() );
        }
                
        return partidas;
    }
    
    public boolean iniciarTorneo(Torneo torneo){
        ArrayList<Jugador> encTorneo = new ArrayList<Jugador>();
        boolean torneoenc = false, torneojugador = false;
        int i = 0, indice = 0;
        
        System.out.println( "iniciar torneo" + torneo.getNombre());
        
        while(!torneoenc && i<torneos.size()){
            System.out.println( "Torneo:" + torneos.get(i).getNombre());
            if(torneos.get(i).getNombre().equals(torneo.getNombre())){
                encTorneo = torneos.get(i).getJugadores();
                torneos.get(i).setInicio(true);
                torneoenc = true;
                System.out.println( "Torneo encontrado");
            }
            i++;            
        }        
        
        for(int j = 0; j< encTorneo.size();j++){
            indice = this.buscarJugador(encTorneo.get(j).getDNI());
            torneojugador = false;
            i = 0;
            while(!torneojugador && i<jugadores.size()){
                if(jugadores.get(indice).getTorneos().get(i).getNombre().equals(torneo.getNombre())){
                    jugadores.get(indice).getTorneos().get(i).setInicio(true);
                    torneojugador = true;
                    System.out.println( "Torneojugador encontrado");
                }
            i++;
            }           
        }
        
        return (torneojugador && torneoenc);
    }
}
