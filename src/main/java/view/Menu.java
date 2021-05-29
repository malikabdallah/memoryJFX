package view;

import controlleur.Controller;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.io.File;
public class Menu {

    private static Controller controlleur;

    public void lancerMusic(){
        AudioClip mApplause = new AudioClip(this.getClass().getResource("/avengers.mp3").toExternalForm());
        mApplause.play();
    }

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


    public void goToPlay(MouseEvent mouseEvent) throws FileNotFoundException {
        controlleur.goToJeu();
    }
}
