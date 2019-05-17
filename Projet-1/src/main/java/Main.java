package main.java;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Main {

    private static Scanner sc = new Scanner(System.in);
    private static final String[] fighters = {"Warrior", "Wizard"};
    private static final String[] options = {"Afficher les infos du personnage", "Modifier les infos du personnage", "Commbattre !"};

    private static final String[] weapons = {"Hache de bucheron", "Tournevis bélliqueux"};
    private static final String[] shields = {"Casque en mousse", "Plastron MDF"};


    private static final String[] sorts = {"Etincelle du marchand", "Souffle fétide"};
    private static final String[] philters = {"Potion de soin min", "Plume de Phoenix"};

    /*private int weaponNumber = (int)( Math.random()*( (weapons.length-1) + 1 ) );
    private int shieldNumber = (int)( Math.random()*( (shields.length-1) + 1 ) );

    private Weapon weapon = new Weapon (weapons[weaponNumber], 2);
    private String shield = shields[shieldNumber];*/

    private static List<Weapon> weaponList;
    private static List<Sort> sortList;


    public static void main(String[] args) {

        weaponList = initWeapons();
        //System.out.println(weaponList);

        sortList = initSorts();

        printTitle();


        System.out.println("|| Renseigner le nom de votre combattant ||");
        String fighterName = sc.nextLine();
        System.out.println(" ");

        Fighter fighter = null;
        while (fighter == null) {
            int selectedFighter = askFighter()-1;
            System.out.println("Vous avez sélectionné : " + fighters[selectedFighter]);
            System.out.println(" ");
            fighter = createFighter(selectedFighter);
        }

        fillFighter(fighter, fighterName);




        showOptions(fighter);



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

    private static int askFighter() {


        System.out.println("======================================");
        System.out.println("||      Selection du combattant     ||");
        System.out.println("||      --> Entrez un numéro : ");
        System.out.println("||        [1] " + fighters[0]);
        System.out.println("||        [2] " + fighters[1]);
        System.out.println("======================================");
        System.out.println(" \n");

        return sc.nextInt();
    }

    private static int askOptionsFighter() {
        System.out.println("======================================");
        System.out.println("||      Que souhaitez-vous faire ?  ||");
        System.out.println("||      --> Entrer un numéro : ");
        System.out.println("||      [1] " + options[0]);
        System.out.println("||      [2] " + options[1]);
        System.out.println("||      [3] " + options[2]);
        System.out.println("======================================");
        System.out.println(" \n");

        return sc.nextInt();

    }


    private static Fighter createFighter(int fighterNumber) {

        Fighter fighter;
        switch(fighterNumber) {
            case 0:
                System.out.println("======================================");
                System.out.println("||      Armes disponibles :         ||");
                for(Weapon weapon : weaponList) {
                    System.out.println("||      # " + weapon.getName() + " - " + weapon.getAttack() + " points d'attaque");
                }
                System.out.println("||");
                System.out.println("||      *Création du Combattant*");
                System.out.println("======================================");
                int randWeapon = (int)( Math.random()*( (weaponList.size()-1) + 1 ) );
                fighter = new Warrior(weaponList.get(randWeapon));
                break;
            case 1:
                System.out.println("======================================");
                System.out.println("Sorts disponibles : ");
                for(Sort sort : sortList) {
                    System.out.println("||      # " + sort.getName() + " - " + sort.getAttack() + " points d'attaque");
                }
                System.out.println("||");
                System.out.println("|| *Création du Combattant*");
                System.out.println("======================================");
                int randSort = (int)( Math.random()*( (sortList.size()-1) + 1 ) );
                fighter = new Wizard(sortList.get(randSort));
                break;
            default:
                fighter = null;
       }
       return fighter;

    }

    private static void fillFighter(Fighter fighter, String fighterName) {
        fighter.setName(fighterName);
        fighter.setLife((int)( Math.random()*( fighter.maxLife - fighter.minLife + 1 ) ) + fighter.minLife);
        fighter.setPower((int)( Math.random()*( fighter.maxPower - fighter.minPower + 1 ) ) + fighter.minPower);
        //fighter();

    }

    private static void showOptions(Fighter fighter){
        boolean goFighting = false;
        while(!goFighting) {
            int selectedOption = askOptionsFighter();

            switch(selectedOption) {
                case 1:
                    fighter.displayInfos();
                    break;
                case 2:
                    fighter.editInfos(weaponList, sortList);
                    break;
                case 3:
                    goFighting = true;
                    // fight();
                    break;
            }
        }
    }

    private static List initWeapons(){

        List<Stuff> weaponList = new ArrayList<>();
        for(String value : weapons){
            int weaponPower = ((int)( Math.random()*( 10 - 3 + 1 ) ) + 3);
            weaponList.add(new Weapon(value, weaponPower));
        }
        return weaponList;

    }

    private static List initSorts(){

        List<Weapon> sortList = new ArrayList<>();
        for(String value : sorts){
            int sortPower = (int)(( Math.random()*( 8 - 5 + 1 ) )+ 5);
            sortList.add(new Weapon(value, sortPower));
        }
        return sortList;

    }

}
