//package myjavaproject;

import Display.barmanXcuisinier;
import Display.manager;
import Display.serveur;
import management.TicketDeCaisse;

import java.io.IOException;
import java.util.Scanner;

public class Affichage {
    public static void print(int n) throws IOException {
        if(n == 1){
            serveur disp = new serveur();
            serveur.printMenu();
        }
        else if(n == 2){
            barmanXcuisinier disp1 = new barmanXcuisinier();
            disp1.print();
        }
        else if(n == 3){
            manager disp2 = new manager();
            disp2.print();
        }
        else if(n == 4){
            System.out.println("Pour quel table voulez vous imprimmer le ticket de caisse ?");
            Scanner scanner = new Scanner(System.in);
            int choixTable = scanner.nextInt();
            TicketDeCaisse ticket = new TicketDeCaisse();
            ticket.imprimerTicket(choixTable);
        }
        else{
            System.out.println("Nombre saisi incorrect");
        }
    }

}
