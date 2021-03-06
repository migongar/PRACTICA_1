/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author angel
 */
public class DAO{
    public boolean registrarEntrenador(Entrenador entr) {
        boolean hecho = false;
        Connection connection=null;
	Conexion conexion=new Conexion();
        PreparedStatement statement=null;
        ResultSet resultados = null;
        
        connection = conexion.getConnection();
        
        try {                   
            if (connection!=null) {
                String registropersona = "insert into personas(nombre, apellidos, dni) values (?,?,?)";
                statement=connection.prepareStatement(registropersona);
                statement.setString(1, entr.getNombre());
                statement.setString(2, entr.getApellidos());
                statement.setString(3, entr.getDNI());
                
                if (statement.executeUpdate() > 0) {
                    String consulta = "SELECT idpersonas FROM personas WHERE dni = ?";
                    statement=connection.prepareStatement(consulta);
                    statement.setString(1, entr.getDNI());
                    resultados = statement.executeQuery();
                    if(resultados.next()){
                        int i = resultados.getInt(1);
                        String registroentrenador = "insert into entrenadores(contratado,id_persona) values (?,?)";
                        statement=connection.prepareStatement(registroentrenador);
                        statement.setBoolean(1, entr.isContratado());
                        statement.setInt(2, i);
                        if(statement.executeUpdate() > 0){
                            hecho = true;
                        }
                    }         
                }
            }
        } catch (SQLException e) { // Error al realizar la consulta
            System.out.println("Error en la petición a la BD: " + e.getMessage());
        }finally{
        try {
                 if(statement!=null)
                     statement.close();             
                 if(connection!=null)
                     connection.close();
                 conexion.desconectar();
             } catch (SQLException ex) {
                 System.err.println( ex.getMessage() );    
             }
                
        }
        
        return hecho;
    }

    public boolean registrarGerente(Gerente ger) {
        boolean hecho = false;
        Connection connection=null;
	Conexion conexion=new Conexion();
        PreparedStatement statement=null;
        ResultSet resultados = null;
        
        connection = conexion.getConnection();
        
        try {                   
            if (connection!=null) {
                String registropersona = "insert into personas(nombre, apellidos, dni) values (?,?,?)";
                statement=connection.prepareStatement(registropersona);
                statement.setString(1, ger.getNombre());
                statement.setString(2, ger.getApellidos());
                statement.setString(3, ger.getDNI());
                
                if (statement.executeUpdate() > 0) {
                    String consulta = "SELECT idpersonas FROM personas WHERE dni = ?";
                    statement=connection.prepareStatement(consulta);
                    statement.setString(1, ger.getDNI());
                    resultados = statement.executeQuery();
                    if(resultados.next()){
                        int i = resultados.getInt(1);
                        String registroentrenador = "insert into gerentes(contratado,id_persona) values (?,?)";
                        statement=connection.prepareStatement(registroentrenador);
                        statement.setBoolean(1, ger.isContratado());
                        statement.setInt(2, i);
                        if(statement.executeUpdate() > 0){
                            hecho = true;
                        }
                    }         
                }
            }
        } catch (SQLException e) { // Error al realizar la consulta
            System.out.println("Error en la petición a la BD: " + e.getMessage());
        }finally{
        try {
                 if(statement!=null)
                     statement.close();             
                 if(connection!=null)
                     connection.close();
                 conexion.desconectar();
             } catch (SQLException ex) {
                 System.err.println( ex.getMessage() );    
             }
                
        }
        
        return hecho;
    }

    public boolean registrarFederacion(Federacion fede) {
        boolean hecho = false;
        Connection connection=null;
	Conexion conexion=new Conexion();
        PreparedStatement statement=null;
        
        connection = conexion.getConnection();
        
        try {                   
            if (connection!=null) {
                String registro = "insert into federaciones(nombre_federacion) values (?)";
                statement=connection.prepareStatement(registro);
                statement.setString(1, fede.getNombre());
                
                if (statement.executeUpdate() > 0) {
                    hecho = true;
                    //se indica que se deben aplicar los cambios en la base de datos
                    connection.commit();
                }
            }
        } catch (SQLException e) { // Error al realizar la consulta
            System.out.println("Error en la petición a la BD RegistrarFederacion: " + e.getMessage());
        }finally{
        try {
                 if(statement!=null)
                     statement.close();             
                 if(connection!=null)
                     connection.close();
                 conexion.desconectar();
             } catch (SQLException ex) {
                 System.err.println( ex.getMessage() );    
             }
                
        }
        
        return hecho;        
       }

    public ArrayList<Federacion> getFederaciones(FactoriaPersona factoria) {
        ArrayList<Federacion> federaciones = new ArrayList<Federacion>();
        Connection connection=null;
	Conexion conexion=new Conexion();
        PreparedStatement statement=null;
        ResultSet resultados = null;
        
        connection = conexion.getConnection();
        
        try {
            if (connection!=null) {
                // Consulta SQL
                String consulta = "SELECT idfederaciones,nombre_federacion FROM federaciones ";
                statement=connection.prepareStatement(consulta);           
                
                resultados = statement.executeQuery();
                while (resultados.next()) {
                    Federacion fede = new Federacion(resultados.getString("nombre_federacion"));                    
                    ResultSet clubes = null;
                    String consultas = "SELECT nombre_club,id_sede,id_gerente,id_entrenador FROM clubes WHERE id_federacion = ?";
                    statement=connection.prepareStatement(consultas);
                    statement.setInt(1, resultados.getInt("idfederaciones"));
                
                    clubes = statement.executeQuery();
                    while (clubes.next()) {
                        Club club_federacion = new Club();
                        club_federacion.setNombre(clubes.getString("nombre_club"));
                        
                        ResultSet rconsultas = null;                       
                        consultas = "SELECT nombre_sede FROM sedes WHERE idsedes = ?";
                            
                        statement=connection.prepareStatement(consultas);
                        statement.setInt(1, clubes.getInt("id_sede"));

                        rconsultas = statement.executeQuery();
                        if(rconsultas.next()){
                            Sede sede_club = new Sede(rconsultas.getString("nombre_sede"));
                            club_federacion.setSede(sede_club);                            
                        }

                        consultas = "SELECT nombre,apellidos,dni,contratado FROM entrenadores JOIN personas ON id_persona = idpersonas WHERE identrenadores = ?";
                        statement=connection.prepareStatement(consultas);
                        statement.setInt(1, clubes.getInt("id_entrenador"));

                        rconsultas = statement.executeQuery();
                        if(rconsultas.next()){
                            Entrenador entrenador = (Entrenador) factoria.crearPersona(rconsultas.getString("nombre"), rconsultas.getString("apellidos"), rconsultas.getString("dni"), 3);
                            entrenador.setContratado(rconsultas.getBoolean("contratado"));
                            club_federacion.setEntrenador(entrenador);
                        }

                        consultas = "SELECT nombre,apellidos,dni,contratado FROM gerentes JOIN personas ON id_persona = idpersonas WHERE idgerentes = ?";
                        statement=connection.prepareStatement(consultas);
                        statement.setInt(1, clubes.getInt("id_gerente"));

                        rconsultas = statement.executeQuery();
                        if(rconsultas.next()){
                            Gerente gerente = (Gerente) factoria.crearPersona(rconsultas.getString("nombre"), rconsultas.getString("apellidos"), rconsultas.getString("dni"), 2);
                            gerente.setContratado(rconsultas.getBoolean("contratado"));
                            club_federacion.setGerente(gerente);
                        }                        
                        fede.anyadirClub(club_federacion);                        
                    }
                    federaciones.add(fede);
                }
            }                       
        } catch (SQLException e) { // Error al realizar la consulta
            System.out.println("Error en la petición a la BD");
        }
        
        conexion.desconectar();
        
        return federaciones;
    }

    /*public int buscarJugador(String dniJugador) {
        int idjugador = -1;
        Connection connection=null;
	Conexion conexion=new Conexion();
        PreparedStatement statement=null;
        ResultSet resultados = null;
        
        connection = conexion.getConnection();
        
        try {
            if (connection!=null) {
                // Consulta SQL
                String consulta = "SELECT idjugadores FROM usuarios u JOIN jugadores j ON j.id_usuario = u.idusuarios JOIN personas p ON u.id_persona = p.idpersonas WHERE dni = ? ";
                statement=connection.prepareStatement(consulta);
                statement.setString(1, dniJugador);
                
                resultados = statement.executeQuery();
                if(resultados.next()) {
                    idjugador = resultados.getInt("idjugadores");
                }
            }           
        } catch (SQLException e) { // Error al realizar la consulta
            System.out.println("Error en la petición a la BD");
        }
        
        conexion.desconectar();
        
        return idjugador;
    }*/

    public ArrayList<Integer> buscarTorneosJugador(int idjugador) {
        ArrayList<Integer> torneos = new ArrayList<Integer>();
        Connection connection=null;
	Conexion conexion=new Conexion();
        PreparedStatement statement=null;
        ResultSet resultados = null;
        
        connection = conexion.getConnection();
        
        try {
            if (connection!=null) {
                // Consulta SQL
                String consulta = "SELECT id_torneo FROM torneo_jugador WHERE id_jugador = ? ";
                statement=connection.prepareStatement(consulta);                
                statement.setInt(1, idjugador);
                resultados = statement.executeQuery();
                while (resultados.next()) {
                        torneos.add(resultados.getInt("id_torneo"));
                }
            }           
        } catch (SQLException e) { // Error al realizar la consulta
            System.out.println("Error en la petición a la BD");
        }
        
        conexion.desconectar();
        
        return torneos;
    }

    /*public ArrayList<Torneo> buscarTorneoDisponibleJugador(int idclub, ArrayList<Integer> idtorneos) {
        ArrayList<Torneo> torneos = new ArrayList<Torneo>();
        Connection connection=null;
	Conexion conexion=new Conexion();
        PreparedStatement statement=null;
        ResultSet resultados = null;
        
        connection = conexion.getConnection();
        
        try {
            if (connection!=null) {
                // Consulta SQL
                String sentencias = "?";
                for(int i = 1; i < idtorneos.size();i++){
                    sentencias = sentencias + ",?";
                }
                
                String consulta = "SELECT nombre_torneo, inicio FROM torneos t JOIN torneo_club tc ON tc.id_torneo = t.idtorneos WHERE tc.id_club = ? AND t.inicio = false AND t.idtorneos NOT IN ("+sentencias+")";
                System.out.println(consulta);
                statement=connection.prepareStatement(consulta);               
                statement.setInt(1, idclub);
                int j = 2;
                for(int i = 0; i < idtorneos.size();i++){
                   statement.setInt(j, idtorneos.get(i));
                   j++;
                }
                
                resultados = statement.executeQuery();
                while (resultados.next()) {
                        Torneo torneo = new Torneo();
                        torneo.setNombre(resultados.getString("nombre_torneo"));
                        torneo.setInicio(resultados.getBoolean("inicio"));
                        System.out.println(torneo);
                        torneos.add(torneo);
                    }
                }           
        } catch (SQLException e) { // Error al realizar la consulta
            System.out.println("Error en la petición a la BD");
        }
        
        conexion.desconectar();
        
        return torneos;
    }*/

    /*public ArrayList<Club> buscarClubes(String federacion) {
        ArrayList<Club> clubes = new ArrayList<Club>();
        Connection connection=null;
	Conexion conexion=new Conexion();
        PreparedStatement statement=null;
        ResultSet resultados = null;
        
        connection = conexion.getConnection();
        
        try {
            if (connection!=null) {
                // Consulta SQL
                String consulta = "SELECT nombre_club FROM clubes JOIN federaciones ON id_federacion = idfederaciones WHERE nombre_federacion = ?";
                statement=connection.prepareStatement(consulta);
                statement.setString(1, federacion);
                
                resultados = statement.executeQuery();
                while (resultados.next()) {
                        Club club = new Club();
                        club.setNombre(resultados.getString("nombre_club"));
                        clubes.add(club);
                    }
                }           
        } catch (SQLException e) { // Error al realizar la consulta
            System.out.println("Error en la petición a la BD");
        }
        
        conexion.desconectar();
        
        return clubes;
    }*/

    public ArrayList<Administrador> getAdministradores(FactoriaPersona factoria) {
        ArrayList<Administrador> administradores = new ArrayList<Administrador>();
        Connection connection=null;
	Conexion conexion=new Conexion();
        PreparedStatement statement=null;
        ResultSet resultados = null;
        
        connection = conexion.getConnection();
        
        try {
            if (connection!=null) {
                // Consulta SQL
                String consulta = "SELECT nombre, apellidos, dni, login, password FROM usuarios JOIN personas ON id_persona = idpersonas WHERE tipo = 1";
                statement=connection.prepareStatement(consulta);
                
                resultados = statement.executeQuery();
                while (resultados.next()) {
                    Administrador administrador = (Administrador) factoria.crearPersona(resultados.getString("nombre"), resultados.getString("apellidos"), resultados.getString("dni"), 4);
                    administrador.setLogin(resultados.getString("login"));
                    administrador.setContraseña(resultados.getString("password"));
                    administrador.setTipousuario(1);
                    administrador.setLiga(factoria.getLiga());
                    administradores.add(administrador);
                    }
                }           
        } catch (SQLException e) { // Error al realizar la consulta
            System.out.println("Error en la petición a la BD getAdministradores: " + e.getMessage());
        }
        
        conexion.desconectar();
        
        return administradores;
    }

    public ArrayList<Jugador> getJugadores(FactoriaPersona factoria) {
        ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
        Connection connection=null;
	Conexion conexion=new Conexion();
        PreparedStatement statement=null;
        ResultSet resultados = null;
        
        connection = conexion.getConnection();
        
        try {
            if (connection!=null) {
                // Consulta SQL
                String consulta = "SELECT idjugadores, id_club, nombre, apellidos, dni, edad, login, password FROM usuarios JOIN jugadores ON id_usuario = idusuarios JOIN personas ON id_persona = idpersonas WHERE tipo = 0";
                statement=connection.prepareStatement(consulta);
                
                resultados = statement.executeQuery();
                while (resultados.next()) {
                    Club club_jugador = new Club();
                    ResultSet clubes = null;
                    String club = "SELECT nombre_club, id_federacion,id_sede,id_gerente,id_entrenador FROM clubes WHERE idclubes = ?";
                    statement=connection.prepareStatement(club);
                    statement.setInt(1, resultados.getInt("id_club"));
                    
                    clubes = statement.executeQuery();
                    if(clubes.next()){                        
                        club_jugador.setNombre(clubes.getString("nombre_club"));
                        ResultSet rconsultas = null;
                        String consultas = "SELECT nombre_federacion FROM federaciones WHERE idfederaciones = ?";
                        statement=connection.prepareStatement(consultas);
                        statement.setInt(1, clubes.getInt("id_federacion"));
                        
                        rconsultas = statement.executeQuery();
                        if(rconsultas.next()){
                            Federacion federacion_club = new Federacion(rconsultas.getString("nombre_federacion"));
                            club_jugador.setFederacion(federacion_club);                            
                        }
                        
                        consultas = "SELECT nombre_sede FROM sedes WHERE idsedes = ?";
                        statement=connection.prepareStatement(consultas);
                        statement.setInt(1, clubes.getInt("id_sede"));
                        
                        rconsultas = statement.executeQuery();
                        if(rconsultas.next()){
                            Sede sede_club = new Sede(rconsultas.getString("nombre_sede"));
                            club_jugador.setSede(sede_club);                            
                        }
                        
                        consultas = "SELECT nombre,apellidos,dni,contratado FROM entrenadores JOIN personas ON id_persona = idpersonas WHERE identrenadores = ?";
                        statement=connection.prepareStatement(consultas);
                        statement.setInt(1, clubes.getInt("id_entrenador"));
                        
                        rconsultas = statement.executeQuery();
                        if(rconsultas.next()){
                            Entrenador entrenador = (Entrenador) factoria.crearPersona(rconsultas.getString("nombre"), rconsultas.getString("apellidos"), rconsultas.getString("dni"), 3);
                            entrenador.setContratado(rconsultas.getBoolean("contratado"));
                            club_jugador.setEntrenador(entrenador);
                        }
                        
                        consultas = "SELECT nombre,apellidos,dni,contratado FROM gerentes JOIN personas ON id_persona = idpersonas WHERE idgerentes = ?";
                        statement=connection.prepareStatement(consultas);
                        statement.setInt(1, clubes.getInt("id_gerente"));
                        
                        rconsultas = statement.executeQuery();
                        if(rconsultas.next()){
                            Gerente gerente = (Gerente) factoria.crearPersona(rconsultas.getString("nombre"), rconsultas.getString("apellidos"), rconsultas.getString("dni"), 2);
                            gerente.setContratado(rconsultas.getBoolean("contratado"));
                            club_jugador.setGerente(gerente);
                        }                       
                    }      
                    
                    Jugador jugador = (Jugador)factoria.crearPersona(resultados.getString("nombre"), resultados.getString("apellidos"), resultados.getString("dni"),1);
                    
                    jugador.setClub(club_jugador);
                    jugador.setEdad(resultados.getInt("edad"));
                    jugador.setLogin(resultados.getString("login"));
                    jugador.setContraseña(resultados.getString("password"));
                    jugador.setTipousuario(0);
                    jugador.setLiga(factoria.getLiga());
                    
                    ResultSet torneos = null;
                    String tconsulta = "SELECT id_torneo FROM torneo_jugador WHERE id_jugador = ?";
                    statement=connection.prepareStatement(tconsulta);
                    statement.setInt(1, resultados.getInt("idjugadores"));
                
                    torneos = statement.executeQuery();
                    while (torneos.next()) {
                        Torneo torneo = new Torneo();
                        ResultSet rconsultas = null;
                        String consultas = "SELECT nombre_torneo, inicio FROM torneos WHERE idtorneos = ?";
                        statement=connection.prepareStatement(consultas);
                        statement.setInt(1, torneos.getInt("id_torneo"));
                        
                        rconsultas = statement.executeQuery();
                        if(rconsultas.next()){                                                                 
                            torneo.setNombre(rconsultas.getString("nombre_torneo"));
                            torneo.setInicio(rconsultas.getBoolean("inicio"));                    
                        }
                        
                        jugador.addTorneo(torneo);
                            
                        }                       

                    jugadores.add(jugador);
                }
            }           
        } catch (SQLException e) { // Error al realizar la consulta
            System.out.println("Error en la petición a la BD getJugadores: " + e.getMessage());
        }
        
        conexion.desconectar();
        
        return jugadores;
    }

    public ArrayList<Gerente> getGerentes(FactoriaPersona factoria) {
        ArrayList<Gerente> gerentes = new ArrayList<Gerente>();
        Connection connection=null;
	Conexion conexion=new Conexion();
        PreparedStatement statement=null;
        ResultSet resultados = null;
        
        connection = conexion.getConnection();
        
        try {
            if (connection!=null) {
                // Consulta SQL
                String consulta = "SELECT nombre,apellidos,dni,contratado FROM gerentes JOIN personas ON id_persona = idpersonas";
                statement=connection.prepareStatement(consulta);
                
                resultados = statement.executeQuery();
                while (resultados.next()) {
                    Gerente gerente = (Gerente) factoria.crearPersona(resultados.getString("nombre"), resultados.getString("apellidos"), resultados.getString("dni"), 2);
                    gerente.setContratado(resultados.getBoolean("contratado"));
                    gerentes.add(gerente);
                }
            }
            
        }catch (SQLException e) { // Error al realizar la consulta
            System.out.println("Error en la petición a la BD");
        }
        
        conexion.desconectar();
        
        return gerentes;
    }

    public ArrayList<Entrenador> getEntrenadores(FactoriaPersona factoria) {
        ArrayList<Entrenador> entrenadores = new ArrayList<Entrenador>();
        Connection connection=null;
	Conexion conexion=new Conexion();
        PreparedStatement statement=null;
        ResultSet resultados = null;
        
        connection = conexion.getConnection();
        
        try {
            if (connection!=null) {
                // Consulta SQL
                String consulta = "SELECT nombre,apellidos,dni,contratado FROM entrenadores JOIN personas ON id_persona = idpersonas";
                statement=connection.prepareStatement(consulta);
                
                resultados = statement.executeQuery();
                while (resultados.next()) {
                    Entrenador entrenador = (Entrenador)factoria.crearPersona(resultados.getString("nombre"), resultados.getString("apellidos"), resultados.getString("dni"), 3);
                    entrenador.setContratado(resultados.getBoolean("contratado"));
                    entrenadores.add(entrenador);
                }
            }
            
        }catch (SQLException e) { // Error al realizar la consulta
            System.out.println("Error en la petición a la BD getGerentes: " + e.getMessage());
        }
        conexion.desconectar();
        
        return entrenadores;
    }

    public ArrayList<Club> getClubes(FactoriaPersona factoria) {
        ArrayList<Club> clubes = new ArrayList<Club>();
        Connection connection=null;
	Conexion conexion=new Conexion();
        PreparedStatement statement=null;
        ResultSet resultados = null;
        
        connection = conexion.getConnection();
        
        try {
            if (connection!=null) {
                // Consulta SQL
                String consulta = "SELECT idclubes, nombre_club, id_federacion, id_sede, id_gerente, id_entrenador FROM clubes";
                statement=connection.prepareStatement(consulta);
                
                resultados = statement.executeQuery();
                while (resultados.next()) {
                    Club club = new Club();                                       
                    club.setNombre(resultados.getString("nombre_club"));
                    ResultSet rconsultas = null;
                    String consultas = "SELECT nombre_federacion FROM federaciones WHERE idfederaciones = ?";
                    statement=connection.prepareStatement(consultas);
                    statement.setInt(1, resultados.getInt("id_federacion"));

                    rconsultas = statement.executeQuery();
                    if(rconsultas.next()){
                        Federacion federacion_club = new Federacion(rconsultas.getString("nombre_federacion"));
                        club.setFederacion(federacion_club);                            
                    }

                    consultas = "SELECT nombre_sede FROM sedes WHERE idsedes = ?";
                    statement=connection.prepareStatement(consultas);
                    statement.setInt(1, resultados.getInt("id_sede"));

                    rconsultas = statement.executeQuery();
                    if(rconsultas.next()){
                        Sede sede_club = new Sede(rconsultas.getString("nombre_sede"));
                        ResultSet nconsultas = null;
                        consultas = "SELECT idfranjashorarias, hora FROM franjas_horarias WHERE id_sede = ?";
                        statement=connection.prepareStatement(consultas);
                        statement.setInt(1, resultados.getInt("id_sede"));

                        nconsultas = statement.executeQuery();
                        while(nconsultas.next()){
                            FranjaHoraria franja = new FranjaHoraria(nconsultas.getString("hora"));
                            ResultSet nvconsultas = null;
                            consultas = "SELECT dnijugador, fecha FROM reservas WHERE id_franja = ?";
                            statement=connection.prepareStatement(consultas);
                            statement.setInt(1, nconsultas.getInt("idfranjashorarias"));

                            nvconsultas = statement.executeQuery();
                            while(nvconsultas.next()){
                                Reserva reserva = new Reserva(nvconsultas.getDate("fecha"), nvconsultas.getString("dnijugador"));
                                franja.addReserva(reserva);
                            }
                            sede_club.addFranja(franja);
                        }
                        
                        club.setSede(sede_club);                            
                    }

                    consultas = "SELECT nombre,apellidos,dni,contratado FROM entrenadores JOIN personas ON id_persona = idpersonas WHERE identrenadores = ?";
                    statement=connection.prepareStatement(consultas);
                    statement.setInt(1, resultados.getInt("id_entrenador"));

                    rconsultas = statement.executeQuery();
                    if(rconsultas.next()){
                        Entrenador entrenador = (Entrenador)factoria.crearPersona(rconsultas.getString("nombre"), rconsultas.getString("apellidos"), rconsultas.getString("dni"), 3);
                        entrenador.setContratado(rconsultas.getBoolean("contratado"));
                        club.setEntrenador(entrenador);
                    }

                    consultas = "SELECT nombre,apellidos,dni,contratado FROM gerentes JOIN personas ON id_persona = idpersonas WHERE idgerentes = ?";
                    statement=connection.prepareStatement(consultas);
                    statement.setInt(1, resultados.getInt("id_gerente"));

                    rconsultas = statement.executeQuery();
                    if(rconsultas.next()){
                        Gerente gerente = (Gerente) factoria.crearPersona(rconsultas.getString("nombre"), rconsultas.getString("apellidos"), rconsultas.getString("dni"), 2);
                        gerente.setContratado(rconsultas.getBoolean("contratado"));
                        club.setGerente(gerente);
                    }
                    
                    consultas = "SELECT nombre,apellidos,dni,edad,login,password FROM usuarios JOIN jugadores ON id_usuario = idusuarios JOIN personas ON id_persona = idpersonas WHERE id_club = ?";
                    statement=connection.prepareStatement(consultas);
                    statement.setInt(1, resultados.getInt("idclubes"));

                    rconsultas = statement.executeQuery();
                    while(rconsultas.next()){
                        Jugador jugador = (Jugador) factoria.crearPersona(rconsultas.getString("nombre"), rconsultas.getString("apellidos"), rconsultas.getString("dni"), 1);
                        jugador.setClub(club);
                        jugador.setEdad(rconsultas.getInt("edad"));
                        jugador.setLogin(rconsultas.getString("login"));
                        jugador.setContraseña(rconsultas.getString("password"));
                        
                        club.addJugador(jugador);
                    }
                    
                    clubes.add(club);
                }
            }
            
        }catch (SQLException e) { // Error al realizar la consulta
            System.out.println("Error en la petición a la BD getClubes: " + e.getMessage());
        }
        conexion.desconectar();
        
        return clubes;
    }

    public ArrayList<Torneo> getTorneos(FactoriaPersona factoria) {
        ArrayList<Torneo> torneos = new ArrayList<Torneo>();
        Connection connection=null;
	Conexion conexion=new Conexion();
        PreparedStatement statement=null;
        ResultSet resultados = null;
        
        connection = conexion.getConnection();
        
        try {
            if (connection!=null) {
                // Consulta SQL
                String consulta = "SELECT idtorneos, nombre_torneo, inicio FROM torneos";
                statement=connection.prepareStatement(consulta);
                
                resultados = statement.executeQuery();
                while (resultados.next()) {
                    Torneo torneo = new Torneo();                                       
                    torneo.setNombre(resultados.getString("nombre_torneo"));
                    torneo.setInicio(resultados.getBoolean("inicio"));
                    
                    ResultSet rconsultas = null;
                    String consultas = "SELECT id_club FROM torneo_club WHERE id_torneo = ?";
                    statement=connection.prepareStatement(consultas);
                    statement.setInt(1, resultados.getInt("idtorneos"));

                    rconsultas = statement.executeQuery();
                    while(rconsultas.next()){                        
                        ResultSet clubconsultas = null;
                        String clubes = "SELECT idclubes,nombre_club, id_federacion,id_sede,id_gerente,id_entrenador FROM clubes WHERE idclubes = ?";
                        statement=connection.prepareStatement(clubes);
                        statement.setInt(1, rconsultas.getInt("id_club"));
                        
                        clubconsultas = statement.executeQuery();
                        if (clubconsultas.next()) {
                            Club club = new Club();                                       
                            club.setNombre(clubconsultas.getString("nombre_club"));
                            ResultSet tcconsultas = null;
                            String nconsultas = "SELECT nombre_federacion FROM federaciones WHERE idfederaciones = ?";
                            statement=connection.prepareStatement(nconsultas);
                            statement.setInt(1, clubconsultas.getInt("id_federacion"));

                            tcconsultas = statement.executeQuery();
                            if(tcconsultas.next()){
                                Federacion federacion_club = new Federacion(tcconsultas.getString("nombre_federacion"));
                                club.setFederacion(federacion_club);                            
                            }

                            nconsultas = "SELECT nombre_sede FROM sedes WHERE idsedes = ?";
                            statement=connection.prepareStatement(nconsultas);
                            statement.setInt(1, clubconsultas.getInt("id_sede"));

                            tcconsultas = statement.executeQuery();
                            if(tcconsultas.next()){
                                Sede sede_club = new Sede(tcconsultas.getString("nombre_sede"));
                                club.setSede(sede_club);                            
                            }

                            nconsultas = "SELECT nombre,apellidos,dni,contratado FROM entrenadores JOIN personas ON id_persona = idpersonas WHERE identrenadores = ?";
                            statement=connection.prepareStatement(nconsultas);
                            statement.setInt(1, clubconsultas.getInt("id_entrenador"));

                            tcconsultas = statement.executeQuery();
                            if(tcconsultas.next()){
                                Entrenador entrenador = (Entrenador) factoria.crearPersona(tcconsultas.getString("nombre"), tcconsultas.getString("apellidos"), tcconsultas.getString("dni"), 3);
                                entrenador.setContratado(tcconsultas.getBoolean("contratado"));
                                club.setEntrenador(entrenador);
                            }

                            nconsultas = "SELECT nombre,apellidos,dni,contratado FROM gerentes JOIN personas ON id_persona = idpersonas WHERE idgerentes = ?";
                            statement=connection.prepareStatement(nconsultas);
                            statement.setInt(1, clubconsultas.getInt("id_gerente"));

                            tcconsultas = statement.executeQuery();
                            if(tcconsultas.next()){
                                Gerente gerente = (Gerente) factoria.crearPersona(tcconsultas.getString("nombre"), tcconsultas.getString("apellidos"), tcconsultas.getString("dni"), 2);
                                gerente.setContratado(tcconsultas.getBoolean("contratado"));
                                club.setGerente(gerente);
                            }

                            nconsultas = "SELECT nombre,apellidos,dni,edad,login,password FROM usuarios JOIN jugadores ON id_usuario = idusuarios JOIN personas ON id_persona = idpersonas WHERE id_club = ?";
                            statement=connection.prepareStatement(nconsultas);
                            statement.setInt(1, clubconsultas.getInt("idclubes"));

                            tcconsultas = statement.executeQuery();
                            while(tcconsultas.next()){
                                Jugador jugador = (Jugador) factoria.crearPersona(tcconsultas.getString("nombre"), tcconsultas.getString("apellidos"), tcconsultas.getString("dni"), 1);
                                jugador.setClub(club);
                                jugador.setEdad(tcconsultas.getInt("edad"));
                                jugador.setLogin(tcconsultas.getString("login"));
                                jugador.setContraseña(tcconsultas.getString("password"));

                                club.addJugador(jugador);
                            }

                            torneo.addClub(club);                         
                        }
                    }                    
                    
                    consultas = "SELECT id_jugador FROM torneo_jugador WHERE id_torneo = ?";
                    statement=connection.prepareStatement(consultas);
                    statement.setInt(1, resultados.getInt("idtorneos"));

                    rconsultas = statement.executeQuery();
                    while(rconsultas.next()){
                        ResultSet jresultados = null;
                        String cjugador = "SELECT id_club, nombre, apellidos, dni, edad, login, password FROM usuarios JOIN jugadores ON id_usuario = idusuarios JOIN personas ON id_persona = idpersonas WHERE idjugadores = ?";
                        statement=connection.prepareStatement(cjugador);
                        statement.setInt(1, rconsultas.getInt("id_jugador"));
                
                        jresultados = statement.executeQuery();
                        if (jresultados.next()) {
                            Club club_jugador = new Club();
                            ResultSet clubes = null;
                            String club = "SELECT nombre_club, id_federacion,id_sede,id_gerente,id_entrenador FROM clubes WHERE idclubes = ?";
                            statement=connection.prepareStatement(club);
                            statement.setInt(1, jresultados.getInt("id_club"));

                            clubes = statement.executeQuery();
                            if(clubes.next()){                        
                                club_jugador.setNombre(clubes.getString("nombre_club"));
                                ResultSet ncconsultas = null;
                                String nconsultas = "SELECT nombre_federacion FROM federaciones WHERE idfederaciones = ?";
                                statement=connection.prepareStatement(nconsultas);
                                statement.setInt(1, clubes.getInt("id_federacion"));

                                ncconsultas = statement.executeQuery();
                                if(ncconsultas.next()){
                                    Federacion federacion_club = new Federacion(ncconsultas.getString("nombre_federacion"));
                                    club_jugador.setFederacion(federacion_club);                            
                                }

                                nconsultas = "SELECT nombre_sede FROM sedes WHERE idsedes = ?";
                                statement=connection.prepareStatement(nconsultas);
                                statement.setInt(1, clubes.getInt("id_sede"));

                                ncconsultas = statement.executeQuery();
                                if(ncconsultas.next()){
                                    Sede sede_club = new Sede(ncconsultas.getString("nombre_sede"));
                                    club_jugador.setSede(sede_club);                            
                                }

                                nconsultas = "SELECT nombre,apellidos,dni,contratado FROM entrenadores JOIN personas ON id_persona = idpersonas WHERE identrenadores = ?";
                                statement=connection.prepareStatement(nconsultas);
                                statement.setInt(1, clubes.getInt("id_entrenador"));

                                ncconsultas = statement.executeQuery();
                                if(ncconsultas.next()){
                                    Entrenador entrenador = (Entrenador) factoria.crearPersona(ncconsultas.getString("nombre"), ncconsultas.getString("apellidos"), ncconsultas.getString("dni"), 3);
                                    entrenador.setContratado(ncconsultas.getBoolean("contratado"));
                                    club_jugador.setEntrenador(entrenador);
                                }

                                nconsultas = "SELECT nombre,apellidos,dni,contratado FROM gerentes JOIN personas ON id_persona = idpersonas WHERE idgerentes = ?";
                                statement=connection.prepareStatement(nconsultas);
                                statement.setInt(1, clubes.getInt("id_gerente"));

                                ncconsultas = statement.executeQuery();
                                if(ncconsultas.next()){
                                    Gerente gerente = (Gerente) factoria.crearPersona(ncconsultas.getString("nombre"), ncconsultas.getString("apellidos"), ncconsultas.getString("dni"), 2);
                                    gerente.setContratado(ncconsultas.getBoolean("contratado"));
                                    club_jugador.setGerente(gerente);
                                }                       
                            }
                            Jugador jugador = (Jugador) factoria.crearPersona(jresultados.getString("nombre"), jresultados.getString("apellidos"), jresultados.getString("dni"), 1);
                            jugador.setClub(club_jugador);
                            jugador.setEdad(jresultados.getInt("edad"));
                            jugador.setLogin(jresultados.getString("login"));
                            jugador.setContraseña(jresultados.getString("password"));

                            torneo.addJugador(jugador);
                        }                        
                    }
                    torneos.add(torneo);
                }
            }
            
        }catch (SQLException e) { // Error al realizar la consulta
            System.out.println("Error en la petición a la BD getTorneos: " + e.getMessage());
        }
        conexion.desconectar();
        
        return torneos;
    }

    public boolean registrarJugador(Jugador jugador) {
        boolean hecho = false;
        Connection connection=null;
	Conexion conexion=new Conexion();
        PreparedStatement statement=null;
        ResultSet resultados = null;
        
        connection = conexion.getConnection();
        
        try {                   
            if (connection!=null) {
                String registropersona = "insert into personas(nombre, apellidos, dni) values (?,?,?)";
                statement=connection.prepareStatement(registropersona);
                statement.setString(1, jugador.getNombre());
                statement.setString(2, jugador.getApellidos());
                statement.setString(3, jugador.getDNI());
                
                if (statement.executeUpdate() > 0) {
                    String consulta = "SELECT idpersonas FROM personas WHERE dni = ?";
                    statement=connection.prepareStatement(consulta);
                    statement.setString(1, jugador.getDNI());
                    resultados = statement.executeQuery();
                    if(resultados.next()){
                        int idpersona = resultados.getInt(1);
                        String registrousuario = "insert into usuarios(login,password,tipo,id_persona) values (?,?,?,?)";
                        statement=connection.prepareStatement(registrousuario);
                        statement.setString(1, jugador.getLogin());
                        statement.setString(2, jugador.getPassword());
                        statement.setInt(3, jugador.getTipo());
                        statement.setInt(4, idpersona);
                        if(statement.executeUpdate() > 0){
                            String consulta2 = "SELECT idclubes FROM clubes WHERE nombre_club = ?";
                            statement=connection.prepareStatement(consulta2);
                            statement.setString(1, jugador.getClub().getNombre());
                            resultados = statement.executeQuery();
                            if(resultados.next()){
                                int idclub = resultados.getInt(1);
                                String consulta3 = "SELECT idusuarios FROM usuarios WHERE id_persona = ?";
                                statement=connection.prepareStatement(consulta3);
                                statement.setInt(1, idpersona);
                                resultados = statement.executeQuery();
                                if(resultados.next()){
                                    int idusuario = resultados.getInt(1);
                                    String registrojugador = "insert into jugadores(edad,id_club,id_usuario) values (?,?,?)";
                                    statement=connection.prepareStatement(registrojugador);
                                    statement.setInt(1, jugador.getEdad());
                                    statement.setInt(2, idclub);
                                    statement.setInt(3, idusuario);
                                    if(statement.executeUpdate() > 0){
                                        hecho = true;
                                    }
                                }                            
                            }
                        }         
                    }   
                }
            }
        } catch (SQLException e) { // Error al realizar la consulta
            System.out.println("Error en la petición a la BD: " + e.getMessage());
        }finally{
        try {
                 if(statement!=null)
                     statement.close();             
                 if(connection!=null)
                     connection.close();
                 conexion.desconectar();
             } catch (SQLException ex) {
                 System.err.println( ex.getMessage() );    
             }
                
        }
        
        return hecho;
    }

    public boolean registrarTorneo(Torneo torneo) {
        boolean hecho = false;
        Connection connection=null;
	Conexion conexion=new Conexion();
        PreparedStatement statement=null;
        ResultSet resultados = null;
        
        connection = conexion.getConnection();
        
        try {                   
            if (connection!=null) {
                String registrotorneo = "insert into torneos(nombre_torneo, inicio) values (?,?)";
                statement=connection.prepareStatement(registrotorneo);
                statement.setString(1, torneo.getNombre());
                statement.setBoolean(2, torneo.isInicio());
                
                if(statement.executeUpdate() > 0){
                    String consulta = "SELECT count(*) FROM torneos";
                    statement=connection.prepareStatement(consulta);
                    resultados = statement.executeQuery();
                    if(resultados.next()){
                        int idtorneo = resultados.getInt(1);
                        for(int i = 0; i<torneo.getClubes().size();i++){
                            String consulta2 = "SELECT idclubes FROM clubes WHERE nombre_club = ?";
                            statement=connection.prepareStatement(consulta2);
                            statement.setString(1, torneo.getClubes().get(i).getNombre());
                            resultados = statement.executeQuery();
                            if(resultados.next()){
                                int idclub = resultados.getInt(1);
                                String registrotorneo_club = "insert into torneo_club(id_club,id_torneo) values (?,?)";
                                statement=connection.prepareStatement(registrotorneo_club);
                                statement.setInt(1, idclub);
                                statement.setInt(2, idtorneo);
                                if(statement.executeUpdate() > 0){
                                    hecho = true;
                                    System.out.println(torneo + ": "+ torneo.getClubes().get(i).toString());
                                }
                            }
                        }
                    }
                }
            }
         } catch (SQLException e) { // Error al realizar la consulta
            System.out.println("Error en la petición a la BD: " + e.getMessage());
        }finally{
        try {
                 if(statement!=null)
                     statement.close();             
                 if(connection!=null)
                     connection.close();
                 conexion.desconectar();
             } catch (SQLException ex) {
                 System.err.println( ex.getMessage() );    
             }
                
        }
        
        return hecho;
    }

    public boolean registrarClub(Club club) {
        boolean hecho = false;
        Connection connection=null;
	Conexion conexion=new Conexion();
        PreparedStatement statement=null;
        ResultSet resultados = null;
        connection = conexion.getConnection();
        
        try {            
            if (connection!=null) {
                String registrosede = "insert into sedes(nombre_sede) values (?)";
                statement=connection.prepareStatement(registrosede);
                statement.setString(1, club.getSede().getNombre());
                System.out.println("insertar sede");
                if(statement.executeUpdate() > 0){
                    System.out.println("buscar sede");
                    String consulta = "SELECT idsedes FROM sedes WHERE nombre_sede = ?";                    
                    statement=connection.prepareStatement(consulta);
                    statement.setString(1, club.getSede().getNombre());
                    resultados = statement.executeQuery();
                    
                    if(resultados.next()){
                        int idsede = resultados.getInt(1);
                        ArrayList<FranjaHoraria> franja = club.getSede().getFranjaHoraria();
                        System.out.println("Franja tamaño: " + franja.size());
                        for(int i = 0;i<franja.size();i++ ){
                            String registrofranjas = "insert into franjas_horarias(hora, id_sede) values (?,?)";
                            statement=connection.prepareStatement(registrofranjas);
                            statement.setString(1, franja.get(i).getHora());
                            statement.setInt(2, idsede);
                            if(statement.executeUpdate() > 0){
                                System.out.println("Franja creada");
                            }
                        }
                        System.out.println("buscar federacion");
                        String consulta2 = "SELECT idfederaciones FROM federaciones WHERE nombre_federacion = ?";
                        statement=connection.prepareStatement(consulta2);
                        statement.setString(1, club.getFederacion().getNombre());
                        resultados = statement.executeQuery();
                        
                        if(resultados.next()){
                            int idfederacion = resultados.getInt(1);
                            String consulta3 = "SELECT idgerentes FROM gerentes JOIN personas ON id_persona = idpersonas WHERE dni = ?";
                            statement=connection.prepareStatement(consulta3);
                            statement.setString(1, club.getGerente().getDNI());
                            resultados = statement.executeQuery();
                            System.out.println("buscar gerente");
                            if(resultados.next()){
                                int idgerente = resultados.getInt(1);
                                String contratogerente = "UPDATE gerentes SET contratado = ? WHERE idgerentes = ?";
                                statement=connection.prepareStatement(contratogerente);
                                statement.setBoolean(1, club.getGerente().isContratado());
                                statement.setInt(2, idgerente);
                                System.out.println("contrado gerente");
                                if(statement.executeUpdate() > 0){
                                    String consulta4 = "SELECT identrenadores FROM entrenadores JOIN personas ON id_persona = idpersonas WHERE dni = ?";
                                    statement=connection.prepareStatement(consulta4);
                                    statement.setString(1, club.getEntrenador().getDNI());
                                    resultados = statement.executeQuery();
                                    if(resultados.next()){
                                        int identrenador = resultados.getInt(1);
                                        String contratoentrenador = "UPDATE entrenadores SET contratado = ? WHERE identrenadores = ?";
                                        statement=connection.prepareStatement(contratoentrenador);
                                        statement.setBoolean(1, club.getEntrenador().isContratado());
                                        statement.setInt(2, identrenador);

                                        if(statement.executeUpdate() > 0){
                                            String registroclub = "insert into clubes(nombre_club, id_federacion, id_sede, id_gerente, id_entrenador) values (?,?,?,?,?)";
                                            statement=connection.prepareStatement(registroclub);
                                            statement.setString(1, club.getNombre());
                                            statement.setInt(2, idfederacion);
                                            statement.setInt(3, idsede);
                                            statement.setInt(4, idgerente);
                                            statement.setInt(5, identrenador);

                                            if(statement.executeUpdate() > 0){
                                                hecho = true;
                                                System.out.println(club);
                                            }
                                        }
                                    }
                                }                                
                            }
                        }
                    }
                }
            }
        }catch (SQLException e) { // Error al realizar la consulta
            System.out.println("Error en la petición a la BD: " + e.getMessage());
            
        }finally{
        try {
                 if(statement!=null)
                     statement.close();             
                 if(connection!=null)
                     connection.close();
                 conexion.desconectar();
             } catch (SQLException ex) {
                 System.err.println( ex.getMessage() );    
             }
                
        }
        return hecho;
    }

    public boolean registrarJugadorTorneo(Jugador jugador, Torneo torneo) {
        boolean hecho = false;
        Connection connection=null;
	Conexion conexion=new Conexion();
        PreparedStatement statement=null;
        ResultSet resultados = null;
        
        connection = conexion.getConnection();
        
        try {                   
            if (connection!=null) {
                String consulta = "SELECT idtorneos FROM torneos WHERE nombre_torneo = ?";
                statement=connection.prepareStatement(consulta);
                statement.setString(1, torneo.getNombre());
                resultados = statement.executeQuery();
                
                if(resultados.next()){
                    int idtorneo = resultados.getInt(1);
                    String contratoentrenador = "SELECT idjugadores FROM usuarios u JOIN jugadores j ON j.id_usuario = u.idusuarios JOIN personas p ON u.id_persona = p.idpersonas WHERE dni = ? ";
                    statement=connection.prepareStatement(contratoentrenador);
                    statement.setString(1, jugador.getDNI());
                    
                    resultados = statement.executeQuery();
                    if(resultados.next()){
                        int idjugador = resultados.getInt(1);
                        String registrojugador_torneo = "insert into torneo_jugador(id_torneo, id_jugador) values (?,?)";
                        statement=connection.prepareStatement(registrojugador_torneo);
                        statement.setInt(1, idtorneo);
                        statement.setInt(2, idjugador);

                        if(statement.executeUpdate() > 0){
                            hecho = true;
                            System.out.println(torneo + ": " + jugador );
                        }
                    }
                }
            }
        }catch (SQLException e) { // Error al realizar la consulta
            System.out.println("Error en la petición a la BD: " + e.getMessage());
        }finally{
        try {
                 if(statement!=null)
                     statement.close();             
                 if(connection!=null)
                     connection.close();
                 conexion.desconectar();
             } catch (SQLException ex) {
                 System.err.println( ex.getMessage() );    
             }
                
        }
        
        return hecho;
    }
}

    

