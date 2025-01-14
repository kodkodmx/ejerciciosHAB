<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Peluqueria</title>
    </head>
    <body>
        <h1>Datos del Insumo</h1>
        <form action="peluqueriaSv" method="POST">
            <p><label> Codigo: </label><input  type="text" name="codigo"></p>
            <p><label> Nombre: </label><input  type="text" name="nombre"></p>
            <p><label> Cantidad: </label><input  type="text" name="cantidad"></p>
            <p><label> Fecha: </label><input  type="text" name="fecha"></p>
            <button type="submit"> Enviar </button>
        </form>
    </body>
</html>
