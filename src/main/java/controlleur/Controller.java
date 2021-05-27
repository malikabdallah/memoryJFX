package controlleur;

import javafx.stage.Stage;
import view.Jeu;
import view.Menu;

import java.io.FileNotFoundException;

public class Controller {

    final Stage laStageUnique;


    private Menu menuView;
    private Jeu jeuView;
    private Stage stage;

    public Controller(Stage stage) {
        laStageUnique = stage;
        menuView = Menu.creerEtAfficher(this,stage);


    }

    public void goToJeu() throws FileNotFoundException {
       System.out.println("go to jeux");
       jeuView=new Jeu();
       jeuView.creerEtAfficher(this,laStageUnique);

    }
}
