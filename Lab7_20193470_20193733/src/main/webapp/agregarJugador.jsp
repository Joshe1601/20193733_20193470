<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 9/06/2023
  Time: 02:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="Beans.Jugador" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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
            <jsp:include page="/includes/background.jsp">
                <jsp:param name="bgr_text" value="Jugadores"/>
            </jsp:include>
            <!-- ***** Background Area End ***** -->

            <form method="POST" action="<%=request.getContextPath()%>/mainservlet?action=guardar">
                <div class = "row">
                    <div class="form-group">
                        <h5>Ingrese nombre del jugador:</h5>
                        <input type="text" class="form-control" aria-label="nombre_jugador" id="nombre" name="nombre" required>
                    </div>

                    <div class="form-group">
                        <div class="row">
                            <div class="col">
                                <h5>Edad:</h5>
                                <input type="number" class="form-control" id="edad" name="edad" aria-label="edad" min="0" required>
                            </div>
                            <div class="col">
                                <h5>Posición:</h5>
                                <input type="text" class="form-control" id="posicion" name="posicion" aria-label="posicion" required>
                            </div>
                            <div class="col">
                                <h5>Club:</h5>
                                <input type="text" id="club" name="club" aria-label="club" class="form-control" required>
                            </div>
                        </div>
                        
                    </div>

                </div>
            </form>

            <!-- ***** Footer Area Start ***** -->
            <jsp:include page="/static/footer.jsp"/>
            <!-- ***** Footer Area End ***** -->
        </div>
    </body>
</html>
