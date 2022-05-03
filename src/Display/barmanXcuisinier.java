package Display;

import management.Stocks;

import java.io.IOException;
import java.util.Scanner;

public class barmanXcuisinier {     // classe permettant de gérer l'affichage de l'écran barman/cuisinier
    public serveur attender;
    public int statut;
    public void print() throws IOException {    // fonction qui affiche l'écran souhaité (barman ou cuisinier) grâce à un scanner
        System.out.println("Etes vous barman ou cuisinier ?");
        System.out.println("1- Barman");
        System.out.println("2- Cuisinier");
        Scanner scanner = new Scanner(System.in);
        statut = scanner.nextInt();
        gestionFile();
    }

    public void gestionFile() throws IOException {  // fonction qui affiche l'écran souhaité
        if(statut == 1){    // statut vaut 1, on affiche donc l'écran du barman
            System.out.println("=========================================");
            System.out.println("            Ecran du Barman :            ");
            System.out.println("=========================================");
            System.out.println("Boissons déjà préparées :");
            for (int i = 0; i < attender.boissonsFaites.size();i++){    // affichage des boissons déjà préparées
                System.out.println(i + " : " + attender.boissonsFaites.get(i));
            }
            System.out.println("Boissons à préparer :");
            for (int i = 0; i < attender.commandeBoissons.size();i++){  // affichage des boissons à préparer
                System.out.println(i + " : " + attender.commandeBoissons.get(i));
            }
            System.out.println("Saisissez le numéro associé à la boisson préparée pour la supprimer de la file ou 999 si le service est terminé:");
            Scanner scan = new Scanner(System.in);  // scanner permettant d'enregistrer l'indice de la boisson venant d'être finie
            int sup = scan.nextInt();
            if (sup < attender.commandeBoissons.size()){    // si l'indice est compris dans la liste des boissons à préparer, on le supprime de celle-ci
                attender.boissonsFaites.add(attender.commandeBoissons.get(sup));
                attender.commandeBoissons.remove(sup);
                gestionFile();
            }
            else if(sup == 999) System.out.println("Fin de service");   // si l'indice vaut 999, le service est terminé, on revient donc à l'écran d'accueil
            else gestionFile();     // sinon => actualisation
        }
        else if(statut == 2){   // statut vaut 2, on affiche donc l'écran du cuisinier
            System.out.println("===========================================");
            System.out.println("            Ecran du Cuisinier :           ");
            System.out.println("===========================================");
            System.out.println("Plats déjà préparés :");
            for (int i = 0; i < attender.platsFaits.size();i++){    // affichage des plats déjà préparés
                System.out.println(i + " : " + attender.platsFaits.get(i));
            }
            System.out.println("Plats à préparer :");       // affichage des plats à préparer
            for (int i = 0; i < attender.commandePlats.size();i++){
                System.out.println(i + " : " + attender.commandePlats.get(i));
            }
            System.out.println("Saisissez le numéro associé au plat préparé pour le supprimer de la file ou 999 si le service est terminé :");
            Scanner scan = new Scanner(System.in);      // scanner permettant d'enregistrer l'indice du plat venant d'être fini
            int sup = scan.nextInt();
            if (sup < attender.commandePlats.size()) {       // si l'indice est compris dans la liste des plats à préparer, on le supprime de celle-ci
                attender.platsFaits.add(attender.commandePlats.get(sup));
                Stocks reserves = new Stocks();
                reserves.setStocks(attender.commandePlats.get(sup));
                attender.commandePlats.remove(sup);
                gestionFile();
            }
            else if(sup == 999) System.out.println("Fin de service");   // si l'indice vaut 999, le service est terminé, on revient donc à l'écran d'accueil
            else gestionFile();     // sinon => actualisation
        }

    }
}