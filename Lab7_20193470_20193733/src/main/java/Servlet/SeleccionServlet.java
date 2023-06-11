package Servlet;

import Daos.SeleccionDao;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "SeleccionServlet", value = "/SeleccionServlet")
public class SeleccionServlet extends HttpServlet {
    private SeleccionDao seleccionDao;

    @Override
    public void init() throws ServletException {
        super.init();
        // Inicializar el DAO de Selección
        seleccionDao = new SeleccionDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        SeleccionDao seleccionDao = new SeleccionDao();
        //EstadioDao estadioDao = new EstadioDao();

        request.setAttribute("listaSelecciones", seleccionDao.listarSelecciones());

        // Redirigir a la página JSP para mostrar las selecciones
        request.getRequestDispatcher("/listaSelecciones.jsp").forward(request, response);
    }
}
