<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 9/06/2023
  Time: 02:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="Beans.Jugador" %>
<%@ page import="Beans.Seleccion" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<jsp:useBean id="listaSelecciones" type="java.util.ArrayList<Beans.Seleccion>" scope="request"/>
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
                        <form method="POST" action="<%=request.getContextPath()%>/mainservlet?action=guardar">
                            <h4 class="mb-4 mt-4">Ingrese los siguientes datos:</h4>
                            <div class="form-group">
                                <h5>Nombre del jugador:</h5>
                                <input type="text" class="form-control mb-3" aria-label="nombre_jugador" id="nombre_jugador" name="nombre_jugador" required>
                            </div>
                            <div class="form-group">
                                <div class="row">
                                    <div class="col">
                                        <h5>Edad:</h5>
                                        <input type="number" class="form-control mb-3" id="edad" name="edad" aria-label="edad" min="0" required>
                                    </div>
                                    <div class="col">
                                        <h5>Posición:</h5>
                                        <input type="text" class="form-control mb-3" id="posicion" name="posicion" aria-label="posicion" required>
                                    </div>
                                    <div class="col">
                                        <h5>Club:</h5>
                                        <input type="text" id="club" name="club" aria-label="club" class="form-control mb-3" required>
                                    </div>
                                </div>

                                <div class="row">
                                    <div class="col">
                                        <h5>Selecciones:</h5>
                                        <select class="form-control mb-3" aria-label="listaSelecciones" id="listaSelecciones" name="listaSelecciones" required>
                                            <option disabled selected>Elige una selección</option>
                                            <% for (Seleccion seleccion : listaSelecciones) { %>
                                            <option value="<%= seleccion.getIdSeleccion()%>"><%= seleccion.getNombre()%></option>
                                            <% } %>
                                        </select>
                                    </div>
                                </div>
                            </div>
                            <div class="row justify-content-center mt-4">
                                <button type="submit" class="btn btn-primary">Añadir jugador</button>
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
</html>
