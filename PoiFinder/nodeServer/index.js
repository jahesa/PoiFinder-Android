var express = require("express");
var bodyParser = require("body-parser");
var app = express();
 
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({ extended: true }));
 
app.get('/Pois', function(req, res, next) {
	var response = [{"_servicios":["cobro cheques","depósitos"],"diasAtencionList":[],"direccion":"Rivadavia 372","distanciaMinCercania":0.0,"id":1,"nombre":"Galicia","numero":13,"palabrasClaves":[],"tipo":"Banco"},{"_servicios":["cajero automatico"],"diasAtencionList":[],"direccion":"Lavalleja 581","distanciaMinCercania":0.0,"id":2,"nombre":"Santander","numero":0,"palabrasClaves":[],"tipo":"Banco"},{"cantParadas":2,"diasAtencionList":[],"distanciaMinCercania":0.0,"id":3,"nombre":"Colectivo 78","numero":0,"palabrasClaves":[],"tipo":"Colectivo"},{"cantParadas":0,"diasAtencionList":[],"distanciaMinCercania":0.0,"id":4,"nombre":"Colectivo 23","numero":0,"palabrasClaves":[],"tipo":"Colectivo"},{"cantParadas":0,"diasAtencionList":[],"distanciaMinCercania":0.0,"id":5,"nombre":"Colectivo 7","numero":0,"palabrasClaves":[],"tipo":"Colectivo"},{"diasAtencionList":[],"direccion":"Mitre 3271","distanciaMinCercania":0.0,"id":6,"nombre":"Lo de Rosa","numero":0,"palabrasClaves":["Rabano","Lechuga"],"tipo":"Local"},{"diasAtencionList":[],"direccion":"Matheu 3289","distanciaMinCercania":0.0,"id":7,"nombre":"Lo de Carlo","numero":0,"palabrasClaves":["Vacio","Chinchulin","Chorrizo","Nalga"],"tipo":"Local"},{"servicios":[],"diasAtencionList":[],"direccion":"Pres. José E. Uriburu 1022","distanciaMinCercania":0.0,"id":8,"nombre":"Servicio Penetinciario","numero":0,"palabrasClaves":[],"tipo":"CGP"}];
	res.json(response);
});

var server = app.listen(3000, function () {
    console.log("Listening on port %s...", server.address().port);
});