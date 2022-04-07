package Display;

import java.util.Scanner;

public class barmanXcuisinier {
    public serveur attender;
    public int statut;
    public void print(){
        System.out.println("Etes vous barman ou cuisinier ?");
        System.out.println("1- Barman");
        System.out.println("2- Cuisinier");
        Scanner scanner = new Scanner(System.in);
        int choixEcran = scanner.nextInt();
        statut = choixEcran;
        gestionFile();
    }

    public void gestionFile(){
        Scanner scan = new Scanner(System.in);
        int sup = scan.nextInt();
        if(statut == 1){
            System.out.println("Ecran du Barman :");
            for (int i = 0; i < attender.commandeBoissons.size();i++){
                System.out.println(i + " : " + attender.commandeBoissons.get(i));
            }
            System.out.println("Saisissez le numéro associé à la boisson préparée pour la supprimer de la file :");
            if (sup < attender.commandeBoissons.size()){
                attender.boissonsFaites.add(attender.commandeBoissons.get(sup));
                attender.commandeBoissons.remove(sup);
                gestionFile();
            }
            else gestionFile();
        }
        else if(statut == 2){
            System.out.println("Ecran du Cuisinier :");
            for (int i = 0; i < attender.commandePlats.size();i++){
                System.out.println(i + " : " + attender.commandePlats.get(i));
            }
            System.out.println("Saisissez le numéro associé au plat préparé pour le supprimer de la file :");
            if (sup < attender.commandePlats.size()) {
                attender.platsFaits.add(attender.commandePlats.get(sup));
                attender.commandePlats.remove(sup);
                gestionFile();
            }
            else gestionFile();
        }

    }
}
