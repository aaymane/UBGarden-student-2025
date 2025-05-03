package fr.ubx.poo.ubgarden.game.go.decor;

import fr.ubx.poo.ubgarden.game.Position;
import fr.ubx.poo.ubgarden.game.go.bonus.Bonus;
import fr.ubx.poo.ubgarden.game.view.Sprite;

public class NestWasp extends Decor {
    public NestWasp(Position position) {
        super(position);
    }

    public NestWasp(Position position, Bonus bonus) {
        super(position, bonus);
    }
}
