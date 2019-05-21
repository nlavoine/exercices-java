package main.java;


public class Wizard extends Fighter {

    private Stuff sort;
    private String philter;

    private final static int MIN_LIFE = 3;
    private final static int MAX_LIFE = 6;
    private final static int MIN_POWER = 8;
    private final static int MAX_POWER = 15;

    private int life;
    private int power;

    Wizard(Stuff fighterSort, String philter) {
        setStuff(fighterSort);
        setSecondary(philter);
        this.life = generateLife();
        this.power = generatePower();

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
     * @param fighterSort Stuff du Wizard
     */
    @Override
    public void setStuff(Stuff fighterSort) {

        this.sort = fighterSort;
    }

    /**
     * @return Stuff Sort
     */
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
