<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Suma Numeros</title>
    </head>
    <body>
        <%int resultado=0;%>
        <%for(int i=1;i<=10;i++){%>
            <%resultado+=i;%>
        <%}%>
        <h1>Resultado = <%=resultado%></h1>        
    </body>
</html>
