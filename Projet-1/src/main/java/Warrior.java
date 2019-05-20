package main.java;

import java.util.Scanner;

public class Warrior extends Fighter {
    Scanner sc = new Scanner(System.in);

    private Stuff weapon;

    Warrior(Weapon fighterWeapon) {

        weapon = fighterWeapon;
    }

    @Override
    public void setStuff(Stuff fighterWeapon) {

        this.weapon = fighterWeapon;
    }

    @Override
    public Stuff getStuff() {

        return weapon;
    }
}
