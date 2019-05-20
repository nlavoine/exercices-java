package main.java;

abstract class Stuff {

    private String name;
    private int attack;

    Stuff(String weaponName, int weaponAttack){
        name = weaponName;
        attack = weaponAttack;
    }



    void setName(String stuffName) {
        this.name = stuffName;
    }

    String getName() {
        return name;
    }

    void setAttack(int stuffAttack) {
        this.attack = stuffAttack;
    }

    int getAttack() {
        return attack;
    }


}
