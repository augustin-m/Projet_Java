import management.Serveur;

import java.util.*;


public class App {
    private static void menu() {
        System.out.println("Quel écran souhaitez vous afficher?");
        System.out.println("1- Ecran prise de commande");
        System.out.println("2- Ecran cuisine ou de bar");
        System.out.println("3- Ecran manager");
        Scanner scanner = new Scanner(System.in);
        int choixEcran = scanner.nextInt();
        Affichage Display1 = new Affichage();
        Display1.print(choixEcran);
        menu();
    }

    public static void main(String[] args){
        menu();
    }

}
