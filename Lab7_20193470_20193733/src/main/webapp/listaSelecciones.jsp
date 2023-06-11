<%@ page import="Beans.Seleccion" %><%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 10/06/2023
  Time: 23:20
  To change this template use File | Settings | File Templates.
--%>
<jsp:useBean type="java.util.ArrayList<Beans.Seleccion>" scope="request" id="listaSelecciones"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<<html>
<jsp:include page="/static/head.jsp"/>
<body>
<div class="bgr-body">
    <!-- ***** Header Area Start ***** -->
    <jsp:include page="/includes/navbar.jsp">
        <jsp:param name="page" value="selecciones"/>
    </jsp:include>
    <!-- ***** Header Area End ***** -->

    <!-- ***** Background Area Start ***** -->
    <section id="infinite">
        <div class="img-container">
            <h2 class="img-title">Clasificatorias Sudamericanas Mundial 2026</h2>
            <p class="img-subtitle">
                Lista de selecciones disponibles:
            </p>
        </div>
    </section>
    <!-- ***** Background Area End ***** -->


    <div class="pt-4">
        <div class="row">
            <div class="col-lg-12 d-flex justify-content-end" >
                <a id="ocultar" class="btn btn-warning" href="<%=request.getContextPath()%>/SeleccionServlet?action=agregar">Agregar nueva selección</a>
            </div>
        </div>
    </div>

    <div class="tabla">
        <table class="table table-dark table-transparent table-hover">
            <thead>
            <tr>
                <th>ID</th>
                <th>Nombre de selección</th>
                <th>Técnico</th>
                <th>Estadio</th>
                <th>Primer Partido</th>
            </tr>
            </thead>

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


    <jsp:include page="/static/footer.jsp"/>
</div>
    </body>
</html>
