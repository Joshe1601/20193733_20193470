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
                <th>Nombre de selección</th>
                <th>Técnico</th>
                <th>Estadio</th>
                <th>Primer Partido</th>
            </tr>
            <%for (Seleccion seleccion : listaSelecciones) { %>
            <tr>
                <td><%= seleccion.getIdSeleccion() %></td>
                <td><%= seleccion.getNombre() %></td>
                <td><%= seleccion.getTecnico() %></td>
                <td><%= seleccion.getEstadio().getNombre() %></td>
                <td><%= seleccion.getPrimerPartido() %></td>
                <td>
                    <a class="btn btn-warning" href="<%=request.getContextPath()%>/SeleccionServlet?l=borrar&id=<%=seleccion.getIdSeleccion()%>" >Borrar</a>
                    <!--<button type="button" class="btn btn-warning">Warning</button>-->
                </td>
            </tr>
            <%
                }
            %>
            <a href="<%= request.getContextPath()%>/SeleccionServlet?l=agregar" class="btn btn-primary mb-4">Agregar nueva selección</a>
        </table>
    </body>
</html>
