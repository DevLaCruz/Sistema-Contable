/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(function () {
    ListarDetalleDocumento();
});

function ListarDetalleDocumento() {
    $.getJSON("Controlador?URL=listar_detalledocumento", function (data) {
        $("#detalle_asiento").empty();
        $.each(data, function (i, obj) {
            $("#detalle_asiento").append(
                    "<tr>" +
                    "<td>" + (i + 1) + "</td>" +
                    "<td>" + obj.cuenta + "</td>" +
                    "<td> Nombre Cuenta</td>" +
                    "<td>" + obj.debesoles + "</td>" +
                    "<td>" + obj.habersoles + "</td>" +
                    "<td>" + obj.debedolares + "</td>" +
                    "<td>" + obj.haberdolares + "</td>" +
                    "</tr>"
                    );
        });
    });
}

$("#AgregarDetalle").click(function () {

    var recolec = $('#detalleForm').serialize();

    $.ajax({
        url: 'Controlador?URL=agregar_detalle_documento',
        type: 'POST',
        data: recolec,
        success: function () {
            ListarDetalleDocumento();
        }
    });
});

$("#FinalizarAsiento").click(function () {

    var recolec = $('#finalizarForm').serialize();

    $.ajax({
        url: 'Controlador?URL=finalizar_asientocontable',
        type: 'POST',
        data: recolec,
        success: function (e) {
            alert(e);
        }
    });
});

document.addEventListener("keyup", e => {

    if (e.target.matches("#TipoOper")) {
        var cons = e.target.value;
        $.getJSON("Controlador?URL=mostrar_nombreTO", {cons: cons}, function (data) {
            var inputNombre = document.getElementById("NomTipOp");
            inputNombre.value = data;
        });
    }
    ;
});

$("#TCid").click(function () {
    var selector = document.getElementById("TCid").value;
    if (selector !== "") {
        var inputTP = document.getElementById("TCtxt");
        inputTP.value = selector;
    }
});

document.addEventListener("keyup", e => {

    var inputNAsiento = document.getElementById("NumeroAsiento");

    if (e.target.matches("#NAtipD")) {
        var cons = e.target.value;
        if (inputNAsiento.value.length<8) {
            $.getJSON("Controlador?URL=agregar_numeroasiento", function (data) {
                var mes = document.getElementById("NAfecha").value;

                let date = new Date(mes);

                if (date.getMonth() < 9) {
                    inputNAsiento.value = "0" + (date.getMonth() + 1) + cons + data;
                } else {
                    inputNAsiento.value = (date.getMonth() + 1) + cons + data;
                }
            });
        }
        ;
    }

});


