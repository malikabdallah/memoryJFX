package view;

import controlleur.Controller;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Card;

import java.io.FileNotFoundException;
import java.util.*;

public class Jeu {

    public Button btnplayagain;
    private Card selectedCard;

    public Jeu() {
    }

    private Controller controlleur;
    List<Card>cards=new ArrayList<>();

    public  Jeu creerEtAfficher(Controller c, Stage primaryStage) throws FileNotFoundException {
        GridPane root = new GridPane();
        VBox vBox=new VBox();
        int cpt=0;
        controlleur=c;
        this.cards=new ArrayList<>();
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
                Card card=cards.get(cpt);
                card.setOnMouseExited(x -> {
                    try {
                        Thread.sleep(    100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if(selectedCard != card && !card.isFlipped())
                        card.hide();

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
                            selectedCard.hide();
                            selectedCard = null;

                        }
                    } else {
                        selectedCard = card;
                        selectedCard.show();
                    }
                    if(checkAll()){
                      btnplayagain.setVisible(true);
                         }

                });

                hBox.setPadding(new Insets(10,10,1,40));
                hBox.setSpacing(10);
                hBox.setAlignment(Pos.CENTER);
                hBox.getChildren().add(card);
                cpt++;
            }

            vBox.getChildren().add(hBox);
        }
        btnplayagain=new Button();
        btnplayagain.setText(" play again");
        btnplayagain.setPadding(new Insets(10,10,10,10));
        btnplayagain.setVisible(false);
        btnplayagain.setOnMouseClicked(mouseEvent->{
            try {
                this.controlleur.playAgain();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        });
        vBox.getChildren().add(btnplayagain);

        vBox.setAlignment(Pos.CENTER);
        root.add(vBox,0,0);
        primaryStage.setTitle("Avengers Memory");
        primaryStage.setWidth(600);
        primaryStage.setHeight(600);
        primaryStage.setScene(new Scene(root));

        primaryStage.show();
        return new Jeu();
    }

    private boolean checkAll() {
        for(Card card:cards){
            if(card.isFlipped()== false){
                return false;
            }
        }
        return true;
    }
}
