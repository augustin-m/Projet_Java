//package myjavaproject;

import Display.barmanXcuisinier;
import Display.manager;
import Display.serveur;
import management.TicketDeCaisse;

import java.io.IOException;
import java.util.Scanner;

public class Affichage {    // Classe permettant de gérer les différents cas en fonction de l'écran que l'on souhaite afficher
    public static void print(int n) throws IOException {
        if(n == 1){     // n vaut 1 donc on affiche l'écran du serveur
            serveur disp = new serveur();
            serveur.printMenu();
        }
        else if(n == 2){    // n vaut 2 donc on affiche l'écran du barman/cuisinier
            barmanXcuisinier disp1 = new barmanXcuisinier();
            disp1.print();
        }
        else if(n == 3){    // n vaut 3 donc on affiche l'écran du manager
            manager disp2 = new manager();
            disp2.print();
        }
        else if(n == 4){    // n vaut 4 donc on affiche l'écran du paiment (permettant d'avoir un ticket de caisse)
            System.out.println("Pour quel table voulez vous imprimmer le ticket de caisse ?");  // choix de la table associée au ticket
            Scanner scanner = new Scanner(System.in);   // scanner pour récupérer le numéro de la table
            int choixTable = scanner.nextInt();     // on lie la variable "choixTable" au scanner déjà initialisé
            TicketDeCaisse ticket = new TicketDeCaisse();   // initialisation du ticket
            ticket.imprimerTicket(choixTable);  // impression du ticket
        }
        else{   // n différent de 1,2,3 ou 4 donc on affiche un message d'erreur
            System.out.println("Nombre saisi incorrect");
        }
    }

}
