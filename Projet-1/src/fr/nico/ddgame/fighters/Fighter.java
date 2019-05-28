package fr.nico.ddgame.fighters;


import fr.nico.ddgame.items.Stuff;

import java.util.Scanner;

public abstract class Fighter {

    private String name;
    private String type;


    /************************************/


    public void setName(String fighterName) {

        this.name = fighterName;
    }


    public String getName() {

        return name;
    }

    /************************************/

    public void setType(String fighterType) {

        this.type = fighterType;
    }

    public String getType() {

        return type;
    }

    public abstract int getAttackPower();
    public abstract int getDefensePower();

    public abstract void setStuff(Stuff fighterStuff);

    public abstract Stuff getStuff();

    public abstract void setSecondary(Stuff fighterSecondary);

    public abstract Stuff getSecondary();

    public abstract void setLife(int fighterLife);

    public abstract int getLife();

    public abstract void setPower(int fighterPower);

    public abstract int getPower();

    //public abstract boolean doAction(Fighter fighter);
    public boolean doAction(Fighter fighter) {
        Scanner sc = new Scanner(System.in);
        System.out.println("]] Vous affrontez " + this.getName() + " [[");
        System.out.println("Votre vie : " + fighter.getLife() + " || Ennemi : " + this.getLife());
        System.out.println(" ");
        System.out.println("(\"Entrer\" pour attaquer)");
        sc.nextLine();
        boolean fighterIsBeaten = false;
        boolean ennemyIsBeaten = false;
        int damages;
        while(!ennemyIsBeaten && !fighterIsBeaten) {
            int randWinner = (int) (Math.random() * (1 + 1));

            switch (randWinner) {
                case 0:

                    damages = this.getAttackPower();
                    fighter.setLife(fighter.getLife()-damages);
                    System.err.println("|           L'ennemi, vous a touché");
                    System.err.println("|           Il vous a infligé " + damages + " points de dégats");
                    break;
                case 1:
                    damages = fighter.getAttackPower();
                    this.setLife(this.getLife()-damages);
                    System.out.println("|           Vous avez touché l'ennemi");
                    System.out.println("|           vous lui avez infligé " + damages + " points de dégats");
                    break;
            }
            if(fighter.getLife()<=0) {
                System.err.println("|           Vous êtes morts");
                fighterIsBeaten = true;
            }else if(this.getLife()<=0){
                System.out.println("|           L'ennemi est mort");
                ennemyIsBeaten =  true;

            }else{
                System.out.println("|           --------------    Fin du Round    --------------");
                System.out.println("|           Votre vie : " + fighter.getLife() + " || Ennemi : " + this.getLife());

                System.out.println("|           (\"Entrer\" pour attaquer)");
                sc.nextLine();
            }
        }
        return fighterIsBeaten;
    }
}
