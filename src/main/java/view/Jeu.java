package view;

import controlleur.Controller;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
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

    private Card selectedCard;

    public Jeu() {
    }

    private Controller controlleur;
    List<Card>cards=new ArrayList<>();

    public  Jeu creerEtAfficher(Controller c, Stage primaryStage) throws FileNotFoundException {
        GridPane root = new GridPane();
        VBox vBox=new VBox();
        int cpt=0;
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
                        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                        alert.setTitle("YOU WON !");
                        alert.setContentText("PLAY AGAIN ?");
                        ButtonType okButton = new ButtonType("Yes", ButtonBar.ButtonData.YES);
                        ButtonType noButton = new ButtonType("No", ButtonBar.ButtonData.NO);
                        ButtonType cancelButton = new ButtonType("No", ButtonBar.ButtonData.CANCEL_CLOSE);
                        alert.getButtonTypes().setAll(okButton, noButton, cancelButton);
                        alert.showAndWait()
                                .filter(response -> response == ButtonType.YES)
                                .ifPresent(response -> {
                                    try {
                                        controlleur.playAgain();
                                    } catch (FileNotFoundException e) {
                                        e.printStackTrace();
                                    }
                                });
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

        vBox.setAlignment(Pos.CENTER);
        root.add(vBox,0,0);
        primaryStage.setTitle("Easy Memory Puzzle");
        primaryStage.setWidth(550);
        primaryStage.setHeight(600);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
        return new Jeu();
    }

    private boolean checkAll() {
        for(Card card:cards){
            if(card.isFlipped()== false){
                System.out.println("not check all");
                return false;
            }
        }
        System.out.println("check all");
        return true;
    }
}
