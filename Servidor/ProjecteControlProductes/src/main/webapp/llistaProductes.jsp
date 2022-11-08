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
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
            crossorigin="anonymous"></script>
</head>
<body>
<h1>Productes:</h1>
<table class="table table-dark table-striped">
    <thead>
    <tr>
        <th>Id</th>
        <th>Nom</th>
        <th>Preu</th>
        <th>Descripcio</th>
        <th>Editar</th>
        <th>Eliminar</th>
    </tr>
    </thead>
    <tbody>
    <% List<Producte> products = (List<Producte>) request.getAttribute("productList");
        for (Producte product : products) { %>
    <tr>
        <td>
            <a href="controller?action=visualitza?id=<%= product.getId() %>"><%= product.getId() %>
            </a>
        </td>
        <td><%= product.getNom() %>
        </td>
        <td><%= product.getPreu() %>
        </td>
        <td><%= product.getDescripcio() %>
        </td>

        <td>
            <a class="btn btn-primary" href="controller?action=editProduct?id=<%= product.getId() %>">Editar</a>
        </td>
        <td>
            <a class="btn btn-primary" href="controller?action=deleteProduct?id=<%= product.getId() %>">Eliminar</a>
        </td>
    </tr>
    <% } %>
    </tbody>
</table>


<a href="controller?action=insertProduct" class="btn btn-primary">
        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-plus-square"
             viewBox="0 0 16 16">
            <path d="M14 1a1 1 0 0 1 1 1v12a1 1 0 0 1-1 1H2a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1h12zM2 0a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2H2z"/>
            <path d="M8 4a.5.5 0 0 1 .5.5v3h3a.5.5 0 0 1 0 1h-3v3a.5.5 0 0 1-1 0v-3h-3a.5.5 0 0 1 0-1h3v-3A.5.5 0 0 1 8 4z"/>
        </svg>
</a>
</body>
</html>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
        integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.min.js"
        integrity="sha384-IDwe1+LCz02ROU9k972gdyvl+AESN10+x7tBKgc9I5HFtuNz0wWnPclzo6p9vxnk"
        crossorigin="anonymous"></script>