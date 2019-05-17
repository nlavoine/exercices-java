package main.java;

import java.util.List;

public abstract class Fighter {


    protected String name;
    //private String image;

    final int minLife = 5;
    final int maxLife = 10;
    final int minPower = 5;
    final int maxPower = 10;

    protected int life;
    protected int power;

    abstract void displayInfos();
    abstract void editInfos(List<Weapon> weaponList, List<Sort> sortList);
    public abstract void setName(String fighterName);
    public abstract void setLife(int fighterLife);
    public abstract void setPower(int fighterPower);







}
