<%--
  Created by IntelliJ IDEA.
  User: Jaime
  Date: 20/05/2014
  Time: 10:54 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java"
         contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML
4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type"
          content="text/html; charset=UTF-8">
    <title>Menu</title>
</head>
<body>
<h2>Pagina inicial de la lista de
    cuentas</h2>
<p> Bienvenido,
    ${usuarioLogueado.login} </p>
<a href="listarCuentas">Clic aquí</a>
para acceder a la lista de cuentas.
</body>
</html>
