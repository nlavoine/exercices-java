package main.java;


public class Warrior extends Fighter {

    private Stuff weapon;
    private String shield;

    public final static int MIN_LIFE = 5;
    public final static int MAX_LIFE = 10;
    public final static int MIN_POWER = 5;
    public final static int MAX_POWER = 10;

    private int life;
    private int power;

    Warrior(Stuff fighterWeapon, String shield) {
        setStuff(fighterWeapon);
        setSecondary(shield);

    }

    @Override
    public void setStuff(Stuff fighterWeapon) {

        this.weapon = fighterWeapon;
    }

    @Override
    public Stuff getStuff() {

        return weapon;
    }

    /************************************/
    @Override
    public void setSecondary(String fighterShield) {

        this.shield = fighterShield;
    }

    @Override
    public String getSecondary() {

        return shield;
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

    /************************************/
}
