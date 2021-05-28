package view;

import controlleur.Controller;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Card;
import model.CustomImage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Random;

public class Jeu {


    @FXML
    private VBox boxes;
    public Jeu() {
    }

    private Controller controlleur;

    public  Jeu creerEtAfficher(Controller c, Stage primaryStage) throws FileNotFoundException {
        GridPane root = new GridPane();

        byte[] imgs = new byte[10];
        Random rnd = new Random();

        ColorAdjust adjust = new ColorAdjust();
        adjust.setBrightness(-0.25);
        VBox vBox=new VBox();
        //vBox.getChildren().add(new Card("ima"));

        for(int j=0;j<=4;j++){
            HBox hBox=new HBox();

            for(int i=0;i<=5;i++){
                String s=new String("image"+0+".png");

                ImageView iv = new ImageView(new Image("image0.png", 150, 100, true, true));

                /*
                System.out.println("r="+this.getClass().getClassLoader().getResource("image0.jpg")
                );
                Card card=new Card("/img/image0.png");

                 */
                CustomImage customImage=new CustomImage(1,2,"/img/image0.png");
                Card card=new Card("/img/image0.png");
                card.setFitHeight(100);
                card.setFitWidth(150);
                card.setPreserveRatio(true);

                card.setOnMouseClicked(x -> {
                    if(card.isFlipped()){
                        return;
                    }
                    card.flip();


                });
                //FileInputStream input = new FileInputStream(s);
                //Image image = new Image(input);
                //ImageView imageView = new ImageView(image);
               // iv.setFitHeight(100);
                hBox.setPadding(new Insets(10,10,1,10));
                hBox.setSpacing(10);


                hBox.getChildren().add(card);
                //cards.add(imageView);
            }

            vBox.getChildren().add(hBox);
        }





        root.add(vBox,0,0);

        primaryStage.setTitle("Easy Memory Puzzle");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
        return new Jeu();
    }
}
