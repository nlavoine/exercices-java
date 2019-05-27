package fr.nico.ddgame.board;

import fr.nico.ddgame.fighters.Fighter;

public class TileEnnemy implements Tile {
    private Fighter tileContent;

    public TileEnnemy(Fighter fighter){
        tileContent = fighter;
    }

    public boolean doAction(Fighter fighter){
        return tileContent.doAction(fighter);
    }


}
