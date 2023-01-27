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
import modelo.beans.CuentaCorriente;

/**
 *
 * @author USER
 */
public class CuentaCorrienteDao {

    PreparedStatement ps;
    ResultSet rs;
    Connection con;
    Conexion objcon = new Conexion();
    String mensaje;

    public List listar(String busq) {

        List<CuentaCorriente> Cuentaco = new ArrayList<>();

        String sql = "SELECT * FROM cuenta_corriente "
                + "WHERE denominacion LIKE '%" + busq + "%' "
                + "OR numero_identi LIKE '%" + busq + "%';";

        try {

            con = objcon.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {

                CuentaCorriente cc = new CuentaCorriente();
                cc.setNumero(rs.getInt("numero_identi"));
                cc.setDenominacion(rs.getString("denominacion"));
                cc.setPais(rs.getString("pais"));
                cc.setDireccion(rs.getString("direccion"));
                cc.setIdtipo(rs.getInt("id_tipoiden"));
                Cuentaco.add(cc);

            }

        } catch (Exception e) {
            System.out.println("OCURRIO EL SIGUIENTE ERROR: " + e);
        }
        return Cuentaco;

    }

    public String Agregar(CuentaCorriente Cuentaco) {

        String sql = "INSERT INTO cuenta_corriente("
                + "numero_identi, "
                + "denominacion, "
                + "pais, "
                + "direccion, "
                + "id_tipoiden) "
                + "VALUES (?,?,?,?,?)";

        try {

            con = objcon.getConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, Cuentaco.getNumero());
            ps.setString(2, Cuentaco.getDenominacion());
            ps.setString(3, Cuentaco.getPais());
            ps.setString(4, Cuentaco.getDireccion());
            ps.setInt(5, Cuentaco.getIdtipo());

            ps.executeUpdate();

            mensaje = "CUENTA CORRIENTE AGREGADA";

        } catch (Exception e) {

            mensaje = "ERROR AL AGREGAR CUENTA CORRIENTE: " + e;
        }

        return mensaje;
    }
}
