<%@ page import="Beans.Jugador" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<jsp:useBean type="java.util.ArrayList<Beans.Jugador>" scope="request" id="listaJugadores"/>
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
    <jsp:include page="/includes/background.jsp">
        <jsp:param name="bgr_text" value="Jugadores"/>
    </jsp:include>


    <div class="pt-4">
        <div class="row">
            <div class="col-lg-12 d-flex justify-content-end" >
                <a id="ocultar" class="btn btn-warning" href="<%=request.getContextPath()%>/mainservlet?action=agregar">Agregar nuevo jugador</a>
            </div>
        </div>
    </div>

    <div class="tabla">
        <table class="table table-dark table-transparent table-hover">
            <thead>
            <tr>
                <th>ID</th>
                <th>Nombre</th>
                <th>Edad</th>
                <th>Posición</th>
                <th>Club</th>
                <th>Nombre de selección</th>
            </tr>
            </thead>

            <%
                for (Jugador jugador : listaJugadores) {
            %>
                <tr>
                    <td><%= jugador.getIdJugador()%>
                    </td>
                    <td><%= jugador.getNombre()%>
                    </td>
                    <td><%= jugador.getEdad()%>
                    </td>
                    <td><%= jugador.getPosicion()%>
                    </td>
                    <td><%= jugador.getClub()%>
                    </td>
                    <td><%= jugador.getSeleccion().getNombre()%>
                    </td>

                <%
                    }
                %>

            </tr>
        </table>
    </div>
    <jsp:include page="/static/footer.jsp"/>
</div>
</body>
</html>