/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.logic;

import java.util.List;
import modelo.beans.DetalleAsiento;
import modelo.dao.DetalleAsientoDao;

/**
 *
 * @author Jean Paul
 */
public class DetalleAsientoLogic {

    String msj;
    DetalleAsientoDao daoAC = new DetalleAsientoDao();
    DetalleAsiento beansAC = new DetalleAsiento();

    public String Agregar(DetalleAsiento detalle) {

        List<DetalleAsiento> detalles;
        detalles = daoAC.listar("");

        if (detalle.getCuenta() > 0
                && detalle.getTipoCambio() > 0
                && !"".equals(detalle.getNumeroAsiento())
                && !"".equals(detalle.getSerieDoc())) {

            if (detalle.getDebesoles() > 0) {
                msj = daoAC.AgregarDebe(detalle);
            } else {
                msj = daoAC.AgregarHaber(detalle);
            }

        } else {
            msj = "INCOMPLETO";
        }
        return msj;
    }
}
