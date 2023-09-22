package run;

import model.TrianguloSierpinskiModel;
import presenter.TrianguloSierpinskiPresenter;
import view.TrianguloSierpinskiView;

public class Main {
    public static void main(String[] args) {
        TrianguloSierpinskiModel model = new TrianguloSierpinskiModel();
        TrianguloSierpinskiView view = new TrianguloSierpinskiView();
        TrianguloSierpinskiPresenter presenter = new TrianguloSierpinskiPresenter(model, view);

        view.setVisible(true);
    }
}
