package fr.nico.ddgame.fighters;


import fr.nico.ddgame.Backpack;
import fr.nico.ddgame.bonus.Food;
import fr.nico.ddgame.items.Stuff;

import java.util.Scanner;

public abstract class Fighter {

    private String name;
    private String type;
    private Backpack backpack = new Backpack();


    /************************************/
    public Backpack getBackpack() {
        return backpack;
    }

    public void setBackpack(Backpack backpack) {
        this.backpack = backpack;
    }


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

    public int showBackpack() {
        Scanner sc = new Scanner(System.in);
        System.out.println("-----------    Contenu de votre sac à dos   -----------");


        if (this.getBackpack().getBackpackContent().size()>0) {
            for (int i = 0; i < this.getBackpack().getBackpackContent().size(); i++) {
                System.out.println("[" + (i + 1) + "] " + this.getBackpack().getBackpackContent().get(i).getClass().getSimpleName() + " (" + this.getBackpack().getBackpackContent().get(i).getPowerUp() + ")");
            }
        }
        System.out.println("[0] Retour");

        int selectedOption = Integer.parseInt(sc.nextLine());
        return (selectedOption-1);
    }

    public boolean chooseAction(String context){
        Scanner sc = new Scanner(System.in);
        boolean itemUsed = false;
        System.out.println("--> Que souhaitez-vous faire ?");
        if (this.backpack.getBackpackContent().size() > 0) {
            System.out.println("[1] Utiliser un objet de l'inventaire");
        }


        String message = "";

        if(context.equals("board")) {
            message = "Avancer dans le donjon";
        }else if(context.equals("fight")){
            message = "Attaquer !";
        }
        System.out.println("[Entrer] " + message);

        String selectedOption = sc.nextLine();


        switch (selectedOption) {
            case "1":
                int backpackOption = this.showBackpack();
                if (backpackOption >= 0) {
                    itemUsed = true;
                    this.backpack.getBackpackContent().get(backpackOption).getUsed(this);
                    System.out.println("[Entrer] " + message);
                    sc.nextLine();
                } else {
                    System.out.println("[Entrer] " + message);
                    sc.nextLine();
                }

                break;
        }
        return itemUsed;
    }


    //public abstract boolean doAction(Fighter fighter);
    public boolean doAction(Fighter fighter) {
        Scanner sc = new Scanner(System.in);
        System.out.println("⚔⚔ Vous affrontez " + this.getName() + " ⚔⚔");
        System.out.println("Votre vie : " + fighter.getLife() + " || Ennemi : " + this.getLife());
        System.out.println(" ");
        //System.out.println("(\"Entrer\" pour commencer le combat)");
        //sc.nextLine();
        boolean fighterIsBeaten = false;
        boolean ennemyIsBeaten = false;
        int damages;
        while(!ennemyIsBeaten && !fighterIsBeaten) {
            int randWinner = (int) (Math.random() * (1 + 1));

            boolean itemUsed;
            System.out.println("this.backpack.getBackpackContent().size() : " + this.backpack.getBackpackContent().size());
            if(this.backpack.getBackpackContent().size()>0){
                 itemUsed = chooseAction("fight");
            }else {
                System.out.println("|           (\"Entrer\" pour attaquer)");
                sc.nextLine();
                itemUsed = false;
            }


            switch (randWinner) {
                case 0:

                    damages = this.getAttackPower();
                    fighter.setLife(fighter.getLife()-damages);
                    System.err.println("|           L'ennemi, vous a touché");
                    System.err.println("|           Il vous a infligé " + damages + " points de dégats");
                    break;
                case 1:
                    if(!itemUsed) {
                        damages = fighter.getAttackPower();
                        this.setLife(this.getLife() - damages);
                        System.out.println("|           Vous avez touché l'ennemi");
                        System.out.println("|           vous lui avez infligé " + damages + " points de dégats");
                    }else{
                        System.out.println("Vous avez utilisé un objet de votre sac à dos. Vous avez passé votre tour.");
                        itemUsed = false;
                    }
                    break;
            }
            if(fighter.getLife()<=0) {
                System.err.println("|           Vous êtes morts");
                System.out.println(" ");
                fighterIsBeaten = true;
            }else if(this.getLife()<=0){
                System.out.println("|           L'ennemi est mort");
                System.out.println(" ");
                ennemyIsBeaten =  true;

            }else{
                System.out.println("|           --------------    Fin du Round    --------------");
                System.out.println("|");
                System.out.println("|");
                System.out.println("|           Votre vie : " + fighter.getLife() + " || Ennemi : " + this.getLife());
                /*System.out.println("|           (\"Entrer\" pour attaquer)");
                sc.nextLine();*/
            }
        }
        return fighterIsBeaten;
    }
}
