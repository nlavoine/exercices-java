package main.java;

import java.util.Scanner;

public class Wizard extends Fighter {
    Scanner sc = new Scanner(System.in);

    private Stuff sort;

    Wizard(Sort fighterSort) {

        sort = fighterSort;
    }




    @Override
    public void setStuff(Stuff fighterSort) {

        this.sort = fighterSort;
    }

    @Override
    public Stuff getStuff() {

        return sort;
    }
}
