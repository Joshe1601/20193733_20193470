package Servlet;

import Beans.Jugador;
import Beans.Seleccion;
import Daos.JugadorDao;
import Daos.SeleccionDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "MainServlet", urlPatterns = {"/mainservlet"})
public class MainServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action") == null ? "listar" : request.getParameter("action");

        RequestDispatcher view;
        JugadorDao jugadorDao = new JugadorDao();
        SeleccionDao seleccionDao = new SeleccionDao();

        switch (action) {
            case "listar":
                request.setAttribute("listaJugadores", jugadorDao.listarJugadores());
                view = request.getRequestDispatcher("listaJugadores.jsp");
                view.forward(request, response);
                break;

            case "agregar":
                request.setAttribute("listaSelecciones", seleccionDao.listarSelecciones());
                view = request.getRequestDispatcher("agregarJugador.jsp");
                view.forward(request, response);
                break;

            case "info":
                view = request.getRequestDispatcher("/mas_info.jsp");
                view.forward(request,response);
                break;
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String action = request.getParameter("action") == null ? "listar" : request.getParameter("action");

        JugadorDao jugadorDao = new JugadorDao();
        //Jugador jugador = setJugadorData(request);

        switch (action) {
            case "guardar":
                Jugador jugador = new Jugador();
                String nombre = request.getParameter("nombre_jugador");

                jugador.setNombre(nombre);
                jugador.setEdad(Integer.parseInt(request.getParameter("edad")));
                jugador.setPosicion(request.getParameter("posicion"));
                jugador.setClub(request.getParameter("club"));

                Seleccion seleccion = new Seleccion();
                seleccion.setIdSeleccion(Integer.parseInt(request.getParameter("listaSelecciones")));
                /*Dejo este espacio por si falta rellenar!!*/
                jugador.setSeleccion(seleccion);



                Jugador Jugador = jugadorDao.obtenerJugador(nombre);
                if(Jugador == null){
                    jugadorDao.crearJugador(jugador);
                    response.sendRedirect(request.getContextPath() + "/mainservlet");
                } else {
                    response.sendRedirect(request.getContextPath() + "/mainservlet?action=agregar");

                }


                break;
        }
    }
}
