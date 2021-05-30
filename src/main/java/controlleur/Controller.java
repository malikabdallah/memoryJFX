package controlleur;

import javafx.stage.Stage;
import view.Jeu;
import view.Menu;

import java.io.FileNotFoundException;

public class Controller {
    final Stage laStageUnique;
    private Menu menuView;
    private Jeu jeuView;
    public Controller(Stage stage) {
        laStageUnique = stage;
        menuView = Menu.creerEtAfficher(this,stage);
        menuView.lancerMusic();
    }

    public void goToJeu() throws FileNotFoundException {
       jeuView=new Jeu();
       jeuView.creerEtAfficher(this,laStageUnique);

    }

    public void playAgain() throws FileNotFoundException {
        System.out.println("play again");
        jeuView=new Jeu();
        jeuView.creerEtAfficher(this,laStageUnique);
    }
}
