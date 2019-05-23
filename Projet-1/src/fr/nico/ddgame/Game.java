package fr.nico.ddgame;

//import java.lang.reflect.Constructor;
//import java.lang.reflect.InvocationTargetException;
import fr.nico.ddgame.fighters.Fighter;
import fr.nico.ddgame.fighters.Warrior;
import fr.nico.ddgame.fighters.Wizard;
import fr.nico.ddgame.items.*;
import fr.nico.ddgame.ui.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Main game programme
 */
class Game {

    private  Scanner sc = new Scanner(System.in);
    private static final String[] fighters = {"Warrior", "Wizard"};
    private static final String[] options = {"Afficher les joueurs", "Modifier les joueurs","Afficher les adversaires", "Modifier les adversaires", "⚔ Combattre ! ⚔"};

    private static final String[] weapons = {"Hache de bucheron", "Tournevis bélliqueux"};
    private static final String[] shields = {"Casque en mousse", "Plastron MDF"};


    private static final String[] sorts = {"Etincelle du marchand", "Souffle fétide"};
    private static final String[] philters = {"Potion de soin min", "Plume de Phoenix"};



    private static final String[] opponentsNames = {"Beus","Dorusmoricu","Eodi","Falem","Hipo","Hontrote","Iaxenteran","Kroneul","Krseta","Krus","Leulaeagore","Lionusury","Maise","Mpynasytei","Thaeg","Tussiare","Visiteres","Visust","Viusopel","Xemel"};


    private static ArrayList<Stuff> weaponList = new ArrayList<>();
    private static ArrayList<Stuff> sortList = new ArrayList<>();
    private static ArrayList<Stuff> shieldList = new ArrayList<>();
    private static ArrayList<Stuff> philterList = new ArrayList<>();


    private static ArrayList<Fighter> playerList = new ArrayList<>();
    private static ArrayList<Fighter> opponentList = new ArrayList<>();

    private static HashMap<String, ArrayList<Stuff>> stuffList = new HashMap<>();
    private static HashMap<String, ArrayList<Stuff>> secondaryList = new HashMap<>();
    private static HashMap<String, ArrayList<Fighter>> fightersList = new HashMap<>();


    /**
     * Init game lists
     */
    Game() {

        stuffList.put("Warrior", weaponList);
        stuffList.put("Wizard", sortList);

        secondaryList.put("Warrior", shieldList);
        secondaryList.put("Wizard", philterList);

        fightersList.put("players", playerList);
        fightersList.put("opponents", opponentList);
    }


    /**
     * init game environment
     */
    void play(){
        printTitle();
        initWeapons();
        initSorts();
        initShields();
        initPhilters();
        initPlayers();
        initOpponents();
        showOptions();
    }

    /**
     * Display game title
     */
    private void printTitle() {
        System.out.println("                                                                                                          ");
        System.out.println("                                    ˏ           ⎛⎝     ⎠⎞            ˎ                                    ");
        System.out.println("                                ˏ  ⎛(           ⎝ ◟   ◞ ⎠            )⎞  ˎ                                ");
        System.out.println("                               ⎛⎝ ⎛  ⎝         ≼⎛(¤⎝͡⎠¤)⎞≽          ⎠  ⎞ ⎠⎞                               ");
        System.out.println("❨◝◟◞◜◝◟◞◜◝◟◞◜◝◟◞◜◝◟◞◜◝◟◞◜◝◟◞◜◝◟◞◜◝◟◞◜◝◟◞◜◝◟◞◜◝◟◞╲῭ º͡º ΅╱◝◟◞◜◝◟◞◜◝◟◞◜◝◟◞◜◝◟◞◜◝◟◞◜◝◟◞◜◝◟◞◜◝◟◞◜◝◟◞◜◝◟◞◜◝◟◞◜❩");
        System.out.println(" ❩                                                  ٧ ﹷ ٧                                               ❨ ");
        System.out.println("❨       ██▄     ▄      ▄     ▄▀  ▄███▄   ████▄    ▄           ██▄   █▄▄▄▄ ██     ▄▀  ████▄    ▄          ❩");
        System.out.println(" ❩      █  █     █      █  ▄▀    █▀   ▀  █   █     █          █  █  █  ▄▀ █ █  ▄▀    █   █     █        ❨ ");
        System.out.println("❨       █   █ █   █ ██   █ █ ▀▄  ██▄▄    █   █ ██   █         █   █ █▀▀▌  █▄▄█ █ ▀▄  █   █ ██   █        ❩");
        System.out.println(" ❩      █  █  █   █ █ █  █ █   █ █▄   ▄▀ ▀████ █ █  █         █  █  █  █  █  █ █   █ ▀████ █ █  █       ❨ ");
        System.out.println("❨       ███▀  █▄ ▄█ █  █ █  ███  ▀███▀         █  █ █    &    ███▀    █      █  ███        █  █ █        ❩");
        System.out.println(" ❩             ▀▀▀  █   ██                     █   ██                ▀      █              █   ██       ❨ ");
        System.out.println("❨                                                                          ▀                             ❩");
        System.out.println(" ◝◟◞◜◝◟◞◜◝◟◞◜◝◟◞◜◝◟◞◜◝◟◞◜◝◟◞◜◝◟◞◜◝◟◞◜◝◟◞◜◝◟◞◜◝◟◞◜◝◟◞◜◝◟◞◜◝◟◞◜◝◟◞◜◝◟◞◜◝◟◞◜◝◟◞◜◝◟◞◜◝◟◞◜◝◟◞◜◝◟◞◜◝◟◞◜◝◟◞◜◝◟◞◜ ");
        System.out.println("                                   ⎞⎠               ٧               ⎝⎛                                    ");
        System.out.println("                                                                                                          ");
        System.out.println("                                                                                                          ");
    }


    /**
     * Create weapons collection from array
     */
    private void initWeapons(){

        for(String weaponName : weapons){
            int weaponPower = ((int)( Math.random()*( 10 - 3 + 1 ) ) + 3);
            weaponList.add(new Weapon(weaponName, weaponPower));
        }

    }

    /**
     * Create sorts collection from array
     */
    private void initSorts(){

        for(String sortName : sorts){
            int sortPower = (int)(( Math.random()*( 8 - 5 + 1 ) )+ 5);
            sortList.add(new Sort(sortName, sortPower));
        }
    }

    /**
     * Create shields collection from array
     */
    private void initShields(){

        for(String shieldName : shields){
            int shieldPower = (int)(( Math.random()*( 8 - 5 + 1 ) )+ 5);
            shieldList.add(new Shield(shieldName, shieldPower));
        }
    }

    /**
     * Create shields collection from array
     */
    private void initPhilters(){

        for(String philterName : philters){
            int philterPower = (int)(( Math.random()*( 10 - 3 + 1 ) )+ 3);
            philterList.add(new Philter(philterName , philterPower));
        }
    }

    /**
     * Do things from user choice
     */
    private void showOptions(){
        boolean goFighting = false;
        while(!goFighting) {
            int selectedOption = askOptionsFighter();

            switch(selectedOption) {
                case 1:
                    displayFightersList("players");
                    break;
                case 2:
                    editFighter("players");
                    break;
                case 3:
                    displayFightersList("opponents");
                    break;
                case 4:
                    editFighter("opponents");
                    break;
                case 5:
                    goFighting = true;
                    fight();
                    break;
            }
        }
    }


    /**
     * Display menu to user
     * @return integer from user input
     */
    private int askOptionsFighter() {
        WindowMenu WinMenu = new WindowMenu();
        System.out.println(WinMenu.header());

        int i = 0;
        for(String option : options){
            System.out.println(WinMenu.option(i+1, option));
            i++;
        }
        System.out.println(WinMenu.footer());

        return Integer.parseInt(sc.nextLine());

    }


    /**
     * Initialize players from user inputs (number of players and names)
     */
    private void initPlayers(){

        WindowInitPlayer WinInitPlayer = new WindowInitPlayer();
        System.out.println(WinInitPlayer.header());


        int nbPlayers = Integer.parseInt(sc.nextLine());

        for(int i= 0 ; i < nbPlayers; i++){

            System.out.println(WinInitPlayer.askPlayerName(i+1));

            String fighterName = sc.nextLine();

            System.out.println(WinInitPlayer.emptyLine());
            System.out.println(WinInitPlayer.askPlayerType());

            for(int j = 0; j < fighters.length; j++){
                System.out.println(WinInitPlayer.typeOptions(j+1, fighters[j]));
            }

            int fighterType = Integer.parseInt(sc.nextLine())-1;

            fightersList.get("players").add(createFighter(fighterType, fighterName));
        }

        System.out.println(WinInitPlayer.footer());
    }


    /**
     * Initialize opponents from user inputs (number of players. Names are set from array)
     */
    private void initOpponents(){

        WindowInitOpponent WinInitOpponent = new WindowInitOpponent();
        System.out.println(WinInitOpponent.header());

        int nbOpponents = Integer.parseInt(sc.nextLine());
        int randType;


        for(int i= 0 ; i < nbOpponents; i++){
            randType = (int)( Math.random()*( (fighters.length-1) + 1 ) );
            fightersList.get("opponents").add(createFighter(randType, opponentsNames[i]));
        }
        System.out.println(WinInitOpponent.footer(nbOpponents));

    }

    /**
     * @param fighterNumber int : represent the fighter class
     * @param fighterName String : fighter's name
     * @return Fighter fighter : the object fighter created
     */
    private Fighter createFighter(int fighterNumber, String fighterName ) {
        Fighter fighter;
        String fighterType = fighters[fighterNumber];

        int randStuff = (int)( Math.random()*( (stuffList.get(fighterType).size()-1) + 1 ) );
        int randSecondary = (int)( Math.random()*( (secondaryList.get(fighterType).size()-1) + 1 ) );

        switch(fighterNumber) {
            case 0:
                fighter = new Warrior(stuffList.get(fighterType).get(randStuff), secondaryList.get(fighterType).get(randSecondary));
                break;
            case 1:
                fighter = new Wizard(stuffList.get(fighterType).get(randStuff), secondaryList.get(fighterType).get(randSecondary));
                break;
            default:
                fighter = null;
        }

        /*String fullPath = "main.java."+fighterType;
        Fighter fighter = null;
        try {
            Class<?> clazz = Class.forName(fullPath);
            Constructor<?> constructor = clazz.getConstructor(Stuff.class,String.class);
            fighter = ((Fighter)constructor.newInstance(stuffList.get(fighterType).get(randStuff), secondaryList.get(fighterType)[randSecondary]));
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }*/

        fighter.setName(fighterName);
        fighter.setType(fighters[fighterNumber]);
        return fighter;
    }

    //cross : ♰
    //cross 2: ✝
    //Swords ⚔
    //Hammer : ⚒
    //Hermes : ⚚
    //Pen : ✎
    // magnifying : ⌕
    // eye : ☉

    /**
     * Display all fighters info for a team
     * @param team String : which team to UiBox players/opponents
     */
    private void displayFightersList(String team){

        WindowFightersList WinFightersList = new WindowFightersList();
        System.out.println(WinFightersList.header());

        int index = 0;
        for (Fighter fighter : fightersList.get(team)){
            System.out.println(WinFightersList.emptyLine());
            System.out.println(WinFightersList.options("Nom", fighter.getName()));
            System.out.println(WinFightersList.options("Type", fighter.getType()));
            System.out.println(WinFightersList.options("Vie", Integer.toString(fighter.getLife())));
            System.out.println(WinFightersList.options("Force ", Integer.toString(fighter.getPower())));
            System.out.println(WinFightersList.options("Arme", fighter.getStuff().getName() + " - " + fighter.getStuff().getPower()));

            String label = fighter.getType().equals(fighters[0]) ? "Bouclier" : "Philtre";
            String value = fighter.getSecondary().getName() + " [" + fighter.getSecondary().getPower() + "]";

            System.out.println(WinFightersList.options(label, value));

            System.out.println(WinFightersList.emptyLine());

            if(index < (fightersList.size())-1){
                System.out.println(WinFightersList.filledLine());
            }
            index++;
        }
        System.out.println(WinFightersList.footer());
    }


    /**
     * Show all fighters to edit, waiting for the user to pick one
     * @param team String : which team to edit players/opponents
     */
    private void editFighter(String team) {
        WindowFighterSelectEdit WinFighterSelectEdit = new WindowFighterSelectEdit();
        System.out.println(WinFighterSelectEdit.header());

        int index = 0;
        for (Fighter player : fightersList.get(team)){
            System.out.println(WinFighterSelectEdit.options(index+1, player.getName()));
            index++;
        }
        int selectedPlayer = (Integer.parseInt(sc.nextLine())-1);
        editInfos(playerList.get(selectedPlayer));
    }

    /**
     * Edit all attribut for a given fighter
     * @param caracter Fighter : fighter to be edited
     */
    private void editInfos(Fighter caracter){

        WindowFighterEdit WinFighterEdit = new WindowFighterEdit();
        System.out.println(WinFighterEdit.header(caracter.getName()));
        System.out.println(WinFighterEdit.contentLine("ATTRIBUTS"));

        System.out.println(WinFighterEdit.askFighterName(caracter.getName()));

        caracter.setName(sc.nextLine());

        System.out.println(WinFighterEdit.askFighterLife(caracter.getName(), caracter.getLife()));

        caracter.setLife(sc.nextInt());
        sc.nextLine();

        System.out.println(WinFighterEdit.askFighterPower(caracter.getName(), caracter.getPower()));

        caracter.setPower(sc.nextInt());
        sc.nextLine();

        System.out.println(WinFighterEdit.askFighterPower(caracter.getName(), caracter.getPower()));

        System.out.println(WinFighterEdit.contentLine("EQUIPEMENTS"));

        System.out.println(WinFighterEdit.askFighterStuff(caracter.getName(), caracter.getStuff().getName()));


        for (int i = 0; i < stuffList.get(caracter.getType()).size(); i++) {
            System.out.println(WinFighterEdit.stuffOption(i+1, stuffList.get(caracter.getType()).get(i).getName(),stuffList.get(caracter.getType()).get(i).getPower()));
        }

        caracter.setStuff(weaponList.get(sc.nextInt() - 1));
        sc.nextLine();


        System.out.println(WinFighterEdit.askFighterStuff(caracter.getName(), caracter.getSecondary().getName()));

        for (int i = 0; i < secondaryList.get(caracter.getType()).size(); i++) {
            System.out.println(WinFighterEdit.stuffOption(i+1, secondaryList.get(caracter.getType()).get(i).getName(),secondaryList.get(caracter.getType()).get(i).getPower()));
        }

        caracter.setSecondary(secondaryList.get(caracter.getType()).get(sc.nextInt() - 1));
        sc.nextLine();

        System.out.println(WinFighterEdit.footer(caracter.getName()));
    }




    private void fight(){
        boolean doFight = true;
        int round = 1;

        System.out.println("▛▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▜");
        System.out.println("▌                           DEBUT DU COMBAT                           ▐");
        System.out.println("▌");

        while (doFight){
            System.out.println("▌                          [[ Round " + round + " ]]");
            System.out.println("▌");
            for (Fighter player : fightersList.get("players")){
                if(fightersList.get("opponents").size()>0) {
                    System.out.println("▌");
                    System.out.println("▌                         ==[ A " + player.getName() + " de jouer ! ]==");
                    System.out.println("▌                         **** Choissez un adversaire :");
                    System.out.println("▌");

                    int indexOpponents = 1;
                    for (Fighter opponent : fightersList.get("opponents")) {
                        System.out.println("▌   [" + indexOpponents + "] " + opponent.getName() + "  (" + opponent.getType() + ")");
                        System.out.println("▌   [ Vie : " + opponent.getLife() + " ] [  Puissance : " + opponent.getPower() + " ] [ Points de défense : " + opponent.getSecondary().getPower() + " ]");
                        System.out.println("▌");
                        indexOpponents++;
                    }

                    int selectedOpponent = (Integer.parseInt(sc.nextLine())-1);
                    Fighter targetOpponent = fightersList.get("opponents").get(selectedOpponent);

                    doAttack(player, targetOpponent, "players");
                }
                System.out.println("▌");
                System.out.println("▌┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈▌");
                System.out.println("▌");
            }

            if(fightersList.get("opponents").size()>0){
                for(Fighter opponent : fightersList.get("opponents")){
                    if(fightersList.get("players").size()>0) {
                        System.out.println("▌ (press enter to continue)");
                        sc.nextLine();
                        System.out.println("▌                         ==[ A " + opponent.getName() + " de jouer ! ]==");
                        int randPlayer = (int) (Math.random() * ((fightersList.get("players").size() - 1) + 1));
                        Fighter targetPlayer = fightersList.get("players").get(randPlayer);
                        System.out.println("▌   " + opponent.getName() + " attaque " + targetPlayer.getName());

                        doAttack(opponent, targetPlayer, "opponents");
                    }
                    System.out.println("▌");
                    System.out.println("▌┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈▌");
                    System.out.println("▌");
                }//ENDFOR opponents in opponentList
            }//ENDIF opponentList > 0

            if(fightersList.get("opponents").size()== 0){
                System.out.println("▙▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▟");
                System.out.println(" ");
                System.out.println(" ");
                System.out.println("╔═════════════════════════════════════════════════════════════════════╗");
                System.out.println("║                                                                     ║");
                System.out.println("║               BRAVO, les ennemis ont tous été vaincus               ║");
                System.out.println("║                             FIN DU COMBAT                           ║");
                System.out.println("║                                                                     ║");
                System.out.println("╚═════════════════════════════════════════════════════════════════════╝");
                doFight = false;

            }else if(fightersList.get("players").size()== 0){
                System.out.println("▙▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▟");
                System.out.println(" ");
                System.out.println(" ");
                System.out.println("╔═════════════════════════════════════════════════════════════════════╗");
                System.out.println("║                                                                     ║");
                System.out.println("║               Dommage, les ennemis vous ont éliminé                 ║");
                System.out.println("║                             FIN DU COMBAT                           ║");
                System.out.println("║                                                                     ║");
                System.out.println("╚═════════════════════════════════════════════════════════════════════╝");
                doFight = false;
            }else{
                round++;
                System.out.println("▌");
                System.out.println("▌");
                System.out.println("▌┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈▌");
                for (Fighter player : fightersList.get("players")){
                    System.out.println("▌   ||  " + player.getName() + " ❤️ "+ player.getLife()+"");
                }
                for (Fighter opponent : fightersList.get("opponents")){
                    System.out.println("▌   ||  " + opponent.getName() + " ❤️ "+ opponent.getLife()+"");
                }
                System.out.println("▌┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈▌");
                System.out.println("▌");
            }
        }//ENDWHILE
        showOptions();
    }

    private void doAttack(Fighter offenseFighter, Fighter defenseFighter, String team){
        int offenseFighterAttack = offenseFighter.getAttackPower();
        System.out.println("▌   " + offenseFighter.getName() + " attaque avec " + offenseFighter.getStuff().getName() + ". || Puissance d'attaque : " + offenseFighterAttack);

        int defenseFighterDefense = defenseFighter.getDefensePower();
        System.out.println("▌   " + defenseFighter.getName() + " se défend avec " + defenseFighter.getSecondary().getName() + ". || Puissance de défense : " + defenseFighterDefense);

        if (offenseFighterAttack <= defenseFighterDefense) {
            System.out.println("▌   " + defenseFighter.getName() + " a paré le coup. Echec de l'attaque");
        } else {

            int damages = offenseFighterAttack - defenseFighterDefense;
            defenseFighter.setLife(defenseFighter.getLife() - damages);

            System.out.println("▌   " + offenseFighter.getName() + " a touché " + defenseFighter.getName());

            if (defenseFighter.getLife() <= 0) {
                fightersList.get(team).remove(defenseFighter);
                System.out.println("▌   " + defenseFighter.getName() + " a été vaincu");
            }else{
                System.out.println("▌   " + defenseFighter.getName() + " a perdu " + damages + " points de vie. \u2764 " + defenseFighter.getLife());
            }
        }
    }


}
