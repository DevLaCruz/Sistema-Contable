$(function () {
    ListarCuentas();
    ListarCuentasCorriente();
    ListarClaseBien();
    ListarPeriodoContables();
    ListarTipoCambio();
    ListarTipoOperacion();
    ListarTipoIdentificacion();
    ListarDestinoCompra();
    ListarTipoDocumento();
    ListarPeriodoSelect();
});

function ListarCuentasCorriente() {
    $.getJSON("Controlador?URL=listar_cuentacorriente", {busq: ""}, function (data) {
        $("#cuenta_corriente").empty();
        $.each(data, function (i, obj) {
            $("#cuenta_corriente").append(
                    "<tr>" +
                    "<td>" + obj.idtipo + "</td>" +
                    "<td>" + obj.numero + "</td>" +
                    "<td>" + obj.denominacion + "</td>" +
                    "<td>" + obj.pais + "</td>" +
                    "<td>" + obj.direccion + "</td>" +
                    "</tr>"
                    );
        });
    });
}
;

function ListarClaseBien() {
    $.getJSON("Controlador?URL=listar_clasebien", {busq: ""}, function (data) {
        $("#clase_bien").empty();
        $.each(data, function (i, obj) {
            $("#clase_bien").append(
                    "<tr>" +
                    "<td>" + obj.codigo + "</td>" +
                    "<td>" + obj.nombre + "</td>" +
                    "</tr>"
                    );
        });
    });
}
;

function ListarPeriodoContables() {
    $.getJSON("Controlador?URL=listar_periodocontable", {busq: ""}, function (data) {
        $("#periodo_contable").empty();
        $.each(data, function (i, obj) {
            $("#periodo_contable").append(
                    "<tr>" +
                    "<td>" + (i + 1) + "</td>" +
                    "<td>" + obj.año + "</td>" +
                    "<td>" + obj.fecha_inicio + "</td>" +
                    "<td>" + obj.fecha_fin + "</td>" +
                    "<td>" + obj.estado + "</td>" +
                    "</tr>"
                    );
        });
    });
}
;

function ListarTipoCambio() {
    $.getJSON("Controlador?URL=listar_tipocambio", {busq: ""}, function (data) {
        $("#tipo_cambio").empty();
        $.each(data, function (i, obj) {
            $("#tipo_cambio").append(
                    "<tr>" +
                    "<td>" + (i + 1) + "</td>" +
                    "<td>" + obj.id + "</td>" +
                    "<td>" + obj.nombre + "</td>" +
                    "<td>" + obj.fecha + "</td>" +
                    "<td>" + obj.precio_compra + "</td>" +
                    "<td>" + obj.precio_venta + "</td>" +
                    "</tr>"
                    );
        });
    });
}
;

function ListarTipoOperacion() {
    $.getJSON("Controlador?URL=listar_tipooperacion", {busq: ""}, function (data) {
        $("#tipo_operacion").empty();
        $.each(data, function (i, obj) {
            $("#tipo_operacion").append(
                    "<tr>" +
                    "<td>" + (i + 1) + "</td>" +
                    "<td>" + obj.codigo + "</td>" +
                    "<td>" + obj.nombre + "</td>" +
                    "<td>" + obj.tipo_cambio + "</td>" +
                    "</tr>"
                    );
        });
    });
}
;

function ListarTipoIdentificacion() {
    $.getJSON("Controlador?URL=listar_tipoidentificacion", {busq: ""}, function (data) {
        $("#tipo_identificacion").empty();
        $.each(data, function (i, obj) {
            $("#tipo_identificacion").append(
                    "<tr>" +
                    "<td>" + (i + 1) + "</td>" +
                    "<td>" + obj.codigo + "</td>" +
                    "<td>" + obj.nombre + "</td>" +
                    "</tr>"
                    );
        });
    });
}
;

function ListarTipoDocumento() {
    $.getJSON("Controlador?URL=listar_tipodocumento", {busq: ""}, function (data) {
        $("#tipo_documento").empty();
        $.each(data, function (i, obj) {
            $("#tipo_documento").append(
                    "<tr>" +
                    "<td>" + (i + 1) + "</td>" +
                    "<td>" + obj.codigo + "</td>" +
                    "<td>" + obj.nombre + "</td>" +
                    "</tr>"
                    );
        });
    });
}
;

function ListarDestinoCompra() {
    $.getJSON("Controlador?URL=listar_destinocompra", {busq: ""}, function (data) {
        $("#destino_compra").empty();
        $.each(data, function (i, obj) {
            $("#destino_compra").append(
                    "<tr>" +
                    "<td>" + (i + 1) + "</td>" +
                    "<td>" + obj.cuenta_origen + "</td>" +
                    "<td>" + obj.cuenta_cargo + "</td>" +
                    "<td>" + obj.cuenta_abono + "</td>" +
                    "</tr>"
                    );
        });
    });
}
;


function ListarPeriodoSelect() {
    $.getJSON("Controlador?URL=listar_periodocontable", {busq: ""}, function (data) {
        $.each(data, function (i, obj) {
            $("#listar_periodo").append(
                    "<option value=\"" + obj.id + "\">" + obj.año + "</option>"
                    );
        });
    });
}
;


