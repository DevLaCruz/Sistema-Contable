/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.dao;

import datos.Conexion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.beans.PeriodoContable;

/**
 *
 * @author ferdinand
 */
public class PeriodoContableDao {

    PreparedStatement ps;
    ResultSet rs;
    Connection con;
    Conexion objcon = new Conexion();
    String mensaje;

    public List listar(String busq) {

        List<PeriodoContable> PeriodoC = new ArrayList<>();

        String sql = "SELECT * FROM periodo_contable "
                + "WHERE id LIKE '%" + busq + "%' "
                + "OR año LIKE '%" + busq + "%';";

        try {

            con = objcon.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {

                PeriodoContable pc = new PeriodoContable();
                pc.setId(rs.getInt("id"));
                pc.setAño(rs.getInt("año"));
                pc.setFecha_inicio(rs.getDate("fecha_inicio"));
                pc.setFecha_fin(rs.getDate("fecha_fin"));
                pc.setEstado(rs.getString("estado"));
                PeriodoC.add(pc);

            }

        } catch (Exception e) {
            System.out.println("OCURRIO EL SIGUIENTE ERROR: " + e);
        }
        return PeriodoC;

    }

    public String Agregar(PeriodoContable PeriodoC) {

        String sql = "INSERT INTO periodo_contable("
                + "año, "
                + "fecha_inicio, "
                + "fecha_fin, "
                + "estado) "
                + "VALUES (?,?,?,?)";

        try {

            con = objcon.getConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, PeriodoC.getAño());
            ps.setDate(2, (Date) PeriodoC.getFecha_inicio());
            ps.setDate(3, (Date) PeriodoC.getFecha_fin());
            ps.setString(4, PeriodoC.getEstado());

            ps.executeUpdate();

            mensaje = "PERIODO CONTABLE AGREGADA";

        } catch (Exception e) {

            mensaje = "ERROR AL AGREGAR PERIODO CONTABLE: " + e;
        }

        return mensaje;
    }

    public String Editar(PeriodoContable PeriodoC) {

        String sql = "UPDATE periodo_contable SET "
                + "año=?, "
                + "fecha_inicio=?, "
                + "fecha_fin=?, "
                + "estado=? "
                + "WHERE "
                + "id="
                + PeriodoC.getId();

        try {

            con = objcon.getConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, PeriodoC.getAño());
            ps.setDate(2, (Date) PeriodoC.getFecha_inicio());
            ps.setDate(3, (Date) PeriodoC.getFecha_fin());
            ps.setString(4, PeriodoC.getEstado());

            mensaje = "PERIODO CONTABLE EDITADO";

        } catch (Exception e) {

            mensaje = "ERROR AL EDITAR PERIODO CONTABLE: " + e;

        }

        return mensaje;

    }

    public String Eliminar(int n) {

        String sql = "DELETE FROM periodo_contable WHERE id=" + n;

        try {

            con = objcon.getConexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();

            mensaje = "PERIODO CONTABLE ELIMINADO";

        } catch (Exception e) {

            mensaje = "FALLO AL ELIMINAR PERIODO CONTABLE: " + e;

        }

        return mensaje;
    }
}
