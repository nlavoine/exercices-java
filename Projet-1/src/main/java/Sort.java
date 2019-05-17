package main.java;

public class Sort {

    private String name;
    private int attack;

    Sort(String sortName, int sortAttack){
        name = sortName;
        attack = sortAttack;
    }

    public void setName(String sortName) {
        this.name = sortName;
    }
    public String getName() {
        return name;
    }

    public void setAttack(String attackName) {
        this.name = attackName;
    }
    public int getAttack() {
        return attack;
    }
}
