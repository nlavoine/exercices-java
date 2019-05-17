package main.java;
import java.io.FileReader;
import java.util.Scanner;

public class Main {

    private static Scanner sc = new Scanner(System.in);
    private static final String[] fighters = {"Guerrier", "Magicien"};
    private static final String[] options = {"Afficher les infos du personnage", "Modifier les infos du personnage", "Commbattre !"};



    public static void main(String[] args) {


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


        System.out.println("---------------------------------------");
        System.out.println("|| Selection du combattant ||");
        System.out.println("--> Entrez un numéro : ");
        System.out.println("    [1] " + fighters[0]);
        System.out.println("    [2] " + fighters[1]);
        System.out.println(" ");

        return sc.nextInt();
    }

    private static int askOptionsFighter() {
        System.out.println("---------------------------------------");
        System.out.println("|| Que souhaitez-vous faire ? ||");
        System.out.println("--> Entrer un numéro : ");
        System.out.println("    [1] " + options[0]);
        System.out.println("    [2] " + options[1]);
        System.out.println("    [3] " + options[2]);
        System.out.println(" ");

        return sc.nextInt();

    }


    private static Fighter createFighter(int fighterNumber) {

        Fighter fighter;
        switch(fighterNumber) {
            case 0:
                fighter = new Guerrier();
                break;
            case 1:
                fighter = new Magicien();
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
                    fighter.editInfos();
                    break;
                case 3:
                    goFighting = true;
                    // fight();
                    break;
            }
        }
    }

}
