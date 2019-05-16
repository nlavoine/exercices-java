package main.java;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("--> Veuillez saisir le nombre de carton");
        String inputCar = sc.nextLine();
        System.out.println("Il y a " + inputCar + " cartons à déménager");

        DoMoves move = new DoMoves();

        int totalMoves = move.DoMove(inputCar);
        System.out.println("=> Nombre de voyage " + totalMoves + ".");
    }
}
