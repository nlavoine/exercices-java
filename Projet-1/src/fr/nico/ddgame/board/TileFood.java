package fr.nico.ddgame.board;

import fr.nico.ddgame.bonus.Food;
import fr.nico.ddgame.fighters.Fighter;

public class TileFood implements Tile {
    private Food tileContent;

    public TileFood(Food food){
        tileContent = food;
    }

    public boolean doAction(Fighter fighter){
        tileContent.doAction(fighter);
        return false;
    }

}
