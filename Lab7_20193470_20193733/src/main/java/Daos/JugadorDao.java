package Daos;

import Beans.Estadio;
import Beans.Jugador;
import Beans.Seleccion;

import java.sql.*;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;

public class JugadorDao extends BaseDao{
    public ArrayList<Jugador> listarJugadores() {

        ArrayList<Jugador> listaJugadores = new ArrayList<>();

        String sql = "SELECT * FROM jugador LEFT JOIN seleccion ON jugador.sn_idSeleccion = seleccion.idSeleccion";

        //no entiendo bien xq getConnection
        //Tranquila ya lo arreglé :)

        try (Connection conn = this.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Jugador jugador = new Jugador();
                jugador.setIdJugador(rs.getInt(1));
                jugador.setNombre(rs.getString(2));
                jugador.setEdad(rs.getInt(3));
                jugador.setPosicion(rs.getString(4));
                jugador.setClub(rs.getString(5));

                Seleccion seleccion = new Seleccion();
                seleccion.setIdSeleccion(rs.getInt("seleccion.idSeleccion"));
                seleccion.setNombre(rs.getString("seleccion.nombre"));
                seleccion.setTecnico(rs.getString("seleccion.tecnico"));
                jugador.setSeleccion(seleccion);

                listaJugadores.add(jugador);

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return listaJugadores;
    }

    public Jugador obtenerJugador(String nombre){

        Jugador jugador = null;

        String sql = "SELECT * FROM jugador LEFT JOIN seleccion ON jugador.sn_idSeleccion = seleccion.idSeleccion WHERE jugador.nombre = ?";

        try (Connection conn = this.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);) {

            pstmt.setString(1, nombre);
            ResultSet rs = pstmt.executeQuery();

            if(rs.next()){
                jugador = new Jugador();
                jugador.setIdJugador(rs.getInt(1));
                jugador.setNombre(rs.getString(2));
                jugador.setEdad(rs.getInt(3));
                jugador.setPosicion(rs.getString(4));
                jugador.setClub(rs.getString(5));

                Seleccion seleccion = new Seleccion();
                seleccion.setIdSeleccion(rs.getInt("seleccion.idSeleccion"));
                seleccion.setNombre(rs.getString("seleccion.nombre"));
                seleccion.setTecnico(rs.getString("seleccion.tecnico"));
                jugador.setSeleccion(seleccion);

            }



        }catch (SQLException ex) {
            ex.printStackTrace();
        }

        return jugador;
    }

    public void crearJugador(Jugador jugador) {

        String sql = "INSERT INTO jugador (nombre, edad, posicion, club, sn_idSeleccion)"+" VALUES (?,?,?,?,?);";
        //de nuevo no entiendo bien el getConnection
        //OKI arreglado :)

        try (Connection conn = this.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            //setJugadorData(jugador, pstmt);
            pstmt.setString(1, jugador.getNombre());
            pstmt.setInt(2, jugador.getEdad());
            pstmt.setString(3, jugador.getPosicion());
            pstmt.setString(4, jugador.getClub());
            pstmt.setInt(5, jugador.getSeleccion().getIdSeleccion());


            //Vamo a intentarlo ya ps

            pstmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    //esatblecer fetch???
    // By yo: Qué es un fetch o.O
    //lo mismo con setJugadorData
    //By yo: ????
}
