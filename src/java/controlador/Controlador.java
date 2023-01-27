package controlador;

import com.google.gson.Gson;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import modelo.beans.AsientoContable;
import modelo.beans.ClaseBien;
import modelo.beans.CuentaContable;
import modelo.beans.CuentaCorriente;
import modelo.beans.DestinoCompra;
import modelo.beans.DetalleAsiento;
import modelo.beans.Documento;
import modelo.beans.LibroDiario;
import modelo.beans.LibroMayor;
import modelo.beans.TipoCambio;
import modelo.beans.TipoDocumento;
import modelo.beans.TipoIdentificacion;
import modelo.beans.TipoOperacion;
import modelo.beans.Usuario;
import modelo.logic.AsientoContableLogic;
import modelo.logic.ClaseBienLogic;
import modelo.logic.CuentaContableLogic;
import modelo.logic.CuentaCorrienteLogic;
import modelo.logic.DestinoCompraLogic;
import modelo.logic.DetalleAsientoLogic;
import modelo.logic.DocumentoLogic;
import modelo.logic.LibroDiarioLogic;
import modelo.logic.LibroMayorLogic;
import modelo.logic.PeriodoContableLogic;
import modelo.logic.TipoCambioLogic;
import modelo.logic.TipoDocumentoLogic;
import modelo.logic.TipoIdentificacionLogic;
import modelo.logic.TipoOperacionLogic;
import modelo.logic.UsuarioLogic;

/**
 *
 * @author Jean Paul
 */
@WebServlet(name = "Controlador", urlPatterns = {"/Controlador"})
public class Controlador extends HttpServlet {

    private String acceso = "";
    private String msj = "";
    private String rutaUrl = "";

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        rutaUrl = request.getParameter("URL");

        switch (rutaUrl) {
            case "registrar":
                Registrar(request, response);
                break;
            case "ingresar":
                Ingresar(request, response);
                break;
            case "agregar_cuentacontable":
                AgregarCuentaContable(request, response);
                break;
            case "agregar_cuentacorriente":
                AgregarCuentaCorriente(request, response);
                break;
            case "agregar_clasebien":
                AgregarClaseBien(request, response);
                break;
            case "agregar_tipodocumento":
                AgregarTipoDocumento(request, response);
                break;
            case "agregar_detalle_documento":
                AgregarDetalleDocumento(request, response);
                break;
            case "finalizar_asientocontable":
                FinalizarAsientoContable(request, response);
                break;
            case "agregar_tipooperacion":
                AgregarTipoOperacion(request, response);
                break;
            case "agregar_numeroasiento":
                AgregarNumeroAsiento(request, response);
                break;
            case "agregar_tipoidentificacion":
                AgregarTipoIdentificacion(request, response);
                break;
            case "agregar_tipocambio":
                AgregarTipoCambio(request, response);
                break;
            case "agregar_destinocompra":
                AgregarDestinoCompra(request, response);
                break;
            case "area_dashboard":
                AreaDashboard(request, response);
                break;
            case "listar_cuentacontable":
                ListarCuentaContable(request, response);
                break;
            case "listar_cuentacorriente":
                ListarCuentaCorriente(request, response);
                break;
            case "listar_clasebien":
                ListarClaseBien(request, response);
                break;
            case "listar_tipodocumento":
                ListarTipoDocumento(request, response);
                break;
            case "listar_periodocontable":
                ListarPeriodoContable(request, response);
                break;
            case "listar_tipocambio":
                ListarTipoCambio(request, response);
                break;
            case "listar_tipooperacion":
                ListarTipoOperacion(request, response);
                break;
            case "listar_tipoidentificacion":
                ListarTipoIdentificacion(request, response);
                break;
            case "listar_destinocompra":
                ListarDestinoCompra(request, response);
                break;
            case "listar_detalledocumento":
                ListarDetalleDocumento(request, response);
                break;
            case "listar_librodiario":
                ListarLibroDiario(request, response);
                break;
            case "listar_libromayor":
                ListarLibroMayor(request, response);
                break;    
            case "modificar_digitos":
                ModificarDigitos(request, response);
                break;
            case "modificar_cuentacontable":
                ModificarCuentaContable(request, response);
                break;
            case "eliminar_cuentacontable":
                EliminarCuentaContable(request, response);
                break;
            case "mostrar_nombreTO":
                MostrarNombreTO(request, response);
                break;
            case "area_plancontable":
                AreaPlanContable(request, response);
                break;
            case "area_clasebien":
                AreaClaseBien(request, response);
                break;
            case "area_tipodocumento":
                AreaTipoDocumento(request, response);
                break;
            case "area_cuentacorriente":
                AreaCuentaCorriente(request, response);
                break;
            case "area_asientocontable":
                AreaAsientoContable(request, response);
                break;
            case "area_tipocambio":
                AreaTipoCambio(request, response);
                break;
            case "area_tipooperacion":
                AreaTipoOperacion(request, response);
                break;
            case "area_destinocompra":
                AreaDestinoCompra(request, response);
                break;
            case "area_periodos":
                AreaPeriodoContable(request, response);
                break;
            case "area_tipoidentificacion":
                AreaTipoIdentificacion(request, response);
                break;
            case "area_librodiario":
                AreaLibroDiario(request, response);
                break;
            case "area_consultas":
                AreaConsultas(request, response);
                break;
            case "area_informes":
                AreaInformes(request, response);
                break;
            case "area_ajustes":
                AreaAjustes(request, response);
                break;
            case "area_libromayor":
                AreaLibroMayor(request, response);
                break;    
            default:
                throw new AssertionError();
        }

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    //Areas de la Pagina
    public void AreaDashboard(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        acceso = "/AreaDashboard.jsp";
        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
    }

    public void AreaPlanContable(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        acceso = "/AreaPlanContable.jsp";
        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
    }

    public void AreaCuentaCorriente(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        acceso = "/AreaCuentaCorriente.jsp";
        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
    }

    public void AreaClaseBien(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        acceso = "/AreaClaseBien.jsp";
        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
    }

    public void AreaTipoDocumento(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        acceso = "/AreaTipoDocumento.jsp";
        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
    }

    public void AreaTipoCambio(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        acceso = "/AreaTipoCambio.jsp";
        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
    }

    public void AreaAsientoContable(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        acceso = "/AreaAsientoContable.jsp";
        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
    }

    public void AreaLibroDiario(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        acceso = "/AreaLibroDiario.jsp";
        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
    }
    
    public void AreaLibroMayor(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        acceso = "/AreaLibroMayor.jsp";
        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
    }
    
    public void AreaConsultas(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        acceso = "/AreaConsultas.jsp";
        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
    }

    public void AreaInformes(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        acceso = "/AreaInformes.jsp";
        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
    }

    public void AreaAjustes(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        acceso = "/AreaAjustes.jsp";
        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
    }

    public void AreaTipoOperacion(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        acceso = "/AreaTipoOperacion.jsp";
        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
    }

    public void AreaDestinoCompra(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        acceso = "/AreaDestinoCompra.jsp";
        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
    }

    public void AreaPeriodoContable(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        acceso = "/AreaPeriodoContable.jsp";
        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
    }

    public void AreaTipoIdentificacion(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        acceso = "/AreaTipoIdentificacion.jsp";
        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
    }

    //Funciones
    public void Registrar(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        UsuarioLogic uL = new UsuarioLogic();
        Usuario uB = new Usuario();

        uB.setDni(request.getParameter("txtDni"));
        uB.setApell(request.getParameter("txtApellidos"));
        uB.setNombres(request.getParameter("txtNombres"));
        uB.setUsuario(request.getParameter("txtUsuario"));
        uB.setContraseña(request.getParameter("txtContraseña"));

        msj = uL.Registro(uB);
        acceso = "/index.jsp";
        request.setAttribute("msj", msj);
        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
    }

    public void Ingresar(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String usuario = request.getParameter("txtUsuario");
        String contraseña = request.getParameter("txtContraseña");

        UsuarioLogic uL = new UsuarioLogic();
        Usuario uB = uL.DatosU(usuario);

        msj = uL.Ingresar(usuario, contraseña);

        if (msj.compareTo("INGRESO_USUARIO") == 0) {

            //creamos la sesion
            HttpSession osesion = request.getSession();
            osesion.setAttribute("Usuario", uB);
            osesion.setAttribute("verif", "clnt");
            response.sendRedirect("AreaDashboard.jsp");

        } else {

            acceso = "/index.jsp";
            request.setAttribute("msj", msj);
            RequestDispatcher vista = request.getRequestDispatcher(acceso);
            vista.forward(request, response);

        }
    }

    public void AgregarCuentaContable(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        int numero = Integer.parseInt(request.getParameter("txtNumero"));
        String nombre = request.getParameter("txtNombre");
        String moneda = String.valueOf(request.getParameter("txtMoneda"));

        CuentaContableLogic ccL = new CuentaContableLogic();
        CuentaContable ccB = new CuentaContable();

        ccB.setNumero(numero);
        ccB.setNombre(nombre);
        ccB.setMoneda(moneda);

        msj = ccL.Agregar(ccB);
        acceso = "/AreaPlanContable.jsp";
        request.setAttribute("msj", msj);
        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
    }
    
    public void ModificarCuentaContable(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        int numero = Integer.parseInt(request.getParameter("txtNumeroM"));
        String nombre = request.getParameter("txtNombreM");
        String moneda = String.valueOf(request.getParameter("txtMonedaM"));

        CuentaContableLogic ccL = new CuentaContableLogic();
        CuentaContable ccB = new CuentaContable();

        ccB.setNumero(numero);
        ccB.setNombre(nombre);
        ccB.setMoneda(moneda);

        msj = ccL.Modificar(ccB);
        
        response.getWriter().print(msj);
    }
    
    public void EliminarCuentaContable(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        int numero = Integer.parseInt(request.getParameter("txtNumeroM"));

        CuentaContableLogic ccL = new CuentaContableLogic();

        msj = ccL.Eliminar(numero);
        
        response.getWriter().print(msj);
    }

    public void ListarCuentaContable(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        CuentaContableLogic ccL = new CuentaContableLogic();

        String busq = request.getParameter("busq");

        List<CuentaContable> lista;
        lista = ccL.Listar(busq);

        try {
            Gson gson = new Gson();
            String json = gson.toJson(lista);
            response.setContentType("application/json;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println(json);

        } catch (IOException e) {
        }
    }

    public void AgregarCuentaCorriente(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        int numero = Integer.parseInt(request.getParameter("txtNumero"));
        String denominacion = request.getParameter("txtDenominacion");
        String pais = request.getParameter("txtPais");
        String Direccion = request.getParameter("txtDireccion");
        int idtipo = Integer.parseInt(request.getParameter("txtidtipo"));

        CuentaCorrienteLogic ccL = new CuentaCorrienteLogic();
        CuentaCorriente ccB = new CuentaCorriente();

        ccB.setNumero(numero);
        ccB.setDenominacion(denominacion);
        ccB.setPais(pais);
        ccB.setDireccion(Direccion);
        ccB.setIdtipo(idtipo);

        msj = ccL.Agregar(ccB);
        acceso = "/AreaCuentaCorriente.jsp";
        request.setAttribute("msj", msj);
        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
    }

    public void AgregarTipoDocumento(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String codigo = request.getParameter("txtCodigo");
        String nombre = request.getParameter("txtNombre");

        TipoDocumentoLogic ccL = new TipoDocumentoLogic();
        TipoDocumento ccB = new TipoDocumento();

        ccB.setCodigo(codigo);
        ccB.setNombre(nombre);

        msj = ccL.Agregar(ccB);
        acceso = "/AreaTipoDocumento.jsp";
        request.setAttribute("msj", msj);
        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
    }

    public void ListarCuentaCorriente(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        CuentaCorrienteLogic ccL = new CuentaCorrienteLogic();

        String busq = request.getParameter("busq");

        List<CuentaCorriente> lista;
        lista = ccL.Listar(busq);

        try {
            Gson gson = new Gson();
            String json = gson.toJson(lista);
            response.setContentType("application/json;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println(json);

        } catch (IOException e) {
        }
    }

    public void AgregarClaseBien(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        int codigo = Integer.parseInt(request.getParameter("txtCodigo"));
        String nombre = request.getParameter("txtNombre");

        ClaseBienLogic ccL = new ClaseBienLogic();
        ClaseBien ccB = new ClaseBien();

        ccB.setCodigo(codigo);
        ccB.setNombre(nombre);

        msj = ccL.Agregar(ccB);
        acceso = "/AreaClaseBien.jsp";
        request.setAttribute("msj", msj);
        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
    }

    public void ListarClaseBien(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        ClaseBienLogic ccL = new ClaseBienLogic();

        String busq = request.getParameter("busq");

        List<ClaseBien> lista;
        lista = ccL.Listar(busq);

        try {
            Gson gson = new Gson();
            String json = gson.toJson(lista);
            response.setContentType("application/json;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println(json);

        } catch (IOException e) {
        }
    }

    public void ListarTipoDocumento(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        TipoDocumentoLogic ccL = new TipoDocumentoLogic();
        String busq = request.getParameter("busq");

        List<TipoDocumento> lista;
        lista = ccL.Listar(busq);

        try {
            Gson gson = new Gson();
            String json = gson.toJson(lista);
            response.setContentType("application/json;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println(json);

        } catch (IOException e) {
        }
    }

    public void ListarPeriodoContable(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        PeriodoContableLogic ccL = new PeriodoContableLogic();

        String busq = request.getParameter("busq");

        List<PeriodoContableLogic> lista;
        lista = ccL.Listar(busq);

        try {
            Gson gson = new Gson();
            String json = gson.toJson(lista);
            response.setContentType("application/json;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println(json);

        } catch (IOException e) {
        }
    }

    public void ListarLibroDiario(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        LibroDiarioLogic ldL = new LibroDiarioLogic();
        LibroDiario libro = new LibroDiario();
        
        libro.setTipooperacion(request.getParameter("txttipoOpe"));
        
        if(!"".equals(request.getParameter("txtFechain"))){
            libro.setFechaInicio(Date.valueOf(request.getParameter("txtFechain")));
        }
        if(!"".equals(request.getParameter("txtFechafin"))){
            libro.setFechaFin(Date.valueOf(request.getParameter("txtFechafin")));
        }
        
        libro.setSerie(request.getParameter("txtserie"));
        libro.setCorrelativo(request.getParameter("txtcorrel"));
        libro.setTipoDoc(request.getParameter("txttipoDoc"));
        libro.setEstado(request.getParameter("txtestado"));
        
        List<LibroDiario> lista;
        lista = ldL.Listar(libro);

        
        try {
            Gson gson = new Gson();
            String json = gson.toJson(lista);
            response.setContentType("application/json;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println(json);

        } catch (IOException e) {
        }
    }

    public void ListarLibroMayor(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        LibroMayorLogic lmL = new LibroMayorLogic();
        
        String fi = request.getParameter("txtFecha_inicio");
        String ff = request.getParameter("txtFecha_fin");
        String c = request.getParameter("txtCuenta");
        
        
        List<LibroDiario> lista;
        lista = lmL.Listar();

        
        try {
            Gson gson = new Gson();
            String json = gson.toJson(lista);
            response.setContentType("application/json;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println(json);

        } catch (IOException e) {
        }
    }

    public void AgregarTipoCambio(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String nombre = request.getParameter("txtNombre");
        double pc = Double.parseDouble(request.getParameter("txtPrecio_compra"));
        double pv = Double.parseDouble(request.getParameter("txtPrecio_venta"));

        TipoCambioLogic tcL = new TipoCambioLogic();
        TipoCambio tcB = new TipoCambio();

        tcB.setNombre(nombre);
        tcB.setPrecio_compra(pc);
        tcB.setPrecio_venta(pv);
        msj = tcL.Agregar(tcB);

        acceso = "/AreaTipoCambio.jsp";
        request.setAttribute("msj", msj);
        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
    }

    public void ListarTipoCambio(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        TipoCambioLogic tcL = new TipoCambioLogic();

        String busq = request.getParameter("busq");

        List<TipoCambioLogic> lista;
        lista = tcL.Listar(busq);

        try {
            Gson gson = new Gson();
            String json = gson.toJson(lista);
            response.setContentType("application/json;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println(json);

        } catch (IOException e) {
        }
    }

    public void AgregarTipoOperacion(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String codigo=request.getParameter("txtCodigo");

        String nombre = request.getParameter("txtNombre");
        String tipo_cambio = request.getParameter("txtTipo_cambio");

        TipoOperacionLogic toL = new TipoOperacionLogic();
        TipoOperacion toB = new TipoOperacion();

        toB.setCodigo(codigo);
        toB.setNombre(nombre);
        toB.setTipo_cambio(tipo_cambio);
        msj = toL.Agregar(toB);
        acceso = "/AreaTipoOperacion.jsp";
        request.setAttribute("msj", msj);
        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
    }

    public void ListarTipoOperacion(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        TipoOperacionLogic toL = new TipoOperacionLogic();

        String busq = request.getParameter("busq");

        List<TipoOperacionLogic> lista;
        lista = toL.Listar(busq);

        try {
            Gson gson = new Gson();
            String json = gson.toJson(lista);
            response.setContentType("application/json;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println(json);

        } catch (IOException e) {
        }
    }

    public void AgregarTipoIdentificacion(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String codigo = request.getParameter("txtCodigo");
        String nombre = request.getParameter("txtNombre");

        TipoIdentificacionLogic tiL = new TipoIdentificacionLogic();
        TipoIdentificacion tiB = new TipoIdentificacion();

        tiB.setCodigo(codigo);
        tiB.setNombre(nombre);
        msj = tiL.Agregar(tiB);
        acceso = "/AreaTipoIdentificacion.jsp";
        request.setAttribute("msj", msj);
        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
    }

    public void ListarTipoIdentificacion(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        TipoIdentificacionLogic tiL = new TipoIdentificacionLogic();

        String busq = request.getParameter("busq");

        List<TipoIdentificacionLogic> lista;
        lista = tiL.Listar(busq);

        try {
            Gson gson = new Gson();
            String json = gson.toJson(lista);
            response.setContentType("application/json;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println(json);

        } catch (IOException e) {
        }
    }

    public void AgregarDestinoCompra(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        int cuenta_origen, cuenta_cargo, cuenta_abono;

        if (request.getParameter("txtCuenta_origen").compareTo("") != 0) {
            cuenta_origen = Integer.parseInt(request.getParameter("txtCuenta_origen"));
        } else {
            cuenta_origen = 0;
        }
        if (request.getParameter("txtCuenta_cargo").compareTo("") != 0) {
            cuenta_cargo = Integer.parseInt(request.getParameter("txtCuenta_cargo"));
        } else {
            cuenta_cargo = 0;
        }
        if (request.getParameter("txtCuenta_abono").compareTo("") != 0) {
            cuenta_abono = Integer.parseInt(request.getParameter("txtCuenta_abono"));
        } else {
            cuenta_abono = 0;
        }

        DestinoCompraLogic dcL = new DestinoCompraLogic();
        DestinoCompra dcB = new DestinoCompra();

        dcB.setCuenta_origen(cuenta_origen);
        dcB.setCuenta_cargo(cuenta_cargo);
        dcB.setCuenta_abono(cuenta_abono);
        msj = dcL.Agregar(dcB);
        acceso = "/AreaDestinoCompra.jsp";
        request.setAttribute("msj", msj);
        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
    }

    public void ListarDestinoCompra(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        DestinoCompraLogic dcL = new DestinoCompraLogic();

        String busq = request.getParameter("busq");

        List<DestinoCompraLogic> lista;
        lista = dcL.Listar(busq);

        try {
            Gson gson = new Gson();
            String json = gson.toJson(lista);
            response.setContentType("application/json;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println(json);

        } catch (IOException e) {
        }
    }

    public void ModificarDigitos(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        int digito = Integer.parseInt(request.getParameter("txtDigito"));
        String SPeriodo = String.valueOf(request.getParameter("txtPeriodo"));
        int periodo = Integer.parseInt(SPeriodo);

        Usuario uB;

        HttpSession osesion = request.getSession(true);
        uB = (Usuario) osesion.getAttribute("Usuario");


        uB.setPeriodo(periodo);
        uB.setDigitos(digito);
        request.setAttribute("Usuario", uB);
        acceso = "/AreaAjustes.jsp";
        request.setAttribute("msj", msj);
        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
    }

    public void AgregarDetalleDocumento(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        HttpSession osesion = request.getSession(true);

        DocumentoLogic dLogic = new DocumentoLogic();
        DetalleAsientoLogic daLogic = new DetalleAsientoLogic();
        Documento doc = new Documento();
        DetalleAsiento det = new DetalleAsiento();
        TipoCambioLogic tipL = new TipoCambioLogic();
        TipoCambio tipB = new TipoCambio();

        //Recuperamos datos del Documento
        doc.setSerie(request.getParameter("txtSerie"));
        doc.setCorrelativo(request.getParameter("txtCorrelativo"));
        doc.setConcepto(request.getParameter("txtConcepto"));
        doc.setAmbito(String.valueOf(request.getParameter("txtAmbito")));
        doc.setFechaEmision(Date.valueOf(request.getParameter("txtFechaEmision")));
        doc.setFechaVencimiento(Date.valueOf(request.getParameter("txtFechaVencimiento")));
        doc.setFormaPago(String.valueOf(request.getParameter("txtFormaPago")));
        doc.setNumerocuentacorriente(Integer.parseInt(request.getParameter("txtCuentaCorriente")));
        doc.setTipoDoc(request.getParameter("txtTipoD"));

        ArrayList<Documento> documentos = (ArrayList) osesion.getAttribute("documentos") == null ? documentos = new ArrayList<>() : (ArrayList) osesion.getAttribute("documentos");
        documentos.add(doc);
        
        int tipocambio = Integer.parseInt(request.getParameter("txtCambioOculto"));
        tipB = tipL.DatosUltimo();

        //Recuperamos Datos del DetalleAsiento
        
        if (String.valueOf(request.getParameter("txtTipo")).equals("Debe")) {
            if (tipocambio == 1) {
                det.setDebesoles(Double.parseDouble(request.getParameter("txtImporte")));
                det.setDebedolares((Double.parseDouble(request.getParameter("txtImporte")) / tipB.getPrecio_compra()));
            } else {
                det.setDebesoles((Double.parseDouble(request.getParameter("txtImporte")) * tipB.getPrecio_venta()));
                det.setDebedolares(Double.parseDouble(request.getParameter("txtImporte")));
            }

        } else {
            if (tipocambio == 1) {
                det.setHabersoles(Double.parseDouble(request.getParameter("txtImporte")));
                det.setHaberdolares((Double.parseDouble(request.getParameter("txtImporte")) / tipB.getPrecio_compra()));
            } else {
                det.setHabersoles((Double.parseDouble(request.getParameter("txtImporte")) * tipB.getPrecio_venta()));
                det.setHaberdolares(Double.parseDouble(request.getParameter("txtImporte")));
            }
        }

        det.setCuenta(Integer.parseInt(request.getParameter("txtNumCuenta")));
        det.setTipoCambio(tipB.getId());
        det.setSerieDoc(request.getParameter("txtSerie"));

        ArrayList<DetalleAsiento> detalles = (ArrayList) osesion.getAttribute("detalles") == null ? detalles = new ArrayList<>() : (ArrayList) osesion.getAttribute("detalles");
        detalles.add(det);

        osesion.setAttribute("detalles", detalles);
        osesion.setAttribute("documentos", documentos);
        request.setAttribute("msj", msj);
    }

    public void ListarDetalleDocumento(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        HttpSession osesion = request.getSession(true);

        //Recuperamos DetalleAsiento
        ArrayList<DetalleAsiento> detalles = (ArrayList) osesion.getAttribute("detalles") == null ? detalles = new ArrayList<>() : (ArrayList) osesion.getAttribute("detalles");

        try {
            Gson gson = new Gson();
            String json = gson.toJson(detalles);
            response.setContentType("application/json;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println(json);

        } catch (IOException e) {
        }
    }

    public void FinalizarAsientoContable(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        HttpSession osesion = request.getSession(true);
        AsientoContableLogic acL = new AsientoContableLogic();
        AsientoContable acB = new AsientoContable();
        DetalleAsientoLogic daL = new DetalleAsientoLogic();
        DocumentoLogic dL = new DocumentoLogic();
        TipoCambio tcB = new TipoCambio();
        TipoCambioLogic tcL = new TipoCambioLogic();

        //Recuperamos Datos de Sesion
        Usuario usu = (Usuario) osesion.getAttribute("Usuario");
        ArrayList<DetalleAsiento> detalles = (ArrayList) osesion.getAttribute("detalles");
        ArrayList<Documento> documentos = (ArrayList) osesion.getAttribute("documentos");

        //Creamos el Asiento
        String Stipocambio = String.valueOf(request.getParameter("txtTipoCambio"));
        int tipocambio = Integer.parseInt(Stipocambio);
        
        acB.setNumero(request.getParameter("txtNumero"));
        acB.setFecha(Date.valueOf(request.getParameter("txtFecha")));
        acB.setGlosa(request.getParameter("txtGlosa"));
        acB.setCodOperacion(request.getParameter("txtTipoO"));
        acB.setIdPeriodo(usu.getPeriodo());
        acB.setCodUsuario(usu.getCodigo());
        if(tipocambio==1){
            acB.setMoneda("SOLES");
        }else{
            acB.setMoneda("DOLARES");
        }
        
        acB.setEstado("PENDIENTE");

        msj = acL.Agregar(acB);

        if (msj.equals("AGREGADO")) {
            int i = 0;
            for (Documento doc : documentos) {
                String pr;
                pr = dL.Agregar(doc);
                if (pr.equals("AGREGADO")) {
                    detalles.get(i).setNumeroAsiento(request.getParameter("txtNumero"));
                    msj = daL.Agregar(detalles.get(i));
                }
                i++;
            }
        }
        request.setAttribute("msj", msj);
    }

    public void MostrarNombreTO(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        TipoOperacionLogic toL = new TipoOperacionLogic();
        TipoOperacion toB;
        
        String busq = request.getParameter("cons");
        toB = toL.DatosTO(busq);
        
        try {
            Gson gson = new Gson();
            String json = gson.toJson(toB.getNombre());
            response.setContentType("application/json;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println(json);

        } catch (IOException e) {
        }
    }
    
    public void AgregarNumeroAsiento(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        AsientoContableLogic asL = new AsientoContableLogic();
        
        int n = asL.NumeroAsiento();
        String cont = String.valueOf(n);
        String numeroA = "";
        
        for (int i=0; i< (4-cont.length()); i++) {
            numeroA+=0;
        }
        n++;
        numeroA+=n;
        
        try {
            Gson gson = new Gson();
            String json = gson.toJson(numeroA);
            response.setContentType("application/json;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println(json);

        } catch (IOException e) {
        }
    }
    
    //Alertas
}
