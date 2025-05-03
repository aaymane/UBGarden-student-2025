package fr.ubx.poo.ubgarden.game.go.decor;

import fr.ubx.poo.ubgarden.game.Position;
import fr.ubx.poo.ubgarden.game.go.bonus.Bonus;

public class DoorNextClosed extends Decor{

    public DoorNextClosed(Position position) {
        super(position);
    }

    public DoorNextClosed(Position position, Bonus bonus) {
        super(position, bonus);
    }
}
