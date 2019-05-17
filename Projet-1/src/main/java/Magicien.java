package main.java;

import java.util.Scanner;

public class Magicien extends Fighter{
    Scanner sc = new Scanner(System.in);

    private Sort sort= new Sort("Etincelle du marchand", 1);
    private String philter = "Potion de soin min";

   @Override
    void displayInfos() {

        System.out.println(" ");
        System.out.println("########################");
        System.out.println("Type : Magicien");
        System.out.println("Nom : "+ this.getName());
        System.out.println("Vie : "+ this.getLife());
        System.out.println("Force : "+ this.getPower());
       System.out.println("Arme : "+ this.sort.getName());
       System.out.println("Bouclier : "+ this.philter);
        System.out.println("########################");
        System.out.println(" ");
    }

    @Override
    void editInfos(){
        System.out.println("########################");
        System.out.println("Votre Magicien s'appel "+ this.getName() +".");
        System.out.println("Renseigner son nouveau nom :");

        this.setName(sc.nextLine());

        System.out.println(this.getName() +" a "+ this.getLife() +" points de Vie.");
        System.out.println("Renseigner ses points de Vie :");

        this.setLife(sc.nextInt());

        System.out.println(this.getName() +" a "+ this.getPower() +" points de Force.");
        System.out.println("Renseigner enfin ses points de Force :");

        this.setPower(sc.nextInt());
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
