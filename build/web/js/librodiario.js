/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/ClientSide/javascript.js to edit this template
 */

$("#BtnBuscar").click(function () {

    var recolec = $('#formLibro').serialize();

    $.getJSON("Controlador?URL=listar_librodiario", recolec, function (data) {
        $("#libro_diario").empty();
        $.each(data, function (i, obj) {
            $("#libro_diario").append(
                    "<tr>" +
                    "<td>" + obj.tipooperacion + "</td>" +
                    "<td>" + obj.numeroasiento + "</td>" +
                    "<td>" + obj.fecha + "</td>" +
                    "<td>" + obj.moneda + "</td>" +
                    "<td>" + obj.debesoles + "</td>" +
                    "<td>" + obj.habersoles + "</td>" +
                    "<td>" + obj.debedolares + "</td>" +
                    "<td>" + obj.haberdolares + "</td>" +
                    //"<td> ... </td>" +
                    //"<td> ... </td>" +
                    "<td>" + obj.glosa + "</td>" +
                    "<td>" + obj.estado + "</td>" +
                    "</tr>"
                    );
        });
    });
});
