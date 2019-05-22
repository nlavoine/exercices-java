package fr.nico.ddgame.fighters;


import fr.nico.ddgame.items.Stuff;

public abstract class Fighter {

    private String name;
    private String type;


    /************************************/


    public void setName(String fighterName) {

        this.name = fighterName;
    }


    public String getName() {

        return name;
    }

    /************************************/

    public void setType(String fighterType) {

        this.type = fighterType;
    }

    public String getType() {

        return type;
    }

    public abstract int getAttackPower();
    public abstract int getDefensePower();

    public abstract void setStuff(Stuff fighterStuff);

    public abstract Stuff getStuff();

    public abstract void setSecondary(Stuff fighterSecondary);

    public abstract Stuff getSecondary();

    public abstract void setLife(int fighterLife);

    public abstract int getLife();

    public abstract void setPower(int fighterPower);

    public abstract int getPower();
}
