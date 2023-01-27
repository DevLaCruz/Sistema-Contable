package modelo.logic;

import java.util.List;
import modelo.beans.LibroMayor;
import modelo.dao.LibroMayorDao;

public class LibroMayorLogic {
    
    private String msj;
    
    private LibroMayorDao daoLM = new LibroMayorDao();
    
    private LibroMayor beansLM = new LibroMayor();
    
    public List Listar() {
    
    String busq = "";
    
    List<LibroMayor> lm;
    
    lm=daoLM.listar(busq);
    
    return lm;
    
    }
    
}
