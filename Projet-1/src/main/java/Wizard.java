package main.java;


public class Wizard extends Fighter {

    private Stuff sort;
    private String philter;

    final static int MIN_LIFE = 3;
    final static int MAX_LIFE = 6;
    final static int MIN_POWER = 8;
    final static int MAX_POWER = 15;

    private int life;
    private int power;

    Wizard(Stuff fighterSort, String philter) {
        setStuff(fighterSort);
        setSecondary(philter);
    }

    @Override
    public void setStuff(Stuff fighterSort) {

        this.sort = fighterSort;
    }

    @Override
    public Stuff getStuff() {

        return sort;
    }
    /************************************/
    @Override
    public void setSecondary(String fighterPhilter) {

        this.philter = fighterPhilter;
    }

    @Override
    public String getSecondary() {

        return philter;
    }
    /************************************/

    @Override
    void setLife(int fighterLife) {

        this.life = fighterLife;
    }

    @Override
    int getLife() {

        return life;
    }
    /************************************/

    @Override
    void setPower(int fighterPower) {

        this.power = fighterPower;
    }

    @Override
    int getPower() {

        return this.power;
    }
}
