package fr.ubx.poo.ubgarden.game;

import fr.ubx.poo.ubgarden.game.go.bonus.Bomb;
import fr.ubx.poo.ubgarden.game.go.bonus.Carrot;
import fr.ubx.poo.ubgarden.game.go.bonus.EnergyBoost;
import fr.ubx.poo.ubgarden.game.go.bonus.PoisonedApple;
import fr.ubx.poo.ubgarden.game.go.decor.*;
import fr.ubx.poo.ubgarden.game.go.decor.ground.Grass;
import fr.ubx.poo.ubgarden.game.go.decor.ground.Land;
import fr.ubx.poo.ubgarden.game.launcher.MapEntity;
import fr.ubx.poo.ubgarden.game.launcher.MapLevel;

import java.util.Collection;
import java.util.HashMap;

public class Level implements Map {

    private final int level;
    private final int width;

    private final int height;

    private final java.util.Map<Position, Decor> decors = new HashMap<>();

    public Level(Game game, int level, MapLevel entities) {
        this.level = level;
        this.width = entities.width();
        this.height = entities.height();

        for (int i = 0; i < width; i++)
            for (int j = 0; j < height; j++) {
                Position position = new Position(level, i, j);
                MapEntity mapEntity = entities.get(i, j);
                switch (mapEntity) {
                    case Grass:
                        decors.put(position, new Grass(position));
                        break;
                    case Tree:
                        decors.put(position, new Tree(position));
                        break;
                    case Apple: {
                        Decor grass = new Grass(position);
                        grass.setBonus(new EnergyBoost(position, grass));
                        decors.put(position, grass);
                        break;
                    }
                    case Carrots: {
                        Decor grass = new Grass(position);
                        grass.setBonus(new Carrot(position, grass));
                        decors.put(position, grass);
                        break;
                    } case Land: {
                       decors.put(position, new Land(position));
                        break;
                    } case Flowers: {
                    decors.put(position, new FlowerBush(position));
                    break;
                }
                    case NestWasp: {
                        decors.put(position, new NestWasp(position));
                        break;
                    }
                    case NestHornet: {
                        decors.put(position, new NestHornet(position));
                        break;
                    }
                    case DoorNextClosed: {
                        decors.put(position, new DoorNextClosed(position));
                        break;
                    } case DoorNextOpened: {
                        decors.put(position, new DoorNextOpened(position));
                        break;
                    }
                    case Hedgehog: {
                            Decor grass = new Grass(position);
                            grass.setBonus(new Hedgehog(position, grass));
                            decors.put(position, grass);
                            break;
                    }
                    case PoisonedApple: {
                        Decor grass = new Grass(position);
                        grass.setBonus(new PoisonedApple(position, grass));
                        decors.put(position, grass);
                        break;
                    }
                    case Bomb: {
                        Decor grass = new Grass(position);
                        grass.setBonus(new Bomb(position, grass));
                        decors.put(position, grass);
                        break;
                    }
                    case DoorPrevOpened: {
                        decors.put(position, new DoorPrevOpened(position));
                        break;
                    }
                    default:
                        throw new RuntimeException("EntityCode " + mapEntity.name() + " not processed");
               }
            }
    }

    @Override
    public int width() {
        return this.width;
    }

    @Override
    public int height() {
        return this.height;
    }

    public Decor get(Position position) {
        return decors.get(position);
    }

    public Collection<Decor> values() {
        return decors.values();
    }


    @Override
    public boolean inside(Position position) {
        return true;
    }


}
