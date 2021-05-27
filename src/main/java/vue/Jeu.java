package vue;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import main.Controller;
import model.Card;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;

public class Jeu {

    @FXML
    private VBox boxes;


    private static Controller controlleur;

    public static Jeu creerEtAfficher(Controller c, Stage laStageUnique) throws FileNotFoundException {
        URL location = Jeu.class.getResource("/jeu.fxml");
        FXMLLoader fxmlLoader = new FXMLLoader(location);
        Parent root = null;
        try {
            root = fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Jeu vue = fxmlLoader.getController();
        laStageUnique.setTitle("MENU");
        assert root != null;

        controlleur=c;
        ColorAdjust adjust = new ColorAdjust();
        adjust.setBrightness(-0.25);
        VBox vBox=new VBox();
        vBox.getChildren().add(new Card("ima"));

        for(int j=0;j<=4;j++){
            HBox hBox=new HBox();

            for(int i=0;i<=5;i++){
                String s=new String("/imgs/image"+i+".png");
                FileInputStream input = new FileInputStream(s);
                Image image = new Image(input);
                ImageView imageView = new ImageView(image);
                imageView.setFitHeight(100);
                hBox.setPadding(new Insets(10,10,1,10));
                hBox.setSpacing(10);


                hBox.getChildren().add(imageView);
                //cards.add(imageView);
            }

            vBox.getChildren().add(hBox);
        }



        laStageUnique.setScene(new Scene(root, 750, 400));
        laStageUnique.show();
        return vue;
    }
}
