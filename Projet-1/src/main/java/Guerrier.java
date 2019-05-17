package main.java;

import java.util.Scanner;

public class Guerrier extends Fighter {
    Scanner sc = new Scanner(System.in);

    private static final String[] weapons = {"Hache de bucheron", "Tournevis bélliqueux"};
    private static final String[] shields = {"Casque en mousse", "Plastron MDF"};

    private int weaponNumber = (int)( Math.random()*( (weapons.length-1) + 1 ) );
    private int shieldNumber = (int)( Math.random()*( (shields.length-1) + 1 ) );

    private Weapon weapon = new Weapon (weapons[weaponNumber], 2);
    private String shield = shields[shieldNumber];

    @Override
    void displayInfos() {
        System.out.println(" ");
        System.out.println("########################");
        System.out.println("Type : Guerrier");
        System.out.println("Nom : "+ this.getName());
        System.out.println("Vie : "+ this.getLife());
        System.out.println("Force : "+ this.getPower());
        System.out.println("Arme : "+ this.weapon.getName());
        System.out.println("Bouclier : "+ this.shield);
        System.out.println("########################");
        System.out.println(" ");

    }

    @Override
    void editInfos(){
        System.out.println("########################");
        System.out.println(" ");
        System.out.println("**** ATTRIBUTS ****");
        System.out.println(" ");
        System.out.println("Votre Guerrier s'appel "+ this.getName() +".");
        System.out.println("Renseigner son nouveau nom :");

        this.setName(sc.nextLine());
        System.out.println(" ");

        System.out.println(this.getName() +" a "+ this.getLife() +" points de Vie.");
        System.out.println("Renseigner ses points de Vie :");

        this.setLife(sc.nextInt());
        System.out.println(" ");

        System.out.println(this.getName() +" a "+ this.getPower() +" points de Force.");
        System.out.println("Renseigner enfin ses points de Force :");

        this.setPower(sc.nextInt());
        System.out.println(" ");

        System.out.println(" ");
        System.out.println("**** EQUIPEMENTS ****");
        System.out.println(" ");

        System.out.println("Arme de " + this.getName() + " : " + this.weapon.getName() );
        System.out.println("Quelle arme souhaitez-vous lui équiper ?");
        for(int i = 0; i< weapons.length; i++){
            System.out.println("["+ (i+1) +"] " + weapons[i]);
        }

        this.weapon.setName(weapons[sc.nextInt()-1]);
        System.out.println(" ");
        System.out.println("########################");
    }


    public void setName(String fighterName) {
        this.name = fighterName;
    }

    public String getName() {
        return name;
    }

    public void setLife(int fighterLife) {
        this.life = fighterLife;
    }
    public int getLife() {
        return life;
    }
    public void setPower(int fighterPower) {
        this.power = fighterPower;
    }
    public int getPower() {
        return power;
    }
}
