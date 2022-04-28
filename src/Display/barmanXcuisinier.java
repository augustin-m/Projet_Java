package Display;

import management.Stocks;

import java.io.IOException;
import java.util.Scanner;

public class barmanXcuisinier {
    public serveur attender;
    public int statut;
    public void print() throws IOException {
        System.out.println("Etes vous barman ou cuisinier ?");
        System.out.println("1- Barman");
        System.out.println("2- Cuisinier");
        Scanner scanner = new Scanner(System.in);
        statut = scanner.nextInt();
        gestionFile();
    }

    public void gestionFile() throws IOException {
        if(statut == 1){
            System.out.println("=========================================");
            System.out.println("            Ecran du Barman :            ");
            System.out.println("=========================================");
            System.out.println("Boissons déjà préparées :");
            for (int i = 0; i < attender.boissonsFaites.size();i++){
                System.out.println(i + " : " + attender.boissonsFaites.get(i));
            }
            System.out.println("Boissons à préparer :");
            for (int i = 0; i < attender.commandeBoissons.size();i++){
                System.out.println(i + " : " + attender.commandeBoissons.get(i));
            }
            System.out.println("Saisissez le numéro associé à la boisson préparée pour la supprimer de la file ou 999 si le service est terminé:");
            Scanner scan = new Scanner(System.in);
            int sup = scan.nextInt();
            if (sup < attender.commandeBoissons.size()){
                attender.boissonsFaites.add(attender.commandeBoissons.get(sup));
                attender.commandeBoissons.remove(sup);
                gestionFile();
            }
            else if(sup == 999) System.out.println("Fin de service");
            else gestionFile();
        }
        else if(statut == 2){
            System.out.println("===========================================");
            System.out.println("            Ecran du Cuisinier :           ");
            System.out.println("===========================================");
            System.out.println("Plats déjà préparés :");
            for (int i = 0; i < attender.platsFaits.size();i++){
                System.out.println(i + " : " + attender.platsFaits.get(i));
            }
            System.out.println("Plats à préparer :");
            for (int i = 0; i < attender.commandePlats.size();i++){
                System.out.println(i + " : " + attender.commandePlats.get(i));
            }
            System.out.println("Saisissez le numéro associé au plat préparé pour le supprimer de la file ou 999 si le service est terminé :");
            Scanner scan = new Scanner(System.in);
            int sup = scan.nextInt();
            if (sup < attender.commandePlats.size()) {
                attender.platsFaits.add(attender.commandePlats.get(sup));
                Stocks reserves = new Stocks();
                reserves.setStocks(attender.commandePlats.get(sup));
                attender.commandePlats.remove(sup);
                gestionFile();
            }
            else if(sup == 999) System.out.println("Fin de service");
            else gestionFile();
        }

    }
}
