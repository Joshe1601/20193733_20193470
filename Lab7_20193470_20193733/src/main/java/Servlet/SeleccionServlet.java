package Servlet;

import Daos.SeleccionDao;
import Daos.EstadioDao;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "SeleccionServlet", value = "/SeleccionServlet")
public class SeleccionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        SeleccionDao seleccionDao = new SeleccionDao();
        EstadioDao estadioDao = new EstadioDao();

        String action = request.getParameter("l") == null ? "listar" : request.getParameter("l");

        switch (action) {
            case "listar":
                request.setAttribute("listaSelecciones", seleccionDao.listarSelecciones());
                request.getRequestDispatcher("/listaSelecciones.jsp").forward(request, response);

                break;

            case "borrar":

                break;

            case "agregar":
                request.setAttribute("listaEstadios",estadioDao.listarEstadio());
                request.getRequestDispatcher("/agregarSeleccion.jsp").forward(request, response);

        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("a") == null ? "anadir" : request.getParameter("a");
    }
}
