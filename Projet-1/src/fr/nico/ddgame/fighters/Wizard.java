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

    @Override
    public boolean doAction(Fighter fighter) {
        Scanner sc = new Scanner(System.in);
        System.out.println("]] Vous affrontez " + this.getName() + " [[");
        System.out.println("Votre vie : " + fighter.getLife() + " || Ennemi : " + this.getLife());
        System.out.println(" ");
        boolean fighterIsBeaten = false;
        boolean ennemyIsBeaten = false;
        int damages;
        while(!ennemyIsBeaten && !fighterIsBeaten) {
            int randWinner = (int) (Math.random() * (1 + 1));

            switch (randWinner) {
                case 0:

                    damages = this.getAttackPower();
                    fighter.setLife(fighter.getLife()-damages);
                    System.out.println("|           L'ennemi, vous a touché");
                    System.out.println("|           Il vous a infligé " + damages + " points de dégats");
                    break;
                case 1:
                    damages = fighter.getAttackPower();
                    this.setLife(this.getLife()-damages);
                    System.out.println("|           Vous avez touché l'ennemi");
                    System.out.println("|           vous lui avez infligé " + damages + " points de dégats");
                    break;
            }
            if(fighter.getLife()<=0) {
                System.out.println("|           Vous êtes morts");
                fighterIsBeaten = true;
            }else if(this.getLife()<=0){
                System.out.println("|           L'ennemi est mort");
                ennemyIsBeaten =  true;

            }else{
                System.out.println("|           Votre vie : " + fighter.getLife() + " || Ennemi : " + this.getLife());
            }
            System.out.println("|           --------------    Fin du Round    --------------");
            System.out.println("|           (\"Entrer\" pour attaquer)");
            sc.nextLine();
        }
        return fighterIsBeaten;
    }
}
