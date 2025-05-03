package fr.ubx.poo.ubgarden.game.go.decor;

import fr.ubx.poo.ubgarden.game.Position;
import fr.ubx.poo.ubgarden.game.go.bonus.Bonus;
import fr.ubx.poo.ubgarden.game.go.personage.Gardener;
import fr.ubx.poo.ubgarden.game.view.Sprite;

public class FlowerBush extends Decor {
    public FlowerBush(Position position) {
        super(position);
    }

    public FlowerBush(Position position, Bonus bonus) {
        super(position, bonus);
    }
    @Override
    public boolean walkableBy(Gardener gardener) {
        return gardener.canWalkOn(this);
    }
}

