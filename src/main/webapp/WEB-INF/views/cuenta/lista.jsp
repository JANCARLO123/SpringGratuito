<%--
  Created by IntelliJ IDEA.
  User: Jaime
  Date: 09/05/2014
  Time: 11:49 AM
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html>
<head>
    <script src=”resources/js/jquery.js”></script>
    <script type="text/javascript">
        function fueHecho(datosRespuesta)
        {
            alert('Cuenta pagada con Exito');
        }
//        function pagarAhora(id) {
//            $.get('pagarCuenta ? id ='+id);
//        }

        function pagarAhora(id) {
            $.post("pagarCuenta", {'id' :
                    id}, function() {
                $("#cuenta_"+id).html("Pago");
            });
        }

    </script>

</head>
<body>
<table style="height: 10px;
width: 775px;" border="1">
    <tr>
        <th>Código</th>
        <th>Descripcion</th>
        <th>Valor</th>
        <th>Tipo</th>
        <th>¿Pago?</th>
        <th>Fecha de Pago</th>
        <th>Acciones</th>
    </tr>
    <c:forEach
            items="${cuentas}" var="cuenta">
    <tr>
        <td>${cuenta.id}</td>
        <td>${cuenta.descripcion}</td>
        <td>${cuenta.valor}</td>
        <td>${cuenta.tipo}</td>
        <%--<td--%>
        <%--id="tarifa_${cuenta.id}">--%>
        <%--<c:if--%>
                <%--test="${cuenta.pago eq false}"> No pago--%>
        <%--</c:if>--%>
        <%--<c:if--%>
                <%--test="${cuenta.pago eq true }"> Pago!--%>
        <%--</c:if>--%>
        <%--</td>--%>
        <td
                id="cuenta_${cuenta.id}">
            <c:if test="${cuenta.pago eq false}">  No pago </c:if>
            <c:if test="${cuenta.pago eq true }">  Pago!   </c:if>
        </td>
        <td><fmt:formatDate
            value="${cuenta.fechaPago.time}"
            pattern="dd/MM/yyyy"/>
        </td>
        <td>
            <a href="eliminaCuenta?id=${cuenta.id}">Eliminar</a>
            <a href="muestraCuenta?id=${cuenta.id}">Modificar</a>
            <c:if test="${cuenta.pago eq false}">
                <a href="#" onclick="pagarAhora(${cuenta.id})">Pagar</a>

            </c:if>
        </td>
    </tr>
    </c:forEach>
</table>
</body>
</html>