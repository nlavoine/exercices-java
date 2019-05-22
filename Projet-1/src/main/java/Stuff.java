package main.java;

public class Stuff {

    private String name;
    private int power;

    Stuff(String stuffName, int stuffPower){
        name = stuffName;
        power = stuffPower;
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
        this.power = stuffAttack;
    }*/

    int getPower() {
        return power;
    }


}
