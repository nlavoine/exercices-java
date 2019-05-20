package main.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {

    private static Scanner sc = new Scanner(System.in);
    private static final String[] fighters = {"Warrior", "Wizard"};
    private static final String[] options = {"Afficher les infos des joueurs", "Modifier les infos du personnage","Afficher les infos des adversaires", "Modifier les infos des adversaires", "Combattre !"};

    private static final String[] weapons = {"Hache de bucheron", "Tournevis bélliqueux"};
    private static final String[] shields = {"Casque en mousse", "Plastron MDF"};


    private static final String[] sorts = {"Etincelle du marchand", "Souffle fétide"};
    private static final String[] philters = {"Potion de soin min", "Plume de Phoenix"};

    private static final String[] opponentsNames = {"Beus","Dorusmoricu","Eodi","Falem","Hipo","Hontrote","Iaxenteran","Kroneul","Krseta","Krus","Leulaeagore","Lionusury","Maise","Mpynasytei","Thaeg","Tussiare","Visiteres","Visust","Viusopel","Xemel"};


    private static List<Weapon> weaponList = new ArrayList<>();
    private static List<Sort> sortList = new ArrayList<>();
    private static List<Fighter> playerList = new ArrayList<>();
    private static List<Fighter> opponentList = new ArrayList<>();




    Game() {

        initWeapons();

        initSorts();

        printTitle();

        /*System.out.println("|| Renseigner le nom de votre combattant ||");
        String fighterName = sc.nextLine();
        System.out.println(" ");*/

        /*Fighter fighter = null;
        //Fighter opponent = null;
        while (fighter == null) {
            int selectedFighter = askFighter()-1;
            System.out.println("Vous avez sélectionné : " + fighters[selectedFighter]);
            System.out.println(" ");
            fighter = createFighter(selectedFighter);
        }*/

        initPlayers();
        initOpponents();
        showOptions();

        //fillFighter(fighter, fighterName);


        //showOptions(fighter);



    }

    private static void printTitle() {

        System.out.println("  ██▄     ▄      ▄     ▄▀  ▄███▄   ████▄    ▄           ██▄   █▄▄▄▄ ██     ▄▀  ████▄    ▄ ");
        System.out.println("  █  █     █      █  ▄▀    █▀   ▀  █   █     █          █  █  █  ▄▀ █ █  ▄▀    █   █     █ ");
        System.out.println("  █   █ █   █ ██   █ █ ▀▄  ██▄▄    █   █ ██   █         █   █ █▀▀▌  █▄▄█ █ ▀▄  █   █ ██   █ ");
        System.out.println("  █  █  █   █ █ █  █ █   █ █▄   ▄▀ ▀████ █ █  █         █  █  █  █  █  █ █   █ ▀████ █ █  █ ");
        System.out.println("  ███▀  █▄ ▄█ █  █ █  ███  ▀███▀         █  █ █    &    ███▀    █      █  ███        █  █ █ ");
        System.out.println("         ▀▀▀  █   ██                     █   ██                ▀      █              █   ██ ");
        System.out.println("                                                                     ▀ ");

    }

    /*private static int askFighter() {


        System.out.println("======================================");
        System.out.println("||      Selection du combattant     ||");
        System.out.println("||      --> Entrez un numéro : ");
        System.out.println("||        [1] " + fighters[0]);
        System.out.println("||        [2] " + fighters[1]);
        System.out.println("======================================");
        System.out.println(" \n");

        int userChoice = sc.nextInt();
        sc.nextLine();
        return userChoice;

    }*/

    private static int askOptionsFighter() {
        System.out.println("======================================");
        System.out.println("||      Que souhaitez-vous faire ?  ||");
        System.out.println("||      --> Entrer un numéro : ");
        int i = 0;
        for(String option : options){
            System.out.println("||      ["+(i+1)+"] " + options[i]);
            i++;
        }
        System.out.println("======================================");
        System.out.println(" \n");

        int userChoice = sc.nextInt();
        sc.nextLine();
        return userChoice;

    }

    private void showOptions(){
        boolean goFighting = false;
        while(!goFighting) {
            int selectedOption = askOptionsFighter();

            switch(selectedOption) {
                case 1:
                    displayPlayerList();
                    break;
                case 2:
                    editPlayer();
                    break;
                case 3:
                    displayOpponentsList();
                    break;
                case 4:
                    editOpponent();
                    break;
                case 5:
                    goFighting = true;
                    //fight(fighter, opponent);
                    break;
            }
        }
    }

    private void initPlayers(){
        System.out.println("======================================");
        System.out.println("||        Nombre de joueurs ?       ||");
        System.out.println("======================================");

        int nbPlayers = sc.nextInt();
        sc.nextLine();



        for(int i= 0 ; i < nbPlayers; i++){

            System.out.println("|| Renseigner le nom du combattant " + (i+1) + " ||");
            String fighterName = sc.nextLine();
            System.out.println("||");

            System.out.println("||      Selection du type     ");
            System.out.println("||        [1] " + fighters[0]);
            System.out.println("||        [2] " + fighters[1]);

            int fighterType = sc.nextInt()-1;
            sc.nextLine();

            playerList.add(createFighter(fighterType, fighterName));
        }
        System.out.println("======================================");
    }

    private Fighter createFighter(int fighterNumber, String fighterName) {

        Fighter fighter;
        switch(fighterNumber) {
            case 0:
                //System.out.println("======================================");
                System.out.println("||      Armes disponibles :         ||");
                for(Weapon weapon : weaponList) {
                    System.out.println("||      # " + weapon.getName() + " - " + weapon.getAttack() + " points d'attaque");
                }
                System.out.println("||");
                System.out.println("||      *Création du Combattant*");
                //System.out.println("======================================");
                int randWeapon = (int)( Math.random()*( (weaponList.size()-1) + 1 ) );
                fighter = new Warrior(weaponList.get(randWeapon));
                break;
            case 1:
                //System.out.println("======================================");
                System.out.println("|| Sorts disponibles : ");
                for(Sort sort : sortList) {
                    System.out.println("||      # " + sort.getName() + " - " + sort.getAttack() + " points d'attaque");
                }
                System.out.println("||");
                System.out.println("|| *Création du Combattant*");
                System.out.println("|| ");
                //System.out.println("======================================");
                int randSort = (int)( Math.random()*( (sortList.size()-1) + 1 ) );
                fighter = new Wizard(sortList.get(randSort));
                break;
            default:
                fighter = null;
        }

        fighter.setName(fighterName);
        fighter.setLife((int)( Math.random()*( fighter.maxLife - fighter.minLife + 1 ) ) + fighter.minLife);
        fighter.setPower((int)( Math.random()*( fighter.maxPower - fighter.minPower + 1 ) ) + fighter.minPower);

        return fighter;
    }


    private void displayPlayerList(){
        System.out.println("======================================");
        System.out.println("||            ATTRIBUTS             ||");
        System.out.println("||");
        for (Fighter player : playerList){
            System.out.println("Nom : " + player.getName());
            System.out.println("Vie : " + player.getLife());
            System.out.println("Force : " + player.getPower());
            System.out.println("Arme : " + player.getStuff().getName() + " - " + player.getStuff().getAttack());
            System.out.println("--------------------------------");
        }
        System.out.println("======================================");
        System.out.println(" \n");

    }

    private void editPlayer() {
        System.out.println("======================================");
        System.out.println("||          EDITER UN JOUEUR        ||");
        System.out.println("||");
        System.out.println("|| Quel adverssaire voulez-vous modifier :");
        int index = 0;
        for (Fighter player : playerList){
            System.out.println("[" + (index+1) + "]" + player.getName());
            index++;
        }
        int selectedPlayer = (sc.nextInt()-1);
        sc.nextLine();
        editInfos(playerList.get(selectedPlayer));

    }


    private void initOpponents(){
        System.out.println("======================================");
        System.out.println("||      Nombre d'adversaire ?       ||");
        System.out.println("======================================");


        //String nbInput = sc.nextLine();
        int nbOpponents = sc.nextInt();
        sc.nextLine();

        for(int i= 0 ; i < nbOpponents; i++){
            opponentList.add(createOpponent(opponentsNames[i]));
        }
    }

    private Fighter createOpponent(String opponentName){
        //System.out.println("======================================");
        //System.out.println("||     CREATION D'UN ADVERSAIRE     ||");
        //System.out.println("||");



        int randType = (int)( Math.random()*( (fighters.length-1) + 1 ) );
        String opponentType = fighters[randType];
        //System.out.println("||       Classe du combatant : " + opponentType );

        Fighter opponent;
        switch (randType){
            case 0 :
                int randWeapon = (int)( Math.random()*( (weaponList.size()-1) + 1 ) );
                opponent = new Warrior(weaponList.get(randWeapon));

                break;

            case 1:
                int randSort = (int)( Math.random()*( (sortList.size()-1) + 1 ) );
                opponent = new Wizard(sortList.get(randSort));
                break;
            default:
                opponent = null;
                break;
        }

        opponent.setName(opponentName);
        opponent.setLife((int)( Math.random()*( opponent.maxLife - opponent.minLife + 1 ) ) + opponent.minLife);
        opponent.setPower((int)( Math.random()*( opponent.maxPower - opponent.minPower + 1 ) ) + opponent.minPower);

        //System.out.println("||      *Création de l'adversaire*");
        //System.out.println("======================================");
        System.out.println(" ");
        return opponent;
    }



    private void displayOpponentsList(){
        System.out.println("======================================");
        System.out.println("||            ATTRIBUTS             ||");
        System.out.println("||");
        for (Fighter opponent : opponentList){
            System.out.println("Nom : " + opponent.getName());
            System.out.println("Vie : " + opponent.getLife());
            System.out.println("Force : " + opponent.getPower());
            System.out.println("Arme : " + opponent.getStuff().getName() + " - " + opponent.getStuff().getAttack());
            System.out.println("--------------------------------");
        }
        System.out.println("======================================");
        System.out.println(" \n");

    }

    private void editOpponent() {
        System.out.println("======================================");
        System.out.println("||       EDITER UN ADVERSAIRE        ||");
        System.out.println("||");
        System.out.println("|| Quel adverssaire voulez-vous modifier :");
        int index = 0;
        for (Fighter opponent : opponentList){
            System.out.println("[" + (index+1) + "]" + opponent.getName());
            index++;
        }
        int selectedOpponent = (sc.nextInt()-1);
        sc.nextLine();
        editInfos(opponentList.get(selectedOpponent));

    }

    /*private static void displayInfos(Fighter caracter) {
        System.out.println(" ");
        System.out.println("########################");
        System.out.println("Nom : " + caracter.getName());
        System.out.println("Vie : " + caracter.getLife());
        System.out.println("Force : " + caracter.getPower());
        System.out.println("Arme : " + caracter.getStuff().getName() + " - " + caracter.getStuff().getAttack());
        //System.out.println("Bouclier : " + this.shield);
        System.out.println("########################");
        System.out.println(" ");
    }*/

    private static void editInfos(Fighter caracter){
        System.out.println("======================================");
        System.out.println("||            ATTRIBUTS             ||");
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
        System.out.println("......................................");
        System.out.println("||            EQUIPEMENTS           ||");
        System.out.println("||");

        System.out.println("|| Arme de " + caracter.getName() + " : " + caracter.getStuff().getName());
        System.out.println("||**** Quelle arme souhaitez-vous lui équiper ?");
        System.out.println("||");
        for (int i = 0; i < weaponList.size(); i++) {
            System.out.println("||     [" + (i + 1) + "] " + weaponList.get(i).getName());
        }

        caracter.setStuff(weaponList.get(sc.nextInt() - 1));

        System.out.println("||");
        System.out.println("||   * Mise à jour du Combattant *");
        System.out.println("======================================");
        System.out.println(" \n");
    }

    private static void initWeapons(){

        for(String weaponName : weapons){
            int weaponPower = ((int)( Math.random()*( 10 - 3 + 1 ) ) + 3);
            weaponList.add(new Weapon(weaponName, weaponPower));
        }

    }

    private static void initSorts(){

        for(String sortName : sorts){
            int sortPower = (int)(( Math.random()*( 8 - 5 + 1 ) )+ 5);
            sortList.add(new Sort(sortName, sortPower));
        }
    }

}
