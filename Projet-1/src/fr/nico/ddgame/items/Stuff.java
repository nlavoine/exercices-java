package fr.nico.ddgame.items;

public class Stuff {

    private String name;
    private int power;

    Stuff(String stuffName, int stuffPower){
        name = stuffName;
        power = stuffPower;
    }

    /************************************/

    /*public void setName(String stuffName) {
        this.name = stuffName;
    }*/

    public String getName() {
        return name;
    }
    /************************************/

    /*public void setAttack(int stuffAttack) {
        this.power = stuffAttack;
    }*/

    public int getPower() {
        return power;
    }


}
