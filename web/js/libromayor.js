$("#BtnBuscar").click(function () {

    var recolec = $('#formLibro').serialize();

    $.getJSON("Controlador?URL=listar_libromayor", recolec, function (data) {
        $("#libro_mayor").empty();
        $.each(data, function (i, obj) {
            $("#libro_mayor").append(
                    "<tr>" +
                    "<td>" + obj.fecha_operacion + "</td>" +
                    "<td>" + obj.numero_cuenta + "</td>" +
                    "<td>" + obj.numero_correlativo + "</td>" +
                    "<td>" + obj.glosa + "</td>" +
                    "<td>" + obj.deudor + "</td>" +
                    "<td>" + obj.acreedor + "</td>" +
                    "</tr>"
                    );
        });
    });
});
