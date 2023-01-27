/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.logic;

import java.util.List;
import modelo.beans.CuentaCorriente;
import modelo.dao.CuentaCorrienteDao;

/**
 *
 * @author USER
 */
public class CuentaCorrienteLogic {

    String msj;
    CuentaCorrienteDao daoCC = new CuentaCorrienteDao();
    CuentaCorriente beansCC = new CuentaCorriente();

    public String Agregar(CuentaCorriente cuentacorriente) {

        List<CuentaCorriente> cuentaco;
        cuentaco = daoCC.listar("");

        if (cuentacorriente.getNumero() > 0) {
            int contadorC = 0;
            int contadorA = 0;
            while (contadorC < cuentaco.size()) {
                if (cuentacorriente.getNumero() == cuentaco.get(contadorC).getNumero()) {
                    contadorA++;
                    break;
                }
                contadorC++;
            }
            if (contadorA == 0) {

                msj = daoCC.Agregar(cuentacorriente);
            } else {
                msj = "CUENTA CORRIENTE EXISTENTE";
            }
        } else {
            msj = "FALTAN DATOS";
        }
        return msj;
    }

    public List Listar(String busq) {

        List<CuentaCorriente> cuentaco;
        cuentaco = daoCC.listar(busq);
        return cuentaco;
    }
}
