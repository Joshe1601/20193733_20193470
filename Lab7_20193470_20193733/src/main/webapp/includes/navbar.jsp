<%--
  Created by IntelliJ IDEA.
  User: Usuario
  Date: 8/06/2023
  Time: 20:46
  To change this template use File | Settings | File Templates.
--%>
<%--
  Created by IntelliJ IDEA.
  User: Usuario
  Date: 8/06/2023
  Time: 11:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<header class="header-area header-sticky">
    <div class="container">
        <div class="row">
            <div class="col-12">
                <nav class="main-nav">
                    <!-- ***** Logo Start ***** -->
                    <ul class="header-logo--company">
                        <li><a href="index.html"><img src="<%=request.getContextPath()%>/assets/images/logo-FIFA.png" alt="logo" class = logo-imagen style="width: 75px"></a>
                        </li>
                        <li>
                            <span class="company-logo--vertical-separator"></span>
                        </li>
                        <li>
                            <img src="<%=request.getContextPath()%>/assets/images/conmebol_logo_1.png" alt="logo" class="logo-imagen" style="width: 60px">

                        </li>
                    </ul>

                    <!-- ***** Logo End ***** -->
                    <!-- ***** Menu Start ***** -->
                    <ul class="nav">
                        <li><a class="<%=request.getParameter("page").equals("jugadores")? "active": "" %>" href="<%=request.getContextPath()%>/mainservlet">Jugadores</a></li>
                        <li><a class="<%=request.getParameter("page").equals("selecciones")? "active": "" %>" href="<%=request.getContextPath()%>/SeleccionServlet">Selecciones</a></li>
                        <li><a class="<%=request.getParameter("page").equals("info")? "active": "" %>" href="<%=request.getContextPath()%>/mainservlet?action=info">Más información</a></li>
                    </ul>
                    <!-- Se añadirá el menú de desplazamiento luego
                    <a class='menu-trigger'>
                        <span>Menu</span>
                    </a>
                    -->
                    <!-- ***** Menu End ***** -->
                </nav>
            </div>
        </div>
    </div>
</header>