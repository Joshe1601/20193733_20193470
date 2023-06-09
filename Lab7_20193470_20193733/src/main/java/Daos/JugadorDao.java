package Daos;

import Beans.Jugador;

import java.sql.*;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;

public class JugadorDao {
    public ArrayList<Jugador> listarJugadores() {

        ArrayList<Jugador> listaJugadores = new ArrayList<>();

        String sql = "SELECT j.idJugador as 'ID', j.nombre, j.edad, j.posicion, j.club, s.nombre as 'nombre de seleccion' FROM jugador j JOIN seleccion s ON (j.sn_idSeleccion = s.idSeleccion)";

        //no entiendo bien xq getConnection
        String url = "jdbc:mysql://localhost:3306/mydb";
        try (Connection conn = DriverManager.getConnection(url, "root", "root");
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                //Jugador jugador = fetchJugadorData(rs);
                //listaJugadores.add(jugador);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return listaJugadores;
    }

    public void crearJugador(Jugador jugador) {

        String sql = "INSERT INTO jugador (nombre, edad, posicion, club, sn_idSelecciom) VALUES (?,?,?,?,?)";
        //de nuevo no entiendo bien el getConnection
        //Connection conn = getConnection();
        String url = "jdbc:mysql://localhost:3306/mydb";
        try (Connection conn = DriverManager.getConnection(url, "root", "root");
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
