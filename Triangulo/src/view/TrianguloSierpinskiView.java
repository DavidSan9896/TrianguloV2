package view;

import presenter.TrianguloSierpinskiPresenter;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class TrianguloSierpinskiView extends JFrame {
    private TrianguloSierpinskiPresenter presenter;
    private JTextField iteracionTextField;
    private JPanel panel;

    public TrianguloSierpinskiView() {
        setTitle("Triángulo de Sierpinski");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel() {
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                int panelWidth = getWidth();
                int panelHeight = getHeight();

                Image image = createImage(panelWidth, panelHeight);
                Graphics imageGraphics = image.getGraphics();

                presenter.dibujar(imageGraphics, panelWidth, panelHeight);

                g.drawImage(image, 0, 0, null);
            }
        };





        JPanel controlPanel = new JPanel();

        JLabel iteracionLabel = new JLabel("Iteración:");
        iteracionTextField = new JTextField(10);
        JButton dibujarButton = new JButton("Dibujar");

        dibujarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String input = iteracionTextField.getText();
                if (input.matches("\\d+")) {
                    int iteracion = Integer.parseInt(input);
                    presenter.actualizarIteracion(iteracion);
                    panel.repaint();
                } else {
                    JOptionPane.showMessageDialog(panel, "Ingresa un número entero válido.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        controlPanel.add(iteracionLabel);
        controlPanel.add(iteracionTextField);
        controlPanel.add(dibujarButton);

        getContentPane().add(controlPanel, BorderLayout.SOUTH);
        getContentPane().add(panel, BorderLayout.CENTER);

        setPreferredSize(new Dimension(800, 800));
        pack();
    }

    public void setPresenter(TrianguloSierpinskiPresenter presenter) {
        this.presenter = presenter;
    }
}


