package main.java;


public class Warrior extends Fighter {

    private Stuff weapon;
    private String shield;

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
}
