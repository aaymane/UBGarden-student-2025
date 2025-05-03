package fr.ubx.poo.ubgarden.game.launcher;


import fr.ubx.poo.ubgarden.game.go.personage.Wasp;

import static fr.ubx.poo.ubgarden.game.launcher.MapEntity.*;

public class MapLevelDefaultStart extends MapLevel {


    private final static int width = 18;
    private final static int height = 8;
        private final MapEntity[][] level1 = {
                {Grass, Grass, Grass, Grass, Grass, Bomb, Grass, Grass, Grass, Grass, Grass, Grass, Grass, Grass, Grass, Grass, Grass, Grass},
                {Grass, Gardener, DoorNextOpened, Land, Land, Grass, Grass, Flowers, Grass, Tree, Grass, Grass, Tree, Tree, Grass, Grass, Grass, Grass},
                {Grass, Grass, Grass, Bomb, Grass, Grass, Land, Grass, Grass, Grass, Grass, PoisonedApple, Grass, Tree, Grass, Grass, Grass, Grass},
                {Grass, Grass, Grass, Grass, Grass, Grass, Grass, Grass, Grass, Grass, Grass, Grass, Grass, Tree, Grass, Grass, Grass, Grass},
                {Grass, Tree,NestHornet, Tree, Grass, Grass, Grass, Grass, NestWasp, Grass, Grass, Grass, Grass, Tree, Grass, Bomb, Apple, Grass},
                {Grass, Tree, Tree, Tree, Grass, Grass, Grass, Grass, Grass, Grass, Grass, Grass, Hedgehog, Grass, Grass, Grass, Grass, Grass},
                {Grass, Grass, Grass, Grass, Grass, Grass, Grass, Grass, Grass, PoisonedApple, Grass, Bomb, Grass, Grass, Grass, DoorNextClosed, Grass, Grass},
                {Grass, Tree, Grass, Tree, Grass, Grass, Grass, Grass, Grass, Grass, NestWasp, Grass, NestWasp, Grass, Grass, Grass, Grass, Grass}
        };

    public MapLevelDefaultStart() {
        super(width, height);
        for (int i = 0; i < width; i++)
            for (int j = 0; j < height; j++)
                set(i, j, level1[j][i]);
    }


}
