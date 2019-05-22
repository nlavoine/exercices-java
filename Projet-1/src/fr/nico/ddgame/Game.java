package fr.nico.ddgame;

//import java.lang.reflect.Constructor;
//import java.lang.reflect.InvocationTargetException;
import fr.nico.ddgame.fighters.Fighter;
import fr.nico.ddgame.fighters.Warrior;
import fr.nico.ddgame.fighters.Wizard;
import fr.nico.ddgame.items.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Main game programme
 */
class Game {

    private  Scanner sc = new Scanner(System.in);
    private static final String[] fighters = {"Warrior", "Wizard"};
    private static final String[] options = {"Afficher les infos des joueurs", "Modifier les infos du personnage","Afficher les infos des adversaires", "Modifier les infos des adversaires", "Combattre !"};

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



//۸
//٧
    /**
     * Display game title
     */
    private void printTitle() {
        System.out.println("                                                                                                          ");
        System.out.println("                                    ˏ           ⎛⎝     ⎠⎞            ˎ                                    ");
        System.out.println("                                ˏ  ⎛(           ⎝ ◟   ◞ ⎠            )⎞  ˎ                                ");
        System.out.println("                               ⎛⎝ ⎛  ⎝         ≼⎛(¤⎝͡⎠¤)⎞≽          ⎠  ⎞ ⎠⎞                               ");
        System.out.println("❨◝◟◞◜◝◟◞◜◝◟◞◜◝◟◞◜◝◟◞◜◝◟◞◜◝◟◞◜◝◟◞◜◝◟◞◜◝◟◞◜◝◟◞◜◝◟◞◜◝◟◞◜◝◟◞◜◝◟◞◜◝◟◞◜◝◟◞◜◝◟◞◜◝◟◞◜◝◟◞◜◝◟◞◜◝◟◞◜◝◟◞◜◝◟◞◜◝◟◞◜◝◟◞◜❩");
        System.out.println(" ❩                                                                                                      ❨ ");
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
        System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("┃                    Que souhaitez-vous faire ?                       ┃");
        System.out.println("┃                    --> Entrer un numéro : ");
        int i = 0;
        for(String option : options){
            System.out.println("┃                  ["+(i+1)+"] " + option);
            i++;
        }
        System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
        System.out.println(" \n");

        return Integer.parseInt(sc.nextLine());

    }


    /**
     * Initialize players from user inputs (number of players and names)
     */
    private void initPlayers(){
        System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("┃                          Nombre de joueurs ?                        ┃");
        System.out.println("┠─────────────────────────────────────────────────────────────────────┨");

        int nbPlayers = Integer.parseInt(sc.nextLine());

        for(int i= 0 ; i < nbPlayers; i++){

            System.out.println("┃  Renseigner le nom du combattant " + (i+1) + " ");
            String fighterName = sc.nextLine();
            System.out.println("┃ ");
            System.out.println("┃       Selection du type     ");
            System.out.println("┃         [1] ⚒ " + fighters[0]);
            System.out.println("┃         [2] ⚚ " + fighters[1]);

            int fighterType = Integer.parseInt(sc.nextLine())-1;

            fightersList.get("players").add(createFighter(fighterType, fighterName));
        }

        System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
        System.out.println(" \n");
    }


    /**
     * Initialize opponents from user inputs (number of players. Names are set from array)
     */
    private void initOpponents(){
        System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("┃                       Nombre d'adversaire ?                         ┃");
        System.out.println("┃                                                                     ┃");

        int nbOpponents = Integer.parseInt(sc.nextLine());
        int randType;

        for(int i= 0 ; i < nbOpponents; i++){
            randType = (int)( Math.random()*( (fighters.length-1) + 1 ) );
            fightersList.get("opponents").add(createFighter(randType, opponentsNames[i]));
        }
        System.out.println("┃ " + nbOpponents + " adversaires créés                               ┃");
        System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
        System.out.println(" \n");
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
     * @param team String : which team to display players/opponents
     */
    private void displayFightersList(String team){

        System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("┃                           ATTRIBUTS                                 ┃");
        System.out.println("┃");
        for (Fighter fighter : fightersList.get(team)){
            System.out.println("┠─────────────────────────────────────────────────────────────────────┨");
            System.out.println("┃   Nom : " + fighter.getName());
            System.out.println("┃   Type : " + fighter.getType());
            System.out.println("┃   Vie : " + fighter.getLife());
            System.out.println("┃   Force : " + fighter.getPower());
            System.out.println("┃   Arme : " + fighter.getStuff().getName() + " - " + fighter.getStuff().getPower());

            String secondaryP1 = fighter.getType().equals(fighters[0]) ? "┃   Bouclier : " : "┃   Philtre : ";
            String secondaryP2=fighter.getSecondary().getName() + " - " + fighter.getSecondary().getPower();

            System.out.println(secondaryP1 + secondaryP2);

        }
        System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
        System.out.println(" \n");




    }


    /**
     * Show all fighters to edit, waiting for the user to pick one
     * @param team String : which team to edit players/opponents
     */
    private void editFighter(String team) {
        System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("┃                          EDITER UN JOUEUR                           ┃");
        System.out.println("┃");
        System.out.println("┃ Quel adverssaire voulez-vous modifier :");
        int index = 0;
        for (Fighter player : fightersList.get(team)){
            System.out.println("┃   [" + (index+1) + "]" + player.getName());
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
        System.out.println("┠─────────────────────────────────────────────────────────────────────┨");
        System.out.println("┃                              ATTRIBUTS                              ┃");
        System.out.println("┃");
        System.out.println("┃ Le combattant s'appel " + caracter.getName() + ".");
        System.out.println("┃ **** Renseigner son nouveau nom :");

        caracter.setName(sc.nextLine());
        System.out.println("┃");

        System.out.println("┃ " + caracter.getName() + " a " + caracter.getLife() + " points de Vie.");
        System.out.println("┃ **** Renseigner ses points de Vie :");

        caracter.setLife(sc.nextInt());
        sc.nextLine();
        System.out.println("┃");

        System.out.println("┃ " + caracter.getName() + " a " + caracter.getPower() + " points de Force.");
        System.out.println("┃ **** Renseigner enfin ses points de Force :");

        caracter.setPower(sc.nextInt());
        sc.nextLine();
        System.out.println("┃");

        System.out.println("┃");
        System.out.println("┃┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┃");
        System.out.println("┃            EQUIPEMENTS           ||");
        System.out.println("┃");

        System.out.println("┃ Arme de " + caracter.getName() + " : " + caracter.getStuff().getName());
        System.out.println("┃ **** Quelle arme souhaitez-vous lui équiper ?");
        System.out.println("┃");

        for (int i = 0; i < stuffList.get(caracter.getType()).size(); i++) {
            System.out.println("┃      [" + (i + 1) + "] " + stuffList.get(caracter.getType()).get(i).getName() + " - " + stuffList.get(caracter.getType()).get(i).getPower());
        }

        caracter.setStuff(weaponList.get(sc.nextInt() - 1));
        sc.nextLine();

        String secondaryP1 = caracter.getType() == fighters[0] ? "┃ Bouclier de " : "┃ Philtre de ";
        String secondaryP2 = caracter.getName() + " : " + caracter.getSecondary();
        System.out.println(secondaryP1 + secondaryP2);

        System.out.println("┃ **** Quelle équipement secondaire souhaitez-vous lui équiper ?");
        System.out.println("┃");
        for (int i = 0; i < secondaryList.get(caracter.getType()).size(); i++) {
            System.out.println("┃     [" + (i + 1) + "] " + secondaryList.get(caracter.getType()).get(i).getName() + " - " + secondaryList.get(caracter.getType()).get(i).getPower());
        }

        caracter.setSecondary(secondaryList.get(caracter.getType()).get(sc.nextInt() - 1));
        sc.nextLine();

        System.out.println("┃");
        System.out.println("┃   * Mise à jour du Combattant *");
        System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
        System.out.println(" \n");
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
