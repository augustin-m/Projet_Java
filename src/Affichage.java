//package myjavaproject;

import Display.barmanXcuisinier;
import Display.manager;
import Display.serveur;
import java.io.IOException;

public class Affichage {
    public static void print(int n) throws IOException {
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
            manager disp2 = new manager();
            disp2.print();
        }
        else{
            System.out.println("Nombre saisi incorrect");
        }
    }

}
