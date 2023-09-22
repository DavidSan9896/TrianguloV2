package model;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class TrianguloSierpinskiModel {
    private int iteracion;

    public TrianguloSierpinskiModel() {
        this.iteracion = 0;
    }

    public int getIteracion() {
        return iteracion;
    }

    public void setIteracion(int iteracion) {
        this.iteracion = iteracion;
    }


    public void dibujar(Graphics g, int width, int height) {
        int lado = width/2;
        int x = (width - lado) / 2;
        int y = (height + lado) / 2;

        dibujarTrianguloSierpinski(g, x, y, lado, iteracion);
    }

    private void dibujarTrianguloSierpinski(Graphics g, int x, int y, int lado, int iteracion) {
        if (iteracion <= 0) {
            int[] xPoints = {x, x + lado / 2, x + lado};
            int[] yPoints = {y, y - lado, y};
            g.fillPolygon(xPoints, yPoints, 3);
        } else {
            int nuevoLado = lado / 2;
            dibujarTrianguloSierpinski(g, x, y, nuevoLado, iteracion - 1);
            dibujarTrianguloSierpinski(g, x + nuevoLado, y, nuevoLado, iteracion - 1);
            dibujarTrianguloSierpinski(g, x + nuevoLado / 2, y - nuevoLado, nuevoLado, iteracion - 1);
        }
    }
    public int getLado(int panelWidth, int panelHeight) {
        return Math.min(panelWidth, panelHeight) - 20;
    }



}

