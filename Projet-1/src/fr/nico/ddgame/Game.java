package fr.nico.ddgame;

//import java.lang.reflect.Constructor;
//import java.lang.reflect.InvocationTargetException;
import fr.nico.ddgame.Exceptions.FighterUnknownException;
import fr.nico.ddgame.bonus.*;
import fr.nico.ddgame.fighters.Fighter;
import fr.nico.ddgame.items.*;
import fr.nico.ddgame.ui.*;
import fr.nico.ddgame.board.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Main game programme
 */
class Game {

    private  Scanner sc = new Scanner(System.in);
    private static final String[] FOODS = {"Apple", "Elixir"};
    private static final String[] FIGHTERS = {"Warrior", "Wizard"};
    private static final String[] OPTIONS = {"Afficher les joueurs", "Modifier les joueurs","Afficher les adversaires", "Modifier les adversaires", "⚔ Combat dans l'arène ⚔", "⚔ Combat dans le Donjon ⚔"};

    private static final String[] WEAPONS = {"Hache de bucheron", "Tournevis bélliqueux"};
    private static final String[] SHIELDS = {"Casque en mousse", "Plastron MDF"};


    private static final String[] SORTS = {"Etincelle du marchand", "Souffle fétide"};
    private static final String[] PHILTERS = {"Potion de soin min", "Plume de Phoenix"};

    private static final String[] OPPONENTS_NAMES = {"Beus","Dorusmoricu","Eodi","Falem","Hipo","Hontrote","Iaxenteran","Kroneul","Krseta","Krus","Leulaeagore","Lionusury","Maise","Mpynasytei","Thaeg","Tussiare","Visiteres","Visust","Viusopel","Xemel"};

    private static final int TOTAL_TILES = 15;
    private static final String[] TILES = {"TileEnnemy", "TileFood"};

    private ArrayList<Stuff> weaponList = new ArrayList<>();
    private ArrayList<Stuff> sortList = new ArrayList<>();
    private ArrayList<Stuff> shieldList = new ArrayList<>();
    private ArrayList<Stuff> philterList = new ArrayList<>();

    private ArrayList<Fighter> playerList = new ArrayList<>();
    private ArrayList<Fighter> opponentList = new ArrayList<>();

    private HashMap<String, ArrayList<Stuff>> stuffList = new HashMap<>();
    private HashMap<String, ArrayList<Stuff>> secondaryList = new HashMap<>();
    private HashMap<String, ArrayList<Fighter>> fightersList = new HashMap<>();

    private final ArrayList<Tile> board = new ArrayList<>();

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
        initBoard();
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
     * Create set of TILES
     */
    private void initBoard(){
        for(int i = 0; i<Game.TOTAL_TILES; i++){
            int randTileType = ((int)( Math.random()*( (Game.TILES.length-1) + 1 ) ));

            int randType;


            String fullPath = "fr.nico.ddgame.board."+TILES[randTileType];
            Tile currTile = null;


            switch (TILES[randTileType]){
                case "TileEnnemy":
                    randType = (int)( Math.random()*( (FIGHTERS.length-1) + 1 ) );
                    try {
                        currTile = new TileEnnemy(createFighter(randType, OPPONENTS_NAMES[0]));
                    } catch (FighterUnknownException e) {
                        e.printStackTrace();
                    }
                    break;
                case "TileFood" :
                    randType = (int)( Math.random()*( (FOODS.length-1) + 1 ) );
                    currTile = new TileFood(createFood(FOODS[randType]));


                    break;
            }

            board.add(currTile);
        }
    }


    /**
     * Create WEAPONS collection from array
     */
    private void initWeapons(){

        for(String weaponName : WEAPONS){
            int weaponPower = ((int)( Math.random()*( 10 - 3 + 1 ) ) + 3);
            weaponList.add(new Weapon(weaponName, weaponPower));
        }

    }

    /**
     * Create SORTS collection from array
     */
    private void initSorts(){

        for(String sortName : SORTS){
            int sortPower = (int)(( Math.random()*( 8 - 5 + 1 ) )+ 5);
            sortList.add(new Sort(sortName, sortPower));
        }
    }

    /**
     * Create SHIELDS collection from array
     */
    private void initShields(){

        for(String shieldName : SHIELDS){
            int shieldPower = (int)(( Math.random()*( 8 - 5 + 1 ) )+ 5);
            shieldList.add(new Shield(shieldName, shieldPower));
        }
    }

    /**
     * Create SHIELDS collection from array
     */
    private void initPhilters(){

        for(String philterName : PHILTERS){
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
                case 6:
                    goFighting = true;
                    fightTheDungeon();
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
        for(String option : OPTIONS){
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
            int currTry = 1;
            int maxTries = 3;
            boolean trying = true;

            while(trying) {
                try {
                    fightersList.get("players").add(tryToCreatePlayer(i));
                    trying = false;
                } catch (FighterUnknownException e) {

                    System.err.println(e.getMessage());
                    System.err.println("Veuillez séléctionner une classe dans la liste.");

                    if(currTry == maxTries) {
                        trying = false;
                        System.err.println("Le Fighter n'a pas pu être créé.");
                    }
                    currTry++;
                    //e.printStackTrace();
                }
            }

        }

        System.out.println(WinInitPlayer.footer());
    }

    private Fighter tryToCreatePlayer(int i) throws FighterUnknownException{
        WindowInitPlayer WinInitPlayer = new WindowInitPlayer();
        System.out.println(WinInitPlayer.askPlayerName(i+1));

        String fighterName = sc.nextLine();

        System.out.println(WinInitPlayer.askPlayerType());

        for(int j = 0; j < FIGHTERS.length; j++){
            System.out.println(WinInitPlayer.typeOptions(j+1, FIGHTERS[j]));
        }

        int fighterType = Integer.parseInt(sc.nextLine())-1;

        if(fighterType >= 0 && fighterType < FIGHTERS.length){
            return createFighter(fighterType, fighterName);
        } else {
            //e.printStackTrace();
            throw new FighterUnknownException("Classe saisie inexistante.");
            //askOptionsFighter();
        }

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
            randType = (int)( Math.random()*( (FIGHTERS.length-1) + 1 ) );
            try {
                fightersList.get("opponents").add(createFighter(randType, OPPONENTS_NAMES[i]));
            } catch (FighterUnknownException e) {
                e.printStackTrace();
            }
        }
        System.out.println(WinInitOpponent.footer(nbOpponents));

    }

    /**
     * @param fighterNumber int : represent the fighter class
     * @param fighterName String : fighter's name
     * @return Fighter fighter : the object fighter created
     */
    private Fighter createFighter(int fighterNumber, String fighterName ) throws FighterUnknownException {

        String fighterType = null;
        try {
            fighterType = FIGHTERS[fighterNumber];
        } catch (Exception e) {
            //e.printStackTrace();
            throw new FighterUnknownException("Fighter number "+ fighterNumber +" unknown");

        }

        int randStuff = (int)( Math.random()*( (stuffList.get(fighterType).size()-1) + 1 ) );
        int randSecondary = (int)( Math.random()*( (secondaryList.get(fighterType).size()-1) + 1 ) );

        String fullPath = "fr.nico.ddgame.fighters."+fighterType;
        Fighter fighter = null;
        try {
            Class<?> clazz = Class.forName(fullPath);
              fighter = ((Fighter)clazz.newInstance());
        } catch (Exception e) {
            e.printStackTrace();
        }

        fighter.setStuff(stuffList.get(fighterType).get(randStuff));
        fighter.setSecondary(secondaryList.get(fighterType).get(randSecondary));
        fighter.setName(fighterName);
        fighter.setType(FIGHTERS[fighterNumber]);
        return fighter;
    }

    private Food createFood(String foodType){
        String fullPath = "fr.nico.ddgame.bonus."+foodType;
        Food foodItem = null;

        try {
            Class<?> clazz = Class.forName(fullPath);
            foodItem = ((Food)clazz.newInstance());
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return foodItem;
    }


    /**
     * Display all FIGHTERS info for a team
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
            System.out.println(WinFightersList.options("Arme", fighter.getStuff().getName() + " [" + fighter.getStuff().getPower() + "]"));

            String label = fighter.getType().equals(FIGHTERS[0]) ? "Bouclier" : "Philtre";
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
     * Show all FIGHTERS to edit, waiting for the user to pick one
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
        System.out.println(WinFighterSelectEdit.footer());
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

        WindowFight WinFight = new WindowFight();

        System.out.println(WinFight.header());

        while (doFight){
            System.out.println(WinFight.displayRound(round));

            for (Fighter player : fightersList.get("players")){
                if(!fightersList.get("opponents").isEmpty()) {
                    System.out.println(WinFight.playerTurn(player.getName()));
                    System.out.println(WinFight.opponentQuestion());


                    int indexOpponents = 1;
                    for (Fighter opponent : fightersList.get("opponents")) {

                        System.out.println(WinFight.opponentOption(indexOpponents, opponent.getName(), opponent.getType(), opponent.getLife(), opponent.getPower(), opponent.getSecondary().getPower()));

                        indexOpponents++;
                    }

                    int selectedOpponent = (Integer.parseInt(sc.nextLine())-1);
                    Fighter targetOpponent = fightersList.get("opponents").get(selectedOpponent);

                    doAttack(player, targetOpponent, "opponents");
                }

                System.out.println(WinFight.separateFights());

            }

            if(fightersList.get("opponents").size()>0){
                //for(Iterator it = fightersList.get("opponents").iterator(); it.hasNext(); )
                for(Fighter opponent : fightersList.get("opponents")){
                    if(fightersList.get("players").size()>0) {
                        System.out.println(WinFight.pressEnter());
                        sc.nextLine();
                        System.out.println(WinFight.playerTurn(opponent.getName()));
                        int randPlayer = (int) (Math.random() * ((fightersList.get("players").size() - 1) + 1));
                        Fighter targetPlayer = fightersList.get("players").get(randPlayer);
                        System.out.println(WinFight.opponentAttack(opponent.getName(), targetPlayer.getName()));

                        doAttack(opponent, targetPlayer, "players");
                    }
                    System.out.println(WinFight.separateFights());
                }//ENDFOR opponents in opponentList
            }//ENDIF opponentList > 0

            if(fightersList.get("opponents").size()== 0){
                System.out.println(WinFight.footer());
                System.out.println(WinFight.finalWindows("BRAVO, les ennemis ont tous été vaincus."));
                doFight = false;

            }else if(fightersList.get("players").size()== 0){
                System.out.println(WinFight.footer());
                System.out.println(WinFight.finalWindows("Dommage, les ennemis vous ont éliminé."));

                doFight = false;
            }else{
                round++;
                System.out.println(WinFight.separateFights());
                for (Fighter player : fightersList.get("players")){
                    System.out.println(WinFight.showLife(player.getName(), player.getLife()));
                }
                for (Fighter opponent : fightersList.get("opponents")){
                    System.out.println(WinFight.showLife(opponent.getName(), opponent.getLife()));
                }
                System.out.println(WinFight.separateFights());
            }
        }//ENDWHILE
        showOptions();
    }

    private void doAttack(Fighter offenseFighter, Fighter defenseFighter, String team){
        int offenseFighterAttack = offenseFighter.getAttackPower();
        WindowFight WinDoAttack = new WindowFight();
        System.out.println(WinDoAttack.attackStep1(offenseFighter.getName(), offenseFighter.getStuff().getName(), offenseFighterAttack));

        int defenseFighterDefense = defenseFighter.getDefensePower();

        System.out.println(WinDoAttack.attackStep2(defenseFighter.getName(), defenseFighter.getSecondary().getName(), defenseFighterDefense));

        if (offenseFighterAttack <= defenseFighterDefense) {
            System.out.println(WinDoAttack.attackFailed(defenseFighter.getName()));
        } else {

            int damages = offenseFighterAttack - defenseFighterDefense;
            defenseFighter.setLife(defenseFighter.getLife() - damages);
            System.out.println(WinDoAttack.attackSuccess(offenseFighter.getName(),defenseFighter.getName()));
            if (defenseFighter.getLife() <= 0) {
                fightersList.get(team).remove(defenseFighter);
                System.out.println(WinDoAttack.fighterDied(defenseFighter.getName()));
            }else{
                System.out.println(WinDoAttack.fighterRemainingPoints(defenseFighter.getName(), damages, defenseFighter.getLife()));
            }
        }
    }


    private void fightTheDungeon(){
        WindowFighterSelectEdit WinFighterSelectEdit = new WindowFighterSelectEdit();
        System.out.println(WinFighterSelectEdit.header());

        int index = 0;
        for (Fighter player : fightersList.get("players")){
            System.out.println(WinFighterSelectEdit.options(index+1, player.getName()));
            index++;
        }
        int selectedPlayer = (Integer.parseInt(sc.nextLine())-1);
        System.out.println(WinFighterSelectEdit.footer());

        boolean dungeonLost = playDungeonTurn(playerList.get(selectedPlayer));
        if(dungeonLost){
            System.out.println("L'aventure dans le donjon est terminée");
        }else{
            System.out.println("Bravo vous avez terminé le donjon !");
        }
        showOptions();
    }

    private boolean playDungeonTurn(Fighter fighter){
        System.out.println("Vous entrez dans le Donjon !");
        System.out.println("Vous avez " + fighter.getLife() + " points de vie \n");

        boolean playerIsDead = false;
        for(int i = 0; i< board.size(); i++){
            generateBoard(i);
            playerIsDead = board.get(i).doAction(fighter);
            if(playerIsDead){
                break;
            }
            System.out.println("(\"Entrer\" pour continuer)");
            sc.nextLine();
        }
        return playerIsDead;
    }

    private void generateBoard(int currTile){
        String topBoard = "┌";
        for(int i=0; i<board.size(); i++){
            if(i == board.size()-1){
                topBoard += "───";
            }else {
                topBoard += "────";
            }
        }
        topBoard += "┐";

        String bodyBoard = "";
        for(int i=0; i<board.size(); i++){
            bodyBoard += "│";
            if(currTile == i){
                bodyBoard += " ☿";
            }else{
                bodyBoard += "  ";
            }
            if(i == board.size()-1){
                bodyBoard += " │";
            }else{
                bodyBoard += " ";
            }

        }
        String bodyBoard2 = "";
        for(int i=0; i<board.size(); i++){
            bodyBoard2 += "│";
            if(board.get(i).getClass().getSimpleName().equals("TileEnnemy")){
                bodyBoard2 += " ♉";
            }else if(board.get(i).getClass().getSimpleName().equals("TileFood")){
                bodyBoard2 += " ♥";
            }
            if(i == board.size()-1){
                bodyBoard2 += " │";
            }else{
                bodyBoard2 += " ";
            }

        }


        String bottomBoard = "└";
        for(int i=0; i<board.size(); i++){
            if(i == board.size()-1){
                bottomBoard += "───";
            }else {
                bottomBoard += "────";
            }
        }
        bottomBoard += "┘";

        System.out.println(topBoard);
        System.out.println(bodyBoard);
        System.out.println(bodyBoard2);
        System.out.println(bottomBoard);
    }
}

//cross : ♰
//cross 2: ✝
//Swords ⚔
//Hammer : ⚒
//Hermes : ⚚
//Pen : ✎
// magnifying : ⌕
// eye : ☉
