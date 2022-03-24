//package myjavaproject;

import Display.barmanXcuisinier;
import Display.serveur;

public class Affichage {
    public static void print(int n){
        if(n == 1){
            serveur disp = new serveur();
            serveur.printMenu();
            serveur.scanCommande();
        }
        else if(n == 2){
            barmanXcuisinier disp1 = new barmanXcuisinier();
            disp1.print();
        }
        else if(n == 3){
            System.out.println("Ecran Monitoring");
        }
        else{
            System.out.println("Nombre saisi incorrect");
        }
    }

}
