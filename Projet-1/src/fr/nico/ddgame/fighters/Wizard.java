package fr.nico.ddgame.fighters;


import fr.nico.ddgame.items.Stuff;

import java.util.Scanner;

public class Wizard extends Fighter {

    private Stuff sort;
    private Stuff philter;

    private final static int MIN_LIFE = 3;
    private final static int MAX_LIFE = 6;
    private final static int MIN_POWER = 8;
    private final static int MAX_POWER = 15;

    private int life;
    private int power;

    public Wizard() {
        this.life = generateLife()*5;
        this.power = generatePower();
    }

    @Override
    public int getAttackPower(){
        double luck = (( Math.random()*( 10 - 5 + 1 ) ) + 5)/10;
        return (int)((this.power + this.sort.getPower()) * luck);
    }

    @Override
    public int getDefensePower(){
        return this.philter.getPower();
    }

    /**
     * @return Entier correspondant à "life"
     */
    private int generateLife(){
        return (int)( Math.random()*( MAX_LIFE - MIN_LIFE + 1 ) ) + MIN_LIFE;
    }

    /**
     * @return Entier correspondant à "power"
     */
    private int generatePower(){
        return (int)( Math.random()*( MAX_POWER - MIN_POWER + 1 ) ) + MIN_POWER;
    }

    /**
     * @param fighterSort Stuff du Wizard
     */
    @Override
    public void setStuff(Stuff fighterSort) {

        this.sort = fighterSort;
    }

    /**
     * @return Stuff Sort
     */
    @Override
    public Stuff getStuff() {

        return sort;
    }
    /************************************/
    @Override
    public void setSecondary(Stuff fighterPhilter) {

        this.philter = fighterPhilter;
    }

    @Override
    public Stuff getSecondary() {

        return philter;
    }
    /************************************/

    @Override
    public void setLife(int fighterLife) {

        this.life = fighterLife;
    }

    @Override
    public int getLife() {

        return life;
    }
    /************************************/

    @Override
    public void setPower(int fighterPower) {

        this.power = fighterPower;
    }

    @Override
    public int getPower() {

        return this.power;
    }


}
