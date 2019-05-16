package main.java;



public class DoMoves {






    //Constantes
    //int nbCar = 250;
    private int capaCam1 = 5;
    private int capaCam2 = 7;
    private int capaCam3 = 9;
    private int nbMove = 0;
    private int a;
    private int c;


    int DoMove(String cart) {

        int nbCar = Integer.parseInt(cart);
        //Boucle du déménagement : "Tant qu'il reste des cartons"
        while (nbCar > 0) {
            a = nbCar;
            {
                nbCar = movCar(nbCar, capaCam1);
            }
            if (nbCar > 0) {
                nbCar = movCar(nbCar, capaCam2);
            }
            if (nbCar > 0) {
                nbCar = movCar(nbCar, capaCam3);
            }
            c = nbCar;

           System.out.println("voyage " + nbMove + " de " + (a - c) + " cartons");
            nbMove++;
        }

        //Récap du déménagement
        System.out.print("--------------------------------------\n");
        return nbMove;
    }

    //Fonction de calcul du trajet
    private int movCar(int nbCar, int capaCam) {
        if (nbCar >= capaCam) {
            return nbCar - capaCam;
        } else {
            return 0;
        }
    }
}
