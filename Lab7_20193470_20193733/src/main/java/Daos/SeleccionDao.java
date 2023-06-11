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

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT idSeleccion, nombre, tecnico, estadio, fecha, primer_partido\n" +
                     "FROM (\n" +
                     "    SELECT s.idSeleccion, s.nombre, s.tecnico, e.nombre AS estadio, MIN(p.fecha) AS fecha,\n" +
                     "           CONCAT(sl.nombre, ' vs ', sv.nombre) AS primer_partido,\n" +
                     "           ROW_NUMBER() OVER (PARTITION BY s.idSeleccion ORDER BY MIN(p.fecha)) AS row_num\n" +
                     "    FROM seleccion s\n" +
                     "    INNER JOIN estadio e ON s.estadio_idEstadio = e.idEstadio\n" +
                     "    LEFT JOIN partido p ON s.idSeleccion = p.seleccionLocal OR s.idSeleccion = p.seleccionVisitante\n" +
                     "    LEFT JOIN seleccion sl ON p.seleccionLocal = sl.idSeleccion\n" +
                     "    LEFT JOIN seleccion sv ON p.seleccionVisitante = sv.idSeleccion\n" +
                     "    GROUP BY s.idSeleccion, s.nombre, s.tecnico, e.nombre, primer_partido\n" +
                     ") AS subquery\n" +
                     "WHERE row_num = 1\n" +
                     "ORDER BY idSeleccion;");) {

            while (rs.next()) {
                //Seleccion seleccion = new Seleccion();
                Seleccion seleccion = fetchSeleccionData(rs);

                /*
                seleccion.setIdSeleccion(rs.getInt(1));
                seleccion.setNombre(rs.getString(2));
                seleccion.setTecnico(rs.getString(3));

                Estadio estadio = new Estadio();
                //estadio.setIdEstadio(rs.getInt("e.idEstadio"));
                estadio.setNombre(rs.getString("nombre"));
                seleccion.setEstadio(estadio);

                seleccion.setPrimerPartido(rs.getString(5));
                */

                listaSelecciones.add(seleccion);
            }
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listaSelecciones;
    }

    public void borrar (int idSeleccion) {
        String sql = "delete from seleccion where (idSeleccion = ?)";
        try (Connection conn = getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, idSeleccion);
            pstmt.executeUpdate();
        }
        catch (SQLException ex){
            ex.printStackTrace();
        }
    }

    public void anadir (Seleccion seleccion) {
        String sql = "insert into seleccion (nombre, tecnico, estadio_idEstadio) values (?, ?, ?)";

        try (Connection conn = getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql)) {
            setSeleccionData(seleccion, pstmt);
            pstmt.executeUpdate();
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public Seleccion mostrar(int idSeleccion) {
        Seleccion seleccion = null;
        //llenar
        return seleccion;
    }

    private Seleccion fetchSeleccionData(ResultSet rs) throws  SQLException {
        Seleccion seleccion = new Seleccion();
        seleccion.setIdSeleccion(rs.getInt(1));
        seleccion.setNombre(rs.getString(2));
        seleccion.setTecnico(rs.getString(3));

        Estadio estadio = new Estadio();
        //estadio.setIdEstadio(rs.getInt("e.idEstadio"));
        estadio.setNombre(rs.getString(4));
        seleccion.setEstadio(estadio);

        seleccion.setPrimerPartido(rs.getString(6));

        return seleccion;
    }

    private void setSeleccionData(Seleccion seleccion, PreparedStatement pstmt) throws SQLException {
        pstmt.setString(1, seleccion.getNombre());
        pstmt.setString(2, seleccion.getTecnico());
        pstmt.setInt(3, seleccion.getIdSeleccion());
    }

}
