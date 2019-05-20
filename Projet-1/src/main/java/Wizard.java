package main.java;

import java.util.List;
import java.util.Scanner;

public class Wizard extends Fighter {
    Scanner sc = new Scanner(System.in);

    private Sort sort;

    Wizard(Sort fighterSort) {
        sort = fighterSort;
    }

    @Override
    void displayInfos() {
        System.out.println(" ");
        System.out.println("########################");
        System.out.println("Type : Wizard");
        System.out.println("Nom : " + this.getName());
        System.out.println("Vie : " + this.getLife());
        System.out.println("Force : " + this.getPower());
        System.out.println("Arme : " + this.sort.getName() + " - " + this.sort.getAttack());
        //System.out.println("Bouclier : "+ this.philter);
        System.out.println("########################");
        System.out.println(" ");
    }

    @Override
    void editInfos(List<Weapon> weaponList, List<Sort> sortList) {
        System.out.println("======================================");
        System.out.println("||            ATTRIBUTS             ||");
        System.out.println("||");
        System.out.println("|| Votre Wizard s'appel " + this.getName() + ".");
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

        System.out.println("|| Sort de " + this.getName() + " : " + this.sort.getName());
        System.out.println("||**** Quelle sort souhaitez-vous lui équiper ?");
        System.out.println("||");
        for (int i = 0; i < sortList.size(); i++) {
            System.out.println("||     [" + (i + 1) + "] " + sortList.get(i).getName());
        }

        this.sort = sortList.get(sc.nextInt() - 1);
        System.out.println("||");
        System.out.println("||   * Mise à jour du Combattant *");
        System.out.println("======================================");
        System.out.println(" \n");
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
