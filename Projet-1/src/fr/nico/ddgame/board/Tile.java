package fr.nico.ddgame.board;

import fr.nico.ddgame.fighters.Fighter;

public interface Tile {
    boolean doAction(Fighter fighter);
    /*void doAction();
    void setContent(Fighter fighter);
    void setContent(Food food);*/
}
