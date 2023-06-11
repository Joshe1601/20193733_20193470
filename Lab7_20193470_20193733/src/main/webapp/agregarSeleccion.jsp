<%@ page import="Beans.Estadio" %><%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 9/06/2023
  Time: 02:38
  To change this template use File | Settings | File Templates.
--%>
<<<<<<< HEAD
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
=======
<%@ page import="Beans.Jugador" %>
<%@ page import="Beans.Seleccion" %>
<%@ page import="Beans.Estadio" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<jsp:useBean id="listaEstadios" type="java.util.ArrayList<Beans.Estadio>" scope="request"/>
<!DOCTYPE html>
<html>
<jsp:include page="/static/head.jsp"/>
<body>
<div class="bgr-body">
    <!-- ***** Header Area Start ***** -->
    <jsp:include page="/includes/navbar.jsp">
        <jsp:param name="page" value="jugadores"/>
    </jsp:include>
    <!-- ***** Header Area End ***** -->

    <!-- ***** Background Area Start ***** -->
    <section id="infinite">
        <div class="img-container">
            <h2 class="img-title">Clasificatorias Sudamericanas Mundial 2026</h2>
            <p class="img-subtitle">
                Añade un nuevo jugador:
            </p>
        </div>
    </section>
    <!-- ***** Background Area End ***** -->

    <div class="container my-5">
        <div class="row justify-content-center">
            <div class="col-lg-6">
                <form method="POST" action="<%=request.getContextPath()%>/SeleccionServlet?action=guardar">
                    <h4 class="mb-4 mt-4">Ingrese los siguientes datos:</h4>
                    <div class="form-group">
                        <h5>Nombre de la selección:</h5>
                        <input type="text" class="form-control mb-3" aria-label="nombre_selección" id="nombre_selección" name="nombre_selección" required>
                    </div>
                    <div class="form-group">
                        <h5>Nombre del técnico:</h5>
                        <input type="text" class="form-control mb-3" aria-label="nombre_tecnico" id="nombre_tecnico" name="nombre_tecnico" required>
                    </div>
                    <div class="form-group">
                        <div class="row">
                            <div class="col">
                                <h5>Selecciones:</h5>
                                <select class="form-control mb-3" aria-label="listaEstadios" id="listaEstadios" name="listaEstadios" required>
                                    <option disabled selected>Elige un Estadio</option>
                                    <% for (Estadio estadio : listaEstadios) { %>
                                    <option value="<%= estadio.getIdEstadio()%>"><%= estadio.getNombre()%></option>
                                    <% } %>
                                </select>
                            </div>
                        </div>
                    </div>
                    <div class="row justify-content-center mt-4">
                        <button type="submit" class="btn btn-primary">Añadir selección</button>
                    </div>
                </form>
            </div>
        </div>
    </div>


    <!-- ***** Footer Area Start ***** -->
    <jsp:include page="/static/footer.jsp"/>
    <!-- ***** Footer Area End ***** -->
</div>
</body>
>>>>>>> a4ddbe195d911c9c3afda26c9c31544c823b2c22
</html>
