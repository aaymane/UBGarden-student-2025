package fr.ubx.poo.ubgarden.game.go.personage;

import fr.ubx.poo.ubgarden.game.Direction;
import fr.ubx.poo.ubgarden.game.Game;
import fr.ubx.poo.ubgarden.game.Position;
import fr.ubx.poo.ubgarden.game.go.GameObject;
import fr.ubx.poo.ubgarden.game.go.Movable;

public class Wasp extends GameObject implements Movable {
    private Direction direction;


    public Wasp(Game game, Position position) {
        super(game, position);
    }

    public Wasp(Position position) {
        super(position);
    }

    @Override
    public boolean canMove(Direction direction) {
        return false;
    }

    @Override
    public Position move(Direction direction) {
        return null;
    }

    public Direction getDirection() {
        return direction;
    }

}
