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
        this.statut = choixEcran;
        if(this.statut == 1){
            System.out.println("Ecran du Barman :");
            for (int i = 0; i < attender.commandeBoissons.size();i++){
                System.out.println(i + " : " + attender.commandeBoissons.get(i));
            }
        }
        else if(this.statut == 2){
            System.out.println("Ecran du Cuisinier :");
            for (int i = 0; i < attender.commandePlats.size();i++){
                System.out.println(i + " : " + attender.commandePlats.get(i));
            }
        }
    }
}
