package fr.nico.ddgame.bonus;

import fr.nico.ddgame.fighters.Fighter;

public class Elixir extends Food {
    private static int powerUp = 50;

    public int getPowerUp() {
        return powerUp;
    }

    public void doAction(Fighter fighter) {
        //Do Action
        /*System.out.println("Vous êtes tombé sur un Elixir, vous gagnez " + powerUp + " points de vie");
        fighter.setLife(fighter.getLife()+powerUp);
        System.out.println("Vous avez à présent " + fighter.getLife() + " points de vie");*/
        System.out.println("Vous êtes tombé sur un Elixir (" + powerUp + "). Il a été ajouté à votre sac à dos. \n");
        fighter.getBackpack().getBackpackContent().add(this);
    }

    public void getUsed(Fighter fighter) {
        fighter.setLife(fighter.getLife()+powerUp);
        fighter.getBackpack().getBackpackContent().remove(this);
        System.out.println("Vous avez à présent " + fighter.getLife() + " points de vie");
    }
}