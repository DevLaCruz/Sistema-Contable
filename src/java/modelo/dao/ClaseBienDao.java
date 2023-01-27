/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.dao;

import datos.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.beans.ClaseBien;

/**
 *
 * @author USER
 */
public class ClaseBienDao {

    PreparedStatement ps;
    ResultSet rs;
    Connection con;
    Conexion objcon = new Conexion();
    String mensaje;

    public List listar(String busq) {

        List<ClaseBien> Clasebi = new ArrayList<>();

        String sql = "SELECT * FROM clase_bien "
                + "WHERE nombre LIKE '%" + busq + "%' "
                + "OR codigo LIKE '%" + busq + "%';";

        try {

            con = objcon.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {

                ClaseBien cb = new ClaseBien();
                cb.setCodigo(rs.getInt("codigo"));
                cb.setNombre(rs.getString("nombre"));
                Clasebi.add(cb);

            }

        } catch (Exception e) {
            System.out.println("OCURRIO EL SIGUIENTE ERROR: " + e);
        }
        return Clasebi;

    }

    public String Agregar(ClaseBien claseb) {

        String sql = "INSERT INTO clase_bien( "
                + "codigo, "
                + "nombre) "
                + "VALUES (?,?)";

        try {

            con = objcon.getConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, claseb.getCodigo());
            ps.setString(2, claseb.getNombre());

            ps.executeUpdate();

            mensaje = "CUENTA CLASE BIEN AGREGADA";

        } catch (Exception e) {
            mensaje = "ERROR AL AGREGAR CLASE BIEN: " + e;
        }

        return mensaje;
    }
}
