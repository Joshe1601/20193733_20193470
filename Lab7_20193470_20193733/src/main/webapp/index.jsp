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
  <!-- ***** Background Area Emd ***** -->



  <div class="tabla">
    <table class="table table-dark table-transparent table-hover">
      <thead>
      <th>ID</th>
      <th>Nombre</th>
      <th>Edad</th>
      <th>Posición</th>
      <th>Club</th>
      <th>Nombre de selección</th>
      </thead>

      <tr>
        <td>Acá
        </td>
        <td>Se colocan
        </td>
        <td>Los datos
        </td>
        <td>Los datos
        </td>
        <td>Los datos
        </td>
        <td>Los datos
        </td>


      </tr>
    </table>
  </div>
  <jsp:include page="/static/footer.jsp"/>
</div>
</body>
</html>