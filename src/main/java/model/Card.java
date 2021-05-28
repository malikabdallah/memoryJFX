package model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class Card extends ImageView {

    private static final String emptyCard = "/img/unknown.png";

    private String url;
    private boolean flipped;

    public Card(String url) {
        super(emptyCard);
        this.url = url;
    }

    public void flip() {
        setImage(new Image(url));
        flipped = true;
        this.setFitHeight(100);
        this.setFitWidth(150);
        this.setPreserveRatio(true);
    }

    public boolean isFlipped() {
        return flipped;
    }

    public void show() {
        setImage(new Image(url));
    }

    public void hide() {
        setImage(new Image(emptyCard));
    }

    public boolean equals(Object obj) {
        return obj instanceof Card
                && ((Card)obj).url.equals(url);
    }
}
