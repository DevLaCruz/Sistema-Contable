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
        <!-- Barra Lateral-->
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
                <li>
                    <a href="Controlador?URL=area_tipocambio">
                        <i class='bx bxs-doughnut-chart' ></i>
                        <span class="text">Operaciones</span>
                    </a>
                </li>
                <li class="active">
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
                        <h1>Mantenimiento</h1>
                        <ul class="breadcrumb">
                            <li>
                                <a href="#">Mantenimiento</a>
                            </li>
                            <li><i class='bx bx-chevron-right' ></i></li>
                            <li>
                                <a class="active" href="#">Plan Contable</a>
                            </li>
                        </ul>
                    </div>
                </div>

                <%-- Opciones de mantenimiento --%>

                <ul class="box-info">
                    <li>
                        <i class='bx bxs-calendar-check' ></i>
                        <span class="lanzar-modal" type="submit" style="cursor:pointer" onclick="location.href = 'Controlador?URL=area_librodiario'">
                            <h3 class="itemm" >Libro Diario</h3>
                        </span>

                    </li>
                    <li>
                        <i class='bx bxs-group' ></i>
                        <span class="lanzar-modal" type="submit" style="cursor:pointer" onclick="location.href = 'Controlador?URL=area_libromayor'">
                            <h3 class="itemm" >Libro Mayor</h3>
                        </span>
                    </li>
                    <li>
                        <i class='bx bxs-dollar-circle' ></i>
                        <span class="btnmant" type="submit" style="cursor:pointer" onclick="location.href = 'Controlador?URL=area_cuentacorriente'">
                            <h3 class="itemm" >Registros</h3>
                        </span>
                    </li>
                </ul>
                <div class="table-data">
                    <div class="todo">
                        <div class="head">
                            <h3>Nuevo</h3>
                            <i class='bx bx-filter' ></i>
                        </div>
                        <!-- CAMBIOS ALEJANDRO 30/12/2022 4:52AM -->
                        <form id="formLibro">
                            <div class="form-control">
                                <label for="text">Tipo de Operacion</label>
                                <input type="text" name="txttipoOpe" placeholder="Tipo de Operacion">
                            </div>
                            <label for="text">Fecha</label>
                            <div class="form-control">
                                <input type="date" name="txtFechain">
                                <input type="date" name="txtFechafin">
                            </div>
                            <label for="text">Tipo/Serie/Corr</label>
                            <div class="form-control">
                                <input type="text" name="txttipoDoc" placeholder="Tipo">
                                <input type="text" name="txtserie" placeholder="Serie">
                                <input type="text" name="txtcorrel" placeholder="Correlativo">
                            </div>
                            <div class="form-control">
                                <input type="text" name="txtestado" placeholder="Estado">
                            </div>
                        </form>
                        <button type="button" class="btn" id="BtnBuscar">Buscar</button>
                        <!-- CAMBIOS ALEJANDRO 30/12/2022 4:52AM -->
                    </div>
                </div>
                <div class="table-data">
                    <div class="order">
                        <div class="head">
                            <h3>Lista Libro Diario</h3>
                            <i class='bx bx-search' ></i>
                            <i class='bx bx-filter' ></i>
                        </div>
                        <table>
                            <thead>
                                <tr>
                                    <th>Tipo Operacion</th>
                                    <th>Nº ASIENTO</th>
                                    <th>FECHA</th>
                                    <th>MONEDA</th>
                                    <th>DEBE(S/.)</th>
                                    <th>HABER(S/.)</th>
                                    <th>DEBE($)</th>
                                    <th>HABER($)</th>
                                    <th>GLOSA</th>
                                    <th>ESTADO</th>
                                </tr>
                            </thead>
                            <tbody id="libro_diario">
                            </tbody>
                        </table>
                        <form>
                            <button type="submit" class="btn">
                                <img src="Visualizar" alt=""/>Visualizar
                            </button>
                            <button type="submit" class="btn">
                                <img src="Imprimir" alt=""/> Imprimir
                            </button>
                        </form>
                    </div>
                </div>
            </main>
        </section>

        <script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
        <script src="js/librodiario.js" type="text/javascript"></script>
        <script src="js/panel.js" type="text/javascript"></script>
    </body>
</html>
