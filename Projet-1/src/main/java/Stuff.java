package main.java;

public abstract class Stuff {

    protected String name;
    protected int attack;

    Stuff(String weaponName, int weaponAttack){
        name = weaponName;
        attack = weaponAttack;
    }

    public abstract void setName(String stuffName);
    public abstract String getName();

    public abstract void setAttack(int stuffAttack);
    public abstract int getAttack();


}
