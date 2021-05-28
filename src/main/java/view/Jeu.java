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
import java.util.*;

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
        int cpt=0;
        List<Card>cards=new ArrayList<>();
        for(int i=0;i<=5;i++){

            Card card=new Card("/img/image"+String.valueOf(i)+".png");
            card.setFitHeight(100);
            card.setFitWidth(150);
            card.setPreserveRatio(true);
            cards.add(card);

            Card card2=new Card("/img/image"+String.valueOf(i)+".png");
            card2.setFitHeight(100);
            card2.setFitWidth(150);
            card2.setPreserveRatio(true);
            cards.add(card2);

        }

        //Collections.shuffle(cards);





        for(int j=0;j<=2;j++){
            HBox hBox=new HBox();

            for(int i=0;i<=3;i++){
                /*
                String s=new String("image"+0+".png");

                ImageView iv = new ImageView(new Image("image0.png", 150, 100, true, true));
                CustomImage customImage=new CustomImage(1,2,"/img/image0.png");
                Card card=new Card("/img/image0.png");
                card.setFitHeight(100);
                card.setFitWidth(150);
                card.setPreserveRatio(true);

                 */
                Card card=cards.get(cpt);
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
                cpt++;
                //cards.add(imageView);
            }

            vBox.getChildren().add(hBox);
        }


        HBox hbox2=new HBox();
        Card card=new Card("/img/image"+String.valueOf(6)+".png");
        card.setFitHeight(100);
        card.setFitWidth(150);
        card.setPreserveRatio(true);
        card.setOnMouseClicked(x -> {
            if(card.isFlipped()){
                return;
            }
            card.flip();


        });
        Card card2=new Card("/img/image"+String.valueOf(6)+".png");
        card2.setFitHeight(100);
        card2.setFitWidth(150);
        card2.setPreserveRatio(true);
        card2.setOnMouseClicked(x -> {
            if(card2.isFlipped()){
                return;
            }
            card2.flip();


        });
        hbox2.getChildren().add(card);
        hbox2.getChildren().add(card2);
        hbox2.setPadding(new Insets(10,10,1,10));
        hbox2.setSpacing(10);



        vBox.getChildren().add(hbox2);

        root.add(vBox,0,0);

        primaryStage.setTitle("Easy Memory Puzzle");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
        return new Jeu();
    }
}
