package main.java;

public class Weapon extends Stuff {

    Weapon(String weaponName, int weaponAttack){
        super(weaponName, weaponAttack);
    }

    @Override
    public void setName(String weaponName) {
        this.name = weaponName;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setAttack(int weaponAttack) {
        this.attack = weaponAttack;
    }

    @Override
    public int getAttack() {
        return attack;
    }
}
