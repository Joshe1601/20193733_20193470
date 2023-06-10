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
<section id="infinite" class="text-white tm-font-big tm-parallax">
  <div class="text-center tm-hero-text-container">
    <div class="tm-hero-text-container-inner">
      <h2 class="tm-hero-title">Infinite Loop</h2>
      <p class="tm-hero-subtitle">
        Bootstrap 4.0 Parallax Theme
        <br>Free HTML Template by TOOPLATE
      </p>
    </div>
  </div>
</section>


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