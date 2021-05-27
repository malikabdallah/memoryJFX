package sample;

import javafx.stage.Stage;
import vue.Menu;

public class Controller {

    final Stage laStageUnique;


    private Menu menuView;

    public Controller(Stage stage) {
        laStageUnique = stage;
        menuView =Menu.creerEtAfficher(this,stage);


    }

    public void goToJeu() {
        //jeu=Jeu.creerEtAfficher(this,laStageUnique);

    }
}
