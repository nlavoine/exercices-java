package main.java;


public class Wizard extends Fighter {

    private Stuff sort;
    private String philter;

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
    public void setSecondary(String fighterPhilter) {

        this.philter = fighterPhilter;
    }

    public String getSecondary() {

        return philter;
    }
}
