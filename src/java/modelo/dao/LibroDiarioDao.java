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
import modelo.beans.LibroDiario;

/**
 *
 * @author USER
 */
public class LibroDiarioDao {
    PreparedStatement ps;
    ResultSet rs;
    Connection con;
    Conexion objcon = new Conexion();
    String mensaje;

    public List listar(String busq) {

        List<LibroDiario> Librod = new ArrayList<>();
        
        String sql = "SELECT codigo_operacion, numero_asiento, fecha, moneda, debe_soles, haber_soles, debe_dolares, haber_dolares, glosa, estado " +
                     "FROM asiento_contable  ac  " +
                     "JOIN detalle_asiento da ON  ac.numero_asiento= da.num_asiento " +
                     "JOIN documento d ON d.serie= da.seriedocumento " + busq;

        
        try {

            con = objcon.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {

                LibroDiario ld = new LibroDiario();
                
                ld.setTipooperacion(rs.getString("codigo_operacion"));
                ld.setNumeroasiento(rs.getString("numero_asiento"));
                ld.setFecha(rs.getDate("fecha"));
                ld.setMoneda(rs.getString("moneda"));
                ld.setDebesoles(rs.getDouble("debe_soles"));
                ld.setHabersoles(rs.getDouble("haber_soles"));
                ld.setDebedolares(rs.getDouble("debe_dolares"));
                ld.setHaberdolares(rs.getDouble("haber_dolares"));
                ld.setGlosa(rs.getString("glosa"));
                //ld.setModo(rs.getString("modo"));
                //ld.setTipo(rs.getString("tipo"));
                ld.setEstado(rs.getString("estado"));
                Librod.add(ld);

            }

        } catch (Exception e) {
            System.out.println("OCURRIO EL SIGUIENTE ERROR: " + e);
        }
        return Librod;

    }
}
