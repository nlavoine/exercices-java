package main.java;

import java.util.List;
import java.util.Scanner;

public class Warrior extends Fighter {
    Scanner sc = new Scanner(System.in);

    private Weapon weapon;

    Warrior(Weapon fighterWeapon) {
        weapon = fighterWeapon;
    }

    @Override
    void displayInfos() {
        System.out.println(" ");
        System.out.println("########################");
        System.out.println("Type : Warrior");
        System.out.println("Nom : " + this.getName());
        System.out.println("Vie : " + this.getLife());
        System.out.println("Force : " + this.getPower());
        System.out.println("Arme : " + this.weapon.getName());
        //System.out.println("Bouclier : " + this.shield);
        System.out.println("########################");
        System.out.println(" ");
    }

    @Override
    void editInfos(List<Weapon> weaponList, List<Sort> sortList) {
        System.out.println("======================================");
        System.out.println("||            ATTRIBUTS             ||");
        System.out.println("||");
        System.out.println("|| Votre Warrior s'appel " + this.getName() + ".");
        System.out.println("||**** Renseigner son nouveau nom :");

        this.setName(sc.nextLine());
        System.out.println("||");

        System.out.println("||" + this.getName() + " a " + this.getLife() + " points de Vie.");
        System.out.println("||**** Renseigner ses points de Vie :");

        this.setLife(sc.nextInt());
        System.out.println("||");

        System.out.println("||" + this.getName() + " a " + this.getPower() + " points de Force.");
        System.out.println("||**** Renseigner enfin ses points de Force :");

        this.setPower(sc.nextInt());
        System.out.println("||");

        System.out.println("||");
        System.out.println("......................................");
        System.out.println("||            EQUIPEMENTS           ||");
        System.out.println("||");

        System.out.println("|| Arme de " + this.getName() + " : " + this.weapon.getName());
        System.out.println("||**** Quelle arme souhaitez-vous lui équiper ?");
        System.out.println("||");
        for (int i = 0; i < weaponList.size(); i++) {
            System.out.println("||     [" + (i + 1) + "] " + weaponList.get(i).getName());
        }

        this.weapon = weaponList.get(sc.nextInt() - 1);
        System.out.println("||");
        System.out.println("||   * Mise à jour du Combattant *");
        System.out.println("======================================");
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
