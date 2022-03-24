//package myjavaproject;

import Display.barmanXcuisinier;

public class Affichage {
    public static void print(int n){
        if(n == 1) System.out.println("Ecran prise de commande");
        else if(n == 2){
            barmanXcuisinier disp = new barmanXcuisinier();
            disp.print();
        }
        else if(n == 3) System.out.println("Ecran Monitoring");
        else System.out.println("Nombre saisi incorrect");
    }

}
