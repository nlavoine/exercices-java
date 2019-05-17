package main.java;

public class Sort extends Stuff{

    Sort(String weaponName, int weaponAttack){
        super(weaponName, weaponAttack);
    }

    @Override
    public void setName(String sortName) {
        this.name = sortName;
    }
    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setAttack(int sortAttack) {
        this.attack = sortAttack;
    }

    @Override
    public int getAttack() {
        return attack;
    }
}
