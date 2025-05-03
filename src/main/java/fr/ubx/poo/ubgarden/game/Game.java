package fr.ubx.poo.ubgarden.game;

import fr.ubx.poo.ubgarden.game.go.personage.Gardener;


public class Game {

    private Boolean defeated = false;



    public void setDefeated(Boolean defeated) {
        this.defeated = defeated;
    }

    public boolean isDefeated() {
        return defeated;
    }
    private int InsecticideCount=0;

    public int getDiseaselevel() {
        return diseaselevel;
    }

    public int getInsecticideCount() {
        return InsecticideCount;
    }
    public void addInsecticide() {
        InsecticideCount++;
    }
    public void increaseDiseaselevel() {
        diseaselevel++;
    }
    public void decreaseDiseaselevel() {
        diseaselevel--;
    }
    public void decreaseInsecticide() {
        InsecticideCount++;
    }
    private int diseaselevel=0;
    private final Configuration configuration;
    private final World world;
    private final Gardener gardener;
    private boolean switchLevelRequested = false;
    private int switchLevel;
    public Game(World world, Configuration configuration, Position gardenerPosition) {
        this.configuration = configuration;
        this.world = world;
        gardener = new Gardener(this, gardenerPosition);
    }

    public Configuration configuration() {
        return configuration;
    }

    public Gardener getGardener() {
        return this.gardener;
    }

    public World world() {
        return world;
    }

    public boolean isSwitchLevelRequested() {
        return switchLevelRequested;
    }

    public int getSwitchLevel() {
        return switchLevel;
    }

    public void requestSwitchLevel(int level) {
        this.switchLevel = level;
        switchLevelRequested = true;
    }

    public void clearSwitchLevel() {
        switchLevelRequested = false;
    }

}
