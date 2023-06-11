package Daos;

import Beans.Estadio;
import Beans.Seleccion;
import java.sql.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class SeleccionDao extends BaseDao{
    public ArrayList<Seleccion> listarSelecciones() {
        ArrayList<Seleccion> listaSelecciones = new ArrayList<>();

        try (Connection conn = this.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT *" +
                     "FROM (" +
                     "    SELECT s.idSeleccion, s.nombre, s.tecnico, e.nombre AS estadio, MIN(p.fecha) AS fecha," +
                     "           CONCAT(sl.nombre, ' vs ', sv.nombre) AS primer_partido," +
                     "           ROW_NUMBER() OVER (PARTITION BY s.idSeleccion ORDER BY MIN(p.fecha)) AS row_num" +
                     "    FROM seleccion s" +
                     "    INNER JOIN estadio e ON s.estadio_idEstadio = e.idEstadio" +
                     "    LEFT JOIN partido p ON s.idSeleccion = p.seleccionLocal OR s.idSeleccion = p.seleccionVisitante" +
                     "    LEFT JOIN seleccion sl ON p.seleccionLocal = sl.idSeleccion" +
                     "    LEFT JOIN seleccion sv ON p.seleccionVisitante = sv.idSeleccion" +
                     "    GROUP BY s.idSeleccion, s.nombre, s.tecnico, e.nombre, primer_partido" +
                     ") AS subquery" +
                     "WHERE row_num = 1" +
                     "ORDER BY fecha");) {

            while (rs.next()) {
                Seleccion seleccion = new Seleccion();

                seleccion.setIdSeleccion(rs.getInt(1));
                seleccion.setNombre(rs.getString(2));
                seleccion.setTecnico(rs.getString(3));

                Estadio estadio = new Estadio();
                estadio.setIdEstadio(rs.getInt("e.idEstadio"));
                estadio.setNombre(rs.getString("nombre"));
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
