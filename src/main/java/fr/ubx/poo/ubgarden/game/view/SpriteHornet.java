package fr.ubx.poo.ubgarden.game.view;

import fr.ubx.poo.ubgarden.game.Direction;

import fr.ubx.poo.ubgarden.game.go.personage.Wasp;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

public class SpriteHornet extends Sprite {

    public SpriteHornet(Pane layer, Wasp wasp) {
        super(layer, null, wasp);
        updateImage();
    }


    @Override
    public void updateImage() {
        Wasp wasp = (Wasp) getGameObject();
        Image image = getImage(wasp.getDirection());
        setImage(image);
    }

    public Image getImage(Direction direction) {
        return ImageResourceFactory.getInstance().getWasp(direction);
    }
}
