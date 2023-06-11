<%@ page import="Beans.Estadio" %><%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 10/06/2023
  Time: 23:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.ArrayList" %>
<% ArrayList<Estadio> listaEstadios = (ArrayList<Estadio>) request.getAttribute("listaEstadios"); %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Agregar Selección</title>
    </head>
    <body>
        <h1>Agregar Selección</h1>
        <form method="post" action="agregarSeleccion" >
            <label for="nombre">Nombre de selección:</label>
            <input type="text" id="nombre" name="nombre" required><br>

            <label for="tecnico">Técnico:</label>
            <input type="text" id="tecnico" name="tecnico" required><br>

            <label for="estadio">Estadio:</label>
            <select id="estadio" name="estadio" required>
                <% for(Estadio estadio : listaEstadios) { %>
                <option value="<%=estadio.getIdEstadio()%>"><%=estadio.getNombre()%></option>
                <% } %>
            </select><br>

            <div>
                <input type="submit" value="Anadir">
            </div>
        </form>
    </body>
</html>
