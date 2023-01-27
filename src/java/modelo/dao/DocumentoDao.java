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
import modelo.beans.Documento;

/**
 *
 * @author Jean Paul
 */
public class DocumentoDao {
    
    PreparedStatement ps;
    ResultSet rs;
    Connection con;
    Conexion objcon = new Conexion();
    String mensaje;

    public List listar(String busq) {

        List<Documento> lista = new ArrayList<>();

        String sql = "SELECT * FROM documento "
                + "WHERE serie LIKE '%" + busq + "%';";

        try {

            con = objcon.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {

                Documento doc = new Documento();
                doc.setSerie(rs.getString("serie"));
                doc.setCorrelativo(rs.getString("correlativo"));
                doc.setConcepto(rs.getString("concepto"));
                doc.setAmbito(rs.getString("ambito"));
                doc.setFechaEmision(rs.getDate("fecha_emision"));
                doc.setFechaVencimiento(rs.getDate("fecha_vencimiento"));
                doc.setFormaPago(rs.getString("forma_pago"));
                doc.setNumerocuentacorriente(rs.getInt("num_cuentacorriente"));
                doc.setTipoDoc(rs.getString("cod_tipo"));
                lista.add(doc);

            }

        } catch (Exception e) {
            System.out.println("ERROR: " + e);
        }
        return lista;

    }

    public String Agregar(Documento documento) {

        String sql = "INSERT INTO documento("
                + "serie, "
                + "correlativo, "
                + "concepto, "
                + "ambito, "
                + "fecha_emision, "
                + "fecha_vencimiento, "
                + "forma_pago, "
                + "num_cuentacorriente, "
                + "cod_tipo) "
                + "VALUES (?,?,?,?,?,?,?,?,?)";

        try {

            con = objcon.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, documento.getSerie());
            ps.setString(2, documento.getCorrelativo());
            ps.setString(3, documento.getConcepto());
            ps.setString(4, documento.getAmbito());
            ps.setDate(5, (Date) documento.getFechaEmision());
            ps.setDate(6, (Date) documento.getFechaVencimiento());
            ps.setString(7, documento.getFormaPago());
            ps.setInt(8, documento.getNumerocuentacorriente());
            ps.setString(9, documento.getTipoDoc());

            ps.executeUpdate();

            mensaje = "AGREGADO";

        } catch (Exception e) {

            mensaje = "ERROR: " + e;
        }

        return mensaje;
    }

    public String Editar(Documento documento) {

        String sql = "UPDATE documento SET "
                + "serie=?, "
                + "correlativo=?, "
                + "concepto=?, "
                + "ambito=?, "
                + "fecha_emision=?, "
                + "fecha_vencimiento=?, "
                + "fecha_pago=?, "
                + "num_cuentacorriente=? "
                + "WHERE "
                + "serie="
                + documento.getSerie();

        try {

            con = objcon.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, documento.getSerie());
            ps.setString(2, documento.getCorrelativo());
            ps.setString(3, documento.getConcepto());
            ps.setString(4, documento.getAmbito());
            ps.setDate(5, (Date) documento.getFechaEmision());
            ps.setDate(6, (Date) documento.getFechaVencimiento());
            ps.setString(7, documento.getFormaPago());
            ps.setInt(8, documento.getNumerocuentacorriente());

            mensaje = "EDITADO";

        } catch (Exception e) {

            mensaje = "ERROR: " + e;

        }

        return mensaje;

    }

    public String Eliminar(String serie) {

        String sql = "DELETE FROM documento WHERE serie='" + serie + "';";

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
}
