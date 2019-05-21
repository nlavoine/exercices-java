package main.java;

public class Stuff {

    private String name;
    private int attack;

    Stuff(String stuffName, int stuffAttack){
        name = stuffName;
        attack = stuffAttack;
    }

    /************************************/

    /*void setName(String stuffName) {
        this.name = stuffName;
    }*/

    String getName() {
        return name;
    }
    /************************************/

    /*void setAttack(int stuffAttack) {
        this.attack = stuffAttack;
    }*/

    int getAttack() {
        return attack;
    }


}
