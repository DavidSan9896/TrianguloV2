package presenter;

import model.TrianguloSierpinskiModel;
import view.TrianguloSierpinskiView;

import java.awt.*;

public class TrianguloSierpinskiPresenter {
    private TrianguloSierpinskiModel modelo;
    private TrianguloSierpinskiView vista;

    public TrianguloSierpinskiPresenter(TrianguloSierpinskiModel modelo, TrianguloSierpinskiView vista) {
        this.modelo = modelo;
        this.vista = vista;

        this.vista.setPresenter(this);
    }

    public void dibujar(Graphics g, int width, int height) {
        modelo.dibujar(g, width, height);
    }

    public void actualizarIteracion(int iteracion) {
        modelo.setIteracion(iteracion);
    }



}


