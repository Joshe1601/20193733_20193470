package Beans;

import java.time.LocalDate;

public class Partido {
    private int idPartido;
    private LocalDate fecha;
    private int seleccionLocal;
    private int seleccionVisitante;
    private int arbitro;

    public int getIdPartido() {
        return idPartido;
    }

    public void setIdPartido(int idPartido) {
        this.idPartido = idPartido;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public int getSeleccionLocal() {
        return seleccionLocal;
    }

    public void setSeleccionLocal(int seleccionLocal) {
        this.seleccionLocal = seleccionLocal;
    }

    public int getSeleccionVisitante() {
        return seleccionVisitante;
    }

    public void setSeleccionVisitante(int seleccionVisitante) {
        this.seleccionVisitante = seleccionVisitante;
    }

    public int getArbitro() {
        return arbitro;
    }

    public void setArbitro(int arbitro) {
        this.arbitro = arbitro;
    }
}
