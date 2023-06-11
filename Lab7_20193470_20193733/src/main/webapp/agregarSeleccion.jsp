<%@ page import="Beans.Estadio" %><%--
<%@ page import="Beans.Seleccion" %><%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 9/06/2023
  Time: 02:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.ArrayList" %>
<% ArrayList<Estadio> listaEstadios = (ArrayList<Estadio>) request.getAttribute("listaEstadios"); %>
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
                        Añade una nueva Selección:
                    </p>
                </div>
            </section>

            <div class="container my-5">
                <div class="row justify-content-center">
                    <div class="col-lg-6">
                        <form method="POST" action="SeleccionServlet?a=anadir" class="col-md-6 col-lg-6">
                            <h4 class="mb-4 mt-4">Ingrese los siguientes datos:</h4>
                                <label for="nombre">Nombre de selección:</label>
                                <input type="text" class="form-control form-control-sm" id="nombre" name="nombre" required><br>

                                <label for="tecnico">Técnico:</label>
                                <input type="text" class="form-control form-control-sm" id="tecnico" name="tecnico" required><br>

                                <label for="estadio">Estadio:</label>
                                <select id="estadio" name="estadio" required>
                                    <% for(Estadio estadio : listaEstadios) { %>
                                    <option value="<%=estadio.getIdEstadio()%>"><%=estadio.getNombre()%></option>
                                    <% } %>
                                </select><br>

                                <div class="row justify-content-center mt-4">
                                    <a href="<%= request.getContextPath()%>/SeleccionServlet" class="btn btn-danger">Cancelar</a>
                                    <input type="submit" value="Anadir" class="btn btn-primary"/>
                                </div>
                        </form>
                    </div>
                </div>
            </div>

            <!-- ***** Footer Area Start ***** -->
            <jsp:include page="/static/footer.jsp"/>
            <!-- ***** Footer Area End ***** -->

    </body>
</html>



