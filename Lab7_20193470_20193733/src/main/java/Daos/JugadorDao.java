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

        String sql = "SELECT * FROM jugador j LEFT JOIN seleccion s ON (j.sn_idSeleccion = s.idSeleccion)";

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
                seleccion.setIdSeleccion(rs.getInt("s.idSeleccion"));
                seleccion.setNombre(rs.getString("nombre"));
                seleccion.setTecnico(rs.getString("tecnico"));
                jugador.setSeleccion(seleccion);

                listaJugadores.add(jugador);

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return listaJugadores;
    }

    public void crearJugador(Jugador jugador) {

        String sql = "INSERT INTO jugador (nombre, edad, posicion, club, sn_idSelecciom) VALUES (?,?,?,?,?)";
        //de nuevo no entiendo bien el getConnection
        //OKI arreglado :)

        try (Connection conn = this.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            //setJugadorData(jugador, pstmt);

            pstmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    //esatblecer fetch???
    //lo mismo con setJugadorData
}
