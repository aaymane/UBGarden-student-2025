package fr.ubx.poo.ubgarden.game.go.decor;

import fr.ubx.poo.ubgarden.game.Position;
import fr.ubx.poo.ubgarden.game.go.bonus.Bonus;

public class NestHornet extends Decor {
    public NestHornet(Position position) {
        super(position);
    }

    public NestHornet(Position position, Bonus bonus) {
        super(position, bonus);
    }
}
