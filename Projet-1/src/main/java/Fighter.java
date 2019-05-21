package main.java;


public abstract class Fighter {

    private String name;
    private String type;


    /************************************/


    void setName(String fighterName) {

        this.name = fighterName;
    }


    String getName() {

        return name;
    }

    /************************************/

    void setType(String fighterType) {

        this.type = fighterType;
    }

    String getType() {

        return type;
    }



    public abstract void setStuff(Stuff fighterStuff);

    public abstract Stuff getStuff();

    public abstract void setSecondary(String fighterSecondary);

    public abstract String getSecondary();

    abstract void setLife(int fighterLife);

    abstract int getLife();

    abstract void setPower(int fighterPower);

    abstract int getPower();
}
