<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<jsp:include page="/static/head.jsp"/>
<body>
<!-- ***** Header Area Start ***** -->
<jsp:include page="/includes/navbar.jsp">
  <jsp:param name="page" value="jugadores"/>
</jsp:include>
<!-- ***** Header Area End ***** -->
<h1><%= "Esto es una prueba" %></h1>

<div class="tabla">
  <table class="table table-dark table-transparent table-hover">
    <thead>
    <th>Nombre</th>
    <th>Jugador</th>
    <th>Club</th>
    </thead>

    <tr>
      <td>Acá
      </td>
      <td>Se colocan
      </td>
      <td>Los datos
      </td>

    </tr>
  </table>
</div>
<br/>
<a href="hello-servlet">Hello Servlet</a>
</body>
</html>