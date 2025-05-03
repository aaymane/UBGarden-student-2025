package fr.ubx.poo.ubgarden.game.go.decor;

import fr.ubx.poo.ubgarden.game.Position;
import fr.ubx.poo.ubgarden.game.go.bonus.Bonus;
import fr.ubx.poo.ubgarden.game.go.personage.Gardener;

public class Hedgehog extends Bonus{


    public Hedgehog(Position position, Decor decor) {
        super(position, decor);
    }

    public void pickUpBy(Gardener gardener ) {
        gardener.pickUp(this);
    }

}
