<%--
  Created by IntelliJ IDEA.
  User: srive
  Date: 07/11/2022
  Time: 12:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="com.controlproductes.domain.Producte" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
  
</head>
<body>
<h1>Productes:</h1>
<table>
  <tr>
    <th>Id</th>
    <th>Nom</th>
    <th>Preu</th>
    <th>Descripcio</th>
  </tr>
    <% List<Producte> products = (List<Producte>) request.getAttribute("productList");
    for (Producte product : products) { %>
  <tr>
    <td><%= product.getId() %></td>
    <td><%= product.getNom() %></td>
    <td><%= product.getPreu() %></td>
    <td><%= product.getDescripcio() %></td>
  </tr>
    <% } %>
</body>
</html>