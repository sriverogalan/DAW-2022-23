<%--
  Created by IntelliJ IDEA.
  User: srive
  Date: 07/11/2022
  Time: 12:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="com.controlproductes.domain.Producte" %>
<%@ page import="java.util.List" %>
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
<%@include file="capçalera.jsp" %>
<body>
<div class="container-md">
    <%@include file="navegacio.jsp" %>
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
                <a href="controller?action=visualitza&id=<%= product.getId() %>"><%= product.getId() %>
                </a>
            </td>
            <td><%= product.getNom() %>
            </td>
            <td><%= product.getPreu() %>
            </td>
            <td><%= product.getDescripcio() %>
            </td>
            <td>
                <button type="button" class="btn btn-primary" data-bs-toggle="modal"
                        data-bs-target="#modal<%= product.getId() %>"
                        data-bs-whatever="@fat">Editar
                </button>

                <div class="modal fade" id="modal<%= product.getId() %>" tabindex="-1"
                     aria-labelledby="exampleModalLabel"
                     aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <form action="controller" method="post">
                                <div class="modal-body" style="color: black;">
                                    <label >Id :</label>
                                    <input type="text" name="id" value="<%= product.getId() %>" readonly> <br>

                                    <label >Nom :</label>
                                    <input type="text" name="nom" value="<%= product.getNom() %>"><br>

                                    <label>Descripcio :</label>
                                    <input type="text" name="descripcio" value="<%= product.getDescripcio() %>"><br>

                                    <label>Preu :</label>
                                    <input type="text" name="preu" value="<%= product.getPreu() %>"><br>

                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal"> Tancar </button>
                                    <input type="submit" class="btn btn-primary" value="Enviar">
                                </div>
                            </form>
                        </div>
                    </div>
                </div>

            </td>
            <td>
                <a class="btn btn-primary" href="controller?action=borrar&id=<%= product.getId() %>">Eliminar</a>
            </td>
        </tr>
            <% } %>
</div>
</tbody>
</table>
<%@include file="peu.jsp" %>
</body>
</html>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
        integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.min.js"
        integrity="sha384-IDwe1+LCz02ROU9k972gdyvl+AESN10+x7tBKgc9I5HFtuNz0wWnPclzo6p9vxnk"
        crossorigin="anonymous"></script>