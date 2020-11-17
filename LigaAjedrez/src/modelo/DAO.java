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
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author angel
 */
public class DAO implements Serializable{

    private static final long serialVersionUID = 1L;
    public Usuario buscarUsuario(String user){
        Connection connection=null;
	Conexion conexion=new Conexion();
        PreparedStatement statement=null;
        ResultSet resultados = null;
        Usuario usuario = new Usuario();
        // Consulta SQL
        String consulta = "SELECT login, password, tipo, nombre, apellidos, dni FROM usuarios u JOIN personas p ON u.id_persona = p.idpersonas WHERE u.login = ? ";
        
        connection = conexion.getConnection();
        
        try {
            
                    
            if (connection!=null) {
                statement=connection.prepareStatement(consulta);
                statement.setString(1, user);               
                
                resultados = statement.executeQuery();
                while (resultados.next()) {
                    switch(resultados.getInt("tipo")){
                        case 0:
                            usuario = new Jugador();
                            break;
                        case 1:
                            usuario = new Administrador();
                            break;
                    }
                    usuario.setLogin(resultados.getString("login"));
                    usuario.setContraseña(resultados.getString("password"));
                    usuario.setTipousuario(resultados.getInt("tipo"));
                    usuario.setNombre(resultados.getString("nombre"));
                    usuario.setApellidos(resultados.getString("apellidos"));
                    usuario.setDni(resultados.getString("dni"));
                }
                System.out.println(usuario);
            }
        } catch (SQLException e) { // Error al realizar la consulta
            System.out.println("Error en la petición a la BD");
        }
        
        conexion.desconectar();
        
        return usuario;
    }

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
                    String consulta = "SELECT count(*) FROM personas";
                    statement=connection.prepareStatement(consulta);
                    resultados = statement.executeQuery();
                    if(resultados.next()){
                        int i = resultados.getInt(1);
                        String registroentrenador = "insert into entrenadores(contratado,id_persona) values (?,?)";
                        statement=connection.prepareStatement(registroentrenador);
                        statement.setBoolean(1, entr.isContratado());
                        statement.setInt(2, i);
                        if(statement.executeUpdate() > 0){
                            hecho = true;
                            System.out.println(entr);
                        }
                    }         
                }
            }
        } catch (SQLException e) { // Error al realizar la consulta
            System.out.println("Error en la petición a la BD");
        }       
        
        conexion.desconectar();
        
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
                    String consulta = "SELECT count(*) FROM personas";
                    statement=connection.prepareStatement(consulta);
                    resultados = statement.executeQuery();
                    if(resultados.next()){
                        int i = resultados.getInt(1);
                        String registroentrenador = "insert into gerente(contratado,id_persona) values (?,?)";
                        statement=connection.prepareStatement(registroentrenador);
                        statement.setBoolean(1, ger.isContratado());
                        statement.setInt(2, i);
                        if(statement.executeUpdate() > 0){
                            hecho = true;
                            System.out.println(ger);
                        }
                    }         
                }
            }
        } catch (SQLException e) { // Error al realizar la consulta
            System.out.println("Error en la petición a la BD");
        }       
        
        conexion.desconectar();
        
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
                    System.out.println(fede);
                }
            }
        } catch (SQLException e) { // Error al realizar la consulta
            System.out.println("Error en la petición a la BD");
        }
        
        conexion.desconectar();
        
        return hecho;
        
       }

    public ArrayList<Federacion> getFederaciones() {
        ArrayList<Federacion> federaciones = new ArrayList<Federacion>();
        Connection connection=null;
	Conexion conexion=new Conexion();
        PreparedStatement statement=null;
        ResultSet resultados = null;
        
        connection = conexion.getConnection();
        
        try {
            if (connection!=null) {
                // Consulta SQL
                String consulta = "SELECT nombre_federacion FROM federaciones ";
                statement=connection.prepareStatement(consulta);           
                
                resultados = statement.executeQuery();
                while (resultados.next()) {
                        Federacion fede = new Federacion(resultados.getString("nombre_federacion"));
                        if(federaciones.add(fede));
                            System.out.println(fede);
                    }
                }           
        } catch (SQLException e) { // Error al realizar la consulta
            System.out.println("Error en la petición a la BD");
        }
        
        conexion.desconectar();
        
        return federaciones;
    }

    public int buscarJugador(String dniJugador) {
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
    }

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

    public int buscarClubJugador(String dniJugador) {
        int idclub = -1;
        Connection connection=null;
	Conexion conexion=new Conexion();
        PreparedStatement statement=null;
        ResultSet resultados = null;
        
        connection = conexion.getConnection();
        
        try {
            if (connection!=null) {
                // Consulta SQL
                String consulta = "SELECT id_club FROM usuarios u JOIN jugadores j ON j.id_usuario = u.idusuarios JOIN personas p ON u.id_persona = p.idpersonas WHERE dni = ? ";
                statement=connection.prepareStatement(consulta);
                statement.setString(1, dniJugador);
                
                resultados = statement.executeQuery();
                if(resultados.next()) {
                    idclub = resultados.getInt("id_club");
                }
            }           
        } catch (SQLException e) { // Error al realizar la consulta
            System.out.println("Error en la petición a la BD");
        }
        
        conexion.desconectar();
        
        return idclub;
    }

    public ArrayList<Torneo> buscarTorneosClub(int idclub) {
        ArrayList<Torneo> torneos = new ArrayList<Torneo>();
        Connection connection=null;
	Conexion conexion=new Conexion();
        PreparedStatement statement=null;
        ResultSet resultados = null;
        
        connection = conexion.getConnection();
        
        try {
            if (connection!=null) {
                // Consulta SQL
                String consulta = "SELECT nombre_torneo, inicio FROM torneos t JOIN torneo_club tc ON tc.id_torneo = t.idtorneos WHERE tc.id_club = ? AND t.inicio = false ";
                statement=connection.prepareStatement(consulta);               
                statement.setInt(1, idclub);
                
                resultados = statement.executeQuery();
                while (resultados.next()) {
                        Torneo torneo = new Torneo();
                        torneo.setNombre(resultados.getString("nombre_torneo"));
                        torneo.setInicio(resultados.getBoolean("inicio"));
                        torneos.add(torneo);
                    }
                }           
        } catch (SQLException e) { // Error al realizar la consulta
            System.out.println("Error en la petición a la BD");
        }
        
        conexion.desconectar();
        
        return torneos;
    }

    public ArrayList<Torneo> buscarTorneoDisponibleJugador(int idclub, ArrayList<Integer> idtorneos) {
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
    }

    public ArrayList<Club> buscarClubes(String federacion) {
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
    }
}
