package Daos;

import Beans.Estadio;
import Beans.Seleccion;
import java.sql.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class SeleccionDao extends BaseDao{
    public ArrayList<Seleccion> obtenerListaSelecciones() {
        ArrayList<Seleccion> listaSelecciones = new ArrayList<>();

        String sql = "SELECT * FROM seleccion LEFT JOIN estadio ON seleccion.estadio_idEstadio = estadio.idEstadio";

        try (Connection conn = this.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql);) {

            while (rs.next()) {
                Seleccion seleccion = new Seleccion();

                seleccion.setIdSeleccion(rs.getInt(1));
                seleccion.setNombre(rs.getString(2));
                seleccion.setTecnico(rs.getString(3));

                Estadio estadio = new Estadio();
                estadio.setIdEstadio(rs.getInt("estadio.idEstadio"));
                estadio.setNombre(rs.getString("estadio.nombre"));
                estadio.setProvincia(rs.getString("estadio.provincia"));
                seleccion.setEstadio(estadio);

                listaSelecciones.add(seleccion);
            }
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listaSelecciones;
    }

    public ArrayList<Seleccion> listarSelecciones() {
        ArrayList<Seleccion> listaSelecciones = new ArrayList<>();

        String sql = "SELECT s.idSeleccion, s.nombre, s.tecnico, e.nombre AS estadio, CONCAT(sl.nombre, ' vs ', sv.nombre) AS primer_partido\n" +
                "FROM seleccion s\n" +
                "JOIN estadio e ON s.estadio_idEstadio = e.idEstadio\n" +
                "LEFT JOIN partido p ON s.idSeleccion = p.seleccionLocal OR s.idSeleccion = p.seleccionVisitante\n" +
                "LEFT JOIN seleccion sl ON p.seleccionLocal = sl.idSeleccion\n" +
                "LEFT JOIN seleccion sv ON p.seleccionVisitante = sv.idSeleccion\n" +
                "WHERE p.idPartido IS NOT NULL\n" +
                "GROUP BY s.idSeleccion, s.nombre, s.tecnico, e.nombre, primer_partido\n" +
                "ORDER BY MIN(p.fecha);";




        try (Connection conn = this.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql);){

            while (rs.next()) {
                Seleccion seleccion = new Seleccion();

                seleccion.setIdSeleccion(rs.getInt(1));
                seleccion.setNombre(rs.getString(2));
                seleccion.setTecnico(rs.getString(3));

                Estadio estadio = new Estadio();
                estadio.setIdEstadio(rs.getInt("e.idEstadio"));
                estadio.setNombre(rs.getString("estadio"));
                estadio.setProvincia(rs.getString("provincia"));
                seleccion.setEstadio(estadio);

                seleccion.setPrimerPartido(rs.getString(5));

                listaSelecciones.add(seleccion);
            }
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listaSelecciones;
    }

}
