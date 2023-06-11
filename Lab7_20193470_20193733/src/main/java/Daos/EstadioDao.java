package Daos;

import Beans.Estadio;
import java.sql.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class EstadioDao extends BaseDao {
    public ArrayList<Estadio> listarEstadio() {
        ArrayList<Estadio> listaEstadios = new ArrayList<>();
        try(Connection conn = getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from estadio");) {

            while(rs.next()) {
                //Estadio estadio = new Estadio();
                Estadio estadio = fetchEstadioData(rs);
                listaEstadios.add(estadio);
            }
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listaEstadios;
    }

    private Estadio fetchEstadioData(ResultSet rs) throws SQLException {
        Estadio estadio = new Estadio();
        estadio.setIdEstadio(rs.getInt(1));
        estadio.setNombre(rs.getString(2));
        estadio.setProvincia(rs.getString(3));
        estadio.setClub(rs.getString(4));

        return estadio;
    }
}
