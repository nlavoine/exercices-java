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
    private String shield;

    Fighter(String shield){
        this.shield = shield;
    }

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

        return power;
    }
    /************************************/

    void setType(String fighterType) {

        this.type = fighterType;
    }

    String getType() {

        return type;
    }

    /************************************/
    void setShield(String fighterShield) {

        this.shield = fighterShield;
    }

    String getShield() {

        return shield;
    }

    public abstract void setStuff(Stuff fighterStuff);

    public abstract Stuff getStuff();
}
