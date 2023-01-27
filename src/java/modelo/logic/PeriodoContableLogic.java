/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.logic;

import java.util.ArrayList;
import java.util.List;
import modelo.beans.PeriodoContable;
import modelo.dao.PeriodoContableDao;

/**
 *
 * @author ferdinand
 */
public class PeriodoContableLogic {

    String msj;
    PeriodoContableDao daoPC = new PeriodoContableDao();
    PeriodoContable beansPC = new PeriodoContable();

    public List Listar(String busq) {

        List<PeriodoContable> periodos = new ArrayList<>();
        periodos = daoPC.listar(busq);
        return periodos;
    }

}
