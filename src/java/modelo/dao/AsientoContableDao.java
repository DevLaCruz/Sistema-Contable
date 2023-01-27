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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.beans.AsientoContable;

/**
 *
 * @author Jean Paul
 */
public class AsientoContableDao {

    PreparedStatement ps;
    ResultSet rs;
    Statement st;
    Connection con;
    Conexion objcon = new Conexion();
    String mensaje;

    public List listar(String busq) {

        List<AsientoContable> lista = new ArrayList<>();

        String sql = "SELECT * FROM asiento_contable "
                + "WHERE numero_asiento LIKE '%" + busq + "%';";

        try {

            con = objcon.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {

                AsientoContable as = new AsientoContable();
                as.setNumero(rs.getString("numero_asiento"));
                as.setFecha(rs.getDate("fecha"));
                as.setGlosa(rs.getString("glosa"));
                as.setEstado(rs.getString("estado"));
                as.setCodOperacion(rs.getString("codigo_operacion"));
                as.setIdPeriodo(rs.getInt("id_periodo"));
                as.setCodUsuario(rs.getInt("codigo_usuario"));
                as.setMoneda(rs.getString("moneda"));
                lista.add(as);

            }

        } catch (Exception e) {
            System.out.println("ERROR: " + e);
        }
        return lista;
    }

    public String Agregar(AsientoContable asiento) {

        String sql = "INSERT INTO asiento_contable("
                + "numero_asiento, "
                + "fecha, "
                + "glosa, "
                + "estado, "
                + "codigo_operacion, "
                + "id_periodo, "
                + "codigo_usuario,"
                + "moneda) "
                + "VALUES (?,?,?,?,?,?,?,?)";

        try {

            con = objcon.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, asiento.getNumero());
            ps.setDate(2, (Date) asiento.getFecha());
            ps.setString(3, asiento.getGlosa());
            ps.setString(4, asiento.getEstado());
            ps.setString(5, asiento.getCodOperacion());
            ps.setInt(6, asiento.getIdPeriodo());
            ps.setInt(7, asiento.getCodUsuario());
            ps.setString(8, asiento.getMoneda());

            ps.executeUpdate();

            mensaje = "AGREGADO";

        } catch (Exception e) {

            mensaje = "ERROR: " + e;
        }

        return mensaje;
    }

    public String Editar(AsientoContable asiento) {

        String sql = "UPDATE asiento_contable SET "
                + "numero_asiento=?, "
                + "fecha=?, "
                + "glosa=?, "
                + "estado=?, "
                + "codigo_operacion=?, "
                + "id_periodo=?, "
                + "codigo_usuario=?, "
                + "WHERE "
                + "numero_asiento="
                + asiento.getNumero();

        try {

            con = objcon.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, asiento.getNumero());
            ps.setDate(2, (Date) asiento.getFecha());
            ps.setString(3, asiento.getGlosa());
            ps.setString(4, asiento.getEstado());
            ps.setString(5, asiento.getCodOperacion());
            ps.setInt(6, asiento.getIdPeriodo());
            ps.setInt(7, asiento.getCodUsuario());

            mensaje = "EDITADO";

        } catch (Exception e) {

            mensaje = "ERROR: " + e;

        }

        return mensaje;

    }

    public String Eliminar(int numero) {

        String sql = "DELETE FROM asiento_contable WHERE numero_asiento=" + numero;

        try {

            con = objcon.getConexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();

            mensaje = "ELIMINADO";

        } catch (Exception e) {

            mensaje = "ERROR: " + e;

        }

        return mensaje;
    }

    public int NumeroAsientos() {

        int n = 0;
        String sql = "SELECT count(numero_asiento) "
                + "FROM asiento_contable";

        try {

            con = objcon.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            if (rs.next()) {

                n = rs.getInt("count(numero_asiento)");
            }

        } catch (Exception e) {


        }

        return n;
    }
}
