package vue;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import sample.Controller;

import java.io.IOException;
import java.net.URL;

public class Menu {

    private static Controller controlleur;

    public static Menu creerEtAfficher(Controller c, Stage laStageUnique) {
        URL location = Menu.class.getResource("/menu.fxml");
        FXMLLoader fxmlLoader = new FXMLLoader(location);
        Parent root = null;
        try {
            root = fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Menu vue = fxmlLoader.getController();
        laStageUnique.setTitle("MENU");
        assert root != null;
        laStageUnique.setScene(new Scene(root, 750, 400));
        laStageUnique.show();
        controlleur=c;
        return vue;
    }

    public void jouer(MouseEvent mouseEvent) {
        controlleur.goToJeu();
    }
}
