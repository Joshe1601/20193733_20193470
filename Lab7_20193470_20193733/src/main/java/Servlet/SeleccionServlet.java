package Servlet;

import Beans.Seleccion;
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
                if (request.getParameter("id") != null) {
                    String idSeleccion_str = request.getParameter("id");
                    int idSeleccion = 0;
                    try {
                        idSeleccion = Integer.parseInt(idSeleccion_str);
                    } catch (NumberFormatException ex) {
                        response.sendRedirect("SeleccionServlet");
                    }

                    Seleccion seleccion = seleccionDao.mostrar(idSeleccion);
                    if (seleccion != null) {
                        seleccionDao.borrar(idSeleccion);
                    }
                }
                response.sendRedirect("SeleccionServlet");
                break;

            case "agregar":
                request.setAttribute("listaEstadios",estadioDao.listarEstadio());
                request.getRequestDispatcher("/agregarSeleccion.jsp").forward(request, response);

        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        SeleccionDao seleccionDao = new SeleccionDao();
        Seleccion seleccion = setSeleccionData(request);
        String action = request.getParameter("a") == null ? "anadir" : request.getParameter("a");

        switch(action) {
            case "anadir":
                seleccionDao.anadir(seleccion);
                response.sendRedirect("SeleccionServlet");
                break;
        }
    }

    private Seleccion setSeleccionData(HttpServletRequest request) {
        Seleccion seleccion = new Seleccion();

        seleccion.setNombre(request.getParameter("nombre"));
        seleccion.setTecnico(request.getParameter("tecnico"));
        seleccion.setIdSeleccion(Integer.parseInt(request.getParameter("estadio")));

        return seleccion;
    }
}
