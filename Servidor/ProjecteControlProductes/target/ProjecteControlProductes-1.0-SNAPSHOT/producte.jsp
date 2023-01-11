<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: SERGI
  Date: 08/11/2022
  Time: 22:46
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.controlproductes.domain.Producte" %>
<html>
<head>
    <fmt:setLocale value = "es_ES"/>
    <title>Visualitza Producte</title>
</head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
        crossorigin="anonymous"></script>
<body>
<%@include file="capçalera.jsp" %>
<div class="container">
    <% Producte product = (Producte) request.getAttribute("product"); %>
    <p class="text-center">Id : <%= product.getId() %>
    </p>
    <p class="text-center">Nom : <%= product.getNom() %>
    </p>
    <p class="text-center">Descripcio : <%= product.getDescripcio() %>
    </p>
    <p class="text-center">Preu :
    <td> <fmt:formatNumber value="<%= product.getPreu() %>" type="currency" currencySymbol="€"
                           currencyCode="EUR"/>
    </td>
    </p>
    <a href="controller?action=llistar" class="text-center btn btn-danger">Tornar</a>
</div>
</body>
</html>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
        integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.min.js"
        integrity="sha384-IDwe1+LCz02ROU9k972gdyvl+AESN10+x7tBKgc9I5HFtuNz0wWnPclzo6p9vxnk"
        crossorigin="anonymous"></script>
