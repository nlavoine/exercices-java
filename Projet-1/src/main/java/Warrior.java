package main.java;

public class Warrior extends Fighter {

    private Stuff weapon;
    private Stuff shield;

    private final static int MIN_LIFE = 5;
    private final static int MAX_LIFE = 10;
    private final static int MIN_POWER = 5;
    private final static int MAX_POWER = 10;

    private int life;
    private int power;

    /**
     * @param fighterWeapon     Object : "Stuff" du warrior
     * @param fighterShield            String : "Shield" du warrior
     */
    Warrior(Stuff fighterWeapon, Stuff fighterShield) {
        setStuff(fighterWeapon);
        setSecondary(fighterShield);
        this.life = generateLife()*5;
        this.power = generatePower();
    }

    @Override
    public int getAttackPower(){
        double luck = (( Math.random()*( 10 - 5 + 1 ) ) + 5)/10;
        return (int)((this.power + this.weapon.getPower()) * luck);
    }

    @Override
    public int getDefensePower(){
        return this.shield.getPower();
    }

    /**
     * @return Entier correspondant à "life"
     */
    private int generateLife(){
        return (int)( Math.random()*( MAX_LIFE - MIN_LIFE + 1 ) ) + MIN_LIFE;
    }

    /**
     * @return Entier correspondant à "power"
     */
    private int generatePower(){
        return (int)( Math.random()*( MAX_POWER - MIN_POWER + 1 ) ) + MIN_POWER;
    }

    /**
     * @param fighterWeapon Stuff du Warrior
     */
    @Override
    public void setStuff(Stuff fighterWeapon) {

        this.weapon = fighterWeapon;
    }

    /**
     * @return Stuff Weapon
     */
    @Override
    public Stuff getStuff() {

        return weapon;
    }

    /************************************/
    @Override
    public void setSecondary(Stuff fighterShield) {

        this.shield = fighterShield;
    }

    @Override
    public Stuff getSecondary() {

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
