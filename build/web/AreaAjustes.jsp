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
                <li>
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
                    <a href="Controlador?URL=area_librodiario">
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
                        <h1>Configuraciones</h1>
                    </div>
                </div>
                <div class="table-data">
                    <div class="formulinp">
                        <div class="head">
                            <h3>Ajustes Generales</h3>
                            <i class='bx bx-filter' ></i>
                        </div>
                        <form action="Controlador" method="post">
                            <div class="todo">
                                <label>Digitos de la contablidad:</label>
                                <input type="number" name="txtDigito">
                            </div>
                            <div class="todo">
                                <p>Digitos de la contablidad:</p>
                                <label> Periodo Actual:</label>
                                <select name="txtPeriodo" id="listar_periodo">

                                </select>
                            </div>
                            <%
                                if(msj!=null)
                                    out.print(msj);
                            %>
                            <input type="hidden" name="URL" value="modificar_digitos">
                            <button type="submit" class="btn">Guardar</button>
                        </form>
                    </div>
                    <div class="order">
                        <div class="head">
                            <h3>Ajustes Adicionales</h3>
                            <i class='bx bx-filter' ></i>
                        </div>
                        <p>Agregar Cuentas Automaticamente</p>
                        <div>
                            <input type="checkbox">
                            <label>Cuentas 10</label><br>
                            <input type="checkbox">
                            <label>Cuentas 20</label><br>
                            <input type="checkbox">
                            <label>Cuentas 30</label><br>
                            <input type="checkbox">
                            <label>Cuentas 40</label><br>
                            <input type="checkbox">
                            <label>Cuentas 50</label><br>
                            <input type="checkbox">
                            <label>Cuentas 60</label><br>
                            <input type="checkbox">
                            <label>Cuentas 70</label><br>
                        </div>
                    </div>
                </div>
            </main>
        </section>


        <script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
        <script src="js/lista.js" type="text/javascript"></script>
        <script src="js/panel.js"></script>
    </body>
</html>
