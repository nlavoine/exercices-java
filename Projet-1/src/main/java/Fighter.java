package main.java;


public abstract class Fighter {


    private String name;
    //private String image;

    final static int minLife = 5;
    final static int maxLife = 10;
    final static int minPower = 5;
    final static int maxPower = 10;

    private int life;
    private int power;
    private String type;

    /*Fighter(String shield){
        this.shield = shield;
    }*/

    /************************************/

    void setName(String fighterName) {

        this.name = fighterName;
    }


    String getName() {

        return name;
    }
    /************************************/

    void setLife(int fighterLife) {

        this.life = fighterLife;
    }

    int getLife() {

        return life;
    }
    /************************************/

    void setPower(int fighterPower) {

        this.power = fighterPower;
    }

    int getPower() {

        return this.power;
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
}
