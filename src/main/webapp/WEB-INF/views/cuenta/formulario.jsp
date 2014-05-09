<%--
  Created by IntelliJ IDEA.
  User: Jaime
  Date: 09/05/2014
  Time: 10:59 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<h3>Agregar Cuentas</h3>
<form action="agregarCuenta" method="post">
    Descripcion: <br/>
    <textarea name="descripcion" rows="5" cols="100"></textarea>
    <br/>
    Valor: <input type="text" name="valor" /></br>
    Tipo: <br/>
    <select name="tipo">
        <option value="INGRESO">Ingreso</option>
        <option value="SALIDA">Saída</option>
    </select>
    <br/><br/>
    <input type="submit" value="Agregar"/>
</form>
</body>
</html>