/*
 * Copyright (c) 2020. Laurent Réveillère
 */

package fr.ubx.poo.ubgarden.game.go.personage;

import fr.ubx.poo.ubgarden.game.Direction;
import fr.ubx.poo.ubgarden.game.Game;
import fr.ubx.poo.ubgarden.game.Position;
import fr.ubx.poo.ubgarden.game.engine.Timer;
import fr.ubx.poo.ubgarden.game.go.GameObject;
import fr.ubx.poo.ubgarden.game.go.Movable;
import fr.ubx.poo.ubgarden.game.go.PickupVisitor;
import fr.ubx.poo.ubgarden.game.go.WalkVisitor;
import fr.ubx.poo.ubgarden.game.go.bonus.Bomb;
import fr.ubx.poo.ubgarden.game.go.bonus.EnergyBoost;
import fr.ubx.poo.ubgarden.game.go.bonus.PoisonedApple;
import fr.ubx.poo.ubgarden.game.go.decor.Decor;
import fr.ubx.poo.ubgarden.game.go.decor.Hedgehog;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class Gardener extends GameObject implements Movable, PickupVisitor, WalkVisitor {

    private  int energy;
    private Direction direction;
    private int diseaseLevel = 0;
    private boolean moveRequested = false;
    private boolean win = false;
    private final List<Timer> activeDiseases=new ArrayList<>();
    private final List<Timer> finishedDiseases=new ArrayList<>();
    private int poisenedDamage=2;
    private Time lastPoisonTime;

    public int getDiseaseLevel() {
        return diseaseLevel;
    }

    public void setDiseaseLevel(int diseaseLevel) {
        this.diseaseLevel = diseaseLevel;
    }

    public int getPoisenedDamage() {
        return poisenedDamage;
    }
    private int bombsCounter;
    private int poisonedApplesCounter;

    public int getBombsCounter() {
        return bombsCounter;
    }

    public void addBombsCounter() {
         bombsCounter++;
    }

    public boolean isWin() {
        return win;
    }

    public void setWin(boolean win) {
        this.win = win;
    }

    public Gardener(Game game, Position position) {

        super(game, position);
        this.direction = Direction.DOWN;
        this.energy = game.configuration().gardenerEnergy();
    }


    @Override
    public void pickUp(EnergyBoost energyBoost) {
        energy = energy + 50;
        if(energy > 100) {energy = 100;}
        System.out.println("I am taking the boost, I should do something ...");

    }

    public void pickUp(Hedgehog hedgehog) {
        setWin(true);

    }
    public void pickUp(Bomb bomb) {
       addBombsCounter();

    }

    public void pickUp(PoisonedApple poisonedApple) {

       Timer timer = new Timer(game.configuration().diseaseDuration());
       timer.start();
       diseaseLevel ++;
       activeDiseases.add(timer);
       poisonedApple.remove();

    }



    public int getEnergy() {
        return this.energy;
    }


    public void requestMove(Direction direction) {
        if (direction != this.direction) {
            this.direction = direction;
            setModified(true);
        }
        moveRequested = true;
    }

    @Override
    public final boolean canMove(Direction direction) {
        Position position = direction.nextPosition(getPosition());
        int width =game.world().getGrid().width();
        int height =game.world().getGrid().height();
          if (position.x()<0 || position.x()>=width || position.y()<0 || position.y()>=height) return false;
          Decor decor = game.world().getGrid().get(position);
          if (decor!=null && !decor.walkableBy(this)) return false;
        return true;
    }

    @Override
    public Position move(Direction direction) {
        Position nextPos = direction.nextPosition(getPosition());
        Decor next = game.world().getGrid().get(nextPos);
        setPosition(nextPos);
        loseEnnergy(1);
        if (next != null)
            next.pickUpBy(this);
        return nextPos;
    }

    public void update(long now) {
        if (moveRequested) {
            if (canMove(direction)) {
                move(direction);
            }
        }
        for(Timer t : activeDiseases){
            t.update(now);
            if (!t.isRunning()){
                finishedDiseases.add(t);
            }
        }
        for (Timer expired:finishedDiseases){
            activeDiseases.remove(expired);
            loseEnnergy(2);
        }
        finishedDiseases.clear();
         moveRequested = false;

    }

    public int getEnnergy(){
        return energy;
    }

    public void addEnnergy(int energy){
        this.energy += energy;
    }

    public void loseEnnergy(int energy){
        this.energy -= energy;
        if (this.energy < 0) this.energy = 0;
        if (this.energy == 0) {
            game.setDefeated(true);
            System.out.println("game lose");
        }

    }

    public void hurt(int damage) {
    }

    public void hurt() {
        hurt(1);
    }

    public Direction getDirection() {
        return direction;
    }


}
