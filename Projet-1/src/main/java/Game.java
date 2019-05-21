package main.java;

import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Game {

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


    private static ArrayList<Fighter> playerList = new ArrayList<>();
    private static ArrayList<Fighter> opponentList = new ArrayList<>();

    private static HashMap<String, ArrayList<Stuff>> stuffList = new HashMap<>();
    private static HashMap<String, String[]> secondaryList = new HashMap<>();
    private static HashMap<String, ArrayList<Fighter>> fightersList = new HashMap<>();


    public Game() {

        stuffList.put("Warrior", weaponList);
        stuffList.put("Wizard", sortList);

        secondaryList.put("Warrior", shields);
        secondaryList.put("Wizard", philters);

        fightersList.put("players", playerList);
        fightersList.put("opponents", opponentList);
    }

    void play(){
        printTitle();
        initWeapons();
        initSorts();
        initPlayers();
        initOpponents();
        showOptions();
    }

    private void printTitle() {

        System.out.println("  ██▄     ▄      ▄     ▄▀  ▄███▄   ████▄    ▄           ██▄   █▄▄▄▄ ██     ▄▀  ████▄    ▄ ");
        System.out.println("  █  █     █      █  ▄▀    █▀   ▀  █   █     █          █  █  █  ▄▀ █ █  ▄▀    █   █     █ ");
        System.out.println("  █   █ █   █ ██   █ █ ▀▄  ██▄▄    █   █ ██   █         █   █ █▀▀▌  █▄▄█ █ ▀▄  █   █ ██   █ ");
        System.out.println("  █  █  █   █ █ █  █ █   █ █▄   ▄▀ ▀████ █ █  █         █  █  █  █  █  █ █   █ ▀████ █ █  █ ");
        System.out.println("  ███▀  █▄ ▄█ █  █ █  ███  ▀███▀         █  █ █    &    ███▀    █      █  ███        █  █ █ ");
        System.out.println("         ▀▀▀  █   ██                     █   ██                ▀      █              █   ██ ");
        System.out.println("                                                                     ▀ ");

    }


    private int askOptionsFighter() {
        System.out.println("=======================================================================");
        System.out.println("||                   Que souhaitez-vous faire ?                      ||");
        System.out.println("||                   --> Entrer un numéro : ");
        int i = 0;
        for(String option : options){
            System.out.println("||                 ["+(i+1)+"] " + option);
            i++;
        }
        System.out.println("=======================================================================");
        System.out.println(" \n");

        return Integer.parseInt(sc.nextLine());

    }

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
                    //fight(fighter, opponent);
                    break;
            }
        }
    }

    private void initPlayers(){
        System.out.println("=======================================================================");
        System.out.println("||                         Nombre de joueurs ?                       ||");
        System.out.println("=======================================================================");

        int nbPlayers = Integer.parseInt(sc.nextLine());

        for(int i= 0 ; i < nbPlayers; i++){

            System.out.println("|| Renseigner le nom du combattant " + (i+1) + " ");
            String fighterName = sc.nextLine();
            System.out.println("||");

            System.out.println("||      Selection du type     ");
            System.out.println("||        [1] " + fighters[0]);
            System.out.println("||        [2] " + fighters[1]);

            int fighterType = Integer.parseInt(sc.nextLine())-1;

            fightersList.get("players").add(createFighter(fighterType, fighterName));
        }

        System.out.println("======================================");
        System.out.println(" \n");
    }

    private Fighter createFighter(int fighterNumber, String fighterName ) {

        Fighter fighter;

        System.out.println("||");
        System.out.println("||      *Création du Combattant*");
        System.out.println("|| ");

        switch(fighterNumber) {
            case 0:

                int randWeapon = (int)( Math.random()*( (weaponList.size()-1) + 1 ) );
                int randShield = (int)( Math.random()*( (shields.length-1) + 1 ) );

                fighter = new Warrior(weaponList.get(randWeapon), shields[randShield]);
                break;
            case 1:

                int randSort = (int)( Math.random()*( (sortList.size()-1) + 1 ) );
                int randPhilter = (int)( Math.random()*( (philters.length-1) + 1 ) );
                fighter = new Wizard(sortList.get(randSort), philters[randPhilter]);
                break;
            default:
                fighter = null;
        }

        fighter.setName(fighterName);
        fighter.setType(fighters[fighterNumber]);
        fighter.setLife((int)( Math.random()*( fighter.maxLife - fighter.minLife + 1 ) ) + fighter.minLife);
        fighter.setPower((int)( Math.random()*( fighter.maxPower - fighter.minPower + 1 ) ) + fighter.minPower);

        return fighter;
    }


    private void initOpponents(){
        System.out.println("=======================================================================");
        System.out.println("||                      Nombre d'adversaire ?                        ||");
        System.out.println("||");

        int nbOpponents = Integer.parseInt(sc.nextLine());
        int randType;

        for(int i= 0 ; i < nbOpponents; i++){
            randType = (int)( Math.random()*( (fighters.length-1) + 1 ) );
            fightersList.get("opponents").add(createFighter(randType, opponentsNames[i]));
        }
        System.out.println("|| " + nbOpponents + " adversaires créés");
        System.out.println("=======================================================================");
        System.out.println(" \n");
    }


    private void displayFightersList(String team){
        System.out.println("=======================================================================");
        System.out.println("||                          ATTRIBUTS                                ||");
        System.out.println("||");
        for (Fighter fighter : fightersList.get(team)){
            System.out.println("Nom : " + fighter.getName());
            System.out.println("Type : " + fighter.getType());
            System.out.println("Vie : " + fighter.getLife());
            System.out.println("Force : " + fighter.getPower());
            System.out.println("Arme : " + fighter.getStuff().getName() + " - " + fighter.getStuff().getAttack());

            String secondaryP1 =fighter.getType() == fighters[0] ? "Bouclier : " : "Philtre : ";
            String secondaryP2=fighter.getSecondary();

            System.out.println(secondaryP1 + secondaryP2);
            System.out.println("-----------------------------------------------------------------------");
        }
        System.out.println("=======================================================================");
        System.out.println(" \n");

    }

    private void editFighter(String team) {
        System.out.println("=======================================================================");
        System.out.println("||                          EDITER UN JOUEUR                         ||");
        System.out.println("||");
        System.out.println("|| Quel adverssaire voulez-vous modifier :");
        int index = 0;
        for (Fighter player : fightersList.get(team)){
            System.out.println("[" + (index+1) + "]" + player.getName());
            index++;
        }
        int selectedPlayer = (Integer.parseInt(sc.nextLine())-1);
        editInfos(playerList.get(selectedPlayer));
    }


    private void editInfos(Fighter caracter){
        System.out.println("=======================================================================");
        System.out.println("||                              ATTRIBUTS                             ||");
        System.out.println("||");
        System.out.println("|| Le combattant s'appel " + caracter.getName() + ".");
        System.out.println("||**** Renseigner son nouveau nom :");

        caracter.setName(sc.nextLine());
        System.out.println("||");

        System.out.println("||" + caracter.getName() + " a " + caracter.getLife() + " points de Vie.");
        System.out.println("||**** Renseigner ses points de Vie :");

        caracter.setLife(sc.nextInt());
        sc.nextLine();
        System.out.println("||");

        System.out.println("||" + caracter.getName() + " a " + caracter.getPower() + " points de Force.");
        System.out.println("||**** Renseigner enfin ses points de Force :");

        caracter.setPower(sc.nextInt());
        sc.nextLine();
        System.out.println("||");

        System.out.println("||");
        System.out.println(".......................................................................");
        System.out.println("||            EQUIPEMENTS           ||");
        System.out.println("||");

        System.out.println("|| Arme de " + caracter.getName() + " : " + caracter.getStuff().getName());
        System.out.println("||**** Quelle arme souhaitez-vous lui équiper ?");
        System.out.println("||");

        for (int i = 0; i < stuffList.get(caracter.getType()).size(); i++) {
            System.out.println("||     [" + (i + 1) + "] " + stuffList.get(caracter.getType()).get(i).getName());
        }

        caracter.setStuff(weaponList.get(sc.nextInt() - 1));
        sc.nextLine();

        String secondaryP1 = caracter.getType() == fighters[0] ? "|| Bouclier de " : "|| Philtre de ";
        String secondaryP2 = caracter.getName() + " : " + caracter.getSecondary();
        System.out.println(secondaryP1 + secondaryP2);

        System.out.println("||**** Quelle équipement secondaire souhaitez-vous lui équiper ?");
        System.out.println("||");
        for (int i = 0; i < secondaryList.get(caracter.getType()).length; i++) {
            System.out.println("||     [" + (i + 1) + "] " + secondaryList.get(caracter.getType())[i]);
        }

        caracter.setSecondary(secondaryList.get(caracter.getType())[sc.nextInt() - 1]);
        sc.nextLine();

        System.out.println("||");
        System.out.println("||   * Mise à jour du Combattant *");
        System.out.println("=======================================================================");
        System.out.println(" \n");
    }

    private void initWeapons(){

        for(String weaponName : weapons){
            int weaponPower = ((int)( Math.random()*( 10 - 3 + 1 ) ) + 3);
            weaponList.add(new Weapon(weaponName, weaponPower));
        }

    }

    private void initSorts(){

        for(String sortName : sorts){
            int sortPower = (int)(( Math.random()*( 8 - 5 + 1 ) )+ 5);
            sortList.add(new Sort(sortName, sortPower));
        }
    }

}
