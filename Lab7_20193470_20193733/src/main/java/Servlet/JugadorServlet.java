package Servlet;

import Daos.JugadorDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "JugadorServlet", urlPatterns = {"/JugadorServlet"})
public class JugadorServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action") == null ? "listar" : request.getParameter("action");

        RequestDispatcher view;
        JugadorDao jugadorDao = new JugadorDao();
        //no se xq no sale el dao
        //SeleccionDao seleccionDao = new SeleccionDao();

        switch (action) {
            case "listar":
                request.setAttribute("listaJugadores", jugadorDao.listarJugadores());
                view = request.getRequestDispatcher("listaJugadores.jsp");
                view.forward(request, response);
                break;

            case "agregar":
                //request.setAttribute("listaJugadores", JugadorDao.listarJugadores());
                view = request.getRequestDispatcher("agregarJugador.jsp");
                view.forward(request, response);
                break;
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String action = request.getParameter("action") == null ? "lista" : request.getParameter("action");

        JugadorDao jugadorDao = new JugadorDao();
        //Jugador jugador = setJugadorData(request);

        switch (action) {
            case "guardar":
                //jugadorDao.crearJugador(jugador);

                response.sendRedirect("JugadorServlet");
                break;
        }
    }
}
