package fr.nico.ddgame.bonus;

import fr.nico.ddgame.fighters.Fighter;

public abstract class Food {

    public abstract int getPowerUp();
    public abstract void doAction(Fighter fighter);
    public abstract void getUsed(Fighter fighter);
}
