<%-- 
    Document   : Dashboard
    Created on : 29 dic. 2022, 18:10:19
    Author     : Jean Paul
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="verif" scope="session" class="java.lang.String"/>
<jsp:useBean id="Usuario" scope="session" class="modelo.beans.Usuario"/>
<jsp:useBean id="msj" scope="request" class="java.lang.String"/>
<%@page session = "true"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href='https://unpkg.com/boxicons@2.0.9/css/boxicons.min.css' rel='stylesheet'>
        <link rel="stylesheet" href="css/panelcss.css">
        <title>Dashboard</title>
    </head>
    <body>
        <!-- Barra Lateral -->
        <section id="sidebar">
            <a href="#" class="brand">
                <i class='bx bxs-smile'></i>
                <span class="text">Sistema C.</span>
            </a>
            <ul class="side-menu top">
                <li>
                    <a href="Controlador?URL=area_dashboard">
                        <i class='bx bxs-dashboard' ></i>
                        <span class="text">Dashboard</span>
                    </a>
                </li>
                <li>
                    <a href="Controlador?URL=area_plancontable">
                        <i class='bx bxs-shopping-bag-alt' ></i>
                        <span class="text">Mantenimiento</span>
                    </a>
                </li>
                <li class="active">
                    <a href="Controlador?URL=area_tipocambio">
                        <i class='bx bxs-doughnut-chart' ></i>
                        <span class="text">Operaciones</span>
                    </a>
                </li>
                <li>
                    <a href="Controlador?URL=area_librodiario">
                        <i class='bx bxs-group' ></i>
                        <span class="text">Consultas</span>
                    </a>
                </li>
                <li>
                    <a href="Controlador?URL=area_informes">
                        <i class='bx bxs-group' ></i>
                        <span class="text">Informes</span>
                    </a>
                </li>
            </ul>
            <ul class="side-menu">
                <li>
                    <a href="Controlador?URL=area_ajustes">
                        <i class='bx bxs-cog' ></i>
                        <span class="text">Ajustes</span>
                    </a>
                </li>
            </ul>
        </section>
        <section id="content">
            <!-- Barra de Navegacion -->
            <nav>
                <i class='bx bx-menu' ></i>
                <a href="#" class="nav-link"></a>
                <form action="#">
                    <div class="form-input">
                    </div>
                </form>
                <input type="checkbox" id="switch-mode" hidden>
                <label for="switch-mode" class="switch-mode"></label>
                <a href="#" class="profile">
                    <img src="img/people.png">
                </a>
            </nav>
            <!-- MAIN -->
            <main>
                <div class="head-title">
                    <div class="left">
                        <h1>Operaciones</h1>
                        <ul class="breadcrumb">
                            <li>
                                <a href="#">Operaciones</a>
                            </li>
                            <li><i class='bx bx-chevron-right' ></i></li>
                        </ul>
                    </div>
                </div>

                <%-- Opciones de mantenimiento --%>

                <ul class="box-info">
                    <li>
                        <i class='bx bxs-calendar-check' ></i>
                        <span class="lanzar-modal" type="submit" style="cursor:pointer" onclick="location.href = 'Controlador?URL=area_tipocambio'">
                            <h3 class="itemm">Tipo de Cambio</h3>
                        </span>
                    </li>
                    <li>
                        <i class='bx bxs-group' ></i>
                        <span class="lanzar-modal" type="submit" style="cursor:pointer" onclick="location.href = 'Controlador?URL=area_asientocontable'">
                            <h3 class="itemm">Asiento Contable</h3>
                        </span>
                    </li>
                    <li>
                        <i class='bx bxs-dollar-circle' ></i>
                        <span class="lanzar-modal" type="submit" style="cursor:pointer" onclick="location.href = 'Controlador?URL=area_librodiario'">
                            <h3 class="itemm">Libro Diario</h3>
                        </span>
                    </li>
                </ul>
                <div class="head-title">
                    <div class="left">
                        <h1>Opciones</h1>
                    </div>
                </div>
                <div class="table-data">
                    <div class="todo">
                        <div class="head">
                            <h3>Nuevo</h3>
                            <i class='bx bx-filter' ></i>
                        </div>
                        <!-- CAMBIOS ALEJANDRO 30/12/2022 4:52AM -->
                        <form id="finalizarForm">
                            <div class="form-control">
                                <input type="number" name="txtTipoO" id="TipoOper" placeholder="Tipo de Operacion">  

                                <input type="text" id="NomTipOp" name="txtNombre" readonly><!-- no editable -->

                                <input type="number" id="NumeroAsiento" name="txtNumero" readonly> <!-- no editable -->

                                <input type="date" id="NAfecha" name="txtFecha">

                                <input type="text" name="txtGlosa" placeholder="Glosa">

                                <select id="TCid" name="txtTipoCambio">
                                    <option selected></option>
                                    <option value="1">Soles</option>
                                    <option value="2">Dólares</option>
                                </select>

                            </div>
                        </form>
                        <!-- CAMBIOS ALEJANDRO 30/12/2022 4:52AM -->
                    </div>
                </div>
                <div class="table-data">
                    <div class="order">
                        <table id="tabla_detalles">
                            <thead>
                                <tr>
                                    <th>N°</th>
                                    <th>N° Cuenta</th>
                                    <th>Nombre</th>
                                    <th>Debe (S/.)</th>
                                    <th>Haber (S/.)</th>
                                    <th>Debe ($)</th>
                                    <th>Haber ($)</th>
                                </tr>
                            </thead>
                            <tbody id="detalle_asiento">
                            </tbody>
                        </table>
                    </div>
                </div>
                <div class="table-data">
                    <div class="todo">

                        <!-- CAMBIOS ALEJANDRO 30/12/2022 4:52AM -->

                        <form id="detalleForm">
                            <div class="form-control">

                                <input type="number" name="txtNumCuenta" placeholder="Numero de Cuenta">  

                                <input type="number" name="txtCuentaCorriente" placeholder="Cuenta Auxiliar">
                            </div>  
                            <div class="form-control">

                                <label> Tipo</label>
                                <select name="txtTipo">
                                    <option selected></option>
                                    <option value="Debe">Debe</option>
                                    <option value="Haber">Haber</option>
                                </select>
                            </div>
                            <br>
                            <div class="form-control">

                                <input type="text" name="txtConcepto" placeholder="Concepto">
                                <input type="number" name="txtImporte" placeholder="Importe">

                            </div> 
                            <div class="form-control">

                                <label> Ambito</label>
                                <select name="txtAmbito">
                                    <option selected></option>
                                    <option value="Local">Local</option>
                                    <option value="nulo">--</option>
                                </select>
                            </div>
                            <br>
                            <div class="form-control">
                                <input type="text" id="NAtipD" name="txtTipoD" placeholder="Tipo Documento">  

                                <input type="text" name="txtSerie" placeholder="Serie">

                                <input type="number" name="txtCorrelativo" placeholder="Correlativo">

                                <input type="date" name="txtFechaEmision">

                                <input type="date" name="txtFechaVencimiento">
                            </div>     
                            <br>
                            <div class="form-control">    
                                <label> Forma de pago</label>
                                <select name="txtFormaPago">
                                    <option selected></option>
                                    <option value="Contado">Contado</option>
                                    <option value="Credito">Credito</option>
                                </select>
                            </div>

                            <div class="form-control">
                                <input type="text" name="txtClaseBien" placeholder="Clase Bs/Ss">
                                <input type="hidden" id="TCtxt" name="txtCambioOculto">
                            </div>
                        </form>

                        <button type="button" class="btn" id="AgregarDetalle">Agregar Detalle</button>
                        <button type="button" class="btn" id="FinalizarAsiento">Finalizar</button>
                        <!-- CAMBIOS ALEJANDRO 30/12/2022 4:52AM -->
                    </div>
                </div>
            </main>
        </section>

        <script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
        <script src="js/Asiento.js" type="text/javascript"></script>
        <script src="js/panel.js" type="text/javascript"></script>
    </body>
</html>
