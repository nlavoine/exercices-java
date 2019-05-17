package main.java;

public class Weapon {
    private String name;
    private int attack;

    Weapon(String weaponName, int weaponAttack){
        name = weaponName;
        attack = weaponAttack;
    }

    public void setName(String weaponName) {
        this.name = weaponName;
    }
    public String getName() {
        return name;
    }

    public void setAttack(String weaponAttack) {
        this.name = weaponAttack;
    }
    public int getAttack() {
        return attack;
    }
}
