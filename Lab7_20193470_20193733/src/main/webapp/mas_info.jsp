<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<jsp:include page="/static/head.jsp"/>
<body>
<div class="bgr-body">
  <!-- ***** Header Area Start ***** -->
  <jsp:include page="/includes/navbar.jsp">
    <jsp:param name="page" value="info"/>
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
  <h3>Más Información:</h3>
  <p class="styled-text">La Copa Mundial de la FIFA México/Estados Unidos/Canadá 2026 será la vigésima tercera edición de la Copa Mundial
    de Fútbol organizada por la FIFA, y se desarrollará del 9 de junio al 19 de julio de 2026 en Canadá, Estados Unidos
    y México. La sede triple fue escogida el 13 de junio de 2018, durante el 68.º Congreso de la FIFA en Moscú, Rusia.
    Es la primera vez que se otorga la sede a tres países, además, será la primera ocasión en que 48 selecciones se
    clasifiquen a la fase final, después de la decisión de la FIFA, promovida por Gianni Infantino, aprobada el 10 de
    enero de 2017, de elevar de 32 plazas a 48. </p>


  </div>
  <jsp:include page="/static/footer.jsp"/>
</body>
</html>