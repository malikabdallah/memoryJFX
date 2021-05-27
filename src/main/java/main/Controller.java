package main;

import javafx.stage.Stage;
import vue.Jeu;
import vue.Menu;

public class Controller {

    final Stage laStageUnique;


    private Menu menuView;
    private Jeu jeuView;
    private Stage stage;

    public Controller(Stage stage) {
        laStageUnique = stage;
        menuView =Menu.creerEtAfficher(this,stage);


    }

    public void goToJeu() {
        //jeu=Jeu.creerEtAfficher(this,laStageUnique);
        try {
            Jeu.creerEtAfficher(this, stage);
        }catch (Exception e){

        }

    }
}
