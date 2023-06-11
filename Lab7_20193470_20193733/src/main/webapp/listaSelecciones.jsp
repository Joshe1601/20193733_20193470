<%@ page import="Beans.Seleccion" %><%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 10/06/2023
  Time: 23:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.ArrayList" %>
<% ArrayList<Seleccion> listaSelecciones = (ArrayList<Seleccion>) request.getAttribute("listaSelecciones"); %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Lista de Selecciones</title>
    </head>
    <body>
        <h1>Lista de Selecciones</h1>
        <table>
            <tr>
                <th>ID</th>
                <th>Nombre</th>
                <th>Técnico</th>
                <th>Estadio</th>
                <th>Primer Partido</th>
            </tr>
            <%for (Seleccion seleccion : listaSelecciones) { %>
            <tr>
                <td><%= seleccion.getIdSeleccion() %></td>
                <td><%= seleccion.getNombre() %></td>
                <td><%= seleccion.getTecnico() %></td>
                <td><%= seleccion.getEstadio() %></td>
                <td><%= seleccion.getPrimerPartido() %></td>
            </tr>
            <%
                }
            %>
        </table>
    </body>
</html>
