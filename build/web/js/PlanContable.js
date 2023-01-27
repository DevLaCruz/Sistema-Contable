/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/ClientSide/javascript.js to edit this template
 */

$(function () {
    ListarCuentas();
});

var numeroC = 0;
var nombreC = 0;
var mnedaC = 0;
const btnLanzarModal = document.querySelector('#lanzar-modal');
const btnOcultarModal = document.querySelector('#ocultar-modal');
const btnEditar = document.querySelector('#editar');
const btnEliminar = document.querySelector('#eliminar');
const contModal = document.querySelector('.contenedor-modal');

btnLanzarModal.addEventListener('click', (e) => {
    e.preventDefault();
    contModal.classList.add('mostrar');
    
    var Inputnumero = document.getElementById("numeroM");
    var Inputnombre = document.getElementById("nombreM");
    var Inputmoneda = document.getElementById("monedaM");
    
    Inputnumero.value = numeroC;
    Inputnombre.value = nombreC;
    Inputmoneda.value = monedaC;
});

btnOcultarModal.addEventListener('click', (e) => {
    e.preventDefault();
    contModal.classList.remove('mostrar');


});

function Recuperar(codigo, nombre, moneda) {

    numeroC = codigo;
    nombreC = nombre;
    monedaC = moneda;
    //console.log(numeroC + nombreC + monedaC);
    
}
;

function ListarCuentas() {
    $.getJSON("Controlador?URL=listar_cuentacontable", {busq: ""}, function (data) {
        $("#cuenta_contable").empty();
        $.each(data, function (i, obj) {
            $("#cuenta_contable").append(
                    "<tr onclick=\"Recuperar('"+obj.numero+"','"+obj.nombre+"','"+obj.moneda+"')\">" +
                    "<td>" + (i + 1) + "</td>" +
                    "<td>" + obj.numero + "</td>" +
                    "<td>" + obj.nombre + "</td>" +
                    "<td>" + obj.moneda + "</td>" +
                    "</tr>"
                    );
        });
    });
}
;

function Editar() {
    
    var recolec = $('#formModal').serialize();
    
    $.ajax({
        url: 'Controlador?URL=modificar_cuentacontable',
        type: 'POST',
        data: recolec,
        success: function (e) {
            contModal.classList.remove('mostrar');
            alert(e);
            ListarCuentas();
        }
    });
}
;

function Eliminar() {
    $.ajax({
        url: 'Controlador?URL=eliminar_cuentacontable',
        type: 'POST',
        data: {txtNumeroM: numeroC},
        success: function (e) {
            contModal.classList.remove('mostrar');
            alert(e);
            ListarCuentas();
        }
    });
}
;

