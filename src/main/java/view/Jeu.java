package view;

import controlleur.Controller;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
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
    private Card selectedCard;

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
        for(int i=0;i<=7;i++){

            Card card=new Card("/img/image"+String.valueOf(i)+".png");
            card.setFitHeight(120);
            card.setFitWidth(170);
            card.setPreserveRatio(true);
            cards.add(card);

            Card card2=new Card("/img/image"+String.valueOf(i)+".png");
            card2.setFitHeight(120);
            card2.setFitWidth(170);
            card2.setPreserveRatio(true);
            cards.add(card2);

        }

        Collections.shuffle(cards);





        for(int j=0;j<=3;j++){
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



                Card card=new Card("/img/image"+String.valueOf(7)+".png");
                card.setFitHeight(100);
                card.setFitWidth(150);
                card.setPreserveRatio(true);

                 */
                Card card=cards.get(cpt);

                card.setOnMouseExited(x -> {
                    try {
                        Thread.sleep(    100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if(selectedCard != card && !card.isFlipped())
                        card.hide();
                    card.setEffect(null);

                });
                card.setOnMouseClicked(x -> {
                    if(card.isFlipped()){
                        return;
                    }
                    if(selectedCard != null && !selectedCard.isFlipped()) {
                        if (selectedCard != card && selectedCard.equals(card)) {
                            selectedCard.flip();
                            card.flip();
                        } else {
                            card.show();

                            //card.setEffect(null);
                            selectedCard.hide();
                            selectedCard.setEffect(null);
                            selectedCard = null;

                        }
                    } else {
                        selectedCard = card;
                        selectedCard.show();
                    }

                });



                //FileInputStream input = new FileInputStream(s);
                //Image image = new Image(input);
                //ImageView imageView = new ImageView(image);
               // iv.setFitHeight(100);
                hBox.setPadding(new Insets(10,10,1,40));
                hBox.setSpacing(10);
                hBox.setAlignment(Pos.CENTER);


                hBox.getChildren().add(card);
                cpt++;
                //cards.add(imageView);
            }

            vBox.getChildren().add(hBox);
        }







        vBox.setAlignment(Pos.CENTER);

        root.add(vBox,0,0);

        primaryStage.setTitle("Easy Memory Puzzle");
        primaryStage.setWidth(550);
        primaryStage.setHeight(600);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
        return new Jeu();
    }
}
